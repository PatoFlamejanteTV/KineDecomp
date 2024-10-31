package com.nexstreaming.kinemaster.ad.providers;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

/* loaded from: classes.dex */
public class AdmobRewardedVideoAdProvider extends AdmobAdProvider<RewardedVideoAd> implements RewardedVideoAdListener {
    private static final String TAG = "AdmobRewardedVideoAdProvider";
    private static final String UNIT_ID = "ca-app-pub-3940256099942544/5224354917";

    public AdmobRewardedVideoAdProvider(Context context) {
        super(context, UNIT_ID);
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.AdmobAdProvider, com.nexstreaming.kinemaster.ad.g
    public String getId() {
        return AdmobRewardedVideoAdProvider.class.getSimpleName();
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.AdmobAdProvider
    protected void onLoadAd() {
        getAd().loadAd(UNIT_ID, newAdRequest());
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public void onRewarded(RewardItem rewardItem) {
        onAdClicked();
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public void onRewardedVideoAdClosed() {
        onAdClosed();
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public void onRewardedVideoAdFailedToLoad(int i) {
        onAdFailedToLoad(i);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public void onRewardedVideoAdLeftApplication() {
        onAdLeftApplication();
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public void onRewardedVideoAdLoaded() {
        onAdLoaded();
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public void onRewardedVideoAdOpened() {
        onAdOpened();
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public void onRewardedVideoCompleted() {
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public void onRewardedVideoStarted() {
        onAdImpression();
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.AdmobAdProvider
    public void showAd(AppCompatActivity appCompatActivity, int i, int i2) {
        if (isReady()) {
            if (getAd().isLoaded()) {
                getAd().show();
            } else {
                onAdClosed();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.nexstreaming.kinemaster.ad.providers.AdmobAdProvider
    public RewardedVideoAd onCreateAd() {
        RewardedVideoAd a2 = MobileAds.a(getContext());
        a2.setRewardedVideoAdListener(this);
        return a2;
    }
}
