package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public abstract class zzop {
    private zzoq zzbfj;

    public final void invalidate() {
        zzoq zzoqVar = this.zzbfj;
        if (zzoqVar != null) {
            zzoqVar.zzbu();
        }
    }

    public abstract zzor zza(zzga[] zzgaVarArr, zzma zzmaVar) throws zzff;

    public final void zza(zzoq zzoqVar) {
        this.zzbfj = zzoqVar;
    }

    public abstract void zzd(Object obj);
}
