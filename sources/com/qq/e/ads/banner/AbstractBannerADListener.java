package com.qq.e.ads.banner;

import com.qq.e.comm.util.GDTLogger;

/* loaded from: classes3.dex */
public abstract class AbstractBannerADListener implements BannerADListener {
    @Override // com.qq.e.ads.banner.BannerADListener
    public void onADClicked() {
        GDTLogger.i("On BannerAD Clicked");
    }

    @Override // com.qq.e.ads.banner.BannerADListener
    public void onADCloseOverlay() {
        GDTLogger.i("On BannerAD AdCloseOverlay");
    }

    @Override // com.qq.e.ads.banner.BannerADListener
    public void onADClosed() {
        GDTLogger.i("On BannerAD Closed");
    }

    @Override // com.qq.e.ads.banner.BannerADListener
    public void onADExposure() {
        GDTLogger.i("On BannerAD Exposured");
    }

    @Override // com.qq.e.ads.banner.BannerADListener
    public void onADLeftApplication() {
        GDTLogger.i("On BannerAD AdLeftApplication");
    }

    @Override // com.qq.e.ads.banner.BannerADListener
    public void onADOpenOverlay() {
        GDTLogger.i("On BannerAD AdOpenOverlay");
    }
}
