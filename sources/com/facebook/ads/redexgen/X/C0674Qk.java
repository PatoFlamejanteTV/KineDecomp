package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Qk, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0674Qk extends QJ {
    public static byte[] A01;
    public final C0673Qj A00;

    static {
        A01();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C0674Qk.A01
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
            r0 = r0 ^ 114(0x72, float:1.6E-43)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0674Qk.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{23, 50, 21, 62, 57, 63, 53, 51, 37};
    }

    public C0674Qk(C0362Ec c0362Ec, String str, String str2, float[] fArr) {
        super(c0362Ec);
        this.A00 = new C0673Qj(c0362Ec, A00(0, 9, 36), str, fArr, str2);
        addView(this.A00);
    }
}
