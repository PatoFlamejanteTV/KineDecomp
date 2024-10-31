package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Hk, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public enum EnumC0447Hk {
    A02,
    A04,
    A03;

    public static byte[] A00;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.EnumC0447Hk.A00
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
            r0 = r0 ^ 81
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EnumC0447Hk.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A00 = new byte[]{116, 117, 118, 113, 101, 124, 100, 78, 79, 99, 106, 106};
    }

    static {
        A02();
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0038, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.VideoAutoplayBehavior A00(com.facebook.ads.redexgen.X.EnumC0447Hk r3) {
        /*
            r2 = 0
            if (r3 != 0) goto L32
            r0 = 2
        L4:
            switch(r0) {
                case 2: goto L2a;
                case 3: goto L34;
                case 4: goto L10;
                case 5: goto Lc;
                case 6: goto L8;
                case 7: goto L2e;
                case 8: goto L26;
                default: goto L7;
            }
        L7:
            goto L4
        L8:
            com.facebook.ads.VideoAutoplayBehavior r2 = com.facebook.ads.VideoAutoplayBehavior.OFF
            r0 = 3
            goto L4
        Lc:
            com.facebook.ads.VideoAutoplayBehavior r2 = com.facebook.ads.VideoAutoplayBehavior.DEFAULT
            r0 = 3
            goto L4
        L10:
            com.facebook.ads.redexgen.X.Hk r3 = (com.facebook.ads.redexgen.X.EnumC0447Hk) r3
            int[] r1 = com.facebook.ads.redexgen.X.C0446Hj.A00
            int r0 = r3.ordinal()
            r0 = r1[r0]
            switch(r0) {
                case 1: goto L1f;
                case 2: goto L22;
                case 3: goto L24;
                default: goto L1d;
            }
        L1d:
            r0 = 5
            goto L4
        L1f:
            r0 = 8
            goto L4
        L22:
            r0 = 7
            goto L4
        L24:
            r0 = 6
            goto L4
        L26:
            com.facebook.ads.VideoAutoplayBehavior r2 = com.facebook.ads.VideoAutoplayBehavior.DEFAULT
            r0 = 3
            goto L4
        L2a:
            com.facebook.ads.VideoAutoplayBehavior r2 = com.facebook.ads.VideoAutoplayBehavior.DEFAULT
            r0 = 3
            goto L4
        L2e:
            com.facebook.ads.VideoAutoplayBehavior r2 = com.facebook.ads.VideoAutoplayBehavior.ON
            r0 = 3
            goto L4
        L32:
            r0 = 4
            goto L4
        L34:
            com.facebook.ads.VideoAutoplayBehavior r2 = (com.facebook.ads.VideoAutoplayBehavior) r2
            com.facebook.ads.VideoAutoplayBehavior r2 = (com.facebook.ads.VideoAutoplayBehavior) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EnumC0447Hk.A00(com.facebook.ads.redexgen.X.Hk):com.facebook.ads.VideoAutoplayBehavior");
    }
}
