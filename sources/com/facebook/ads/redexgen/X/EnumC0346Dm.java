package com.facebook.ads.redexgen.X;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.Dm, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public enum EnumC0346Dm {
    A04(0),
    A07(1024),
    A05(2048),
    A06(4096);

    public static byte[] A01;
    public static final Map<Integer, EnumC0346Dm> A02;
    public int A00;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.EnumC0346Dm.A01
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
            int r0 = r0 + (-99)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EnumC0346Dm.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A01 = new byte[]{-20, -35, -18, -35, -22, -21, -27, -32, 33, 35, 33, 30, 23, 17, 23, 29, 35, 33, 1, 4, 13, 8, 6, 13, 30, 8, 6, 13, 14, 17, 4, -11, -28, -15, -25, -14, -16, 2, -10, -28, -16, -13, -17, -24};
    }

    static {
        A02();
        A02 = new HashMap();
        for (EnumC0346Dm enumC0346Dm : values()) {
            A02.put(Integer.valueOf(enumC0346Dm.A00), enumC0346Dm);
        }
    }

    EnumC0346Dm(int i) {
        this.A00 = i;
    }

    public static EnumC0346Dm A00(int i) {
        EnumC0346Dm enumC0346Dm = A02.get(Integer.valueOf(i));
        return enumC0346Dm == null ? A04 : enumC0346Dm;
    }

    public final int A03() {
        return this.A00;
    }
}
