package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzpw {
    private byte[] data;
    private int zzbhx;
    private int zzbhy;
    private int zzbhz;

    public zzpw() {
    }

    public final int zzbj(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z = false;
        if (i == 0) {
            return 0;
        }
        int i6 = i / 8;
        int i7 = i;
        int i8 = 0;
        for (int i9 = 0; i9 < i6; i9++) {
            int i10 = this.zzbhy;
            if (i10 != 0) {
                byte[] bArr = this.data;
                int i11 = this.zzbhx;
                i5 = ((bArr[i11 + 1] & 255) >>> (8 - i10)) | ((bArr[i11] & 255) << i10);
            } else {
                i5 = this.data[this.zzbhx];
            }
            i7 -= 8;
            i8 |= (255 & i5) << i7;
            this.zzbhx++;
        }
        if (i7 > 0) {
            int i12 = this.zzbhy + i7;
            byte b2 = (byte) (255 >> (8 - i7));
            if (i12 > 8) {
                byte[] bArr2 = this.data;
                int i13 = this.zzbhx;
                i4 = (b2 & (((bArr2[i13 + 1] & 255) >> (16 - i12)) | ((bArr2[i13] & 255) << (i12 - 8)))) | i8;
                this.zzbhx = i13 + 1;
            } else {
                byte[] bArr3 = this.data;
                int i14 = this.zzbhx;
                i4 = (b2 & ((bArr3[i14] & 255) >> (8 - i12))) | i8;
                if (i12 == 8) {
                    this.zzbhx = i14 + 1;
                }
            }
            i8 = i4;
            this.zzbhy = i12 % 8;
        }
        int i15 = this.zzbhx;
        if (i15 >= 0 && (i2 = this.zzbhy) >= 0 && i2 < 8 && (i15 < (i3 = this.zzbhz) || (i15 == i3 && i2 == 0))) {
            z = true;
        }
        zzpo.checkState(z);
        return i8;
    }

    public zzpw(byte[] bArr) {
        this(bArr, bArr.length);
    }

    private zzpw(byte[] bArr, int i) {
        this.data = bArr;
        this.zzbhz = i;
    }
}
