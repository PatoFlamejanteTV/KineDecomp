package com.facebook.ads.redexgen.X;

import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/* renamed from: com.facebook.ads.redexgen.X.Pa, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0638Pa extends NW {
    public static final int A04 = (int) (12.0f * KE.A01);
    public static final int A05 = (int) (16.0f * KE.A01);
    public int A00;
    public boolean A01;
    public boolean A02;
    public final C0601No A03;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0638Pa(C0362Ec c0362Ec, int i, C2T c2t, InterfaceC0422Gl interfaceC0422Gl, AnonymousClass81 anonymousClass81, boolean z, boolean z2, FP fp, K5 k5, boolean z3) {
        super(c0362Ec, i, c2t, EnumC0666Qc.A04.A02(), interfaceC0422Gl, anonymousClass81, fp, k5);
        boolean z4 = z;
        this.A02 = false;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
        layoutParams.addRule(9);
        layoutParams.setMargins(0, 0, A04, 0);
        if (z2) {
            this.A04.setVisibility(8);
        }
        this.A00 = KE.A03(c0362Ec);
        this.A01 = z3;
        boolean isLandscape = (this.A00 == 2) && this.A01;
        this.A03 = new C0601No(c0362Ec, c2t, true, isLandscape ? true : z4, true);
        this.A03.setUseNewLandscapeEndCard(this.A01);
        this.A03.setAlignment(8388611);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(1, this.A04.getId());
        if (!this.A01) {
            layoutParams.addRule(15);
            layoutParams2.addRule(15);
        }
        super.A01.addView(this.A04, layoutParams);
        super.A01.addView(this.A03, layoutParams2);
        if (isLandscape) {
            addView(super.A01, new LinearLayout.LayoutParams(-2, -1, 0.7f));
            return;
        }
        addView(super.A01, new LinearLayout.LayoutParams(-2, -2));
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, -15658735});
        gradientDrawable.setCornerRadius(0.0f);
        KE.A0T(this, gradientDrawable);
    }

    @Override // com.facebook.ads.redexgen.X.NW
    public final void A08(int i) {
        LinearLayout.LayoutParams layoutParams;
        KE.A0L(super.A03);
        boolean z = i == 1;
        if (this.A01) {
            this.A00 = i;
            setOrientation(1);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            if (this.A02 && !z) {
                layoutParams2.weight = 0.7f;
                setBackgroundResource(0);
                KE.A0P(this, -447721392);
            } else {
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, -15658735});
                gradientDrawable.setCornerRadius(0.0f);
                KE.A0T(this, gradientDrawable);
            }
            super.A01.setLayoutParams(layoutParams2);
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, A05, 0, 0);
            bringToFront();
        } else {
            setOrientation(z ? 1 : 0);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(z ? -1 : 0, -2);
            layoutParams3.weight = 1.0f;
            layoutParams = new LinearLayout.LayoutParams(z ? -1 : -2, -2);
            layoutParams.setMargins(z ? 0 : A05, z ? A05 : 0, 0, 0);
            super.A01.setLayoutParams(layoutParams3);
        }
        layoutParams.gravity = 80;
        addView(super.A03, layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.NW
    public final void A09(boolean z) {
        this.A02 = z;
    }

    @Override // com.facebook.ads.redexgen.X.NW
    public void setInfo(C2S c2s, C2U c2u, String str, String str2, @Nullable NZ nz) {
        super.setInfo(c2s, c2u, str, str2, nz);
        this.A03.A00(c2s.A06(), c2s.A05(), null, false, false);
        if (TextUtils.isEmpty(c2u.A03())) {
            KE.A0J(super.A03);
        }
    }
}
