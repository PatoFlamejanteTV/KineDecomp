package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

@TargetApi(19)
/* loaded from: assets/audience_network.dex */
public final class N9 extends LinearLayout {
    public static byte[] A04;
    public Drawable A00;
    public TextView A01;
    public TextView A02;
    public final C0362Ec A03;

    static {
        A02();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.N9.A04
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
            int r0 = r0 + (-95)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.N9.A00(int, int, int):java.lang.String");
    }

    public static void A02() {
        A04 = new byte[]{51, 63, 63, 59, 62};
    }

    public N9(C0362Ec c0362Ec) {
        super(c0362Ec);
        this.A03 = c0362Ec;
        A01();
    }

    private void A01() {
        float f = getResources().getDisplayMetrics().density;
        setOrientation(1);
        this.A02 = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.A02.setTextColor(-16777216);
        this.A02.setTextSize(2, 20.0f);
        this.A02.setEllipsize(TextUtils.TruncateAt.END);
        this.A02.setSingleLine(true);
        this.A02.setVisibility(8);
        addView(this.A02, layoutParams);
        this.A01 = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        this.A01.setAlpha(0.5f);
        this.A01.setTextColor(-16777216);
        this.A01.setTextSize(2, 15.0f);
        this.A01.setCompoundDrawablePadding((int) (5.0f * f));
        this.A01.setEllipsize(TextUtils.TruncateAt.END);
        this.A01.setSingleLine(true);
        this.A01.setVisibility(8);
        addView(this.A01, layoutParams2);
    }

    private Drawable getPadlockDrawable() {
        if (this.A00 == null) {
            this.A00 = KN.A01(this.A03, KM.BROWSER_PADLOCK);
        }
        return this.A00;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0067, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setSubtitle(java.lang.String r9) {
        /*
            r8 = this;
            r6 = r8
            r5 = 0
            r7 = 0
            r0 = 0
            r4 = 0
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 == 0) goto L65
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L50;
                case 3: goto L67;
                case 4: goto L27;
                case 5: goto L1f;
                case 6: goto L10;
                case 7: goto L61;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            com.facebook.ads.redexgen.X.N9 r6 = (com.facebook.ads.redexgen.X.N9) r6
            android.widget.TextView r7 = (android.widget.TextView) r7
            r7.setCompoundDrawablesRelativeWithIntrinsicBounds(r5, r4, r4, r4)
            android.widget.TextView r1 = r6.A01
            r0 = 0
            r1.setVisibility(r0)
            r0 = 3
            goto Lc
        L1f:
            com.facebook.ads.redexgen.X.N9 r6 = (com.facebook.ads.redexgen.X.N9) r6
            android.graphics.drawable.Drawable r5 = r6.getPadlockDrawable()
            r0 = 6
            goto Lc
        L27:
            com.facebook.ads.redexgen.X.N9 r6 = (com.facebook.ads.redexgen.X.N9) r6
            java.lang.String r9 = (java.lang.String) r9
            android.net.Uri r3 = android.net.Uri.parse(r9)
            android.widget.TextView r1 = r6.A01
            java.lang.String r0 = r3.getHost()
            r1.setText(r0)
            android.widget.TextView r7 = r6.A01
            r2 = 0
            r1 = 5
            r0 = 108(0x6c, float:1.51E-43)
            java.lang.String r1 = A00(r2, r1, r0)
            java.lang.String r0 = r3.getScheme()
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L4e
            r0 = 5
            goto Lc
        L4e:
            r0 = 7
            goto Lc
        L50:
            com.facebook.ads.redexgen.X.N9 r6 = (com.facebook.ads.redexgen.X.N9) r6
            r4 = 0
            android.widget.TextView r0 = r6.A01
            r0.setText(r4)
            android.widget.TextView r1 = r6.A01
            r0 = 8
            r1.setVisibility(r0)
            r0 = 3
            goto Lc
        L61:
            r4 = 0
            r5 = r4
            r0 = 6
            goto Lc
        L65:
            r0 = 4
            goto Lc
        L67:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.N9.setSubtitle(java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0030, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setTitle(java.lang.String r4) {
        /*
            r3 = this;
            r2 = r3
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 == 0) goto L2e
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L30;
                case 4: goto L1d;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.N9 r2 = (com.facebook.ads.redexgen.X.N9) r2
            android.widget.TextView r1 = r2.A02
            r0 = 0
            r1.setText(r0)
            android.widget.TextView r1 = r2.A02
            r0 = 8
            r1.setVisibility(r0)
            r0 = 3
            goto L8
        L1d:
            com.facebook.ads.redexgen.X.N9 r2 = (com.facebook.ads.redexgen.X.N9) r2
            java.lang.String r4 = (java.lang.String) r4
            android.widget.TextView r0 = r2.A02
            r0.setText(r4)
            android.widget.TextView r1 = r2.A02
            r0 = 0
            r1.setVisibility(r0)
            r0 = 3
            goto L8
        L2e:
            r0 = 4
            goto L8
        L30:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.N9.setTitle(java.lang.String):void");
    }
}
