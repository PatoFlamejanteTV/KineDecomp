package com.google.android.gms.internal.firebase_auth;

import com.umeng.commonsdk.proguard.ap;

/* loaded from: classes2.dex */
final class Ma {
    public static void b(byte b2, char[] cArr, int i) {
        cArr[i] = (char) b2;
    }

    public static boolean d(byte b2) {
        return b2 >= 0;
    }

    public static boolean e(byte b2) {
        return b2 < -32;
    }

    public static boolean f(byte b2) {
        return b2 < -16;
    }

    private static boolean g(byte b2) {
        return b2 > -65;
    }

    public static void b(byte b2, byte b3, char[] cArr, int i) throws zzgc {
        if (b2 >= -62 && !g(b3)) {
            cArr[i] = (char) (((b2 & 31) << 6) | (b3 & 63));
            return;
        }
        throw zzgc.zzhy();
    }

    public static void b(byte b2, byte b3, byte b4, char[] cArr, int i) throws zzgc {
        if (!g(b3) && ((b2 != -32 || b3 >= -96) && ((b2 != -19 || b3 < -96) && !g(b4)))) {
            cArr[i] = (char) (((b2 & ap.m) << 12) | ((b3 & 63) << 6) | (b4 & 63));
            return;
        }
        throw zzgc.zzhy();
    }

    public static void b(byte b2, byte b3, byte b4, byte b5, char[] cArr, int i) throws zzgc {
        if (!g(b3) && (((b2 << 28) + (b3 + 112)) >> 30) == 0 && !g(b4) && !g(b5)) {
            int i2 = ((b2 & 7) << 18) | ((b3 & 63) << 12) | ((b4 & 63) << 6) | (b5 & 63);
            cArr[i] = (char) ((i2 >>> 10) + 55232);
            cArr[i + 1] = (char) ((i2 & 1023) + 56320);
            return;
        }
        throw zzgc.zzhy();
    }
}
