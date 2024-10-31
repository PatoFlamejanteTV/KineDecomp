package com.google.ads.mediation;

import com.google.ads.AdRequest;

@Deprecated
/* loaded from: classes.dex */
public interface MediationInterstitialListener {
    void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, AdRequest.ErrorCode errorCode);
}
