package com.google.android.gms.ads.reward;

import com.google.android.gms.ads.AdRequest;

/* loaded from: classes.dex */
public interface RewardedVideoAd {
    boolean isLoaded();

    void loadAd(String str, AdRequest adRequest);

    void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener);

    void show();
}
