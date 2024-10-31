package com.facebook.ads.redexgen.X;

import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.3F, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C3F extends AnonymousClass35 {
    public C3F(C0362Ec c0362Ec, AnonymousClass31 anonymousClass31) {
        super(c0362Ec, anonymousClass31);
    }

    private AnonymousClass20 A02(final Runnable runnable) {
        return new AnonymousClass20() { // from class: com.facebook.ads.redexgen.X.3E
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
                    byte[] r1 = com.facebook.ads.redexgen.X.C3E.A02
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
                    int r0 = r0 + (-120)
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C3E.A00(int, int, int):java.lang.String");
            }

            public static void A01() {
                A02 = new byte[]{57, 56, 19, 56, 62, 47, 60, 61, 62, 51, 62, 51, 43, 54, 22, 57, 49, 49, 51, 56, 49, 19, 55, 58, 60, 47, 61, 61, 51, 57, 56, -14, 1, -6, 45, 82, 88, 73, 86, 87, 88, 77, 88, 77, 69, 80, 4, 77, 81, 84, 86, 73, 87, 87, 77, 83, 82, 4, 74, 77, 86, 73, 72, -81, -32, -80, -36, -78, -77, -77, -34, -26, -13, -23, -9, -12, -18, -23, -77, -18, -13, -7, -22, -13, -7, -77, -26, -24, -7, -18, -12, -13, -77, -37, -50, -54, -36, -47, -12, -15, 0, 4, -11, 2, -80, -7, 3, -80, -2, 5, -4, -4, -80, -1, -2, -80, -4, -1, -15, -12, -39, -2, 4, -11, 2, 3, 4, -7, 4, -7, -15, -4, -47, -12};
            }

            /* JADX WARN: Code restructure failed: missing block: B:33:0x004b, code lost:            return;     */
            @Override // com.facebook.ads.redexgen.X.AnonymousClass20
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void A6q(com.facebook.ads.redexgen.X.C00341f r7, java.lang.String r8, boolean r9) {
                /*
                    r6 = this;
                    r5 = r6
                    r4 = 0
                    com.facebook.ads.redexgen.X.3F r0 = com.facebook.ads.redexgen.X.C3F.this
                    com.facebook.ads.redexgen.X.1G r0 = r0.A06
                    r0.A0C()
                    boolean r0 = android.text.TextUtils.isEmpty(r8)
                    if (r0 != 0) goto L49
                    r0 = 2
                L10:
                    switch(r0) {
                        case 2: goto L43;
                        case 3: goto L3d;
                        case 4: goto L37;
                        case 5: goto L14;
                        case 6: goto L4b;
                        case 7: goto L46;
                        default: goto L13;
                    }
                L13:
                    goto L10
                L14:
                    com.facebook.ads.redexgen.X.3E r5 = (com.facebook.ads.redexgen.X.C3E) r5
                    java.lang.String r8 = (java.lang.String) r8
                    android.content.Intent r3 = new android.content.Intent
                    r2 = 71
                    r1 = 26
                    r0 = 13
                    java.lang.String r0 = A00(r2, r1, r0)
                    r3.<init>(r0)
                    android.net.Uri r0 = android.net.Uri.parse(r8)
                    r3.setData(r0)
                    com.facebook.ads.redexgen.X.3F r0 = com.facebook.ads.redexgen.X.C3F.this
                    com.facebook.ads.redexgen.X.Ec r0 = r0.A0B
                    r0.A09(r3)
                    r0 = 6
                    goto L10
                L37:
                    if (r4 == 0) goto L3b
                    r0 = 5
                    goto L10
                L3b:
                    r0 = 6
                    goto L10
                L3d:
                    if (r9 == 0) goto L41
                    r0 = 4
                    goto L10
                L41:
                    r0 = 6
                    goto L10
                L43:
                    r4 = 1
                    r0 = 3
                    goto L10
                L46:
                    r4 = 0
                    r0 = 3
                    goto L10
                L49:
                    r0 = 7
                    goto L10
                L4b:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C3E.A6q(com.facebook.ads.redexgen.X.1f, java.lang.String, boolean):void");
            }

            @Override // com.facebook.ads.redexgen.X.AnonymousClass20
            public final void A6r(C00341f c00341f) {
                C3F.this.A06.A02();
            }

            @Override // com.facebook.ads.redexgen.X.AnonymousClass20
            public final void A6s(C00341f c00341f) {
                C3F.this.A06.A04();
            }

            /* JADX WARN: Code restructure failed: missing block: B:23:0x0067, code lost:            return;     */
            @Override // com.facebook.ads.redexgen.X.AnonymousClass20
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void A6t(com.facebook.ads.redexgen.X.C00341f r9) {
                /*
                    r8 = this;
                    r4 = r8
                    com.facebook.ads.redexgen.X.3F r0 = com.facebook.ads.redexgen.X.C3F.this
                    com.facebook.ads.redexgen.X.1F r0 = r0.A01
                    if (r9 == r0) goto L65
                    r0 = 2
                L8:
                    switch(r0) {
                        case 2: goto L67;
                        case 3: goto Lc;
                        case 4: goto L14;
                        case 5: goto L44;
                        default: goto Lb;
                    }
                Lb:
                    goto L8
                Lc:
                    com.facebook.ads.redexgen.X.1f r9 = (com.facebook.ads.redexgen.X.C00341f) r9
                    if (r9 != 0) goto L12
                    r0 = 4
                    goto L8
                L12:
                    r0 = 5
                    goto L8
                L14:
                    com.facebook.ads.redexgen.X.3E r4 = (com.facebook.ads.redexgen.X.C3E) r4
                    com.facebook.ads.redexgen.X.1f r9 = (com.facebook.ads.redexgen.X.C00341f) r9
                    com.facebook.ads.redexgen.X.3F r0 = com.facebook.ads.redexgen.X.C3F.this
                    com.facebook.ads.redexgen.X.Ec r7 = r0.A0B
                    r2 = 31
                    r1 = 3
                    r0 = 25
                    java.lang.String r6 = A00(r2, r1, r0)
                    int r5 = com.facebook.ads.redexgen.X.C0512Kc.A0M
                    com.facebook.ads.redexgen.X.Ke r3 = new com.facebook.ads.redexgen.X.Ke
                    r2 = 97
                    r1 = 37
                    r0 = 24
                    java.lang.String r0 = A00(r2, r1, r0)
                    r3.<init>(r0)
                    com.facebook.ads.redexgen.X.C0511Kb.A06(r7, r6, r5, r3)
                    r0 = 2004(0x7d4, float:2.808E-42)
                    com.facebook.ads.AdError r0 = com.facebook.ads.AdError.internalError(r0)
                    r4.A6u(r9, r0)
                    r0 = 2
                    goto L8
                L44:
                    com.facebook.ads.redexgen.X.3E r4 = (com.facebook.ads.redexgen.X.C3E) r4
                    com.facebook.ads.redexgen.X.1f r9 = (com.facebook.ads.redexgen.X.C00341f) r9
                    com.facebook.ads.redexgen.X.3F r0 = com.facebook.ads.redexgen.X.C3F.this
                    android.os.Handler r1 = r0.A06()
                    java.lang.Runnable r0 = r2
                    r1.removeCallbacks(r0)
                    com.facebook.ads.redexgen.X.3F r0 = com.facebook.ads.redexgen.X.C3F.this
                    r0.A02 = r9
                    com.facebook.ads.redexgen.X.3F r0 = com.facebook.ads.redexgen.X.C3F.this
                    com.facebook.ads.redexgen.X.C3F.A03(r0)
                    com.facebook.ads.redexgen.X.3F r0 = com.facebook.ads.redexgen.X.C3F.this
                    com.facebook.ads.redexgen.X.1G r0 = r0.A06
                    r0.A0F(r9)
                    r0 = 2
                    goto L8
                L65:
                    r0 = 3
                    goto L8
                L67:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C3E.A6t(com.facebook.ads.redexgen.X.1f):void");
            }

            /* JADX WARN: Code restructure failed: missing block: B:23:0x0066, code lost:            return;     */
            @Override // com.facebook.ads.redexgen.X.AnonymousClass20
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void A6u(com.facebook.ads.redexgen.X.C00341f r6, com.facebook.ads.AdError r7) {
                /*
                    r5 = this;
                    r4 = r5
                    com.facebook.ads.redexgen.X.3F r0 = com.facebook.ads.redexgen.X.C3F.this
                    com.facebook.ads.redexgen.X.1F r0 = r0.A01
                    if (r6 == r0) goto L64
                    r0 = 2
                L8:
                    switch(r0) {
                        case 2: goto L66;
                        case 3: goto Lc;
                        case 4: goto L2e;
                        case 5: goto L37;
                        default: goto Lb;
                    }
                Lb:
                    goto L8
                Lc:
                    com.facebook.ads.redexgen.X.3E r4 = (com.facebook.ads.redexgen.X.C3E) r4
                    com.facebook.ads.redexgen.X.1f r6 = (com.facebook.ads.redexgen.X.C00341f) r6
                    com.facebook.ads.redexgen.X.3F r0 = com.facebook.ads.redexgen.X.C3F.this
                    android.os.Handler r1 = r0.A06()
                    java.lang.Runnable r0 = r2
                    r1.removeCallbacks(r0)
                    com.facebook.ads.redexgen.X.3F r0 = com.facebook.ads.redexgen.X.C3F.this
                    r0.A0D(r6)
                    com.facebook.ads.redexgen.X.3F r0 = com.facebook.ads.redexgen.X.C3F.this
                    com.facebook.ads.redexgen.X.Ec r0 = r0.A0B
                    boolean r0 = com.facebook.ads.redexgen.X.C0413Gc.A0X(r0)
                    if (r0 != 0) goto L2c
                    r0 = 4
                    goto L8
                L2c:
                    r0 = 5
                    goto L8
                L2e:
                    com.facebook.ads.redexgen.X.3E r4 = (com.facebook.ads.redexgen.X.C3E) r4
                    com.facebook.ads.redexgen.X.3F r0 = com.facebook.ads.redexgen.X.C3F.this
                    r0.A0C()
                    r0 = 5
                    goto L8
                L37:
                    com.facebook.ads.redexgen.X.3E r4 = (com.facebook.ads.redexgen.X.C3E) r4
                    com.facebook.ads.AdError r7 = (com.facebook.ads.AdError) r7
                    com.facebook.ads.redexgen.X.3F r0 = com.facebook.ads.redexgen.X.C3F.this
                    com.facebook.ads.redexgen.X.Ec r0 = r0.A0B
                    com.facebook.ads.redexgen.X.0c r2 = r0.A08()
                    int r1 = r7.getErrorCode()
                    java.lang.String r0 = r7.getErrorMessage()
                    r2.A3s(r1, r0)
                    com.facebook.ads.redexgen.X.3F r0 = com.facebook.ads.redexgen.X.C3F.this
                    com.facebook.ads.redexgen.X.1G r3 = r0.A06
                    com.facebook.ads.redexgen.X.Hr r2 = new com.facebook.ads.redexgen.X.Hr
                    int r1 = r7.getErrorCode()
                    java.lang.String r0 = r7.getErrorMessage()
                    r2.<init>(r1, r0)
                    r3.A0G(r2)
                    r0 = 2
                    goto L8
                L64:
                    r0 = 3
                    goto L8
                L66:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C3E.A6u(com.facebook.ads.redexgen.X.1f, com.facebook.ads.AdError):void");
            }

            @Override // com.facebook.ads.redexgen.X.AnonymousClass20
            public final void A6v(C00341f c00341f) {
                I5.A05(A00(0, 31, 82), A00(34, 29, 108), A00(63, 8, 2));
                C3F.this.A06.A0D();
            }

            @Override // com.facebook.ads.redexgen.X.AnonymousClass20
            public final void A6w() {
                C3F.this.A06.A07();
            }

            @Override // com.facebook.ads.redexgen.X.AnonymousClass20
            public final void A6x() {
                C3F.this.A06.A05();
            }

            @Override // com.facebook.ads.redexgen.X.AnonymousClass20
            public final void A6y() {
                C3F.this.A06.A06();
            }

            @Override // com.facebook.ads.redexgen.X.AnonymousClass20
            public final void onInterstitialActivityDestroyed() {
                C3F.this.A06.A00();
            }
        };
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass35
    public final void A0K() {
        ((C00341f) this.A02).A0A();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass35
    public final void A0L(C1F c1f, C0402Fq c0402Fq, C0400Fo c0400Fo, final Map<String, Object> map) {
        final C00341f c00341f = (C00341f) c1f;
        AbstractRunnableC00351g abstractRunnableC00351g = new AbstractRunnableC00351g() { // from class: com.facebook.ads.redexgen.X.3D
            /* JADX WARN: Code restructure failed: missing block: B:14:0x0059, code lost:            return;     */
            @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00351g
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void A05() {
                /*
                    r5 = this;
                    r4 = r5
                    com.facebook.ads.redexgen.X.3F r1 = com.facebook.ads.redexgen.X.C3F.this
                    java.util.Map r0 = r2
                    r1.A0H(r0)
                    com.facebook.ads.redexgen.X.3F r1 = com.facebook.ads.redexgen.X.C3F.this
                    com.facebook.ads.redexgen.X.1f r0 = r3
                    r1.A0D(r0)
                    com.facebook.ads.redexgen.X.3F r0 = com.facebook.ads.redexgen.X.C3F.this
                    com.facebook.ads.redexgen.X.Ec r0 = r0.A0B
                    boolean r0 = com.facebook.ads.redexgen.X.C0413Gc.A0X(r0)
                    if (r0 == 0) goto L57
                    r0 = 2
                L1a:
                    switch(r0) {
                        case 2: goto L1e;
                        case 3: goto L59;
                        case 4: goto L4e;
                        default: goto L1d;
                    }
                L1d:
                    goto L1a
                L1e:
                    com.facebook.ads.redexgen.X.3D r4 = (com.facebook.ads.redexgen.X.C3D) r4
                    com.facebook.ads.redexgen.X.3F r1 = com.facebook.ads.redexgen.X.C3F.this
                    r0 = 0
                    r1.A01 = r0
                    com.facebook.ads.redexgen.X.Hr r3 = new com.facebook.ads.redexgen.X.Hr
                    com.facebook.ads.internal.protocol.AdErrorType r1 = com.facebook.ads.internal.protocol.AdErrorType.INTERSTITIAL_AD_TIMEOUT
                    java.lang.String r0 = ""
                    r3.<init>(r1, r0)
                    com.facebook.ads.redexgen.X.3F r0 = com.facebook.ads.redexgen.X.C3F.this
                    com.facebook.ads.redexgen.X.Ec r0 = r0.A0B
                    com.facebook.ads.redexgen.X.0c r2 = r0.A08()
                    com.facebook.ads.internal.protocol.AdErrorType r0 = r3.A04()
                    int r1 = r0.getErrorCode()
                    java.lang.String r0 = r3.A05()
                    r2.A3s(r1, r0)
                    com.facebook.ads.redexgen.X.3F r0 = com.facebook.ads.redexgen.X.C3F.this
                    com.facebook.ads.redexgen.X.1G r0 = r0.A06
                    r0.A0G(r3)
                    r0 = 3
                    goto L1a
                L4e:
                    com.facebook.ads.redexgen.X.3D r4 = (com.facebook.ads.redexgen.X.C3D) r4
                    com.facebook.ads.redexgen.X.3F r0 = com.facebook.ads.redexgen.X.C3F.this
                    r0.A0C()
                    r0 = 3
                    goto L1a
                L57:
                    r0 = 4
                    goto L1a
                L59:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C3D.A05():void");
            }
        };
        A06().postDelayed(abstractRunnableC00351g, c0402Fq.A05().A05());
        c00341f.A09(this.A0B, A02(abstractRunnableC00351g), map, this.A07.A09, this.A07.A03, this.A07.A04, this.A07.A01);
    }
}
