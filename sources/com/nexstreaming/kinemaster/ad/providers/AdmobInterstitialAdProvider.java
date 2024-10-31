package com.nexstreaming.kinemaster.ad.providers;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import com.google.android.gms.ads.InterstitialAd;
import com.nexstreaming.kinemaster.ad.AdManager;

/* loaded from: classes.dex */
public class AdmobInterstitialAdProvider extends AdmobAdProvider<InterstitialAd> {
    private static final String TAG = "AdmobInterstitialAdProvider";
    private boolean isShowAds;

    public AdmobInterstitialAdProvider(Context context, String str) {
        super(context, str);
        this.isShowAds = false;
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.AdmobAdProvider, com.nexstreaming.kinemaster.ad.g
    public String getId() {
        return AdmobInterstitialAdProvider.class.getSimpleName();
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.AdmobAdProvider, com.nexstreaming.kinemaster.ad.g
    public boolean isOpened() {
        return this.isShowAds;
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.AdmobAdProvider, com.google.android.gms.ads.AdListener
    public void onAdClosed() {
        this.isShowAds = false;
        super.onAdClosed();
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.AdmobAdProvider, com.google.android.gms.ads.AdListener
    public void onAdFailedToLoad(int i) {
        this.isShowAds = false;
        super.onAdFailedToLoad(i);
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.AdmobAdProvider, com.google.android.gms.ads.AdListener
    public void onAdLeftApplication() {
        super.onAdLeftApplication();
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.AdmobAdProvider, com.google.android.gms.ads.AdListener
    public void onAdLoaded() {
        super.onAdLoaded();
        if (AdManager.a(getContext()).a() != null) {
            AdManager.a(getContext()).a(getAd(), this.unitID);
        }
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.AdmobAdProvider
    protected void onLoadAd() {
        getAd().a(newAdRequest());
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.AdmobAdProvider
    public void showAd(AppCompatActivity appCompatActivity, int i, int i2) {
        if (isReady()) {
            if (getAd().b()) {
                getAd().c();
            } else {
                onAdClosed();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.nexstreaming.kinemaster.ad.providers.AdmobAdProvider
    public InterstitialAd onCreateAd() {
        InterstitialAd interstitialAd = new InterstitialAd(getContext());
        interstitialAd.a(this.unitID);
        interstitialAd.a(this);
        return interstitialAd;
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.AdmobAdProvider, com.nexstreaming.kinemaster.ad.g
    public void showAd(AppCompatActivity appCompatActivity) {
        getAd().c();
        this.isShowAds = true;
    }
}
