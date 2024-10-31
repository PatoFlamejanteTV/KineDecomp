package com.qq.e.ads.interstitial;

import com.qq.e.comm.util.AdError;

/* loaded from: classes3.dex */
public interface InterstitialADListener {
    void onADClicked();

    void onADClosed();

    void onADExposure();

    void onADLeftApplication();

    void onADOpened();

    void onADReceive();

    void onNoAD(AdError adError);
}
