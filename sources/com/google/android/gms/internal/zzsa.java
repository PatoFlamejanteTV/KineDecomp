package com.google.android.gms.internal;

/* loaded from: classes.dex */
public final class zzsa implements Cloneable {
    private static final jl zzbin = new jl();
    private int mSize;
    private boolean zzbio;
    private int[] zzbip;
    private jl[] zzbiq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzsa() {
        this(10);
    }

    zzsa(int i) {
        this.zzbio = false;
        int idealIntArraySize = idealIntArraySize(i);
        this.zzbip = new int[idealIntArraySize];
        this.zzbiq = new jl[idealIntArraySize];
        this.mSize = 0;
    }

    private void gc() {
        int i = this.mSize;
        int[] iArr = this.zzbip;
        jl[] jlVarArr = this.zzbiq;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            jl jlVar = jlVarArr[i3];
            if (jlVar != zzbin) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    jlVarArr[i2] = jlVar;
                    jlVarArr[i3] = null;
                }
                i2++;
            }
        }
        this.zzbio = false;
        this.mSize = i2;
    }

    private int idealByteArraySize(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            if (i <= (1 << i2) - 12) {
                return (1 << i2) - 12;
            }
        }
        return i;
    }

    private int idealIntArraySize(int i) {
        return idealByteArraySize(i * 4) / 4;
    }

    private boolean zza(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean zza(jl[] jlVarArr, jl[] jlVarArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!jlVarArr[i2].equals(jlVarArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    private int zzlT(int i) {
        int i2 = 0;
        int i3 = this.mSize - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.zzbip[i4];
            if (i5 < i) {
                i2 = i4 + 1;
            } else {
                if (i5 <= i) {
                    return i4;
                }
                i3 = i4 - 1;
            }
        }
        return i2 ^ (-1);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzsa)) {
            return false;
        }
        zzsa zzsaVar = (zzsa) obj;
        if (size() != zzsaVar.size()) {
            return false;
        }
        return zza(this.zzbip, zzsaVar.zzbip, this.mSize) && zza(this.zzbiq, zzsaVar.zzbiq, this.mSize);
    }

    public int hashCode() {
        if (this.zzbio) {
            gc();
        }
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (((i * 31) + this.zzbip[i2]) * 31) + this.zzbiq[i2].hashCode();
        }
        return i;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int size() {
        if (this.zzbio) {
            gc();
        }
        return this.mSize;
    }

    /* renamed from: zzFH, reason: merged with bridge method [inline-methods] */
    public final zzsa clone() {
        int size = size();
        zzsa zzsaVar = new zzsa(size);
        System.arraycopy(this.zzbip, 0, zzsaVar.zzbip, 0, size);
        for (int i = 0; i < size; i++) {
            if (this.zzbiq[i] != null) {
                zzsaVar.zzbiq[i] = this.zzbiq[i].clone();
            }
        }
        zzsaVar.mSize = size;
        return zzsaVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zza(int i, jl jlVar) {
        int zzlT = zzlT(i);
        if (zzlT >= 0) {
            this.zzbiq[zzlT] = jlVar;
            return;
        }
        int i2 = zzlT ^ (-1);
        if (i2 < this.mSize && this.zzbiq[i2] == zzbin) {
            this.zzbip[i2] = i;
            this.zzbiq[i2] = jlVar;
            return;
        }
        if (this.zzbio && this.mSize >= this.zzbip.length) {
            gc();
            i2 = zzlT(i) ^ (-1);
        }
        if (this.mSize >= this.zzbip.length) {
            int idealIntArraySize = idealIntArraySize(this.mSize + 1);
            int[] iArr = new int[idealIntArraySize];
            jl[] jlVarArr = new jl[idealIntArraySize];
            System.arraycopy(this.zzbip, 0, iArr, 0, this.zzbip.length);
            System.arraycopy(this.zzbiq, 0, jlVarArr, 0, this.zzbiq.length);
            this.zzbip = iArr;
            this.zzbiq = jlVarArr;
        }
        if (this.mSize - i2 != 0) {
            System.arraycopy(this.zzbip, i2, this.zzbip, i2 + 1, this.mSize - i2);
            System.arraycopy(this.zzbiq, i2, this.zzbiq, i2 + 1, this.mSize - i2);
        }
        this.zzbip[i2] = i;
        this.zzbiq[i2] = jlVar;
        this.mSize++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public jl zzlR(int i) {
        int zzlT = zzlT(i);
        if (zzlT < 0 || this.zzbiq[zzlT] == zzbin) {
            return null;
        }
        return this.zzbiq[zzlT];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public jl zzlS(int i) {
        if (this.zzbio) {
            gc();
        }
        return this.zzbiq[i];
    }
}
