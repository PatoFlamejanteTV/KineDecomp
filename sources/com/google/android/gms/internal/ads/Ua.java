package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Ua implements zzbcq<zzajr> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzaji f11868a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ua(zzaji zzajiVar) {
        this.f11868a = zzajiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbcq
    public final /* synthetic */ void zzh(zzajr zzajrVar) {
        zzajm zzajmVar;
        zzaxz.v("Releasing engine reference.");
        zzajmVar = this.f11868a.zzdjp;
        zzajmVar.zzue();
    }
}
