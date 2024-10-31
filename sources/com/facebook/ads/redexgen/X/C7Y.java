package com.facebook.ads.redexgen.X;

import android.view.animation.Interpolator;
import android.widget.OverScroller;

/* renamed from: com.facebook.ads.redexgen.X.7Y, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class C7Y implements Runnable {
    public static byte[] A07;
    public OverScroller A01;
    public int A02;
    public int A03;
    public final /* synthetic */ C01807a A06;
    public Interpolator A00 = C01807a.A19;
    public boolean A04 = false;
    public boolean A05 = false;

    static {
        A03();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A02(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C7Y.A07
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
            r0 = r0 ^ 24
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7Y.A02(int, int, int):java.lang.String");
    }

    public static void A03() {
        A07 = new byte[]{109, 105, 31, 108, 92, 77, 80, 83, 83};
    }

    public C7Y(C01807a c01807a) {
        this.A06 = c01807a;
        this.A01 = new OverScroller(c01807a.getContext(), C01807a.A19);
    }

    private float A00(float f) {
        return (float) Math.sin((f - 0.5f) * 0.47123894f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00a3, code lost:            return java.lang.Math.min(r6, 2000);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int A01(int r13, int r14, int r15, int r16) {
        /*
            r12 = this;
            r7 = r12
            r0 = 0
            r6 = 0
            r5 = 0
            r0 = 0
            r9 = 0
            r8 = 0
            r2 = 0
            r11 = 0
            int r4 = java.lang.Math.abs(r13)
            int r3 = java.lang.Math.abs(r14)
            if (r4 <= r3) goto L99
            r0 = 2
        L14:
            switch(r0) {
                case 2: goto L7a;
                case 3: goto L49;
                case 4: goto L70;
                case 5: goto L2a;
                case 6: goto L18;
                case 7: goto L9d;
                case 8: goto L80;
                case 9: goto L8c;
                case 10: goto L88;
                case 11: goto L66;
                case 12: goto L7d;
                default: goto L17;
            }
        L17:
            goto L14
        L18:
            r1 = 1148846080(0x447a0000, float:1000.0)
            float r0 = (float) r8
            float r0 = r2 / r0
            float r0 = java.lang.Math.abs(r0)
            float r1 = r1 * r0
            int r0 = java.lang.Math.round(r1)
            int r6 = r0 * 4
            r0 = 7
            goto L14
        L2a:
            com.facebook.ads.redexgen.X.7Y r7 = (com.facebook.ads.redexgen.X.C7Y) r7
            int r1 = r5 / 2
            r10 = 1065353216(0x3f800000, float:1.0)
            r2 = 1065353216(0x3f800000, float:1.0)
            float r0 = (float) r9
            float r2 = r2 * r0
            float r0 = (float) r5
            float r2 = r2 / r0
            float r0 = java.lang.Math.min(r10, r2)
            float r2 = (float) r1
            float r1 = (float) r1
            float r0 = r7.A00(r0)
            float r1 = r1 * r0
            float r2 = r2 + r1
            if (r8 <= 0) goto L46
            r0 = 6
            goto L14
        L46:
            r0 = 8
            goto L14
        L49:
            int r1 = r15 * r15
            int r0 = r16 * r16
            int r1 = r1 + r0
            double r0 = (double) r1
            double r0 = java.lang.Math.sqrt(r0)
            int r8 = (int) r0
            int r1 = r13 * r13
            int r0 = r14 * r14
            int r1 = r1 + r0
            double r0 = (double) r1
            double r0 = java.lang.Math.sqrt(r0)
            int r9 = (int) r0
            if (r11 == 0) goto L63
            r0 = 4
            goto L14
        L63:
            r0 = 11
            goto L14
        L66:
            com.facebook.ads.redexgen.X.7Y r7 = (com.facebook.ads.redexgen.X.C7Y) r7
            com.facebook.ads.redexgen.X.7a r0 = r7.A06
            int r5 = r0.getHeight()
            r0 = 5
            goto L14
        L70:
            com.facebook.ads.redexgen.X.7Y r7 = (com.facebook.ads.redexgen.X.C7Y) r7
            com.facebook.ads.redexgen.X.7a r0 = r7.A06
            int r5 = r0.getWidth()
            r0 = 5
            goto L14
        L7a:
            r11 = 1
            r0 = 3
            goto L14
        L7d:
            r11 = 0
            r0 = 3
            goto L14
        L80:
            if (r11 == 0) goto L85
            r0 = 9
            goto L14
        L85:
            r0 = 10
            goto L14
        L88:
            r4 = r3
            r0 = 9
            goto L14
        L8c:
            float r1 = (float) r4
            float r0 = (float) r5
            float r1 = r1 / r0
            r0 = 1065353216(0x3f800000, float:1.0)
            float r1 = r1 + r0
            r0 = 1133903872(0x43960000, float:300.0)
            float r1 = r1 * r0
            int r6 = (int) r1
            r0 = 7
            goto L14
        L99:
            r0 = 12
            goto L14
        L9d:
            r0 = 2000(0x7d0, float:2.803E-42)
            int r0 = java.lang.Math.min(r6, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7Y.A01(int, int, int, int):int");
    }

    private final void A04() {
        this.A05 = false;
        this.A04 = true;
    }

    private final void A05() {
        this.A04 = false;
        if (this.A05) {
            A07();
        }
    }

    private final void A06(int i, int i2, int i3, int i4) {
        A0B(i, i2, A01(i, i2, i3, i4));
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0021, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A07() {
        /*
            r2 = this;
            r1 = r2
            boolean r0 = r1.A04
            if (r0 == 0) goto L1f
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L21;
                case 4: goto L11;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.7Y r1 = (com.facebook.ads.redexgen.X.C7Y) r1
            r0 = 1
            r1.A05 = r0
            r0 = 3
            goto L6
        L11:
            com.facebook.ads.redexgen.X.7Y r1 = (com.facebook.ads.redexgen.X.C7Y) r1
            com.facebook.ads.redexgen.X.7a r0 = r1.A06
            r0.removeCallbacks(r1)
            com.facebook.ads.redexgen.X.7a r0 = r1.A06
            com.facebook.ads.redexgen.X.C5B.A0C(r0, r1)
            r0 = 3
            goto L6
        L1f:
            r0 = 4
            goto L6
        L21:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7Y.A07():void");
    }

    public final void A08() {
        this.A06.removeCallbacks(this);
        this.A01.abortAnimation();
    }

    public final void A09(int i, int i2) {
        this.A06.setScrollState(2);
        this.A03 = 0;
        this.A02 = 0;
        this.A01.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        A07();
    }

    public final void A0A(int i, int i2) {
        A06(i, i2, 0, 0);
    }

    public final void A0B(int i, int i2, int i3) {
        A0C(i, i2, i3, C01807a.A19);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x004c, code lost:            r2.A07();     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0051, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0C(int r10, int r11, int r12, android.view.animation.Interpolator r13) {
        /*
            r9 = this;
            r2 = r9
            r0 = 0
            r0 = 0
            android.view.animation.Interpolator r0 = r2.A00
            if (r0 == r13) goto L4a
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L21;
                case 4: goto L41;
                case 5: goto L4c;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.7Y r2 = (com.facebook.ads.redexgen.X.C7Y) r2
            android.view.animation.Interpolator r13 = (android.view.animation.Interpolator) r13
            r2.A00 = r13
            android.widget.OverScroller r1 = new android.widget.OverScroller
            com.facebook.ads.redexgen.X.7a r0 = r2.A06
            android.content.Context r0 = r0.getContext()
            r1.<init>(r0, r13)
            r2.A01 = r1
            r0 = 3
            goto L8
        L21:
            com.facebook.ads.redexgen.X.7Y r2 = (com.facebook.ads.redexgen.X.C7Y) r2
            r4 = 0
            com.facebook.ads.redexgen.X.7a r1 = r2.A06
            r0 = 2
            r1.setScrollState(r0)
            r2.A03 = r4
            r2.A02 = r4
            android.widget.OverScroller r3 = r2.A01
            r5 = r4
            r7 = r11
            r8 = r12
            r6 = r10
            r3.startScroll(r4, r5, r6, r7, r8)
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 23
            if (r1 >= r0) goto L3f
            r0 = 4
            goto L8
        L3f:
            r0 = 5
            goto L8
        L41:
            com.facebook.ads.redexgen.X.7Y r2 = (com.facebook.ads.redexgen.X.C7Y) r2
            android.widget.OverScroller r0 = r2.A01
            r0.computeScrollOffset()
            r0 = 5
            goto L8
        L4a:
            r0 = 3
            goto L8
        L4c:
            com.facebook.ads.redexgen.X.7Y r2 = (com.facebook.ads.redexgen.X.C7Y) r2
            r2.A07()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7Y.A0C(int, int, int, android.view.animation.Interpolator):void");
    }

    public final void A0D(int i, int i2, Interpolator interpolator) {
        int A01 = A01(i, i2, 0, 0);
        if (interpolator == null) {
            interpolator = C01807a.A19;
        }
        A0C(i, i2, A01, interpolator);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 530
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:64)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // java.lang.Runnable
    public final void run() {
        /*
            Method dump skipped, instructions count: 1324
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7Y.run():void");
    }
}
