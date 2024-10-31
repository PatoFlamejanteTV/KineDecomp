package com.google.ads.mediation;

import com.google.ads.AdRequest;

@Deprecated
/* loaded from: classes.dex */
public interface MediationBannerListener {
    void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, AdRequest.ErrorCode errorCode);
}
