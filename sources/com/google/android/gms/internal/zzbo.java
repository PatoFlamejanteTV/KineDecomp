package com.google.android.gms.internal;

import java.security.MessageDigest;

/* loaded from: classes.dex */
public class zzbo extends zzbl {
    private MessageDigest zzsw;

    byte[] zza(String[] strArr) {
        byte[] bArr = new byte[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            bArr[i] = zzj(zzbn.zzC(strArr[i]));
        }
        return bArr;
    }

    byte zzj(int i) {
        return (byte) ((((i & 255) ^ ((65280 & i) >> 8)) ^ ((16711680 & i) >> 16)) ^ (((-16777216) & i) >> 24));
    }

    @Override // com.google.android.gms.internal.zzbl
    public byte[] zzz(String str) {
        byte[] bArr;
        byte[] zza = zza(str.split(" "));
        this.zzsw = zzcy();
        synchronized (this.zzpd) {
            if (this.zzsw == null) {
                bArr = new byte[0];
            } else {
                this.zzsw.reset();
                this.zzsw.update(zza);
                byte[] digest = this.zzsw.digest();
                bArr = new byte[digest.length <= 4 ? digest.length : 4];
                System.arraycopy(digest, 0, bArr, 0, bArr.length);
            }
        }
        return bArr;
    }
}
