package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdView;

/* loaded from: assets/audience_network.dex */
public final class H3 implements AdView.AdViewLoadConfigBuilder, AdView.AdViewLoadConfig {

    @Nullable
    public String A00;
    public final C02047z A01;

    public H3(C02047z c02047z) {
        this.A01 = c02047z;
    }

    @Nullable
    public final String A00() {
        return this.A00;
    }

    public final AdView.AdViewLoadConfig build() {
        return this;
    }

    public final AdView.AdViewLoadConfigBuilder withAdListener(AdListener adListener) {
        this.A01.setAdListener(adListener);
        return this;
    }

    public final AdView.AdViewLoadConfigBuilder withBid(String str) {
        this.A00 = str;
        return this;
    }
}
