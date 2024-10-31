package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.n */
/* loaded from: classes2.dex */
final class RunnableC1006n implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzabs f12341a;

    public RunnableC1006n(zzabs zzabsVar) {
        this.f12341a = zzabsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzacd zzacdVar;
        zzacd zzacdVar2;
        zzacd zzacdVar3;
        zzacd zzacdVar4;
        zzacdVar = this.f12341a.zzdbj;
        if (zzacdVar != null) {
            zzacdVar2 = this.f12341a.zzdbj;
            zzacdVar2.zzsr();
            zzacdVar3 = this.f12341a.zzdbj;
            zzacdVar3.zzsq();
            zzacdVar4 = this.f12341a.zzdbj;
            zzacdVar4.zzjm();
        }
        zzabs.zza(this.f12341a, null);
    }
}
