package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Gf implements com.google.android.gms.ads.internal.overlay.zzn {

    /* renamed from: a, reason: collision with root package name */
    private zzbgg f11547a;

    /* renamed from: b, reason: collision with root package name */
    private com.google.android.gms.ads.internal.overlay.zzn f11548b;

    public Gf(zzbgg zzbggVar, com.google.android.gms.ads.internal.overlay.zzn zznVar) {
        this.f11547a = zzbggVar;
        this.f11548b = zznVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzn
    public final void onPause() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzn
    public final void onResume() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzn
    public final void zziv() {
        this.f11548b.zziv();
        this.f11547a.zzade();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzn
    public final void zziw() {
        this.f11548b.zziw();
        this.f11547a.zzvv();
    }
}
