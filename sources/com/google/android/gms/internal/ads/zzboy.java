package com.google.android.gms.internal.ads;

import java.security.SecureRandom;

/* loaded from: classes2.dex */
public final class zzboy {
    private static final ThreadLocal<SecureRandom> zzfkf = new C0944ih();

    public static SecureRandom zzakb() {
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextLong();
        return secureRandom;
    }

    public static byte[] zzeg(int i) {
        byte[] bArr = new byte[i];
        zzfkf.get().nextBytes(bArr);
        return bArr;
    }
}
