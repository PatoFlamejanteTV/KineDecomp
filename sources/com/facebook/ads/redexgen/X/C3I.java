package com.facebook.ads.redexgen.X;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.3I, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C3I extends AnonymousClass35 {
    public static byte[] A00;

    static {
        A06();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A02(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C3I.A00
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
            int r0 = r0 + (-109)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C3I.A02(int, int, int):java.lang.String");
    }

    public static void A06() {
        A00 = new byte[]{24, 27, -41, 32, 42, -41, 37, 38, 43, -41, 41, 28, 24, 27, 48, -41, 38, 41, -41, 24, 35, 41, 28, 24, 27, 48, -41, 27, 32, 42, 39, 35, 24, 48, 28, 27, -3, -2, 5, -6, 18};
    }

    public C3I(C0362Ec c0362Ec, AnonymousClass31 anonymousClass31) {
        super(c0362Ec, anonymousClass31);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> A03(long j) {
        HashMap hashMap = new HashMap();
        hashMap.put(A02(36, 5, 44), String.valueOf(System.currentTimeMillis() - j));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0049, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A08(java.util.List<java.lang.String> r7, java.util.Map<java.lang.String, java.lang.String> r8) {
        /*
            r6 = this;
            r5 = r6
            r4 = 0
            if (r7 == 0) goto L47
            r0 = 2
        L5:
            switch(r0) {
                case 2: goto L9;
                case 3: goto L49;
                case 4: goto L15;
                case 5: goto L1d;
                case 6: goto L29;
                default: goto L8;
            }
        L8:
            goto L5
        L9:
            java.util.List r7 = (java.util.List) r7
            boolean r0 = r7.isEmpty()
            if (r0 == 0) goto L13
            r0 = 3
            goto L5
        L13:
            r0 = 4
            goto L5
        L15:
            java.util.List r7 = (java.util.List) r7
            java.util.Iterator r4 = r7.iterator()
            r0 = 5
            goto L5
        L1d:
            java.util.Iterator r4 = (java.util.Iterator) r4
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L27
            r0 = 6
            goto L5
        L27:
            r0 = 3
            goto L5
        L29:
            com.facebook.ads.redexgen.X.3I r5 = (com.facebook.ads.redexgen.X.C3I) r5
            java.util.Map r8 = (java.util.Map) r8
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r3 = r4.next()
            java.lang.String r3 = (java.lang.String) r3
            com.facebook.ads.redexgen.X.79 r2 = new com.facebook.ads.redexgen.X.79
            com.facebook.ads.redexgen.X.Ec r0 = r5.A0B
            r2.<init>(r0, r8)
            r0 = 1
            java.lang.String[] r1 = new java.lang.String[r0]
            r0 = 0
            r1[r0] = r3
            r2.execute(r1)
            r0 = 5
            goto L5
        L47:
            r0 = 3
            goto L5
        L49:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C3I.A08(java.util.List, java.util.Map):void");
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass35
    public final void A0K() {
        C00371i c00371i = (C00371i) this.A02;
        if (!c00371i.A0e()) {
            throw new IllegalStateException(A02(0, 36, 74));
        }
        this.A06.A0A(c00371i);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass35
    public final void A0L(C1F c1f, C0402Fq c0402Fq, final C0400Fo c0400Fo, final Map<String, Object> map) {
        final C00371i c00371i = (C00371i) c1f;
        final long currentTimeMillis = System.currentTimeMillis();
        final AbstractRunnableC00351g abstractRunnableC00351g = new AbstractRunnableC00351g() { // from class: com.facebook.ads.redexgen.X.3G
            public static byte[] A05;

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
                    byte[] r1 = com.facebook.ads.redexgen.X.C3G.A05
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
                    int r0 = r0 + (-73)
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C3G.A01(int, int, int):java.lang.String");
            }

            public static void A04() {
                A05 = new byte[]{23, 36, 36, 33, 36, -14, -10, 30, 36, 24, 35, 24, 28, 20, 30, 36, 35};
            }

            @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00351g
            public final void A05() {
                Map A03;
                C3I.this.A0H(map);
                C3I.this.A0D(c00371i);
                A03 = C3I.this.A03(currentTimeMillis);
                A03.put(A01(0, 5, 105), A01(5, 2, 124));
                A03.put(A01(7, 3, 104), A01(10, 7, 102));
                C3I.this.A08(c0400Fo.A04(EnumC0404Fs.A04), A03);
                C3I.this.A0C();
            }
        };
        A06().postDelayed(abstractRunnableC00351g, c0402Fq.A05().A05());
        c00371i.A0W(this.A0B, new AnonymousClass25() { // from class: com.facebook.ads.redexgen.X.3H
            public static byte[] A07;
            public boolean A02 = false;
            public boolean A01 = false;
            public boolean A00 = false;

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
                    byte[] r1 = com.facebook.ads.redexgen.X.C3H.A07
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
                    r0 = r0 ^ 17
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C3H.A00(int, int, int):java.lang.String");
            }

            public static void A01() {
                A07 = new byte[]{7, 16, 16, 13, 16, 41, 55, 35};
            }

            /* JADX WARN: Code restructure failed: missing block: B:23:0x0038, code lost:            return;     */
            @Override // com.facebook.ads.redexgen.X.AnonymousClass25
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void A76(com.facebook.ads.redexgen.X.C00371i r5) {
                /*
                    r4 = this;
                    r3 = r4
                    boolean r0 = r3.A00
                    if (r0 != 0) goto L36
                    r0 = 2
                L6:
                    switch(r0) {
                        case 2: goto La;
                        case 3: goto L1f;
                        case 4: goto L2b;
                        case 5: goto L38;
                        default: goto L9;
                    }
                L9:
                    goto L6
                La:
                    com.facebook.ads.redexgen.X.3H r3 = (com.facebook.ads.redexgen.X.C3H) r3
                    r0 = 1
                    r3.A00 = r0
                    com.facebook.ads.redexgen.X.3I r2 = com.facebook.ads.redexgen.X.C3I.this
                    com.facebook.ads.redexgen.X.Fo r1 = r6
                    com.facebook.ads.redexgen.X.Fs r0 = com.facebook.ads.redexgen.X.EnumC0404Fs.A02
                    java.util.List r1 = r1.A04(r0)
                    r0 = 0
                    com.facebook.ads.redexgen.X.C3I.A07(r2, r1, r0)
                    r0 = 3
                    goto L6
                L1f:
                    com.facebook.ads.redexgen.X.3H r3 = (com.facebook.ads.redexgen.X.C3H) r3
                    com.facebook.ads.redexgen.X.3I r0 = com.facebook.ads.redexgen.X.C3I.this
                    com.facebook.ads.redexgen.X.1G r0 = r0.A06
                    if (r0 == 0) goto L29
                    r0 = 4
                    goto L6
                L29:
                    r0 = 5
                    goto L6
                L2b:
                    com.facebook.ads.redexgen.X.3H r3 = (com.facebook.ads.redexgen.X.C3H) r3
                    com.facebook.ads.redexgen.X.3I r0 = com.facebook.ads.redexgen.X.C3I.this
                    com.facebook.ads.redexgen.X.1G r0 = r0.A06
                    r0.A0C()
                    r0 = 5
                    goto L6
                L36:
                    r0 = 3
                    goto L6
                L38:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C3H.A76(com.facebook.ads.redexgen.X.1i):void");
            }

            /* JADX WARN: Code restructure failed: missing block: B:20:0x004c, code lost:            return;     */
            @Override // com.facebook.ads.redexgen.X.AnonymousClass25
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void A77(com.facebook.ads.redexgen.X.C00371i r6) {
                /*
                    r5 = this;
                    r4 = r5
                    com.facebook.ads.redexgen.X.3I r0 = com.facebook.ads.redexgen.X.C3I.this
                    com.facebook.ads.redexgen.X.1F r0 = r0.A01
                    if (r6 == r0) goto L4a
                    r0 = 2
                L8:
                    switch(r0) {
                        case 2: goto L4c;
                        case 3: goto Lc;
                        case 4: goto L2e;
                        default: goto Lb;
                    }
                Lb:
                    goto L8
                Lc:
                    com.facebook.ads.redexgen.X.3H r4 = (com.facebook.ads.redexgen.X.C3H) r4
                    com.facebook.ads.redexgen.X.1i r6 = (com.facebook.ads.redexgen.X.C00371i) r6
                    com.facebook.ads.redexgen.X.3I r0 = com.facebook.ads.redexgen.X.C3I.this
                    android.os.Handler r1 = r0.A06()
                    java.lang.Runnable r0 = r3
                    r1.removeCallbacks(r0)
                    com.facebook.ads.redexgen.X.3I r0 = com.facebook.ads.redexgen.X.C3I.this
                    r0.A02 = r6
                    com.facebook.ads.redexgen.X.3I r0 = com.facebook.ads.redexgen.X.C3I.this
                    com.facebook.ads.redexgen.X.1G r0 = r0.A06
                    r0.A0F(r6)
                    boolean r0 = r4.A02
                    if (r0 != 0) goto L2c
                    r0 = 4
                    goto L8
                L2c:
                    r0 = 2
                    goto L8
                L2e:
                    com.facebook.ads.redexgen.X.3H r4 = (com.facebook.ads.redexgen.X.C3H) r4
                    r0 = 1
                    r4.A02 = r0
                    com.facebook.ads.redexgen.X.3I r2 = com.facebook.ads.redexgen.X.C3I.this
                    long r0 = r4
                    java.util.Map r3 = com.facebook.ads.redexgen.X.C3I.A05(r2, r0)
                    com.facebook.ads.redexgen.X.3I r2 = com.facebook.ads.redexgen.X.C3I.this
                    com.facebook.ads.redexgen.X.Fo r1 = r6
                    com.facebook.ads.redexgen.X.Fs r0 = com.facebook.ads.redexgen.X.EnumC0404Fs.A04
                    java.util.List r0 = r1.A04(r0)
                    com.facebook.ads.redexgen.X.C3I.A07(r2, r0, r3)
                    r0 = 2
                    goto L8
                L4a:
                    r0 = 3
                    goto L8
                L4c:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C3H.A77(com.facebook.ads.redexgen.X.1i):void");
            }

            @Override // com.facebook.ads.redexgen.X.AnonymousClass25
            public final void A78(C00371i c00371i2) {
                if (!this.A01) {
                    this.A01 = true;
                    C3I.this.A08(c0400Fo.A04(EnumC0404Fs.A03), null);
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:23:0x007b, code lost:            return;     */
            @Override // com.facebook.ads.redexgen.X.AnonymousClass25
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void A7A(com.facebook.ads.redexgen.X.C00371i r6, com.facebook.ads.redexgen.X.C0453Hr r7) {
                /*
                    r5 = this;
                    r3 = r5
                    com.facebook.ads.redexgen.X.3I r0 = com.facebook.ads.redexgen.X.C3I.this
                    com.facebook.ads.redexgen.X.1F r0 = r0.A01
                    if (r6 == r0) goto L79
                    r0 = 2
                L8:
                    switch(r0) {
                        case 2: goto L7b;
                        case 3: goto Lc;
                        case 4: goto L28;
                        case 5: goto L70;
                        default: goto Lb;
                    }
                Lb:
                    goto L8
                Lc:
                    com.facebook.ads.redexgen.X.3H r3 = (com.facebook.ads.redexgen.X.C3H) r3
                    com.facebook.ads.redexgen.X.1i r6 = (com.facebook.ads.redexgen.X.C00371i) r6
                    com.facebook.ads.redexgen.X.3I r0 = com.facebook.ads.redexgen.X.C3I.this
                    android.os.Handler r1 = r0.A06()
                    java.lang.Runnable r0 = r3
                    r1.removeCallbacks(r0)
                    com.facebook.ads.redexgen.X.3I r0 = com.facebook.ads.redexgen.X.C3I.this
                    r0.A0D(r6)
                    boolean r0 = r3.A02
                    if (r0 != 0) goto L26
                    r0 = 4
                    goto L8
                L26:
                    r0 = 5
                    goto L8
                L28:
                    com.facebook.ads.redexgen.X.3H r3 = (com.facebook.ads.redexgen.X.C3H) r3
                    com.facebook.ads.redexgen.X.Hr r7 = (com.facebook.ads.redexgen.X.C0453Hr) r7
                    r0 = 1
                    r3.A02 = r0
                    com.facebook.ads.redexgen.X.3I r2 = com.facebook.ads.redexgen.X.C3I.this
                    long r0 = r4
                    java.util.Map r4 = com.facebook.ads.redexgen.X.C3I.A05(r2, r0)
                    r2 = 0
                    r1 = 5
                    r0 = 115(0x73, float:1.61E-43)
                    java.lang.String r1 = A00(r2, r1, r0)
                    com.facebook.ads.internal.protocol.AdErrorType r0 = r7.A04()
                    int r0 = r0.getErrorCode()
                    java.lang.String r0 = java.lang.String.valueOf(r0)
                    r4.put(r1, r0)
                    r2 = 5
                    r1 = 3
                    r0 = 85
                    java.lang.String r1 = A00(r2, r1, r0)
                    java.lang.String r0 = r7.A05()
                    java.lang.String r0 = java.lang.String.valueOf(r0)
                    r4.put(r1, r0)
                    com.facebook.ads.redexgen.X.3I r2 = com.facebook.ads.redexgen.X.C3I.this
                    com.facebook.ads.redexgen.X.Fo r1 = r6
                    com.facebook.ads.redexgen.X.Fs r0 = com.facebook.ads.redexgen.X.EnumC0404Fs.A04
                    java.util.List r0 = r1.A04(r0)
                    com.facebook.ads.redexgen.X.C3I.A07(r2, r0, r4)
                    r0 = 5
                    goto L8
                L70:
                    com.facebook.ads.redexgen.X.3H r3 = (com.facebook.ads.redexgen.X.C3H) r3
                    com.facebook.ads.redexgen.X.3I r0 = com.facebook.ads.redexgen.X.C3I.this
                    r0.A0C()
                    r0 = 2
                    goto L8
                L79:
                    r0 = 3
                    goto L8
                L7b:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C3H.A7A(com.facebook.ads.redexgen.X.1i, com.facebook.ads.redexgen.X.Hr):void");
            }
        }, this.A08, map, HX.A0I());
    }
}
