package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Hx, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public enum EnumC0458Hx {
    A08(0),
    A0C(4),
    A0A(5),
    A0B(6),
    A09(7),
    A0F(100),
    A0D(101),
    A0G(102),
    A0E(103),
    A06(200),
    A05(500),
    A04(201),
    A07(400),
    A03(300);

    public static byte[] A01;
    public final int A00;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.EnumC0458Hx.A01
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
            int r0 = r0 + (-86)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EnumC0458Hx.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A01 = new byte[]{-70, -88, -91, -71, -84, -88, -70, -62, -91, -92, -79, -79, -88, -75, -62, -104, -109, -12, -25, -6, -17, -4, -21, 5, -24, -25, -12, -12, -21, -8, -20, -38, -41, -21, -34, -38, -20, -12, -34, -29, -23, -38, -25, -24, -23, -34, -23, -34, -42, -31, -12, -35, -28, -25, -34, -17, -28, -29, -23, -42, -31, -62, -75, -56, -67, -54, -71, -45, -90, -87, -92, 28, 10, 7, 27, 14, 10, 28, 36, 7, 6, 19, 19, 10, 23, 36, -2, -11, -30, -48, -51, -31, -44, -48, -30, -22, -44, -39, -33, -48, -35, -34, -33, -44, -33, -44, -52, -41, -22, -33, -52, -51, -41, -48, -33, 37, 19, 16, 36, 23, 19, 37, 45, 23, 28, 34, 19, 32, 33, 34, 23, 34, 23, 15, 26, 45, 36, 19, 32, 34, 23, 17, 15, 26, -31, -26, -21, -20, -22, -35, -39, -27, -9, -18, -31, -36, -35, -25, -75, -93, -96, -76, -89, -93, -75, -67, -96, -97, -84, -84, -93, -80, -67, -86, -93, -91, -97, -95, -73, 2, -16, -19, 1, -12, -16, 2, 10, -19, -20, -7, -7, -16, -3, 10, -35, -32, -37, -20, -33, -15, -37, -20, -34, -33, -34, -7, -16, -29, -34, -33, -23, 10, -3, 16, 5, 18, 1, 27, 17, 10, 7, 10, 11, 19, 10, -46, -64, -67, -47, -60, -64, -46, -38, -60, -55, -49, -64, -51, -50, -49, -60, -49, -60, -68, -57, -38, -48, -55, -58, -55, -54, -46, -55, 25, 18, 15, 18, 19, 27, 18};
    }

    static {
        A02();
    }

    EnumC0458Hx(int i) {
        this.A00 = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x002a, code lost:            return r4;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.EnumC0458Hx A00(int r5) {
        /*
            r4 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.Hx[] r3 = values()
            int r2 = r3.length
            r1 = 0
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L15;
                case 4: goto L28;
                case 5: goto L21;
                case 6: goto L25;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            if (r1 >= r2) goto L13
            r0 = 3
            goto Lb
        L13:
            r0 = 6
            goto Lb
        L15:
            com.facebook.ads.redexgen.X.Hx[] r3 = (com.facebook.ads.redexgen.X.EnumC0458Hx[]) r3
            r4 = r3[r1]
            int r0 = r4.A00
            if (r0 != r5) goto L1f
            r0 = 4
            goto Lb
        L1f:
            r0 = 5
            goto Lb
        L21:
            int r1 = r1 + 1
            r0 = 2
            goto Lb
        L25:
            r4 = 0
            r0 = 4
            goto Lb
        L28:
            com.facebook.ads.redexgen.X.Hx r4 = (com.facebook.ads.redexgen.X.EnumC0458Hx) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EnumC0458Hx.A00(int):com.facebook.ads.redexgen.X.Hx");
    }

    public final int A03() {
        return this.A00;
    }
}
