package com.facebook.ads.redexgen.X;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.Dp, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public enum EnumC0349Dp {
    A04(1),
    A0A(2),
    A07(4),
    A09(8),
    A0M(16),
    A0E(32),
    A05(64),
    A0D(128),
    A0B(256),
    A0C(512),
    A0L(1024),
    A0I(2048),
    A0J(4096),
    A08(8192),
    A0H(16384),
    A0F(32768),
    A0G(65536),
    A0K(131072),
    A06(262144);

    public static byte[] A01;
    public static final Map<Integer, EnumC0349Dp> A02;
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
            byte[] r1 = com.facebook.ads.redexgen.X.EnumC0349Dp.A01
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
            r0 = r0 ^ 98
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EnumC0349Dp.A01(int, int, int):java.lang.String");
    }

    public static void A03() {
        A01 = new byte[]{26, 14, 10, 30, 19, 0, 29, 6, 0, 9, 30, 19, 10, 26, 16, 4, 0, 20, 25, 10, 23, 12, 10, 1, 28, 24, 16, 6, 1, 20, 24, 5, 104, 110, 114, 126, 111, 96, 117, 104, 119, 100, 32, 61, 42, 37, 41, 45, 39, 33, 55, 60, 33, 59, 38, 59, 36, 55, 123, 108, 119, 125, 117, 124, 1, 14, 4, 18, 15, 9, 4, 31, 14, 1, 20, 9, 22, 5, 32, 38, 32, 35, 58, 48, 58, 60, 38, 32, 44, 39, 58, 54, 33, 65, 74, 76, 78, 70, 87, 81, 74, 64, 66, 67, 86, 84, 67, 69, 71, 82, 67, 66, 65, 72, 72, 93, 71, 90, 75, 81, 93, 75, 64, 93, 71, 90, 71, 88, 75, 9, 26, 21, 31, 20, 22, 4, 8, 26, 22, 11, 23, 30, 4, 15, 18, 30, 9, 98, 112, 119, 56, 58, 45, 48, 47, 60, 6, 7, 26, 0, 29, 12, 8, 25, 10, 25, 22, 23, 17, 28, 7, 12, 17, 29, 10, 110, 122, 126, 106, 103, 116, 105, 114, 116, 104, 100, 101, Byte.MAX_VALUE, 110, 115, Byte.MAX_VALUE, 70, 65, 74, 77, 67, 74, 91, 80, 77, 65, 86, 88, 81, 81, 68, 94, 67, 82};
    }

    static {
        A03();
        A02 = new HashMap();
        for (EnumC0349Dp enumC0349Dp : values()) {
            A02.put(Integer.valueOf(enumC0349Dp.A00), enumC0349Dp);
        }
    }

    EnumC0349Dp(int i) {
        this.A00 = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:            return r2;     */
    @javax.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.EnumC0349Dp A00(int r3) {
        /*
            r2 = 0
            java.util.Map<java.lang.Integer, com.facebook.ads.redexgen.X.Dp> r1 = com.facebook.ads.redexgen.X.EnumC0349Dp.A02
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)
            boolean r0 = r1.containsKey(r0)
            if (r0 == 0) goto L23
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L12;
                case 3: goto L25;
                case 4: goto L20;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            java.util.Map<java.lang.Integer, com.facebook.ads.redexgen.X.Dp> r1 = com.facebook.ads.redexgen.X.EnumC0349Dp.A02
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)
            java.lang.Object r2 = r1.get(r0)
            com.facebook.ads.redexgen.X.Dp r2 = (com.facebook.ads.redexgen.X.EnumC0349Dp) r2
            r0 = 3
            goto Le
        L20:
            r2 = 0
            r0 = 3
            goto Le
        L23:
            r0 = 4
            goto Le
        L25:
            com.facebook.ads.redexgen.X.Dp r2 = (com.facebook.ads.redexgen.X.EnumC0349Dp) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EnumC0349Dp.A00(int):com.facebook.ads.redexgen.X.Dp");
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x003f, code lost:            return r1;     */
    @android.annotation.SuppressLint({"BadMethodUse-android.util.Log.e", "CatchGeneralException", "EmptyCatchBlock"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.EnumSet<com.facebook.ads.redexgen.X.EnumC0349Dp> A02(int r4) throws java.lang.Exception {
        /*
            r3 = 0
            r2 = 0
            r0 = 0
            java.lang.Class<com.facebook.ads.redexgen.X.Dp> r0 = com.facebook.ads.redexgen.X.EnumC0349Dp.class
            java.util.EnumSet r1 = java.util.EnumSet.noneOf(r0)
            if (r4 > 0) goto L39
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L3b;
                case 3: goto L10;
                case 4: goto L16;
                case 5: goto L1c;
                case 6: goto L2e;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            com.facebook.ads.redexgen.X.Dp[] r2 = values()
            r0 = 4
            goto Lc
        L16:
            if (r4 == 0) goto L1a
            r0 = 5
            goto Lc
        L1a:
            r0 = 2
            goto Lc
        L1c:
            com.facebook.ads.redexgen.X.Dp[] r2 = (com.facebook.ads.redexgen.X.EnumC0349Dp[]) r2
            int r3 = java.lang.Integer.numberOfTrailingZeros(r4)
            int r0 = java.lang.Integer.lowestOneBit(r4)
            r4 = r4 ^ r0
            int r0 = r2.length
            if (r3 >= r0) goto L2c
            r0 = 6
            goto Lc
        L2c:
            r0 = 4
            goto Lc
        L2e:
            java.util.EnumSet r1 = (java.util.EnumSet) r1
            com.facebook.ads.redexgen.X.Dp[] r2 = (com.facebook.ads.redexgen.X.EnumC0349Dp[]) r2
            r0 = r2[r3]
            r1.add(r0)
            r0 = 4
            goto Lc
        L39:
            r0 = 3
            goto Lc
        L3b:
            java.util.EnumSet r1 = (java.util.EnumSet) r1
            java.util.EnumSet r1 = (java.util.EnumSet) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EnumC0349Dp.A02(int):java.util.EnumSet");
    }

    public final int A04() {
        return this.A00;
    }
}
