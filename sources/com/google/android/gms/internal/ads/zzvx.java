package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;

@zzark
/* loaded from: classes2.dex */
public final class zzvx extends zzxb {
    private final AdListener zzciz;

    public zzvx(AdListener adListener) {
        this.zzciz = adListener;
    }

    public final AdListener getAdListener() {
        return this.zzciz;
    }

    @Override // com.google.android.gms.internal.ads.zzxa
    public final void onAdClicked() {
        this.zzciz.onAdClicked();
    }

    @Override // com.google.android.gms.internal.ads.zzxa
    public final void onAdClosed() {
        this.zzciz.onAdClosed();
    }

    @Override // com.google.android.gms.internal.ads.zzxa
    public final void onAdFailedToLoad(int i) {
        this.zzciz.onAdFailedToLoad(i);
    }

    @Override // com.google.android.gms.internal.ads.zzxa
    public final void onAdImpression() {
        this.zzciz.onAdImpression();
    }

    @Override // com.google.android.gms.internal.ads.zzxa
    public final void onAdLeftApplication() {
        this.zzciz.onAdLeftApplication();
    }

    @Override // com.google.android.gms.internal.ads.zzxa
    public final void onAdLoaded() {
        this.zzciz.onAdLoaded();
    }

    @Override // com.google.android.gms.internal.ads.zzxa
    public final void onAdOpened() {
        this.zzciz.onAdOpened();
    }
}
