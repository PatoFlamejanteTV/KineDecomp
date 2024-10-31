package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.mediation.MediationInterstitialListener;

/* loaded from: classes2.dex */
final class Gb implements com.google.android.gms.ads.internal.overlay.zzn {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzanu f11541a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Gb(zzanu zzanuVar) {
        this.f11541a = zzanuVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzn
    public final void onPause() {
        zzbbd.zzdn("AdMobCustomTabsAdapter overlay is paused.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzn
    public final void onResume() {
        zzbbd.zzdn("AdMobCustomTabsAdapter overlay is resumed.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzn
    public final void zziv() {
        MediationInterstitialListener mediationInterstitialListener;
        zzbbd.zzdn("AdMobCustomTabsAdapter overlay is closed.");
        mediationInterstitialListener = this.f11541a.zzdox;
        mediationInterstitialListener.onAdClosed(this.f11541a);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzn
    public final void zziw() {
        MediationInterstitialListener mediationInterstitialListener;
        zzbbd.zzdn("Opening AdMobCustomTabsAdapter overlay.");
        mediationInterstitialListener = this.f11541a.zzdox;
        mediationInterstitialListener.onAdOpened(this.f11541a);
    }
}
