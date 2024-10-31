package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import com.facebook.ads.InstreamVideoAdListener;
import com.facebook.ads.InstreamVideoAdView;

/* loaded from: assets/audience_network.dex */
public final class H4 implements InstreamVideoAdView.InstreamVideoLoadConfigBuilder, InstreamVideoAdView.InstreamVideoLoadAdConfig {

    @Nullable
    public String A00;
    public final C8X A01;

    public H4(C8X c8x) {
        this.A01 = c8x;
    }

    @Nullable
    public final String A00() {
        return this.A00;
    }

    public final InstreamVideoAdView.InstreamVideoLoadAdConfig build() {
        return this;
    }

    public final InstreamVideoAdView.InstreamVideoLoadConfigBuilder withAdListener(InstreamVideoAdListener instreamVideoAdListener) {
        this.A01.setAdListener(instreamVideoAdListener);
        return this;
    }

    public final InstreamVideoAdView.InstreamVideoLoadConfigBuilder withBid(String str) {
        this.A00 = str;
        return this;
    }
}
