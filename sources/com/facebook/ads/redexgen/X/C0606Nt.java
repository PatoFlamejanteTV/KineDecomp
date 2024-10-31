package com.facebook.ads.redexgen.X;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/* renamed from: com.facebook.ads.redexgen.X.Nt, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0606Nt extends AbstractC0604Nr {
    public C0606Nt(C0610Nx c0610Nx, C2T c2t, boolean z) {
        super(c0610Nx, c2t, true);
        RelativeLayout relativeLayout = new RelativeLayout(c0610Nx.A05());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{-1778384896, 0});
        gradientDrawable.setCornerRadius(0.0f);
        gradientDrawable.setGradientType(0);
        KE.A0T(relativeLayout, gradientDrawable);
        LinearLayout linearLayout = new LinearLayout(c0610Nx.A05());
        linearLayout.setOrientation(z ? 0 : 1);
        linearLayout.setGravity(80);
        KE.A0N(linearLayout);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(AbstractC0604Nr.A05, 0, AbstractC0604Nr.A05, c0610Nx.A0A() == null ? AbstractC0604Nr.A05 : AbstractC0604Nr.A05 / 2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(z ? -2 : -1, -2);
        layoutParams3.setMargins(z ? AbstractC0604Nr.A05 : 0, z ? 0 : AbstractC0604Nr.A05, 0, 0);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(z ? 0 : -1, -2);
        layoutParams4.setMargins(0, 0, 0, 0);
        layoutParams4.weight = 1.0f;
        linearLayout.addView(getTitleDescContainer(), layoutParams4);
        linearLayout.addView(getCtaButton(), layoutParams3);
        relativeLayout.addView(linearLayout, layoutParams2);
        if (c0610Nx.A0A() != null) {
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams5.setMargins(0, 0, 0, 0);
            layoutParams5.addRule(3, linearLayout.getId());
            relativeLayout.addView(c0610Nx.A0A(), layoutParams5);
        }
        addView(c0610Nx.A02(), new RelativeLayout.LayoutParams(-1, -1));
        addView(relativeLayout, layoutParams);
        if (c0610Nx.A03() != null) {
            RelativeLayout.LayoutParams muteParams = new RelativeLayout.LayoutParams(AbstractC0604Nr.A06, AbstractC0604Nr.A06);
            muteParams.addRule(10);
            muteParams.addRule(11);
            muteParams.setMargins(AbstractC0604Nr.A05, AbstractC0604Nr.A05 + c0610Nx.A01(), AbstractC0604Nr.A05, AbstractC0604Nr.A05);
            addView(c0610Nx.A03(), muteParams);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0604Nr
    public final void A0Z(C2L c2l, String str, double d, @Nullable Bundle bundle) {
        super.A0Z(c2l, str, d, bundle);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0604Nr
    public final boolean A0b() {
        return true;
    }
}
