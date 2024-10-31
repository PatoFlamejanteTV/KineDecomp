package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.23, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public enum AnonymousClass23 {
    A03(A00(9, 9, 63)),
    A05(A00(65, 9, 19)),
    A04(A00(46, 19, 56));

    public static byte[] A01;
    public final String A00;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.AnonymousClass23.A01
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
            r0 = r0 ^ 69
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass23.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{68, 95, 95, 79, 67, 93, 81, 92, 92, 27, 12, 27, 19, 22, 27, 24, 22, 31, 66, 67, 83, 66, 77, 88, 69, 90, 73, 83, 77, 72, 83, 64, 77, 85, 67, 89, 88, 79, 88, 79, 71, 66, 79, 76, 66, 75, 19, 18, 34, 19, 28, 9, 20, 11, 24, 34, 28, 25, 34, 17, 28, 4, 18, 8, 9, 34, 57, 57, 9, 37, 59, 55, 58, 58};
    }

    static {
        A01();
    }

    AnonymousClass23(String str) {
        this.A00 = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.A00;
    }
}
