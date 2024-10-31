package com.facebook.ads.redexgen.X;

/* loaded from: assets/audience_network.dex */
public class HM implements C1Z {
    public static byte[] A03;
    public final /* synthetic */ C00371i A00;
    public final /* synthetic */ HX A01;
    public final /* synthetic */ boolean A02;

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
            byte[] r1 = com.facebook.ads.redexgen.X.HM.A03
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
            int r0 = r0 + (-38)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HM.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A03 = new byte[]{-22, 5, 13, 16, 9, 8, -60, 24, 19, -60, 8, 19, 27, 18, 16, 19, 5, 8, -60, 5, -60, 17, 9, 8, 13, 5, -46};
    }

    public HM(HX hx, C00371i c00371i, boolean z) {
        this.A01 = hx;
        this.A00 = c00371i;
        this.A02 = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0069, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.C1Z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A6I() {
        /*
            r7 = this;
            r5 = r7
            r6 = 0
            r4 = 0
            com.facebook.ads.redexgen.X.HX r0 = r5.A01
            com.facebook.ads.redexgen.X.1i r0 = r0.A0V
            if (r0 == 0) goto L67
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L33;
                case 4: goto L1e;
                case 5: goto L69;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.HM r5 = (com.facebook.ads.redexgen.X.HM) r5
            com.facebook.ads.redexgen.X.HX r0 = r5.A01
            com.facebook.ads.redexgen.X.1i r0 = r0.A0V
            r0.A0U()
            com.facebook.ads.redexgen.X.HX r1 = r5.A01
            r0 = 0
            r1.A0V = r0
            r0 = 3
            goto La
        L1e:
            com.facebook.ads.redexgen.X.HM r5 = (com.facebook.ads.redexgen.X.HM) r5
            com.facebook.ads.internal.protocol.AdErrorType r4 = (com.facebook.ads.internal.protocol.AdErrorType) r4
            java.lang.String r6 = (java.lang.String) r6
            com.facebook.ads.redexgen.X.HX r0 = r5.A01
            com.facebook.ads.redexgen.X.HZ r1 = com.facebook.ads.redexgen.X.HX.A0K(r0)
            com.facebook.ads.redexgen.X.Hr r0 = com.facebook.ads.redexgen.X.C0453Hr.A02(r4, r6)
            r1.A6Y(r0)
            r0 = 5
            goto La
        L33:
            com.facebook.ads.redexgen.X.HM r5 = (com.facebook.ads.redexgen.X.HM) r5
            com.facebook.ads.internal.protocol.AdErrorType r4 = com.facebook.ads.internal.protocol.AdErrorType.CACHE_FAILURE_ERROR
            r2 = 0
            r1 = 27
            r0 = 126(0x7e, float:1.77E-43)
            java.lang.String r6 = A00(r2, r1, r0)
            com.facebook.ads.redexgen.X.HX r0 = r5.A01
            com.facebook.ads.redexgen.X.Ec r0 = com.facebook.ads.redexgen.X.HX.A0G(r0)
            com.facebook.ads.redexgen.X.0c r3 = r0.A08()
            com.facebook.ads.redexgen.X.HX r0 = r5.A01
            long r0 = com.facebook.ads.redexgen.X.HX.A04(r0)
            long r1 = com.facebook.ads.redexgen.X.K4.A01(r0)
            int r0 = r4.getErrorCode()
            r3.A2a(r1, r0, r6)
            com.facebook.ads.redexgen.X.HX r0 = r5.A01
            com.facebook.ads.redexgen.X.HZ r0 = com.facebook.ads.redexgen.X.HX.A0K(r0)
            if (r0 == 0) goto L65
            r0 = 4
            goto La
        L65:
            r0 = 5
            goto La
        L67:
            r0 = 3
            goto La
        L69:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HM.A6I():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x0088, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.C1Z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A6P() {
        /*
            r3 = this;
            r2 = r3
            com.facebook.ads.redexgen.X.HX r1 = r2.A01
            com.facebook.ads.redexgen.X.1i r0 = r2.A00
            r1.A0V = r0
            boolean r0 = r2.A02
            if (r0 == 0) goto L86
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L5e;
                case 3: goto L51;
                case 4: goto L34;
                case 5: goto L1f;
                case 6: goto L10;
                case 7: goto L78;
                case 8: goto L6c;
                case 9: goto L43;
                case 10: goto L88;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            com.facebook.ads.redexgen.X.HM r2 = (com.facebook.ads.redexgen.X.HM) r2
            com.facebook.ads.redexgen.X.HX r0 = r2.A01
            boolean r0 = com.facebook.ads.redexgen.X.HX.A0r(r0)
            if (r0 != 0) goto L1c
            r0 = 7
            goto Lc
        L1c:
            r0 = 8
            goto Lc
        L1f:
            com.facebook.ads.redexgen.X.HM r2 = (com.facebook.ads.redexgen.X.HM) r2
            com.facebook.ads.redexgen.X.HX r0 = r2.A01
            com.facebook.ads.redexgen.X.HI r1 = com.facebook.ads.redexgen.X.HX.A0H(r0)
            com.facebook.ads.redexgen.X.HI r0 = com.facebook.ads.redexgen.X.HI.A04
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L31
            r0 = 6
            goto Lc
        L31:
            r0 = 8
            goto Lc
        L34:
            com.facebook.ads.redexgen.X.HM r2 = (com.facebook.ads.redexgen.X.HM) r2
            com.facebook.ads.redexgen.X.HX r0 = r2.A01
            com.facebook.ads.redexgen.X.HZ r0 = com.facebook.ads.redexgen.X.HX.A0K(r0)
            if (r0 == 0) goto L40
            r0 = 5
            goto Lc
        L40:
            r0 = 10
            goto Lc
        L43:
            com.facebook.ads.redexgen.X.HM r2 = (com.facebook.ads.redexgen.X.HM) r2
            com.facebook.ads.redexgen.X.HX r0 = r2.A01
            com.facebook.ads.redexgen.X.HZ r0 = com.facebook.ads.redexgen.X.HX.A0K(r0)
            r0.A68()
            r0 = 10
            goto Lc
        L51:
            com.facebook.ads.redexgen.X.HM r2 = (com.facebook.ads.redexgen.X.HM) r2
            com.facebook.ads.redexgen.X.HX r0 = r2.A01
            com.facebook.ads.redexgen.X.3I r0 = com.facebook.ads.redexgen.X.HX.A0F(r0)
            r0.A09()
            r0 = 4
            goto Lc
        L5e:
            com.facebook.ads.redexgen.X.HM r2 = (com.facebook.ads.redexgen.X.HM) r2
            com.facebook.ads.redexgen.X.HX r0 = r2.A01
            com.facebook.ads.redexgen.X.3I r0 = com.facebook.ads.redexgen.X.HX.A0F(r0)
            if (r0 == 0) goto L6a
            r0 = 3
            goto Lc
        L6a:
            r0 = 4
            goto Lc
        L6c:
            com.facebook.ads.redexgen.X.HM r2 = (com.facebook.ads.redexgen.X.HM) r2
            boolean r0 = r2.A02
            if (r0 == 0) goto L75
            r0 = 9
            goto Lc
        L75:
            r0 = 10
            goto Lc
        L78:
            com.facebook.ads.redexgen.X.HM r2 = (com.facebook.ads.redexgen.X.HM) r2
            com.facebook.ads.redexgen.X.HX r0 = r2.A01
            com.facebook.ads.redexgen.X.HZ r0 = com.facebook.ads.redexgen.X.HX.A0K(r0)
            r0.A73()
            r0 = 8
            goto Lc
        L86:
            r0 = 4
            goto Lc
        L88:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HM.A6P():void");
    }
}
