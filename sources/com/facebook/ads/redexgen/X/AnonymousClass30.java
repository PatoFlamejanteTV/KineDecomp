package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.30, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass30 {
    public static byte[] A00;

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
            byte[] r1 = com.facebook.ads.redexgen.X.AnonymousClass30.A00
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass30.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A00 = new byte[]{50, 37, 55, 33, 50, 36, 37, 36, 31, 54, 41, 36, 37, 47};
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00c3, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A02(com.facebook.ads.redexgen.X.EV r13, com.facebook.ads.redexgen.X.C00622h r14) {
        /*
            r0 = 0
            r0 = 0
            r9 = -1
            com.facebook.ads.redexgen.X.ES r3 = new com.facebook.ads.redexgen.X.ES
            com.facebook.ads.redexgen.X.2c r0 = r14.A0N()
            java.lang.String r4 = r0.A01()
            int r5 = com.facebook.ads.redexgen.X.PC.A04
            int r6 = com.facebook.ads.redexgen.X.PC.A04
            java.lang.String r7 = r14.A0T()
            r2 = 0
            r1 = 14
            r0 = 61
            java.lang.String r8 = A00(r2, r1, r0)
            r3.<init>(r4, r5, r6, r7, r8)
            r13.A0R(r3)
            com.facebook.ads.redexgen.X.2L r0 = r14.A0L()
            com.facebook.ads.redexgen.X.2O r0 = r0.A0D()
            java.lang.String r5 = r0.A07()
            com.facebook.ads.redexgen.X.EU r4 = new com.facebook.ads.redexgen.X.EU
            java.lang.String r3 = r14.A0T()
            r2 = 0
            r1 = 14
            r0 = 61
            java.lang.String r0 = A00(r2, r1, r0)
            r4.<init>(r5, r3, r0)
            r13.A0V(r4)
            com.facebook.ads.redexgen.X.ES r3 = new com.facebook.ads.redexgen.X.ES
            com.facebook.ads.redexgen.X.2L r0 = r14.A0L()
            com.facebook.ads.redexgen.X.2O r0 = r0.A0D()
            java.lang.String r4 = r0.A06()
            com.facebook.ads.redexgen.X.2L r0 = r14.A0L()
            com.facebook.ads.redexgen.X.2O r0 = r0.A0D()
            int r5 = com.facebook.ads.redexgen.X.C00752u.A00(r0)
            com.facebook.ads.redexgen.X.2L r0 = r14.A0L()
            com.facebook.ads.redexgen.X.2O r0 = r0.A0D()
            int r6 = com.facebook.ads.redexgen.X.C00752u.A01(r0)
            java.lang.String r7 = r14.A0T()
            r2 = 0
            r1 = 14
            r0 = 61
            java.lang.String r8 = A00(r2, r1, r0)
            r3.<init>(r4, r5, r6, r7, r8)
            r13.A0R(r3)
            com.facebook.ads.redexgen.X.2L r0 = r14.A0L()
            com.facebook.ads.redexgen.X.2V r0 = r0.A0G()
            java.util.List r0 = r0.A01()
            java.util.Iterator r3 = r0.iterator()
            r0 = 2
        L8f:
            switch(r0) {
                case 2: goto L93;
                case 3: goto L9f;
                case 4: goto Lc3;
                default: goto L92;
            }
        L92:
            goto L8f
        L93:
            java.util.Iterator r3 = (java.util.Iterator) r3
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L9d
            r0 = 3
            goto L8f
        L9d:
            r0 = 4
            goto L8f
        L9f:
            com.facebook.ads.redexgen.X.EV r13 = (com.facebook.ads.redexgen.X.EV) r13
            com.facebook.ads.redexgen.X.2h r14 = (com.facebook.ads.redexgen.X.C00622h) r14
            java.util.Iterator r3 = (java.util.Iterator) r3
            java.lang.Object r8 = r3.next()
            java.lang.String r8 = (java.lang.String) r8
            com.facebook.ads.redexgen.X.ES r7 = new com.facebook.ads.redexgen.X.ES
            java.lang.String r11 = r14.A0T()
            r2 = 0
            r1 = 14
            r0 = 61
            java.lang.String r12 = A00(r2, r1, r0)
            r10 = r9
            r7.<init>(r8, r9, r10, r11, r12)
            r13.A0R(r7)
            r0 = 2
            goto L8f
        Lc3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass30.A02(com.facebook.ads.redexgen.X.EV, com.facebook.ads.redexgen.X.2h):void");
    }
}
