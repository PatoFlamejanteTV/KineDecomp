package com.facebook.ads.redexgen.X;

import android.text.TextUtils;

/* loaded from: assets/audience_network.dex */
public final class N8 {
    public static byte[] A02;
    public boolean A00 = true;
    public final NE A01;

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
            byte[] r1 = com.facebook.ads.redexgen.X.N8.A02
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
            r0 = r0 ^ 64
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.N8.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A02 = new byte[]{32, 47, 47, 0, 23, 51, 4, 18, 17, 14, 15, 18, 4, 36, 15, 5, 91, 61, 50, 50, 29, 10, 56, 19, 17, 63, 19, 18, 8, 25, 18, 8, 48, 19, 29, 24, 25, 24, 70, 81, 94, 94, 113, 102, 92, Byte.MAX_VALUE, 113, 116, 85, 102, 117, 126, 100, 85, 126, 116, 42, 70, 95, 89, 84, 24, 24, 86, 69, 94, 83, 68, 89, 95, 94, 24, 25, 16, 75, 68, 66, 73, 16, 75, 16, 16, 89, 86, 16, 24, 17, 71, 89, 94, 84, 95, 71, 30, 64, 85, 66, 86, 95, 66, 93, 81, 94, 83, 85, 16, 76, 76, 16, 17, 71, 89, 94, 84, 95, 71, 30, 64, 85, 66, 86, 95, 66, 93, 81, 94, 83, 85, 30, 68, 89, 93, 89, 94, 87, 16, 76, 76, 16, 17, 84, 95, 83, 69, 93, 85, 94, 68, 16, 76, 76, 16, 16, 16, 16, 16, 16, 16, 17, 84, 95, 83, 69, 93, 85, 94, 68, 30, 82, 95, 84, 73, 16, 76, 76, 16, 84, 95, 83, 69, 93, 85, 94, 68, 30, 82, 95, 84, 73, 30, 67, 83, 66, 95, 92, 92, 120, 85, 89, 87, 88, 68, 16, 12, 13, 16, 0, 16, 76, 76, 16, 16, 16, 16, 16, 16, 16, 17, 84, 95, 83, 69, 93, 85, 94, 68, 30, 82, 95, 84, 73, 30, 83, 88, 89, 92, 84, 66, 85, 94, 16, 76, 76, 16, 84, 95, 83, 69, 93, 85, 94, 68, 30, 82, 95, 84, 73, 30, 83, 88, 89, 92, 84, 66, 85, 94, 30, 92, 85, 94, 87, 68, 88, 16, 12, 16, 1, 25, 16, 75, 16, 16, 16, 16, 66, 85, 68, 69, 66, 94, 11, 16, 16, 77, 16, 16, 70, 81, 66, 16, 94, 70, 68, 89, 93, 89, 94, 87, 111, 111, 81, 94, 111, 68, 16, 13, 16, 71, 89, 94, 84, 95, 71, 30, 64, 85, 66, 86, 95, 66, 93, 81, 94, 83, 85, 30, 68, 89, 93, 89, 94, 87, 11, 16, 16, 89, 86, 16, 24, 94, 70, 68, 89, 93, 89, 94, 87, 111, 111, 81, 94, 111, 68, 30, 66, 85, 67, 64, 95, 94, 67, 85, 117, 94, 84, 16, 14, 16, 0, 25, 16, 75, 16, 16, 16, 16, 83, 95, 94, 67, 95, 92, 85, 30, 92, 95, 87, 24, 23, 113, 126, 126, 81, 70, 98, 85, 67, 64, 95, 94, 67, 85, 117, 94, 84, 10, 23, 27, 94, 70, 68, 89, 93, 89, 94, 87, 111, 111, 81, 94, 111, 68, 30, 66, 85, 67, 64, 95, 94, 67, 85, 117, 94, 84, 25, 11, 16, 16, 77, 16, 16, 89, 86, 16, 24, 94, 70, 68, 89, 93, 89, 94, 87, 111, 111, 81, 94, 111, 68, 30, 84, 95, 93, 115, 95, 94, 68, 85, 94, 68, 124, 95, 81, 84, 85, 84, 117, 70, 85, 94, 68, 99, 68, 81, 66, 68, 16, 14, 16, 0, 25, 16, 75, 16, 16, 16, 16, 83, 95, 94, 67, 95, 92, 85, 30, 92, 95, 87, 24, 23, 113, 126, 126, 81, 70, 116, 95, 93, 115, 95, 94, 68, 85, 94, 68, 124, 95, 81, 84, 85, 84, 10, 23, 16, 27, 16, 94, 70, 68, 89, 93, 89, 94, 87, 111, 111, 81, 94, 111, 68, 30, 84, 95, 93, 115, 95, 94, 68, 85, 94, 68, 124, 95, 81, 84, 85, 84, 117, 70, 85, 94, 68, 99, 68, 81, 66, 68, 25, 11, 16, 16, 77, 16, 16, 89, 86, 16, 24, 94, 70, 68, 89, 93, 89, 94, 87, 111, 111, 81, 94, 111, 68, 30, 92, 95, 81, 84, 117, 70, 85, 94, 68, 117, 94, 84, 16, 14, 16, 0, 25, 16, 75, 16, 16, 16, 16, 83, 95, 94, 67, 95, 92, 85, 30, 92, 95, 87, 24, 23, 113, 126, 126, 81, 70, 124, 95, 81, 84, 117, 70, 85, 94, 68, 117, 94, 84, 10, 23, 16, 27, 16, 94, 70, 68, 89, 93, 89, 94, 87, 111, 111, 81, 94, 111, 68, 30, 92, 95, 81, 84, 117, 70, 85, 94, 68, 117, 94, 84, 25, 11, 16, 16, 77, 77, 16, 83, 81, 68, 83, 88, 24, 85, 66, 66, 25, 16, 75, 16, 16, 83, 95, 94, 67, 95, 92, 85, 30, 92, 95, 87, 24, 23, 81, 94, 111, 94, 81, 70, 89, 87, 81, 68, 89, 95, 94, 111, 68, 89, 93, 89, 94, 87, 111, 85, 66, 66, 95, 66, 10, 23, 16, 27, 16, 85, 66, 66, 30, 93, 85, 67, 67, 81, 87, 85, 25, 11, 77, 77, 25, 24, 25, 25, 11};
    }

    public N8(NE ne) {
        this.A01 = ne;
    }

    public static long A00(String str, String str2) {
        long j = -1;
        String substring = str.substring(str2.length());
        if (TextUtils.isEmpty(substring)) {
            return -1L;
        }
        try {
            Long valueOf = Long.valueOf(Long.parseLong(substring));
            if (valueOf.longValue() < 0) {
                return -1L;
            }
            j = valueOf.longValue();
            return j;
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0042, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A03() {
        /*
            r5 = this;
            r4 = r5
            boolean r0 = r4.A00
            if (r0 != 0) goto L40
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto L42;
                case 3: goto L32;
                case 4: goto La;
                case 5: goto L18;
                case 6: goto L1f;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.N8 r4 = (com.facebook.ads.redexgen.X.N8) r4
            com.facebook.ads.redexgen.X.NE r0 = r4.A01
            boolean r0 = r0.canGoForward()
            if (r0 == 0) goto L16
            r0 = 5
            goto L6
        L16:
            r0 = 6
            goto L6
        L18:
            com.facebook.ads.redexgen.X.N8 r4 = (com.facebook.ads.redexgen.X.N8) r4
            r0 = 0
            r4.A00 = r0
            r0 = 2
            goto L6
        L1f:
            com.facebook.ads.redexgen.X.N8 r4 = (com.facebook.ads.redexgen.X.N8) r4
            com.facebook.ads.redexgen.X.NE r3 = r4.A01
            r2 = 57
            r1 = 726(0x2d6, float:1.017E-42)
            r0 = 112(0x70, float:1.57E-43)
            java.lang.String r0 = A01(r2, r1, r0)
            r3.A0E(r0)
            r0 = 2
            goto L6
        L32:
            com.facebook.ads.redexgen.X.N8 r4 = (com.facebook.ads.redexgen.X.N8) r4
            com.facebook.ads.redexgen.X.NE r0 = r4.A01
            boolean r0 = r0.canGoBack()
            if (r0 != 0) goto L3e
            r0 = 4
            goto L6
        L3e:
            r0 = 5
            goto L6
        L40:
            r0 = 3
            goto L6
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.N8.A03():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x009a, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A04(java.lang.String r6) {
        /*
            r5 = this;
            r4 = r5
            boolean r0 = r4.A00
            if (r0 != 0) goto L97
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto L9a;
                case 3: goto L51;
                case 4: goto L39;
                case 5: goto L23;
                case 6: goto La;
                case 7: goto L66;
                case 8: goto L7d;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.N8 r4 = (com.facebook.ads.redexgen.X.N8) r4
            java.lang.String r6 = (java.lang.String) r6
            com.facebook.ads.redexgen.X.NE r3 = r4.A01
            r2 = 17
            r1 = 22
            r0 = 60
            java.lang.String r0 = A01(r2, r1, r0)
            long r0 = A00(r6, r0)
            r3.A0B(r0)
            r0 = 2
            goto L6
        L23:
            java.lang.String r6 = (java.lang.String) r6
            r2 = 17
            r1 = 22
            r0 = 60
            java.lang.String r0 = A01(r2, r1, r0)
            boolean r0 = r6.startsWith(r0)
            if (r0 == 0) goto L37
            r0 = 6
            goto L6
        L37:
            r0 = 7
            goto L6
        L39:
            com.facebook.ads.redexgen.X.N8 r4 = (com.facebook.ads.redexgen.X.N8) r4
            java.lang.String r6 = (java.lang.String) r6
            com.facebook.ads.redexgen.X.NE r3 = r4.A01
            r2 = 0
            r1 = 17
            r0 = 33
            java.lang.String r0 = A01(r2, r1, r0)
            long r0 = A00(r6, r0)
            r3.A0D(r0)
            r0 = 2
            goto L6
        L51:
            java.lang.String r6 = (java.lang.String) r6
            r2 = 0
            r1 = 17
            r0 = 33
            java.lang.String r0 = A01(r2, r1, r0)
            boolean r0 = r6.startsWith(r0)
            if (r0 == 0) goto L64
            r0 = 4
            goto L6
        L64:
            r0 = 5
            goto L6
        L66:
            java.lang.String r6 = (java.lang.String) r6
            r2 = 39
            r1 = 18
            r0 = 80
            java.lang.String r0 = A01(r2, r1, r0)
            boolean r0 = r6.startsWith(r0)
            if (r0 == 0) goto L7b
            r0 = 8
            goto L6
        L7b:
            r0 = 2
            goto L6
        L7d:
            com.facebook.ads.redexgen.X.N8 r4 = (com.facebook.ads.redexgen.X.N8) r4
            java.lang.String r6 = (java.lang.String) r6
            com.facebook.ads.redexgen.X.NE r3 = r4.A01
            r2 = 39
            r1 = 18
            r0 = 80
            java.lang.String r0 = A01(r2, r1, r0)
            long r0 = A00(r6, r0)
            r3.A0C(r0)
            r0 = 2
            goto L6
        L97:
            r0 = 3
            goto L6
        L9a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.N8.A04(java.lang.String):void");
    }

    public final void A05(boolean z) {
        this.A00 = z;
    }
}
