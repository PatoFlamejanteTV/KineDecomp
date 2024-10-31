package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Ma implements com.google.android.gms.ads.internal.gmsg.zzu<zzajr> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzajm f11675a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzaii f11676b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzait f11677c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ma(zzait zzaitVar, zzajm zzajmVar, zzaii zzaiiVar) {
        this.f11677c = zzaitVar;
        this.f11675a = zzajmVar;
        this.f11676b = zzaiiVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final /* synthetic */ void zza(zzajr zzajrVar, Map map) {
        Object obj;
        zzazn zzaznVar;
        obj = this.f11677c.mLock;
        synchronized (obj) {
            if (this.f11675a.getStatus() != -1 && this.f11675a.getStatus() != 1) {
                this.f11677c.zzdiz = 0;
                zzaznVar = this.f11677c.zzdiw;
                zzaznVar.zzh(this.f11676b);
                this.f11675a.zzo(this.f11676b);
                this.f11677c.zzdiy = this.f11675a;
                zzaxz.v("Successfully loaded JS Engine.");
            }
        }
    }
}
