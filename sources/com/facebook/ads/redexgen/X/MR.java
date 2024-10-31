package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.protocol.AdPlacementType;

/* loaded from: assets/audience_network.dex */
public final class MR implements MQ {
    public static byte[] A00;

    static {
        A01();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.MR.A00
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
            int r0 = r0 + (-102)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.MR.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A00 = new byte[]{-51, -39, -41, -104, -48, -53, -51, -49, -52, -39, -39, -43, -104, -53, -50, -35, -104, -45, -40, -34, -49, -36, -35, -34, -45, -34, -45, -53, -42, -104, -45, -41, -38, -36, -49, -35, -35, -45, -39, -40, -104, -42, -39, -47, -47, -49, -50, -11, 1, -1, -64, -8, -13, -11, -9, -12, 1, 1, -3, -64, -13, -10, 5, -64, -5, 0, 6, -9, 4, 5, 6, -5, 6, -5, -13, -2, -64, -9, 4, 4, 1, 4, -46, -34, -36, -99, -43, -48, -46, -44, -47, -34, -34, -38, -99, -48, -45, -30, -99, -40, -35, -29, -44, -31, -30, -29, -40, -29, -40, -48, -37, -99, -31, -44, -26, -48, -31, -45, -50, -30, -44, -31, -27, -44, -31, -50, -43, -48, -40, -37, -28, -31, -44, -24, -12, -14, -77, -21, -26, -24, -22, -25, -12, -12, -16, -77, -26, -23, -8, -77, -18, -13, -7, -22, -9, -8, -7, -18, -7, -18, -26, -15, -77, -9, -22, -4, -26, -9, -23, 23, 35, 33, -30, 26, 21, 23, 25, 22, 35, 35, 31, -30, 21, 24, 39, -30, 29, 34, 40, 25, 38, 39, 40, 29, 40, 29, 21, 32, -30, 38, 25, 43, 21, 38, 24, 19, 39, 25, 38, 42, 25, 38, 19, 39, 41, 23, 23, 25, 39, 39, 44, 56, 54, -9, 47, 42, 44, 46, 43, 56, 56, 52, -9, 42, 45, 60, -9, 50, 55, 61, 46, 59, 60, 61, 50, 61, 50, 42, 53, -9, 47, 50, 55, 50, 60, 49, 40, 42, 44, 61, 50, 63, 50, 61, 66, -22, -10, -12, -75, -19, -24, -22, -20, -23, -10, -10, -14, -75, -24, -21, -6, -75, -16, -11, -5, -20, -7, -6, -5, -16, -5, -16, -24, -13, -75, -22, -13, -16, -22, -14, -20, -21};
    }

    @Override // com.facebook.ads.redexgen.X.MQ
    public final String A4D() {
        return A00(133, 36, 31);
    }

    @Override // com.facebook.ads.redexgen.X.MQ
    public final String A4U() {
        return A00(265, 37, 33);
    }

    @Override // com.facebook.ads.redexgen.X.MQ
    public final String A4a() {
        return A00(220, 45, 99);
    }

    @Override // com.facebook.ads.redexgen.X.MQ
    public final String A4e() {
        return A00(47, 35, 44);
    }

    @Override // com.facebook.ads.redexgen.X.MQ
    public final String A4k() {
        return A00(0, 47, 4);
    }

    @Override // com.facebook.ads.redexgen.X.MQ
    public final String A4q() {
        return AdPlacementType.INTERSTITIAL.toString();
    }

    @Override // com.facebook.ads.redexgen.X.MQ
    public final String A4t() {
        return A00(82, 51, 9);
    }

    @Override // com.facebook.ads.redexgen.X.MQ
    public final String A4u() {
        return A00(169, 51, 78);
    }
}
