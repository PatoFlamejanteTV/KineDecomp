package com.facebook.ads.redexgen.X;

/* loaded from: assets/audience_network.dex */
public enum AI {
    A09(A00(104, 12, 79)),
    A04(A00(182, 14, 98)),
    A07(A00(196, 14, 33)),
    A08(A00(116, 19, 48)),
    A03(A00(38, 14, 64)),
    A05(A00(0, 19, 0)),
    A06(A00(52, 13, 53));

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
            byte[] r1 = com.facebook.ads.redexgen.X.AI.A01
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
            int r0 = r0 + (-96)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AI.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{-55, -50, -42, -63, -52, -55, -60, -65, -62, -60, -65, -46, -59, -45, -48, -49, -50, -45, -59, 23, 28, 36, 15, 26, 23, 18, 45, 16, 18, 45, 32, 19, 33, 30, 29, 28, 33, 19, 3, 15, 14, 6, 9, 7, -1, 16, 1, 18, 19, 9, 14, 7, 7, 10, 3, 9, -2, 2, -6, -12, -6, 7, 7, 4, 7, -26, -37, -33, -41, -28, -15, -43, -45, -34, -34, -41, -42, 5, 8, 1, 7, -4, 0, -8, 18, -8, 5, 5, 2, 5, -25, -13, -14, -22, -19, -21, 3, -12, -27, -10, -9, -19, -14, -21, 35, 24, 28, 20, 33, 14, 18, 16, 27, 27, 20, 19, 3, -7, -9, -2, -15, -4, -17, -13, -1, -2, 3, 4, 2, 5, -13, 4, -7, -1, -2, -17, -27, -29, -22, -35, -24, -5, -33, -21, -22, -17, -16, -18, -15, -33, -16, -27, -21, -22, 29, 46, 29, 38, 44, 55, 39, 27, 27, 45, 42, 42, 29, 28, 21, 7, 21, 21, 11, 17, 16, 33, 14, 17, 9, 9, 7, 6, 39, 56, 39, 48, 54, 33, 49, 37, 37, 55, 52, 52, 39, 38, -12, -26, -12, -12, -22, -16, -17, -32, -19, -16, -24, -24, -26, -27};
    }

    static {
        A01();
    }

    AI(String str) {
        this.A00 = str;
    }

    public final String A02() {
        return this.A00;
    }
}
