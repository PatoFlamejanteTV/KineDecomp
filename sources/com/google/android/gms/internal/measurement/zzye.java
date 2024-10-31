package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzye implements Cloneable {
    private static final Gb zzcew = new Gb();
    private int mSize;
    private boolean zzcex;
    private int[] zzcey;
    private Gb[] zzcez;

    public zzye() {
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

    private final int zzcg(int i) {
        int i2 = this.mSize - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            int i5 = this.zzcey[i4];
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
        zzye zzyeVar = new zzye(i);
        System.arraycopy(this.zzcey, 0, zzyeVar.zzcey, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            Gb[] gbArr = this.zzcez;
            if (gbArr[i2] != null) {
                zzyeVar.zzcez[i2] = (Gb) gbArr[i2].clone();
            }
        }
        zzyeVar.mSize = i;
        return zzyeVar;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzye)) {
            return false;
        }
        zzye zzyeVar = (zzye) obj;
        int i = this.mSize;
        if (i != zzyeVar.mSize) {
            return false;
        }
        int[] iArr = this.zzcey;
        int[] iArr2 = zzyeVar.zzcey;
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
            Gb[] gbArr = this.zzcez;
            Gb[] gbArr2 = zzyeVar.zzcez;
            int i3 = this.mSize;
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    z2 = true;
                    break;
                }
                if (!gbArr[i4].equals(gbArr2[i4])) {
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
            i = (((i * 31) + this.zzcey[i2]) * 31) + this.zzcez[i2].hashCode();
        }
        return i;
    }

    public final boolean isEmpty() {
        return this.mSize == 0;
    }

    public final int size() {
        return this.mSize;
    }

    public final void zza(int i, Gb gb) {
        int zzcg = zzcg(i);
        if (zzcg >= 0) {
            this.zzcez[zzcg] = gb;
            return;
        }
        int i2 = zzcg ^ (-1);
        if (i2 < this.mSize) {
            Gb[] gbArr = this.zzcez;
            if (gbArr[i2] == zzcew) {
                this.zzcey[i2] = i;
                gbArr[i2] = gb;
                return;
            }
        }
        int i3 = this.mSize;
        if (i3 >= this.zzcey.length) {
            int idealIntArraySize = idealIntArraySize(i3 + 1);
            int[] iArr = new int[idealIntArraySize];
            Gb[] gbArr2 = new Gb[idealIntArraySize];
            int[] iArr2 = this.zzcey;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Gb[] gbArr3 = this.zzcez;
            System.arraycopy(gbArr3, 0, gbArr2, 0, gbArr3.length);
            this.zzcey = iArr;
            this.zzcez = gbArr2;
        }
        int i4 = this.mSize;
        if (i4 - i2 != 0) {
            int[] iArr3 = this.zzcey;
            int i5 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i5, i4 - i2);
            Gb[] gbArr4 = this.zzcez;
            System.arraycopy(gbArr4, i2, gbArr4, i5, this.mSize - i2);
        }
        this.zzcey[i2] = i;
        this.zzcez[i2] = gb;
        this.mSize++;
    }

    public final Gb zzce(int i) {
        int zzcg = zzcg(i);
        if (zzcg < 0) {
            return null;
        }
        Gb[] gbArr = this.zzcez;
        if (gbArr[zzcg] == zzcew) {
            return null;
        }
        return gbArr[zzcg];
    }

    public final Gb zzcf(int i) {
        return this.zzcez[i];
    }

    private zzye(int i) {
        this.zzcex = false;
        int idealIntArraySize = idealIntArraySize(i);
        this.zzcey = new int[idealIntArraySize];
        this.zzcez = new Gb[idealIntArraySize];
        this.mSize = 0;
    }
}
