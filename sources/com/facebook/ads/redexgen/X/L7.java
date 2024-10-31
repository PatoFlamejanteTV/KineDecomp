package com.facebook.ads.redexgen.X;

import android.util.AttributeSet;

/* loaded from: assets/audience_network.dex */
public final class L7 extends L5 implements L6 {
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public L4 A04;
    public boolean A05;
    public final L3 A06;

    public L7(C0362Ec c0362Ec) {
        super(c0362Ec);
        this.A03 = -1;
        this.A02 = -1;
        this.A01 = 0;
        this.A00 = 0;
        this.A05 = false;
        this.A06 = new L3(c0362Ec, new P8(), new P7());
        A01();
    }

    public L7(C0362Ec c0362Ec, AttributeSet attributeSet) {
        super(c0362Ec, attributeSet);
        this.A03 = -1;
        this.A02 = -1;
        this.A01 = 0;
        this.A00 = 0;
        this.A05 = false;
        this.A06 = new L3(c0362Ec, new P8(), new P7());
        A01();
    }

    public L7(C0362Ec c0362Ec, AttributeSet attributeSet, int i) {
        super(c0362Ec, attributeSet, i);
        this.A03 = -1;
        this.A02 = -1;
        this.A01 = 0;
        this.A00 = 0;
        this.A05 = false;
        this.A06 = new L3(c0362Ec, new P8(), new P7());
        A01();
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0043, code lost:            return r8;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int A00(int r8) {
        /*
            r7 = this;
            r0 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            int r0 = r7.A00
            int r6 = r0 * 2
            int r5 = r7.getMeasuredWidth()
            int r0 = r7.getPaddingLeft()
            int r5 = r5 - r0
            int r5 = r5 - r6
            com.facebook.ads.redexgen.X.2E r0 = r7.getAdapter()
            int r4 = r0.A0C()
            r3 = 0
            r1 = 2147483647(0x7fffffff, float:NaN)
            r0 = 2
        L20:
            switch(r0) {
                case 2: goto L24;
                case 3: goto L38;
                case 4: goto L43;
                case 5: goto L2a;
                case 6: goto L40;
                default: goto L23;
            }
        L23:
            goto L20
        L24:
            if (r1 <= r8) goto L28
            r0 = 3
            goto L20
        L28:
            r0 = 6
            goto L20
        L2a:
            int r0 = r3 * r6
            int r0 = r5 - r0
            float r2 = (float) r0
            float r1 = (float) r3
            r0 = 1051361018(0x3eaa7efa, float:0.333)
            float r1 = r1 + r0
            float r2 = r2 / r1
            int r1 = (int) r2
            r0 = 2
            goto L20
        L38:
            int r3 = r3 + 1
            if (r3 < r4) goto L3e
            r0 = 4
            goto L20
        L3e:
            r0 = 5
            goto L20
        L40:
            r8 = r1
            r0 = 4
            goto L20
        L43:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.L7.A00(int):int");
    }

    private void A01() {
        this.A06.A2E(0);
        setLayoutManager(this.A06);
        setSaveEnabled(false);
        setSnapDelegate(this);
        KE.A0N(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0024, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A02(int r3, int r4) {
        /*
            r2 = this;
            r1 = r2
            int r0 = r1.A03
            if (r3 != r0) goto L22
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L24;
                case 4: goto L14;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.L7 r1 = (com.facebook.ads.redexgen.X.L7) r1
            int r0 = r1.A02
            if (r4 != r0) goto L12
            r0 = 3
            goto L6
        L12:
            r0 = 4
            goto L6
        L14:
            com.facebook.ads.redexgen.X.L7 r1 = (com.facebook.ads.redexgen.X.L7) r1
            r1.A03 = r3
            r1.A02 = r4
            com.facebook.ads.redexgen.X.L4 r0 = r1.A04
            if (r0 == 0) goto L20
            r0 = 3
            goto L6
        L20:
            r0 = 3
            goto L6
        L22:
            r0 = 4
            goto L6
        L24:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.L7.A02(int, int):void");
    }

    @Override // com.facebook.ads.redexgen.X.L5
    public final void A1r(int i, boolean z) {
        super.A1r(i, z);
        A02(i, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x002c, code lost:            return r2;     */
    @Override // com.facebook.ads.redexgen.X.L6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A4r(int r5) {
        /*
            r4 = this;
            r3 = r4
            r0 = 0
            r2 = 0
            int r1 = java.lang.Math.abs(r5)
            int r0 = r3.A06
            if (r1 > r0) goto L2a
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L2c;
                case 4: goto L1d;
                case 5: goto L27;
                case 6: goto L13;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            r2 = 0
            r0 = 3
            goto Lc
        L13:
            com.facebook.ads.redexgen.X.L7 r3 = (com.facebook.ads.redexgen.X.L7) r3
            int r0 = r3.A01
            int r0 = r1 / r0
            int r2 = r0 + 1
            r0 = 3
            goto Lc
        L1d:
            com.facebook.ads.redexgen.X.L7 r3 = (com.facebook.ads.redexgen.X.L7) r3
            int r0 = r3.A01
            if (r0 != 0) goto L25
            r0 = 5
            goto Lc
        L25:
            r0 = 6
            goto Lc
        L27:
            r2 = 1
            r0 = 3
            goto Lc
        L2a:
            r0 = 4
            goto Lc
        L2c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.L7.A4r(int):int");
    }

    public int getChildSpacing() {
        return this.A00;
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x009e, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.C01807a, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onMeasure(int r8, int r9) {
        /*
            r7 = this;
            r3 = r7
            r6 = 0
            r2 = 0
            r1 = 0
            r0 = 0
            super.onMeasure(r8, r9)
            int r5 = r3.getPaddingTop()
            int r0 = r3.getPaddingBottom()
            int r5 = r5 + r0
            boolean r0 = r3.A05
            if (r0 == 0) goto L9a
            r0 = 2
        L16:
            switch(r0) {
                case 2: goto L52;
                case 3: goto L43;
                case 4: goto L36;
                case 5: goto L1a;
                case 6: goto L22;
                case 7: goto L74;
                case 8: goto L9e;
                case 9: goto L81;
                case 10: goto L89;
                case 11: goto L8f;
                case 12: goto L63;
                default: goto L19;
            }
        L19:
            goto L16
        L1a:
            int r0 = com.facebook.ads.redexgen.X.C0531Kv.A08
            int r6 = java.lang.Math.min(r0, r2)
            r0 = 6
            goto L16
        L22:
            com.facebook.ads.redexgen.X.L7 r3 = (com.facebook.ads.redexgen.X.L7) r3
            int r4 = r3.getMeasuredWidth()
            int r0 = r6 + r5
            r3.setMeasuredDimension(r4, r0)
            boolean r0 = r3.A05
            if (r0 != 0) goto L33
            r0 = 7
            goto L16
        L33:
            r0 = 8
            goto L16
        L36:
            com.facebook.ads.redexgen.X.L7 r3 = (com.facebook.ads.redexgen.X.L7) r3
            int r2 = r1 - r5
            boolean r0 = r3.A05
            if (r0 == 0) goto L40
            r0 = 5
            goto L16
        L40:
            r0 = 9
            goto L16
        L43:
            int r0 = android.view.View.MeasureSpec.getMode(r9)
            switch(r0) {
                case -2147483648: goto L4c;
                case 1073741824: goto L4f;
                default: goto L4a;
            }
        L4a:
            r0 = 4
            goto L16
        L4c:
            r0 = 11
            goto L16
        L4f:
            r0 = 10
            goto L16
        L52:
            com.facebook.ads.redexgen.X.L7 r3 = (com.facebook.ads.redexgen.X.L7) r3
            float r0 = com.facebook.ads.redexgen.X.KE.A01
            int r1 = (int) r0
            android.content.Context r0 = r3.getContext()
            int r0 = com.facebook.ads.redexgen.X.C0413Gc.A0A(r0)
            int r1 = r1 * r0
            int r1 = r1 + r5
            r0 = 3
            goto L16
        L63:
            com.facebook.ads.redexgen.X.L7 r3 = (com.facebook.ads.redexgen.X.L7) r3
            int r0 = r3.getMeasuredWidth()
            float r1 = (float) r0
            r0 = 1072986849(0x3ff47ae1, float:1.91)
            float r1 = r1 / r0
            int r1 = java.lang.Math.round(r1)
            r0 = 3
            goto L16
        L74:
            com.facebook.ads.redexgen.X.L7 r3 = (com.facebook.ads.redexgen.X.L7) r3
            int r0 = r3.A00
            int r0 = r0 * 2
            int r0 = r0 + r6
            r3.setChildWidth(r0)
            r0 = 8
            goto L16
        L81:
            com.facebook.ads.redexgen.X.L7 r3 = (com.facebook.ads.redexgen.X.L7) r3
            int r6 = r3.A00(r2)
            r0 = 6
            goto L16
        L89:
            int r1 = android.view.View.MeasureSpec.getSize(r9)
            r0 = 4
            goto L16
        L8f:
            int r0 = android.view.View.MeasureSpec.getSize(r9)
            int r1 = java.lang.Math.min(r0, r1)
            r0 = 4
            goto L16
        L9a:
            r0 = 12
            goto L16
        L9e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.L7.onMeasure(int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0018, code lost:            r1.A2L(r2);        super.setAdapter(r4);     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.C01807a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setAdapter(@android.support.annotation.Nullable com.facebook.ads.redexgen.X.C2E r4) {
        /*
            r3 = this;
            r2 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.L3 r1 = r3.A06
            if (r4 != 0) goto L16
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L18;
                case 4: goto Le;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            r2 = -1
            r0 = 3
            goto L7
        Le:
            com.facebook.ads.redexgen.X.2E r4 = (com.facebook.ads.redexgen.X.C2E) r4
            int r2 = r4.hashCode()
            r0 = 3
            goto L7
        L16:
            r0 = 4
            goto L7
        L18:
            r0 = r3
            com.facebook.ads.redexgen.X.L7 r0 = (com.facebook.ads.redexgen.X.L7) r0
            com.facebook.ads.redexgen.X.2E r4 = (com.facebook.ads.redexgen.X.C2E) r4
            com.facebook.ads.redexgen.X.L3 r1 = (com.facebook.ads.redexgen.X.L3) r1
            r1.A2L(r2)
            super.setAdapter(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.L7.setAdapter(com.facebook.ads.redexgen.X.2E):void");
    }

    public void setChildSpacing(int i) {
        this.A00 = i;
    }

    public void setChildWidth(int i) {
        this.A01 = i;
        int measuredWidth = getMeasuredWidth();
        this.A06.A2M((((measuredWidth - getPaddingLeft()) - getPaddingRight()) - this.A01) / 2);
        this.A06.A2K(this.A01 / measuredWidth);
    }

    public void setCurrentPosition(int i) {
        A1r(i, false);
    }

    public void setOnPageChangedListener(L4 l4) {
        this.A04 = l4;
    }

    public void setShowTextInCarousel(boolean z) {
        this.A05 = z;
    }
}
