package android.support.v4.a;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.Log;
import android.util.SparseArray;

/* compiled from: WakefulBroadcastReceiver.java */
/* loaded from: classes.dex */
public abstract class h extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private static final SparseArray<PowerManager.WakeLock> f25a = new SparseArray<>();
    private static int b = 1;

    public static ComponentName a(Context context, Intent intent) {
        synchronized (f25a) {
            int i = b;
            b++;
            if (b <= 0) {
                b = 1;
            }
            intent.putExtra("android.support.content.wakelockid", i);
            ComponentName startService = context.startService(intent);
            if (startService == null) {
                return null;
            }
            PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:" + startService.flattenToShortString());
            newWakeLock.setReferenceCounted(false);
            newWakeLock.acquire(60000L);
            f25a.put(i, newWakeLock);
            return startService;
        }
    }

    public static boolean a(Intent intent) {
        boolean z = false;
        int intExtra = intent.getIntExtra("android.support.content.wakelockid", 0);
        if (intExtra != 0) {
            synchronized (f25a) {
                PowerManager.WakeLock wakeLock = f25a.get(intExtra);
                if (wakeLock != null) {
                    wakeLock.release();
                    f25a.remove(intExtra);
                    z = true;
                } else {
                    Log.w("WakefulBroadcastReceiver", "No active wake lock id #" + intExtra);
                    z = true;
                }
            }
        }
        return z;
    }
}
