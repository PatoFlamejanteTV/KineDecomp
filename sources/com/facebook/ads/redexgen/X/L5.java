package com.facebook.ads.redexgen.X;

import android.util.AttributeSet;
import android.view.View;

/* loaded from: assets/audience_network.dex */
public class L5 extends C01807a implements View.OnTouchListener {
    public static byte[] A07;
    public int A00;
    public C01636i A01;
    public L6 A02;
    public boolean A03;
    public boolean A04;
    public int A05;
    public final int A06;

    static {
        A06();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A04(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.L5.A07
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
            r0 = r0 ^ r4
            r0 = r0 ^ 124(0x7c, float:1.74E-43)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.L5.A04(int, int, int):java.lang.String");
    }

    public static void A06() {
        A07 = new byte[]{46, 19, 28, 13, 47, 24, 30, 4, 30, 17, 24, 15, 43, 20, 24, 10, 93, 18, 19, 17, 4, 93, 14, 8, 13, 13, 18, 15, 9, 14, 93, 49, 20, 19, 24, 28, 15, 49, 28, 4, 18, 8, 9, 48, 28, 19, 28, 26, 24, 15};
    }

    public L5(C0362Ec c0362Ec) {
        super(c0362Ec);
        this.A05 = 0;
        this.A00 = 0;
        this.A03 = true;
        this.A04 = false;
        this.A06 = A00();
        setOnTouchListener(this);
    }

    public L5(C0362Ec c0362Ec, AttributeSet attributeSet) {
        super(c0362Ec, attributeSet);
        this.A05 = 0;
        this.A00 = 0;
        this.A03 = true;
        this.A04 = false;
        this.A06 = A00();
        setOnTouchListener(this);
    }

    public L5(C0362Ec c0362Ec, AttributeSet attributeSet, int i) {
        super(c0362Ec, attributeSet, i);
        this.A05 = 0;
        this.A00 = 0;
        this.A03 = true;
        this.A04 = false;
        this.A06 = A00();
        setOnTouchListener(this);
    }

    private int A00() {
        return ((int) getContext().getResources().getDisplayMetrics().density) * 10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x003d, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int A01(int r6) {
        /*
            r5 = this;
            r4 = r5
            r0 = 0
            r3 = 0
            r0 = 0
            int r2 = r4.A00
            int r2 = r2 - r6
            com.facebook.ads.redexgen.X.L6 r0 = r4.A02
            int r1 = r0.A4r(r2)
            int r0 = r4.A06
            if (r2 <= r0) goto L3b
            r0 = 2
        L12:
            switch(r0) {
                case 2: goto L16;
                case 3: goto L3d;
                case 4: goto L20;
                case 5: goto L2b;
                case 6: goto L35;
                default: goto L15;
            }
        L15:
            goto L12
        L16:
            com.facebook.ads.redexgen.X.L5 r4 = (com.facebook.ads.redexgen.X.L5) r4
            int r0 = r4.A05
            int r3 = r4.A03(r0, r1)
            r0 = 3
            goto L12
        L20:
            com.facebook.ads.redexgen.X.L5 r4 = (com.facebook.ads.redexgen.X.L5) r4
            int r0 = r4.A06
            int r0 = -r0
            if (r2 >= r0) goto L29
            r0 = 5
            goto L12
        L29:
            r0 = 6
            goto L12
        L2b:
            com.facebook.ads.redexgen.X.L5 r4 = (com.facebook.ads.redexgen.X.L5) r4
            int r0 = r4.A05
            int r3 = r4.A02(r0, r1)
            r0 = 3
            goto L12
        L35:
            com.facebook.ads.redexgen.X.L5 r4 = (com.facebook.ads.redexgen.X.L5) r4
            int r3 = r4.A05
            r0 = 3
            goto L12
        L3b:
            r0 = 4
            goto L12
        L3d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.L5.A01(int):int");
    }

    private int A02(int i, int i2) {
        return Math.max(i - i2, 0);
    }

    private int A03(int i, int i2) {
        return Math.min(i + i2, getItemCount() - 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0026, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A1r(int r3, boolean r4) {
        /*
            r2 = this;
            r1 = r2
            com.facebook.ads.redexgen.X.2E r0 = r1.getAdapter()
            if (r0 != 0) goto L24
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto L26;
                case 3: goto L13;
                case 4: goto L1d;
                case 5: goto Lc;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.L5 r1 = (com.facebook.ads.redexgen.X.L5) r1
            r1.A1K(r3)
            r0 = 2
            goto L8
        L13:
            com.facebook.ads.redexgen.X.L5 r1 = (com.facebook.ads.redexgen.X.L5) r1
            r1.A05 = r3
            if (r4 == 0) goto L1b
            r0 = 4
            goto L8
        L1b:
            r0 = 5
            goto L8
        L1d:
            com.facebook.ads.redexgen.X.L5 r1 = (com.facebook.ads.redexgen.X.L5) r1
            r1.A1L(r3)
            r0 = 2
            goto L8
        L24:
            r0 = 3
            goto L8
        L26:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.L5.A1r(int, boolean):void");
    }

    public int getCurrentPosition() {
        return this.A05;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int getItemCount() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.2E r0 = r2.getAdapter()
            if (r0 != 0) goto L1c
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L1e;
                case 4: goto L10;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            r1 = 0
            r0 = 3
            goto L9
        L10:
            com.facebook.ads.redexgen.X.L5 r2 = (com.facebook.ads.redexgen.X.L5) r2
            com.facebook.ads.redexgen.X.2E r0 = r2.getAdapter()
            int r1 = r0.A0C()
            r0 = 3
            goto L9
        L1c:
            r0 = 4
            goto L9
        L1e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.L5.getItemCount():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0092, code lost:            return r5;     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onTouch(android.view.View r7, android.view.MotionEvent r8) {
        /*
            r6 = this;
            r4 = r6
            r0 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            r5 = 0
            r3 = 1
            float r0 = r8.getRawX()
            int r2 = (int) r0
            int r1 = r8.getActionMasked()
            if (r1 == r3) goto L90
            r0 = 2
        L13:
            switch(r0) {
                case 2: goto L46;
                case 3: goto L34;
                case 4: goto L2c;
                case 5: goto L22;
                case 6: goto L17;
                case 7: goto L3b;
                case 8: goto L92;
                case 9: goto L59;
                case 10: goto L61;
                case 11: goto L4d;
                case 12: goto L6a;
                case 13: goto L73;
                case 14: goto L81;
                case 15: goto L89;
                default: goto L16;
            }
        L16:
            goto L13
        L17:
            com.facebook.ads.redexgen.X.L5 r4 = (com.facebook.ads.redexgen.X.L5) r4
            int r0 = r4.A01(r2)
            r4.A1r(r0, r3)
            r0 = 7
            goto L13
        L22:
            com.facebook.ads.redexgen.X.L5 r4 = (com.facebook.ads.redexgen.X.L5) r4
            boolean r0 = r4.A04
            if (r0 == 0) goto L2a
            r0 = 6
            goto L13
        L2a:
            r0 = 7
            goto L13
        L2c:
            r0 = 4
            if (r1 != r0) goto L31
            r0 = 5
            goto L13
        L31:
            r0 = 9
            goto L13
        L34:
            r0 = 3
            if (r1 == r0) goto L39
            r0 = 4
            goto L13
        L39:
            r0 = 5
            goto L13
        L3b:
            com.facebook.ads.redexgen.X.L5 r4 = (com.facebook.ads.redexgen.X.L5) r4
            r0 = 0
            r4.A03 = r3
            r4.A04 = r0
            r5 = r3
            r0 = 8
            goto L13
        L46:
            r0 = 6
            if (r1 == r0) goto L4b
            r0 = 3
            goto L13
        L4b:
            r0 = 5
            goto L13
        L4d:
            com.facebook.ads.redexgen.X.L5 r4 = (com.facebook.ads.redexgen.X.L5) r4
            boolean r0 = r4.A03
            if (r0 == 0) goto L56
            r0 = 12
            goto L13
        L56:
            r0 = 8
            goto L13
        L59:
            if (r1 == 0) goto L5e
            r0 = 10
            goto L13
        L5e:
            r0 = 13
            goto L13
        L61:
            r0 = 5
            if (r1 == r0) goto L67
            r0 = 11
            goto L13
        L67:
            r0 = 13
            goto L13
        L6a:
            r0 = 2
            if (r1 != r0) goto L70
            r0 = 13
            goto L13
        L70:
            r0 = 8
            goto L13
        L73:
            com.facebook.ads.redexgen.X.L5 r4 = (com.facebook.ads.redexgen.X.L5) r4
            r4.A00 = r2
            boolean r0 = r4.A03
            if (r0 == 0) goto L7e
            r0 = 14
            goto L13
        L7e:
            r0 = 15
            goto L13
        L81:
            com.facebook.ads.redexgen.X.L5 r4 = (com.facebook.ads.redexgen.X.L5) r4
            r5 = 0
            r4.A03 = r5
            r0 = 15
            goto L13
        L89:
            com.facebook.ads.redexgen.X.L5 r4 = (com.facebook.ads.redexgen.X.L5) r4
            r4.A04 = r3
            r0 = 8
            goto L13
        L90:
            r0 = 5
            goto L13
        L92:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.L5.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // com.facebook.ads.redexgen.X.C01807a
    public void setLayoutManager(AbstractC01616g abstractC01616g) {
        if (!(abstractC01616g instanceof C01636i)) {
            throw new IllegalArgumentException(A04(0, 50, 1));
        }
        super.setLayoutManager(abstractC01616g);
        this.A01 = (C01636i) abstractC01616g;
    }

    public void setSnapDelegate(L6 l6) {
        this.A02 = l6;
    }
}
