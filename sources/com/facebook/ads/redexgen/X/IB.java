package com.facebook.ads.redexgen.X;

import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.widget.Button;

/* loaded from: assets/audience_network.dex */
public final class IB extends Button {
    public static byte[] A07;
    public String A00;
    public String A01;
    public boolean A02;
    public final Paint A03;
    public final Path A04;
    public final Path A05;
    public final Path A06;

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
            byte[] r1 = com.facebook.ads.redexgen.X.IB.A07
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
            int r0 = r0 + (-12)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.IB.A00(int, int, int):java.lang.String");
    }

    public static void A02() {
        A07 = new byte[]{119, -109, -120, -96, -64, -47, -27, -29, -43};
    }

    public IB(C0362Ec c0362Ec) {
        this(c0362Ec, false);
    }

    public IB(C0362Ec c0362Ec, boolean z) {
        super(c0362Ec);
        this.A02 = false;
        this.A01 = A00(0, 4, 27);
        this.A00 = A00(4, 5, 100);
        this.A04 = new Path();
        this.A05 = new Path();
        this.A06 = new Path();
        this.A03 = new IC(this, z);
        A01();
        setClickable(true);
        KE.A0P(this, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0019, code lost:            r2.setContentDescription(r1);     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0020, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A01() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r2.A02
            if (r0 == 0) goto L17
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L19;
                case 4: goto L11;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.IB r2 = (com.facebook.ads.redexgen.X.IB) r2
            java.lang.String r1 = r2.A01
            r0 = 3
            goto L7
        L11:
            com.facebook.ads.redexgen.X.IB r2 = (com.facebook.ads.redexgen.X.IB) r2
            java.lang.String r1 = r2.A00
            r0 = 3
            goto L7
        L17:
            r0 = 4
            goto L7
        L19:
            com.facebook.ads.redexgen.X.IB r2 = (com.facebook.ads.redexgen.X.IB) r2
            java.lang.String r1 = (java.lang.String) r1
            r2.setContentDescription(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.IB.A01():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0117, code lost:            super.onDraw(r11);     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x011e, code lost:            return;     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onDraw(android.graphics.Canvas r11) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.IB.onDraw(android.graphics.Canvas):void");
    }

    public void setChecked(boolean z) {
        this.A02 = z;
        A01();
        refreshDrawableState();
        invalidate();
    }

    public void setPauseAccessibilityLabel(@Nullable String str) {
        if (str != null) {
            this.A00 = str;
            A01();
        }
    }

    public void setPlayAccessibilityLabel(@Nullable String str) {
        if (str != null) {
            this.A01 = str;
            A01();
        }
    }
}
