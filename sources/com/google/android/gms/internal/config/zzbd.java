package com.google.android.gms.internal.config;

/* loaded from: classes2.dex */
public final class zzbd implements Cloneable {
    private static final a zzcj = new a();
    private int mSize;
    private boolean zzck;
    private int[] zzcl;
    private a[] zzcm;

    public zzbd() {
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

    private final int zzq(int i) {
        int i2 = this.mSize - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            int i5 = this.zzcl[i4];
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
        zzbd zzbdVar = new zzbd(i);
        System.arraycopy(this.zzcl, 0, zzbdVar.zzcl, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            a[] aVarArr = this.zzcm;
            if (aVarArr[i2] != null) {
                zzbdVar.zzcm[i2] = (a) aVarArr[i2].clone();
            }
        }
        zzbdVar.mSize = i;
        return zzbdVar;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbd)) {
            return false;
        }
        zzbd zzbdVar = (zzbd) obj;
        int i = this.mSize;
        if (i != zzbdVar.mSize) {
            return false;
        }
        int[] iArr = this.zzcl;
        int[] iArr2 = zzbdVar.zzcl;
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
            a[] aVarArr = this.zzcm;
            a[] aVarArr2 = zzbdVar.zzcm;
            int i3 = this.mSize;
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    z2 = true;
                    break;
                }
                if (!aVarArr[i4].equals(aVarArr2[i4])) {
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
            i = (((i * 31) + this.zzcl[i2]) * 31) + this.zzcm[i2].hashCode();
        }
        return i;
    }

    public final boolean isEmpty() {
        return this.mSize == 0;
    }

    public final int size() {
        return this.mSize;
    }

    public final void zza(int i, a aVar) {
        int zzq = zzq(i);
        if (zzq >= 0) {
            this.zzcm[zzq] = aVar;
            return;
        }
        int i2 = zzq ^ (-1);
        if (i2 < this.mSize) {
            a[] aVarArr = this.zzcm;
            if (aVarArr[i2] == zzcj) {
                this.zzcl[i2] = i;
                aVarArr[i2] = aVar;
                return;
            }
        }
        int i3 = this.mSize;
        if (i3 >= this.zzcl.length) {
            int idealIntArraySize = idealIntArraySize(i3 + 1);
            int[] iArr = new int[idealIntArraySize];
            a[] aVarArr2 = new a[idealIntArraySize];
            int[] iArr2 = this.zzcl;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            a[] aVarArr3 = this.zzcm;
            System.arraycopy(aVarArr3, 0, aVarArr2, 0, aVarArr3.length);
            this.zzcl = iArr;
            this.zzcm = aVarArr2;
        }
        int i4 = this.mSize;
        if (i4 - i2 != 0) {
            int[] iArr3 = this.zzcl;
            int i5 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i5, i4 - i2);
            a[] aVarArr4 = this.zzcm;
            System.arraycopy(aVarArr4, i2, aVarArr4, i5, this.mSize - i2);
        }
        this.zzcl[i2] = i;
        this.zzcm[i2] = aVar;
        this.mSize++;
    }

    public final a zzo(int i) {
        int zzq = zzq(i);
        if (zzq < 0) {
            return null;
        }
        a[] aVarArr = this.zzcm;
        if (aVarArr[zzq] == zzcj) {
            return null;
        }
        return aVarArr[zzq];
    }

    public final a zzp(int i) {
        return this.zzcm[i];
    }

    private zzbd(int i) {
        this.zzck = false;
        int idealIntArraySize = idealIntArraySize(i);
        this.zzcl = new int[idealIntArraySize];
        this.zzcm = new a[idealIntArraySize];
        this.mSize = 0;
    }
}
