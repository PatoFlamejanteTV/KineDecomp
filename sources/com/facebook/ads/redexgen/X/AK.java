package com.facebook.ads.redexgen.X;

/* loaded from: assets/audience_network.dex */
public final class AK {
    public static A1 A00;
    public static byte[] A01;
    public static final String A02;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.AK.A01
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
            int r0 = r0 + (-75)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AK.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{-67, -16, -37, -35, -24, -20, -31, -25, -26, -104, -36, -19, -22, -31, -26, -33, -104, -35, -16, -35, -37, -19, -20, -31, -25, -26, -90};
    }

    static {
        A01();
        A02 = AK.class.getSimpleName();
    }

    public static void A02(A1 a1) {
        A00 = a1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:            return;     */
    @android.annotation.SuppressLint({"BadMethodUse-android.util.Log.e"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A03(java.lang.Throwable r4) {
        /*
            com.facebook.ads.redexgen.X.A1 r0 = com.facebook.ads.redexgen.X.AK.A00
            if (r0 == 0) goto L24
            r0 = 2
        L5:
            switch(r0) {
                case 2: goto L9;
                case 3: goto L26;
                case 4: goto L12;
                default: goto L8;
            }
        L8:
            goto L5
        L9:
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            com.facebook.ads.redexgen.X.A1 r0 = com.facebook.ads.redexgen.X.AK.A00
            r0.A8A(r4)
            r0 = 3
            goto L5
        L12:
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            java.lang.String r3 = com.facebook.ads.redexgen.X.AK.A02
            r2 = 0
            r1 = 27
            r0 = 45
            java.lang.String r0 = A00(r2, r1, r0)
            android.util.Log.e(r3, r0, r4)
            r0 = 3
            goto L5
        L24:
            r0 = 4
            goto L5
        L26:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AK.A03(java.lang.Throwable):void");
    }
}
