package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public abstract class zzmc extends zzmo {
    private C1171yl zzazk;
    private int[] zzazl;

    public zzmc(zzov zzovVar, zzoz zzozVar, zzfs zzfsVar, int i, Object obj, long j, long j2, int i2) {
        super(zzovVar, zzozVar, zzfsVar, i, obj, j, j2, i2);
    }

    public final void zza(C1171yl c1171yl) {
        this.zzazk = c1171yl;
        this.zzazl = c1171yl.a();
    }

    public final int zzav(int i) {
        return this.zzazl[i];
    }

    public final C1171yl zzft() {
        return this.zzazk;
    }
}
