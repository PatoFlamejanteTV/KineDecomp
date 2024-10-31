package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Qa implements zzbcq<zzaii> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzajm f11782a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzait f11783b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Qa(zzait zzaitVar, zzajm zzajmVar) {
        this.f11783b = zzaitVar;
        this.f11782a = zzajmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbcq
    public final /* synthetic */ void zzh(zzaii zzaiiVar) {
        Object obj;
        zzajm zzajmVar;
        zzajm zzajmVar2;
        zzajm zzajmVar3;
        obj = this.f11783b.mLock;
        synchronized (obj) {
            this.f11783b.zzdiz = 0;
            zzajmVar = this.f11783b.zzdiy;
            if (zzajmVar != null) {
                zzajm zzajmVar4 = this.f11782a;
                zzajmVar2 = this.f11783b.zzdiy;
                if (zzajmVar4 != zzajmVar2) {
                    zzaxz.v("New JS engine is loaded, marking previous one as destroyable.");
                    zzajmVar3 = this.f11783b.zzdiy;
                    zzajmVar3.zzuf();
                }
            }
            this.f11783b.zzdiy = this.f11782a;
        }
    }
}
