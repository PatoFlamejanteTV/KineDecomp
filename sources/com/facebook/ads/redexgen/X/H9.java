package com.facebook.ads.redexgen.X;

import com.facebook.ads.NativeAd;
import com.facebook.ads.internal.api.MediaViewVideoRendererApi;

/* loaded from: assets/audience_network.dex */
public class H9 implements H8 {
    public final /* synthetic */ MediaViewVideoRendererApi A00;
    public final /* synthetic */ HH A01;

    public H9(HH hh, MediaViewVideoRendererApi mediaViewVideoRendererApi) {
        this.A01 = hh;
        this.A00 = mediaViewVideoRendererApi;
    }

    @Override // com.facebook.ads.redexgen.X.H8
    public final void A8H() {
        this.A00.setVolume(1.0f);
    }

    @Override // com.facebook.ads.redexgen.X.H8
    public final void A8J(NativeAd nativeAd) {
        this.A01.A0I(HX.A0J(nativeAd.getInternalNativeAd()), new HG(HX.A0J(nativeAd.getInternalNativeAd())));
    }

    @Override // com.facebook.ads.redexgen.X.H8
    public final void A8W() {
        this.A01.A0D();
    }
}
