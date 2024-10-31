package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.9b, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C02329b implements InterfaceC02319a {
    public static byte[] A02;
    public final EnumC02339c A00;
    public final String A01;

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
            byte[] r1 = com.facebook.ads.redexgen.X.C02329b.A02
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
            r0 = r0 ^ 105(0x69, float:1.47E-43)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02329b.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A02 = new byte[]{56, 63, 33, 32, 45, 36, 49};
    }

    public C02329b(EnumC02339c enumC02339c, String str) {
        this.A00 = enumC02339c;
        this.A01 = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0040, code lost:            return r4;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.C02329b A00(org.json.JSONObject r5) {
        /*
            r0 = 0
            r0 = 0
            r4 = 0
            r2 = 3
            r1 = 4
            r0 = 61
            java.lang.String r0 = A01(r2, r1, r0)
            java.lang.String r0 = r5.optString(r0)
            com.facebook.ads.redexgen.X.9c r3 = com.facebook.ads.redexgen.X.EnumC02339c.A00(r0)
            r2 = 0
            r1 = 3
            r0 = 36
            java.lang.String r0 = A01(r2, r1, r0)
            java.lang.String r1 = r5.optString(r0)
            if (r3 == 0) goto L3c
            r0 = 2
        L22:
            switch(r0) {
                case 2: goto L26;
                case 3: goto L2e;
                case 4: goto L3e;
                case 5: goto L31;
                default: goto L25;
            }
        L25:
            goto L22
        L26:
            java.lang.String r1 = (java.lang.String) r1
            if (r1 != 0) goto L2c
            r0 = 3
            goto L22
        L2c:
            r0 = 5
            goto L22
        L2e:
            r4 = 0
            r0 = 4
            goto L22
        L31:
            com.facebook.ads.redexgen.X.9c r3 = (com.facebook.ads.redexgen.X.EnumC02339c) r3
            java.lang.String r1 = (java.lang.String) r1
            com.facebook.ads.redexgen.X.9b r4 = new com.facebook.ads.redexgen.X.9b
            r4.<init>(r3, r1)
            r0 = 4
            goto L22
        L3c:
            r0 = 3
            goto L22
        L3e:
            com.facebook.ads.redexgen.X.9b r4 = (com.facebook.ads.redexgen.X.C02329b) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02329b.A00(org.json.JSONObject):com.facebook.ads.redexgen.X.9b");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC02319a
    public final EnumC02339c A51() {
        return this.A00;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0049, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r4 = r5
            r3 = 0
            r0 = 0
            r2 = 0
            if (r4 != r6) goto L47
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto L36;
                case 3: goto L49;
                case 4: goto L2e;
                case 5: goto L1c;
                case 6: goto Lb;
                case 7: goto L39;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.9b r4 = (com.facebook.ads.redexgen.X.C02329b) r4
            java.lang.Object r6 = (java.lang.Object) r6
            r3 = r6
            com.facebook.ads.redexgen.X.9b r3 = (com.facebook.ads.redexgen.X.C02329b) r3
            com.facebook.ads.redexgen.X.9c r1 = r4.A00
            com.facebook.ads.redexgen.X.9c r0 = r3.A00
            if (r1 != r0) goto L1a
            r0 = 7
            goto L7
        L1a:
            r0 = 3
            goto L7
        L1c:
            com.facebook.ads.redexgen.X.9b r4 = (com.facebook.ads.redexgen.X.C02329b) r4
            java.lang.Object r6 = (java.lang.Object) r6
            java.lang.Class r1 = r4.getClass()
            java.lang.Class r0 = r6.getClass()
            if (r1 != r0) goto L2c
            r0 = 6
            goto L7
        L2c:
            r0 = 3
            goto L7
        L2e:
            java.lang.Object r6 = (java.lang.Object) r6
            if (r6 == 0) goto L34
            r0 = 5
            goto L7
        L34:
            r0 = 3
            goto L7
        L36:
            r2 = 1
            r0 = 3
            goto L7
        L39:
            com.facebook.ads.redexgen.X.9b r4 = (com.facebook.ads.redexgen.X.C02329b) r4
            com.facebook.ads.redexgen.X.9b r3 = (com.facebook.ads.redexgen.X.C02329b) r3
            java.lang.String r1 = r4.A01
            java.lang.String r0 = r3.A01
            boolean r2 = r1.equals(r0)
            r0 = 3
            goto L7
        L47:
            r0 = 4
            goto L7
        L49:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02329b.equals(java.lang.Object):boolean");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC02319a
    public final String getUrl() {
        return this.A01;
    }

    public final int hashCode() {
        return (this.A00.hashCode() * 31) + this.A01.hashCode();
    }
}
