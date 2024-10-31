package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.FrameLayout;

/* loaded from: assets/audience_network.dex */
public final class P6 extends AbstractC0625On {
    public static byte[] A0K;

    @Nullable
    public AbstractC0604Nr A00;

    @Nullable
    public QH A01;
    public boolean A02;
    public boolean A03;
    public boolean A04;
    public boolean A05;
    public boolean A06;
    public boolean A07;
    public final AnonymousClass86 A08;
    public final C0647Pj A09;
    public final C0537Lb A0A;
    public final QA A0B;
    public final AbstractC02238s A0C;
    public final AbstractC02278w A0D;
    public final AbstractC02198o A0E;
    public final AbstractC02178m A0F;
    public final AbstractC02158k A0G;
    public final LH A0H;
    public final M9 A0I;
    public final I6 A0J;

    static {
        A08();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A03(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.P6.A0K
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
            int r0 = r0 + (-83)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.P6.A03(int, int, int):java.lang.String");
    }

    public static void A08() {
        A0K = new byte[]{41, 28, 23, 24, 34, -37, -13, -27, -29, -13, -35};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public P6(C0362Ec c0362Ec, MQ mq, InterfaceC0422Gl interfaceC0422Gl, C2I c2i, EV ev, AnonymousClass81 anonymousClass81) {
        super(c0362Ec, mq, interfaceC0422Gl, c2i, ev, anonymousClass81);
        boolean z = false;
        this.A08 = new C0635Ox(this);
        this.A0G = new C0636Oy(this);
        this.A0F = new C0637Oz(this);
        this.A0E = new P0(this);
        this.A0H = new P1(this);
        this.A0C = new P2(this);
        this.A0D = new P3(this);
        this.A06 = false;
        this.A07 = false;
        this.A05 = false;
        this.A03 = false;
        this.A0A = new C0537Lb(super.A03);
        this.A0A.setFunnelLoggingHandler(super.A05);
        this.A0A.getEventBus().A03(this.A0G, this.A0F, this.A0E, this.A0H, this.A0C, this.A0D);
        this.A0B = new QA(super.A03, super.A04, this.A0A, super.A01.A0P());
        this.A09 = new C0647Pj(super.A03, super.A09, super.A01.A0U(), anonymousClass81);
        this.A0I = new M9(super.A03, super.A05);
        this.A0J = new I6(super.A03);
        A07();
        this.A0A.setVideoURI(super.A02.A0L(super.A01.A0L().A0D().A07()));
        A05();
        this.A04 = super.A01.A0L().A0D().A03() <= 0;
        if (super.A01.A0L().A0K() && super.A01.A0L().A0D().A02() > 0) {
            z = true;
        }
        this.A02 = z;
        KE.A0P(this, super.A01.A0K().A01().A07(true));
    }

    private AbstractC0604Nr A00(int i) {
        return C0607Nu.A00(new C0609Nw(super.A03, super.A04, super.A07, super.A01, this.A0A, super.A0A, super.A06).A0D(super.A08.getToolbarHeight()).A0F(super.A08).A0C(i).A0E(this.A0I).A0G(this.A0J).A0H(), null, true);
    }

    private void A04() {
        this.A0A.postDelayed(new P4(this), C0413Gc.A0F(super.A03));
    }

    private void A05() {
        this.A0A.postDelayed(new P5(this), C0413Gc.A0G(super.A03));
    }

    private void A06() {
        this.A04 = true;
        if (this.A00 != null) {
            this.A00.A0X();
        }
    }

    private void A07() {
        this.A0A.A0S(this.A0J);
        this.A0A.A0S(this.A0I);
        if (!TextUtils.isEmpty(super.A01.A0L().A0D().A06())) {
            M6 m6 = new M6(super.A03);
            this.A0A.A0S(m6);
            m6.setImage(super.A01.A0L().A0D().A06());
        }
        ID id = new ID(super.A03, true, super.A05);
        this.A0A.A0S(id);
        this.A0A.A0S(new C0563Mb(id, NA.A02, true));
        this.A0A.A0S(new C0464Ie(super.A03));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0052, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A0D(com.facebook.ads.redexgen.X.QM r6, boolean r7) {
        /*
            r5 = this;
            r4 = r5
            boolean r0 = r4.A05
            if (r0 == 0) goto L50
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto L52;
                case 3: goto L15;
                case 4: goto L2c;
                case 5: goto L22;
                case 6: goto La;
                case 7: goto L33;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.P6 r4 = (com.facebook.ads.redexgen.X.P6) r4
            com.facebook.ads.redexgen.X.QM r6 = (com.facebook.ads.redexgen.X.QM) r6
            com.facebook.ads.redexgen.X.Nr r0 = r4.A00
            r0.A0M(r6)
            r0 = 7
            goto L6
        L15:
            com.facebook.ads.redexgen.X.P6 r4 = (com.facebook.ads.redexgen.X.P6) r4
            r0 = 1
            r4.A05 = r0
            boolean r0 = r4.A04
            if (r0 != 0) goto L20
            r0 = 4
            goto L6
        L20:
            r0 = 5
            goto L6
        L22:
            com.facebook.ads.redexgen.X.P6 r4 = (com.facebook.ads.redexgen.X.P6) r4
            com.facebook.ads.redexgen.X.Nr r0 = r4.A00
            if (r0 == 0) goto L2a
            r0 = 6
            goto L6
        L2a:
            r0 = 7
            goto L6
        L2c:
            com.facebook.ads.redexgen.X.P6 r4 = (com.facebook.ads.redexgen.X.P6) r4
            r4.A06()
            r0 = 5
            goto L6
        L33:
            com.facebook.ads.redexgen.X.P6 r4 = (com.facebook.ads.redexgen.X.P6) r4
            com.facebook.ads.internal.view.FullScreenAdToolbar r1 = r4.A08
            int r0 = r4.getCloseButtonStyle()
            r1.setToolbarActionMode(r0)
            com.facebook.ads.internal.view.FullScreenAdToolbar r3 = r4.A08
            r2 = 0
            r1 = 0
            r0 = 46
            java.lang.String r0 = A03(r2, r1, r0)
            r3.setToolbarActionMessage(r0)
            r4.A0H(r7)
            r0 = 2
            goto L6
        L50:
            r0 = 3
            goto L6
        L52:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.P6.A0D(com.facebook.ads.redexgen.X.QM, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0032, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A0E(com.facebook.ads.redexgen.X.QT r6) {
        /*
            r5 = this;
            r4 = r5
            com.facebook.ads.redexgen.X.Lb r0 = r4.A0A
            com.facebook.ads.redexgen.X.FR r1 = r0.getState()
            com.facebook.ads.redexgen.X.FR r0 = com.facebook.ads.redexgen.X.FR.A02
            if (r1 == r0) goto L30
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L32;
                case 3: goto L10;
                case 4: goto L1e;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            com.facebook.ads.redexgen.X.P6 r4 = (com.facebook.ads.redexgen.X.P6) r4
            com.facebook.ads.redexgen.X.Ec r0 = r4.A03
            boolean r0 = com.facebook.ads.redexgen.X.C0413Gc.A0k(r0)
            if (r0 == 0) goto L1c
            r0 = 4
            goto Lc
        L1c:
            r0 = 2
            goto Lc
        L1e:
            com.facebook.ads.redexgen.X.P6 r4 = (com.facebook.ads.redexgen.X.P6) r4
            com.facebook.ads.redexgen.X.QT r6 = (com.facebook.ads.redexgen.X.QT) r6
            com.facebook.ads.redexgen.X.Lb r3 = r4.A0A
            com.facebook.ads.redexgen.X.Ow r2 = new com.facebook.ads.redexgen.X.Ow
            r2.<init>(r4, r6)
            r0 = 5000(0x1388, double:2.4703E-320)
            r3.postDelayed(r2, r0)
            r0 = 2
            goto Lc
        L30:
            r0 = 3
            goto Lc
        L32:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.P6.A0E(com.facebook.ads.redexgen.X.QT):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b1, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A0F(com.facebook.ads.redexgen.X.QT r8) {
        /*
            r7 = this;
            r6 = r7
            r4 = 0
            r0 = 0
            int r5 = r8.A00()
            com.facebook.ads.redexgen.X.2I r0 = r6.A01
            com.facebook.ads.redexgen.X.2L r0 = r0.A0L()
            com.facebook.ads.redexgen.X.2O r0 = r0.A0D()
            int r0 = r0.A03()
            float r1 = (float) r0
            r0 = 1148846080(0x447a0000, float:1000.0)
            float r1 = r1 * r0
            com.facebook.ads.redexgen.X.Lb r0 = r6.A0A
            int r0 = r0.getDuration()
            float r0 = (float) r0
            float r0 = java.lang.Math.min(r1, r0)
            float r2 = (float) r5
            float r2 = r2 / r0
            com.facebook.ads.internal.view.FullScreenAdToolbar r1 = r6.A08
            r0 = 1120403456(0x42c80000, float:100.0)
            float r0 = r0 * r2
            r1.setProgress(r0)
            r0 = 1065353216(0x3f800000, float:1.0)
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 < 0) goto Laf
            r0 = 2
        L35:
            switch(r0) {
                case 2: goto La5;
                case 3: goto L95;
                case 4: goto L5c;
                case 5: goto L66;
                case 6: goto L39;
                case 7: goto Lb1;
                case 8: goto L80;
                default: goto L38;
            }
        L38:
            goto L35
        L39:
            com.facebook.ads.redexgen.X.P6 r6 = (com.facebook.ads.redexgen.X.P6) r6
            com.facebook.ads.redexgen.X.2I r0 = r6.A01
            com.facebook.ads.redexgen.X.2k r0 = r0.A0O()
            java.lang.String r3 = r0.A00()
            r2 = 5
            r1 = 6
            r0 = 45
            java.lang.String r1 = A03(r2, r1, r0)
            java.lang.String r0 = java.lang.String.valueOf(r4)
            java.lang.String r1 = r3.replace(r1, r0)
            com.facebook.ads.internal.view.FullScreenAdToolbar r0 = r6.A08
            r0.setToolbarActionMessage(r1)
            r0 = 7
            goto L35
        L5c:
            com.facebook.ads.redexgen.X.P6 r6 = (com.facebook.ads.redexgen.X.P6) r6
            boolean r0 = r6.A02
            if (r0 == 0) goto L64
            r0 = 5
            goto L35
        L64:
            r0 = 7
            goto L35
        L66:
            com.facebook.ads.redexgen.X.P6 r6 = (com.facebook.ads.redexgen.X.P6) r6
            com.facebook.ads.redexgen.X.2I r0 = r6.A01
            com.facebook.ads.redexgen.X.2L r0 = r0.A0L()
            com.facebook.ads.redexgen.X.2O r0 = r0.A0D()
            int r4 = r0.A02()
            int r0 = r5 / 1000
            int r4 = r4 - r0
            if (r4 <= 0) goto L7d
            r0 = 6
            goto L35
        L7d:
            r0 = 8
            goto L35
        L80:
            com.facebook.ads.redexgen.X.P6 r6 = (com.facebook.ads.redexgen.X.P6) r6
            com.facebook.ads.internal.view.FullScreenAdToolbar r3 = r6.A08
            r2 = 0
            r1 = 0
            r0 = 46
            java.lang.String r0 = A03(r2, r1, r0)
            r3.setToolbarActionMessage(r0)
            r0 = 0
            r6.A0H(r0)
            r0 = 7
            goto L35
        L95:
            com.facebook.ads.redexgen.X.P6 r6 = (com.facebook.ads.redexgen.X.P6) r6
            r6.A06()
            com.facebook.ads.internal.view.FullScreenAdToolbar r1 = r6.A08
            int r0 = r6.getCloseButtonStyle()
            r1.setToolbarActionMode(r0)
            r0 = 4
            goto L35
        La5:
            com.facebook.ads.redexgen.X.P6 r6 = (com.facebook.ads.redexgen.X.P6) r6
            boolean r0 = r6.A04
            if (r0 != 0) goto Lad
            r0 = 3
            goto L35
        Lad:
            r0 = 4
            goto L35
        Laf:
            r0 = 4
            goto L35
        Lb1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.P6.A0F(com.facebook.ads.redexgen.X.QT):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006b, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A0G(java.lang.String r8) {
        /*
            r7 = this;
            r4 = r7
            r0 = 0
            r0 = 0
            r3 = 0
            r2 = 0
            com.facebook.ads.redexgen.X.Lb r0 = r4.A0A
            if (r0 == 0) goto L69
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L1e;
                case 4: goto L42;
                case 5: goto L6b;
                case 6: goto L4f;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.P6 r4 = (com.facebook.ads.redexgen.X.P6) r4
            com.facebook.ads.redexgen.X.Lb r0 = r4.A0A
            int r3 = r0.getCurrentPositionInMillis()
            com.facebook.ads.redexgen.X.Lb r0 = r4.A0A
            int r2 = r0.getDuration()
            r0 = 3
            goto La
        L1e:
            com.facebook.ads.redexgen.X.P6 r4 = (com.facebook.ads.redexgen.X.P6) r4
            java.lang.String r8 = (java.lang.String) r8
            com.facebook.ads.redexgen.X.Ec r6 = r4.A03
            r5 = 0
            r1 = 5
            r0 = 96
            java.lang.String r5 = A03(r5, r1, r0)
            int r1 = com.facebook.ads.redexgen.X.C0512Kc.A1l
            com.facebook.ads.redexgen.X.Ke r0 = new com.facebook.ads.redexgen.X.Ke
            r0.<init>(r8)
            com.facebook.ads.redexgen.X.C0511Kb.A06(r6, r5, r1, r0)
            com.facebook.ads.redexgen.X.Ec r0 = r4.A03
            boolean r0 = com.facebook.ads.redexgen.X.C0413Gc.A0l(r0)
            if (r0 == 0) goto L40
            r0 = 4
            goto La
        L40:
            r0 = 6
            goto La
        L42:
            com.facebook.ads.redexgen.X.P6 r4 = (com.facebook.ads.redexgen.X.P6) r4
            com.facebook.ads.redexgen.X.QM r1 = new com.facebook.ads.redexgen.X.QM
            r1.<init>(r3, r2)
            r0 = 0
            r4.A0D(r1, r0)
            r0 = 5
            goto La
        L4f:
            com.facebook.ads.redexgen.X.P6 r4 = (com.facebook.ads.redexgen.X.P6) r4
            com.facebook.ads.redexgen.X.81 r1 = r4.A07
            com.facebook.ads.redexgen.X.MQ r0 = r4.A09
            java.lang.String r0 = r0.A4e()
            r1.A3b(r0)
            com.facebook.ads.redexgen.X.81 r1 = r4.A07
            com.facebook.ads.redexgen.X.MQ r0 = r4.A09
            java.lang.String r0 = r0.A4a()
            r1.A3b(r0)
            r0 = 5
            goto La
        L69:
            r0 = 3
            goto La
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.P6.A0G(java.lang.String):void");
    }

    private synchronized void A0H(boolean z) {
        if (this.A02 && !z) {
            super.A07.A3b(super.A09.A4D());
            this.A09.A05();
            this.A02 = false;
            if (this.A00 != null) {
                this.A00.A0V();
            }
        }
        this.A02 = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x0078, code lost:            r4.A04();     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x007d, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.AbstractC0625On
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0N() {
        /*
            r5 = this;
            r4 = r5
            r3 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.Nr r0 = r4.A00
            com.facebook.ads.redexgen.X.KE.A0O(r0)
            com.facebook.ads.internal.view.FullScreenAdToolbar r0 = r4.A08
            com.facebook.ads.redexgen.X.KE.A0O(r0)
            com.facebook.ads.redexgen.X.Lb r2 = r4.A0A
            com.facebook.ads.redexgen.X.2I r0 = r4.A01
            com.facebook.ads.redexgen.X.2L r0 = r0.A0L()
            com.facebook.ads.redexgen.X.2O r0 = r0.A0D()
            boolean r0 = r0.A08()
            if (r0 == 0) goto L75
            r0 = 2
        L20:
            switch(r0) {
                case 2: goto L58;
                case 3: goto L42;
                case 4: goto L38;
                case 5: goto L2f;
                case 6: goto L24;
                case 7: goto L5b;
                case 8: goto L67;
                case 9: goto L78;
                case 10: goto L71;
                default: goto L23;
            }
        L23:
            goto L20
        L24:
            com.facebook.ads.redexgen.X.P6 r4 = (com.facebook.ads.redexgen.X.P6) r4
            com.facebook.ads.redexgen.X.Nr r0 = r4.A00
            if (r0 == 0) goto L2c
            r0 = 7
            goto L20
        L2c:
            r0 = 9
            goto L20
        L2f:
            com.facebook.ads.redexgen.X.P6 r4 = (com.facebook.ads.redexgen.X.P6) r4
            com.facebook.ads.redexgen.X.Nr r0 = r4.A00
            r0.A0W()
            r0 = 6
            goto L20
        L38:
            com.facebook.ads.redexgen.X.P6 r4 = (com.facebook.ads.redexgen.X.P6) r4
            boolean r0 = r4.A02
            if (r0 == 0) goto L40
            r0 = 5
            goto L20
        L40:
            r0 = 6
            goto L20
        L42:
            com.facebook.ads.redexgen.X.P6 r4 = (com.facebook.ads.redexgen.X.P6) r4
            com.facebook.ads.redexgen.X.Lb r2 = (com.facebook.ads.redexgen.X.C0537Lb) r2
            r2.setVolume(r3)
            com.facebook.ads.redexgen.X.Lb r1 = r4.A0A
            com.facebook.ads.redexgen.X.QH r0 = com.facebook.ads.redexgen.X.QH.A03
            r1.A0Q(r0)
            com.facebook.ads.redexgen.X.Nr r0 = r4.A00
            if (r0 == 0) goto L56
            r0 = 4
            goto L20
        L56:
            r0 = 6
            goto L20
        L58:
            r3 = 0
            r0 = 3
            goto L20
        L5b:
            com.facebook.ads.redexgen.X.P6 r4 = (com.facebook.ads.redexgen.X.P6) r4
            boolean r0 = r4.A04
            if (r0 != 0) goto L64
            r0 = 8
            goto L20
        L64:
            r0 = 9
            goto L20
        L67:
            com.facebook.ads.redexgen.X.P6 r4 = (com.facebook.ads.redexgen.X.P6) r4
            com.facebook.ads.redexgen.X.Nr r0 = r4.A00
            r0.A0Y()
            r0 = 9
            goto L20
        L71:
            r3 = 1065353216(0x3f800000, float:1.0)
            r0 = 3
            goto L20
        L75:
            r0 = 10
            goto L20
        L78:
            com.facebook.ads.redexgen.X.P6 r4 = (com.facebook.ads.redexgen.X.P6) r4
            r4.A04()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.P6.A0N():void");
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0625On
    public final void A0O(AnonymousClass89 anonymousClass89) {
        anonymousClass89.A0J(this.A08);
        this.A00 = A00(anonymousClass89.A0H().getResources().getConfiguration().orientation);
        addView(this.A00, AbstractC0625On.A0D);
        addView(super.A08, new FrameLayout.LayoutParams(-1, super.A08.getToolbarHeight()));
        KE.A0J(this.A00);
        KE.A0J(super.A08);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0023, code lost:            return r2;     */
    @Override // com.facebook.ads.redexgen.X.AbstractC0625On
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0P() {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            com.facebook.ads.redexgen.X.Nr r0 = r3.A00
            if (r0 == 0) goto L21
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L1b;
                case 4: goto L23;
                case 5: goto L1e;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.P6 r3 = (com.facebook.ads.redexgen.X.P6) r3
            com.facebook.ads.redexgen.X.Nr r1 = r3.A00
            boolean r0 = r3.A02
            boolean r0 = r1.A0c(r0)
            if (r0 == 0) goto L19
            r0 = 3
            goto L7
        L19:
            r0 = 5
            goto L7
        L1b:
            r2 = 1
            r0 = 4
            goto L7
        L1e:
            r2 = 0
            r0 = 4
            goto L7
        L21:
            r0 = 5
            goto L7
        L23:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.P6.A0P():boolean");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0524Ko
    public final void A7F(boolean z) {
        if (this.A0A.A0Y()) {
            return;
        }
        this.A01 = this.A0A.getVideoStartReason();
        this.A03 = z;
        this.A0A.A0U(false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0051, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0524Ko
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A7O(boolean r4) {
        /*
            r3 = this;
            r2 = r3
            com.facebook.ads.redexgen.X.Lb r0 = r2.A0A
            boolean r0 = r0.A0Z()
            if (r0 != 0) goto L4f
            r0 = 2
        La:
            switch(r0) {
                case 2: goto L33;
                case 3: goto L51;
                case 4: goto L23;
                case 5: goto L19;
                case 6: goto Le;
                case 7: goto L3d;
                case 8: goto L44;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.P6 r2 = (com.facebook.ads.redexgen.X.P6) r2
            boolean r0 = r2.A03
            if (r0 == 0) goto L16
            r0 = 7
            goto La
        L16:
            r0 = 8
            goto La
        L19:
            com.facebook.ads.redexgen.X.P6 r2 = (com.facebook.ads.redexgen.X.P6) r2
            com.facebook.ads.redexgen.X.QH r0 = r2.A01
            if (r0 == 0) goto L21
            r0 = 6
            goto La
        L21:
            r0 = 3
            goto La
        L23:
            com.facebook.ads.redexgen.X.P6 r2 = (com.facebook.ads.redexgen.X.P6) r2
            com.facebook.ads.redexgen.X.Lb r0 = r2.A0A
            com.facebook.ads.redexgen.X.FR r1 = r0.getState()
            com.facebook.ads.redexgen.X.FR r0 = com.facebook.ads.redexgen.X.FR.A06
            if (r1 == r0) goto L31
            r0 = 5
            goto La
        L31:
            r0 = 3
            goto La
        L33:
            com.facebook.ads.redexgen.X.P6 r2 = (com.facebook.ads.redexgen.X.P6) r2
            boolean r0 = r2.A05
            if (r0 == 0) goto L3b
            r0 = 3
            goto La
        L3b:
            r0 = 4
            goto La
        L3d:
            if (r4 == 0) goto L42
            r0 = 8
            goto La
        L42:
            r0 = 3
            goto La
        L44:
            com.facebook.ads.redexgen.X.P6 r2 = (com.facebook.ads.redexgen.X.P6) r2
            com.facebook.ads.redexgen.X.Lb r1 = r2.A0A
            com.facebook.ads.redexgen.X.QH r0 = r2.A01
            r1.A0Q(r0)
            r0 = 3
            goto La
        L4f:
            r0 = 3
            goto La
        L51:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.P6.A7O(boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001a, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int getCloseButtonStyle() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.Nr r0 = r2.A00
            if (r0 == 0) goto L18
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L1a;
                case 4: goto L15;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.P6 r2 = (com.facebook.ads.redexgen.X.P6) r2
            com.facebook.ads.redexgen.X.Nr r0 = r2.A00
            int r1 = r0.getCloseButtonStyle()
            r0 = 3
            goto L7
        L15:
            r1 = 0
            r0 = 3
            goto L7
        L18:
            r0 = 4
            goto L7
        L1a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.P6.getCloseButtonStyle():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x006a, code lost:            r2.A0B.A0R();     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0071, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.AbstractC0625On, com.facebook.ads.redexgen.X.InterfaceC0524Ko
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onDestroy() {
        /*
            r5 = this;
            r2 = r5
            super.onDestroy()
            com.facebook.ads.redexgen.X.Nr r0 = r2.A00
            if (r0 == 0) goto L68
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto L5f;
                case 3: goto L55;
                case 4: goto L4b;
                case 5: goto L40;
                case 6: goto Ld;
                case 7: goto L6a;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.P6 r2 = (com.facebook.ads.redexgen.X.P6) r2
            com.facebook.ads.redexgen.X.Lb r0 = r2.A0A
            com.facebook.ads.redexgen.X.GY r4 = r0.getEventBus()
            r0 = 6
            com.facebook.ads.redexgen.X.1S[] r3 = new com.facebook.ads.redexgen.X.C1S[r0]
            r1 = 0
            com.facebook.ads.redexgen.X.8k r0 = r2.A0G
            r3[r1] = r0
            r1 = 1
            com.facebook.ads.redexgen.X.8m r0 = r2.A0F
            r3[r1] = r0
            r1 = 2
            com.facebook.ads.redexgen.X.8o r0 = r2.A0E
            r3[r1] = r0
            r1 = 3
            com.facebook.ads.redexgen.X.LH r0 = r2.A0H
            r3[r1] = r0
            r1 = 4
            com.facebook.ads.redexgen.X.8s r0 = r2.A0C
            r3[r1] = r0
            r1 = 5
            com.facebook.ads.redexgen.X.8w r0 = r2.A0D
            r3[r1] = r0
            r4.A04(r3)
            com.facebook.ads.redexgen.X.Lb r0 = r2.A0A
            r0.A0K()
            r0 = 7
            goto L9
        L40:
            com.facebook.ads.redexgen.X.P6 r2 = (com.facebook.ads.redexgen.X.P6) r2
            com.facebook.ads.redexgen.X.Lb r1 = r2.A0A
            com.facebook.ads.redexgen.X.QE r0 = com.facebook.ads.redexgen.X.QE.A03
            r1.A0P(r0)
            r0 = 6
            goto L9
        L4b:
            com.facebook.ads.redexgen.X.P6 r2 = (com.facebook.ads.redexgen.X.P6) r2
            boolean r0 = r2.A05
            if (r0 != 0) goto L53
            r0 = 5
            goto L9
        L53:
            r0 = 6
            goto L9
        L55:
            com.facebook.ads.redexgen.X.P6 r2 = (com.facebook.ads.redexgen.X.P6) r2
            com.facebook.ads.redexgen.X.Lb r0 = r2.A0A
            if (r0 == 0) goto L5d
            r0 = 4
            goto L9
        L5d:
            r0 = 7
            goto L9
        L5f:
            com.facebook.ads.redexgen.X.P6 r2 = (com.facebook.ads.redexgen.X.P6) r2
            com.facebook.ads.redexgen.X.Nr r0 = r2.A00
            r0.A0U()
            r0 = 3
            goto L9
        L68:
            r0 = 3
            goto L9
        L6a:
            com.facebook.ads.redexgen.X.P6 r2 = (com.facebook.ads.redexgen.X.P6) r2
            com.facebook.ads.redexgen.X.QA r0 = r2.A0B
            r0.A0R()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.P6.onDestroy():void");
    }
}
