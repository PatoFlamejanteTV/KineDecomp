package com.facebook.ads.redexgen.X;

/* loaded from: assets/audience_network.dex */
public enum FR {
    A04,
    A08,
    A07,
    A0A,
    A05,
    A02,
    A06,
    A03,
    A09;

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
            byte[] r1 = com.facebook.ads.redexgen.X.FR.A00
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
            int r0 = r0 + (-69)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FR.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A00 = new byte[]{-94, -93, -112, -95, -93, -108, -109, -48, -35, -35, -38, -35, -71, -79, -81, -74, -74, -85, -86, -72, -76, -87, -63, -86, -87, -85, -77, -57, -85, -73, -75, -72, -76, -83, -68, -83, -84, 1, -4, 4, -3, -6, -4, -17, -6, -21, -4, -13, -8, -15, -72, -70, -83, -72, -87, -70, -83, -84, -84, -65, -80, -80, -81, -68, -77, -72, -79, -102, -117, -97, -99, -113, -114};
    }

    static {
        A01();
    }
}
