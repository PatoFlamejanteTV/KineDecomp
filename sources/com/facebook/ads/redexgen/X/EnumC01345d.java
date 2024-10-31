package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.5d, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public enum EnumC01345d {
    A07(A00(0, 13, 30), C5L.A02, true),
    A06(A00(64, 17, 18), C5L.A03, true),
    A05(A00(50, 14, 33), C5L.A03, false),
    A08(A00(124, 23, 9), C5L.A03, false),
    A09(A00(111, 13, 88), C5L.A03, true);

    public static byte[] A03;
    public C5L A00;
    public String A01;
    public boolean A02;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.EnumC01345d.A03
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
            r0 = r0 ^ 107(0x6b, float:1.5E-43)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EnumC01345d.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A03 = new byte[]{5, 25, 20, 22, 16, 24, 16, 27, 1, 88, 28, 17, 6, 20, 23, 19, 6, 7, 0, 23, 13, 17, 29, 28, 20, 27, 21, 108, 110, 121, 122, 121, 104, Byte.MAX_VALUE, 116, 121, 120, 99, 125, 120, 99, 110, 121, 111, 108, 115, 114, 111, 121, 111, 44, 47, 43, 62, 63, 56, 47, 103, 41, 37, 36, 44, 35, 45, 9, 21, 24, 26, 28, 20, 28, 23, 13, 84, 31, 22, 11, 20, 24, 13, 10, 97, 99, 116, 119, 116, 101, 114, 121, 110, 100, 99, 125, 98, 119, 107, 102, 100, 98, 106, 98, 105, 115, 120, 97, 104, 117, 106, 102, 115, 116, 67, 65, 86, 85, 86, 71, 80, 91, 108, 70, 65, 95, 64, 18, 16, 7, 4, 7, 22, 1, 10, 7, 6, 79, 3, 6, 79, 16, 7, 17, 18, 13, 12, 17, 7, 17, 75, 87, 90, 88, 94, 86, 94, 85, 79, 68, 82, 95, 72};
    }

    static {
        A01();
    }

    EnumC01345d(String str, C5L c5l, boolean z) {
        this.A01 = str;
        this.A00 = c5l;
        this.A02 = z;
    }

    public final C5L A02() {
        return this.A00;
    }

    public final String A03() {
        return this.A01;
    }

    public final boolean A04() {
        return this.A02;
    }
}
