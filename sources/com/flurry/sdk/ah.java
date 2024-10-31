package com.flurry.sdk;

import android.telephony.TelephonyManager;
import java.util.Arrays;

/* loaded from: classes.dex */
public class ah {

    /* renamed from: a, reason: collision with root package name */
    private static final String f455a = ah.class.getSimpleName();
    private static byte[] b;

    public static byte[] a() {
        if (b != null) {
            return b;
        }
        if (ad.a().b().checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            return null;
        }
        b();
        return b;
    }

    private static void b() {
        String deviceId;
        TelephonyManager telephonyManager = (TelephonyManager) ad.a().b().getSystemService("phone");
        if (telephonyManager != null && (deviceId = telephonyManager.getDeviceId()) != null && deviceId.trim().length() > 0) {
            try {
                byte[] b2 = bb.b(deviceId);
                if (b2 != null && b2.length == 20) {
                    b = b2;
                } else {
                    as.a(6, f455a, "sha1 is not 20 bytes long: " + Arrays.toString(b2));
                }
            } catch (Exception e) {
                as.a(6, f455a, "Exception in generateHashedImei()");
            }
        }
    }
}
