package com.facebook.ads.redexgen.X;

import android.graphics.drawable.GradientDrawable;
import android.widget.ImageView;
import android.widget.LinearLayout;

/* renamed from: com.facebook.ads.redexgen.X.Kn, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0523Kn extends LinearLayout {
    public final ImageView A00;
    public final ImageView A01;
    public final C0362Ec A02;
    public static final int A05 = (int) (50.0f * KE.A01);
    public static final int A03 = (int) (10.0f * KE.A01);
    public static final int A04 = (int) (20.0f * KE.A01);
    public static final int A06 = (int) (4.0f * KE.A01);

    public C0523Kn(C0362Ec c0362Ec, int i) {
        super(c0362Ec);
        this.A02 = c0362Ec;
        setOrientation(0);
        setPadding(A03, A03, A03, A03);
        this.A00 = new ImageView(c0362Ec);
        this.A01 = new ImageView(c0362Ec);
        A01(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001c, code lost:            r4 = r5;        A02(r4.A01, r2);        r4.addView(r4.A01, new android.widget.LinearLayout.LayoutParams(com.facebook.ads.redexgen.X.C0523Kn.A04, com.facebook.ads.redexgen.X.C0523Kn.A04));        r2 = new android.widget.LinearLayout.LayoutParams(com.facebook.ads.redexgen.X.C0523Kn.A04, com.facebook.ads.redexgen.X.C0523Kn.A04);        r2.setMargins(com.facebook.ads.redexgen.X.C0523Kn.A06, 0, 0, 0);        r4.addView(r4.A00, r2);     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0048, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A01(int r6) {
        /*
            r5 = this;
            r2 = 0
            r0 = 0
            r0 = 0
            android.widget.ImageView r1 = r5.A00
            com.facebook.ads.redexgen.X.KM r0 = com.facebook.ads.redexgen.X.KM.AD_CHOICES_ICON
            A02(r1, r0)
            r0 = 1
            if (r6 != r0) goto L1a
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L12;
                case 3: goto L1c;
                case 4: goto L16;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            com.facebook.ads.redexgen.X.KM r2 = com.facebook.ads.redexgen.X.KM.AN_INFO_ICON
            r0 = 3
            goto Le
        L16:
            com.facebook.ads.redexgen.X.KM r2 = com.facebook.ads.redexgen.X.KM.DEFAULT_INFO_ICON
            r0 = 3
            goto Le
        L1a:
            r0 = 4
            goto Le
        L1c:
            r4 = r5
            com.facebook.ads.redexgen.X.Kn r4 = (com.facebook.ads.redexgen.X.C0523Kn) r4
            com.facebook.ads.redexgen.X.KM r2 = (com.facebook.ads.redexgen.X.KM) r2
            r3 = 0
            android.widget.ImageView r0 = r4.A01
            A02(r0, r2)
            android.widget.LinearLayout$LayoutParams r2 = new android.widget.LinearLayout$LayoutParams
            int r1 = com.facebook.ads.redexgen.X.C0523Kn.A04
            int r0 = com.facebook.ads.redexgen.X.C0523Kn.A04
            r2.<init>(r1, r0)
            android.widget.ImageView r0 = r4.A01
            r4.addView(r0, r2)
            android.widget.LinearLayout$LayoutParams r2 = new android.widget.LinearLayout$LayoutParams
            int r1 = com.facebook.ads.redexgen.X.C0523Kn.A04
            int r0 = com.facebook.ads.redexgen.X.C0523Kn.A04
            r2.<init>(r1, r0)
            int r0 = com.facebook.ads.redexgen.X.C0523Kn.A06
            r2.setMargins(r0, r3, r3, r3)
            android.widget.ImageView r0 = r4.A00
            r4.addView(r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0523Kn.A01(int):void");
    }

    public static void A02(ImageView imageView, KM km) {
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setImageBitmap(KN.A00(km));
        imageView.setColorFilter(-1);
    }

    public void setAdDetails(C00572c c00572c, String str, C0432Gv c0432Gv, AnonymousClass81 anonymousClass81) {
        setOnClickListener(new ViewOnClickListenerC0522Km(this, c0432Gv, anonymousClass81, str, c00572c));
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(A05);
        gradientDrawable.setColor(i);
        KE.A0T(this, gradientDrawable);
    }

    public void setIconColors(int i) {
        this.A00.setColorFilter(i);
        this.A01.setColorFilter(i);
    }
}
