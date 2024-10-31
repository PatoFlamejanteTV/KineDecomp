package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Kj, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0519Kj {
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
            byte[] r1 = com.facebook.ads.redexgen.X.C0519Kj.A00
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
            int r0 = r0 + (-115)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0519Kj.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A00 = new byte[]{8, 59, 38, 40, 51, 55, 44, 50, 49, -29, 44, 49, -29, 54, 38, 53, 40, 40, 49, -29, 44, 49, 55, 40, 53, 36, 38, 55, 44, 57, 40, -29, 38, 43, 40, 38, 46, -17, -29, 36, 54, 54, 56, 48, 44, 49, 42, -29, 44, 49, 55, 40, 53, 36, 38, 55, 44, 57, 40, -15, 70, 61, 71, 63, 77, 57, 56, 64, 46, 59};
    }

    static {
        A01();
        A01 = C0519Kj.class.getSimpleName();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0020, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A02(com.facebook.ads.redexgen.X.C0362Ec r2) {
        /*
            r1 = 0
            boolean r0 = A03(r2)
            if (r0 == 0) goto L1e
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L18;
                case 4: goto L20;
                case 5: goto L1b;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.Ec r2 = (com.facebook.ads.redexgen.X.C0362Ec) r2
            boolean r0 = com.facebook.ads.redexgen.X.C0520Kk.A03(r2)
            if (r0 == 0) goto L16
            r0 = 3
            goto L8
        L16:
            r0 = 5
            goto L8
        L18:
            r1 = 1
            r0 = 4
            goto L8
        L1b:
            r1 = 0
            r0 = 4
            goto L8
        L1e:
            r0 = 5
            goto L8
        L20:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0519Kj.A02(com.facebook.ads.redexgen.X.Ec):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x005c, code lost:            return r6;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A03(com.facebook.ads.redexgen.X.C0362Ec r7) {
        /*
            r0 = 0
            r5 = 0
            r6 = 1
            if (r7 != 0) goto L5a
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto L5c;
                case 3: goto L12;
                case 4: goto L9;
                case 5: goto L9;
                case 6: goto L9;
                case 7: goto L9;
                case 8: goto La;
                case 9: goto L9;
                case 10: goto L2e;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            android.os.PowerManager r5 = (android.os.PowerManager) r5     // Catch: java.lang.Exception -> L36
            boolean r6 = r5.isInteractive()     // Catch: java.lang.Exception -> L36
            r0 = 2
            goto L6
        L12:
            r2 = 65
            r1 = 5
            r0 = 86
            java.lang.String r0 = A00(r2, r1, r0)     // Catch: java.lang.Exception -> L36
            java.lang.Object r0 = r7.getSystemService(r0)     // Catch: java.lang.Exception -> L36
            r5 = r0
            android.os.PowerManager r5 = (android.os.PowerManager) r5     // Catch: java.lang.Exception -> L36
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L36
            r0 = 20
            if (r1 < r0) goto L2b
            r0 = 8
            goto L6
        L2b:
            r0 = 10
            goto L6
        L2e:
            android.os.PowerManager r5 = (android.os.PowerManager) r5     // Catch: java.lang.Exception -> L36
            boolean r6 = r5.isScreenOn()     // Catch: java.lang.Exception -> L36
            r0 = 2
            goto L6
        L36:
            r4 = move-exception
            java.lang.String r3 = com.facebook.ads.redexgen.X.C0519Kj.A01
            r2 = 0
            r1 = 60
            r0 = 80
            java.lang.String r0 = A00(r2, r1, r0)
            android.util.Log.e(r3, r0, r4)
            r2 = 60
            r1 = 5
            r0 = 97
            java.lang.String r2 = A00(r2, r1, r0)
            int r1 = com.facebook.ads.redexgen.X.C0512Kc.A1e
            com.facebook.ads.redexgen.X.Ke r0 = new com.facebook.ads.redexgen.X.Ke
            r0.<init>(r4)
            com.facebook.ads.redexgen.X.C0511Kb.A06(r7, r2, r1, r0)
            r0 = 2
            goto L6
        L5a:
            r0 = 3
            goto L6
        L5c:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0519Kj.A03(com.facebook.ads.redexgen.X.Ec):boolean");
    }
}
