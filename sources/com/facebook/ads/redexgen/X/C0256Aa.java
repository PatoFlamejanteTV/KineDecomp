package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Aa, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0256Aa {
    public static byte[] A01;
    public static final String[] A02;
    public final float[] A00;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C0256Aa.A01
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
            r0 = r0 ^ 21
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0256Aa.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{105, 107, 30, 112, 38};
    }

    static {
        A01();
        A02 = new String[]{A00(2, 1, 115), A00(1, 1, 7), A00(0, 1, 6), A00(4, 1, 68)};
    }

    public C0256Aa(float[] fArr) {
        this.A00 = fArr;
    }

    private final float[] A02() {
        return this.A00;
    }

    public final int A03() {
        return this.A00.length * 4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0038, code lost:            r7 = r7;        r7.put(A00(3, 1, 19), r3);     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0049, code lost:            return r7;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final org.json.JSONObject A04(org.json.JSONObject r7) throws org.json.JSONException {
        /*
            r6 = this;
            r5 = r6
            r0 = 0
            r0 = 0
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            r4 = 0
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L19;
                case 4: goto L22;
                case 5: goto L34;
                case 6: goto L38;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.Aa r5 = (com.facebook.ads.redexgen.X.C0256Aa) r5
            float[] r0 = r5.A00
            int r0 = r0.length
            if (r4 >= r0) goto L17
            r0 = 3
            goto La
        L17:
            r0 = 6
            goto La
        L19:
            java.lang.String[] r0 = com.facebook.ads.redexgen.X.C0256Aa.A02
            int r0 = r0.length
            if (r4 >= r0) goto L20
            r0 = 4
            goto La
        L20:
            r0 = 5
            goto La
        L22:
            com.facebook.ads.redexgen.X.Aa r5 = (com.facebook.ads.redexgen.X.C0256Aa) r5
            org.json.JSONObject r3 = (org.json.JSONObject) r3
            java.lang.String[] r0 = com.facebook.ads.redexgen.X.C0256Aa.A02
            r2 = r0[r4]
            float[] r0 = r5.A00
            r0 = r0[r4]
            double r0 = (double) r0
            r3.put(r2, r0)
            r0 = 5
            goto La
        L34:
            int r4 = r4 + 1
            r0 = 2
            goto La
        L38:
            org.json.JSONObject r7 = (org.json.JSONObject) r7
            org.json.JSONObject r3 = (org.json.JSONObject) r3
            r2 = 3
            r1 = 1
            r0 = 19
            java.lang.String r0 = A00(r2, r1, r0)
            r7.put(r0, r3)
            org.json.JSONObject r7 = (org.json.JSONObject) r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0256Aa.A04(org.json.JSONObject):org.json.JSONObject");
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0046, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A05(com.facebook.ads.redexgen.X.C0256Aa r7) {
        /*
            r6 = this;
            r5 = r6
            r4 = 0
            r0 = 0
            r0 = 0
            r3 = 0
            float[] r2 = r7.A02()
            int r1 = r2.length
            float[] r0 = r5.A00
            int r0 = r0.length
            if (r1 == r0) goto L44
            r0 = 2
        L10:
            switch(r0) {
                case 2: goto L46;
                case 3: goto L3e;
                case 4: goto L35;
                case 5: goto L18;
                case 6: goto L14;
                case 7: goto L41;
                default: goto L13;
            }
        L13:
            goto L10
        L14:
            int r4 = r4 + 1
            r0 = 4
            goto L10
        L18:
            com.facebook.ads.redexgen.X.Aa r5 = (com.facebook.ads.redexgen.X.C0256Aa) r5
            float[] r2 = (float[]) r2
            float[] r0 = r5.A02()
            r1 = r0[r4]
            r0 = r2[r4]
            float r1 = r1 - r0
            float r1 = java.lang.Math.abs(r1)
            float r0 = com.facebook.ads.redexgen.X.AA.A01()
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 > 0) goto L33
            r0 = 6
            goto L10
        L33:
            r0 = 2
            goto L10
        L35:
            float[] r2 = (float[]) r2
            int r0 = r2.length
            if (r4 >= r0) goto L3c
            r0 = 5
            goto L10
        L3c:
            r0 = 7
            goto L10
        L3e:
            r4 = 0
            r0 = 4
            goto L10
        L41:
            r3 = 1
            r0 = 2
            goto L10
        L44:
            r0 = 3
            goto L10
        L46:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0256Aa.A05(com.facebook.ads.redexgen.X.Aa):boolean");
    }
}
