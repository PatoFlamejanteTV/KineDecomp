package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzpy {
    private byte[] data;
    private int zzbhx;
    private int zzbhy = 0;
    private int zzbhz;

    public zzpy(byte[] bArr, int i, int i2) {
        this.data = bArr;
        this.zzbhx = i;
        this.zzbhz = i2;
        zzhn();
    }

    private final boolean zzbo(int i) {
        if (2 > i || i >= this.zzbhz) {
            return false;
        }
        byte[] bArr = this.data;
        return bArr[i] == 3 && bArr[i + (-2)] == 0 && bArr[i - 1] == 0;
    }

    private final int zzhm() {
        int i = 0;
        while (!zzhj()) {
            i++;
        }
        return ((1 << i) - 1) + (i > 0 ? zzbj(i) : 0);
    }

    private final void zzhn() {
        int i;
        int i2;
        int i3 = this.zzbhx;
        zzpo.checkState(i3 >= 0 && (i = this.zzbhy) >= 0 && i < 8 && (i3 < (i2 = this.zzbhz) || (i3 == i2 && i == 0)));
    }

    public final int zzbj(int i) {
        int i2;
        int i3;
        if (i == 0) {
            return 0;
        }
        int i4 = i / 8;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            int i7 = zzbo(this.zzbhx + 1) ? this.zzbhx + 2 : this.zzbhx + 1;
            int i8 = this.zzbhy;
            if (i8 != 0) {
                byte[] bArr = this.data;
                i3 = ((bArr[i7] & 255) >>> (8 - i8)) | ((bArr[this.zzbhx] & 255) << i8);
            } else {
                i3 = this.data[this.zzbhx];
            }
            i -= 8;
            i5 |= (255 & i3) << i;
            this.zzbhx = i7;
        }
        if (i > 0) {
            int i9 = this.zzbhy + i;
            byte b2 = (byte) (255 >> (8 - i));
            int i10 = zzbo(this.zzbhx + 1) ? this.zzbhx + 2 : this.zzbhx + 1;
            if (i9 > 8) {
                byte[] bArr2 = this.data;
                i2 = (b2 & (((255 & bArr2[i10]) >> (16 - i9)) | ((bArr2[this.zzbhx] & 255) << (i9 - 8)))) | i5;
                this.zzbhx = i10;
            } else {
                i2 = (b2 & ((255 & this.data[this.zzbhx]) >> (8 - i9))) | i5;
                if (i9 == 8) {
                    this.zzbhx = i10;
                }
            }
            i5 = i2;
            this.zzbhy = i9 % 8;
        }
        zzhn();
        return i5;
    }

    public final void zzbn(int i) {
        int i2 = this.zzbhx;
        this.zzbhx = (i / 8) + i2;
        this.zzbhy += i % 8;
        int i3 = this.zzbhy;
        if (i3 > 7) {
            this.zzbhx++;
            this.zzbhy = i3 - 8;
        }
        while (true) {
            i2++;
            if (i2 <= this.zzbhx) {
                if (zzbo(i2)) {
                    this.zzbhx++;
                    i2 += 2;
                }
            } else {
                zzhn();
                return;
            }
        }
    }

    public final boolean zzhj() {
        return zzbj(1) == 1;
    }

    public final int zzhk() {
        return zzhm();
    }

    public final int zzhl() {
        int zzhm = zzhm();
        return (zzhm % 2 == 0 ? -1 : 1) * ((zzhm + 1) / 2);
    }
}
