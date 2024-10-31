package com.facebook.ads.redexgen.X;

import android.os.Bundle;

/* renamed from: com.facebook.ads.redexgen.X.42, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass42 implements InterfaceC00301b<Bundle> {
    public static byte[] A06;
    public AnonymousClass41 A00;
    public boolean A01;
    public boolean A02;
    public boolean A03;
    public final C1X A04;
    public final AnonymousClass41 A05;

    static {
        A04();
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
            byte[] r1 = com.facebook.ads.redexgen.X.AnonymousClass42.A06
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
            int r0 = r0 + (-47)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass42.A00(int, int, int):java.lang.String");
    }

    public static void A04() {
        A06 = new byte[]{-68, -83, -69, -68, -101, -68, -87, -68, -69, -21, -36, -18, -18, -32, -33, -39, -30, -40, -39, -40, -78, -66, -68, -65, -69, -76, -61, -76, -66, -79, -83, -65, -87, -86, -76, -83, -101, -68, -87, -68, -69};
    }

    public AnonymousClass42(C1X c1x) {
        this.A02 = false;
        this.A03 = false;
        this.A01 = false;
        this.A04 = c1x;
        this.A05 = new AnonymousClass41(c1x.A01);
        this.A00 = new AnonymousClass41(c1x.A01);
    }

    public AnonymousClass42(C1X c1x, Bundle bundle) {
        this.A02 = false;
        this.A03 = false;
        this.A01 = false;
        this.A04 = c1x;
        this.A05 = (AnonymousClass41) Jk.A00(bundle.getByteArray(A00(0, 9, 25)));
        this.A00 = (AnonymousClass41) Jk.A00(bundle.getByteArray(A00(28, 13, 25)));
        this.A02 = bundle.getBoolean(A00(15, 5, 69));
        this.A03 = bundle.getBoolean(A00(9, 6, 76));
        this.A01 = bundle.getBoolean(A00(20, 8, 32));
    }

    private void A01() {
        this.A01 = true;
        A02();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001c, code lost:            r4 = r4;        r4.A04.A00(r4.A01, r4.A03, r3);     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A02() {
        /*
            r5 = this;
            r4 = r5
            r3 = 0
            r0 = 1
            r4.A02 = r0
            boolean r0 = r4.A03
            if (r0 == 0) goto L1a
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L1c;
                case 4: goto L14;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.42 r4 = (com.facebook.ads.redexgen.X.AnonymousClass42) r4
            com.facebook.ads.redexgen.X.41 r3 = r4.A00
            r0 = 3
            goto La
        L14:
            com.facebook.ads.redexgen.X.42 r4 = (com.facebook.ads.redexgen.X.AnonymousClass42) r4
            com.facebook.ads.redexgen.X.41 r3 = r4.A05
            r0 = 3
            goto La
        L1a:
            r0 = 4
            goto La
        L1c:
            com.facebook.ads.redexgen.X.42 r4 = (com.facebook.ads.redexgen.X.AnonymousClass42) r4
            com.facebook.ads.redexgen.X.41 r3 = (com.facebook.ads.redexgen.X.AnonymousClass41) r3
            com.facebook.ads.redexgen.X.1X r2 = r4.A04
            boolean r1 = r4.A01
            boolean r0 = r4.A03
            r2.A00(r1, r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass42.A02():void");
    }

    private void A03() {
        this.A03 = true;
        A01();
    }

    public final void A05() {
        if (!this.A02) {
            this.A00.A03();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x0097, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A06(double r11, double r13) {
        /*
            r10 = this;
            r3 = r10
            r0 = 0
            r8 = 0
            r6 = 0
            boolean r0 = r3.A02
            if (r0 == 0) goto L94
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L97;
                case 3: goto L38;
                case 4: goto L56;
                case 5: goto L29;
                case 6: goto L10;
                case 7: goto L6b;
                case 8: goto L4f;
                case 9: goto L75;
                case 10: goto L83;
                case 11: goto L64;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            com.facebook.ads.redexgen.X.42 r3 = (com.facebook.ads.redexgen.X.AnonymousClass42) r3
            com.facebook.ads.redexgen.X.41 r0 = r3.A05
            com.facebook.ads.redexgen.X.40 r0 = r0.A00()
            double r4 = r0.A04()
            com.facebook.ads.redexgen.X.1X r0 = r3.A04
            double r1 = r0.A00
            int r0 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r0 <= 0) goto L26
            r0 = 7
            goto Lc
        L26:
            r0 = 10
            goto Lc
        L29:
            com.facebook.ads.redexgen.X.42 r3 = (com.facebook.ads.redexgen.X.AnonymousClass42) r3
            com.facebook.ads.redexgen.X.1X r0 = r3.A04
            double r1 = r0.A00
            int r0 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r0 < 0) goto L35
            r0 = 6
            goto Lc
        L35:
            r0 = 10
            goto Lc
        L38:
            com.facebook.ads.redexgen.X.42 r3 = (com.facebook.ads.redexgen.X.AnonymousClass42) r3
            com.facebook.ads.redexgen.X.41 r0 = r3.A05
            r0.A04(r11, r13)
            com.facebook.ads.redexgen.X.41 r0 = r3.A00
            r0.A04(r11, r13)
            com.facebook.ads.redexgen.X.1X r0 = r3.A04
            boolean r0 = r0.A03
            if (r0 == 0) goto L4c
            r0 = 4
            goto Lc
        L4c:
            r0 = 9
            goto Lc
        L4f:
            com.facebook.ads.redexgen.X.42 r3 = (com.facebook.ads.redexgen.X.AnonymousClass42) r3
            r3.A01()
            r0 = 2
            goto Lc
        L56:
            com.facebook.ads.redexgen.X.42 r3 = (com.facebook.ads.redexgen.X.AnonymousClass42) r3
            com.facebook.ads.redexgen.X.41 r0 = r3.A00
            com.facebook.ads.redexgen.X.40 r0 = r0.A00()
            double r8 = r0.A03()
            r0 = 5
            goto Lc
        L64:
            com.facebook.ads.redexgen.X.42 r3 = (com.facebook.ads.redexgen.X.AnonymousClass42) r3
            r3.A03()
            r0 = 2
            goto Lc
        L6b:
            int r0 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r0 != 0) goto L72
            r0 = 8
            goto Lc
        L72:
            r0 = 10
            goto Lc
        L75:
            com.facebook.ads.redexgen.X.42 r3 = (com.facebook.ads.redexgen.X.AnonymousClass42) r3
            com.facebook.ads.redexgen.X.41 r0 = r3.A00
            com.facebook.ads.redexgen.X.40 r0 = r0.A00()
            double r8 = r0.A01()
            r0 = 5
            goto Lc
        L83:
            com.facebook.ads.redexgen.X.42 r3 = (com.facebook.ads.redexgen.X.AnonymousClass42) r3
            com.facebook.ads.redexgen.X.1X r0 = r3.A04
            double r1 = r0.A02
            int r0 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r0 < 0) goto L91
            r0 = 11
            goto Lc
        L91:
            r0 = 2
            goto Lc
        L94:
            r0 = 3
            goto Lc
        L97:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass42.A06(double, double):void");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00301b
    public final Bundle getSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putByteArray(A00(28, 13, 25), Jk.A01(this.A00));
        bundle.putByteArray(A00(0, 9, 25), Jk.A01(this.A05));
        bundle.putBoolean(A00(15, 5, 69), this.A02);
        bundle.putBoolean(A00(9, 6, 76), this.A03);
        bundle.putBoolean(A00(20, 8, 32), this.A01);
        return bundle;
    }
}
