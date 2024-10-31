package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdExtendedListener;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.RewardData;
import com.facebook.ads.RewardedAdListener;
import java.util.EnumSet;

/* renamed from: com.facebook.ads.redexgen.X.8Z, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C8Z implements InterstitialAd.InterstitialAdLoadConfigBuilder, InterstitialAd.InterstitialLoadAdConfig {
    public C8Y A00;

    @Nullable
    public String A01;
    public EnumSet<CacheFlag> A02;

    public C8Z(C8Y c8y) {
        this.A00 = c8y;
    }

    public final void A00() {
        if (this.A02 == null) {
            this.A02 = CacheFlag.ALL;
        }
        this.A00.A03(this.A02, this.A01);
    }

    public final InterstitialAd.InterstitialLoadAdConfig build() {
        return this;
    }

    public final InterstitialAd.InterstitialAdLoadConfigBuilder withAdListener(InterstitialAdListener interstitialAdListener) {
        this.A00.setAdListener(interstitialAdListener);
        if (interstitialAdListener instanceof InterstitialAdExtendedListener) {
            this.A00.setRewardedAdListener((InterstitialAdExtendedListener) interstitialAdListener);
        }
        return this;
    }

    public final InterstitialAd.InterstitialAdLoadConfigBuilder withBid(String str) {
        this.A01 = str;
        return this;
    }

    public final InterstitialAd.InterstitialAdLoadConfigBuilder withCacheFlags(EnumSet<CacheFlag> cacheFlags) {
        this.A02 = cacheFlags;
        return this;
    }

    public final InterstitialAd.InterstitialAdLoadConfigBuilder withRewardData(RewardData rewardData) {
        this.A00.A02(rewardData);
        return this;
    }

    public final InterstitialAd.InterstitialAdLoadConfigBuilder withRewardedAdListener(RewardedAdListener rewardedAdListener) {
        this.A00.setRewardedAdListener(rewardedAdListener);
        return this;
    }
}
