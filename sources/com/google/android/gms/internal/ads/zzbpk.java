package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbpk {
    private final byte[] zzfku = new byte[256];
    private int zzfkv;
    private int zzfkw;

    public zzbpk(byte[] bArr) {
        for (int i = 0; i < 256; i++) {
            this.zzfku[i] = (byte) i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            byte[] bArr2 = this.zzfku;
            i2 = (i2 + bArr2[i3] + bArr[i3 % bArr.length]) & 255;
            byte b2 = bArr2[i3];
            bArr2[i3] = bArr2[i2];
            bArr2[i2] = b2;
        }
        this.zzfkv = 0;
        this.zzfkw = 0;
    }

    public final void zzq(byte[] bArr) {
        int i = this.zzfkv;
        int i2 = this.zzfkw;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & 255;
            byte[] bArr2 = this.zzfku;
            i2 = (i2 + bArr2[i]) & 255;
            byte b2 = bArr2[i];
            bArr2[i] = bArr2[i2];
            bArr2[i2] = b2;
            bArr[i3] = (byte) (bArr2[(bArr2[i] + bArr2[i2]) & 255] ^ bArr[i3]);
        }
        this.zzfkv = i;
        this.zzfkw = i2;
    }
}
