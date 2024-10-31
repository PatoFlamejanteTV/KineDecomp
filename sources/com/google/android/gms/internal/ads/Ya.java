package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Ya implements zzbcq<zzaii> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzajm f11972a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ya(zzajm zzajmVar) {
        this.f11972a = zzajmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbcq
    public final /* synthetic */ void zzh(zzaii zzaiiVar) {
        final zzaii zzaiiVar2 = zzaiiVar;
        zzbcg.zzepo.execute(new Runnable(this, zzaiiVar2) { // from class: com.google.android.gms.internal.ads.Za

            /* renamed from: a, reason: collision with root package name */
            private final Ya f12000a;

            /* renamed from: b, reason: collision with root package name */
            private final zzaii f12001b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12000a = this;
                this.f12001b = zzaiiVar2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzazn zzaznVar;
                Ya ya = this.f12000a;
                zzaii zzaiiVar3 = this.f12001b;
                zzaznVar = ya.f11972a.zzdix;
                zzaznVar.zzh(zzaiiVar3);
                zzaiiVar3.destroy();
            }
        });
    }
}
