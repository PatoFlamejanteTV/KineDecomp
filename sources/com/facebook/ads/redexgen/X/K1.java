package com.facebook.ads.redexgen.X;

/* loaded from: assets/audience_network.dex */
public final class K1 {
    public static byte[] A00;

    static {
        A02();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.K1.A00
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
            r0 = r0 ^ 30
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.K1.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A00 = new byte[]{Byte.MAX_VALUE, 115, 114, 114, 121, Byte.MAX_VALUE, 104, 117, 106, 117, 104, 101, 89, 86, 92, 74, 87, 81, 92, 22, 72, 93, 74, 85, 81, 75, 75, 81, 87, 86, 22, 121, 123, 123, 125, 107, 107, 103, 118, 125, 108, 111, 119, 106, 115, 103, 107, 108, 121, 108, 125};
    }

    /* JADX WARN: Code restructure failed: missing block: B:108:0x00aa, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.K0 A00(android.content.Context r5) {
        /*
            r4 = 0
            r3 = 0
            r2 = 12
            r1 = 39
            r0 = 38
            java.lang.String r0 = A01(r2, r1, r0)
            int r0 = r5.checkCallingOrSelfPermission(r0)
            if (r0 == 0) goto La3
            r0 = 2
        L13:
            switch(r0) {
                case 2: goto L53;
                case 3: goto La6;
                case 4: goto L2b;
                case 5: goto L1f;
                case 6: goto L17;
                case 7: goto L45;
                case 8: goto L57;
                case 9: goto L1b;
                case 10: goto L90;
                case 11: goto L94;
                case 12: goto L99;
                case 13: goto L9e;
                default: goto L16;
            }
        L16:
            goto L13
        L17:
            com.facebook.ads.redexgen.X.K0 r3 = com.facebook.ads.redexgen.X.K0.A07
            r0 = 3
            goto L13
        L1b:
            com.facebook.ads.redexgen.X.K0 r3 = com.facebook.ads.redexgen.X.K0.A08
            r0 = 3
            goto L13
        L1f:
            android.net.NetworkInfo r4 = (android.net.NetworkInfo) r4
            boolean r0 = r4.isConnected()
            if (r0 != 0) goto L29
            r0 = 6
            goto L13
        L29:
            r0 = 7
            goto L13
        L2b:
            android.content.Context r5 = (android.content.Context) r5
            r2 = 0
            r1 = 12
            r0 = 2
            java.lang.String r0 = A01(r2, r1, r0)
            java.lang.Object r0 = r5.getSystemService(r0)
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            android.net.NetworkInfo r4 = r0.getActiveNetworkInfo()
            if (r4 == 0) goto L43
            r0 = 5
            goto L13
        L43:
            r0 = 6
            goto L13
        L45:
            android.net.NetworkInfo r4 = (android.net.NetworkInfo) r4
            int r0 = r4.getType()
            if (r0 != 0) goto L50
            r0 = 8
            goto L13
        L50:
            r0 = 13
            goto L13
        L53:
            com.facebook.ads.redexgen.X.K0 r3 = com.facebook.ads.redexgen.X.K0.A08
            r0 = 3
            goto L13
        L57:
            android.net.NetworkInfo r4 = (android.net.NetworkInfo) r4
            int r0 = r4.getSubtype()
            switch(r0) {
                case 1: goto L63;
                case 2: goto L66;
                case 3: goto L72;
                case 4: goto L69;
                case 5: goto L75;
                case 6: goto L78;
                case 7: goto L6c;
                case 8: goto L7b;
                case 9: goto L7e;
                case 10: goto L81;
                case 11: goto L6f;
                case 12: goto L84;
                case 13: goto L8d;
                case 14: goto L87;
                case 15: goto L8a;
                default: goto L60;
            }
        L60:
            r0 = 9
            goto L13
        L63:
            r0 = 12
            goto L13
        L66:
            r0 = 12
            goto L13
        L69:
            r0 = 12
            goto L13
        L6c:
            r0 = 12
            goto L13
        L6f:
            r0 = 12
            goto L13
        L72:
            r0 = 11
            goto L13
        L75:
            r0 = 11
            goto L13
        L78:
            r0 = 11
            goto L13
        L7b:
            r0 = 11
            goto L13
        L7e:
            r0 = 11
            goto L13
        L81:
            r0 = 11
            goto L13
        L84:
            r0 = 11
            goto L13
        L87:
            r0 = 11
            goto L13
        L8a:
            r0 = 11
            goto L13
        L8d:
            r0 = 10
            goto L13
        L90:
            com.facebook.ads.redexgen.X.K0 r3 = com.facebook.ads.redexgen.X.K0.A05
            r0 = 3
            goto L13
        L94:
            com.facebook.ads.redexgen.X.K0 r3 = com.facebook.ads.redexgen.X.K0.A04
            r0 = 3
            goto L13
        L99:
            com.facebook.ads.redexgen.X.K0 r3 = com.facebook.ads.redexgen.X.K0.A03
            r0 = 3
            goto L13
        L9e:
            com.facebook.ads.redexgen.X.K0 r3 = com.facebook.ads.redexgen.X.K0.A06
            r0 = 3
            goto L13
        La3:
            r0 = 4
            goto L13
        La6:
            com.facebook.ads.redexgen.X.K0 r3 = (com.facebook.ads.redexgen.X.K0) r3
            com.facebook.ads.redexgen.X.K0 r3 = (com.facebook.ads.redexgen.X.K0) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.K1.A00(android.content.Context):com.facebook.ads.redexgen.X.K0");
    }
}
