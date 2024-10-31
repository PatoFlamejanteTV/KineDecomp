package com.facebook.ads.redexgen.X;

/* loaded from: assets/audience_network.dex */
public enum E8 {
    A06,
    A09,
    A05,
    A0C,
    A02,
    A03,
    A07,
    A0D,
    A0A,
    A08,
    A0B,
    A04;

    public static byte[] A00;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.E8.A00
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
            int r0 = r0 + (-80)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.E8.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A00 = new byte[]{-19, -18, -20, -29, -24, -31, -52, -34, -36, -35, -40, -42, -24, -40, -53, -45, -50, -52, -35, 24, 29, 35, 46, 16, 33, 33, 16, 40, -69, -74, -68, -86, -81, -5, -19, -10, -5, -9, -6, -35, -22, -22, -25, -22, -4, 2, 5, -9, 10, -47, -42, -36, -76, -63, -63, -66, -73, -77, -64, -41, -44, -34, -33, -43, -55, -40, -46, -43, -44, -51};
    }

    static {
        A01();
    }
}
