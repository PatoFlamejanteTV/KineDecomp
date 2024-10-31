package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public abstract class zztd {
    private static MessageDigest zzbyx;
    protected Object mLock = new Object();

    public abstract byte[] zzay(String str);

    public final MessageDigest zzoc() {
        synchronized (this.mLock) {
            if (zzbyx != null) {
                return zzbyx;
            }
            for (int i = 0; i < 2; i++) {
                try {
                    zzbyx = MessageDigest.getInstance("MD5");
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return zzbyx;
        }
    }
}
