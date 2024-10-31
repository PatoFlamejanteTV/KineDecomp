package com.facebook.ads.redexgen.X;

import android.text.TextUtils;

/* renamed from: com.facebook.ads.redexgen.X.1s, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C00471s extends C1H {
    public static final String A05 = C00471s.class.getSimpleName();
    public C00451q A00;
    public boolean A01;
    public final C0362Ec A02;
    public final InterfaceC0422Gl A03;
    public final ND A04;

    public C00471s(C0362Ec c0362Ec, InterfaceC0422Gl interfaceC0422Gl, ND nd, FP fp, C1I c1i) {
        super(c0362Ec, c1i, fp);
        this.A03 = interfaceC0422Gl;
        this.A04 = nd;
        this.A02 = c0362Ec;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0038, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.C1H
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A06(java.util.Map<java.lang.String, java.lang.String> r4) {
        /*
            r3 = this;
            r2 = r3
            com.facebook.ads.redexgen.X.1q r0 = r2.A00
            if (r0 == 0) goto L36
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L1c;
                case 4: goto L38;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.1s r2 = (com.facebook.ads.redexgen.X.C00471s) r2
            com.facebook.ads.redexgen.X.1q r0 = r2.A00
            java.lang.String r0 = r0.A4V()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L1a
            r0 = 3
            goto L6
        L1a:
            r0 = 4
            goto L6
        L1c:
            com.facebook.ads.redexgen.X.1s r2 = (com.facebook.ads.redexgen.X.C00471s) r2
            java.util.Map r4 = (java.util.Map) r4
            com.facebook.ads.redexgen.X.Ec r0 = r2.A02
            com.facebook.ads.redexgen.X.0c r0 = r0.A08()
            r0.A2X()
            com.facebook.ads.redexgen.X.Gl r1 = r2.A03
            com.facebook.ads.redexgen.X.1q r0 = r2.A00
            java.lang.String r0 = r0.A4V()
            r1.A5a(r0, r4)
            r0 = 4
            goto L6
        L36:
            r0 = 4
            goto L6
        L38:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00471s.A06(java.util.Map):void");
    }

    public final synchronized void A07() {
        if (!this.A01 && this.A00 != null) {
            this.A01 = true;
            if (!TextUtils.isEmpty(this.A00.A03())) {
                K7.A00(new AbstractRunnableC00351g() { // from class: com.facebook.ads.redexgen.X.1r
                    public static byte[] A01;

                    static {
                        A04();
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
                            byte[] r1 = com.facebook.ads.redexgen.X.C00461r.A01
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
                            int r0 = r0 + (-66)
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00461r.A01(int, int, int):java.lang.String");
                    }

                    public static void A04() {
                        A01 = new byte[]{11, 2, 23, 2, 20, 4, 19, 10, 17, 21, -37};
                    }

                    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00351g
                    public final void A05() {
                        C0362Ec c0362Ec;
                        ND nd;
                        C00451q c00451q;
                        c0362Ec = C00471s.this.A02;
                        c0362Ec.A08().A8e();
                        nd = C00471s.this.A04;
                        StringBuilder append = new StringBuilder().append(A01(0, 11, 95));
                        c00451q = C00471s.this.A00;
                        nd.loadUrl(append.append(c00451q.A03()).toString());
                    }
                });
            }
        }
    }

    public final void A08(C00451q c00451q) {
        this.A00 = c00451q;
    }
}
