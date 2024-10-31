package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.api.NativeAdImageApi;

/* loaded from: assets/audience_network.dex */
public final class HY implements NativeAdImageApi {
    public static byte[] A03;
    public final int A00;
    public final int A01;
    public final String A02;

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
            byte[] r1 = com.facebook.ads.redexgen.X.HY.A03
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HY.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A03 = new byte[]{110, 105, 119, 2, 28, 17, 1, 29, 55, 58, 54, 56, 55, 43};
    }

    public HY(String str, int i, int i2) {
        this.A02 = str;
        this.A01 = i;
        this.A00 = i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0048, code lost:            return r4;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.HY A00(org.json.JSONObject r6) {
        /*
            r0 = 0
            r0 = 0
            r5 = 0
            r4 = 0
            r0 = 0
            if (r6 != 0) goto L44
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto L46;
                case 3: goto Lc;
                case 4: goto L1f;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            org.json.JSONObject r6 = (org.json.JSONObject) r6
            r2 = 0
            r1 = 3
            r0 = 5
            java.lang.String r0 = A01(r2, r1, r0)
            java.lang.String r5 = r6.optString(r0)
            if (r5 == 0) goto L1d
            r0 = 4
            goto L8
        L1d:
            r0 = 2
            goto L8
        L1f:
            org.json.JSONObject r6 = (org.json.JSONObject) r6
            java.lang.String r5 = (java.lang.String) r5
            r4 = 0
            r2 = 3
            r1 = 5
            r0 = 107(0x6b, float:1.5E-43)
            java.lang.String r0 = A01(r2, r1, r0)
            int r3 = r6.optInt(r0, r4)
            r2 = 8
            r1 = 6
            r0 = 65
            java.lang.String r0 = A01(r2, r1, r0)
            int r0 = r6.optInt(r0, r4)
            com.facebook.ads.redexgen.X.HY r4 = new com.facebook.ads.redexgen.X.HY
            r4.<init>(r5, r3, r0)
            r0 = 2
            goto L8
        L44:
            r0 = 3
            goto L8
        L46:
            com.facebook.ads.redexgen.X.HY r4 = (com.facebook.ads.redexgen.X.HY) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HY.A00(org.json.JSONObject):com.facebook.ads.redexgen.X.HY");
    }

    public final int getHeight() {
        return this.A00;
    }

    public final String getUrl() {
        return this.A02;
    }

    public final int getWidth() {
        return this.A01;
    }
}
