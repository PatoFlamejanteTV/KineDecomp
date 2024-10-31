package com.facebook.ads.redexgen.X;

/* loaded from: assets/audience_network.dex */
public class LA extends AnonymousClass29 {
    public static byte[] A01;
    public final /* synthetic */ LD A00;

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
            byte[] r1 = com.facebook.ads.redexgen.X.LA.A01
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
            r0 = r0 ^ 108(0x6c, float:1.51E-43)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.LA.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{74, 70, 68, 7, 79, 72, 74, 76, 75, 70, 70, 66, 7, 72, 77, 90, 7, 64, 71, 93, 76, 91, 90, 93, 64, 93, 64, 72, 69, 7, 64, 68, 89, 91, 76, 90, 90, 64, 70, 71, 7, 69, 70, 78, 78, 76, 77};
    }

    public LA(LD ld) {
        this.A00 = ld;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0084, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.AnonymousClass29
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A03() {
        /*
            r5 = this;
            r4 = r5
            com.facebook.ads.redexgen.X.LD r0 = r4.A00
            com.facebook.ads.redexgen.X.K5 r0 = com.facebook.ads.redexgen.X.LD.A01(r0)
            boolean r0 = r0.A07()
            if (r0 != 0) goto L82
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L12;
                case 3: goto L6c;
                case 4: goto L84;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            com.facebook.ads.redexgen.X.LA r4 = (com.facebook.ads.redexgen.X.LA) r4
            com.facebook.ads.redexgen.X.LD r0 = r4.A00
            com.facebook.ads.redexgen.X.K5 r0 = com.facebook.ads.redexgen.X.LD.A01(r0)
            r0.A05()
            com.facebook.ads.redexgen.X.NS r1 = new com.facebook.ads.redexgen.X.NS
            r1.<init>()
            com.facebook.ads.redexgen.X.LD r0 = r4.A00
            com.facebook.ads.redexgen.X.FP r0 = com.facebook.ads.redexgen.X.LD.A02(r0)
            com.facebook.ads.redexgen.X.NS r1 = r1.A03(r0)
            com.facebook.ads.redexgen.X.LD r0 = r4.A00
            com.facebook.ads.redexgen.X.K5 r0 = com.facebook.ads.redexgen.X.LD.A01(r0)
            com.facebook.ads.redexgen.X.NS r1 = r1.A02(r0)
            com.facebook.ads.redexgen.X.LD r0 = r4.A00
            com.facebook.ads.redexgen.X.2W r0 = r0.A09
            java.lang.String r0 = r0.A0R()
            com.facebook.ads.redexgen.X.NS r0 = r1.A04(r0)
            java.util.Map r2 = r0.A05()
            com.facebook.ads.redexgen.X.LD r0 = r4.A00
            com.facebook.ads.redexgen.X.Gl r1 = r0.A0B
            com.facebook.ads.redexgen.X.LD r0 = r4.A00
            com.facebook.ads.redexgen.X.2W r0 = r0.A09
            java.lang.String r0 = r0.A0P()
            r1.A5a(r0, r2)
            com.facebook.ads.redexgen.X.LD r0 = r4.A00
            com.facebook.ads.redexgen.X.Ec r0 = r0.A0A
            com.facebook.ads.redexgen.X.0c r0 = r0.A08()
            r0.A2X()
            com.facebook.ads.redexgen.X.LD r0 = r4.A00
            com.facebook.ads.redexgen.X.81 r0 = r0.getAudienceNetworkListener()
            if (r0 == 0) goto L6a
            r0 = 3
            goto Le
        L6a:
            r0 = 4
            goto Le
        L6c:
            com.facebook.ads.redexgen.X.LA r4 = (com.facebook.ads.redexgen.X.LA) r4
            com.facebook.ads.redexgen.X.LD r0 = r4.A00
            com.facebook.ads.redexgen.X.81 r3 = r0.getAudienceNetworkListener()
            r2 = 0
            r1 = 47
            r0 = 69
            java.lang.String r0 = A00(r2, r1, r0)
            r3.A3b(r0)
            r0 = 4
            goto Le
        L82:
            r0 = 4
            goto Le
        L84:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.LA.A03():void");
    }
}
