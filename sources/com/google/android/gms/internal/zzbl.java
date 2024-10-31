package com.google.android.gms.internal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public abstract class zzbl {
    private static MessageDigest zzso = null;
    protected Object zzpd = new Object();

    /* JADX INFO: Access modifiers changed from: protected */
    public MessageDigest zzcy() {
        MessageDigest messageDigest;
        synchronized (this.zzpd) {
            if (zzso != null) {
                messageDigest = zzso;
            } else {
                for (int i = 0; i < 2; i++) {
                    try {
                        zzso = MessageDigest.getInstance("MD5");
                    } catch (NoSuchAlgorithmException e) {
                    }
                }
                messageDigest = zzso;
            }
        }
        return messageDigest;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte[] zzz(String str);
}
