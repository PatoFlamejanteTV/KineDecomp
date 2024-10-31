package com.facebook.ads.redexgen.X;

import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.1H, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public abstract class C1H {
    public static byte[] A04;
    public boolean A00;
    public final C0362Ec A01;
    public final C1I A02;
    public final FP A03;

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
            byte[] r1 = com.facebook.ads.redexgen.X.C1H.A04
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
            int r0 = r0 + (-28)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1H.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A04 = new byte[]{-103, -67, -64, -62, -75, -61, -61, -71, -65, -66, 112, -68, -65, -73, -73, -75, -76};
    }

    public abstract void A06(Map<String, String> map);

    public C1H(C0362Ec c0362Ec, C1I c1i, FP fp) {
        this.A01 = c0362Ec;
        this.A02 = c1i;
        this.A03 = fp;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x004c, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A02() {
        /*
            r5 = this;
            r4 = r5
            boolean r0 = r4.A00
            if (r0 == 0) goto L4a
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto L4c;
                case 3: goto La;
                case 4: goto L14;
                case 5: goto L1d;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.1H r4 = (com.facebook.ads.redexgen.X.C1H) r4
            com.facebook.ads.redexgen.X.1I r0 = r4.A02
            if (r0 == 0) goto L12
            r0 = 4
            goto L6
        L12:
            r0 = 5
            goto L6
        L14:
            com.facebook.ads.redexgen.X.1H r4 = (com.facebook.ads.redexgen.X.C1H) r4
            com.facebook.ads.redexgen.X.1I r0 = r4.A02
            r0.A00()
            r0 = 5
            goto L6
        L1d:
            com.facebook.ads.redexgen.X.1H r4 = (com.facebook.ads.redexgen.X.C1H) r4
            com.facebook.ads.redexgen.X.NS r1 = new com.facebook.ads.redexgen.X.NS
            r1.<init>()
            com.facebook.ads.redexgen.X.FP r0 = r4.A03
            com.facebook.ads.redexgen.X.NS r0 = r1.A03(r0)
            java.util.Map r0 = r0.A05()
            r4.A06(r0)
            r0 = 1
            r4.A00 = r0
            com.facebook.ads.redexgen.X.Ec r3 = r4.A01
            r2 = 0
            r1 = 17
            r0 = 52
            java.lang.String r0 = A00(r2, r1, r0)
            com.facebook.ads.redexgen.X.JP.A02(r3, r0)
            com.facebook.ads.redexgen.X.1I r0 = r4.A02
            if (r0 == 0) goto L48
            r0 = 2
            goto L6
        L48:
            r0 = 2
            goto L6
        L4a:
            r0 = 3
            goto L6
        L4c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1H.A02():void");
    }
}
