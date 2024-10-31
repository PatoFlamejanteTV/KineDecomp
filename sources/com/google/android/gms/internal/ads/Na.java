package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Na implements com.google.android.gms.ads.internal.gmsg.zzu<zzajr> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzcu f11699a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzaii f11700b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzbaj f11701c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ zzait f11702d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Na(zzait zzaitVar, zzcu zzcuVar, zzaii zzaiiVar, zzbaj zzbajVar) {
        this.f11702d = zzaitVar;
        this.f11699a = zzcuVar;
        this.f11700b = zzaiiVar;
        this.f11701c = zzbajVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final /* synthetic */ void zza(zzajr zzajrVar, Map map) {
        Object obj;
        int i;
        obj = this.f11702d.mLock;
        synchronized (obj) {
            zzbbd.zzen("JS Engine is requesting an update");
            i = this.f11702d.zzdiz;
            if (i == 0) {
                zzbbd.zzen("Starting reload.");
                this.f11702d.zzdiz = 2;
                this.f11702d.zza(this.f11699a);
            }
            this.f11700b.zzb("/requestReload", (com.google.android.gms.ads.internal.gmsg.zzu<? super zzajr>) this.f11701c.get());
        }
    }
}
