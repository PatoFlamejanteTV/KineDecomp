package com.facebook.ads.redexgen.X;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: assets/audience_network.dex */
public final class IG {
    public static Map<String, Long> A00;
    public static Map<String, Long> A01;
    public static Map<String, String> A02;
    public static byte[] A03;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.IG.A03
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
            r0 = r0 ^ 125(0x7d, float:1.75E-43)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.IG.A01(int, int, int):java.lang.String");
    }

    public static void A04() {
        A03 = new byte[]{90, 88, 73, 113, 92, 78, 73, 111, 88, 78, 77, 82, 83, 78, 88, 121, 47, 102, 121, 47, 102, 121, 47, 102, 121, 56, 102, 121, 56, 102, 121, 56, 76, 27, 74, 25, 77, 28, 22, 15, 41, 51, 52, 61, 122, 54, 59, 41, 46, 122, 59, 62, 122, 40, 63, 41, 42, 53, 52, 41, 63};
    }

    static {
        A04();
        A01 = new ConcurrentHashMap();
        A00 = new ConcurrentHashMap();
        A02 = new ConcurrentHashMap();
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x003c, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long A00(java.lang.String r4, com.facebook.ads.redexgen.X.EnumC0456Hu r5) {
        /*
            r0 = 0
            r2 = -1000(0xfffffffffffffc18, double:NaN)
            java.util.Map<java.lang.String, java.lang.Long> r0 = com.facebook.ads.redexgen.X.IG.A01
            boolean r0 = r0.containsKey(r4)
            if (r0 == 0) goto L3a
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L11;
                case 3: goto L3c;
                case 4: goto L21;
                case 5: goto L36;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            java.lang.String r4 = (java.lang.String) r4
            java.util.Map<java.lang.String, java.lang.Long> r0 = com.facebook.ads.redexgen.X.IG.A01
            java.lang.Object r0 = r0.get(r4)
            java.lang.Long r0 = (java.lang.Long) r0
            long r2 = r0.longValue()
            r0 = 3
            goto Ld
        L21:
            com.facebook.ads.redexgen.X.Hu r5 = (com.facebook.ads.redexgen.X.EnumC0456Hu) r5
            int[] r1 = com.facebook.ads.redexgen.X.IF.A00
            int r0 = r5.ordinal()
            r0 = r1[r0]
            switch(r0) {
                case 1: goto L30;
                case 2: goto L32;
                case 3: goto L34;
                default: goto L2e;
            }
        L2e:
            r0 = 3
            goto Ld
        L30:
            r0 = 5
            goto Ld
        L32:
            r0 = 3
            goto Ld
        L34:
            r0 = 3
            goto Ld
        L36:
            r2 = 15000(0x3a98, double:7.411E-320)
            r0 = 3
            goto Ld
        L3a:
            r0 = 4
            goto Ld
        L3c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.IG.A00(java.lang.String, com.facebook.ads.redexgen.X.Hu):long");
    }

    public static String A02(IH ih) {
        I5.A05(A01(0, 15, 64), A01(39, 22, 39), A01(32, 7, 82));
        return A02.get(A03(ih));
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0069, code lost:            r2 = r2;        r2[r7] = java.lang.Integer.valueOf(r5);        r2[5] = java.lang.Integer.valueOf(r8.A03());     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0088, code lost:            return java.lang.String.format(r4, r3, r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A03(com.facebook.ads.redexgen.X.IH r8) {
        /*
            r0 = 0
            r0 = 0
            r7 = 0
            r0 = 0
            r0 = 0
            r6 = 0
            r0 = 0
            r5 = 0
            java.util.Locale r4 = java.util.Locale.US
            r2 = 15
            r1 = 17
            r0 = 33
            java.lang.String r3 = A01(r2, r1, r0)
            r0 = 6
            java.lang.Object[] r2 = new java.lang.Object[r0]
            java.lang.String r0 = r8.A08()
            r2[r5] = r0
            r1 = 1
            com.facebook.ads.redexgen.X.Hu r0 = r8.A04()
            r2[r1] = r0
            r1 = 2
            com.facebook.ads.redexgen.X.Hx r0 = r8.A05()
            r2[r1] = r0
            r1 = 3
            com.facebook.ads.redexgen.X.Jj r0 = r8.A07()
            if (r0 != 0) goto L67
            r0 = 2
        L33:
            switch(r0) {
                case 2: goto L37;
                case 3: goto L3a;
                case 4: goto L69;
                case 5: goto L4f;
                case 6: goto L5b;
                default: goto L36;
            }
        L36:
            goto L33
        L37:
            r6 = r5
            r0 = 3
            goto L33
        L3a:
            com.facebook.ads.redexgen.X.IH r8 = (com.facebook.ads.redexgen.X.IH) r8
            java.lang.Object[] r2 = (java.lang.Object[]) r2
            java.lang.Integer r0 = java.lang.Integer.valueOf(r6)
            r2[r1] = r0
            r7 = 4
            com.facebook.ads.redexgen.X.Jj r0 = r8.A07()
            if (r0 != 0) goto L4d
            r0 = 4
            goto L33
        L4d:
            r0 = 5
            goto L33
        L4f:
            com.facebook.ads.redexgen.X.IH r8 = (com.facebook.ads.redexgen.X.IH) r8
            com.facebook.ads.redexgen.X.Jj r0 = r8.A07()
            int r5 = r0.A01()
            r0 = 4
            goto L33
        L5b:
            com.facebook.ads.redexgen.X.IH r8 = (com.facebook.ads.redexgen.X.IH) r8
            com.facebook.ads.redexgen.X.Jj r0 = r8.A07()
            int r6 = r0.A00()
            r0 = 3
            goto L33
        L67:
            r0 = 6
            goto L33
        L69:
            com.facebook.ads.redexgen.X.IH r8 = (com.facebook.ads.redexgen.X.IH) r8
            java.util.Locale r4 = (java.util.Locale) r4
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object[] r2 = (java.lang.Object[]) r2
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
            r2[r7] = r0
            r1 = 5
            int r0 = r8.A03()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2[r1] = r0
            java.lang.String r0 = java.lang.String.format(r4, r3, r2)
            java.lang.String r0 = (java.lang.String) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.IG.A03(com.facebook.ads.redexgen.X.IH):java.lang.String");
    }

    public static void A05(long j, IH ih) {
        A01.put(A03(ih), Long.valueOf(j));
    }

    public static void A06(IH ih) {
        A00.put(A03(ih), Long.valueOf(System.currentTimeMillis()));
    }

    public static void A07(String str, IH ih) {
        A02.put(A03(ih), str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0046, code lost:            return r8;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A08(com.facebook.ads.redexgen.X.IH r10) {
        /*
            r9 = 0
            r0 = 0
            r0 = 0
            r8 = 0
            java.lang.String r7 = A03(r10)
            java.util.Map<java.lang.String, java.lang.Long> r0 = com.facebook.ads.redexgen.X.IG.A00
            boolean r0 = r0.containsKey(r7)
            if (r0 != 0) goto L44
            r0 = 2
        L11:
            switch(r0) {
                case 2: goto L46;
                case 3: goto L15;
                case 4: goto L3a;
                case 5: goto L3d;
                case 6: goto L40;
                default: goto L14;
            }
        L14:
            goto L11
        L15:
            com.facebook.ads.redexgen.X.IH r10 = (com.facebook.ads.redexgen.X.IH) r10
            java.lang.String r7 = (java.lang.String) r7
            java.util.Map<java.lang.String, java.lang.Long> r0 = com.facebook.ads.redexgen.X.IG.A00
            java.lang.Object r0 = r0.get(r7)
            java.lang.Long r0 = (java.lang.Long) r0
            long r5 = r0.longValue()
            com.facebook.ads.redexgen.X.Hu r0 = r10.A04()
            long r3 = A00(r7, r0)
            long r1 = java.lang.System.currentTimeMillis()
            long r1 = r1 - r5
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 >= 0) goto L38
            r0 = 4
            goto L11
        L38:
            r0 = 6
            goto L11
        L3a:
            r9 = 1
            r0 = 5
            goto L11
        L3d:
            r8 = r9
            r0 = 2
            goto L11
        L40:
            r8 = 0
            r9 = r8
            r0 = 5
            goto L11
        L44:
            r0 = 3
            goto L11
        L46:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.IG.A08(com.facebook.ads.redexgen.X.IH):boolean");
    }
}
