package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.view.View;
import com.facebook.ads.AdListener;

/* renamed from: com.facebook.ads.redexgen.X.8I, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C8I extends C1G {
    public static byte[] A03;
    public View A00;
    public final C02047z A01;
    public final C0364Ee A02;

    static {
        A03();
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
            byte[] r1 = com.facebook.ads.redexgen.X.C8I.A03
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
            r0 = r0 ^ 105(0x69, float:1.47E-43)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C8I.A02(int, int, int):java.lang.String");
    }

    public static void A03() {
        A03 = new byte[]{118, 84, 91, 91, 90, 65, 21, 69, 71, 80, 70, 80, 91, 65, 21, 91, 64, 89, 89, 21, 84, 81, 99, 92, 80, 66};
    }

    public C8I(C02047z c02047z) {
        this.A02 = c02047z.A09();
        this.A01 = c02047z;
    }

    @Override // com.facebook.ads.redexgen.X.C1G
    public final void A0C() {
        this.A02.A08().A3O();
        C0465If.A00(new AbstractRunnableC00491u() { // from class: com.facebook.ads.redexgen.X.8G
            @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00491u
            public final void A01() {
                C02047z c02047z;
                C02047z c02047z2;
                C02047z c02047z3;
                c02047z = C8I.this.A01;
                if (c02047z.A06() == null) {
                    return;
                }
                c02047z2 = C8I.this.A01;
                AdListener A06 = c02047z2.A06();
                c02047z3 = C8I.this.A01;
                A06.onAdClicked(c02047z3.A07());
            }
        });
    }

    @Override // com.facebook.ads.redexgen.X.C1G
    public final void A0D() {
        this.A02.A08().A3R();
        C0465If.A00(new AbstractRunnableC00491u() { // from class: com.facebook.ads.redexgen.X.8H
            @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00491u
            public final void A01() {
                C02047z c02047z;
                C02047z c02047z2;
                C02047z c02047z3;
                c02047z = C8I.this.A01;
                if (c02047z.A06() == null) {
                    return;
                }
                c02047z2 = C8I.this.A01;
                AdListener A06 = c02047z2.A06();
                c02047z3 = C8I.this.A01;
                A06.onLoggingImpression(c02047z3.A07());
            }
        });
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0006. Please report as an issue. */
    @Override // com.facebook.ads.redexgen.X.C1G
    public final void A0E(View view) {
        final C8I c8i = this;
        final NQ nq = null;
        AnonymousClass36 anonymousClass36 = null;
        char c = view == null ? (char) 2 : (char) 3;
        while (true) {
            switch (c) {
                case 2:
                    throw new IllegalStateException(A02(0, 26, 92));
                case 3:
                    c8i = c8i;
                    view = view;
                    c8i.A02.A08().A3Q();
                    c8i.A00 = view;
                    c8i.A01.A07().removeAllViews();
                    c8i.A01.A07().addView(c8i.A00);
                    c = c8i.A00 instanceof NM ? (char) 4 : (char) 5;
                case 4:
                    c8i = c8i;
                    C0460Hz.A03(c8i.A01.A05(), c8i.A00, c8i.A01.A0A());
                    c = 5;
                case 5:
                    c8i = c8i;
                    anonymousClass36 = c8i.A01.A08();
                    c = anonymousClass36 != null ? (char) 6 : (char) 7;
                case 6:
                    anonymousClass36 = anonymousClass36;
                    anonymousClass36.A09();
                    c = 7;
                case 7:
                    c8i = c8i;
                    C0465If.A00(new AbstractRunnableC00491u() { // from class: com.facebook.ads.redexgen.X.8E
                        @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00491u
                        public final void A01() {
                            C02047z c02047z;
                            C02047z c02047z2;
                            C02047z c02047z3;
                            c02047z = C8I.this.A01;
                            if (c02047z.A06() == null) {
                                return;
                            }
                            c02047z2 = C8I.this.A01;
                            AdListener A06 = c02047z2.A06();
                            c02047z3 = C8I.this.A01;
                            A06.onAdLoaded(c02047z3.A07());
                        }
                    });
                    c8i.A01.A0B(c8i.A01.A07(), c8i.A00);
                    c = Build.VERSION.SDK_INT >= 18 ? '\b' : (char) 15;
                case '\b':
                    c8i = c8i;
                    c = C0413Gc.A0d(c8i.A01.A07().getContext()) ? '\t' : (char) 15;
                case '\t':
                    c8i = c8i;
                    nq = new NQ();
                    c8i.A01.A0C(nq);
                    nq.A0C(c8i.A01.getPlacementId());
                    nq.A0B(c8i.A01.A07().getContext().getPackageName());
                    c = c8i.A01.A08() != null ? '\n' : '\f';
                case '\n':
                    c8i = c8i;
                    c = c8i.A01.A08().A07() != null ? (char) 11 : '\f';
                case 11:
                    c8i = c8i;
                    nq = nq;
                    nq.A09(c8i.A01.A08().A07().A0C());
                    c = '\f';
                case '\f':
                    c8i = c8i;
                    c = c8i.A00 instanceof NM ? '\r' : (char) 14;
                case '\r':
                    c8i = c8i;
                    nq = nq;
                    nq.A0A(((NM) c8i.A00).getViewabilityChecker());
                    c = 14;
                case 14:
                    c8i = c8i;
                    nq = nq;
                    c8i.A00.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.facebook.ads.redexgen.X.8F
                        /* JADX WARN: Code restructure failed: missing block: B:23:0x0049, code lost:            return true;     */
                        @Override // android.view.View.OnLongClickListener
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final boolean onLongClick(android.view.View r7) {
                            /*
                                r6 = this;
                                r5 = r6
                                r1 = 0
                                r0 = 0
                                r0 = 0
                                r4 = 1
                                r3 = 0
                                com.facebook.ads.redexgen.X.8I r0 = com.facebook.ads.redexgen.X.C8I.this
                                android.view.View r0 = com.facebook.ads.redexgen.X.C8I.A00(r0)
                                if (r0 == 0) goto L47
                                r0 = 2
                            Lf:
                                switch(r0) {
                                    case 2: goto L13;
                                    case 3: goto L3d;
                                    case 4: goto L40;
                                    case 5: goto L49;
                                    default: goto L12;
                                }
                            L12:
                                goto Lf
                            L13:
                                com.facebook.ads.redexgen.X.8F r5 = (com.facebook.ads.redexgen.X.C8F) r5
                                r3 = 0
                                com.facebook.ads.redexgen.X.NQ r2 = r2
                                com.facebook.ads.redexgen.X.8I r0 = com.facebook.ads.redexgen.X.C8I.this
                                android.view.View r0 = com.facebook.ads.redexgen.X.C8I.A00(r0)
                                int r1 = r0.getWidth()
                                com.facebook.ads.redexgen.X.8I r0 = com.facebook.ads.redexgen.X.C8I.this
                                android.view.View r0 = com.facebook.ads.redexgen.X.C8I.A00(r0)
                                int r0 = r0.getHeight()
                                r2.setBounds(r3, r3, r1, r0)
                                com.facebook.ads.redexgen.X.NQ r1 = r2
                                com.facebook.ads.redexgen.X.NQ r0 = r2
                                boolean r0 = r0.A0E()
                                if (r0 != 0) goto L3b
                                r0 = 3
                                goto Lf
                            L3b:
                                r0 = 4
                                goto Lf
                            L3d:
                                r3 = r4
                                r0 = 4
                                goto Lf
                            L40:
                                com.facebook.ads.redexgen.X.NQ r1 = (com.facebook.ads.redexgen.X.NQ) r1
                                r1.A0D(r3)
                                r0 = 5
                                goto Lf
                            L47:
                                r0 = 5
                                goto Lf
                            L49:
                                return r4
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C8F.onLongClick(android.view.View):boolean");
                        }
                    });
                    c8i.A00.getOverlay().add(nq);
                    c = 15;
                case 15:
                    return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x003e, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.C1G
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0F(com.facebook.ads.redexgen.X.C1F r5) {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.Ee r0 = r3.A02
            com.facebook.ads.redexgen.X.0d r1 = r0.A08()
            com.facebook.ads.redexgen.X.7z r0 = r3.A01
            com.facebook.ads.redexgen.X.36 r0 = r0.A08()
            if (r0 == 0) goto L3c
            r0 = 2
        L12:
            switch(r0) {
                case 2: goto L16;
                case 3: goto L19;
                case 4: goto L2c;
                case 5: goto L3e;
                case 6: goto L39;
                default: goto L15;
            }
        L15:
            goto L12
        L16:
            r2 = 1
            r0 = 3
            goto L12
        L19:
            com.facebook.ads.redexgen.X.8I r3 = (com.facebook.ads.redexgen.X.C8I) r3
            com.facebook.ads.redexgen.X.0d r1 = (com.facebook.ads.redexgen.X.InterfaceC00060d) r1
            r1.A3P(r2)
            com.facebook.ads.redexgen.X.7z r0 = r3.A01
            com.facebook.ads.redexgen.X.36 r0 = r0.A08()
            if (r0 == 0) goto L2a
            r0 = 4
            goto L12
        L2a:
            r0 = 5
            goto L12
        L2c:
            com.facebook.ads.redexgen.X.8I r3 = (com.facebook.ads.redexgen.X.C8I) r3
            com.facebook.ads.redexgen.X.7z r0 = r3.A01
            com.facebook.ads.redexgen.X.36 r0 = r0.A08()
            r0.A0A()
            r0 = 5
            goto L12
        L39:
            r2 = 0
            r0 = 3
            goto L12
        L3c:
            r0 = 6
            goto L12
        L3e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C8I.A0F(com.facebook.ads.redexgen.X.1F):void");
    }

    @Override // com.facebook.ads.redexgen.X.C1G
    public final void A0G(final C0453Hr c0453Hr) {
        this.A02.A08().A2a(K4.A01(this.A01.A04()), c0453Hr.A04().getErrorCode(), c0453Hr.A05());
        C0465If.A00(new AbstractRunnableC00491u() { // from class: com.facebook.ads.redexgen.X.8D
            @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00491u
            public final void A01() {
                C02047z c02047z;
                C02047z c02047z2;
                C02047z c02047z3;
                c02047z = C8I.this.A01;
                if (c02047z.A06() == null) {
                    return;
                }
                c02047z2 = C8I.this.A01;
                AdListener A06 = c02047z2.A06();
                c02047z3 = C8I.this.A01;
                A06.onError(c02047z3.A07(), C0453Hr.A00(c0453Hr));
            }
        });
    }
}
