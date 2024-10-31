package com.facebook.ads.redexgen.X;

/* loaded from: assets/audience_network.dex */
public enum AR {
    A0D,
    A02,
    A06,
    A08,
    A05,
    A09,
    A0A,
    A0C,
    A07,
    A04,
    A03,
    A0B;

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
            byte[] r1 = com.facebook.ads.redexgen.X.AR.A00
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
            r0 = r0 ^ 40
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AR.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A00 = new byte[]{0, 5, 5, 30, 21, 14, 20, 2, 9, 30, 18, 8, 6, 15, 0, 13, 30, 27, 27, 0, 24, 6, 13, 16, 12, 28, 16, 15, 26, 0, 12, 26, 17, 12, 16, 13, 0, 9, 30, 19, 10, 26, 30, 27, 27, 0, 18, 30, 24, 17, 26, 11, 16, 18, 26, 11, 26, 13, 0, 12, 26, 17, 12, 16, 13, 0, 9, 30, 19, 10, 26, 6, 3, 3, 24, 20, 19, 2, 23, 24, 3, 2, 19, 2, 4, 19, 8, 21, 24, 20, 2, 9, 20, 8, 21, 24, 17, 6, 11, 18, 2, 103, 98, 98, 121, 97, 99, 105, 107, 103, 97, 104, 99, 114, 111, 101, 121, 116, 105, 114, 103, 114, 111, 105, 104, 121, 117, 99, 104, 117, 105, 116, 121, 112, 103, 106, 115, 99, 28, 25, 25, 2, 28, 30, 30, 24, 17, 24, 15, 18, 16, 24, 9, 24, 15, 2, 14, 24, 19, 14, 18, 15, 2, 11, 28, 17, 8, 24, 43, 46, 46, 53, 38, 35, 45, 34, 62, 53, 57, 47, 36, 57, 37, 56, 53, 60, 43, 38, 63, 47, 4, 1, 1, 26, 4, 8, 7, 12, 0, 11, 17, 26, 17, 0, 8, 21, 0, 23, 4, 17, 16, 23, 0, 26, 22, 0, 11, 22, 10, 23, 26, 19, 4, 9, 16, 0, 120, 125, 125, 102, 105, 107, 118, 97, 112, 116, 112, 109, 96, 102, 106, 124, 119, 106, 118, 107, 102, 111, 120, 117, 108, 124, 120, 125, 125, 102, 123, 120, 107, 118, 116, 124, 109, 124, 107, 102, 106, 124, 119, 106, 118, 107, 102, 111, 120, 117, 108, 124, 56, 61, 61, 38, 43, 60, 53, 56, 45, 48, 47, 60, 38, 49, 44, 52, 48, 61, 48, 45, 32, 38, 42, 60, 55, 42, 54, 43, 38, 47, 56, 53, 44, 60, 123, 126, 126, 101, 117, 104, 115, Byte.MAX_VALUE, 116, 110, 123, 110, 115, 117, 116, 101, 105, Byte.MAX_VALUE, 116, 105, 117, 104, 101, 108, 123, 118, 111, Byte.MAX_VALUE};
    }

    static {
        A01();
    }
}
