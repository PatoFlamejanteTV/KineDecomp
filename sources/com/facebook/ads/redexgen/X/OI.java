package com.facebook.ads.redexgen.X;

import android.graphics.drawable.GradientDrawable;
import android.widget.RelativeLayout;

/* loaded from: assets/audience_network.dex */
public final class OI extends OH {
    public static final int A00 = (int) (12.0f * KE.A01);

    public OI(C0610Nx c0610Nx, C2T c2t, String str, PG pg) {
        super(c0610Nx, c2t, true, str, pg);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0604Nr
    public final boolean A02() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.OH, com.facebook.ads.redexgen.X.AbstractC0604Nr
    public final boolean A07() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.OH
    public final void A0g(C0362Ec c0362Ec) {
        C0601No titleDescContainer = getTitleDescContainer();
        titleDescContainer.setAlignment(3);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(8, getMediaContainer().getId());
        titleDescContainer.setLayoutParams(layoutParams);
        titleDescContainer.setPadding(A00, A00, A00, A00);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, -15658735});
        gradientDrawable.setCornerRadius(0.0f);
        KE.A0T(titleDescContainer, gradientDrawable);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(3, getMediaContainer().getId());
        getCtaButton().setLayoutParams(layoutParams2);
        addView(getMediaContainer());
        addView(titleDescContainer);
        addView(getCtaButton());
    }
}
