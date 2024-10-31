package com.facebook.ads.redexgen.X;

/* loaded from: assets/audience_network.dex */
public final class KF {
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
            byte[] r1 = com.facebook.ads.redexgen.X.KF.A00
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
            r0 = r0 ^ 68
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.KF.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A00 = new byte[]{25, 67, 82, 71, 67, 88, 69, 75, 87, 73, 91, 79, 92, 74, 76, 93, 95, 80, 92, 115, 117, 114, 98, 10, 6, 19};
    }

    static {
        A01();
        A01 = KF.class.getSimpleName();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x002c, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A02(android.content.Context r4) {
        /*
            r3 = 0
            r0 = 0
            r2 = 6
            r1 = 8
            r0 = 106(0x6a, float:1.49E-43)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.KF.A02(android.content.Context):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x00a4, code lost:            return r6;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A03(java.util.Map<java.lang.String, java.lang.String> r7) {
        /*
            r5 = 0
            r4 = 0
            r3 = 0
            r0 = 0
            r6 = 0
            if (r7 == 0) goto La1
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto L5f;
                case 3: goto La4;
                case 4: goto L28;
                case 5: goto L14;
                case 6: goto Lc;
                case 7: goto L74;
                case 8: goto L6b;
                case 9: goto L89;
                case 10: goto L5c;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L12
            r0 = 7
            goto L8
        L12:
            r0 = 3
            goto L8
        L14:
            java.lang.String r3 = (java.lang.String) r3
            r2 = 0
            r1 = 1
            r0 = 108(0x6c, float:1.51E-43)
            java.lang.String r0 = A00(r2, r1, r0)
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L26
            r0 = 6
            goto L8
        L26:
            r0 = 3
            goto L8
        L28:
            java.util.Map r7 = (java.util.Map) r7
            r2 = 14
            r1 = 5
            r0 = 127(0x7f, float:1.78E-43)
            java.lang.String r0 = A00(r2, r1, r0)
            java.lang.Object r3 = r7.get(r0)
            java.lang.String r3 = (java.lang.String) r3
            r2 = 1
            r1 = 5
            r0 = 112(0x70, float:1.57E-43)
            java.lang.String r0 = A00(r2, r1, r0)
            java.lang.Object r4 = r7.get(r0)
            java.lang.String r4 = (java.lang.String) r4
            r2 = 23
            r1 = 3
            r0 = 37
            java.lang.String r0 = A00(r2, r1, r0)
            java.lang.Object r5 = r7.get(r0)
            java.lang.String r5 = (java.lang.String) r5
            if (r3 == 0) goto L5a
            r0 = 5
            goto L8
        L5a:
            r0 = 3
            goto L8
        L5c:
            r6 = 1
            r0 = 3
            goto L8
        L5f:
            java.util.Map r7 = (java.util.Map) r7
            boolean r0 = r7.isEmpty()
            if (r0 == 0) goto L69
            r0 = 3
            goto L8
        L69:
            r0 = 4
            goto L8
        L6b:
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L72
            r0 = 9
            goto L8
        L72:
            r0 = 3
            goto L8
        L74:
            java.lang.String r4 = (java.lang.String) r4
            r2 = 0
            r1 = 1
            r0 = 108(0x6c, float:1.51E-43)
            java.lang.String r0 = A00(r2, r1, r0)
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L87
            r0 = 8
            goto L8
        L87:
            r0 = 3
            goto L8
        L89:
            java.lang.String r5 = (java.lang.String) r5
            r2 = 19
            r1 = 4
            r0 = 67
            java.lang.String r0 = A00(r2, r1, r0)
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L9e
            r0 = 10
            goto L8
        L9e:
            r0 = 3
            goto L8
        La1:
            r0 = 3
            goto L8
        La4:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.KF.A03(java.util.Map):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x00a6, code lost:            return r6;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A04(java.util.Map<java.lang.String, java.lang.String> r7) {
        /*
            r5 = 0
            r4 = 0
            r3 = 0
            r0 = 0
            r6 = 0
            if (r7 == 0) goto La3
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto L51;
                case 3: goto La6;
                case 4: goto L29;
                case 5: goto L15;
                case 6: goto Lc;
                case 7: goto L5d;
                case 8: goto L72;
                case 9: goto L8b;
                case 10: goto L4e;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L12
            r0 = 7
            goto L8
        L12:
            r0 = 8
            goto L8
        L15:
            java.lang.String r3 = (java.lang.String) r3
            r2 = 0
            r1 = 1
            r0 = 108(0x6c, float:1.51E-43)
            java.lang.String r0 = A00(r2, r1, r0)
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L27
            r0 = 6
            goto L8
        L27:
            r0 = 3
            goto L8
        L29:
            java.util.Map r7 = (java.util.Map) r7
            r2 = 14
            r1 = 5
            r0 = 127(0x7f, float:1.78E-43)
            java.lang.String r0 = A00(r2, r1, r0)
            java.lang.Object r3 = r7.get(r0)
            java.lang.String r3 = (java.lang.String) r3
            r2 = 1
            r1 = 5
            r0 = 112(0x70, float:1.57E-43)
            java.lang.String r0 = A00(r2, r1, r0)
            java.lang.Object r4 = r7.get(r0)
            java.lang.String r4 = (java.lang.String) r4
            if (r3 == 0) goto L4c
            r0 = 5
            goto L8
        L4c:
            r0 = 6
            goto L8
        L4e:
            r6 = 1
            r0 = 3
            goto L8
        L51:
            java.util.Map r7 = (java.util.Map) r7
            boolean r0 = r7.isEmpty()
            if (r0 == 0) goto L5b
            r0 = 3
            goto L8
        L5b:
            r0 = 4
            goto L8
        L5d:
            java.lang.String r4 = (java.lang.String) r4
            r2 = 0
            r1 = 1
            r0 = 108(0x6c, float:1.51E-43)
            java.lang.String r0 = A00(r2, r1, r0)
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L70
            r0 = 8
            goto L8
        L70:
            r0 = 3
            goto L8
        L72:
            java.util.Map r7 = (java.util.Map) r7
            r2 = 23
            r1 = 3
            r0 = 37
            java.lang.String r0 = A00(r2, r1, r0)
            java.lang.Object r5 = r7.get(r0)
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L88
            r0 = 9
            goto L8
        L88:
            r0 = 3
            goto L8
        L8b:
            java.lang.String r5 = (java.lang.String) r5
            r2 = 19
            r1 = 4
            r0 = 67
            java.lang.String r0 = A00(r2, r1, r0)
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto La0
            r0 = 10
            goto L8
        La0:
            r0 = 3
            goto L8
        La3:
            r0 = 3
            goto L8
        La6:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.KF.A04(java.util.Map):boolean");
    }
}
