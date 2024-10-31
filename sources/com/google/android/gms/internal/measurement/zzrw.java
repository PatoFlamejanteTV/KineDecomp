package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.UserManager;
import android.util.Log;

/* loaded from: classes2.dex */
public class zzrw {
    private static volatile UserManager zzbqz;
    private static volatile boolean zzbra = !zztj();

    private zzrw() {
    }

    public static boolean isUserUnlocked(Context context) {
        return !zztj() || zzab(context);
    }

    @TargetApi(24)
    private static boolean zzab(Context context) {
        boolean z = zzbra;
        if (!z) {
            boolean z2 = z;
            for (int i = 1; i <= 2; i++) {
                UserManager zzac = zzac(context);
                if (zzac == null) {
                    zzbra = true;
                    return true;
                }
                try {
                    if (!zzac.isUserUnlocked() && zzac.isUserRunning(Process.myUserHandle())) {
                        z2 = false;
                        zzbra = z2;
                        break;
                    }
                    z2 = true;
                    zzbra = z2;
                    break;
                    break;
                } catch (NullPointerException e2) {
                    Log.w("DirectBootUtils", "Failed to check if user is unlocked", e2);
                    zzbqz = null;
                }
            }
            z = z2;
            if (z) {
                zzbqz = null;
            }
        }
        return z;
    }

    @TargetApi(24)
    private static UserManager zzac(Context context) {
        UserManager userManager = zzbqz;
        if (userManager == null) {
            synchronized (zzrw.class) {
                userManager = zzbqz;
                if (userManager == null) {
                    UserManager userManager2 = (UserManager) context.getSystemService(UserManager.class);
                    zzbqz = userManager2;
                    userManager = userManager2;
                }
            }
        }
        return userManager;
    }

    public static boolean zztj() {
        return Build.VERSION.SDK_INT >= 24;
    }
}
