package com.google.android.gms.internal.firebase_abt;

/* loaded from: classes2.dex */
public final class zzf implements Cloneable {
    private static final a zzu = new a();
    private int mSize;
    private boolean zzv;
    private int[] zzw;
    private a[] zzx;

    public zzf() {
        this(10);
    }

    private zzf(int i) {
        this.zzv = false;
        int idealIntArraySize = idealIntArraySize(i);
        this.zzw = new int[idealIntArraySize];
        this.zzx = new a[idealIntArraySize];
        this.mSize = 0;
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

    private final int zzh(int i) {
        int i2 = this.mSize - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            int i5 = this.zzw[i4];
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
        zzf zzfVar = new zzf(i);
        System.arraycopy(this.zzw, 0, zzfVar.zzw, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            a[] aVarArr = this.zzx;
            if (aVarArr[i2] != null) {
                zzfVar.zzx[i2] = (a) aVarArr[i2].clone();
            }
        }
        zzfVar.mSize = i;
        return zzfVar;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzf)) {
            return false;
        }
        zzf zzfVar = (zzf) obj;
        int i = this.mSize;
        if (i != zzfVar.mSize) {
            return false;
        }
        int[] iArr = this.zzw;
        int[] iArr2 = zzfVar.zzw;
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
            a[] aVarArr = this.zzx;
            a[] aVarArr2 = zzfVar.zzx;
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
            i = (((i * 31) + this.zzw[i2]) * 31) + this.zzx[i2].hashCode();
        }
        return i;
    }

    public final void zza(int i, a aVar) {
        int zzh = zzh(i);
        if (zzh >= 0) {
            this.zzx[zzh] = aVar;
            return;
        }
        int i2 = zzh ^ (-1);
        if (i2 < this.mSize) {
            a[] aVarArr = this.zzx;
            if (aVarArr[i2] == zzu) {
                this.zzw[i2] = i;
                aVarArr[i2] = aVar;
                return;
            }
        }
        int i3 = this.mSize;
        if (i3 >= this.zzw.length) {
            int idealIntArraySize = idealIntArraySize(i3 + 1);
            int[] iArr = new int[idealIntArraySize];
            a[] aVarArr2 = new a[idealIntArraySize];
            int[] iArr2 = this.zzw;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            a[] aVarArr3 = this.zzx;
            System.arraycopy(aVarArr3, 0, aVarArr2, 0, aVarArr3.length);
            this.zzw = iArr;
            this.zzx = aVarArr2;
        }
        int i4 = this.mSize;
        if (i4 - i2 != 0) {
            int[] iArr3 = this.zzw;
            int i5 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i5, i4 - i2);
            a[] aVarArr4 = this.zzx;
            System.arraycopy(aVarArr4, i2, aVarArr4, i5, this.mSize - i2);
        }
        this.zzw[i2] = i;
        this.zzx[i2] = aVar;
        this.mSize++;
    }

    public final a zzg(int i) {
        int zzh = zzh(i);
        if (zzh < 0) {
            return null;
        }
        a[] aVarArr = this.zzx;
        if (aVarArr[zzh] == zzu) {
            return null;
        }
        return aVarArr[zzh];
    }
}
