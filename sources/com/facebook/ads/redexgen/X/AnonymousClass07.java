package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.07, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public enum AnonymousClass07 {
    A03(A00(0, 4, 91)),
    A04(A00(8, 6, 11));

    public static byte[] A01;
    public String A00;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.AnonymousClass07.A01
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
            r0 = r0 ^ 1
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass07.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{60, 51, 54, 54, 87, 88, 93, 93, Byte.MAX_VALUE, 122, 110, 107, 126, 111, 119, 114, 102, 99, 118, 103};
    }

    static {
        A01();
    }

    AnonymousClass07(String str) {
        this.A00 = str;
    }

    public final String A02() {
        return this.A00;
    }
}
