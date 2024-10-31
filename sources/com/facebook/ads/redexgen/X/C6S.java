package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.6S, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class C6S {
    public static byte[] A06;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public C7Z A04;
    public C7Z A05;

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
            byte[] r1 = com.facebook.ads.redexgen.X.C6S.A06
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
            int r0 = r0 + (-39)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6S.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A06 = new byte[]{-71, -83, -13, -1, -4, -6, -26, -54, -112, -124, -46, -55, -37, -84, -45, -48, -56, -55, -42, -95, -62, -25, -32, -19, -26, -28, -56, -19, -27, -18, -6, -18, -21, -29, -57, -18, -21, -29, -28, -15, -68, -69, -81, -11, 1, -2, -4, -25, -52, -103, -115, -31, -36, -58, -86, 120, 108, -64, -69, -92, -119};
    }

    public C6S(C7Z c7z, C7Z c7z2) {
        this.A05 = c7z;
        this.A04 = c7z2;
    }

    public C6S(C7Z c7z, C7Z c7z2, int i, int i2, int i3, int i4) {
        this(c7z, c7z2);
        this.A00 = i;
        this.A01 = i2;
        this.A02 = i3;
        this.A03 = i4;
    }

    public final String toString() {
        return A00(20, 21, 88) + this.A05 + A00(8, 12, 61) + this.A04 + A00(41, 8, 104) + this.A00 + A00(0, 8, 102) + this.A01 + A00(55, 6, 37) + this.A02 + A00(49, 6, 70) + this.A03 + '}';
    }
}
