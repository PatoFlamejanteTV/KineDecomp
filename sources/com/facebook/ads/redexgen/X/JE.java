package com.facebook.ads.redexgen.X;

/* loaded from: assets/audience_network.dex */
public enum JE {
    A04(0),
    A0C(1),
    A07(2),
    A0A(3),
    A08(4),
    A0B(5),
    A03(6),
    A09(7),
    A05(8),
    A06(9);

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
            byte[] r1 = com.facebook.ads.redexgen.X.JE.A01
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
            r0 = r0 ^ 29
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.JE.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{120, 121, 105, 122, 119, 99, 120, 117, 126, 115, 100, 105, 112, 121, 99, 120, 114, 105, 100, 115, 112, 122, 115, 117, 98, Byte.MAX_VALUE, 121, 120, 65, 90, 67, 67, 80, 78, 76, 91, 70, 89, 70, 91, 70, 74, 92, 80, 93, 74, 73, 67, 74, 76, 91, 70, 64, 65, 99, 97, 106, 97, 118, 109, 103, 123, 97, 118, 118, 107, 118, 3, 14, 26, 1, 12, 7, 10, 29, 16, 9, 0, 26, 1, 11, 16, 29, 10, 9, 3, 10, 12, 27, 6, 0, 1, 105, 97, 124, 120, 117, 115, 109, 111, 120, 101, 122, 101, 120, 101, 105, Byte.MAX_VALUE, 115, 126, 105, 106, 96, 105, 111, 120, 101, 99, 98, 113, 112, 96, 109, 106, 113, 113, 118, 113, 120, 96, 107, 126, 108, 116, 108, 101, 104, 124, 103, 106, 97, 108, 123, 118, 111, 102, 124, 103, 109, 118, 104, 121, 96, 27, 24, 120, 121, 105, 119, 117, 98, Byte.MAX_VALUE, 96, Byte.MAX_VALUE, 98, 111, 105, 101, 115, 100, 96, Byte.MAX_VALUE, 117, 115, 61, 38, 63, 63, 44, 48, 60, 61, 39, 54, 43, 39, 1, 0, 16, 3, 14, 26, 1, 12, 7, 10, 29, 16, 9, 0, 26, 1, 11, 16, 14, 31, 6, 125, 126};
    }

    static {
        A01();
    }

    JE(int i) {
        this.A00 = i;
    }
}
