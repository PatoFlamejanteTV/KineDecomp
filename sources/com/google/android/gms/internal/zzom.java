package com.google.android.gms.internal;

/* loaded from: classes.dex */
public class zzom {
    private static final ThreadLocal<String> zzark = new ThreadLocal<>();

    public static String zzB(String str, String str2) {
        if (str == null || str2 == null) {
            return str;
        }
        byte[] bArr = new byte[str.length() + str2.length()];
        System.arraycopy(str.getBytes(), 0, bArr, 0, str.length());
        System.arraycopy(str2.getBytes(), 0, bArr, str.length(), str2.length());
        return Integer.toHexString(zzmw.zza(bArr, 0, bArr.length, 0));
    }

    public static String zzcU(String str) {
        return zzsK() ? str : zzB(str, zzark.get());
    }

    public static boolean zzsK() {
        String str = zzark.get();
        return str == null || str.startsWith("com.google");
    }
}
