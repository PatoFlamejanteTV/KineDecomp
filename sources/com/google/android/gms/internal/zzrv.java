package com.google.android.gms.internal;

/* loaded from: classes.dex */
public class zzrv {
    private final byte[] zzbhX = new byte[256];
    private int zzbhY;
    private int zzbhZ;

    public zzrv(byte[] bArr) {
        for (int i = 0; i < 256; i++) {
            this.zzbhX[i] = (byte) i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            i2 = (i2 + this.zzbhX[i3] + bArr[i3 % bArr.length]) & 255;
            byte b = this.zzbhX[i3];
            this.zzbhX[i3] = this.zzbhX[i2];
            this.zzbhX[i2] = b;
        }
        this.zzbhY = 0;
        this.zzbhZ = 0;
    }

    public void zzA(byte[] bArr) {
        int i = this.zzbhY;
        int i2 = this.zzbhZ;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & 255;
            i2 = (i2 + this.zzbhX[i]) & 255;
            byte b = this.zzbhX[i];
            this.zzbhX[i] = this.zzbhX[i2];
            this.zzbhX[i2] = b;
            bArr[i3] = (byte) (bArr[i3] ^ this.zzbhX[(this.zzbhX[i] + this.zzbhX[i2]) & 255]);
        }
        this.zzbhY = i;
        this.zzbhZ = i2;
    }
}
