package android.support.v4.app;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.v4.app.INotificationSideChannel;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class NotificationManagerCompat {
    public static final String ACTION_BIND_SIDE_CHANNEL = "android.support.BIND_NOTIFICATION_SIDE_CHANNEL";
    public static final String EXTRA_USE_SIDE_CHANNEL = "android.support.useSideChannel";
    public static final int IMPORTANCE_DEFAULT = 3;
    public static final int IMPORTANCE_HIGH = 4;
    public static final int IMPORTANCE_LOW = 2;
    public static final int IMPORTANCE_MAX = 5;
    public static final int IMPORTANCE_MIN = 1;
    public static final int IMPORTANCE_NONE = 0;
    public static final int IMPORTANCE_UNSPECIFIED = -1000;

    /* renamed from: b */
    private static String f995b;

    /* renamed from: e */
    private static SideChannelManager f998e;

    /* renamed from: f */
    private final Context f999f;

    /* renamed from: g */
    private final NotificationManager f1000g;

    /* renamed from: a */
    private static final Object f994a = new Object();

    /* renamed from: c */
    private static Set<String> f996c = new HashSet();

    /* renamed from: d */
    private static final Object f997d = new Object();

    /* loaded from: classes.dex */
    public static class NotifyTask implements Task {

        /* renamed from: a */
        final String f1005a;

        /* renamed from: b */
        final int f1006b;

        /* renamed from: c */
        final String f1007c;

        /* renamed from: d */
        final Notification f1008d;

        NotifyTask(String str, int i, String str2, Notification notification) {
            this.f1005a = str;
            this.f1006b = i;
            this.f1007c = str2;
            this.f1008d = notification;
        }

        @Override // android.support.v4.app.NotificationManagerCompat.Task
        public void send(INotificationSideChannel iNotificationSideChannel) throws RemoteException {
            iNotificationSideChannel.notify(this.f1005a, this.f1006b, this.f1007c, this.f1008d);
        }

        public String toString() {
            return "NotifyTask[packageName:" + this.f1005a + ", id:" + this.f1006b + ", tag:" + this.f1007c + "]";
        }
    }

    /* loaded from: classes.dex */
    private static class ServiceConnectedEvent {

        /* renamed from: a */
        final ComponentName f1009a;

        /* renamed from: b */
        final IBinder f1010b;

        ServiceConnectedEvent(ComponentName componentName, IBinder iBinder) {
            this.f1009a = componentName;
            this.f1010b = iBinder;
        }
    }

    /* loaded from: classes.dex */
    public interface Task {
        void send(INotificationSideChannel iNotificationSideChannel) throws RemoteException;
    }

    private NotificationManagerCompat(Context context) {
        this.f999f = context;
        this.f1000g = (NotificationManager) this.f999f.getSystemService("notification");
    }

    private static boolean a(Notification notification) {
        Bundle extras = NotificationCompat.getExtras(notification);
        return extras != null && extras.getBoolean(EXTRA_USE_SIDE_CHANNEL);
    }

    public static NotificationManagerCompat from(Context context) {
        return new NotificationManagerCompat(context);
    }

    public static Set<String> getEnabledListenerPackages(Context context) {
        Set<String> set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (f994a) {
            if (string != null) {
                if (!string.equals(f995b)) {
                    String[] split = string.split(":");
                    HashSet hashSet = new HashSet(split.length);
                    for (String str : split) {
                        ComponentName unflattenFromString = ComponentName.unflattenFromString(str);
                        if (unflattenFromString != null) {
                            hashSet.add(unflattenFromString.getPackageName());
                        }
                    }
                    f996c = hashSet;
                    f995b = string;
                }
            }
            set = f996c;
        }
        return set;
    }

    public boolean areNotificationsEnabled() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            return this.f1000g.areNotificationsEnabled();
        }
        if (i < 19) {
            return true;
        }
        AppOpsManager appOpsManager = (AppOpsManager) this.f999f.getSystemService("appops");
        ApplicationInfo applicationInfo = this.f999f.getApplicationInfo();
        String packageName = this.f999f.getApplicationContext().getPackageName();
        int i2 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            return ((Integer) cls.getMethod("checkOpNoThrow", Integer.TYPE, Integer.TYPE, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i2), packageName)).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }

    public void cancel(int i) {
        cancel(null, i);
    }

    public void cancelAll() {
        this.f1000g.cancelAll();
        if (Build.VERSION.SDK_INT <= 19) {
            a(new CancelTask(this.f999f.getPackageName()));
        }
    }

    public int getImportance() {
        return Build.VERSION.SDK_INT >= 24 ? this.f1000g.getImportance() : IMPORTANCE_UNSPECIFIED;
    }

    public void notify(int i, Notification notification) {
        notify(null, i, notification);
    }

    /* loaded from: classes.dex */
    public static class SideChannelManager implements Handler.Callback, ServiceConnection {

        /* renamed from: a */
        private final Context f1011a;

        /* renamed from: c */
        private final Handler f1013c;

        /* renamed from: d */
        private final Map<ComponentName, ListenerRecord> f1014d = new HashMap();

        /* renamed from: e */
        private Set<String> f1015e = new HashSet();

        /* renamed from: b */
        private final HandlerThread f1012b = new HandlerThread("NotificationManagerCompat");

        /* loaded from: classes.dex */
        public static class ListenerRecord {

            /* renamed from: a */
            final ComponentName f1016a;

            /* renamed from: c */
            INotificationSideChannel f1018c;

            /* renamed from: b */
            boolean f1017b = false;

            /* renamed from: d */
            ArrayDeque<Task> f1019d = new ArrayDeque<>();

            /* renamed from: e */
            int f1020e = 0;

            ListenerRecord(ComponentName componentName) {
                this.f1016a = componentName;
            }
        }

        SideChannelManager(Context context) {
            this.f1011a = context;
            this.f1012b.start();
            this.f1013c = new Handler(this.f1012b.getLooper(), this);
        }

        private void a(Task task) {
            a();
            for (ListenerRecord listenerRecord : this.f1014d.values()) {
                listenerRecord.f1019d.add(task);
                c(listenerRecord);
            }
        }

        private void b(ComponentName componentName) {
            ListenerRecord listenerRecord = this.f1014d.get(componentName);
            if (listenerRecord != null) {
                b(listenerRecord);
            }
        }

        private void c(ListenerRecord listenerRecord) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Processing component " + listenerRecord.f1016a + ", " + listenerRecord.f1019d.size() + " queued tasks");
            }
            if (listenerRecord.f1019d.isEmpty()) {
                return;
            }
            if (a(listenerRecord) && listenerRecord.f1018c != null) {
                while (true) {
                    Task peek = listenerRecord.f1019d.peek();
                    if (peek == null) {
                        break;
                    }
                    try {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Sending task " + peek);
                        }
                        peek.send(listenerRecord.f1018c);
                        listenerRecord.f1019d.remove();
                    } catch (DeadObjectException unused) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Remote service has died: " + listenerRecord.f1016a);
                        }
                    } catch (RemoteException e2) {
                        Log.w("NotifManCompat", "RemoteException communicating with " + listenerRecord.f1016a, e2);
                    }
                }
                if (listenerRecord.f1019d.isEmpty()) {
                    return;
                }
                d(listenerRecord);
                return;
            }
            d(listenerRecord);
        }

        private void d(ListenerRecord listenerRecord) {
            if (this.f1013c.hasMessages(3, listenerRecord.f1016a)) {
                return;
            }
            listenerRecord.f1020e++;
            int i = listenerRecord.f1020e;
            if (i > 6) {
                Log.w("NotifManCompat", "Giving up on delivering " + listenerRecord.f1019d.size() + " tasks to " + listenerRecord.f1016a + " after " + listenerRecord.f1020e + " retries");
                listenerRecord.f1019d.clear();
                return;
            }
            int i2 = (1 << (i - 1)) * 1000;
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Scheduling retry for " + i2 + " ms");
            }
            this.f1013c.sendMessageDelayed(this.f1013c.obtainMessage(3, listenerRecord.f1016a), i2);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                a((Task) message.obj);
                return true;
            }
            if (i == 1) {
                ServiceConnectedEvent serviceConnectedEvent = (ServiceConnectedEvent) message.obj;
                a(serviceConnectedEvent.f1009a, serviceConnectedEvent.f1010b);
                return true;
            }
            if (i == 2) {
                b((ComponentName) message.obj);
                return true;
            }
            if (i != 3) {
                return false;
            }
            a((ComponentName) message.obj);
            return true;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Connected to service " + componentName);
            }
            this.f1013c.obtainMessage(1, new ServiceConnectedEvent(componentName, iBinder)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service " + componentName);
            }
            this.f1013c.obtainMessage(2, componentName).sendToTarget();
        }

        public void queueTask(Task task) {
            this.f1013c.obtainMessage(0, task).sendToTarget();
        }

        private void b(ListenerRecord listenerRecord) {
            if (listenerRecord.f1017b) {
                this.f1011a.unbindService(this);
                listenerRecord.f1017b = false;
            }
            listenerRecord.f1018c = null;
        }

        private void a(ComponentName componentName, IBinder iBinder) {
            ListenerRecord listenerRecord = this.f1014d.get(componentName);
            if (listenerRecord != null) {
                listenerRecord.f1018c = INotificationSideChannel.Stub.asInterface(iBinder);
                listenerRecord.f1020e = 0;
                c(listenerRecord);
            }
        }

        private void a(ComponentName componentName) {
            ListenerRecord listenerRecord = this.f1014d.get(componentName);
            if (listenerRecord != null) {
                c(listenerRecord);
            }
        }

        private void a() {
            Set<String> enabledListenerPackages = NotificationManagerCompat.getEnabledListenerPackages(this.f1011a);
            if (enabledListenerPackages.equals(this.f1015e)) {
                return;
            }
            this.f1015e = enabledListenerPackages;
            List<ResolveInfo> queryIntentServices = this.f1011a.getPackageManager().queryIntentServices(new Intent().setAction(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL), 0);
            HashSet<ComponentName> hashSet = new HashSet();
            for (ResolveInfo resolveInfo : queryIntentServices) {
                if (enabledListenerPackages.contains(resolveInfo.serviceInfo.packageName)) {
                    ComponentName componentName = new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
                    if (resolveInfo.serviceInfo.permission != null) {
                        Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                    } else {
                        hashSet.add(componentName);
                    }
                }
            }
            for (ComponentName componentName2 : hashSet) {
                if (!this.f1014d.containsKey(componentName2)) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                    }
                    this.f1014d.put(componentName2, new ListenerRecord(componentName2));
                }
            }
            Iterator<Map.Entry<ComponentName, ListenerRecord>> it = this.f1014d.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<ComponentName, ListenerRecord> next = it.next();
                if (!hashSet.contains(next.getKey())) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Removing listener record for " + next.getKey());
                    }
                    b(next.getValue());
                    it.remove();
                }
            }
        }

        private boolean a(ListenerRecord listenerRecord) {
            if (listenerRecord.f1017b) {
                return true;
            }
            listenerRecord.f1017b = this.f1011a.bindService(new Intent(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL).setComponent(listenerRecord.f1016a), this, 33);
            if (listenerRecord.f1017b) {
                listenerRecord.f1020e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + listenerRecord.f1016a);
                this.f1011a.unbindService(this);
            }
            return listenerRecord.f1017b;
        }
    }

    public void cancel(String str, int i) {
        this.f1000g.cancel(str, i);
        if (Build.VERSION.SDK_INT <= 19) {
            a(new CancelTask(this.f999f.getPackageName(), i, str));
        }
    }

    public void notify(String str, int i, Notification notification) {
        if (a(notification)) {
            a(new NotifyTask(this.f999f.getPackageName(), i, str, notification));
            this.f1000g.cancel(str, i);
        } else {
            this.f1000g.notify(str, i, notification);
        }
    }

    private void a(Task task) {
        synchronized (f997d) {
            if (f998e == null) {
                f998e = new SideChannelManager(this.f999f.getApplicationContext());
            }
            f998e.queueTask(task);
        }
    }

    /* loaded from: classes.dex */
    public static class CancelTask implements Task {

        /* renamed from: a */
        final String f1001a;

        /* renamed from: b */
        final int f1002b;

        /* renamed from: c */
        final String f1003c;

        /* renamed from: d */
        final boolean f1004d;

        CancelTask(String str) {
            this.f1001a = str;
            this.f1002b = 0;
            this.f1003c = null;
            this.f1004d = true;
        }

        @Override // android.support.v4.app.NotificationManagerCompat.Task
        public void send(INotificationSideChannel iNotificationSideChannel) throws RemoteException {
            if (this.f1004d) {
                iNotificationSideChannel.cancelAll(this.f1001a);
            } else {
                iNotificationSideChannel.cancel(this.f1001a, this.f1002b, this.f1003c);
            }
        }

        public String toString() {
            return "CancelTask[packageName:" + this.f1001a + ", id:" + this.f1002b + ", tag:" + this.f1003c + ", all:" + this.f1004d + "]";
        }

        CancelTask(String str, int i, String str2) {
            this.f1001a = str;
            this.f1002b = i;
            this.f1003c = str2;
            this.f1004d = false;
        }
    }
}
