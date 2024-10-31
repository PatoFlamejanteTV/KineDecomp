package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;

@zzark
/* loaded from: classes2.dex */
public abstract class zzasc implements zzasa, zzazb<Void> {
    private final Object mLock = new Object();
    private final zzbcn<zzasi> zzdvz;
    private final zzasa zzdwa;

    public zzasc(zzbcn<zzasi> zzbcnVar, zzasa zzasaVar) {
        this.zzdvz = zzbcnVar;
        this.zzdwa = zzasaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzazb
    public final void cancel() {
        zzwi();
    }

    @Override // com.google.android.gms.internal.ads.zzasa
    public final void zza(zzasm zzasmVar) {
        synchronized (this.mLock) {
            this.zzdwa.zza(zzasmVar);
            zzwi();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzazb
    public final /* synthetic */ Void zzwa() {
        zzasq zzwj = zzwj();
        if (zzwj == null) {
            this.zzdwa.zza(new zzasm(0));
            zzwi();
            return null;
        }
        this.zzdvz.zza(new Jc(this, zzwj), new Kc(this));
        return null;
    }

    public abstract void zzwi();

    public abstract zzasq zzwj();

    @VisibleForTesting
    public final boolean zza(zzasq zzasqVar, zzasi zzasiVar) {
        try {
            zzasqVar.zza(zzasiVar, new zzasl(this));
            return true;
        } catch (Throwable th) {
            zzbbd.zzc("Could not fetch ad response from ad request service due to an Exception.", th);
            com.google.android.gms.ads.internal.zzbv.i().zza(th, "AdRequestClientTask.getAdResponseFromService");
            this.zzdwa.zza(new zzasm(0));
            return false;
        }
    }
}
