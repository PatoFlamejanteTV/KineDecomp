package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.0x, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public enum EnumC00260x {
    A08(A00(31, 5, 49)),
    A06(A00(0, 5, 8)),
    A03(A00(61, 8, 68)),
    A07(A00(14, 8, 49)),
    A05(A00(22, 9, 27)),
    A04(A00(5, 9, 69));

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
            byte[] r1 = com.facebook.ads.redexgen.X.EnumC00260x.A01
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
            int r0 = r0 + (-93)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EnumC00260x.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{-50, -46, -58, -52, -54, 6, 21, 14, 1, 11, 15, 3, 9, 7, -2, -6, -17, 7, -17, -16, -6, -13, -36, -21, -28, -41, -18, -31, -36, -35, -25, 4, -9, -14, -13, -3, -15, 0, -7, 12, 3, -10, -15, -14, -4, 1, -3, -14, 10, -14, -13, -3, -10, -6, -8, 9, 6, 12, 10, -4, 3, 4, 2, 19, 16, 22, 20, 6, 13, -60, -45, -52, -33, -55, -51, -63, -57, -59, 14, 18, 6, 12, 10, -30, -43, -48, -47, -37};
    }

    static {
        A01();
    }

    EnumC00260x(String str) {
        this.A00 = str;
    }

    public final String A02() {
        return this.A00;
    }
}
