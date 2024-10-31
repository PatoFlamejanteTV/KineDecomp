package com.facebook.ads.redexgen.X;

import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import java.util.HashMap;

/* loaded from: assets/audience_network.dex */
public final class OG extends FrameLayout {
    public static byte[] A04;
    public static final int A05;
    public static final int A06;
    public static final int A07;
    public static final int A08;
    public static final int A09;
    public static final int A0A;
    public final int A00;
    public final RelativeLayout A01;
    public final ViewOnClickListenerC0589Nc A02;
    public final C0610Nx A03;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.OG.A04
            int r0 = r2 + r3
            byte[] r2 = java.util.Arrays.copyOfRange(r1, r2, r0)
            r1 = 0
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L19;
                case 4: goto L27;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            byte[] r2 = (byte[]) r2
            int r0 = r2.length
            if (r1 >= r0) goto L17
            r0 = 3
            goto Lc
        L17:
            r0 = 4
            goto Lc
        L19:
            byte[] r2 = (byte[]) r2
            r0 = r2[r1]
            int r0 = r0 - r4
            int r0 = r0 + (-44)
            byte r0 = (byte) r0
            r2[r1] = r0
            int r1 = r1 + 1
            r0 = 2
            goto Lc
        L27:
            byte[] r2 = (byte[]) r2
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
            java.lang.String r0 = (java.lang.String) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.OG.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A04 = new byte[]{-15, -3, -5, -68, -12, -17, -15, -13, -16, -3, -3, -7, -68, -17, -14, 1, -68, -9, -4, 2, -13, 0, 1, 2, -9, 2, -9, -17, -6, -68, -15, -6, -9, -15, -7, -13, -14};
    }

    static {
        A01();
        A08 = (int) (KE.A01 * 36.0f);
        A09 = (int) (KE.A01 * 36.0f);
        A05 = (int) (KE.A01 * 23.0f);
        A07 = (int) (KE.A01 * 8.0f);
        A06 = (int) (KE.A01 * 3.0f);
        A0A = (int) (4.0f * KE.A01);
    }

    public OG(C0610Nx c0610Nx, String str, C2T c2t, NZ nz) {
        super(c0610Nx.A05());
        this.A03 = c0610Nx;
        this.A00 = c2t.A08(true);
        this.A01 = new RelativeLayout(c0610Nx.A05());
        addView(this.A01, new FrameLayout.LayoutParams(-1, -1));
        this.A01.setClickable(false);
        A03(str, c2t, C0413Gc.A1A(this.A03.A05()));
        this.A02 = new ViewOnClickListenerC0589Nc(c0610Nx.A05(), A00(0, 37, 98), null, c0610Nx.A06(), c0610Nx.A08(), c0610Nx.A0B(), c0610Nx.A07());
        this.A02.setCta(c0610Nx.A04().A0L().A0F(), c0610Nx.A04().A0P(), new HashMap(), nz);
        this.A02.setIsInAppBrowser(true);
        addView(this.A02, new FrameLayout.LayoutParams(-1, -1));
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x006c, code lost:            r5 = r5;        r5.bottomMargin = r7;        r5.addRule(2, r9.getId());        r5.addRule(14);        r6.A01.addView(r4, r5);     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0088, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A02(android.view.View r9, boolean r10) {
        /*
            r8 = this;
            r6 = r8
            r0 = 0
            r5 = 0
            r0 = 0
            r7 = 0
            android.widget.ImageView r4 = new android.widget.ImageView
            com.facebook.ads.redexgen.X.Nx r0 = r6.A03
            com.facebook.ads.redexgen.X.Ec r0 = r0.A05()
            r4.<init>(r0)
            com.facebook.ads.redexgen.X.KM r0 = com.facebook.ads.redexgen.X.KM.MINIMIZE_ARROW
            android.graphics.Bitmap r0 = com.facebook.ads.redexgen.X.KN.A00(r0)
            r4.setImageBitmap(r0)
            r0 = 1127481344(0x43340000, float:180.0)
            r4.setRotation(r0)
            r4.setClickable(r7)
            if (r10 == 0) goto L6a
            r0 = 2
        L24:
            switch(r0) {
                case 2: goto L28;
                case 3: goto L33;
                case 4: goto L6c;
                case 5: goto L4f;
                case 6: goto L53;
                default: goto L27;
            }
        L27:
            goto L24
        L28:
            com.facebook.ads.redexgen.X.OG r6 = (com.facebook.ads.redexgen.X.OG) r6
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            int r0 = r6.A00
            r4.setColorFilter(r0)
            r0 = 3
            goto L24
        L33:
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            android.widget.RelativeLayout$LayoutParams r5 = new android.widget.RelativeLayout$LayoutParams
            int r1 = com.facebook.ads.redexgen.X.OG.A05
            int r0 = com.facebook.ads.redexgen.X.OG.A05
            r5.<init>(r1, r0)
            int r3 = com.facebook.ads.redexgen.X.OG.A06
            int r2 = com.facebook.ads.redexgen.X.OG.A06
            int r1 = com.facebook.ads.redexgen.X.OG.A06
            int r0 = com.facebook.ads.redexgen.X.OG.A06
            r4.setPadding(r3, r2, r1, r0)
            if (r10 == 0) goto L4d
            r0 = 4
            goto L24
        L4d:
            r0 = 5
            goto L24
        L4f:
            int r7 = com.facebook.ads.redexgen.X.OG.A07
            r0 = 4
            goto L24
        L53:
            com.facebook.ads.redexgen.X.OG r6 = (com.facebook.ads.redexgen.X.OG) r6
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            android.graphics.drawable.GradientDrawable r1 = new android.graphics.drawable.GradientDrawable
            r1.<init>()
            int r0 = r6.A00
            r1.setColor(r0)
            r0 = 1
            r1.setShape(r0)
            r4.setBackgroundDrawable(r1)
            r0 = 3
            goto L24
        L6a:
            r0 = 6
            goto L24
        L6c:
            com.facebook.ads.redexgen.X.OG r6 = (com.facebook.ads.redexgen.X.OG) r6
            android.view.View r9 = (android.view.View) r9
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            android.widget.RelativeLayout$LayoutParams r5 = (android.widget.RelativeLayout.LayoutParams) r5
            r5.bottomMargin = r7
            r1 = 2
            int r0 = r9.getId()
            r5.addRule(r1, r0)
            r0 = 14
            r5.addRule(r0)
            android.widget.RelativeLayout r0 = r6.A01
            r0.addView(r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.OG.A02(android.view.View, boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x007f, code lost:            r4 = r4;        r3 = r3;        r2 = new android.widget.RelativeLayout.LayoutParams(-2, com.facebook.ads.redexgen.X.OG.A08);        r2.addRule(12);        r2.addRule(14);        r4.A01.addView(r3, r2);        r4.A02(r3, r8);     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x009d, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A03(java.lang.String r6, com.facebook.ads.redexgen.X.C2T r7, boolean r8) {
        /*
            r5 = this;
            r4 = r5
            r3 = 0
            r0 = 0
            r0 = 0
            if (r8 == 0) goto L7c
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto L53;
                case 3: goto L40;
                case 4: goto L38;
                case 5: goto L1d;
                case 6: goto Lb;
                case 7: goto L7f;
                case 8: goto L62;
                case 9: goto L6d;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.OG r4 = (com.facebook.ads.redexgen.X.OG) r4
            android.widget.TextView r3 = (android.widget.TextView) r3
            int r1 = r4.A00
            int r0 = com.facebook.ads.redexgen.X.OG.A0A
            com.facebook.ads.redexgen.X.KE.A0R(r3, r1, r0)
            r0 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r3.setTextColor(r0)
            r0 = 7
            goto L7
        L1d:
            java.lang.String r6 = (java.lang.String) r6
            android.widget.TextView r3 = (android.widget.TextView) r3
            r3.setText(r6)
            r0 = 1096810496(0x41600000, float:14.0)
            r3.setTextSize(r0)
            r0 = 1
            android.graphics.Typeface r0 = android.graphics.Typeface.defaultFromStyle(r0)
            r3.setTypeface(r0)
            if (r8 == 0) goto L35
            r0 = 6
            goto L7
        L35:
            r0 = 8
            goto L7
        L38:
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r6 = r6.toUpperCase()
            r0 = 5
            goto L7
        L40:
            android.widget.TextView r3 = (android.widget.TextView) r3
            r2 = 0
            com.facebook.ads.redexgen.X.KE.A0N(r3)
            int r1 = com.facebook.ads.redexgen.X.OG.A09
            int r0 = com.facebook.ads.redexgen.X.OG.A09
            r3.setPadding(r1, r2, r0, r2)
            if (r8 == 0) goto L51
            r0 = 4
            goto L7
        L51:
            r0 = 5
            goto L7
        L53:
            com.facebook.ads.redexgen.X.OG r4 = (com.facebook.ads.redexgen.X.OG) r4
            android.widget.Button r3 = new android.widget.Button
            com.facebook.ads.redexgen.X.Nx r0 = r4.A03
            com.facebook.ads.redexgen.X.Ec r0 = r0.A05()
            r3.<init>(r0)
            r0 = 3
            goto L7
        L62:
            com.facebook.ads.redexgen.X.OG r4 = (com.facebook.ads.redexgen.X.OG) r4
            android.widget.TextView r3 = (android.widget.TextView) r3
            int r0 = r4.A00
            r3.setTextColor(r0)
            r0 = 7
            goto L7
        L6d:
            com.facebook.ads.redexgen.X.OG r4 = (com.facebook.ads.redexgen.X.OG) r4
            android.widget.TextView r3 = new android.widget.TextView
            com.facebook.ads.redexgen.X.Nx r0 = r4.A03
            com.facebook.ads.redexgen.X.Ec r0 = r0.A05()
            r3.<init>(r0)
            r0 = 3
            goto L7
        L7c:
            r0 = 9
            goto L7
        L7f:
            com.facebook.ads.redexgen.X.OG r4 = (com.facebook.ads.redexgen.X.OG) r4
            android.widget.TextView r3 = (android.widget.TextView) r3
            android.widget.RelativeLayout$LayoutParams r2 = new android.widget.RelativeLayout$LayoutParams
            r1 = -2
            int r0 = com.facebook.ads.redexgen.X.OG.A08
            r2.<init>(r1, r0)
            r0 = 12
            r2.addRule(r0)
            r0 = 14
            r2.addRule(r0)
            android.widget.RelativeLayout r0 = r4.A01
            r0.addView(r3, r2)
            r4.A02(r3, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.OG.A03(java.lang.String, com.facebook.ads.redexgen.X.2T, boolean):void");
    }

    @Override // android.view.View
    public final boolean performClick() {
        return this.A02.performClick();
    }
}
