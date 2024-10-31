package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Kk, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0520Kk {
    public static byte[] A00;
    public static final String A01;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C0520Kk.A00
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
            int r0 = r0 + (-81)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0520Kk.A00(int, int, int):java.lang.String");
    }

    public static void A02() {
        A00 = new byte[]{-40, 16, -1, 12, 16, 5, 26, 17, 27, 19, 33, -64, -70, -50, -68, -54, -74, -57, -71, -92, 48, 31, 29, 36, 32, -85, -34, -55, -53, -42, -38, -49, -43, -44, -122, -49, -44, -122, -35, -49, -44, -54, -43, -35, -122, -49, -44, -52, -43, -122, -55, -50, -53, -55, -47, 3, -1, 10, 7, 4};
    }

    static {
        A02();
        A01 = C0520Kk.class.getSimpleName();
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a2, code lost:            r5.put(A00(1, 5, 72), r4);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Map<java.lang.String, java.lang.String> A01(com.facebook.ads.redexgen.X.C0362Ec r8) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0520Kk.A01(com.facebook.ads.redexgen.X.Ec):java.util.Map");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0018, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A03(com.facebook.ads.redexgen.X.C0362Ec r2) {
        /*
            r1 = 0
            java.util.Map r0 = A01(r2)
            boolean r0 = com.facebook.ads.redexgen.X.KF.A04(r0)
            if (r0 != 0) goto L16
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L18;
                case 4: goto L13;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            r1 = 1
            r0 = 3
            goto Lc
        L13:
            r1 = 0
            r0 = 3
            goto Lc
        L16:
            r0 = 4
            goto Lc
        L18:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0520Kk.A03(com.facebook.ads.redexgen.X.Ec):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x002c, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A04(com.facebook.ads.redexgen.X.C0362Ec r4) {
        /*
            r3 = 0
            r0 = 0
            r2 = 11
            r1 = 8
            r0 = 4
            java.lang.String r0 = A00(r2, r1, r0)
            java.lang.Object r1 = r4.getSystemService(r0)
            android.app.KeyguardManager r1 = (android.app.KeyguardManager) r1
            if (r1 == 0) goto L2a
            r0 = 2
        L14:
            switch(r0) {
                case 2: goto L18;
                case 3: goto L24;
                case 4: goto L2c;
                case 5: goto L27;
                default: goto L17;
            }
        L17:
            goto L14
        L18:
            android.app.KeyguardManager r1 = (android.app.KeyguardManager) r1
            boolean r0 = r1.inKeyguardRestrictedInputMode()
            if (r0 == 0) goto L22
            r0 = 3
            goto L14
        L22:
            r0 = 5
            goto L14
        L24:
            r3 = 1
            r0 = 4
            goto L14
        L27:
            r3 = 0
            r0 = 4
            goto L14
        L2a:
            r0 = 5
            goto L14
        L2c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0520Kk.A04(com.facebook.ads.redexgen.X.Ec):boolean");
    }
}
