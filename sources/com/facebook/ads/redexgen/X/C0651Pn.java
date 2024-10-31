package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeBannerAd;
import java.util.ArrayList;

/* renamed from: com.facebook.ads.redexgen.X.Pn, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0651Pn extends LinearLayout implements InterfaceC0650Pm {
    public final NativeBannerAd A00;
    public final C0362Ec A01;
    public final ArrayList<View> A02;
    public static final int A04 = (int) (KE.A01 * 42.0f);
    public static final int A03 = (int) (KE.A01 * 48.0f);
    public static final int A05 = (int) (KE.A01 * 54.0f);
    public static final int A07 = (int) (KE.A01 * 4.0f);
    public static final int A06 = (int) (KE.A01 * 8.0f);

    public C0651Pn(C0362Ec c0362Ec, NativeBannerAd nativeBannerAd, C0444Hh c0444Hh, EnumC0445Hi enumC0445Hi, MediaView mediaView, AdOptionsView adOptionsView) {
        super(c0362Ec);
        LinearLayout.LayoutParams contentViewParams;
        ViewGroup.LayoutParams layoutParams;
        this.A02 = new ArrayList<>();
        this.A00 = nativeBannerAd;
        this.A01 = c0362Ec;
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        int A00 = A00(enumC0445Hi);
        C0596Nj c0596Nj = new C0596Nj(this.A01);
        c0596Nj.setFullCircleCorners(true);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(A00, A00);
        layoutParams2.gravity = 16;
        c0596Nj.addView((View) mediaView, (ViewGroup.LayoutParams) new LinearLayout.LayoutParams(-1, -1));
        linearLayout.addView(c0596Nj, layoutParams2);
        C0648Pk c0648Pk = new C0648Pk(c0362Ec, this.A00, enumC0445Hi, c0444Hh, adOptionsView);
        c0648Pk.setPadding(A06, 0, 0, 0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
        layoutParams3.weight = 1.0f;
        layoutParams3.gravity = 16;
        linearLayout.addView(c0648Pk, layoutParams3);
        if (enumC0445Hi == EnumC0445Hi.A0A) {
            setPadding(A07, A07, A07, A07);
            setOrientation(0);
            contentViewParams = new LinearLayout.LayoutParams(0, -1);
            layoutParams = new LinearLayout.LayoutParams(-2, -1);
            linearLayout.setPadding(0, 0, A07, 0);
        } else {
            setPadding(A06, A06, A06, A06);
            setOrientation(1);
            contentViewParams = new LinearLayout.LayoutParams(-1, 0);
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
            linearLayout.setPadding(0, 0, 0, A06);
        }
        contentViewParams.weight = 1.0f;
        addView(linearLayout, contentViewParams);
        TextView ctaButton = new TextView(getContext());
        ctaButton.setPadding(A06, A07, A06, A07);
        c0444Hh.A05(ctaButton);
        ctaButton.setText(this.A00.getAdCallToAction());
        addView(ctaButton, layoutParams);
        this.A02.add(mediaView);
        this.A02.add(ctaButton);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0021, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A00(com.facebook.ads.redexgen.X.EnumC0445Hi r3) {
        /*
            r2 = 0
            int[] r1 = com.facebook.ads.redexgen.X.C0649Pl.A00
            int r0 = r3.ordinal()
            r0 = r1[r0]
            switch(r0) {
                case 1: goto L1f;
                case 2: goto L1d;
                default: goto Lc;
            }
        Lc:
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L11;
                case 3: goto L21;
                case 4: goto L15;
                case 5: goto L19;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            int r2 = com.facebook.ads.redexgen.X.C0651Pn.A05
            r0 = 3
            goto Ld
        L15:
            int r2 = com.facebook.ads.redexgen.X.C0651Pn.A04
            r0 = 3
            goto Ld
        L19:
            int r2 = com.facebook.ads.redexgen.X.C0651Pn.A03
            r0 = 3
            goto Ld
        L1d:
            r0 = 5
            goto Ld
        L1f:
            r0 = 4
            goto Ld
        L21:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0651Pn.A00(com.facebook.ads.redexgen.X.Hi):int");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0650Pm
    public View getView() {
        return this;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0650Pm
    public ArrayList<View> getViewsForInteraction() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0650Pm
    public final void unregisterView() {
        this.A00.unregisterView();
    }
}
