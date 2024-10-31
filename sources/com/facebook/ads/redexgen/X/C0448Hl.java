package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdListener;

/* renamed from: com.facebook.ads.redexgen.X.Hl, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0448Hl implements NativeAdBase.NativeAdLoadConfigBuilder, NativeAdBase.NativeLoadAdConfig {

    @Nullable
    public NativeAdBase.MediaCacheFlag A02;

    @Nullable
    public String A03;
    public boolean A04;
    public final NativeAdBase A05;
    public final HX A06;
    public int A01 = -1;
    public int A00 = -1;

    public C0448Hl(HX hx, NativeAdBase nativeAdBase) {
        this.A06 = hx;
        this.A05 = nativeAdBase;
    }

    public final NativeAdBase.NativeLoadAdConfig build() {
        return this;
    }

    public final void loadAd() {
        if (this.A02 == null) {
            this.A02 = NativeAdBase.MediaCacheFlag.ALL;
        }
        this.A06.A1L(HI.A00(this.A02), this.A03, new C0360Ea(this.A04, this.A01, this.A00));
    }

    public final NativeAdBase.NativeAdLoadConfigBuilder withAdListener(NativeAdListener nativeAdListener) {
        this.A06.setAdListener(nativeAdListener, this.A05);
        return this;
    }

    public final NativeAdBase.NativeAdLoadConfigBuilder withBid(String str) {
        this.A03 = str;
        return this;
    }

    public final NativeAdBase.NativeAdLoadConfigBuilder withMediaCacheFlag(NativeAdBase.MediaCacheFlag mediaCacheFlag) {
        this.A02 = mediaCacheFlag;
        return this;
    }

    public final NativeAdBase.NativeAdLoadConfigBuilder withPreloadedIconView(int i, int i2) {
        this.A04 = true;
        this.A01 = i;
        this.A00 = i2;
        return this;
    }
}
