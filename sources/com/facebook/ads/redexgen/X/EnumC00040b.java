package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.0b, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public enum EnumC00040b {
    A0K(0),
    A0I(1),
    A07(2),
    A0G(3),
    A0H(4),
    A06(5),
    A0F(6),
    A0A(7),
    A08(8),
    A0C(9),
    A0D(10),
    A0B(11),
    A0J(12),
    A03(13),
    A0E(14),
    A09(15),
    A04(16),
    A05(17);

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
            byte[] r1 = com.facebook.ads.redexgen.X.EnumC00040b.A01
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
            r0 = r0 ^ 53
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EnumC00040b.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{19, 9, 5, 12, 19, 31, 13, 27, 24, 22, 31, 47, 42, 49, 39, 61, 49, 33, 44, 61, 58, 60, 59, 45, 58, 43, 42, 49, 44, 55, 49, 37, 43, 55, 41, 59, 47, 60, 42, 18, 23, 12, 28, 21, 21, 0, 16, 1, 22, 22, 29, 12, 27, 28, 1, 26, 9, 28, 29, 7, 18, 31, 31, 10, 46, 43, 48, 38, 60, 48, 32, 45, 60, 59, 61, 58, 44, 59, 42, 43, 42, 47, 52, 34, 56, 52, 37, 36, 63, 52, 61, 34, 56, 34, 41, 39, 46, 126, 121, 97, 118, 123, 126, 115, 104, 96, 126, 121, 115, 120, 96, 5, 0, 27, 11, 2, 2, 23, 7, 22, 1, 1, 10, 27, 6, 11, 16, 16, 11, 9, 55, 50, 41, 63, 37, 41, 34, 36, 55, 56, 37, 38, 55, 36, 51, 56, 34, 79, 74, 81, 71, 93, 81, 64, 65, 90, 81, 71, 64, 81, 79, 77, 90, 71, 88, 71, 90, 87, 124, 121, 98, 116, 110, 98, 115, 104, 113, 113, 39, 32, 56, 47, 34, 39, 42, 49, 42, 39, 35, 43, 32, 61, 39, 33, 32, 61, 74, 79, 84, 68, 77, 77, 88, 72, 89, 78, 78, 69, 84, 95, 68, 91, 33, 36, 63, 41, 46, 51, 53, 38, 38, 41, 35, 41, 37, 46, 52, 63, 54, 41, 51, 41, 34, 44, 37, 63, 33, 50, 37, 33, 43, 44, 52, 35, 46, 43, 38, 61, 50, 35, 48, 39, 44, 54, 109, 104, 115, 101, 98, 115, 96, 99, 111, 103, Byte.MAX_VALUE, 111, 126, 105, 105, 98, 1, 4, 31, 22, 9, 5, 23, 1, 2, 9, 12, 9, 20, 25, 31, 20, 9, 3, 11, 31, 4, 21, 18, 1, 20, 9, 15, 14, 8, 24, 9, 30, 30, 21, 4, 21, 20, 15, 4, 18, 21, 15, 30, 9, 26, 24, 15, 18, 13, 30, 17, 10, 15, 10, 11, 19, 10};
    }

    static {
        A01();
    }

    EnumC00040b(int i) {
        this.A00 = i;
    }

    public final int A02() {
        return this.A00;
    }
}
