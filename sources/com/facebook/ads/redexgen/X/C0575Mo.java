package com.facebook.ads.redexgen.X;

import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* renamed from: com.facebook.ads.redexgen.X.Mo, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0575Mo extends MZ {
    public final HorizontalScrollView A00;
    public final ImageView A01;
    public final LinearLayout A02;
    public final LinearLayout A03;
    public final C0362Ec A04;
    public static final int A07 = (int) (4.0f * KE.A01);
    public static final int A06 = (int) (10.0f * KE.A01);
    public static final int A05 = (int) (44.0f * KE.A01);

    public C0575Mo(C0362Ec c0362Ec, InterfaceC0422Gl interfaceC0422Gl, String str) {
        super(c0362Ec, interfaceC0422Gl, str);
        this.A04 = c0362Ec;
        this.A01 = new ImageView(getContext());
        this.A01.setPadding(A06, A06, A06, A06);
        this.A01.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.A01.setColorFilter(-10459280);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(A05, A05);
        layoutParams.gravity = 16;
        this.A02 = new LinearLayout(getContext());
        this.A02.setOrientation(0);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 17;
        this.A00 = new HorizontalScrollView(getContext());
        this.A00.setHorizontalScrollBarEnabled(false);
        this.A00.setLayoutParams(layoutParams2);
        this.A00.addView(this.A02, layoutParams2);
        this.A03 = new LinearLayout(getContext());
        this.A03.setOrientation(0);
        KE.A0P(this.A03, -218103809);
        this.A03.setMotionEventSplittingEnabled(false);
        this.A03.addView(this.A01, layoutParams);
        this.A03.addView(this.A00, layoutParams2);
        addView(this.A03, new FrameLayout.LayoutParams(-1, -1));
        this.A03.setClickable(true);
    }

    @Override // com.facebook.ads.redexgen.X.MZ
    public final void A0K() {
        this.A01.setImageBitmap(KN.A00(KM.CROSS));
        this.A01.setOnClickListener(new ViewOnClickListenerC0569Mi(this));
        C0564Mc c0564Mc = new C0564Mc(this.A04);
        c0564Mc.setData(AnonymousClass43.A0B(this.A04.A00()), KM.HIDE_AD);
        c0564Mc.setOnClickListener(new ViewOnClickListenerC0570Mj(this, c0564Mc));
        C0564Mc c0564Mc2 = new C0564Mc(this.A04);
        c0564Mc2.setData(AnonymousClass43.A0F(this.A04.A00()), KM.REPORT_AD);
        c0564Mc2.setOnClickListener(new ViewOnClickListenerC0571Mk(this, c0564Mc2));
        C0564Mc c0564Mc3 = new C0564Mc(this.A04);
        c0564Mc3.setData(AnonymousClass43.A0G(this.A04.A00()), KM.AD_CHOICES_ICON);
        c0564Mc3.setOnClickListener(new ViewOnClickListenerC0572Ml(this, c0564Mc3));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, A07, A07, A07);
        KE.A0U(this.A03);
        this.A02.removeAllViews();
        this.A02.addView(c0564Mc, layoutParams);
        this.A02.addView(c0564Mc2, layoutParams);
        this.A02.addView(c0564Mc3, layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.MZ
    public final void A0L() {
        KE.A0K(this);
        KE.A0L(this);
    }

    @Override // com.facebook.ads.redexgen.X.MZ
    public final void A0M(AnonymousClass46 anonymousClass46, AnonymousClass44 anonymousClass44) {
        this.A01.setOnClickListener(null);
        TextView textView = new TextView(getContext());
        KE.A0Y(textView, true, 14);
        textView.setText(AnonymousClass43.A07(this.A04.A00()));
        textView.setGravity(17);
        KE.A0U(this.A03);
        this.A03.removeAllViews();
        this.A03.addView(textView, new LinearLayout.LayoutParams(-1, -1));
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x007c, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.MZ
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0N(com.facebook.ads.redexgen.X.AnonymousClass46 r8, com.facebook.ads.redexgen.X.AnonymousClass44 r9) {
        /*
            r7 = this;
            r6 = r7
            r0 = 0
            r0 = 0
            r2 = -2
            android.widget.LinearLayout r0 = r6.A03
            com.facebook.ads.redexgen.X.KE.A0U(r0)
            android.widget.ImageView r1 = r6.A01
            com.facebook.ads.redexgen.X.KM r0 = com.facebook.ads.redexgen.X.KM.BACK_ARROW
            android.graphics.Bitmap r0 = com.facebook.ads.redexgen.X.KN.A00(r0)
            r1.setImageBitmap(r0)
            android.widget.ImageView r1 = r6.A01
            com.facebook.ads.redexgen.X.Mm r0 = new com.facebook.ads.redexgen.X.Mm
            r0.<init>(r6)
            r1.setOnClickListener(r0)
            android.widget.LinearLayout r0 = r6.A02
            r0.removeAllViews()
            android.widget.HorizontalScrollView r1 = r6.A00
            r0 = 17
            r1.fullScroll(r0)
            android.widget.LinearLayout$LayoutParams r5 = new android.widget.LinearLayout$LayoutParams
            r5.<init>(r2, r2)
            r3 = 0
            int r2 = com.facebook.ads.redexgen.X.C0575Mo.A07
            int r1 = com.facebook.ads.redexgen.X.C0575Mo.A07
            int r0 = com.facebook.ads.redexgen.X.C0575Mo.A07
            r5.setMargins(r3, r2, r1, r0)
            java.util.List r0 = r8.A05()
            java.util.Iterator r4 = r0.iterator()
            r0 = 2
        L42:
            switch(r0) {
                case 2: goto L46;
                case 3: goto L52;
                case 4: goto L7c;
                default: goto L45;
            }
        L45:
            goto L42
        L46:
            java.util.Iterator r4 = (java.util.Iterator) r4
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L50
            r0 = 3
            goto L42
        L50:
            r0 = 4
            goto L42
        L52:
            com.facebook.ads.redexgen.X.Mo r6 = (com.facebook.ads.redexgen.X.C0575Mo) r6
            android.widget.LinearLayout$LayoutParams r5 = (android.widget.LinearLayout.LayoutParams) r5
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r3 = r4.next()
            com.facebook.ads.redexgen.X.46 r3 = (com.facebook.ads.redexgen.X.AnonymousClass46) r3
            com.facebook.ads.redexgen.X.Mc r2 = new com.facebook.ads.redexgen.X.Mc
            com.facebook.ads.redexgen.X.Ec r0 = r6.A04
            r2.<init>(r0)
            java.lang.String r1 = r3.A04()
            r0 = 0
            r2.setData(r1, r0)
            com.facebook.ads.redexgen.X.Mn r0 = new com.facebook.ads.redexgen.X.Mn
            r0.<init>(r6, r2, r3)
            r2.setOnClickListener(r0)
            android.widget.LinearLayout r0 = r6.A02
            r0.addView(r2, r5)
            r0 = 2
            goto L42
        L7c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0575Mo.A0N(com.facebook.ads.redexgen.X.46, com.facebook.ads.redexgen.X.44):void");
    }

    @Override // com.facebook.ads.redexgen.X.MZ
    public final boolean A0O() {
        return true;
    }
}
