package com.facebook.ads.redexgen.X;

import android.widget.FrameLayout;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdLayout;

/* renamed from: com.facebook.ads.redexgen.X.8z, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C02308z extends C8J {
    public InterfaceC0650Pm A00;

    public final void A05(NativeAdLayout nativeAdLayout, C0362Ec c0362Ec, NativeAd nativeAd, C0444Hh c0444Hh) {
        M4 m4 = new M4(c0362Ec);
        MediaView mediaView = new MediaView(c0362Ec);
        AdOptionsView adOptionsView = new AdOptionsView(c0362Ec, nativeAd, nativeAdLayout);
        c0444Hh.A09(adOptionsView, 28);
        HX internalNativeAd = HX.A0J(nativeAd.getInternalNativeAd());
        this.A00 = new C0652Po(c0362Ec, nativeAd, c0444Hh, internalNativeAd.A11(), m4, mediaView, adOptionsView);
        KE.A0P(nativeAdLayout, c0444Hh.A00());
        nativeAd.registerViewForInteraction(nativeAdLayout, mediaView, m4, this.A00.getViewsForInteraction());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        nativeAdLayout.addView(this.A00.getView(), layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.C02017w
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.A00.unregisterView();
    }
}
