package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.6H, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class C6H {
    public static byte[] A02;
    public long A00 = 0;
    public C6H A01;

    static {
        A02();
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
            byte[] r1 = com.facebook.ads.redexgen.X.C6H.A02
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
            r0 = r0 ^ 115(0x73, float:1.61E-43)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6H.A00(int, int, int):java.lang.String");
    }

    public static void A02() {
        A02 = new byte[]{0, 0};
    }

    private void A01() {
        if (this.A01 == null) {
            this.A01 = new C6H();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x005a, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A03(int r9) {
        /*
            r8 = this;
            r5 = r8
            r0 = 0
            r2 = 0
            r0 = 0
            r4 = 64
            r6 = 1
            com.facebook.ads.redexgen.X.6H r0 = r5.A01
            if (r0 != 0) goto L58
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L31;
                case 3: goto L19;
                case 4: goto L5a;
                case 5: goto L23;
                case 6: goto L12;
                case 7: goto L37;
                case 8: goto L45;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            if (r9 >= r4) goto L16
            r0 = 7
            goto Le
        L16:
            r0 = 8
            goto Le
        L19:
            com.facebook.ads.redexgen.X.6H r5 = (com.facebook.ads.redexgen.X.C6H) r5
            long r0 = r5.A00
            int r2 = java.lang.Long.bitCount(r0)
            r0 = 4
            goto Le
        L23:
            com.facebook.ads.redexgen.X.6H r5 = (com.facebook.ads.redexgen.X.C6H) r5
            long r2 = r5.A00
            long r0 = r6 << r9
            long r0 = r0 - r6
            long r2 = r2 & r0
            int r2 = java.lang.Long.bitCount(r2)
            r0 = 4
            goto Le
        L31:
            if (r9 < r4) goto L35
            r0 = 3
            goto Le
        L35:
            r0 = 5
            goto Le
        L37:
            com.facebook.ads.redexgen.X.6H r5 = (com.facebook.ads.redexgen.X.C6H) r5
            long r2 = r5.A00
            long r0 = r6 << r9
            long r0 = r0 - r6
            long r2 = r2 & r0
            int r2 = java.lang.Long.bitCount(r2)
            r0 = 4
            goto Le
        L45:
            com.facebook.ads.redexgen.X.6H r5 = (com.facebook.ads.redexgen.X.C6H) r5
            com.facebook.ads.redexgen.X.6H r1 = r5.A01
            int r0 = r9 + (-64)
            int r2 = r1.A03(r0)
            long r0 = r5.A00
            int r0 = java.lang.Long.bitCount(r0)
            int r2 = r2 + r0
            r0 = 4
            goto Le
        L58:
            r0 = 6
            goto Le
        L5a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6H.A03(int):int");
    }

    public final void A04() {
        this.A00 = 0L;
        if (this.A01 != null) {
            this.A01.A04();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0030, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A05(int r8) {
        /*
            r7 = this;
            r6 = r7
            r0 = 64
            if (r8 < r0) goto L2e
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L14;
                case 4: goto L30;
                case 5: goto L1f;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.6H r6 = (com.facebook.ads.redexgen.X.C6H) r6
            com.facebook.ads.redexgen.X.6H r0 = r6.A01
            if (r0 == 0) goto L12
            r0 = 3
            goto L6
        L12:
            r0 = 4
            goto L6
        L14:
            com.facebook.ads.redexgen.X.6H r6 = (com.facebook.ads.redexgen.X.C6H) r6
            com.facebook.ads.redexgen.X.6H r1 = r6.A01
            int r0 = r8 + (-64)
            r1.A05(r0)
            r0 = 4
            goto L6
        L1f:
            com.facebook.ads.redexgen.X.6H r6 = (com.facebook.ads.redexgen.X.C6H) r6
            long r4 = r6.A00
            r2 = 1
            long r2 = r2 << r8
            r0 = -1
            long r2 = r2 ^ r0
            long r4 = r4 & r2
            r6.A00 = r4
            r0 = 4
            goto L6
        L2e:
            r0 = 5
            goto L6
        L30:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6H.A05(int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A06(int r6) {
        /*
            r5 = this;
            r4 = r5
            r0 = 64
            if (r6 < r0) goto L24
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L26;
                case 4: goto L18;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.6H r4 = (com.facebook.ads.redexgen.X.C6H) r4
            r4.A01()
            com.facebook.ads.redexgen.X.6H r1 = r4.A01
            int r0 = r6 + (-64)
            r1.A06(r0)
            r0 = 3
            goto L6
        L18:
            com.facebook.ads.redexgen.X.6H r4 = (com.facebook.ads.redexgen.X.C6H) r4
            long r2 = r4.A00
            r0 = 1
            long r0 = r0 << r6
            long r2 = r2 | r0
            r4.A00 = r2
            r0 = 3
            goto L6
        L24:
            r0 = 4
            goto L6
        L26:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6H.A06(int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x0080, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A07(int r12, boolean r13) {
        /*
            r11 = this;
            r6 = r11
            r5 = 0
            r0 = 64
            if (r12 < r0) goto L7e
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto L55;
                case 3: goto L80;
                case 4: goto L3b;
                case 5: goto L30;
                case 6: goto Lb;
                case 7: goto L33;
                case 8: goto L28;
                case 9: goto L70;
                case 10: goto L63;
                case 11: goto L4d;
                case 12: goto L7b;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.6H r6 = (com.facebook.ads.redexgen.X.C6H) r6
            r9 = 1
            long r9 = r9 << r12
            r0 = 1
            long r9 = r9 - r0
            long r2 = r6.A00
            long r2 = r2 & r9
            long r0 = r6.A00
            r7 = -1
            long r7 = r7 ^ r9
            long r0 = r0 & r7
            r4 = 1
            long r0 = r0 << r4
            long r2 = r2 | r0
            r6.A00 = r2
            if (r13 == 0) goto L25
            r0 = 7
            goto L7
        L25:
            r0 = 11
            goto L7
        L28:
            if (r5 != 0) goto L2d
            r0 = 9
            goto L7
        L2d:
            r0 = 10
            goto L7
        L30:
            r5 = 1
            r0 = 6
            goto L7
        L33:
            com.facebook.ads.redexgen.X.6H r6 = (com.facebook.ads.redexgen.X.C6H) r6
            r6.A06(r12)
            r0 = 8
            goto L7
        L3b:
            com.facebook.ads.redexgen.X.6H r6 = (com.facebook.ads.redexgen.X.C6H) r6
            long r3 = r6.A00
            r0 = -9223372036854775808
            long r3 = r3 & r0
            r1 = 0
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 == 0) goto L4a
            r0 = 5
            goto L7
        L4a:
            r0 = 12
            goto L7
        L4d:
            com.facebook.ads.redexgen.X.6H r6 = (com.facebook.ads.redexgen.X.C6H) r6
            r6.A05(r12)
            r0 = 8
            goto L7
        L55:
            com.facebook.ads.redexgen.X.6H r6 = (com.facebook.ads.redexgen.X.C6H) r6
            r6.A01()
            com.facebook.ads.redexgen.X.6H r1 = r6.A01
            int r0 = r12 + (-64)
            r1.A07(r0, r13)
            r0 = 3
            goto L7
        L63:
            com.facebook.ads.redexgen.X.6H r6 = (com.facebook.ads.redexgen.X.C6H) r6
            r6.A01()
            com.facebook.ads.redexgen.X.6H r1 = r6.A01
            r0 = 0
            r1.A07(r0, r5)
            r0 = 3
            goto L7
        L70:
            com.facebook.ads.redexgen.X.6H r6 = (com.facebook.ads.redexgen.X.C6H) r6
            com.facebook.ads.redexgen.X.6H r0 = r6.A01
            if (r0 == 0) goto L79
            r0 = 10
            goto L7
        L79:
            r0 = 3
            goto L7
        L7b:
            r5 = 0
            r0 = 6
            goto L7
        L7e:
            r0 = 4
            goto L7
        L80:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6H.A07(int, boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0034, code lost:            return r5;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A08(int r8) {
        /*
            r7 = this;
            r6 = r7
            r5 = 0
            r0 = 64
            if (r8 < r0) goto L32
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L34;
                case 4: goto L1a;
                case 5: goto L2c;
                case 6: goto L2f;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.6H r6 = (com.facebook.ads.redexgen.X.C6H) r6
            r6.A01()
            com.facebook.ads.redexgen.X.6H r1 = r6.A01
            int r0 = r8 + (-64)
            boolean r5 = r1.A08(r0)
            r0 = 3
            goto L7
        L1a:
            com.facebook.ads.redexgen.X.6H r6 = (com.facebook.ads.redexgen.X.C6H) r6
            long r3 = r6.A00
            r0 = 1
            long r0 = r0 << r8
            long r3 = r3 & r0
            r1 = 0
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 == 0) goto L2a
            r0 = 5
            goto L7
        L2a:
            r0 = 6
            goto L7
        L2c:
            r5 = 1
            r0 = 3
            goto L7
        L2f:
            r5 = 0
            r0 = 3
            goto L7
        L32:
            r0 = 4
            goto L7
        L34:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6H.A08(int):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0083, code lost:            return r12;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A09(int r14) {
        /*
            r13 = this;
            r7 = r13
            r12 = 0
            r5 = 0
            r0 = 64
            if (r14 < r0) goto L81
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto L34;
                case 3: goto L83;
                case 4: goto L46;
                case 5: goto L43;
                case 6: goto Ld;
                case 7: goto L5c;
                case 8: goto L6d;
                case 9: goto L77;
                case 10: goto L59;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.6H r7 = (com.facebook.ads.redexgen.X.C6H) r7
            long r2 = r7.A00
            r0 = -1
            long r0 = r0 ^ r5
            long r2 = r2 & r0
            r7.A00 = r2
            r0 = 1
            long r10 = r5 - r0
            long r2 = r7.A00
            long r2 = r2 & r10
            long r0 = r7.A00
            r8 = -1
            long r8 = r8 ^ r10
            long r0 = r0 & r8
            r4 = 1
            long r0 = java.lang.Long.rotateRight(r0, r4)
            long r2 = r2 | r0
            r7.A00 = r2
            com.facebook.ads.redexgen.X.6H r0 = r7.A01
            if (r0 == 0) goto L32
            r0 = 7
            goto L9
        L32:
            r0 = 3
            goto L9
        L34:
            com.facebook.ads.redexgen.X.6H r7 = (com.facebook.ads.redexgen.X.C6H) r7
            r7.A01()
            com.facebook.ads.redexgen.X.6H r1 = r7.A01
            int r0 = r14 + (-64)
            boolean r12 = r1.A09(r0)
            r0 = 3
            goto L9
        L43:
            r12 = 1
            r0 = 6
            goto L9
        L46:
            com.facebook.ads.redexgen.X.6H r7 = (com.facebook.ads.redexgen.X.C6H) r7
            r5 = 1
            long r5 = r5 << r14
            long r3 = r7.A00
            long r3 = r3 & r5
            r1 = 0
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 == 0) goto L56
            r0 = 5
            goto L9
        L56:
            r0 = 10
            goto L9
        L59:
            r12 = 0
            r0 = 6
            goto L9
        L5c:
            com.facebook.ads.redexgen.X.6H r7 = (com.facebook.ads.redexgen.X.C6H) r7
            com.facebook.ads.redexgen.X.6H r1 = r7.A01
            r0 = 0
            boolean r0 = r1.A08(r0)
            if (r0 == 0) goto L6a
            r0 = 8
            goto L9
        L6a:
            r0 = 9
            goto L9
        L6d:
            com.facebook.ads.redexgen.X.6H r7 = (com.facebook.ads.redexgen.X.C6H) r7
            r0 = 63
            r7.A06(r0)
            r0 = 9
            goto L9
        L77:
            com.facebook.ads.redexgen.X.6H r7 = (com.facebook.ads.redexgen.X.C6H) r7
            com.facebook.ads.redexgen.X.6H r1 = r7.A01
            r0 = 0
            r1.A09(r0)
            r0 = 3
            goto L9
        L81:
            r0 = 4
            goto L9
        L83:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6H.A09(int):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0048, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String toString() {
        /*
            r5 = this;
            r4 = r5
            r1 = 0
            com.facebook.ads.redexgen.X.6H r0 = r4.A01
            if (r0 != 0) goto L42
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L44;
                case 4: goto L15;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.6H r4 = (com.facebook.ads.redexgen.X.C6H) r4
            long r0 = r4.A00
            java.lang.String r1 = java.lang.Long.toBinaryString(r0)
            r0 = 3
            goto L7
        L15:
            com.facebook.ads.redexgen.X.6H r4 = (com.facebook.ads.redexgen.X.C6H) r4
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            com.facebook.ads.redexgen.X.6H r0 = r4.A01
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r3 = r1.append(r0)
            r2 = 0
            r1 = 2
            r0 = 11
            java.lang.String r0 = A00(r2, r1, r0)
            java.lang.StringBuilder r2 = r3.append(r0)
            long r0 = r4.A00
            java.lang.String r0 = java.lang.Long.toBinaryString(r0)
            java.lang.StringBuilder r0 = r2.append(r0)
            java.lang.String r1 = r0.toString()
            r0 = 3
            goto L7
        L42:
            r0 = 4
            goto L7
        L44:
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r1 = (java.lang.String) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6H.toString():java.lang.String");
    }
}
