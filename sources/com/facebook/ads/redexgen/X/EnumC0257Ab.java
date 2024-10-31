package com.facebook.ads.redexgen.X;

import android.os.Build;

/* renamed from: com.facebook.ads.redexgen.X.Ab, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public enum EnumC0257Ab {
    A03(1),
    A07(4),
    A09(2),
    A06(Build.VERSION.SDK_INT >= 19 ? 20 : -1),
    A0A(0),
    A0B(8),
    A0D(Build.VERSION.SDK_INT >= 19 ? 18 : -1),
    A08(5),
    A05(6),
    A04(13),
    A0C(12);

    public static byte[] A01;
    public int A00;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.EnumC0257Ab.A01
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
            int r0 = r0 + (-14)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EnumC0257Ab.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{-42, -39, -48, -52, -43, -37, -56, -37, -48, -42, -43, -26, -38, -52, -43, -38, -42, -39, 92, 104, 93, 100, 96, 105, 111, 122, 111, 96, 104, 107, 96, 109, 92, 111, 112, 109, 96, 122, 110, 96, 105, 110, 106, 109, 115, 117, 117, 119, 126, 119, -124, -127, Byte.MAX_VALUE, 119, -122, 119, -124, -111, -123, 119, Byte.MIN_VALUE, -123, -127, -124, -93, -105, -99, -92, -101, -86, -91, -93, -101, -86, -101, -88, -75, -87, -101, -92, -87, -91, -88, 119, 121, 118, Byte.MAX_VALUE, 112, 116, 112, 123, Byte.MIN_VALUE, -122, 122, 108, 117, 122, 118, 121, 99, 97, 107, 105, 93, 99, 106, 97, 112, 101, 95, 123, 110, 107, 112, 93, 112, 101, 107, 106, 123, 111, 97, 106, 111, 107, 110, -45, -58, -51, -62, -43, -54, -41, -58, -32, -55, -42, -50, -54, -59, -54, -43, -38, -32, -44, -58, -49, -44, -48, -45, -51, -50, -65, -54, -39, -66, -65, -50, -65, -67, -50, -55, -52, -39, -51, -65, -56, -51, -55, -52, -98, -99, -82, -85, -87, -95, -80, -95, -82, -69, -81, -95, -86, -81, -85, -82, 90, 87, 85, 86, 98, 109, 97, 83, 92, 97, 93, 96, -66, -48, -55, -58, -54, -70, -58, -57, -68, -42, -54, -68, -59, -54, -58, -55};
    }

    static {
        A01();
    }

    EnumC0257Ab(int i) {
        this.A00 = i;
    }

    public final int A02() {
        return this.A00;
    }
}
