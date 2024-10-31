package com.facebook.ads.redexgen.X;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

/* loaded from: assets/audience_network.dex */
public final class O4 extends AbstractC0604Nr {
    public static final int A01 = Resources.getSystem().getDisplayMetrics().widthPixels;
    public final OE A00;

    public O4(C0610Nx c0610Nx, boolean z, C2T c2t) {
        super(c0610Nx, c2t, z);
        this.A00 = new OE(c0610Nx.A05(), c0610Nx.A02());
        this.A00.A01(c0610Nx.A0A(), c0610Nx.A03(), 10, getTitleDescContainer(), z);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        layoutParams.setMargins(AbstractC0604Nr.A05, AbstractC0604Nr.A05, AbstractC0604Nr.A05, AbstractC0604Nr.A05);
        getCtaButton().setLayoutParams(layoutParams);
        FrameLayout frameLayout = new FrameLayout(c0610Nx.A05());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(2, getCtaButton().getId());
        frameLayout.setLayoutParams(layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams3.gravity = 17;
        layoutParams3.setMargins(AbstractC0604Nr.A05, 0, AbstractC0604Nr.A05, 0);
        frameLayout.addView(this.A00, layoutParams3);
        addView(frameLayout);
        addView(getCtaButton());
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0604Nr
    public final boolean A04() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0604Nr
    public final boolean A07() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0604Nr
    public final void A0Z(C2L c2l, String str, double d, @Nullable Bundle bundle) {
        super.A0Z(c2l, str, d, bundle);
        if (d > 0.0d) {
            this.A00.A00((int) ((A01 - (AbstractC0604Nr.A05 * 2)) / d));
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0604Nr
    public final boolean A0b() {
        return false;
    }
}
