package com.facebook.ads.redexgen.X;

import android.widget.LinearLayout;

/* renamed from: com.facebook.ads.redexgen.X.Nk, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0597Nk extends LinearLayout {
    public static final int A06 = (int) (4.0f * KE.A01);
    public int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final C0362Ec A04;
    public final C0598Nl[] A05;

    public C0597Nk(C0362Ec c0362Ec, int i, int i2, int i3, int i4) {
        super(c0362Ec);
        this.A00 = A06;
        this.A04 = c0362Ec;
        setOrientation(0);
        this.A03 = i;
        this.A01 = i3;
        this.A02 = i4;
        this.A05 = new C0598Nl[i2];
        for (int i5 = 0; i5 < i2; i5++) {
            this.A05[i5] = A00();
            addView(this.A05[i5]);
        }
        A01();
    }

    private C0598Nl A00() {
        C0598Nl c0598Nl = new C0598Nl(this.A04, this.A01, this.A02);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.A03, this.A03);
        layoutParams.gravity = 16;
        c0598Nl.setLayoutParams(layoutParams);
        return c0598Nl;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0038, code lost:            r4.requestLayout();     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x003d, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A01() {
        /*
            r5 = this;
            r4 = r5
            r3 = 0
            r2 = 0
            r0 = 0
            r1 = 0
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto L2d;
                case 3: goto L1b;
                case 4: goto L18;
                case 5: goto L10;
                case 6: goto La;
                case 7: goto L38;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.Nk r4 = (com.facebook.ads.redexgen.X.C0597Nk) r4
            int r2 = r4.A00
            r0 = 5
            goto L6
        L10:
            android.widget.LinearLayout$LayoutParams r3 = (android.widget.LinearLayout.LayoutParams) r3
            r3.leftMargin = r2
            int r1 = r1 + 1
            r0 = 2
            goto L6
        L18:
            r2 = 0
            r0 = 5
            goto L6
        L1b:
            com.facebook.ads.redexgen.X.Nk r4 = (com.facebook.ads.redexgen.X.C0597Nk) r4
            com.facebook.ads.redexgen.X.Nl[] r0 = r4.A05
            r0 = r0[r1]
            android.view.ViewGroup$LayoutParams r3 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r3 = (android.widget.LinearLayout.LayoutParams) r3
            if (r1 != 0) goto L2b
            r0 = 4
            goto L6
        L2b:
            r0 = 6
            goto L6
        L2d:
            com.facebook.ads.redexgen.X.Nk r4 = (com.facebook.ads.redexgen.X.C0597Nk) r4
            com.facebook.ads.redexgen.X.Nl[] r0 = r4.A05
            int r0 = r0.length
            if (r1 >= r0) goto L36
            r0 = 3
            goto L6
        L36:
            r0 = 7
            goto L6
        L38:
            com.facebook.ads.redexgen.X.Nk r4 = (com.facebook.ads.redexgen.X.C0597Nk) r4
            r4.requestLayout()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0597Nk.A01():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0036, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A02(float r5) {
        /*
            r4 = this;
            r3 = r4
            r1 = 0
            r0 = 0
            r2 = 0
            r0 = 2
        L5:
            switch(r0) {
                case 2: goto L9;
                case 3: goto L14;
                case 4: goto L26;
                case 5: goto L29;
                case 6: goto L36;
                default: goto L8;
            }
        L8:
            goto L5
        L9:
            com.facebook.ads.redexgen.X.Nk r3 = (com.facebook.ads.redexgen.X.C0597Nk) r3
            com.facebook.ads.redexgen.X.Nl[] r0 = r3.A05
            int r0 = r0.length
            if (r2 >= r0) goto L12
            r0 = 3
            goto L5
        L12:
            r0 = 6
            goto L5
        L14:
            r1 = 1065353216(0x3f800000, float:1.0)
            float r0 = (float) r2
            float r0 = r5 - r0
            float r1 = java.lang.Math.min(r1, r0)
            r0 = 0
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 >= 0) goto L24
            r0 = 4
            goto L5
        L24:
            r0 = 5
            goto L5
        L26:
            r1 = 0
            r0 = 5
            goto L5
        L29:
            com.facebook.ads.redexgen.X.Nk r3 = (com.facebook.ads.redexgen.X.C0597Nk) r3
            com.facebook.ads.redexgen.X.Nl[] r0 = r3.A05
            r0 = r0[r2]
            r0.setFillRatio(r1)
            int r2 = r2 + 1
            r0 = 2
            goto L5
        L36:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0597Nk.A02(float):void");
    }

    public void setItemSpacing(int i) {
        this.A00 = i;
        A01();
    }

    public void setRating(float f) {
        A02(f);
    }
}
