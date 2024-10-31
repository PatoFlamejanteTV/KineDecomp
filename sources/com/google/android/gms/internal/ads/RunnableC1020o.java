package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.o */
/* loaded from: classes2.dex */
final class RunnableC1020o implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzabu f12374a;

    public RunnableC1020o(zzabu zzabuVar) {
        this.f12374a = zzabuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzacd zzacdVar;
        zzacd zzacdVar2;
        zzacd zzacdVar3;
        zzacd zzacdVar4;
        zzacdVar = this.f12374a.zzdbj;
        if (zzacdVar != null) {
            zzacdVar2 = this.f12374a.zzdbj;
            zzacdVar2.zzsr();
            zzacdVar3 = this.f12374a.zzdbj;
            zzacdVar3.zzsq();
            zzacdVar4 = this.f12374a.zzdbj;
            zzacdVar4.zzjm();
        }
        zzabu.zza(this.f12374a, null);
    }
}
