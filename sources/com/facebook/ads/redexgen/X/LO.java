package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.MotionEvent;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: assets/audience_network.dex */
public final class LO extends LC {
    public static byte[] A0T;

    @Nullable
    public AnonymousClass89 A00;

    @Nullable
    public AbstractC0604Nr A01;

    @Nullable
    public QH A02;
    public boolean A03;
    public boolean A04;
    public boolean A05;
    public boolean A06;
    public boolean A07;
    public boolean A08;
    public final C2L A09;
    public final AnonymousClass86 A0A;
    public final EV A0B;
    public final C0362Ec A0C;
    public final K5 A0D;
    public final C0647Pj A0E;
    public final C0537Lb A0F;
    public final Q9 A0G;
    public final AbstractC02238s A0H;
    public final AbstractC02278w A0I;
    public final AbstractC02198o A0J;
    public final AbstractC02178m A0K;
    public final AbstractC02158k A0L;
    public final LH A0M;
    public final M9 A0N;
    public final I6 A0O;
    public final AnonymousClass29 A0P;
    public final FP A0Q;
    public final AtomicBoolean A0R;
    public final AtomicBoolean A0S;

    static {
        A0F();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A0B(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.LO.A0T
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
            r0 = r0 ^ 118(0x76, float:1.65E-43)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.LO.A0B(int, int, int):java.lang.String");
    }

    public static void A0F() {
        A0T = new byte[]{22, 0, 18, 62, 23, 8, 5, 4, 14, 62, 12, 20, 21, 4, 5};
    }

    public LO(C0362Ec c0362Ec, InterfaceC0422Gl interfaceC0422Gl, C2W c2w, EV ev, AnonymousClass81 anonymousClass81) {
        super(c0362Ec, interfaceC0422Gl, anonymousClass81, c2w);
        this.A0A = new LE(this);
        this.A0I = new LF(this);
        this.A0K = new LG(this);
        this.A0M = new LI(this);
        this.A0J = new LJ(this);
        this.A0H = new LK(this);
        this.A0L = new LL(this);
        this.A0D = new K5();
        this.A0S = new AtomicBoolean(false);
        this.A0R = new AtomicBoolean(false);
        this.A03 = false;
        this.A06 = false;
        this.A04 = false;
        this.A07 = false;
        this.A08 = true;
        this.A05 = false;
        this.A0C = c0362Ec;
        this.A0F = new C0537Lb(this.A0C);
        this.A0F.setFunnelLoggingHandler(super.A0C);
        this.A0F.setVideoProgressReportIntervalMs(c2w.A0E());
        KE.A0N(this.A0F);
        KE.A0P(this.A0F, 0);
        this.A09 = c2w.A0L();
        this.A05 = this.A09.A0K() && this.A09.A0D().A02() > 0;
        this.A0B = ev;
        this.A0O = new I6(this.A0C);
        this.A0N = new M9(c0362Ec, super.A0C);
        this.A0F.getEventBus().A03(this.A0K, this.A0M, this.A0J, this.A0H, this.A0I, this.A0L);
        setupPlugins(this.A09);
        this.A0P = new LM(this);
        this.A0Q = new FP(this, 1, this.A0P, c0362Ec);
        this.A0Q.A0X(c2w.A0F());
        this.A0Q.A0Y(c2w.A0G());
        this.A0G = new QA(this.A0C, super.A0B, this.A0F, super.A09.A0P());
        this.A0E = new C0647Pj(c0362Ec, new MR(), this.A09.A0G().A00(), getAudienceNetworkListener());
        if (this.A09.A0D().A03() > 0) {
            setForcedTimeViewIncomplete(true);
        }
    }

    private C0610Nx A07(int i) {
        return new C0609Nw(this.A0C, super.A0B, getAudienceNetworkListener(), super.A09, this.A0F, this.A0Q, this.A0D).A0D(super.A0D.getToolbarHeight()).A0C(i).A0G(this.A0O).A0E(this.A0N).A0F(super.A0D).A0H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001a, code lost:            r1.setVisibility(r2);     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x001f, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A0E() {
        /*
            r3 = this;
            r2 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.M9 r1 = r3.A0N
            java.util.concurrent.atomic.AtomicBoolean r0 = r3.A0R
            boolean r0 = r0.get()
            if (r0 == 0) goto L18
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L11;
                case 3: goto L1a;
                case 4: goto L14;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            r2 = 0
            r0 = 3
            goto Ld
        L14:
            r2 = 8
            r0 = 3
            goto Ld
        L18:
            r0 = 4
            goto Ld
        L1a:
            com.facebook.ads.redexgen.X.M9 r1 = (com.facebook.ads.redexgen.X.M9) r1
            r1.setVisibility(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.LO.A0E():void");
    }

    private void A0G(int i) {
        if (this.A01 == null) {
            return;
        }
        A08(this.A01, this.A01.A0b(), i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002e, code lost:            r3.A01 = com.facebook.ads.redexgen.X.C0607Nu.A01(r2, r6, false, r1);     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003b, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0H(int r5, @android.support.annotation.Nullable android.os.Bundle r6) {
        /*
            r4 = this;
            r3 = r4
            r0 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.Nx r2 = r3.A07(r5)
            r1 = 0
            com.facebook.ads.redexgen.X.Nr r0 = r3.A01
            if (r0 == 0) goto L2c
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L11;
                case 3: goto L23;
                case 4: goto L2e;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            com.facebook.ads.redexgen.X.LO r3 = (com.facebook.ads.redexgen.X.LO) r3
            com.facebook.ads.redexgen.X.Nr r0 = r3.A01
            boolean r1 = r0.A0a()
            com.facebook.ads.redexgen.X.Nr r0 = r3.A01
            boolean r0 = r0 instanceof com.facebook.ads.redexgen.X.OD
            if (r0 != 0) goto L21
            r0 = 3
            goto Ld
        L21:
            r0 = 4
            goto Ld
        L23:
            com.facebook.ads.redexgen.X.LO r3 = (com.facebook.ads.redexgen.X.LO) r3
            com.facebook.ads.redexgen.X.Nr r0 = r3.A01
            r0.A0U()
            r0 = 4
            goto Ld
        L2c:
            r0 = 4
            goto Ld
        L2e:
            com.facebook.ads.redexgen.X.LO r3 = (com.facebook.ads.redexgen.X.LO) r3
            android.os.Bundle r6 = (android.os.Bundle) r6
            com.facebook.ads.redexgen.X.Nx r2 = (com.facebook.ads.redexgen.X.C0610Nx) r2
            r0 = 0
            com.facebook.ads.redexgen.X.Nr r0 = com.facebook.ads.redexgen.X.C0607Nu.A01(r2, r6, r0, r1)
            r3.A01 = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.LO.A0H(int, android.os.Bundle):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0044, code lost:            r3 = r3;        r3.A0E();        r3.A0G(r13);     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004c, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0I(@android.support.annotation.Nullable android.os.Bundle r11, com.facebook.ads.redexgen.X.C2L r12, int r13) {
        /*
            r10 = this;
            r5 = r12
            r9 = r11
            r3 = r10
            com.facebook.ads.redexgen.X.Nr r0 = r3.A01
            if (r0 == 0) goto L42
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L24;
                case 4: goto L2c;
                case 5: goto L44;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.LO r3 = (com.facebook.ads.redexgen.X.LO) r3
            android.os.Bundle r9 = (android.os.Bundle) r9
            com.facebook.ads.redexgen.X.2L r5 = (com.facebook.ads.redexgen.X.C2L) r5
            com.facebook.ads.redexgen.X.Nr r4 = r3.A01
            com.facebook.ads.redexgen.X.2W r0 = r3.A09
            java.lang.String r6 = r0.A0P()
            float r0 = com.facebook.ads.redexgen.X.C0603Nq.A00(r5)
            double r7 = (double) r0
            r4.A0Z(r5, r6, r7, r9)
            r0 = 3
            goto L8
        L24:
            android.os.Bundle r9 = (android.os.Bundle) r9
            if (r9 == 0) goto L2a
            r0 = 4
            goto L8
        L2a:
            r0 = 5
            goto L8
        L2c:
            com.facebook.ads.redexgen.X.LO r3 = (com.facebook.ads.redexgen.X.LO) r3
            android.os.Bundle r9 = (android.os.Bundle) r9
            r2 = 0
            r1 = 15
            r0 = 23
            java.lang.String r1 = A0B(r2, r1, r0)
            r0 = 1
            boolean r0 = r9.getBoolean(r1, r0)
            r3.A08 = r0
            r0 = 5
            goto L8
        L42:
            r0 = 3
            goto L8
        L44:
            com.facebook.ads.redexgen.X.LO r3 = (com.facebook.ads.redexgen.X.LO) r3
            r3.A0E()
            r3.A0G(r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.LO.A0I(android.os.Bundle, com.facebook.ads.redexgen.X.2L, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x00a7, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.LC
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0S() {
        /*
            r7 = this;
            r6 = r7
            r5 = 0
            r4 = 0
            r3 = 0
            com.facebook.ads.redexgen.X.Lb r0 = r6.A0F
            android.view.ViewParent r0 = r0.getParent()
            if (r0 != 0) goto La4
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto La7;
                case 3: goto L33;
                case 4: goto L28;
                case 5: goto L25;
                case 6: goto L11;
                case 7: goto L70;
                case 8: goto L80;
                case 9: goto L64;
                case 10: goto L8c;
                case 11: goto L4f;
                case 12: goto L9f;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            com.facebook.ads.redexgen.X.LO r6 = (com.facebook.ads.redexgen.X.LO) r6
            com.facebook.ads.redexgen.X.Lb r3 = (com.facebook.ads.redexgen.X.C0537Lb) r3
            r3.setVolume(r4)
            com.facebook.ads.redexgen.X.Lb r0 = r6.A0F
            boolean r0 = r0.A0Z()
            if (r0 != 0) goto L22
            r0 = 7
            goto Ld
        L22:
            r0 = 10
            goto Ld
        L25:
            r4 = 0
            r0 = 6
            goto Ld
        L28:
            com.facebook.ads.redexgen.X.LO r6 = (com.facebook.ads.redexgen.X.LO) r6
            boolean r0 = r6.A08
            if (r0 == 0) goto L30
            r0 = 5
            goto Ld
        L30:
            r0 = 12
            goto Ld
        L33:
            com.facebook.ads.redexgen.X.LO r6 = (com.facebook.ads.redexgen.X.LO) r6
            r6.A06()
            com.facebook.ads.redexgen.X.2W r0 = r6.A09
            com.facebook.ads.redexgen.X.2L r5 = r0.A0L()
            com.facebook.ads.redexgen.X.Lb r3 = r6.A0F
            com.facebook.ads.redexgen.X.2O r0 = r5.A0D()
            boolean r0 = r0.A08()
            if (r0 == 0) goto L4c
            r0 = 4
            goto Ld
        L4c:
            r0 = 12
            goto Ld
        L4f:
            com.facebook.ads.redexgen.X.LO r6 = (com.facebook.ads.redexgen.X.LO) r6
            com.facebook.ads.redexgen.X.LN r2 = new com.facebook.ads.redexgen.X.LN
            r2.<init>(r6)
            android.content.Context r0 = r6.getContext()
            int r0 = com.facebook.ads.redexgen.X.C0413Gc.A0G(r0)
            long r0 = (long) r0
            r6.postDelayed(r2, r0)
            r0 = 2
            goto Ld
        L64:
            com.facebook.ads.redexgen.X.LO r6 = (com.facebook.ads.redexgen.X.LO) r6
            com.facebook.ads.redexgen.X.Lb r1 = r6.A0F
            com.facebook.ads.redexgen.X.QH r0 = com.facebook.ads.redexgen.X.QH.A03
            r1.A0R(r0)
            r0 = 10
            goto Ld
        L70:
            com.facebook.ads.redexgen.X.LO r6 = (com.facebook.ads.redexgen.X.LO) r6
            com.facebook.ads.redexgen.X.Lb r0 = r6.A0F
            boolean r0 = r0.A0b()
            if (r0 == 0) goto L7d
            r0 = 8
            goto Ld
        L7d:
            r0 = 10
            goto Ld
        L80:
            com.facebook.ads.redexgen.X.LO r6 = (com.facebook.ads.redexgen.X.LO) r6
            boolean r0 = r6.A06
            if (r0 != 0) goto L89
            r0 = 9
            goto Ld
        L89:
            r0 = 10
            goto Ld
        L8c:
            com.facebook.ads.redexgen.X.2L r5 = (com.facebook.ads.redexgen.X.C2L) r5
            com.facebook.ads.redexgen.X.2O r0 = r5.A0D()
            int r0 = r0.A03()
            if (r0 <= 0) goto L9c
            r0 = 11
            goto Ld
        L9c:
            r0 = 2
            goto Ld
        L9f:
            r4 = 1065353216(0x3f800000, float:1.0)
            r0 = 6
            goto Ld
        La4:
            r0 = 3
            goto Ld
        La7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.LO.A0S():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0023, code lost:            return r2;     */
    @Override // com.facebook.ads.redexgen.X.LC
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0T() {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            com.facebook.ads.redexgen.X.Nr r0 = r3.A01
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
            com.facebook.ads.redexgen.X.LO r3 = (com.facebook.ads.redexgen.X.LO) r3
            com.facebook.ads.redexgen.X.Nr r1 = r3.A01
            boolean r0 = r3.A05
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.LO.A0T():boolean");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0524Ko
    public final void A5L(Intent intent, @Nullable Bundle bundle, AnonymousClass89 anonymousClass89) {
        super.A0A(anonymousClass89);
        this.A00 = anonymousClass89;
        C2L A0L = super.A09.A0L();
        int i = anonymousClass89.A0H().getResources().getConfiguration().orientation;
        A0H(i, bundle);
        this.A0F.setVideoURI(this.A0B.A0L(this.A09.A0D().A07()));
        A0I(bundle, A0L, i);
        if (this.A00 != null) {
            this.A00.A0J(this.A0A);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002e, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.LC, com.facebook.ads.redexgen.X.InterfaceC0524Ko
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A7F(boolean r4) {
        /*
            r3 = this;
            r2 = r3
            boolean r0 = r2.A03
            if (r0 != 0) goto L2c
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L2e;
                case 4: goto L18;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.LO r2 = (com.facebook.ads.redexgen.X.LO) r2
            com.facebook.ads.redexgen.X.Lb r0 = r2.A0F
            boolean r0 = r0.A0Y()
            if (r0 == 0) goto L16
            r0 = 3
            goto L6
        L16:
            r0 = 4
            goto L6
        L18:
            com.facebook.ads.redexgen.X.LO r2 = (com.facebook.ads.redexgen.X.LO) r2
            com.facebook.ads.redexgen.X.Lb r0 = r2.A0F
            com.facebook.ads.redexgen.X.QH r0 = r0.getVideoStartReason()
            r2.A02 = r0
            r2.A06 = r4
            com.facebook.ads.redexgen.X.Lb r1 = r2.A0F
            r0 = 0
            r1.A0U(r0)
            r0 = 3
            goto L6
        L2c:
            r0 = 3
            goto L6
        L2e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.LO.A7F(boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x0082, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.LC, com.facebook.ads.redexgen.X.InterfaceC0524Ko
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A7O(boolean r4) {
        /*
            r3 = this;
            r2 = r3
            boolean r0 = r2.A03
            if (r0 != 0) goto L80
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto L5f;
                case 3: goto L3b;
                case 4: goto L2b;
                case 5: goto La;
                case 6: goto L82;
                case 7: goto L1a;
                case 8: goto L49;
                case 9: goto L6d;
                case 10: goto L79;
                case 11: goto L54;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.LO r2 = (com.facebook.ads.redexgen.X.LO) r2
            com.facebook.ads.redexgen.X.Lb r0 = r2.A0F
            com.facebook.ads.redexgen.X.QH r1 = r0.getVideoStartReason()
            com.facebook.ads.redexgen.X.QH r0 = com.facebook.ads.redexgen.X.QH.A04
            if (r1 != r0) goto L18
            r0 = 6
            goto L6
        L18:
            r0 = 7
            goto L6
        L1a:
            com.facebook.ads.redexgen.X.LO r2 = (com.facebook.ads.redexgen.X.LO) r2
            com.facebook.ads.redexgen.X.Lb r0 = r2.A0F
            com.facebook.ads.redexgen.X.FR r1 = r0.getState()
            com.facebook.ads.redexgen.X.FR r0 = com.facebook.ads.redexgen.X.FR.A06
            if (r1 == r0) goto L29
            r0 = 8
            goto L6
        L29:
            r0 = 6
            goto L6
        L2b:
            com.facebook.ads.redexgen.X.LO r2 = (com.facebook.ads.redexgen.X.LO) r2
            com.facebook.ads.redexgen.X.Lb r0 = r2.A0F
            com.facebook.ads.redexgen.X.FR r1 = r0.getState()
            com.facebook.ads.redexgen.X.FR r0 = com.facebook.ads.redexgen.X.FR.A07
            if (r1 != r0) goto L39
            r0 = 5
            goto L6
        L39:
            r0 = 7
            goto L6
        L3b:
            com.facebook.ads.redexgen.X.LO r2 = (com.facebook.ads.redexgen.X.LO) r2
            com.facebook.ads.redexgen.X.Lb r0 = r2.A0F
            boolean r0 = r0.A0Z()
            if (r0 != 0) goto L47
            r0 = 4
            goto L6
        L47:
            r0 = 6
            goto L6
        L49:
            com.facebook.ads.redexgen.X.LO r2 = (com.facebook.ads.redexgen.X.LO) r2
            com.facebook.ads.redexgen.X.QH r0 = r2.A02
            if (r0 == 0) goto L52
            r0 = 9
            goto L6
        L52:
            r0 = 6
            goto L6
        L54:
            com.facebook.ads.redexgen.X.LO r2 = (com.facebook.ads.redexgen.X.LO) r2
            com.facebook.ads.redexgen.X.Lb r1 = r2.A0F
            com.facebook.ads.redexgen.X.QH r0 = r2.A02
            r1.A0Q(r0)
            r0 = 6
            goto L6
        L5f:
            com.facebook.ads.redexgen.X.LO r2 = (com.facebook.ads.redexgen.X.LO) r2
            com.facebook.ads.redexgen.X.Lb r0 = r2.A0F
            android.view.ViewParent r0 = r0.getParent()
            if (r0 == 0) goto L6b
            r0 = 3
            goto L6
        L6b:
            r0 = 6
            goto L6
        L6d:
            com.facebook.ads.redexgen.X.LO r2 = (com.facebook.ads.redexgen.X.LO) r2
            boolean r0 = r2.A06
            if (r0 == 0) goto L76
            r0 = 10
            goto L6
        L76:
            r0 = 11
            goto L6
        L79:
            if (r4 == 0) goto L7e
            r0 = 11
            goto L6
        L7e:
            r0 = 6
            goto L6
        L80:
            r0 = 6
            goto L6
        L82:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.LO.A7O(boolean):void");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0524Ko
    public final void A8E(Bundle bundle) {
        if (this.A01 != null) {
            bundle.putBoolean(A0B(0, 15, 23), this.A0F.A0X());
            this.A01.A0L(bundle);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001a, code lost:            return r1;     */
    @Override // com.facebook.ads.redexgen.X.LC
    @com.facebook.ads.internal.view.ToolbarActionView$ToolbarActionMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getCloseButtonStyle() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.Nr r0 = r2.A01
            if (r0 != 0) goto L18
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L1a;
                case 4: goto Le;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            r1 = 0
            r0 = 3
            goto L7
        Le:
            com.facebook.ads.redexgen.X.LO r2 = (com.facebook.ads.redexgen.X.LO) r2
            com.facebook.ads.redexgen.X.Nr r0 = r2.A01
            int r1 = r0.getCloseButtonStyle()
            r0 = 3
            goto L7
        L18:
            r0 = 4
            goto L7
        L1a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.LO.getCloseButtonStyle():int");
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        Bundle bundle = new Bundle();
        A8E(bundle);
        removeAllViews();
        KE.A0L(this.A0F);
        KE.A0L(this.A0O);
        KE.A0L(this.A0N);
        if (super.A09.A0L() == null) {
            return;
        }
        A0H(configuration.orientation, bundle);
        A0I(bundle, super.A09.A0L(), configuration.orientation);
        super.onConfigurationChanged(configuration);
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x00de, code lost:            super.onDestroy();     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00e3, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.LC, com.facebook.ads.redexgen.X.InterfaceC0524Ko
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onDestroy() {
        /*
            Method dump skipped, instructions count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.LO.onDestroy():void");
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.A0D.A06(motionEvent, this, this);
        return super.onInterceptTouchEvent(motionEvent);
    }

    private void setupPlugins(C2L c2l) {
        this.A0F.A0M();
        this.A0F.A0S(this.A0O);
        this.A0F.A0S(this.A0N);
        if (!TextUtils.isEmpty(c2l.A0D().A06())) {
            M6 m6 = new M6(this.A0C);
            this.A0F.A0S(m6);
            m6.setImage(c2l.A0D().A06());
        }
        ID id = new ID(this.A0C, true, super.A0C);
        this.A0F.A0S(id);
        this.A0F.A0S(new C0563Mb(id, NA.A02, true));
        this.A0F.A0S(new C0464Ie(this.A0C));
    }
}
