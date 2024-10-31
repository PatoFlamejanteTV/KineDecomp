package com.facebook.ads.redexgen.X;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.ads.internal.api.AdNativeComponentView;

/* renamed from: com.facebook.ads.redexgen.X.Kv, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0531Kv extends AdNativeComponentView {
    public final LinearLayout A00;
    public final RelativeLayout A01;
    public final RelativeLayout A02;
    public final TextView A03;
    public final TextView A04;
    public final TextView A05;
    public final C0444Hh A06;
    public final M5 A07;
    public static final int A08 = ((int) KE.A01) * 500;
    public static final int A0G = (int) (KE.A01 * 500.0f);
    public static final int A0C = (int) (KE.A01 * 4.0f);
    public static final int A0A = (int) (KE.A01 * 8.0f);
    public static final int A0F = (int) (KE.A01 * 8.0f);
    public static final int A0D = (int) (KE.A01 * 4.0f);
    public static final int A0B = (int) KE.A01;
    public static final int A0E = (int) (KE.A01 * 4.0f);
    public static final int A09 = (int) (KE.A01 * 0.5d);

    public C0531Kv(C0362Ec c0362Ec, C0444Hh c0444Hh) {
        super(c0362Ec);
        this.A06 = c0444Hh;
        this.A05 = new TextView(c0362Ec);
        this.A04 = new TextView(c0362Ec);
        this.A03 = new TextView(c0362Ec);
        this.A02 = new RelativeLayout(c0362Ec);
        this.A00 = new LinearLayout(c0362Ec);
        this.A01 = new RelativeLayout(c0362Ec);
        this.A07 = new M5(c0362Ec);
        A09();
        A0D();
        A05();
        A0A();
        A00();
        A0B();
        A03();
        A0A();
        A08();
        A0C();
    }

    private void A00() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.weight = 1.0f;
        layoutParams.gravity = 1;
        this.A00.addView(this.A01, layoutParams);
    }

    private void A01() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(3, this.A04.getId());
        KE.A0L(this.A03);
        this.A02.addView(this.A03, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        this.A02.setBackgroundDrawable(null);
        this.A02.setPadding(A0F, A0F, A0F, A0F);
        KE.A0L(this.A02);
        this.A00.addView(this.A02, layoutParams2);
    }

    private void A02() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(A0A, A0C, A0A, A0C);
        KE.A0L(this.A03);
        this.A00.addView(this.A03, layoutParams);
    }

    private void A03() {
        this.A01.addView(this.A07, new LinearLayout.LayoutParams(-2, -1));
    }

    private void A04() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(8, this.A07.getId());
        layoutParams.addRule(5, this.A07.getId());
        layoutParams.addRule(7, this.A07.getId());
        this.A02.setPadding(A0F, 0, A0F, 0);
        this.A02.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{-872415232, 0}));
        KE.A0L(this.A02);
        this.A01.addView(this.A02, layoutParams);
    }

    private void A05() {
        addView(this.A00, new LinearLayout.LayoutParams(-2, -2));
    }

    private void A06() {
        this.A05.setTextColor(-1);
        this.A04.setTextColor(-1);
        this.A03.setTextColor(this.A06.A03());
    }

    private void A07() {
        this.A07.setMaxWidth(A0G);
        this.A05.setTextColor(this.A06.A04(0.2f));
        this.A04.setTextColor(this.A06.A04(0.4f));
        this.A03.setTextColor(this.A06.A03());
        ((LinearLayout.LayoutParams) this.A01.getLayoutParams()).gravity = 1;
    }

    private void A08() {
        this.A03.setPadding(A0B, A0B, A0B, A0B);
        this.A03.setTextSize(14.0f);
        KE.A0N(this.A03);
    }

    private void A09() {
        setLayoutParams(new RelativeLayout.LayoutParams(-2, -1));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.A06.A01());
        gradientDrawable.setCornerRadius(A0E);
        gradientDrawable.setStroke(1, this.A06.A02());
        setBackgroundDrawable(gradientDrawable);
        setPadding(A09, A09, A09, A09);
    }

    private void A0A() {
        KE.A0N(this.A01);
    }

    private void A0B() {
        this.A07.setScaleType(ImageView.ScaleType.FIT_XY);
        this.A07.setRadius(new float[]{A0E, A0E, A0E, A0E, 0.0f, 0.0f, 0.0f, 0.0f});
        this.A07.setAdjustViewBounds(true);
        EnumC0489Je.A04(this.A07, EnumC0489Je.A0A);
        KE.A0N(this.A07);
    }

    private void A0C() {
        KE.A0N(this.A02);
        this.A05.setTextSize(14.0f);
        KE.A0N(this.A05);
        this.A05.setMaxLines(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, A0D);
        this.A02.addView(this.A05, layoutParams);
        this.A04.setTextSize(12.0f);
        KE.A0N(this.A04);
        this.A04.setMaxLines(1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(3, this.A05.getId());
        layoutParams2.setMargins(0, 0, 0, A0D);
        this.A02.addView(this.A04, layoutParams2);
    }

    private void A0D() {
        this.A00.setOrientation(1);
        KE.A0N(this.A00);
    }

    public View getAdContentsView() {
        return this.A07;
    }

    public ImageView getImageCardView() {
        return this.A07;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x003b, code lost:            super.onMeasure(r4, r5);     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0040, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onMeasure(int r4, int r5) {
        /*
            r3 = this;
            r2 = r3
            float r0 = com.facebook.ads.redexgen.X.KE.A01
            int r1 = (int) r0
            android.content.Context r0 = r2.getContext()
            int r0 = com.facebook.ads.redexgen.X.C0413Gc.A0A(r0)
            int r1 = r1 * r0
            int r0 = android.view.View.MeasureSpec.getSize(r5)
            if (r0 >= r1) goto L39
            r0 = 2
        L14:
            switch(r0) {
                case 2: goto L18;
                case 3: goto L22;
                case 4: goto L3b;
                case 5: goto L2c;
                default: goto L17;
            }
        L17:
            goto L14
        L18:
            int r0 = android.view.View.MeasureSpec.getMode(r5)
            if (r0 != 0) goto L20
            r0 = 3
            goto L14
        L20:
            r0 = 5
            goto L14
        L22:
            com.facebook.ads.redexgen.X.Kv r2 = (com.facebook.ads.redexgen.X.C0531Kv) r2
            r2.A01()
            r2.A07()
            r0 = 4
            goto L14
        L2c:
            com.facebook.ads.redexgen.X.Kv r2 = (com.facebook.ads.redexgen.X.C0531Kv) r2
            r2.A02()
            r2.A04()
            r2.A06()
            r0 = 4
            goto L14
        L39:
            r0 = 3
            goto L14
        L3b:
            com.facebook.ads.redexgen.X.Kv r2 = (com.facebook.ads.redexgen.X.C0531Kv) r2
            super.onMeasure(r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0531Kv.onMeasure(int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0045, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setButtonText(java.lang.String r6) {
        /*
            r5 = this;
            r4 = r5
            r0 = 0
            r0 = 0
            if (r6 == 0) goto L43
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L1a;
                case 4: goto L45;
                case 5: goto L25;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r0 = r6.trim()
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L18
            r0 = 3
            goto L6
        L18:
            r0 = 5
            goto L6
        L1a:
            com.facebook.ads.redexgen.X.Kv r4 = (com.facebook.ads.redexgen.X.C0531Kv) r4
            android.widget.TextView r1 = r4.A03
            r0 = 8
            r1.setVisibility(r0)
            r0 = 4
            goto L6
        L25:
            com.facebook.ads.redexgen.X.Kv r4 = (com.facebook.ads.redexgen.X.C0531Kv) r4
            java.lang.String r6 = (java.lang.String) r6
            r3 = 0
            android.text.SpannableString r2 = new android.text.SpannableString
            r2.<init>(r6)
            android.text.style.StyleSpan r1 = new android.text.style.StyleSpan
            r0 = 1
            r1.<init>(r0)
            int r0 = r2.length()
            r2.setSpan(r1, r3, r0, r3)
            android.widget.TextView r0 = r4.A03
            r0.setText(r2)
            r0 = 4
            goto L6
        L43:
            r0 = 3
            goto L6
        L45:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0531Kv.setButtonText(java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0025, code lost:            r2.A04.setText(r4);     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002e, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setSubtitle(java.lang.String r4) {
        /*
            r3 = this;
            r2 = r3
            if (r4 == 0) goto L23
            r0 = 2
        L4:
            switch(r0) {
                case 2: goto L8;
                case 3: goto L18;
                case 4: goto L25;
                default: goto L7;
            }
        L7:
            goto L4
        L8:
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r0 = r4.trim()
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L16
            r0 = 3
            goto L4
        L16:
            r0 = 4
            goto L4
        L18:
            com.facebook.ads.redexgen.X.Kv r2 = (com.facebook.ads.redexgen.X.C0531Kv) r2
            android.widget.TextView r1 = r2.A04
            r0 = 8
            r1.setVisibility(r0)
            r0 = 4
            goto L4
        L23:
            r0 = 3
            goto L4
        L25:
            com.facebook.ads.redexgen.X.Kv r2 = (com.facebook.ads.redexgen.X.C0531Kv) r2
            java.lang.String r4 = (java.lang.String) r4
            android.widget.TextView r0 = r2.A04
            r0.setText(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0531Kv.setSubtitle(java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0025, code lost:            r2.A05.setText(r4);     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002e, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setTitle(java.lang.String r4) {
        /*
            r3 = this;
            r2 = r3
            if (r4 == 0) goto L23
            r0 = 2
        L4:
            switch(r0) {
                case 2: goto L8;
                case 3: goto L18;
                case 4: goto L25;
                default: goto L7;
            }
        L7:
            goto L4
        L8:
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r0 = r4.trim()
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L16
            r0 = 3
            goto L4
        L16:
            r0 = 4
            goto L4
        L18:
            com.facebook.ads.redexgen.X.Kv r2 = (com.facebook.ads.redexgen.X.C0531Kv) r2
            android.widget.TextView r1 = r2.A05
            r0 = 8
            r1.setVisibility(r0)
            r0 = 4
            goto L4
        L23:
            r0 = 3
            goto L4
        L25:
            com.facebook.ads.redexgen.X.Kv r2 = (com.facebook.ads.redexgen.X.C0531Kv) r2
            java.lang.String r4 = (java.lang.String) r4
            android.widget.TextView r0 = r2.A05
            r0.setText(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0531Kv.setTitle(java.lang.String):void");
    }
}
