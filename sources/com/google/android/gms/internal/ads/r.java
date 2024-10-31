package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class r implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzabz f12474a;

    public r(zzabz zzabzVar) {
        this.f12474a = zzabzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzacd zzacdVar;
        zzacd zzacdVar2;
        zzacd zzacdVar3;
        zzacd zzacdVar4;
        zzacdVar = this.f12474a.zzdbj;
        if (zzacdVar != null) {
            zzacdVar2 = this.f12474a.zzdbj;
            zzacdVar2.zzsr();
            zzacdVar3 = this.f12474a.zzdbj;
            zzacdVar3.zzsq();
            zzacdVar4 = this.f12474a.zzdbj;
            zzacdVar4.zzjm();
        }
        zzabz.zza(this.f12474a, null);
    }
}
