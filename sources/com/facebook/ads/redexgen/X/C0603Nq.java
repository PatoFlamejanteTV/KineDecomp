package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Nq, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0603Nq {
    public static final int A00 = KE.A02.heightPixels;
    public static final int A01 = KE.A02.widthPixels;

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static float A00(com.facebook.ads.redexgen.X.C2L r4) {
        /*
            r1 = 0
            r0 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.2O r0 = r4.A0D()
            int r3 = r0.A01()
            com.facebook.ads.redexgen.X.2O r0 = r4.A0D()
            int r2 = r0.A00()
            if (r2 <= 0) goto L23
            r0 = 2
        L16:
            switch(r0) {
                case 2: goto L1a;
                case 3: goto L25;
                case 4: goto L1f;
                default: goto L19;
            }
        L19:
            goto L16
        L1a:
            float r1 = (float) r3
            float r0 = (float) r2
            float r1 = r1 / r0
            r0 = 3
            goto L16
        L1f:
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0 = 3
            goto L16
        L23:
            r0 = 4
            goto L16
        L25:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0603Nq.A00(com.facebook.ads.redexgen.X.2L):float");
    }

    public static int A01(double d) {
        return (int) ((A01 - (AbstractC0604Nr.A05 * 2)) / d);
    }

    public static int A02(int bottomMargin) {
        int ctaSpacing = KE.A01(16);
        int ctaTextHeight = C0588Nb.A0A;
        int i = ctaTextHeight * 2;
        int ctaTextHeight2 = AbstractC0604Nr.A05;
        int ctaMargin = ctaTextHeight2 * 2;
        int ctaSpacing2 = ctaSpacing + i + ctaMargin;
        int ctaMargin2 = A00;
        return (ctaMargin2 - bottomMargin) - ctaSpacing2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0017, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A03(double r4) {
        /*
            r3 = 0
            r1 = 4606281698874543309(0x3feccccccccccccd, double:0.9)
            int r0 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r0 >= 0) goto L15
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L17;
                case 4: goto L12;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            r3 = 1
            r0 = 3
            goto Lb
        L12:
            r3 = 0
            r0 = 3
            goto Lb
        L15:
            r0 = 4
            goto Lb
        L17:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0603Nq.A03(double):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0018, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A04(double r3, int r5) {
        /*
            r2 = 0
            int r1 = A02(r5)
            int r0 = A01(r3)
            if (r1 >= r0) goto L16
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L18;
                case 4: goto L13;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            r2 = 1
            r0 = 3
            goto Lc
        L13:
            r2 = 0
            r0 = 3
            goto Lc
        L16:
            r0 = 4
            goto Lc
        L18:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0603Nq.A04(double, int):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x001b, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A05(int r2, int r3, double r4) {
        /*
            r1 = 0
            r0 = 2
            if (r2 == r0) goto L19
            r0 = 2
        L5:
            switch(r0) {
                case 2: goto L9;
                case 3: goto L13;
                case 4: goto L1b;
                case 5: goto L16;
                default: goto L8;
            }
        L8:
            goto L5
        L9:
            boolean r0 = A04(r4, r3)
            if (r0 == 0) goto L11
            r0 = 3
            goto L5
        L11:
            r0 = 5
            goto L5
        L13:
            r1 = 1
            r0 = 4
            goto L5
        L16:
            r1 = 0
            r0 = 4
            goto L5
        L19:
            r0 = 3
            goto L5
        L1b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0603Nq.A05(int, int, double):boolean");
    }
}
