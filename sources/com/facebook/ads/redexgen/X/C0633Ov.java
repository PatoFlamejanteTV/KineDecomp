package com.facebook.ads.redexgen.X;

import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* renamed from: com.facebook.ads.redexgen.X.Ov, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0633Ov extends LinearLayout {

    @Nullable
    public LinearLayout A00;
    public final int A01;
    public final C0362Ec A02;
    public final M4 A03;
    public final C0601No A04;
    public static final int A07 = (int) (KE.A01 * 16.0f);
    public static final int A08 = (int) (KE.A01 * 16.0f);
    public static final int A06 = (int) (KE.A01 * 8.0f);
    public static final int A05 = (int) (72.0f * KE.A01);

    public C0633Ov(C0632Ou c0632Ou) {
        super(C0632Ou.A04(c0632Ou));
        this.A02 = C0632Ou.A04(c0632Ou);
        this.A03 = new M4(this.A02);
        this.A04 = new C0601No(this.A02, C0632Ou.A02(c0632Ou), true, false, true);
        this.A01 = C0632Ou.A00(c0632Ou);
        A03(c0632Ou);
    }

    public /* synthetic */ C0633Ov(C0632Ou c0632Ou, C0631Ot c0631Ot) {
        this(c0632Ou);
    }

    private void A00() {
        A01(this.A03, 150);
        A01(this.A04, 170);
        if (this.A00 != null) {
            A01(this.A00, 190);
        }
    }

    private void A01(View view, int i) {
        view.setTranslationY(i);
        view.setScaleY(0.75f);
        view.setScaleX(0.75f);
        view.animate().translationYBy(-i).scaleX(1.0f).scaleY(1.0f).setDuration(300L).setInterpolator(new DecelerateInterpolator(2.0f));
    }

    private void A02(C0632Ou c0632Ou) {
        if (!TextUtils.isEmpty(C0632Ou.A05(c0632Ou))) {
            this.A00 = new LinearLayout(getContext());
            this.A00.setGravity(17);
            this.A00.setPadding(A08, A08 / 2, A08, A08 / 2);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, A08 / 2, 0, 0);
            TextView textView = new TextView(getContext());
            textView.setTextColor(-1);
            KE.A0Y(textView, false, 16);
            textView.setText(C0632Ou.A05(c0632Ou));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            ImageView informativeIconView = new ImageView(getContext());
            new NR(informativeIconView, this.A02).A04().A07(C0632Ou.A06(c0632Ou));
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(A07, A07);
            layoutParams3.setMargins(0, 0, A08 / 2, 0);
            this.A00.addView(informativeIconView, layoutParams3);
            this.A00.addView(textView, layoutParams2);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(100.0f);
            gradientDrawable.setColor(469762047);
            KE.A0T(this.A00, gradientDrawable);
            addView(this.A00, layoutParams);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003d, code lost:            r5 = r5;        r13 = r13;        new com.facebook.ads.redexgen.X.NR(r5.A03, r5.A02).A04().A07(com.facebook.ads.redexgen.X.C0632Ou.A03(r13).A01());        r5.A04.A00(com.facebook.ads.redexgen.X.C0632Ou.A01(r13).A06(), com.facebook.ads.redexgen.X.C0632Ou.A03(r13).A03(), null, false, true);        r5.A04.getDescriptionTextView().setAlpha(0.8f);        r5.A04.setAlignment(17);        r6 = new android.widget.LinearLayout.LayoutParams(-2, -2);        r6.setMargins(0, com.facebook.ads.redexgen.X.C0633Ov.A08, 0, com.facebook.ads.redexgen.X.C0633Ov.A08 / 2);        r5.addView(r5.A03, new android.widget.LinearLayout.LayoutParams(com.facebook.ads.redexgen.X.C0633Ov.A05, com.facebook.ads.redexgen.X.C0633Ov.A05));        r5.addView(r5.A04, r6);        r5.A02(r13);        com.facebook.ads.redexgen.X.KE.A0P(r5, -14473425);        r5.setGravity(17);        r5.setOrientation(1);     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00b0, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A03(com.facebook.ads.redexgen.X.C0632Ou r13) {
        /*
            r12 = this;
            r5 = r12
            r0 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            r4 = 17
            r2 = -2
            r11 = 1
            r10 = 0
            com.facebook.ads.redexgen.X.M4 r0 = r5.A03
            com.facebook.ads.redexgen.X.KE.A0P(r0, r10)
            com.facebook.ads.redexgen.X.M4 r1 = r5.A03
            r0 = 50
            r1.setRadius(r0)
            com.facebook.ads.redexgen.X.2S r0 = com.facebook.ads.redexgen.X.C0632Ou.A01(r13)
            com.facebook.ads.redexgen.X.2Q r1 = r0.A00()
            com.facebook.ads.redexgen.X.2Q r0 = com.facebook.ads.redexgen.X.C2Q.A04
            if (r1 != r0) goto L3b
            r0 = 2
        L23:
            switch(r0) {
                case 2: goto L27;
                case 3: goto L3d;
                case 4: goto L30;
                default: goto L26;
            }
        L26:
            goto L23
        L27:
            com.facebook.ads.redexgen.X.Ov r5 = (com.facebook.ads.redexgen.X.C0633Ov) r5
            com.facebook.ads.redexgen.X.M4 r0 = r5.A03
            r0.setFullCircleCorners(r11)
            r0 = 3
            goto L23
        L30:
            com.facebook.ads.redexgen.X.Ov r5 = (com.facebook.ads.redexgen.X.C0633Ov) r5
            com.facebook.ads.redexgen.X.M4 r1 = r5.A03
            int r0 = com.facebook.ads.redexgen.X.C0633Ov.A06
            r1.setRadius(r0)
            r0 = 3
            goto L23
        L3b:
            r0 = 4
            goto L23
        L3d:
            com.facebook.ads.redexgen.X.Ov r5 = (com.facebook.ads.redexgen.X.C0633Ov) r5
            com.facebook.ads.redexgen.X.Ou r13 = (com.facebook.ads.redexgen.X.C0632Ou) r13
            com.facebook.ads.redexgen.X.NR r3 = new com.facebook.ads.redexgen.X.NR
            com.facebook.ads.redexgen.X.M4 r1 = r5.A03
            com.facebook.ads.redexgen.X.Ec r0 = r5.A02
            r3.<init>(r1, r0)
            com.facebook.ads.redexgen.X.NR r1 = r3.A04()
            com.facebook.ads.redexgen.X.2c r0 = com.facebook.ads.redexgen.X.C0632Ou.A03(r13)
            java.lang.String r0 = r0.A01()
            r1.A07(r0)
            com.facebook.ads.redexgen.X.No r6 = r5.A04
            com.facebook.ads.redexgen.X.2S r0 = com.facebook.ads.redexgen.X.C0632Ou.A01(r13)
            java.lang.String r7 = r0.A06()
            com.facebook.ads.redexgen.X.2c r0 = com.facebook.ads.redexgen.X.C0632Ou.A03(r13)
            java.lang.String r8 = r0.A03()
            r9 = 0
            r6.A00(r7, r8, r9, r10, r11)
            com.facebook.ads.redexgen.X.No r0 = r5.A04
            android.widget.TextView r1 = r0.getDescriptionTextView()
            r0 = 1061997773(0x3f4ccccd, float:0.8)
            r1.setAlpha(r0)
            com.facebook.ads.redexgen.X.No r0 = r5.A04
            r0.setAlignment(r4)
            android.widget.LinearLayout$LayoutParams r6 = new android.widget.LinearLayout$LayoutParams
            r6.<init>(r2, r2)
            int r1 = com.facebook.ads.redexgen.X.C0633Ov.A08
            int r0 = com.facebook.ads.redexgen.X.C0633Ov.A08
            int r0 = r0 / 2
            r6.setMargins(r10, r1, r10, r0)
            com.facebook.ads.redexgen.X.M4 r3 = r5.A03
            android.widget.LinearLayout$LayoutParams r2 = new android.widget.LinearLayout$LayoutParams
            int r1 = com.facebook.ads.redexgen.X.C0633Ov.A05
            int r0 = com.facebook.ads.redexgen.X.C0633Ov.A05
            r2.<init>(r1, r0)
            r5.addView(r3, r2)
            com.facebook.ads.redexgen.X.No r0 = r5.A04
            r5.addView(r0, r6)
            r5.A02(r13)
            r0 = -14473425(0xffffffffff23272f, float:-2.1686762E38)
            com.facebook.ads.redexgen.X.KE.A0P(r5, r0)
            r5.setGravity(r4)
            r5.setOrientation(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0633Ov.A03(com.facebook.ads.redexgen.X.Ou):void");
    }

    public final void A04(LS ls) {
        A00();
        postDelayed(new C0631Ot(this, ls), this.A01);
    }
}
