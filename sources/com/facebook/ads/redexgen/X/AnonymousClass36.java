package com.facebook.ads.redexgen.X;

import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.36, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass36 extends AnonymousClass35 {
    public C0364Ee A00;

    public AnonymousClass36(C0364Ee c0364Ee, AnonymousClass31 anonymousClass31) {
        super(c0364Ee, anonymousClass31);
        this.A00 = c0364Ee;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0017, code lost:            r1.A3X(r2);        super.A0F(r4);     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0024, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.AnonymousClass35
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0F(java.lang.String r4) {
        /*
            r3 = this;
            r2 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.Ee r0 = r3.A00
            com.facebook.ads.redexgen.X.0d r1 = r0.A08()
            if (r4 == 0) goto L15
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L17;
                case 4: goto L12;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            r2 = 1
            r0 = 3
            goto Lb
        L12:
            r2 = 0
            r0 = 3
            goto Lb
        L15:
            r0 = 4
            goto Lb
        L17:
            r0 = r3
            com.facebook.ads.redexgen.X.36 r0 = (com.facebook.ads.redexgen.X.AnonymousClass36) r0
            java.lang.String r4 = (java.lang.String) r4
            com.facebook.ads.redexgen.X.0d r1 = (com.facebook.ads.redexgen.X.InterfaceC00060d) r1
            r1.A3X(r2)
            super.A0F(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass36.A0F(java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.AnonymousClass35
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0K() {
        /*
            r3 = this;
            r2 = r3
            android.view.View r0 = r2.A00
            if (r0 == 0) goto L2b
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L2d;
                case 4: goto L1e;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.36 r2 = (com.facebook.ads.redexgen.X.AnonymousClass36) r2
            com.facebook.ads.redexgen.X.Ee r0 = r2.A00
            com.facebook.ads.redexgen.X.0d r0 = r0.A08()
            r0.A3Y()
            com.facebook.ads.redexgen.X.1G r1 = r2.A06
            android.view.View r0 = r2.A00
            r1.A0E(r0)
            r0 = 3
            goto L6
        L1e:
            com.facebook.ads.redexgen.X.36 r2 = (com.facebook.ads.redexgen.X.AnonymousClass36) r2
            com.facebook.ads.redexgen.X.Ee r0 = r2.A00
            com.facebook.ads.redexgen.X.0d r0 = r0.A08()
            r0.A3Z()
            r0 = 3
            goto L6
        L2b:
            r0 = 4
            goto L6
        L2d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass36.A0K():void");
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass35
    public final void A0L(C1F c1f, C0402Fq c0402Fq, C0400Fo c0400Fo, final Map<String, Object> map) {
        this.A00.A08().A3S();
        final C1R c1r = (C1R) c1f;
        final AbstractRunnableC00351g abstractRunnableC00351g = new AbstractRunnableC00351g() { // from class: com.facebook.ads.redexgen.X.32
            @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00351g
            public final void A05() {
                AnonymousClass36.this.A0H(map);
                AnonymousClass36.this.A0D(c1r);
                AnonymousClass36.this.A0C();
            }
        };
        A06().postDelayed(abstractRunnableC00351g, c0402Fq.A05().A05());
        c1r.A0C(this.A00, this.A08, this.A07.A06, new C1L() { // from class: com.facebook.ads.redexgen.X.33
            public static byte[] A02;

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
                    byte[] r1 = com.facebook.ads.redexgen.X.AnonymousClass33.A02
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
                    int r0 = r0 + (-106)
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass33.A00(int, int, int):java.lang.String");
            }

            public static void A01() {
                A02 = new byte[]{-37, -6, 7, 7, -2, 11, -71, 2, 6, 9, 11, -2, 12, 12, 2, 8, 7, -71, -1, 2, 11, -2, -3, 45, 44, 0, 31, 44, 44, 35, 48, 10, 45, 37, 37, 39, 44, 37, 7, 43, 46, 48, 35, 49, 49, 39, 45, 44, -27, -22, 25, -23, -25, -21, -24, -26};
            }

            @Override // com.facebook.ads.redexgen.X.C1L
            public final void A6D(C1R c1r2) {
                C0364Ee c0364Ee;
                c0364Ee = AnonymousClass36.this.A00;
                c0364Ee.A08().A3U();
                AnonymousClass36.this.A06.A0C();
            }

            /* JADX WARN: Code restructure failed: missing block: B:38:0x007d, code lost:            return;     */
            @Override // com.facebook.ads.redexgen.X.C1L
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void A6E(com.facebook.ads.redexgen.X.C1R r6, android.view.View r7) {
                /*
                    r5 = this;
                    r3 = r5
                    r0 = 0
                    r4 = 0
                    r2 = 0
                    com.facebook.ads.redexgen.X.36 r0 = com.facebook.ads.redexgen.X.AnonymousClass36.this
                    com.facebook.ads.redexgen.X.Ee r0 = com.facebook.ads.redexgen.X.AnonymousClass36.A02(r0)
                    com.facebook.ads.redexgen.X.0d r1 = r0.A08()
                    com.facebook.ads.redexgen.X.36 r0 = com.facebook.ads.redexgen.X.AnonymousClass36.this
                    com.facebook.ads.redexgen.X.1F r0 = r0.A01
                    if (r6 != r0) goto L7a
                    r0 = 2
                L15:
                    switch(r0) {
                        case 2: goto L60;
                        case 3: goto L4d;
                        case 4: goto L7d;
                        case 5: goto L26;
                        case 6: goto L19;
                        case 7: goto L63;
                        case 8: goto L77;
                        default: goto L18;
                    }
                L18:
                    goto L15
                L19:
                    com.facebook.ads.redexgen.X.33 r3 = (com.facebook.ads.redexgen.X.AnonymousClass33) r3
                    com.facebook.ads.redexgen.X.1R r6 = (com.facebook.ads.redexgen.X.C1R) r6
                    com.facebook.ads.redexgen.X.36 r0 = com.facebook.ads.redexgen.X.AnonymousClass36.this
                    com.facebook.ads.redexgen.X.1G r0 = r0.A06
                    r0.A0F(r6)
                    r0 = 4
                    goto L15
                L26:
                    com.facebook.ads.redexgen.X.33 r3 = (com.facebook.ads.redexgen.X.AnonymousClass33) r3
                    com.facebook.ads.redexgen.X.1R r6 = (com.facebook.ads.redexgen.X.C1R) r6
                    android.view.View r7 = (android.view.View) r7
                    com.facebook.ads.redexgen.X.36 r0 = com.facebook.ads.redexgen.X.AnonymousClass36.this
                    android.os.Handler r4 = r0.A06()
                    java.lang.Runnable r0 = r2
                    r4.removeCallbacks(r0)
                    com.facebook.ads.redexgen.X.36 r0 = com.facebook.ads.redexgen.X.AnonymousClass36.this
                    com.facebook.ads.redexgen.X.1F r4 = r0.A02
                    com.facebook.ads.redexgen.X.36 r0 = com.facebook.ads.redexgen.X.AnonymousClass36.this
                    r0.A02 = r6
                    com.facebook.ads.redexgen.X.36 r0 = com.facebook.ads.redexgen.X.AnonymousClass36.this
                    r0.A00 = r7
                    com.facebook.ads.redexgen.X.36 r0 = com.facebook.ads.redexgen.X.AnonymousClass36.this
                    boolean r0 = r0.A0C
                    if (r0 != 0) goto L4b
                    r0 = 6
                    goto L15
                L4b:
                    r0 = 7
                    goto L15
                L4d:
                    com.facebook.ads.redexgen.X.33 r3 = (com.facebook.ads.redexgen.X.AnonymousClass33) r3
                    com.facebook.ads.redexgen.X.1R r6 = (com.facebook.ads.redexgen.X.C1R) r6
                    com.facebook.ads.redexgen.X.0d r1 = (com.facebook.ads.redexgen.X.InterfaceC00060d) r1
                    r1.A3T(r2)
                    com.facebook.ads.redexgen.X.36 r0 = com.facebook.ads.redexgen.X.AnonymousClass36.this
                    com.facebook.ads.redexgen.X.1F r0 = r0.A01
                    if (r6 == r0) goto L5e
                    r0 = 4
                    goto L15
                L5e:
                    r0 = 5
                    goto L15
                L60:
                    r2 = 1
                    r0 = 3
                    goto L15
                L63:
                    com.facebook.ads.redexgen.X.33 r3 = (com.facebook.ads.redexgen.X.AnonymousClass33) r3
                    android.view.View r7 = (android.view.View) r7
                    com.facebook.ads.redexgen.X.1F r4 = (com.facebook.ads.redexgen.X.C1F) r4
                    com.facebook.ads.redexgen.X.36 r0 = com.facebook.ads.redexgen.X.AnonymousClass36.this
                    com.facebook.ads.redexgen.X.1G r0 = r0.A06
                    r0.A0E(r7)
                    com.facebook.ads.redexgen.X.36 r0 = com.facebook.ads.redexgen.X.AnonymousClass36.this
                    r0.A0D(r4)
                    r0 = 4
                    goto L15
                L77:
                    r2 = 0
                    r0 = 3
                    goto L15
                L7a:
                    r0 = 8
                    goto L15
                L7d:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass33.A6E(com.facebook.ads.redexgen.X.1R, android.view.View):void");
            }

            /* JADX WARN: Code restructure failed: missing block: B:26:0x0054, code lost:            return;     */
            @Override // com.facebook.ads.redexgen.X.C1L
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void A6F(com.facebook.ads.redexgen.X.C1R r6, com.facebook.ads.AdError r7) {
                /*
                    r5 = this;
                    r4 = r5
                    r0 = 0
                    r3 = 0
                    com.facebook.ads.redexgen.X.36 r0 = com.facebook.ads.redexgen.X.AnonymousClass36.this
                    com.facebook.ads.redexgen.X.Ee r0 = com.facebook.ads.redexgen.X.AnonymousClass36.A02(r0)
                    com.facebook.ads.redexgen.X.0d r2 = r0.A08()
                    com.facebook.ads.redexgen.X.36 r0 = com.facebook.ads.redexgen.X.AnonymousClass36.this
                    com.facebook.ads.redexgen.X.1F r0 = r0.A01
                    if (r6 != r0) goto L52
                    r0 = 2
                L14:
                    switch(r0) {
                        case 2: goto L18;
                        case 3: goto L1b;
                        case 4: goto L54;
                        case 5: goto L34;
                        case 6: goto L4f;
                        default: goto L17;
                    }
                L17:
                    goto L14
                L18:
                    r3 = 1
                    r0 = 3
                    goto L14
                L1b:
                    com.facebook.ads.redexgen.X.33 r4 = (com.facebook.ads.redexgen.X.AnonymousClass33) r4
                    com.facebook.ads.redexgen.X.1R r6 = (com.facebook.ads.redexgen.X.C1R) r6
                    com.facebook.ads.AdError r7 = (com.facebook.ads.AdError) r7
                    com.facebook.ads.redexgen.X.0d r2 = (com.facebook.ads.redexgen.X.InterfaceC00060d) r2
                    int r0 = r7.getErrorCode()
                    r2.A3V(r3, r0)
                    com.facebook.ads.redexgen.X.36 r0 = com.facebook.ads.redexgen.X.AnonymousClass36.this
                    com.facebook.ads.redexgen.X.1F r0 = r0.A01
                    if (r6 == r0) goto L32
                    r0 = 4
                    goto L14
                L32:
                    r0 = 5
                    goto L14
                L34:
                    com.facebook.ads.redexgen.X.33 r4 = (com.facebook.ads.redexgen.X.AnonymousClass33) r4
                    com.facebook.ads.redexgen.X.1R r6 = (com.facebook.ads.redexgen.X.C1R) r6
                    com.facebook.ads.redexgen.X.36 r0 = com.facebook.ads.redexgen.X.AnonymousClass36.this
                    android.os.Handler r1 = r0.A06()
                    java.lang.Runnable r0 = r2
                    r1.removeCallbacks(r0)
                    com.facebook.ads.redexgen.X.36 r0 = com.facebook.ads.redexgen.X.AnonymousClass36.this
                    r0.A0D(r6)
                    com.facebook.ads.redexgen.X.36 r0 = com.facebook.ads.redexgen.X.AnonymousClass36.this
                    r0.A0C()
                    r0 = 4
                    goto L14
                L4f:
                    r3 = 0
                    r0 = 3
                    goto L14
                L52:
                    r0 = 6
                    goto L14
                L54:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass33.A6F(com.facebook.ads.redexgen.X.1R, com.facebook.ads.AdError):void");
            }

            @Override // com.facebook.ads.redexgen.X.C1L
            public final void A6G(C1R c1r2) {
                C0364Ee c0364Ee;
                I5.A05(A00(23, 25, 84), A00(0, 23, 47), A00(48, 8, 73));
                c0364Ee = AnonymousClass36.this.A00;
                c0364Ee.A08().A3W();
                AnonymousClass36.this.A06.A0D();
            }
        }, map);
    }
}
