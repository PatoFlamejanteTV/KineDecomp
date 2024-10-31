package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.13, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public enum AnonymousClass13 {
    A03,
    A02,
    A04;

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
            byte[] r1 = com.facebook.ads.redexgen.X.AnonymousClass13.A00
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
            int r0 = r0 + (-30)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass13.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A00 = new byte[]{-95, -90, -85, -84, -103, -92, -92, -99, -100, -119, -118, -119, Byte.MIN_VALUE, -47, -46, -41, -30, -52, -47, -42, -41, -60, -49, -49, -56, -57};
    }

    static {
        A02();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0026, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.AnonymousClass13 A00(java.lang.String r2) {
        /*
            r1 = 0
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 == 0) goto L20
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto L1c;
                case 3: goto L22;
                case 4: goto Lc;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            java.util.Locale r0 = java.util.Locale.US     // Catch: java.lang.IllegalArgumentException -> L18
            java.lang.String r0 = r2.toUpperCase(r0)     // Catch: java.lang.IllegalArgumentException -> L18
            com.facebook.ads.redexgen.X.13 r1 = valueOf(r0)     // Catch: java.lang.IllegalArgumentException -> L18
            r0 = 3
            goto L8
        L18:
            com.facebook.ads.redexgen.X.13 r1 = com.facebook.ads.redexgen.X.AnonymousClass13.A03
            r0 = 3
            goto L8
        L1c:
            com.facebook.ads.redexgen.X.13 r1 = com.facebook.ads.redexgen.X.AnonymousClass13.A03
            r0 = 3
            goto L8
        L20:
            r0 = 4
            goto L8
        L22:
            com.facebook.ads.redexgen.X.13 r1 = (com.facebook.ads.redexgen.X.AnonymousClass13) r1
            com.facebook.ads.redexgen.X.13 r1 = (com.facebook.ads.redexgen.X.AnonymousClass13) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass13.A00(java.lang.String):com.facebook.ads.redexgen.X.13");
    }
}
