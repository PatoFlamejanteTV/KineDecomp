package com.facebook.ads.redexgen.X;

/* loaded from: assets/audience_network.dex */
public enum QE {
    A04(101),
    A07(102),
    A08(103),
    A05(104),
    A06(105),
    A03(106);

    public static byte[] A01;
    public final int A00;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.QE.A01
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
            r0 = r0 ^ 73
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.QE.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{64, 75, 89, 81, 88, 71, 74, 75, 65, 81, 71, 64, 90, 75, 92, 93, 90, 71, 90, 71, 79, 66, 81, 64, 73, 90, 81, 76, 91, 90, 90, 65, 64, 121, 97, 99, 122, 117, 122, 102, Byte.MAX_VALUE, 109, 99, 100, 40, 59, 34, 34, 61, 45, 60, 43, 43, 32, 49, 56, 39, 42, 43, 33, 49, 56, 39, 43, 57, 49, 33, 32, 49, 42, 43, 61, 58, 60, 33, 55, 117, 98, 112, 102, 117, 99, 98, 99, 120, 113, 110, 99, 98, 104, 120, 115, 104, 104, 107, 101, 102, 117, 120, 100, 107, 104, 116, 98, 120, 100, 107, 110, 100, 108, 98, 99, 59, 48, 34, 42, 35, 60, 49, 48, 58, 42, 60, 59, 33, 48, 39, 38, 33, 60, 33, 60, 52, 57, 42, 33, 58, 58, 57, 55, 52, 39, 42, 54, 57, 58, 38, 48, 42, 54, 57, 60, 54, 62, 48, 49, 49, 54, 44, 61, 42, 43, 44, 49, 44, 49, 57, 52, 39, 46, 49, 60, 61, 55, 39, 46, 49, 61, 47, 39, 60, 61, 43, 44, 42, 55, 33};
    }

    static {
        A01();
    }

    QE(int i) {
        this.A00 = i;
    }

    public final int A02() {
        return this.A00;
    }
}
