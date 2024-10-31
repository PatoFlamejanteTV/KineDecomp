package com.facebook.ads.redexgen.X;

import android.graphics.drawable.ColorDrawable;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/* loaded from: assets/audience_network.dex */
public final class OU extends OH {
    public static final int A00 = (int) (20.0f * KE.A01);
    public static final int A01 = (int) (16.0f * KE.A01);

    public OU(C0610Nx c0610Nx, C2T c2t, String str, PG pg) {
        super(c0610Nx, c2t, false, str, pg);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0604Nr
    public final boolean A03() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.OH
    public final void A0g(C0362Ec c0362Ec) {
        C0601No titleDescContainer = getTitleDescContainer();
        titleDescContainer.setAlignment(3);
        titleDescContainer.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        titleDescContainer.setPadding(0, 0, 0, A00);
        getCtaButton().setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout = new LinearLayout(c0362Ec);
        KE.A0T(linearLayout, new ColorDrawable(-1));
        RelativeLayout.LayoutParams ctaLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        ctaLayoutParams.addRule(3, getMediaContainer().getId());
        linearLayout.setLayoutParams(ctaLayoutParams);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(A01, A01, A01, A01);
        linearLayout.addView(titleDescContainer);
        linearLayout.addView(getCtaButton());
        addView(getMediaContainer());
        addView(linearLayout);
    }
}
