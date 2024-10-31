package com.facebook.ads.redexgen.X;

/* loaded from: assets/audience_network.dex */
public enum E5 {
    A07(0),
    A05(1),
    A06(2),
    A04(3),
    A03(4);

    public static byte[] A01;
    public int A00;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.E5.A01
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
            int r0 = r0 + (-119)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.E5.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{-12, -11, 5, -10, -21, -8, -13, -17, -7, -7, -17, -11, -12, 52, 59, 50, 50, -37, -36, -31, -20, -32, -30, -35, -35, -36, -33, -31, -46, -47, 9, 2, -1, 2, 3, 11, 2, -47, -46, -41, -30, -52, -48, -45, -49, -56, -48, -56, -47, -41, -56, -57};
    }

    static {
        A01();
    }

    E5(int i) {
        this.A00 = i;
    }

    public final int A02() {
        return this.A00;
    }
}
