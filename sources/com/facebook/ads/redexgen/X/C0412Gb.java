package com.facebook.ads.redexgen.X;

import android.content.Context;

/* renamed from: com.facebook.ads.redexgen.X.Gb, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0412Gb {
    public static byte[] A00;

    static {
        A03();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A02(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C0412Gb.A00
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
            r0 = r0 ^ 103(0x67, float:1.44E-43)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0412Gb.A02(int, int, int):java.lang.String");
    }

    public static void A03() {
        A00 = new byte[]{104, 109, 103, 126, 86, 96, 109, 111, 104, 86, 123, 108, 111, 123, 108, 122, 97, 86, 125, 96, 100, 108, 86, 100, 122, 35, 38, 44, 53, 29, 33, 45, 44, 36, 43, 37, 29, 49, 39, 44, 38, 29, 36, 32, 46, 45, 37, 43, 44, 29, 35, 49, 43, 38, 67, 70, 76, 85, 125, 87, 81, 71, 125, 68, 64, 22, 67, 125, 75, 70, 125, 68, 75, 80, 81, 86, 28, 25, 19, 10, 34, 8, 14, 24, 15, 34, 28, 26, 24, 19, 9, 34, 15, 24, 27, 15, 24, 14, 21, 34, 9, 20, 16, 24, 34, 16, 14, 83, 86, 92, 69, 109, 71, 65, 87, 109, 84, 80, 6, 83, 109, 91, 86, 104, 109, 103, 126, 86, 122, 97, 102, 124, 101, 109, 86, 122, 108, 103, 109, 86, 104, 121, 121, 86, 96, 103, 111, 102, 86, 96, 103, 86, 124, 122, 108, 123, 86, 104, 110, 108, 103, 125};
    }

    public static long A00(Context context) {
        return C0413Gc.A0I(context).A1N(A02(0, 25, 110), -1L);
    }

    public static long A01(Context context) {
        return C0413Gc.A0I(context).A1N(A02(76, 31, 26), -1L);
    }

    public static boolean A04(Context context) {
        return C0413Gc.A0I(context).A1Q(A02(123, 39, 110), true);
    }

    public static boolean A05(Context context) {
        return C0413Gc.A0I(context).A1Q(A02(25, 29, 37), false);
    }

    public static boolean A06(Context context) {
        return C0413Gc.A0I(context).A1Q(A02(107, 16, 85), false);
    }

    public static boolean A07(Context context) {
        return C0413Gc.A0I(context).A1Q(A02(54, 22, 69), false);
    }
}
