package com.facebook.ads.redexgen.X;

/* loaded from: assets/audience_network.dex */
public class LJ extends AbstractC02198o {
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
            byte[] r1 = com.facebook.ads.redexgen.X.LJ.A01
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
            int r0 = r0 + (-36)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.LJ.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{-72, -85, -90, -89, -79, -117, -80, -74, -89, -76, -75, -74, -85, -74, -93, -82, -121, -72, -89, -80, -74};
    }

    public LJ(LO lo) {
        this.A00 = lo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0036, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.C1S
    /* renamed from: A02, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A03(com.facebook.ads.redexgen.X.QQ r6) {
        /*
            r5 = this;
            r4 = r5
            com.facebook.ads.redexgen.X.LO r0 = r4.A00
            com.facebook.ads.redexgen.X.81 r0 = r0.getAudienceNetworkListener()
            if (r0 == 0) goto L34
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L26;
                case 4: goto L36;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.LJ r4 = (com.facebook.ads.redexgen.X.LJ) r4
            com.facebook.ads.redexgen.X.QQ r6 = (com.facebook.ads.redexgen.X.QQ) r6
            com.facebook.ads.redexgen.X.LO r0 = r4.A00
            com.facebook.ads.redexgen.X.81 r3 = r0.getAudienceNetworkListener()
            r2 = 0
            r1 = 21
            r0 = 30
            java.lang.String r0 = A00(r2, r1, r0)
            r3.A3c(r0, r6)
            r0 = 3
            goto La
        L26:
            com.facebook.ads.redexgen.X.LJ r4 = (com.facebook.ads.redexgen.X.LJ) r4
            com.facebook.ads.redexgen.X.LO r0 = r4.A00
            com.facebook.ads.redexgen.X.Nr r0 = com.facebook.ads.redexgen.X.LO.A06(r0)
            if (r0 == 0) goto L32
            r0 = 4
            goto La
        L32:
            r0 = 4
            goto La
        L34:
            r0 = 3
            goto La
        L36:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.LJ.A03(com.facebook.ads.redexgen.X.QQ):void");
    }
}
