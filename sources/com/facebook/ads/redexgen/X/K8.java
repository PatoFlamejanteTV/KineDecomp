package com.facebook.ads.redexgen.X;

/* loaded from: assets/audience_network.dex */
public final class K8 {
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
            byte[] r1 = com.facebook.ads.redexgen.X.K8.A00
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
            int r0 = r0 + (-67)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.K8.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A00 = new byte[]{-38, 13, 18, 16, 13, 18, 9, -75, -58, -38, -39, -44, -43, -47, -58, -34, -64, -44, -61, -56, -50};
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0039, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static float A00(android.content.Context r7) {
        /*
            r6 = 0
            r5 = 0
            r0 = 0
            r1 = 0
            r0 = 0
            r4 = 3
            r3 = 16
            r2 = 5
            r0 = 28
            java.lang.String r0 = A01(r3, r2, r0)
            java.lang.Object r2 = r7.getSystemService(r0)
            android.media.AudioManager r2 = (android.media.AudioManager) r2
            if (r2 == 0) goto L37
            r0 = 2
        L18:
            switch(r0) {
                case 2: goto L1c;
                case 3: goto L2c;
                case 4: goto L39;
                case 5: goto L34;
                default: goto L1b;
            }
        L1b:
            goto L18
        L1c:
            android.media.AudioManager r2 = (android.media.AudioManager) r2
            int r5 = r2.getStreamVolume(r4)
            int r6 = r2.getStreamMaxVolume(r4)
            if (r6 <= 0) goto L2a
            r0 = 3
            goto L18
        L2a:
            r0 = 5
            goto L18
        L2c:
            float r1 = (float) r5
            r0 = 1065353216(0x3f800000, float:1.0)
            float r1 = r1 * r0
            float r0 = (float) r6
            float r1 = r1 / r0
            r0 = 4
            goto L18
        L34:
            r1 = 0
            r0 = 4
            goto L18
        L37:
            r0 = 5
            goto L18
        L39:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.K8.A00(android.content.Context):float");
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0056, code lost:            r7.put(r4, r6);     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005f, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A03(java.util.Map<java.lang.String, java.lang.String> r7, boolean r8, boolean r9) {
        /*
            r6 = 0
            r5 = 0
            r0 = 0
            r4 = 0
            r2 = 8
            r1 = 8
            r0 = 34
            java.lang.String r3 = A01(r2, r1, r0)
            if (r8 == 0) goto L54
            r0 = 2
        L11:
            switch(r0) {
                case 2: goto L40;
                case 3: goto L29;
                case 4: goto L1f;
                case 5: goto L56;
                case 6: goto L15;
                case 7: goto L4a;
                default: goto L14;
            }
        L14:
            goto L11
        L15:
            r2 = 7
            r1 = 1
            r0 = 66
            java.lang.String r6 = A01(r2, r1, r0)
            r0 = 5
            goto L11
        L1f:
            r2 = 0
            r1 = 1
            r0 = 102(0x66, float:1.43E-43)
            java.lang.String r6 = A01(r2, r1, r0)
            r0 = 5
            goto L11
        L29:
            java.util.Map r7 = (java.util.Map) r7
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r5 = (java.lang.String) r5
            r7.put(r3, r5)
            r2 = 1
            r1 = 6
            r0 = 97
            java.lang.String r4 = A01(r2, r1, r0)
            if (r9 == 0) goto L3e
            r0 = 4
            goto L11
        L3e:
            r0 = 6
            goto L11
        L40:
            r2 = 0
            r1 = 1
            r0 = 102(0x66, float:1.43E-43)
            java.lang.String r5 = A01(r2, r1, r0)
            r0 = 3
            goto L11
        L4a:
            r2 = 7
            r1 = 1
            r0 = 66
            java.lang.String r5 = A01(r2, r1, r0)
            r0 = 3
            goto L11
        L54:
            r0 = 7
            goto L11
        L56:
            java.util.Map r7 = (java.util.Map) r7
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r6 = (java.lang.String) r6
            r7.put(r4, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.K8.A03(java.util.Map, boolean, boolean):void");
    }
}
