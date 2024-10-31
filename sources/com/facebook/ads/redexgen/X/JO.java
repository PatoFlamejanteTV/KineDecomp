package com.facebook.ads.redexgen.X;

import org.json.JSONArray;

/* loaded from: assets/audience_network.dex */
public enum JO {
    A06(0),
    A0E(1),
    A07(2),
    A0F(3),
    A08(4),
    A05(5),
    A0C(6),
    A0D(7),
    A0I(8),
    A0B(9),
    A09(10),
    A0G(11),
    A0H(16),
    A0A(17);

    public static byte[] A01;
    public static final JO[] A02;
    public static final String A03;
    public final int A00;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A02(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.JO.A01
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
            int r0 = r0 + (-88)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.JO.A02(int, int, int):java.lang.String");
    }

    public static void A03() {
        A01 = new byte[]{-23, -24, -11, -11, -20, -7, 6, -5, -10, 6, -16, -11, -5, -20, -7, -6, -5, -16, -5, -16, -24, -13, -57, -60, -55, -58, -38, -68, -65, -57, -48, -36, -47, -49, -58, -60, -60, -62, -49, -29, -42, -47, -46, -36, -20, -50, -47, -91, -88, -61, -89, -84, -77, -83, -89, -87, -73, 24, 39, 39, 54, 24, 27, 54, 45, 9, 3, 15, 15, 11, 26, 7, 4, 9, 6, 14, -50, -45, -47, -50, -45, -54, -28, -37, -50, -55, -54, -44, -28, -58, -55, -7, -14, -19, -22, -19, -23, -24, 3, -16, -13, -21, -21, -19, -14, -21, -47, -38, -26, -37, -39, -48, -50, -50, -52, -39, -26, -43, -42, -26, -56, -36, -37, -42, -26, -48, -44, -41, -26, -45, -42, -50, -50, -48, -43, -50, -33, -36, -31, -34, -14, -44, -41, -14, -23, -59, -30, -43, -24, -35, -22, -39, -13, -41, -32, -29, -25, -39, -13, -42, -23, -24, -24, -29, -30, -4, 11, 11, 26, 0, 9, 2, -4, 2, 0, 8, 0, 9, 15, 26, -4, -1, -79, -64, -64, -49, -79, -76};
    }

    static {
        A03();
        A02 = new JO[]{A0F, A08, A05, A0D, A0G, A0H, A0A};
        JSONArray array = new JSONArray();
        for (JO jo : A02) {
            array.put(jo.A00());
        }
        A03 = array.toString();
    }

    JO(int i) {
        this.A00 = i;
    }

    private final int A00() {
        return this.A00;
    }

    public static String A01() {
        return A03;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return String.valueOf(this.A00);
    }
}
