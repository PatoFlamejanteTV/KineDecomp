package com.google.android.gms.ads.mediation;

/* loaded from: classes.dex */
public interface MediationNativeListener {
    void onAdClicked(MediationNativeAdapter mediationNativeAdapter);

    void onAdClosed(MediationNativeAdapter mediationNativeAdapter);

    void onAdFailedToLoad(MediationNativeAdapter mediationNativeAdapter, int i);

    void onAdLeftApplication(MediationNativeAdapter mediationNativeAdapter);

    void onAdLoaded(MediationNativeAdapter mediationNativeAdapter, NativeAdMapper nativeAdMapper);

    void onAdOpened(MediationNativeAdapter mediationNativeAdapter);
}
