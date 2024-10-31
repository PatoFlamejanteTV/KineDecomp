package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.10, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public enum AnonymousClass10 {
    A02,
    A03;

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
            byte[] r1 = com.facebook.ads.redexgen.X.AnonymousClass10.A00
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
            r0 = r0 ^ 119(0x77, float:1.67E-43)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass10.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A00 = new byte[]{119, 117, 122, 122, 123, 96, 107, 123, 100, 113, 122, 97, 99, 108, 108, 109, 118, 125, 118, 112, 99, 97, 105};
    }

    static {
        A01();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0024, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A02(@android.support.annotation.Nullable com.facebook.ads.redexgen.X.AnonymousClass10 r2) {
        /*
            r1 = 0
            com.facebook.ads.redexgen.X.10 r0 = com.facebook.ads.redexgen.X.AnonymousClass10.A02
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L22
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L1c;
                case 4: goto L24;
                case 5: goto L1f;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.10 r2 = (com.facebook.ads.redexgen.X.AnonymousClass10) r2
            com.facebook.ads.redexgen.X.10 r0 = com.facebook.ads.redexgen.X.AnonymousClass10.A03
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L1a
            r0 = 3
            goto La
        L1a:
            r0 = 5
            goto La
        L1c:
            r1 = 1
            r0 = 4
            goto La
        L1f:
            r1 = 0
            r0 = 4
            goto La
        L22:
            r0 = 3
            goto La
        L24:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass10.A02(com.facebook.ads.redexgen.X.10):boolean");
    }
}
