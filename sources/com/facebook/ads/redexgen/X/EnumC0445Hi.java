package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Hi, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public enum EnumC0445Hi {
    A06(-1, 100, 1, 0),
    A07(-1, 120, 2, 1),
    A08(-1, 300, 3, 2),
    A09(-1, 400, 4, 3),
    A0A(-1, 50, 5, 4),
    A0B(-1, -1, 6, 5);

    public static byte[] A04;
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.EnumC0445Hi.A04
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
            int r0 = r0 + (-82)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EnumC0445Hi.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A04 = new byte[]{-88, -91, -87, -89, -88, -76, -65, -107, -112, -101, -104, -100, -102, -101, -89, -78, -124, -123, -125, -49, -52, -48, -50, -49, -37, -26, -72, -73, -73, -25, -38, -40, -23, -12, -39, -18, -29, -42, -30, -34, -40, 11, 8, 12, 10, 11, 23, 34, -10, -13, -13, -36, -39, -35, -37, -36, -24, -13, -56, -60, -60};
    }

    static {
        A02();
    }

    EnumC0445Hi(int i, int i2, int i3, int i4) {
        this.A03 = i;
        this.A01 = i2;
        this.A02 = i3;
        this.A00 = i4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x002a, code lost:            return r4;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.EnumC0445Hi A00(int r5) {
        /*
            r4 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.Hi[] r3 = values()
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
            com.facebook.ads.redexgen.X.Hi[] r3 = (com.facebook.ads.redexgen.X.EnumC0445Hi[]) r3
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
            com.facebook.ads.redexgen.X.Hi r4 = (com.facebook.ads.redexgen.X.EnumC0445Hi) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EnumC0445Hi.A00(int):com.facebook.ads.redexgen.X.Hi");
    }

    public final int A03() {
        return this.A01;
    }

    public final int A04() {
        return this.A02;
    }

    public final int A05() {
        return this.A03;
    }
}
