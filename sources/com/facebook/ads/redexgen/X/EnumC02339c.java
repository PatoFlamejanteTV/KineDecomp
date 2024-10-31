package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.9c, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public enum EnumC02339c {
    A03(A01(0, 5, 9)),
    A05(A01(5, 5, 99)),
    A04(A01(26, 6, 16));

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
            byte[] r1 = com.facebook.ads.redexgen.X.EnumC02339c.A01
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
            int r0 = r0 + (-36)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EnumC02339c.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A01 = new byte[]{-106, -102, -114, -108, -110, -3, -16, -21, -20, -10, -119, 125, -114, -121, -111, -116, -91, -87, -99, -93, -95, -71, -84, -89, -88, -78, -95, -107, -90, -97, -87, -92};
    }

    static {
        A02();
    }

    EnumC02339c(String str) {
        this.A00 = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0030, code lost:            return r4;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.EnumC02339c A00(@android.support.annotation.Nullable java.lang.String r5) {
        /*
            r4 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.9c[] r3 = values()
            int r2 = r3.length
            r1 = 0
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L15;
                case 4: goto L2e;
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
            com.facebook.ads.redexgen.X.9c[] r3 = (com.facebook.ads.redexgen.X.EnumC02339c[]) r3
            r4 = r3[r1]
            java.lang.String r0 = r4.A00
            boolean r0 = r0.equals(r5)
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
            r4 = 0
            r0 = 4
            goto Lb
        L2e:
            com.facebook.ads.redexgen.X.9c r4 = (com.facebook.ads.redexgen.X.EnumC02339c) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EnumC02339c.A00(java.lang.String):com.facebook.ads.redexgen.X.9c");
    }
}
