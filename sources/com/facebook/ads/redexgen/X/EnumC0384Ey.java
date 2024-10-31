package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Ey, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public enum EnumC0384Ey {
    A08(9000, A00(114, 30, 20)),
    A06(3001, A00(50, 29, 36)),
    A05(3002, A00(79, 35, 115)),
    A07(3003, A00(144, 33, 30)),
    A04(3004, A00(15, 35, 115));

    public static byte[] A02;
    public final int A00;
    public final String A01;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.EnumC0384Ey.A02
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
            r0 = r0 ^ 115(0x73, float:1.61E-43)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EnumC0384Ey.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A02 = new byte[]{87, 82, 71, 82, 81, 82, 64, 86, 76, 70, 67, 87, 82, 71, 86, 70, 97, 105, 108, 101, 100, 32, 116, 111, 32, 100, 101, 108, 101, 116, 101, 32, 114, 111, 119, 32, 102, 114, 111, 109, 32, 100, 97, 116, 97, 98, 97, 115, 101, 46, 17, 54, 62, 59, 50, 51, 119, 35, 56, 119, 37, 50, 54, 51, 119, 49, 37, 56, 58, 119, 51, 54, 35, 54, 53, 54, 36, 50, 121, 70, 97, 105, 108, 101, 100, 32, 116, 111, 32, 105, 110, 115, 101, 114, 116, 32, 114, 111, 119, 32, 105, 110, 116, 111, 32, 100, 97, 116, 97, 98, 97, 115, 101, 46, 38, 9, 71, 18, 9, 12, 9, 8, 16, 9, 71, 2, 21, 21, 8, 21, 71, 15, 6, 20, 71, 8, 4, 4, 18, 21, 21, 2, 3, 73, 43, 12, 4, 1, 8, 9, 77, 25, 2, 77, 24, 29, 9, 12, 25, 8, 77, 31, 2, 26, 77, 4, 3, 77, 9, 12, 25, 12, 15, 12, 30, 8, 67, 104, 109, 120, 109, 110, 109, Byte.MAX_VALUE, 105, 115, 101, 98, Byte.MAX_VALUE, 105, 126, 120, 80, 85, 64, 85, 86, 85, 71, 81, 75, 80, 81, 88, 81, 64, 81, 80, 85, 64, 85, 86, 85, 71, 81, 75, 71, 81, 88, 81, 87, 64, 76, 87, 82, 87, 86, 78, 87};
    }

    static {
        A01();
    }

    EnumC0384Ey(int i, String str) {
        this.A00 = i;
        this.A01 = str;
    }

    public final int A02() {
        return this.A00;
    }

    public final String A03() {
        return this.A01;
    }
}
