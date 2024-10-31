package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.util.SparseArray;
import com.facebook.applinks.AppLinkData;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class NotificationCompatJellybean {
    public static final String TAG = "NotificationCompat";

    /* renamed from: b */
    private static Field f986b;

    /* renamed from: c */
    private static boolean f987c;

    /* renamed from: e */
    private static Class<?> f989e;

    /* renamed from: f */
    private static Field f990f;

    /* renamed from: g */
    private static Field f991g;

    /* renamed from: h */
    private static Field f992h;
    private static Field i;
    private static boolean j;

    /* renamed from: a */
    private static final Object f985a = new Object();

    /* renamed from: d */
    private static final Object f988d = new Object();

    NotificationCompatJellybean() {
    }

    private static Object[] a(Notification notification) {
        synchronized (f988d) {
            if (!a()) {
                return null;
            }
            try {
                return (Object[]) f990f.get(notification);
            } catch (IllegalAccessException e2) {
                Log.e(TAG, "Unable to access notification actions", e2);
                j = true;
                return null;
            }
        }
    }

    private static RemoteInput b(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("allowedDataTypes");
        HashSet hashSet = new HashSet();
        if (stringArrayList != null) {
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                hashSet.add(it.next());
            }
        }
        return new RemoteInput(bundle.getString("resultKey"), bundle.getCharSequence("label"), bundle.getCharSequenceArray("choices"), bundle.getBoolean("allowFreeFormInput"), bundle.getBundle(AppLinkData.ARGUMENTS_EXTRAS_KEY), hashSet);
    }

    public static SparseArray<Bundle> buildActionExtrasMap(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i2 = 0; i2 < size; i2++) {
            Bundle bundle = list.get(i2);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i2, bundle);
            }
        }
        return sparseArray;
    }

    public static NotificationCompat.Action getAction(Notification notification, int i2) {
        SparseArray sparseParcelableArray;
        synchronized (f988d) {
            try {
                try {
                    Object[] a2 = a(notification);
                    if (a2 != null) {
                        Object obj = a2[i2];
                        Bundle extras = getExtras(notification);
                        return readAction(f991g.getInt(obj), (CharSequence) f992h.get(obj), (PendingIntent) i.get(obj), (extras == null || (sparseParcelableArray = extras.getSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS)) == null) ? null : (Bundle) sparseParcelableArray.get(i2));
                    }
                } catch (IllegalAccessException e2) {
                    Log.e(TAG, "Unable to access notification actions", e2);
                    j = true;
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static int getActionCount(Notification notification) {
        int length;
        synchronized (f988d) {
            Object[] a2 = a(notification);
            length = a2 != null ? a2.length : 0;
        }
        return length;
    }

    public static Bundle getExtras(Notification notification) {
        synchronized (f985a) {
            if (f987c) {
                return null;
            }
            try {
                if (f986b == null) {
                    Field declaredField = Notification.class.getDeclaredField(AppLinkData.ARGUMENTS_EXTRAS_KEY);
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e(TAG, "Notification.extras field is not of type Bundle");
                        f987c = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    f986b = declaredField;
                }
                Bundle bundle = (Bundle) f986b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f986b.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e2) {
                Log.e(TAG, "Unable to access notification extras", e2);
                f987c = true;
                return null;
            } catch (NoSuchFieldException e3) {
                Log.e(TAG, "Unable to access notification extras", e3);
                f987c = true;
                return null;
            }
        }
    }

    public static NotificationCompat.Action readAction(int i2, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
        RemoteInput[] remoteInputArr;
        RemoteInput[] remoteInputArr2;
        boolean z;
        if (bundle != null) {
            remoteInputArr = a(a(bundle, NotificationCompatExtras.EXTRA_REMOTE_INPUTS));
            remoteInputArr2 = a(a(bundle, "android.support.dataRemoteInputs"));
            z = bundle.getBoolean("android.support.allowGeneratedReplies");
        } else {
            remoteInputArr = null;
            remoteInputArr2 = null;
            z = false;
        }
        return new NotificationCompat.Action(i2, charSequence, pendingIntent, bundle, remoteInputArr, remoteInputArr2, z);
    }

    public static Bundle writeActionAndGetExtras(Notification.Builder builder, NotificationCompat.Action action) {
        builder.addAction(action.getIcon(), action.getTitle(), action.getActionIntent());
        Bundle bundle = new Bundle(action.getExtras());
        if (action.getRemoteInputs() != null) {
            bundle.putParcelableArray(NotificationCompatExtras.EXTRA_REMOTE_INPUTS, a(action.getRemoteInputs()));
        }
        if (action.getDataOnlyRemoteInputs() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", a(action.getDataOnlyRemoteInputs()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", action.getAllowGeneratedReplies());
        return bundle;
    }

    private static boolean a() {
        if (j) {
            return false;
        }
        try {
            if (f990f == null) {
                f989e = Class.forName("android.app.Notification$Action");
                f991g = f989e.getDeclaredField("icon");
                f992h = f989e.getDeclaredField("title");
                i = f989e.getDeclaredField("actionIntent");
                f990f = Notification.class.getDeclaredField("actions");
                f990f.setAccessible(true);
            }
        } catch (ClassNotFoundException e2) {
            Log.e(TAG, "Unable to access notification actions", e2);
            j = true;
        } catch (NoSuchFieldException e3) {
            Log.e(TAG, "Unable to access notification actions", e3);
            j = true;
        }
        return !j;
    }

    public static NotificationCompat.Action a(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(AppLinkData.ARGUMENTS_EXTRAS_KEY);
        return new NotificationCompat.Action(bundle.getInt("icon"), bundle.getCharSequence("title"), (PendingIntent) bundle.getParcelable("actionIntent"), bundle.getBundle(AppLinkData.ARGUMENTS_EXTRAS_KEY), a(a(bundle, "remoteInputs")), a(a(bundle, "dataOnlyRemoteInputs")), bundle2 != null ? bundle2.getBoolean("android.support.allowGeneratedReplies", false) : false);
    }

    public static Bundle a(NotificationCompat.Action action) {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        bundle2.putInt("icon", action.getIcon());
        bundle2.putCharSequence("title", action.getTitle());
        bundle2.putParcelable("actionIntent", action.getActionIntent());
        if (action.getExtras() != null) {
            bundle = new Bundle(action.getExtras());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", action.getAllowGeneratedReplies());
        bundle2.putBundle(AppLinkData.ARGUMENTS_EXTRAS_KEY, bundle);
        bundle2.putParcelableArray("remoteInputs", a(action.getRemoteInputs()));
        return bundle2;
    }

    private static Bundle a(RemoteInput remoteInput) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", remoteInput.getResultKey());
        bundle.putCharSequence("label", remoteInput.getLabel());
        bundle.putCharSequenceArray("choices", remoteInput.getChoices());
        bundle.putBoolean("allowFreeFormInput", remoteInput.getAllowFreeFormInput());
        bundle.putBundle(AppLinkData.ARGUMENTS_EXTRAS_KEY, remoteInput.getExtras());
        Set<String> allowedDataTypes = remoteInput.getAllowedDataTypes();
        if (allowedDataTypes != null && !allowedDataTypes.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList<>(allowedDataTypes.size());
            Iterator<String> it = allowedDataTypes.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    private static RemoteInput[] a(Bundle[] bundleArr) {
        if (bundleArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[bundleArr.length];
        for (int i2 = 0; i2 < bundleArr.length; i2++) {
            remoteInputArr[i2] = b(bundleArr[i2]);
        }
        return remoteInputArr;
    }

    private static Bundle[] a(RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[remoteInputArr.length];
        for (int i2 = 0; i2 < remoteInputArr.length; i2++) {
            bundleArr[i2] = a(remoteInputArr[i2]);
        }
        return bundleArr;
    }

    private static Bundle[] a(Bundle bundle, String str) {
        Parcelable[] parcelableArray = bundle.getParcelableArray(str);
        if (!(parcelableArray instanceof Bundle[]) && parcelableArray != null) {
            Bundle[] bundleArr = (Bundle[]) Arrays.copyOf(parcelableArray, parcelableArray.length, Bundle[].class);
            bundle.putParcelableArray(str, bundleArr);
            return bundleArr;
        }
        return (Bundle[]) parcelableArray;
    }
}
