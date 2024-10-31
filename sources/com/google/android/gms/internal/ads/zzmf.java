package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* loaded from: classes2.dex */
public final class zzmf implements zzib {
    private zzig zzaxa;
    public final zzhz zzaxu;
    private final zzfs zzazu;
    private final SparseArray<C1185zl> zzazv = new SparseArray<>();
    private boolean zzazw;
    private zzmh zzazx;
    private zzfs[] zzazy;

    public zzmf(zzhz zzhzVar, zzfs zzfsVar) {
        this.zzaxu = zzhzVar;
        this.zzazu = zzfsVar;
    }

    public final void zza(zzmh zzmhVar) {
        this.zzazx = zzmhVar;
        if (!this.zzazw) {
            this.zzaxu.zza(this);
            this.zzazw = true;
            return;
        }
        this.zzaxu.zzc(0L, 0L);
        for (int i = 0; i < this.zzazv.size(); i++) {
            this.zzazv.valueAt(i).a(zzmhVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzib
    public final zzii zzb(int i, int i2) {
        C1185zl c1185zl = this.zzazv.get(i);
        if (c1185zl != null) {
            return c1185zl;
        }
        zzpo.checkState(this.zzazy == null);
        C1185zl c1185zl2 = new C1185zl(i, i2, this.zzazu);
        c1185zl2.a(this.zzazx);
        this.zzazv.put(i, c1185zl2);
        return c1185zl2;
    }

    @Override // com.google.android.gms.internal.ads.zzib
    public final void zzdy() {
        zzfs[] zzfsVarArr = new zzfs[this.zzazv.size()];
        for (int i = 0; i < this.zzazv.size(); i++) {
            zzfsVarArr[i] = this.zzazv.valueAt(i).f12711d;
        }
        this.zzazy = zzfsVarArr;
    }

    public final zzig zzfw() {
        return this.zzaxa;
    }

    public final zzfs[] zzfx() {
        return this.zzazy;
    }

    @Override // com.google.android.gms.internal.ads.zzib
    public final void zza(zzig zzigVar) {
        this.zzaxa = zzigVar;
    }
}
