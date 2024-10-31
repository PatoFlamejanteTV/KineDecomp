package com.facebook.ads.redexgen.X;

/* loaded from: assets/audience_network.dex */
public class PM extends AnonymousClass29 {
    public static byte[] A01;
    public final /* synthetic */ PP A00;

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
            byte[] r1 = com.facebook.ads.redexgen.X.PM.A01
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
            int r0 = r0 + (-26)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.PM.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{-67, -55, -57, -120, -64, -69, -67, -65, -68, -55, -55, -59, -120, -69, -66, -51, -120, -61, -56, -50, -65, -52, -51, -50, -61, -50, -61, -69, -58, -120, -61, -57, -54, -52, -65, -51, -51, -61, -55, -56, -120, -58, -55, -63, -63, -65, -66};
    }

    public PM(PP pp) {
        this.A00 = pp;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a0, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.AnonymousClass29
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A03() {
        /*
            r5 = this;
            r3 = r5
            com.facebook.ads.redexgen.X.PP r0 = r3.A00
            com.facebook.ads.redexgen.X.K5 r0 = com.facebook.ads.redexgen.X.PP.A03(r0)
            boolean r0 = r0.A07()
            if (r0 != 0) goto L9d
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L12;
                case 3: goto L29;
                case 4: goto L3f;
                case 5: goto L51;
                case 6: goto La0;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            com.facebook.ads.redexgen.X.PM r3 = (com.facebook.ads.redexgen.X.PM) r3
            com.facebook.ads.redexgen.X.PP r0 = r3.A00
            com.facebook.ads.redexgen.X.K5 r0 = com.facebook.ads.redexgen.X.PP.A03(r0)
            r0.A05()
            com.facebook.ads.redexgen.X.PP r0 = r3.A00
            com.facebook.ads.redexgen.X.81 r0 = com.facebook.ads.redexgen.X.PP.A06(r0)
            if (r0 == 0) goto L27
            r0 = 3
            goto Le
        L27:
            r0 = 4
            goto Le
        L29:
            com.facebook.ads.redexgen.X.PM r3 = (com.facebook.ads.redexgen.X.PM) r3
            com.facebook.ads.redexgen.X.PP r0 = r3.A00
            com.facebook.ads.redexgen.X.81 r4 = com.facebook.ads.redexgen.X.PP.A07(r0)
            r2 = 0
            r1 = 47
            r0 = 64
            java.lang.String r0 = A00(r2, r1, r0)
            r4.A3b(r0)
            r0 = 4
            goto Le
        L3f:
            com.facebook.ads.redexgen.X.PM r3 = (com.facebook.ads.redexgen.X.PM) r3
            com.facebook.ads.redexgen.X.PP r0 = r3.A00
            java.lang.String r0 = com.facebook.ads.redexgen.X.PP.A0B(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L4f
            r0 = 5
            goto Le
        L4f:
            r0 = 6
            goto Le
        L51:
            com.facebook.ads.redexgen.X.PM r3 = (com.facebook.ads.redexgen.X.PM) r3
            com.facebook.ads.redexgen.X.NS r1 = new com.facebook.ads.redexgen.X.NS
            r1.<init>()
            com.facebook.ads.redexgen.X.PP r0 = r3.A00
            com.facebook.ads.redexgen.X.FP r0 = com.facebook.ads.redexgen.X.PP.A09(r0)
            com.facebook.ads.redexgen.X.NS r1 = r1.A03(r0)
            com.facebook.ads.redexgen.X.PP r0 = r3.A00
            com.facebook.ads.redexgen.X.K5 r0 = com.facebook.ads.redexgen.X.PP.A03(r0)
            com.facebook.ads.redexgen.X.NS r1 = r1.A02(r0)
            com.facebook.ads.redexgen.X.PP r0 = r3.A00
            com.facebook.ads.redexgen.X.2W r0 = com.facebook.ads.redexgen.X.PP.A00(r0)
            java.lang.String r0 = r0.A0R()
            com.facebook.ads.redexgen.X.NS r0 = r1.A04(r0)
            java.util.Map r2 = r0.A05()
            com.facebook.ads.redexgen.X.PP r0 = r3.A00
            com.facebook.ads.redexgen.X.Gl r1 = com.facebook.ads.redexgen.X.PP.A02(r0)
            com.facebook.ads.redexgen.X.PP r0 = r3.A00
            java.lang.String r0 = com.facebook.ads.redexgen.X.PP.A0B(r0)
            r1.A5a(r0, r2)
            com.facebook.ads.redexgen.X.PP r0 = r3.A00
            com.facebook.ads.redexgen.X.Ec r0 = com.facebook.ads.redexgen.X.PP.A01(r0)
            com.facebook.ads.redexgen.X.0c r0 = r0.A08()
            r0.A2X()
            r0 = 6
            goto Le
        L9d:
            r0 = 6
            goto Le
        La0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.PM.A03():void");
    }
}
