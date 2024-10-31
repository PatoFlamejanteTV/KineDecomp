package com.facebook.ads.redexgen.X;

/* loaded from: assets/audience_network.dex */
public enum AJ {
    A03(A00(129, 14, 71)),
    A09(A00(239, 19, 61)),
    A05(A00(294, 15, 124)),
    A06(A00(0, 38, 58)),
    A08(A00(38, 37, 23)),
    A04(A00(180, 40, 42)),
    A07(A00(336, 13, 100));

    public static byte[] A01;
    public final String A00;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.AJ.A01
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
            int r0 = r0 + (-88)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AJ.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{-10, 11, 0, -13, -1, -5, -11, -15, 5, -5, -7, 0, -13, -2, -15, -11, -5, 4, 7, -11, 7, -2, -13, 4, -15, -12, 7, -8, -8, -9, 4, -15, -2, -9, 0, -7, 6, -6, -30, -29, -48, -29, -40, -46, -50, -30, -40, -42, -35, -48, -37, -50, -46, -40, -31, -28, -46, -28, -37, -48, -31, -50, -47, -28, -43, -43, -44, -31, -50, -37, -44, -35, -42, -29, -41, -81, -74, -68, -70, -78, -63, -65, -74, -80, -52, -64, -74, -76, -69, -82, -71, -52, -80, -74, -65, -80, -62, -71, -82, -65, -52, -81, -62, -77, -77, -78, -65, -52, -71, -78, -69, -76, -63, -75, -4, 15, 0, 0, -1, 12, 25, -3, -5, 10, -5, -3, 3, 14, 19, 0, 15, 15, -2, 18, 4, 18, 18, 8, 14, 13, -2, 8, 3, -30, -9, -20, -33, -21, -25, -31, -3, -15, -25, -27, -20, -33, -22, -3, -31, -25, -16, -31, -13, -22, -33, -16, -3, -32, -13, -28, -28, -29, -16, -3, -22, -29, -20, -27, -14, -26, -28, -21, -15, -17, -25, -10, -12, -21, -27, -31, -11, -21, -23, -16, -29, -18, -31, -27, -21, -12, -9, -27, -9, -18, -29, -12, -31, -28, -9, -24, -24, -25, -12, -31, -18, -25, -16, -23, -10, -22, -81, -92, -88, -96, -83, -70, -92, -87, -81, -96, -83, -79, -100, -89, -70, -81, -92, -88, -96, 9, -2, 2, -6, 7, -12, -2, 3, 9, -6, 7, 11, -10, 1, -12, 9, -2, 2, -6, 12, 13, -6, 13, 2, -4, 24, 12, 2, 0, 7, -6, 5, 24, -4, 2, 11, -4, 14, 5, -6, 11, 24, -5, 14, -1, -1, -2, 11, 24, 5, -2, 7, 0, 13, 1, 54, 73, 58, 58, 57, 70, 51, 55, 53, 68, 53, 55, 61, 72, 77, -23, -33, -35, -28, -41, -30, -11, -39, -27, -28, -36, -33, -35, 3, 18, 18, 33, 21, 7, 21, 21, 11, 17, 16, 33, 11, 6, 47, 37, 35, 42, 29, 40, 27, 31, 43, 42, 34, 37, 35};
    }

    static {
        A01();
    }

    AJ(String str) {
        this.A00 = str;
    }

    public final String A02() {
        return this.A00;
    }
}
