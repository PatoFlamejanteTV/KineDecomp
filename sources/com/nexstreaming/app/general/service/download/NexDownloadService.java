package com.nexstreaming.app.general.service.download;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.support.v4.app.NotificationCompat;
import com.nexstreaming.app.general.service.download.l;
import com.nexstreaming.app.general.service.download.n;
import com.nexstreaming.app.kinemasterfree.R;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes2.dex */
public class NexDownloadService extends Service {

    /* renamed from: a */
    private static final ExecutorService f19679a = Executors.newFixedThreadPool(4);

    /* renamed from: b */
    private static final Map<String, l> f19680b = new HashMap();

    /* renamed from: c */
    private RemoteCallbackList<m> f19681c = new RemoteCallbackList<>();

    /* renamed from: d */
    private int f19682d = 0;

    /* renamed from: e */
    private NotificationManager f19683e = null;

    /* renamed from: f */
    private ArrayList<String> f19684f = new ArrayList<>();

    /* renamed from: g */
    private l.b f19685g = new q(this);

    /* renamed from: h */
    private n.a f19686h = new r(this);

    public static /* synthetic */ int c(NexDownloadService nexDownloadService) {
        int i = nexDownloadService.f19682d;
        nexDownloadService.f19682d = i - 1;
        return i;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (intent == null || intent.getAction() == null || !intent.getAction().equals("com.nexstreaming.app.download.bind")) {
            return null;
        }
        return this.f19686h;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f19683e = (NotificationManager) getSystemService("notification");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        int onStartCommand = super.onStartCommand(intent, i, i2);
        if (intent != null && intent.getAction() != null) {
            String action = intent.getAction();
            if (action.equals("com.nexstreaming.app.download.item")) {
                d(intent);
            } else if (action.equals("com.nexstreaming.app.download.clear.item")) {
                c(intent);
            } else if (action.equals("com.nexstreaming.app.cancel.download.item")) {
                b(intent);
            } else if (action.equals("com.nexstreaming.app.cancel.all.download.item")) {
                a(intent);
            }
        }
        return onStartCommand;
    }

    public static /* synthetic */ int b(NexDownloadService nexDownloadService) {
        int i = nexDownloadService.f19682d;
        nexDownloadService.f19682d = i + 1;
        return i;
    }

    private void e(k kVar) {
        new Handler(getMainLooper()).post(new p(this, kVar));
    }

    private void c(Intent intent) {
        this.f19684f.clear();
        this.f19683e.cancel(244);
    }

    private void d(Intent intent) {
        k kVar;
        if (intent == null || (kVar = (k) intent.getParcelableExtra(k.class.getName())) == null) {
            return;
        }
        d(kVar);
    }

    private void b(Intent intent) {
        k kVar;
        l lVar;
        if (intent == null || (kVar = (k) intent.getParcelableExtra(k.class.getName())) == null || (lVar = f19680b.get(kVar.c())) == null) {
            return;
        }
        lVar.cancel(true);
    }

    public int c(k kVar) {
        return (kVar == null || !kVar.h()) ? 0 : 1;
    }

    public void d(k kVar) {
        l lVar = f19680b.get(kVar.c());
        if (lVar != null && lVar.a().f19721c == 1) {
            f19680b.remove(kVar.c());
        }
        new l(kVar, this.f19685g).executeOnExecutor(f19679a, new Void[0]);
    }

    private void a(Intent intent) {
        Iterator<String> it = f19680b.keySet().iterator();
        while (it.hasNext()) {
            f19680b.get(it.next()).cancel(true);
        }
    }

    public void b(l lVar, k kVar) {
        if (kVar == null || lVar == null) {
            return;
        }
        if (lVar.a().f19721c == 16 || lVar.a().f19721c == 0) {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
            builder.setContentTitle(getString(R.string.downloading_theme_progress)).setColor(getResources().getColor(R.color.km_red)).setOngoing(true).setContentText(kVar.g()).setProgress(0, 0, true).setSmallIcon(android.R.drawable.stat_sys_download);
            this.f19683e.notify((int) kVar.a(), builder.build());
        }
    }

    public static void a(Context context, ServiceConnection serviceConnection) {
        if (context == null || serviceConnection == null) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) NexDownloadService.class);
        intent.setAction("com.nexstreaming.app.download.bind");
        context.bindService(intent, serviceConnection, 1);
    }

    public synchronized void a(k kVar, b bVar) {
        if (kVar != null && bVar != null) {
            switch (bVar.f19687a) {
                case 34:
                    if (kVar.h()) {
                        new File(kVar.c()).delete();
                        break;
                    }
                    break;
            }
            Intent intent = new Intent("com.nexstreaming.app.download.item.failed");
            intent.putExtra(kVar.getClass().getName(), kVar);
            intent.putExtra(bVar.getClass().getName(), bVar);
            sendBroadcast(intent);
            this.f19681c.beginBroadcast();
            for (int i = 0; i < b(); i++) {
                try {
                    this.f19681c.getBroadcastItem(i).a(kVar, bVar);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
            this.f19681c.finishBroadcast();
        }
    }

    public void b(k kVar, b bVar) {
        if (kVar == null || bVar == null) {
            return;
        }
        String string = getString(R.string.file_opt_add_fail_title);
        String str = kVar.g() + " - " + bVar.getLocalizedMessage(this);
        Intent intent = new Intent(this, (Class<?>) NexDownloadService.class);
        intent.setAction("com.nexstreaming.app.download.clear.item");
        PendingIntent service = PendingIntent.getService(this, 0, intent, 134217728);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle(string).setColor(getResources().getColor(R.color.km_red)).setContentText(str).setSmallIcon(R.drawable.notification_icon).setPriority(1).setContentIntent(service).setAutoCancel(true).setDeleteIntent(service);
        this.f19683e.notify((int) kVar.a(), builder.build());
    }

    public synchronized void a(k kVar) {
        Intent intent = new Intent("com.nexstreaming.app.download.item.canceled");
        intent.putExtra(kVar.getClass().getName(), kVar);
        sendBroadcast(intent);
        this.f19681c.beginBroadcast();
        for (int i = 0; i < b(); i++) {
            try {
                this.f19681c.getBroadcastItem(i).b(kVar);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
        this.f19681c.finishBroadcast();
    }

    public synchronized void b(k kVar) {
        e(kVar);
        Intent intent = new Intent("com.nexstreaming.app.download.item.completed");
        intent.putExtra(kVar.getClass().getName(), kVar);
        sendBroadcast(intent);
        if (kVar != null) {
            this.f19681c.beginBroadcast();
            for (int i = 0; i < b(); i++) {
                try {
                    this.f19681c.getBroadcastItem(i).d(kVar);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
            this.f19681c.finishBroadcast();
        }
    }

    public synchronized void a(l lVar, k kVar) {
        this.f19681c.beginBroadcast();
        for (int i = 0; i < b(); i++) {
            try {
                this.f19681c.getBroadcastItem(i).c(kVar);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
        this.f19681c.finishBroadcast();
    }

    public synchronized void a(k kVar, int i) {
        this.f19681c.beginBroadcast();
        for (int i2 = 0; i2 < b(); i2++) {
            try {
                this.f19681c.getBroadcastItem(i2).a(kVar, i);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
        this.f19681c.finishBroadcast();
    }

    private int b() {
        if (Build.VERSION.SDK_INT > 16) {
            this.f19682d = this.f19681c.getRegisteredCallbackCount();
        }
        return this.f19682d;
    }

    public static void a(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, (Class<?>) NexDownloadService.class);
            intent.setAction("com.nexstreaming.app.cancel.all.download.item");
            context.startService(intent);
        }
    }
}
