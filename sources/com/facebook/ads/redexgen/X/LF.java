package com.facebook.ads.redexgen.X;

/* loaded from: assets/audience_network.dex */
public class LF extends AbstractC02278w {
    public static byte[] A01;
    public final /* synthetic */ LO A00;

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
            byte[] r1 = com.facebook.ads.redexgen.X.LF.A01
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
            r0 = r0 ^ 51
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.LF.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{16, 15, 2, 3, 9, 47, 8, 18, 3, 20, 21, 18, 15, 18, 7, 10, 35, 16, 3, 8, 18};
    }

    public LF(LO lo) {
        this.A00 = lo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x007d, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.C1S
    /* renamed from: A02, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A03(com.facebook.ads.redexgen.X.QN r6) {
        /*
            r5 = this;
            r4 = r5
            com.facebook.ads.redexgen.X.LO r0 = r4.A00
            com.facebook.ads.redexgen.X.81 r0 = r0.getAudienceNetworkListener()
            if (r0 == 0) goto L7b
            r0 = 2
        La:
            switch(r0) {
                case 2: goto L63;
                case 3: goto L47;
                case 4: goto L39;
                case 5: goto L1d;
                case 6: goto Le;
                case 7: goto L55;
                case 8: goto L7d;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.LF r4 = (com.facebook.ads.redexgen.X.LF) r4
            com.facebook.ads.redexgen.X.LO r0 = r4.A00
            com.facebook.ads.redexgen.X.89 r0 = com.facebook.ads.redexgen.X.LO.A01(r0)
            if (r0 == 0) goto L1a
            r0 = 7
            goto La
        L1a:
            r0 = 8
            goto La
        L1d:
            com.facebook.ads.redexgen.X.LF r4 = (com.facebook.ads.redexgen.X.LF) r4
            com.facebook.ads.redexgen.X.LO r0 = r4.A00
            com.facebook.ads.redexgen.X.Lb r0 = com.facebook.ads.redexgen.X.LO.A09(r0)
            r0.A0N()
            com.facebook.ads.redexgen.X.LO r0 = r4.A00
            com.facebook.ads.redexgen.X.Lb r0 = com.facebook.ads.redexgen.X.LO.A09(r0)
            r0.A0K()
            com.facebook.ads.redexgen.X.LO r1 = r4.A00
            r0 = 1
            com.facebook.ads.redexgen.X.LO.A0P(r1, r0)
            r0 = 6
            goto La
        L39:
            com.facebook.ads.redexgen.X.LF r4 = (com.facebook.ads.redexgen.X.LF) r4
            com.facebook.ads.redexgen.X.LO r0 = r4.A00
            boolean r0 = com.facebook.ads.redexgen.X.LO.A0L(r0)
            if (r0 != 0) goto L45
            r0 = 5
            goto La
        L45:
            r0 = 6
            goto La
        L47:
            com.facebook.ads.redexgen.X.LF r4 = (com.facebook.ads.redexgen.X.LF) r4
            com.facebook.ads.redexgen.X.LO r0 = r4.A00
            com.facebook.ads.redexgen.X.Nr r0 = com.facebook.ads.redexgen.X.LO.A06(r0)
            if (r0 == 0) goto L53
            r0 = 4
            goto La
        L53:
            r0 = 4
            goto La
        L55:
            com.facebook.ads.redexgen.X.LF r4 = (com.facebook.ads.redexgen.X.LF) r4
            com.facebook.ads.redexgen.X.LO r0 = r4.A00
            com.facebook.ads.redexgen.X.89 r0 = com.facebook.ads.redexgen.X.LO.A01(r0)
            r0.finish()
            r0 = 8
            goto La
        L63:
            com.facebook.ads.redexgen.X.LF r4 = (com.facebook.ads.redexgen.X.LF) r4
            com.facebook.ads.redexgen.X.QN r6 = (com.facebook.ads.redexgen.X.QN) r6
            com.facebook.ads.redexgen.X.LO r0 = r4.A00
            com.facebook.ads.redexgen.X.81 r3 = r0.getAudienceNetworkListener()
            r2 = 0
            r1 = 21
            r0 = 85
            java.lang.String r0 = A00(r2, r1, r0)
            r3.A3c(r0, r6)
            r0 = 3
            goto La
        L7b:
            r0 = 3
            goto La
        L7d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.LF.A03(com.facebook.ads.redexgen.X.QN):void");
    }
}
