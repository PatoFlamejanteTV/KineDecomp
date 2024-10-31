package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Ra implements zzbco {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzajm f11797a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzait f11798b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ra(zzait zzaitVar, zzajm zzajmVar) {
        this.f11798b = zzaitVar;
        this.f11797a = zzajmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void run() {
        Object obj;
        obj = this.f11798b.mLock;
        synchronized (obj) {
            this.f11798b.zzdiz = 1;
            zzaxz.v("Failed loading new engine. Marking new engine destroyable.");
            this.f11797a.zzuf();
        }
    }
}
