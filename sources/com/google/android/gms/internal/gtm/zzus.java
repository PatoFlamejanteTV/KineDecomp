package com.google.android.gms.internal.gtm;

/* loaded from: classes2.dex */
public final class zzus implements Cloneable {
    private static final Db zzbhe = new Db();
    private int mSize;
    private boolean zzbhf;
    private int[] zzbhg;
    private Db[] zzbhh;

    public zzus() {
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

    private final int zzcf(int i) {
        int i2 = this.mSize - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            int i5 = this.zzbhg[i4];
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
        zzus zzusVar = new zzus(i);
        System.arraycopy(this.zzbhg, 0, zzusVar.zzbhg, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            Db[] dbArr = this.zzbhh;
            if (dbArr[i2] != null) {
                zzusVar.zzbhh[i2] = (Db) dbArr[i2].clone();
            }
        }
        zzusVar.mSize = i;
        return zzusVar;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzus)) {
            return false;
        }
        zzus zzusVar = (zzus) obj;
        int i = this.mSize;
        if (i != zzusVar.mSize) {
            return false;
        }
        int[] iArr = this.zzbhg;
        int[] iArr2 = zzusVar.zzbhg;
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
            Db[] dbArr = this.zzbhh;
            Db[] dbArr2 = zzusVar.zzbhh;
            int i3 = this.mSize;
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    z2 = true;
                    break;
                }
                if (!dbArr[i4].equals(dbArr2[i4])) {
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
            i = (((i * 31) + this.zzbhg[i2]) * 31) + this.zzbhh[i2].hashCode();
        }
        return i;
    }

    public final boolean isEmpty() {
        return this.mSize == 0;
    }

    public final int size() {
        return this.mSize;
    }

    public final void zza(int i, Db db) {
        int zzcf = zzcf(i);
        if (zzcf >= 0) {
            this.zzbhh[zzcf] = db;
            return;
        }
        int i2 = zzcf ^ (-1);
        if (i2 < this.mSize) {
            Db[] dbArr = this.zzbhh;
            if (dbArr[i2] == zzbhe) {
                this.zzbhg[i2] = i;
                dbArr[i2] = db;
                return;
            }
        }
        int i3 = this.mSize;
        if (i3 >= this.zzbhg.length) {
            int idealIntArraySize = idealIntArraySize(i3 + 1);
            int[] iArr = new int[idealIntArraySize];
            Db[] dbArr2 = new Db[idealIntArraySize];
            int[] iArr2 = this.zzbhg;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Db[] dbArr3 = this.zzbhh;
            System.arraycopy(dbArr3, 0, dbArr2, 0, dbArr3.length);
            this.zzbhg = iArr;
            this.zzbhh = dbArr2;
        }
        int i4 = this.mSize;
        if (i4 - i2 != 0) {
            int[] iArr3 = this.zzbhg;
            int i5 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i5, i4 - i2);
            Db[] dbArr4 = this.zzbhh;
            System.arraycopy(dbArr4, i2, dbArr4, i5, this.mSize - i2);
        }
        this.zzbhg[i2] = i;
        this.zzbhh[i2] = db;
        this.mSize++;
    }

    public final Db zzcd(int i) {
        int zzcf = zzcf(i);
        if (zzcf < 0) {
            return null;
        }
        Db[] dbArr = this.zzbhh;
        if (dbArr[zzcf] == zzbhe) {
            return null;
        }
        return dbArr[zzcf];
    }

    public final Db zzce(int i) {
        return this.zzbhh[i];
    }

    private zzus(int i) {
        this.zzbhf = false;
        int idealIntArraySize = idealIntArraySize(i);
        this.zzbhg = new int[idealIntArraySize];
        this.zzbhh = new Db[idealIntArraySize];
        this.mSize = 0;
    }
}
