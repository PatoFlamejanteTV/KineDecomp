package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.2f, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public enum EnumC00602f {
    A05(A01(0, 16, 30)),
    A04(A01(16, 14, 50)),
    A03(A01(30, 13, 124));

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
            byte[] r1 = com.facebook.ads.redexgen.X.EnumC00602f.A01
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
            int r0 = r0 + (-44)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EnumC00602f.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A01 = new byte[]{-95, -113, -116, -96, -109, -113, -95, -87, -102, -100, -113, -115, -117, -115, -110, -113, -82, -80, -83, -74, -73, -67, -82, -80, -93, -95, -97, -95, -90, -93, -18, -15, -12, -19, 7, -8, -6, -19, -21, -23, -21, -16, -19};
    }

    static {
        A02();
    }

    EnumC00602f(String str) {
        this.A00 = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0033, code lost:            return r4;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.EnumC00602f A00(java.lang.String r5) {
        /*
            r4 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.2f[] r3 = values()
            int r2 = r3.length
            r1 = 0
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L15;
                case 4: goto L2f;
                case 5: goto L27;
                case 6: goto L2b;
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
            java.lang.String r5 = (java.lang.String) r5
            com.facebook.ads.redexgen.X.2f[] r3 = (com.facebook.ads.redexgen.X.EnumC00602f[]) r3
            r4 = r3[r1]
            java.lang.String r0 = r4.A00
            boolean r0 = r0.equalsIgnoreCase(r5)
            if (r0 == 0) goto L25
            r0 = 4
            goto Lb
        L25:
            r0 = 5
            goto Lb
        L27:
            int r1 = r1 + 1
            r0 = 2
            goto Lb
        L2b:
            com.facebook.ads.redexgen.X.2f r4 = com.facebook.ads.redexgen.X.EnumC00602f.A03
            r0 = 4
            goto Lb
        L2f:
            com.facebook.ads.redexgen.X.2f r4 = (com.facebook.ads.redexgen.X.EnumC00602f) r4
            com.facebook.ads.redexgen.X.2f r4 = (com.facebook.ads.redexgen.X.EnumC00602f) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EnumC00602f.A00(java.lang.String):com.facebook.ads.redexgen.X.2f");
    }
}
