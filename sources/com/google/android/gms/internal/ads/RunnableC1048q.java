package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.q */
/* loaded from: classes2.dex */
final class RunnableC1048q implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzabw f12443a;

    public RunnableC1048q(zzabw zzabwVar) {
        this.f12443a = zzabwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzacd zzacdVar;
        zzacd zzacdVar2;
        zzacd zzacdVar3;
        zzacdVar = this.f12443a.zzdbj;
        if (zzacdVar != null) {
            zzacdVar2 = this.f12443a.zzdbj;
            zzacdVar2.zzsr();
            zzacdVar3 = this.f12443a.zzdbj;
            zzacdVar3.zzsq();
        }
        zzabw.zza(this.f12443a, null);
    }
}
