package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import com.facebook.ads.RewardData;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.RewardedVideoAdListener;

/* renamed from: com.facebook.ads.redexgen.X.9K, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C9K implements RewardedVideoAd.RewardedVideoAdLoadConfigBuilder, RewardedVideoAd.RewardedVideoLoadAdConfig {
    public C9J A00;

    @Nullable
    public String A01;
    public boolean A02;

    public C9K(C9J c9j) {
        this.A00 = c9j;
    }

    public final void A00() {
        this.A00.A02(this.A01, this.A02);
    }

    public final RewardedVideoAd.RewardedVideoLoadAdConfig build() {
        return this;
    }

    public final RewardedVideoAd.RewardedVideoAdLoadConfigBuilder withAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        this.A00.setAdListener(rewardedVideoAdListener);
        return this;
    }

    public final RewardedVideoAd.RewardedVideoAdLoadConfigBuilder withBid(String str) {
        this.A01 = str;
        return this;
    }

    public final RewardedVideoAd.RewardedVideoAdLoadConfigBuilder withFailOnCacheFailureEnabled(boolean z) {
        this.A02 = z;
        return this;
    }

    @Deprecated
    public final RewardedVideoAd.RewardedVideoAdLoadConfigBuilder withRVChainEnabled(boolean z) {
        return this;
    }

    public final RewardedVideoAd.RewardedVideoAdLoadConfigBuilder withRewardData(RewardData rewardData) {
        this.A00.setRewardData(rewardData);
        return this;
    }
}
