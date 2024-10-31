package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbuv implements Cloneable {
    private static final Yi zzfwm = new Yi();
    private int mSize;
    private boolean zzfwn;
    private int[] zzfwo;
    private Yi[] zzfwp;

    public zzbuv() {
        this(10);
    }

    private static int idealIntArraySize(int i) {
        int i2 = i << 2;
        int i3 = 4;
        while (true) {
            if (i3 >= 32) {
                break;
            }
            int i4 = (1 << i3) - 12;
            if (i2 <= i4) {
                i2 = i4;
                break;
            }
            i3++;
        }
        return i2 / 4;
    }

    private final int zzgh(int i) {
        int i2 = this.mSize - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            int i5 = this.zzfwo[i4];
            if (i5 < i) {
                i3 = i4 + 1;
            } else {
                if (i5 <= i) {
                    return i4;
                }
                i2 = i4 - 1;
            }
        }
        return i3 ^ (-1);
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        int i = this.mSize;
        zzbuv zzbuvVar = new zzbuv(i);
        System.arraycopy(this.zzfwo, 0, zzbuvVar.zzfwo, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            Yi[] yiArr = this.zzfwp;
            if (yiArr[i2] != null) {
                zzbuvVar.zzfwp[i2] = (Yi) yiArr[i2].clone();
            }
        }
        zzbuvVar.mSize = i;
        return zzbuvVar;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbuv)) {
            return false;
        }
        zzbuv zzbuvVar = (zzbuv) obj;
        int i = this.mSize;
        if (i != zzbuvVar.mSize) {
            return false;
        }
        int[] iArr = this.zzfwo;
        int[] iArr2 = zzbuvVar.zzfwo;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                z = true;
                break;
            }
            if (iArr[i2] != iArr2[i2]) {
                z = false;
                break;
            }
            i2++;
        }
        if (z) {
            Yi[] yiArr = this.zzfwp;
            Yi[] yiArr2 = zzbuvVar.zzfwp;
            int i3 = this.mSize;
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    z2 = true;
                    break;
                }
                if (!yiArr[i4].equals(yiArr2[i4])) {
                    z2 = false;
                    break;
                }
                i4++;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (((i * 31) + this.zzfwo[i2]) * 31) + this.zzfwp[i2].hashCode();
        }
        return i;
    }

    public final int size() {
        return this.mSize;
    }

    public final void zza(int i, Yi yi) {
        int zzgh = zzgh(i);
        if (zzgh >= 0) {
            this.zzfwp[zzgh] = yi;
            return;
        }
        int i2 = zzgh ^ (-1);
        if (i2 < this.mSize) {
            Yi[] yiArr = this.zzfwp;
            if (yiArr[i2] == zzfwm) {
                this.zzfwo[i2] = i;
                yiArr[i2] = yi;
                return;
            }
        }
        int i3 = this.mSize;
        if (i3 >= this.zzfwo.length) {
            int idealIntArraySize = idealIntArraySize(i3 + 1);
            int[] iArr = new int[idealIntArraySize];
            Yi[] yiArr2 = new Yi[idealIntArraySize];
            int[] iArr2 = this.zzfwo;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Yi[] yiArr3 = this.zzfwp;
            System.arraycopy(yiArr3, 0, yiArr2, 0, yiArr3.length);
            this.zzfwo = iArr;
            this.zzfwp = yiArr2;
        }
        int i4 = this.mSize;
        if (i4 - i2 != 0) {
            int[] iArr3 = this.zzfwo;
            int i5 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i5, i4 - i2);
            Yi[] yiArr4 = this.zzfwp;
            System.arraycopy(yiArr4, i2, yiArr4, i5, this.mSize - i2);
        }
        this.zzfwo[i2] = i;
        this.zzfwp[i2] = yi;
        this.mSize++;
    }

    public final Yi zzgf(int i) {
        int zzgh = zzgh(i);
        if (zzgh < 0) {
            return null;
        }
        Yi[] yiArr = this.zzfwp;
        if (yiArr[zzgh] == zzfwm) {
            return null;
        }
        return yiArr[zzgh];
    }

    public final Yi zzgg(int i) {
        return this.zzfwp[i];
    }

    private zzbuv(int i) {
        this.zzfwn = false;
        int idealIntArraySize = idealIntArraySize(i);
        this.zzfwo = new int[idealIntArraySize];
        this.zzfwp = new Yi[idealIntArraySize];
        this.mSize = 0;
    }
}
