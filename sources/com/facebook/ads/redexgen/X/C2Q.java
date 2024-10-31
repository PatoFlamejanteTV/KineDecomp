package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.2Q, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public enum C2Q {
    A03(A01(23, 14, 67)),
    A04(A01(14, 9, 105));

    public static byte[] A01;
    public final String A00;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C2Q.A01
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
            int r0 = r0 + (-85)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2Q.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A01 = new byte[]{-17, -5, -6, 0, -15, 4, 0, 1, -19, -8, 11, -19, -4, -4, 46, 31, 37, 35, 29, 46, 45, 49, 50, -5, 7, 6, 12, -3, 16, 12, 13, -7, 4, -9, -7, 8, 8, -62, -77, -71, -73, -47, -62, -63, -59, -58};
    }

    static {
        A02();
    }

    C2Q(String str) {
        this.A00 = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x005a, code lost:            return r4;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.C2Q A00(java.lang.String r5) {
        /*
            r0 = 0
            r4 = 0
            r3 = -1
            int r0 = r5.hashCode()
            switch(r0) {
                case 883765328: goto L54;
                case 1434358835: goto L51;
                default: goto La;
            }
        La:
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto L2d;
                case 3: goto L29;
                case 4: goto L56;
                case 5: goto Lf;
                case 6: goto L13;
                case 7: goto L34;
                case 8: goto L37;
                case 9: goto L4e;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            com.facebook.ads.redexgen.X.2Q r4 = com.facebook.ads.redexgen.X.C2Q.A03
            r0 = 4
            goto Lb
        L13:
            java.lang.String r5 = (java.lang.String) r5
            r2 = 14
            r1 = 9
            r0 = 105(0x69, float:1.47E-43)
            java.lang.String r0 = A01(r2, r1, r0)
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L27
            r0 = 7
            goto Lb
        L27:
            r0 = 2
            goto Lb
        L29:
            com.facebook.ads.redexgen.X.2Q r4 = com.facebook.ads.redexgen.X.C2Q.A04
            r0 = 4
            goto Lb
        L2d:
            switch(r3) {
                case 0: goto L32;
                default: goto L30;
            }
        L30:
            r0 = 3
            goto Lb
        L32:
            r0 = 5
            goto Lb
        L34:
            r3 = 1
            r0 = 2
            goto Lb
        L37:
            java.lang.String r5 = (java.lang.String) r5
            r2 = 23
            r1 = 14
            r0 = 67
            java.lang.String r0 = A01(r2, r1, r0)
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L4c
            r0 = 9
            goto Lb
        L4c:
            r0 = 2
            goto Lb
        L4e:
            r3 = 0
            r0 = 2
            goto Lb
        L51:
            r0 = 8
            goto Lb
        L54:
            r0 = 6
            goto Lb
        L56:
            com.facebook.ads.redexgen.X.2Q r4 = (com.facebook.ads.redexgen.X.C2Q) r4
            com.facebook.ads.redexgen.X.2Q r4 = (com.facebook.ads.redexgen.X.C2Q) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2Q.A00(java.lang.String):com.facebook.ads.redexgen.X.2Q");
    }
}
