package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class Uf implements com.google.android.gms.ads.internal.overlay.zzn {

    /* renamed from: a, reason: collision with root package name */
    private zzbgg f11877a;

    /* renamed from: b, reason: collision with root package name */
    private com.google.android.gms.ads.internal.overlay.zzn f11878b;

    public Uf(zzbgg zzbggVar, com.google.android.gms.ads.internal.overlay.zzn zznVar) {
        this.f11877a = zzbggVar;
        this.f11878b = zznVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzn
    public final void onPause() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzn
    public final void onResume() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzn
    public final void zziv() {
        this.f11878b.zziv();
        this.f11877a.zzade();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzn
    public final void zziw() {
        this.f11878b.zziw();
        this.f11877a.zzvv();
    }
}
