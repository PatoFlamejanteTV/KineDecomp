package com.facebook.ads.redexgen.X;

import com.facebook.ads.RewardedVideoAd;

/* renamed from: com.facebook.ads.redexgen.X.9L, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C9L implements RewardedVideoAd.RewardedVideoAdShowConfigBuilder, RewardedVideoAd.RewardedVideoShowAdConfig {
    public int A00 = -1;

    public final int A00() {
        return this.A00;
    }

    public final RewardedVideoAd.RewardedVideoShowAdConfig build() {
        return this;
    }

    public final RewardedVideoAd.RewardedVideoAdShowConfigBuilder withAppOrientation(int i) {
        this.A00 = i;
        return this;
    }
}
