package com.qq.e.ads.interstitial;

import com.qq.e.comm.util.GDTLogger;

/* loaded from: classes3.dex */
public abstract class AbstractInterstitialADListener implements InterstitialADListener {
    @Override // com.qq.e.ads.interstitial.InterstitialADListener
    public void onADClicked() {
        GDTLogger.i("ON InterstitialAD Clicked");
    }

    @Override // com.qq.e.ads.interstitial.InterstitialADListener
    public void onADClosed() {
        GDTLogger.i("ON InterstitialAD Closed");
    }

    @Override // com.qq.e.ads.interstitial.InterstitialADListener
    public void onADExposure() {
        GDTLogger.i("ON InterstitialAD Exposure");
    }

    @Override // com.qq.e.ads.interstitial.InterstitialADListener
    public void onADLeftApplication() {
        GDTLogger.i("ON InterstitialAD LeftApplication");
    }

    @Override // com.qq.e.ads.interstitial.InterstitialADListener
    public void onADOpened() {
        GDTLogger.i("ON InterstitialAD Opened");
    }
}
