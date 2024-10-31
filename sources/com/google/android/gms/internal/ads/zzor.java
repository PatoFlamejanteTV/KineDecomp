package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzor {
    public final zzma zzbfk;
    public final zzoo zzbfl;
    public final Object zzbfm;
    public final zzgb[] zzbfn;

    public zzor(zzma zzmaVar, zzoo zzooVar, Object obj, zzgb[] zzgbVarArr) {
        this.zzbfk = zzmaVar;
        this.zzbfl = zzooVar;
        this.zzbfm = obj;
        this.zzbfn = zzgbVarArr;
    }

    public final boolean zza(zzor zzorVar, int i) {
        return zzorVar != null && zzqe.zza(this.zzbfl.zzbe(i), zzorVar.zzbfl.zzbe(i)) && zzqe.zza(this.zzbfn[i], zzorVar.zzbfn[i]);
    }
}
