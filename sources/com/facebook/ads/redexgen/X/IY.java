package com.facebook.ads.redexgen.X;

/* loaded from: assets/audience_network.dex */
public enum IY {
    A09,
    A07,
    A06,
    A08,
    A05,
    A0B,
    A0A,
    A02,
    A03,
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
            byte[] r1 = com.facebook.ads.redexgen.X.IY.A00
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
            int r0 = r0 + (-50)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.IY.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A00 = new byte[]{-127, -106, -117, 126, -118, -122, Byte.MIN_VALUE, -100, -122, -117, -111, -126, -113, -112, -111, -122, -111, -122, 126, -119, -117, 126, -112, 122, -117, 125, 126, 125, -104, -119, -123, 122, -110, 122, 123, -123, 126, -73, -57, -60, -52, -56, -70, -57, -28, -7, -18, -31, -19, -23, -29, -1, -14, -27, -9, -31, -14, -28, -27, -28, -1, -10, -23, -28, -27, -17, -61, -46, -55, -55, -36, -48, -64, -49, -62, -62, -53, -36, -45, -58, -63, -62, -52, -26, -39, -21, -43, -26, -40, -39, -40, -13, -22, -35, -40, -39, -29, -59, -54, -48, -63, -50, -49, -48, -59, -48, -59, -67, -56, -37, -54, -67, -48, -59, -46, -63, -37, -52, -56, -67, -43, -67, -66, -56, -63, -49, -44, -38, -53, -40, -39, -38, -49, -38, -49, -57, -46, -27, -44, -57, -38, -49, -36, -53, -27, -36, -49, -54, -53, -43, -22, -17, -11, -26, -13, -12, -11, -22, -11, -22, -30, -19, 0, -17, -30, -11, -22, -9, -26, 0, -28, -30, -13, -16, -10, -12, -26, -19, -44, -39, -33, -48, -35, -34, -33, -44, -33, -44, -52, -41, -22, -39, -52, -33, -44, -31, -48, -22, -44, -40, -52, -46, -48};
    }

    static {
        A01();
    }
}
