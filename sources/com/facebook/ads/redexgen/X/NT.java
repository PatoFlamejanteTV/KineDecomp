package com.facebook.ads.redexgen.X;

/* loaded from: assets/audience_network.dex */
public enum NT {
    A05(0),
    A04(1),
    A03(2);

    public static byte[] A01;
    public int A00;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.NT.A01
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
            int r0 = r0 + (-117)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.NT.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A01 = new byte[]{33, 22, 35, 25, 40, 24, 22, 37, 26, 55, 48, 53, 50, 39, 37, 43, 40, 43, 39, 38, 20, 19, 22, 24, 22, 5, 13, 24};
    }

    static {
        A02();
    }

    NT(int i) {
        this.A00 = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x002d, code lost:            return r4;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.NT A00(int r5) {
        /*
            r4 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.NT[] r3 = values()
            int r2 = r3.length
            r1 = 0
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L15;
                case 4: goto L29;
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
            com.facebook.ads.redexgen.X.NT[] r3 = (com.facebook.ads.redexgen.X.NT[]) r3
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
            com.facebook.ads.redexgen.X.NT r4 = com.facebook.ads.redexgen.X.NT.A04
            r0 = 4
            goto Lb
        L29:
            com.facebook.ads.redexgen.X.NT r4 = (com.facebook.ads.redexgen.X.NT) r4
            com.facebook.ads.redexgen.X.NT r4 = (com.facebook.ads.redexgen.X.NT) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.NT.A00(int):com.facebook.ads.redexgen.X.NT");
    }

    public final int A03() {
        return this.A00;
    }
}
