package com.facebook.ads.redexgen.X;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

/* renamed from: com.facebook.ads.redexgen.X.My, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0585My extends MZ {
    public final ImageView A00;
    public final LinearLayout A01;
    public final ScrollView A02;
    public final C0362Ec A03;
    public static final int A06 = (int) (8.0f * KE.A01);
    public static final int A05 = (int) (10.0f * KE.A01);
    public static final int A04 = (int) (44.0f * KE.A01);

    public C0585My(C0362Ec c0362Ec, InterfaceC0422Gl interfaceC0422Gl, String str) {
        super(c0362Ec, interfaceC0422Gl, str);
        this.A03 = c0362Ec;
        this.A00 = new ImageView(getContext());
        this.A00.setPadding(A05, A05, A05, A05);
        this.A00.setColorFilter(-10459280);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(A04, A04);
        layoutParams.gravity = 3;
        this.A00.setLayoutParams(layoutParams);
        this.A02 = new ScrollView(getContext());
        this.A02.setFillViewport(true);
        KE.A0P(this.A02, -218103809);
        this.A01 = new LinearLayout(getContext());
        this.A01.setOrientation(1);
        this.A01.setPadding(A06, A06, A06, A06);
        this.A02.addView(this.A01, new FrameLayout.LayoutParams(-1, -2));
        addView(this.A02, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.facebook.ads.redexgen.X.MZ
    public final void A0K() {
        this.A00.setImageBitmap(KN.A00(KM.CROSS));
        this.A00.setOnClickListener(new ViewOnClickListenerC0580Mt(this));
        C0564Mc c0564Mc = new C0564Mc(this.A03);
        c0564Mc.setData(AnonymousClass43.A0B(this.A03.A00()), KM.HIDE_AD);
        c0564Mc.setOnClickListener(new ViewOnClickListenerC0581Mu(this, c0564Mc));
        C0564Mc c0564Mc2 = new C0564Mc(this.A03);
        c0564Mc2.setData(AnonymousClass43.A0F(this.A03.A00()), KM.REPORT_AD);
        c0564Mc2.setOnClickListener(new ViewOnClickListenerC0582Mv(this, c0564Mc2));
        C0564Mc c0564Mc3 = new C0564Mc(this.A03);
        c0564Mc3.setData(AnonymousClass43.A0G(this.A03.A00()), KM.AD_CHOICES_ICON);
        c0564Mc3.setOnClickListener(new ViewOnClickListenerC0583Mw(this, c0564Mc3));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(A06, A06, A06, A06);
        layoutParams.gravity = 17;
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, 0);
        layoutParams2.gravity = 17;
        layoutParams2.weight = 1.0f;
        KE.A0U(this.A01);
        this.A01.removeAllViews();
        this.A01.addView(this.A00);
        this.A01.addView(linearLayout, layoutParams2);
        linearLayout.addView(c0564Mc, layoutParams);
        linearLayout.addView(c0564Mc2, layoutParams);
        linearLayout.addView(c0564Mc3, layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.MZ
    public final void A0L() {
        KE.A0K(this);
        KE.A0L(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003d, code lost:            r4 = r4;        r3 = new com.facebook.ads.redexgen.X.MV(r4.A03, r4.A0A).A0I(r7).A0H(com.facebook.ads.redexgen.X.AnonymousClass43.A07(r4.A03.A00())).A0F(r9.A04()).A0K(false).A0E(r3).A0D(r2).A0L(false).A0J(false).A0M();        r2 = new android.widget.LinearLayout.LayoutParams(-1, 0);        r2.gravity = 17;        r2.weight = 1.0f;        com.facebook.ads.redexgen.X.KE.A0U(r4.A01);        r4.A02.fullScroll(33);        r4.A01.removeAllViews();        r4.A01.addView(r3, r2);     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00a5, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.MZ
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0M(com.facebook.ads.redexgen.X.AnonymousClass46 r9, com.facebook.ads.redexgen.X.AnonymousClass44 r10) {
        /*
            r8 = this;
            r4 = r8
            r2 = 0
            r7 = 0
            r3 = 0
            r0 = 0
            r0 = 0
            android.widget.ImageView r1 = r4.A00
            r0 = 0
            r1.setOnClickListener(r0)
            com.facebook.ads.redexgen.X.44 r0 = com.facebook.ads.redexgen.X.AnonymousClass44.A05
            if (r10 != r0) goto L3b
            r0 = 2
        L11:
            switch(r0) {
                case 2: goto L15;
                case 3: goto L3d;
                case 4: goto L28;
                default: goto L14;
            }
        L14:
            goto L11
        L15:
            com.facebook.ads.redexgen.X.My r4 = (com.facebook.ads.redexgen.X.C0585My) r4
            com.facebook.ads.redexgen.X.Ec r0 = r4.A03
            com.facebook.ads.redexgen.X.Ef r0 = r0.A00()
            java.lang.String r7 = com.facebook.ads.redexgen.X.AnonymousClass43.A09(r0)
            com.facebook.ads.redexgen.X.KM r3 = com.facebook.ads.redexgen.X.KM.REPORT_AD
            r2 = -552389(0xfffffffffff7923b, float:NaN)
            r0 = 3
            goto L11
        L28:
            com.facebook.ads.redexgen.X.My r4 = (com.facebook.ads.redexgen.X.C0585My) r4
            com.facebook.ads.redexgen.X.Ec r0 = r4.A03
            com.facebook.ads.redexgen.X.Ef r0 = r0.A00()
            java.lang.String r7 = com.facebook.ads.redexgen.X.AnonymousClass43.A0B(r0)
            com.facebook.ads.redexgen.X.KM r3 = com.facebook.ads.redexgen.X.KM.HIDE_AD
            r2 = -13272859(0xffffffffff3578e5, float:-2.4121799E38)
            r0 = 3
            goto L11
        L3b:
            r0 = 4
            goto L11
        L3d:
            com.facebook.ads.redexgen.X.My r4 = (com.facebook.ads.redexgen.X.C0585My) r4
            com.facebook.ads.redexgen.X.46 r9 = (com.facebook.ads.redexgen.X.AnonymousClass46) r9
            java.lang.String r7 = (java.lang.String) r7
            com.facebook.ads.redexgen.X.KM r3 = (com.facebook.ads.redexgen.X.KM) r3
            r5 = 0
            com.facebook.ads.redexgen.X.MV r6 = new com.facebook.ads.redexgen.X.MV
            com.facebook.ads.redexgen.X.Ec r1 = r4.A03
            com.facebook.ads.redexgen.X.MX r0 = r4.A0A
            r6.<init>(r1, r0)
            com.facebook.ads.redexgen.X.MV r1 = r6.A0I(r7)
            com.facebook.ads.redexgen.X.Ec r0 = r4.A03
            com.facebook.ads.redexgen.X.Ef r0 = r0.A00()
            java.lang.String r0 = com.facebook.ads.redexgen.X.AnonymousClass43.A07(r0)
            com.facebook.ads.redexgen.X.MV r1 = r1.A0H(r0)
            java.lang.String r0 = r9.A04()
            com.facebook.ads.redexgen.X.MV r0 = r1.A0F(r0)
            com.facebook.ads.redexgen.X.MV r0 = r0.A0K(r5)
            com.facebook.ads.redexgen.X.MV r0 = r0.A0E(r3)
            com.facebook.ads.redexgen.X.MV r0 = r0.A0D(r2)
            com.facebook.ads.redexgen.X.MV r0 = r0.A0L(r5)
            com.facebook.ads.redexgen.X.MV r0 = r0.A0J(r5)
            com.facebook.ads.redexgen.X.MW r3 = r0.A0M()
            android.widget.LinearLayout$LayoutParams r2 = new android.widget.LinearLayout$LayoutParams
            r0 = -1
            r2.<init>(r0, r5)
            r0 = 17
            r2.gravity = r0
            r0 = 1065353216(0x3f800000, float:1.0)
            r2.weight = r0
            android.widget.LinearLayout r0 = r4.A01
            com.facebook.ads.redexgen.X.KE.A0U(r0)
            android.widget.ScrollView r1 = r4.A02
            r0 = 33
            r1.fullScroll(r0)
            android.widget.LinearLayout r0 = r4.A01
            r0.removeAllViews()
            android.widget.LinearLayout r0 = r4.A01
            r0.addView(r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0585My.A0M(com.facebook.ads.redexgen.X.46, com.facebook.ads.redexgen.X.44):void");
    }

    @Override // com.facebook.ads.redexgen.X.MZ
    public final void A0N(AnonymousClass46 anonymousClass46, AnonymousClass44 anonymousClass44) {
        C0579Ms c0579Ms = new C0579Ms(this.A03, anonymousClass46, this.A0A, anonymousClass44 == AnonymousClass44.A05 ? KM.REPORT_AD : KM.HIDE_AD);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, 0);
        layoutParams.gravity = 17;
        layoutParams.weight = 1.0f;
        this.A00.setImageBitmap(KN.A00(KM.BACK_ARROW));
        this.A00.setOnClickListener(new ViewOnClickListenerC0584Mx(this));
        KE.A0U(this.A01);
        this.A02.fullScroll(33);
        this.A01.removeAllViews();
        this.A01.addView(this.A00);
        this.A01.addView(c0579Ms, layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.MZ
    public final boolean A0O() {
        return true;
    }
}
