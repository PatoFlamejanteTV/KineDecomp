package com.facebook.ads.internal.protocol;

/* loaded from: assets/audience_network.dex */
public enum AdPlacementType {
    BANNER(A00(27, 6, 78)),
    INSTREAM(A00(19, 8, 93)),
    INTERSTITIAL(A00(0, 12, 91)),
    NATIVE(A00(47, 6, 9)),
    NATIVE_BANNER(A00(74, 13, 10)),
    REWARDED_VIDEO(A00(33, 14, 67)),
    UNKNOWN(A00(12, 7, 24));

    public static byte[] A01;
    public String A00;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.internal.protocol.AdPlacementType.A01
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
            int r0 = r0 + (-56)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.protocol.AdPlacementType.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{-4, 1, 7, -8, 5, 6, 7, -4, 7, -4, -12, -1, -59, -66, -69, -66, -65, -57, -66, -2, 3, 8, 9, 7, -6, -10, 2, -24, -25, -12, -12, -21, -8, -19, -32, -14, -36, -19, -33, -32, -33, -38, -15, -28, -33, -32, -22, -81, -94, -75, -86, -73, -90, -5, 0, 5, 6, 4, -9, -13, -1, -33, -46, -27, -38, -25, -42, -16, -45, -46, -33, -33, -42, -29, -80, -93, -74, -85, -72, -89, -95, -92, -93, -80, -80, -89, -76, -83, -96, -77, -88, -75, -92, -64, -59, -53, -68, -55, -54, -53, -64, -53, -64, -72, -61, -23, -36, -18, -40, -23, -37, -36, -37, -10, -19, -32, -37, -36, -26, -3, -10, -13, -10, -9, -1, -10, -70, -71, -58, -58, -67, -54};
    }

    static {
        A01();
    }

    AdPlacementType(String str) {
        this.A00 = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0026, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.internal.protocol.AdPlacementType fromString(java.lang.String r2) {
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
            java.util.Locale r0 = java.util.Locale.US     // Catch: java.lang.Exception -> L18
            java.lang.String r0 = r2.toUpperCase(r0)     // Catch: java.lang.Exception -> L18
            com.facebook.ads.internal.protocol.AdPlacementType r1 = valueOf(r0)     // Catch: java.lang.Exception -> L18
            r0 = 3
            goto L8
        L18:
            com.facebook.ads.internal.protocol.AdPlacementType r1 = com.facebook.ads.internal.protocol.AdPlacementType.UNKNOWN
            r0 = 3
            goto L8
        L1c:
            com.facebook.ads.internal.protocol.AdPlacementType r1 = com.facebook.ads.internal.protocol.AdPlacementType.UNKNOWN
            r0 = 3
            goto L8
        L20:
            r0 = 4
            goto L8
        L22:
            com.facebook.ads.internal.protocol.AdPlacementType r1 = (com.facebook.ads.internal.protocol.AdPlacementType) r1
            com.facebook.ads.internal.protocol.AdPlacementType r1 = (com.facebook.ads.internal.protocol.AdPlacementType) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.protocol.AdPlacementType.fromString(java.lang.String):com.facebook.ads.internal.protocol.AdPlacementType");
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.A00;
    }
}
