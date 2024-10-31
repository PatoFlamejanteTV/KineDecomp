package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.api.NativeAdRatingApi;

/* renamed from: com.facebook.ads.redexgen.X.Hg, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0443Hg implements NativeAdRatingApi {
    public static byte[] A02;
    public final double A00;
    public final double A01;

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
            byte[] r1 = com.facebook.ads.redexgen.X.C0443Hg.A02
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
            r0 = r0 ^ 43
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0443Hg.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A02 = new byte[]{51, 36, 41, 48, 32, 115, 99, 97, 108, 101};
    }

    public C0443Hg(double d, double d2) {
        this.A01 = d;
        this.A00 = d2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0046, code lost:            return r7;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.C0443Hg A00(org.json.JSONObject r8) {
        /*
            r0 = 0
            r5 = 0
            r0 = 0
            r3 = 0
            r7 = 0
            r1 = 0
            if (r8 != 0) goto L42
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L44;
                case 3: goto L11;
                case 4: goto L33;
                case 5: goto L3b;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            org.json.JSONObject r8 = (org.json.JSONObject) r8
            r4 = 0
            r3 = 5
            r0 = 110(0x6e, float:1.54E-43)
            java.lang.String r0 = A01(r4, r3, r0)
            double r5 = r8.optDouble(r0, r1)
            r4 = 5
            r3 = 5
            r0 = 43
            java.lang.String r0 = A01(r4, r3, r0)
            double r3 = r8.optDouble(r0, r1)
            int r0 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r0 == 0) goto L31
            r0 = 4
            goto Ld
        L31:
            r0 = 2
            goto Ld
        L33:
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 == 0) goto L39
            r0 = 5
            goto Ld
        L39:
            r0 = 2
            goto Ld
        L3b:
            com.facebook.ads.redexgen.X.Hg r7 = new com.facebook.ads.redexgen.X.Hg
            r7.<init>(r5, r3)
            r0 = 2
            goto Ld
        L42:
            r0 = 3
            goto Ld
        L44:
            com.facebook.ads.redexgen.X.Hg r7 = (com.facebook.ads.redexgen.X.C0443Hg) r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0443Hg.A00(org.json.JSONObject):com.facebook.ads.redexgen.X.Hg");
    }

    public final double getScale() {
        return this.A00;
    }

    public final double getValue() {
        return this.A01;
    }
}
