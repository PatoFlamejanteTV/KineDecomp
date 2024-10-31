package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.view.FullScreenAdToolbar;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: assets/audience_network.dex */
public final class M3 extends RelativeLayout implements InterfaceC0524Ko {
    public static byte[] A0i;
    public static final int A0j;
    public static final int A0k;
    public static final int A0l;
    public static final int A0m;
    public static final int A0n;
    public static final int A0o;
    public static final RelativeLayout.LayoutParams A0p;
    public static final int A0q;
    public static final int A0r;
    public static final int A0s;
    public static final int A0t;
    public static final int A0u;
    public static final /* synthetic */ boolean A0v;
    public int A00;
    public int A01;

    @Nullable
    public View A02;

    @Nullable
    public AnonymousClass81 A03;

    @Nullable
    public FullScreenAdToolbar A04;

    @Nullable
    public NW A05;
    public C0641Pd A06;
    public C0647Pj A07;

    @Nullable
    public C0537Lb A08;

    @Nullable
    public QH A09;
    public C0682Qs A0A;

    @Nullable
    public C0563Mb A0B;

    @Nullable
    public ID A0C;

    @Nullable
    public C0392Fg A0D;
    public FX A0E;
    public boolean A0F;
    public boolean A0G;
    public boolean A0H;
    public boolean A0I;
    public final int A0J;
    public final Handler A0K;
    public final Handler A0L;
    public final RelativeLayout A0M;
    public final C2T A0N;
    public final C00622h A0O;
    public final AnonymousClass86 A0P;
    public final C0362Ec A0Q;
    public final InterfaceC0422Gl A0R;
    public final C0432Gv A0S;
    public final ViewOnSystemUiVisibilityChangeListenerC0509Jz A0T;
    public final K5 A0U;
    public final QA A0V;
    public final AbstractC02238s A0W;
    public final AbstractC02278w A0X;
    public final AbstractC02178m A0Y;
    public final AbstractC02158k A0Z;
    public final LH A0a;
    public final M9 A0b;
    public final I6 A0c;
    public final AnonymousClass29 A0d;
    public final FP A0e;
    public final AtomicBoolean A0f;
    public final boolean A0g;
    public final boolean A0h;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A0F(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.M3.A0i
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
            int r0 = r0 + (-35)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.M3.A0F(int, int, int):java.lang.String");
    }

    public static void A0Q() {
        A0i = new byte[]{-100, -113, -118, -117, -107, -90, -78, -80, 113, -87, -92, -90, -88, -91, -78, -78, -82, 113, -92, -89, -74, 113, -84, -79, -73, -88, -75, -74, -73, -84, -73, -84, -92, -81, 113, -90, -81, -84, -90, -82, -88, -89};
    }

    static {
        A0Q();
        A0v = !M3.class.desiredAssertionStatus();
        A0l = (int) (10.0f * KE.A01);
        A0m = (int) (18.0f * KE.A01);
        A0o = (int) (16.0f * KE.A01);
        A0k = (int) (48.0f * KE.A01);
        A0n = (int) (28.0f * KE.A01);
        A0j = (int) (250.0f * KE.A01);
        A0u = (int) (12.0f * KE.A01);
        A0t = (int) (26.0f * KE.A01);
        A0q = (int) (4.0f * KE.A01);
        A0r = C4G.A01(-1, 77);
        A0s = C4G.A01(A0r, 90);
        A0p = new RelativeLayout.LayoutParams(-1, -1);
    }

    public M3(C0362Ec c0362Ec, InterfaceC0422Gl interfaceC0422Gl, C0537Lb c0537Lb, AnonymousClass81 anonymousClass81, C00622h c00622h) {
        super(c0362Ec);
        this.A0K = new Handler(Looper.getMainLooper());
        this.A0P = new C0555Lt(this);
        this.A0W = new C0556Lu(this);
        this.A0X = new C0557Lv(this);
        this.A0Z = new C0558Lw(this);
        this.A0Y = new C0559Lx(this);
        this.A0a = new C0561Lz(this);
        this.A0U = new K5();
        this.A0f = new AtomicBoolean(false);
        this.A0L = new Handler();
        this.A0H = false;
        this.A0G = false;
        this.A0F = false;
        this.A0I = false;
        this.A01 = -1;
        this.A0Q = c0362Ec;
        this.A0g = C0413Gc.A1I(this.A0Q);
        this.A0h = C0413Gc.A1H(this.A0Q);
        this.A03 = anonymousClass81;
        this.A0R = interfaceC0422Gl;
        this.A0O = c00622h;
        this.A0S = new C0432Gv(this.A0O.A0P(), this.A0R);
        this.A08 = c0537Lb;
        this.A08.setFunnelLoggingHandler(this.A0S);
        this.A0N = this.A0O.A0K().A01();
        this.A0M = new RelativeLayout(c0362Ec);
        this.A0c = new I6(this.A0Q);
        this.A0b = new M9(this.A0Q, this.A0S);
        C2O A0D = this.A0O.A0L().A0D();
        this.A0J = Math.min(A0D.A02(), A0D.A04());
        this.A08.setVolume(A0D.A08() ? 0.0f : 1.0f);
        this.A0d = new M0(this);
        this.A0e = new FP(this, 1, this.A0d, c0362Ec);
        this.A0e.A0X(250);
        this.A0V = new QA(this.A0Q, this.A0R, this.A08, this.A0O.A0P());
        this.A06 = new C0641Pd(this.A0Q, this.A0R, this.A0O);
        this.A07 = new C0647Pj(this.A0Q, new MS(), this.A0O.A0L().A0G().A00(), this.A03);
        new NR(this, c0362Ec).A07(A0D.A06());
        if (!A0v && this.A08 == null) {
            throw new AssertionError();
        }
        this.A08.setVideoProgressReportIntervalMs(c00622h.A0E());
        this.A08.getEventBus().A03(this.A0W, this.A0X, this.A0Z, this.A0Y, this.A0a);
        c0362Ec.A08().A2n();
        this.A0T = new ViewOnSystemUiVisibilityChangeListenerC0509Jz(this);
        this.A0T.A05(EnumC0508Jy.A02);
    }

    private void A0H() {
        if (this.A0Q == null) {
            return;
        }
        FrameLayout frameLayout = new FrameLayout(this.A0Q);
        frameLayout.setLayoutParams(A0p);
        KE.A0P(frameLayout, 1711276032);
        this.A0M.addView(frameLayout, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0I() {
        if (this.A03 == null) {
            return;
        }
        this.A03.A3b(EnumC0666Qc.A08.A02());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x013b, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A0J() {
        /*
            Method dump skipped, instructions count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.M3.A0J():void");
    }

    private void A0K() {
        int A03;
        if (this.A08 == null || this.A0Q == null) {
            return;
        }
        this.A08.A0M();
        this.A08.A0S(new C0464Ie(this.A0Q));
        this.A08.A0S(this.A0b);
        this.A08.A0S(this.A0c);
        this.A0C = new ID(this.A0Q, true, this.A0S);
        View view = new View(this.A0Q);
        view.setLayoutParams(A0p);
        KE.A0P(view, 1711276032);
        C0563Mb c0563Mb = new C0563Mb(view, NA.A02, true);
        this.A08.addView(view);
        this.A08.A0S(c0563Mb);
        C0563Mb fadeableTouchPlayPausePlugin = new C0563Mb(this.A0C, NA.A02, true);
        this.A08.A0S(this.A0C);
        this.A08.A0S(fadeableTouchPlayPausePlugin);
        this.A00 = KE.A03(this.A0Q);
        boolean landscapeFonts = this.A06.A03() == EnumC0640Pc.A03 && this.A00 == 2 && this.A0h;
        if (!this.A0g) {
            this.A05 = new C0638Pa(this.A0Q, A0k, this.A0N, this.A0R, this.A03, this.A06.A03() == EnumC0640Pc.A02 || landscapeFonts, this.A06.A03() == EnumC0640Pc.A02, this.A0e, this.A0U, this.A0h);
            C0563Mb fadeableTouchPlayPausePlugin2 = new C0563Mb(this.A05, NA.A02, true);
            this.A0B = fadeableTouchPlayPausePlugin2;
            this.A08.A0S(this.A0B);
        } else {
            this.A05 = new C0594Nh(this.A0Q, A0k, this.A0O.A0L().A0E().A00() == C2Q.A04, this.A0N, EnumC0666Qc.A04.A02(), this.A0R, this.A03, this.A0e, this.A0U, this.A0h);
            this.A0E = new FX(this.A05, 400, 100, 0);
            A0R();
            this.A0E.A3A(true, false);
        }
        this.A05.setInfo(this.A0O.A0L().A0E(), this.A0O.A0L().A0F(), this.A0O.A0P(), this.A0O.A0N().A01(), null);
        this.A04 = new FullScreenAdToolbar(this.A0Q, this.A03, this.A0S, 1, this.A0O.A0D());
        if (this.A0O.A0L().A0D().A03() < 0) {
            A03 = this.A0O.A0L().A0D().A04();
        } else {
            A03 = this.A0O.A0L().A0D().A03();
        }
        this.A01 = A03;
        this.A04.setPageDetails(this.A0O.A0N(), this.A0O.A0P(), this.A01, this.A0O.A0O());
        if (this.A0O.A0L().A0D().A03() < 0) {
            this.A04.setToolbarActionMode(4);
        }
        if (this.A06.A03() != EnumC0640Pc.A02 || this.A0g) {
            this.A04.setPageDetailsVisible(false);
        }
        this.A04.setToolbarListener(new C0551Lp(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ae, code lost:            r5 = r5;        r0 = new android.widget.RelativeLayout.LayoutParams(-1, -1);        r3.addView(r5, r0);        r5.bringToFront();     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00bd, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A0L() {
        /*
            r14 = this;
            r3 = r14
            r0 = 0
            r5 = 0
            r0 = 0
            r9 = 0
            r0 = 0
            r0 = 0
            r7 = -1
            com.facebook.ads.redexgen.X.2h r0 = r3.A0O
            com.facebook.ads.RewardData r4 = r0.A0J()
            if (r4 != 0) goto Lab
            r0 = 2
        L11:
            switch(r0) {
                case 2: goto L84;
                case 3: goto L23;
                case 4: goto L15;
                case 5: goto L7a;
                case 6: goto Lae;
                case 7: goto L92;
                default: goto L14;
            }
        L14:
            goto L11
        L15:
            com.facebook.ads.redexgen.X.M3 r3 = (com.facebook.ads.redexgen.X.M3) r3
            com.facebook.ads.redexgen.X.Lb r0 = r3.A08
            boolean r0 = r0.A0Z()
            if (r0 != 0) goto L21
            r0 = 5
            goto L11
        L21:
            r0 = 6
            goto L11
        L23:
            com.facebook.ads.redexgen.X.M3 r3 = (com.facebook.ads.redexgen.X.M3) r3
            java.lang.String r9 = (java.lang.String) r9
            com.facebook.ads.redexgen.X.Ld r5 = new com.facebook.ads.redexgen.X.Ld
            com.facebook.ads.redexgen.X.Ec r6 = r3.A0Q
            r8 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r10 = 0
            com.facebook.ads.redexgen.X.2h r0 = r3.A0O
            com.facebook.ads.redexgen.X.2Z r0 = r0.A0M()
            java.lang.String r11 = r0.A04()
            com.facebook.ads.redexgen.X.2h r0 = r3.A0O
            com.facebook.ads.redexgen.X.2Z r0 = r0.A0M()
            java.lang.String r12 = r0.A03()
            com.facebook.ads.redexgen.X.KM r0 = com.facebook.ads.redexgen.X.KM.REWARD_ICON
            android.graphics.Bitmap r13 = com.facebook.ads.redexgen.X.KN.A00(r0)
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13)
            android.widget.Button r1 = r5.A02
            com.facebook.ads.redexgen.X.Lq r0 = new com.facebook.ads.redexgen.X.Lq
            r0.<init>(r3, r5)
            r1.setOnClickListener(r0)
            android.widget.Button r1 = r5.A01
            com.facebook.ads.redexgen.X.Lr r0 = new com.facebook.ads.redexgen.X.Lr
            r0.<init>(r3, r5)
            r1.setOnClickListener(r0)
            android.widget.RelativeLayout r0 = r3.A0M
            com.facebook.ads.redexgen.X.KE.A0J(r0)
            com.facebook.ads.internal.view.FullScreenAdToolbar r0 = r3.A04
            com.facebook.ads.redexgen.X.KE.A0J(r0)
            r0 = 1711276032(0x66000000, float:1.5111573E23)
            com.facebook.ads.redexgen.X.KE.A0P(r5, r0)
            r0 = 1
            r5.setClickable(r0)
            com.facebook.ads.redexgen.X.Lb r0 = r3.A08
            if (r0 == 0) goto L78
            r0 = 4
            goto L11
        L78:
            r0 = 6
            goto L11
        L7a:
            com.facebook.ads.redexgen.X.M3 r3 = (com.facebook.ads.redexgen.X.M3) r3
            r1 = 0
            com.facebook.ads.redexgen.X.Lb r0 = r3.A08
            r0.A0V(r1, r1)
            r0 = 6
            goto L11
        L84:
            com.facebook.ads.redexgen.X.M3 r3 = (com.facebook.ads.redexgen.X.M3) r3
            com.facebook.ads.redexgen.X.2h r0 = r3.A0O
            com.facebook.ads.redexgen.X.2Z r0 = r0.A0M()
            java.lang.String r9 = r0.A05()
            r0 = 3
            goto L11
        L92:
            com.facebook.ads.redexgen.X.M3 r3 = (com.facebook.ads.redexgen.X.M3) r3
            com.facebook.ads.RewardData r4 = (com.facebook.ads.RewardData) r4
            com.facebook.ads.redexgen.X.2h r0 = r3.A0O
            com.facebook.ads.redexgen.X.2Z r2 = r0.A0M()
            java.lang.String r1 = r4.getCurrency()
            int r0 = r4.getQuantity()
            java.lang.String r9 = r2.A07(r1, r0)
            r0 = 3
            goto L11
        Lab:
            r0 = 7
            goto L11
        Lae:
            com.facebook.ads.redexgen.X.M3 r3 = (com.facebook.ads.redexgen.X.M3) r3
            com.facebook.ads.redexgen.X.Ld r5 = (com.facebook.ads.redexgen.X.C0539Ld) r5
            android.widget.RelativeLayout$LayoutParams r0 = new android.widget.RelativeLayout$LayoutParams
            r0.<init>(r7, r7)
            r3.addView(r5, r0)
            r5.bringToFront()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.M3.A0L():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x006e, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0M() {
        /*
            r5 = this;
            r4 = r5
            com.facebook.ads.redexgen.X.2h r0 = r4.A0O
            com.facebook.ads.redexgen.X.2L r0 = r0.A0L()
            boolean r0 = r0.A0O()
            if (r0 == 0) goto L6c
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L12;
                case 3: goto L1c;
                case 4: goto L6e;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            com.facebook.ads.redexgen.X.M3 r4 = (com.facebook.ads.redexgen.X.M3) r4
            com.facebook.ads.redexgen.X.81 r0 = r4.A03
            if (r0 == 0) goto L1a
            r0 = 3
            goto Le
        L1a:
            r0 = 4
            goto Le
        L1c:
            com.facebook.ads.redexgen.X.M3 r4 = (com.facebook.ads.redexgen.X.M3) r4
            com.facebook.ads.redexgen.X.Ou r3 = new com.facebook.ads.redexgen.X.Ou
            com.facebook.ads.redexgen.X.Ec r2 = r4.A0Q
            com.facebook.ads.redexgen.X.2h r0 = r4.A0O
            com.facebook.ads.redexgen.X.2L r0 = r0.A0L()
            com.facebook.ads.redexgen.X.2S r1 = r0.A0E()
            com.facebook.ads.redexgen.X.2h r0 = r4.A0O
            com.facebook.ads.redexgen.X.2c r0 = r0.A0N()
            r3.<init>(r2, r1, r0)
            com.facebook.ads.redexgen.X.2h r0 = r4.A0O
            com.facebook.ads.redexgen.X.2J r0 = r0.A0K()
            com.facebook.ads.redexgen.X.2T r0 = r0.A01()
            com.facebook.ads.redexgen.X.Ou r0 = r3.A08(r0)
            com.facebook.ads.redexgen.X.Ov r3 = r0.A0B()
            com.facebook.ads.redexgen.X.Gv r1 = r4.A0S
            com.facebook.ads.redexgen.X.Gu r0 = com.facebook.ads.redexgen.X.EnumC0431Gu.A0T
            com.facebook.ads.redexgen.X.C0434Gx.A04(r3, r1, r0)
            com.facebook.ads.redexgen.X.81 r2 = r4.A03
            r1 = 1
            android.widget.RelativeLayout$LayoutParams r0 = com.facebook.ads.redexgen.X.M3.A0p
            r2.A38(r3, r1, r0)
            r3.bringToFront()
            com.facebook.ads.redexgen.X.M2 r0 = new com.facebook.ads.redexgen.X.M2
            r0.<init>(r4)
            r3.A04(r0)
            com.facebook.ads.redexgen.X.Ec r0 = r4.A0Q
            com.facebook.ads.redexgen.X.0c r0 = r0.A08()
            r0.A2Y()
            r0 = 4
            goto Le
        L6c:
            r0 = 4
            goto Le
        L6e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.M3.A0M():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0N() {
        if (this.A08 == null) {
            return;
        }
        this.A08.A0Q(QH.A03);
        postDelayed(new C0550Lo(this), C0413Gc.A0F(getContext()));
    }

    private void A0O() {
        if (this.A0h && this.A02 != null && this.A06 != null && this.A06.A03() == EnumC0640Pc.A03) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            boolean z = this.A00 == 2;
            layoutParams.setMargins(0, !z ? getToolbarHeight() : A0l, 0, !z ? 0 : A0l);
            this.A02.setLayoutParams(layoutParams);
            this.A02.setOverScrollMode(2);
            C0642Pe recyclerAdapter = (C0642Pe) ((C01807a) this.A02).getAdapter();
            recyclerAdapter.A06();
            recyclerAdapter.A0F(this.A00, this.A0h);
            if (this.A05 != null) {
                if (z) {
                    this.A05.A08(this.A00);
                } else {
                    layoutParams.addRule(2, this.A05.getId());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(!z ? -1 : A0j, z ? -1 : -2);
                layoutParams2.addRule(12);
                this.A05.setPadding(A0o, !z ? A0o : A0o + getToolbarHeight(), A0o, A0o);
                this.A05.setLayoutParams(layoutParams2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001a, code lost:            r1.setVisibility(r2);        r3.A0b.A09();     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A0P() {
        /*
            r3 = this;
            r2 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.M9 r1 = r3.A0b
            java.util.concurrent.atomic.AtomicBoolean r0 = r3.A0f
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
            r0 = r3
            com.facebook.ads.redexgen.X.M3 r0 = (com.facebook.ads.redexgen.X.M3) r0
            com.facebook.ads.redexgen.X.M9 r1 = (com.facebook.ads.redexgen.X.M9) r1
            r1.setVisibility(r2)
            com.facebook.ads.redexgen.X.M9 r0 = r0.A0b
            r0.A09()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.M3.A0P():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x009b, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void A0R() {
        /*
            r9 = this;
            r7 = r9
            r0 = 0
            r0 = 0
            r6 = 300(0x12c, float:4.2E-43)
            r5 = 1
            com.facebook.ads.redexgen.X.NW r0 = r7.A05
            if (r0 != 0) goto L98
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto L9b;
                case 3: goto Lf;
                case 4: goto L20;
                case 5: goto L2b;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            com.facebook.ads.redexgen.X.M3 r7 = (com.facebook.ads.redexgen.X.M3) r7
            com.facebook.ads.redexgen.X.Qs r0 = new com.facebook.ads.redexgen.X.Qs
            r0.<init>(r5)
            r7.A0A = r0
            com.facebook.ads.redexgen.X.Fg r0 = r7.A0D
            if (r0 == 0) goto L1e
            r0 = 4
            goto Lb
        L1e:
            r0 = 5
            goto Lb
        L20:
            com.facebook.ads.redexgen.X.M3 r7 = (com.facebook.ads.redexgen.X.M3) r7
            com.facebook.ads.redexgen.X.Qs r1 = r7.A0A
            com.facebook.ads.redexgen.X.Fg r0 = r7.A0D
            r1.A0I(r0)
            r0 = 5
            goto Lb
        L2b:
            com.facebook.ads.redexgen.X.M3 r7 = (com.facebook.ads.redexgen.X.M3) r7
            com.facebook.ads.redexgen.X.2h r0 = r7.A0O
            com.facebook.ads.redexgen.X.2J r0 = r0.A0K()
            com.facebook.ads.redexgen.X.2T r8 = r0.A01()
            com.facebook.ads.redexgen.X.Qs r4 = r7.A0A
            com.facebook.ads.redexgen.X.Fb r3 = new com.facebook.ads.redexgen.X.Fb
            com.facebook.ads.redexgen.X.NW r0 = r7.A05
            com.facebook.ads.redexgen.X.Nc r2 = r0.getCTAButton()
            int r1 = r8.A08(r5)
            r0 = -14934495(0xffffffffff1c1e21, float:-2.07516E38)
            r3.<init>(r2, r6, r1, r0)
            r4.A0I(r3)
            int r2 = com.facebook.ads.redexgen.X.M3.A0r
            int r1 = com.facebook.ads.redexgen.X.M3.A0s
            int r0 = com.facebook.ads.redexgen.X.M3.A0q
            android.graphics.drawable.Drawable r4 = com.facebook.ads.redexgen.X.KE.A09(r2, r1, r0)
            int r1 = r8.A08(r5)
            int r0 = com.facebook.ads.redexgen.X.M3.A0q
            android.graphics.drawable.Drawable r3 = com.facebook.ads.redexgen.X.KE.A06(r1, r0)
            com.facebook.ads.redexgen.X.Qs r2 = r7.A0A
            com.facebook.ads.redexgen.X.Gr r1 = new com.facebook.ads.redexgen.X.Gr
            com.facebook.ads.redexgen.X.NW r0 = r7.A05
            com.facebook.ads.redexgen.X.Nc r0 = r0.getCTAButton()
            r1.<init>(r0, r6, r4, r3)
            r2.A0I(r1)
            com.facebook.ads.redexgen.X.Qs r4 = r7.A0A
            com.facebook.ads.redexgen.X.Fd r3 = new com.facebook.ads.redexgen.X.Fd
            com.facebook.ads.redexgen.X.NW r0 = r7.A05
            com.facebook.ads.redexgen.X.Nh r0 = (com.facebook.ads.redexgen.X.C0594Nh) r0
            android.view.View r2 = r0.getExpandableLayout()
            r1 = 150(0x96, float:2.1E-43)
            r0 = 0
            r3.<init>(r2, r1, r0)
            r4.A0I(r3)
            com.facebook.ads.redexgen.X.Qs r1 = r7.A0A
            r0 = 2300(0x8fc, float:3.223E-42)
            r1.A0H(r0)
            com.facebook.ads.redexgen.X.Qs r1 = r7.A0A
            com.facebook.ads.redexgen.X.Lb r0 = r7.A08
            r1.A5M(r0)
            r0 = 2
            goto Lb
        L98:
            r0 = 3
            goto Lb
        L9b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.M3.A0R():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x002d, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void A0S() {
        /*
            r2 = this;
            r1 = r2
            com.facebook.ads.redexgen.X.Lb r0 = r1.A08
            if (r0 == 0) goto L2b
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L18;
                case 4: goto L22;
                case 5: goto L2d;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.M3 r1 = (com.facebook.ads.redexgen.X.M3) r1
            com.facebook.ads.redexgen.X.Lb r0 = r1.A08
            r0.A0N()
            com.facebook.ads.redexgen.X.Lb r0 = r1.A08
            r0.A0K()
            r0 = 3
            goto L6
        L18:
            com.facebook.ads.redexgen.X.M3 r1 = (com.facebook.ads.redexgen.X.M3) r1
            com.facebook.ads.redexgen.X.FP r0 = r1.A0e
            if (r0 == 0) goto L20
            r0 = 4
            goto L6
        L20:
            r0 = 5
            goto L6
        L22:
            com.facebook.ads.redexgen.X.M3 r1 = (com.facebook.ads.redexgen.X.M3) r1
            com.facebook.ads.redexgen.X.FP r0 = r1.A0e
            r0.A0W()
            r0 = 5
            goto L6
        L2b:
            r0 = 3
            goto L6
        L2d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.M3.A0S():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002f, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A0a(com.facebook.ads.redexgen.X.QM r4) {
        /*
            r3 = this;
            r2 = r3
            boolean r0 = r2.A0H
            if (r0 == 0) goto L2d
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto L2f;
                case 3: goto La;
                case 4: goto L1c;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.M3 r2 = (com.facebook.ads.redexgen.X.M3) r2
            com.facebook.ads.redexgen.X.Pj r0 = r2.A07
            r0.A05()
            r2.A0J()
            com.facebook.ads.redexgen.X.81 r0 = r2.A03
            if (r0 == 0) goto L1a
            r0 = 4
            goto L6
        L1a:
            r0 = 2
            goto L6
        L1c:
            com.facebook.ads.redexgen.X.M3 r2 = (com.facebook.ads.redexgen.X.M3) r2
            com.facebook.ads.redexgen.X.QM r4 = (com.facebook.ads.redexgen.X.QM) r4
            com.facebook.ads.redexgen.X.81 r1 = r2.A03
            com.facebook.ads.redexgen.X.Qc r0 = com.facebook.ads.redexgen.X.EnumC0666Qc.A06
            java.lang.String r0 = r0.A02()
            r1.A3c(r0, r4)
            r0 = 2
            goto L6
        L2d:
            r0 = 3
            goto L6
        L2f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.M3.A0a(com.facebook.ads.redexgen.X.QM):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0074, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A0b(java.lang.String r8) {
        /*
            r7 = this;
            r4 = r7
            r0 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.Ec r0 = r4.A0Q
            com.facebook.ads.redexgen.X.0c r0 = r0.A08()
            r0.A2o(r8)
            r5 = 0
            r6 = 0
            com.facebook.ads.redexgen.X.Lb r0 = r4.A08
            if (r0 == 0) goto L72
            r0 = 2
        L13:
            switch(r0) {
                case 2: goto L53;
                case 3: goto L2d;
                case 4: goto L21;
                case 5: goto L74;
                case 6: goto L17;
                case 7: goto L63;
                default: goto L16;
            }
        L16:
            goto L13
        L17:
            com.facebook.ads.redexgen.X.M3 r4 = (com.facebook.ads.redexgen.X.M3) r4
            com.facebook.ads.redexgen.X.81 r0 = r4.A03
            if (r0 == 0) goto L1f
            r0 = 7
            goto L13
        L1f:
            r0 = 5
            goto L13
        L21:
            com.facebook.ads.redexgen.X.M3 r4 = (com.facebook.ads.redexgen.X.M3) r4
            com.facebook.ads.redexgen.X.QM r0 = new com.facebook.ads.redexgen.X.QM
            r0.<init>(r5, r6)
            r4.A0a(r0)
            r0 = 5
            goto L13
        L2d:
            com.facebook.ads.redexgen.X.M3 r4 = (com.facebook.ads.redexgen.X.M3) r4
            java.lang.String r8 = (java.lang.String) r8
            r4.A0S()
            com.facebook.ads.redexgen.X.Ec r3 = r4.A0Q
            r2 = 0
            r1 = 5
            r0 = 3
            java.lang.String r2 = A0F(r2, r1, r0)
            int r1 = com.facebook.ads.redexgen.X.C0512Kc.A1l
            com.facebook.ads.redexgen.X.Ke r0 = new com.facebook.ads.redexgen.X.Ke
            r0.<init>(r8)
            com.facebook.ads.redexgen.X.C0511Kb.A06(r3, r2, r1, r0)
            com.facebook.ads.redexgen.X.Ec r0 = r4.A0Q
            boolean r0 = com.facebook.ads.redexgen.X.C0413Gc.A0l(r0)
            if (r0 == 0) goto L51
            r0 = 4
            goto L13
        L51:
            r0 = 6
            goto L13
        L53:
            com.facebook.ads.redexgen.X.M3 r4 = (com.facebook.ads.redexgen.X.M3) r4
            com.facebook.ads.redexgen.X.Lb r0 = r4.A08
            int r5 = r0.getCurrentPositionInMillis()
            com.facebook.ads.redexgen.X.Lb r0 = r4.A08
            int r6 = r0.getDuration()
            r0 = 3
            goto L13
        L63:
            com.facebook.ads.redexgen.X.M3 r4 = (com.facebook.ads.redexgen.X.M3) r4
            com.facebook.ads.redexgen.X.81 r1 = r4.A03
            com.facebook.ads.redexgen.X.Qc r0 = com.facebook.ads.redexgen.X.EnumC0666Qc.A09
            java.lang.String r0 = r0.A02()
            r1.A3b(r0)
            r0 = 5
            goto L13
        L72:
            r0 = 3
            goto L13
        L74:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.M3.A0b(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0031, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean A0c() {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            com.facebook.ads.redexgen.X.Lb r0 = r3.A08
            if (r0 == 0) goto L2f
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L29;
                case 4: goto L31;
                case 5: goto L2c;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.M3 r3 = (com.facebook.ads.redexgen.X.M3) r3
            com.facebook.ads.redexgen.X.Lb r0 = r3.A08
            int r0 = r0.getCurrentPositionInMillis()
            int r1 = r0 / 1000
            com.facebook.ads.redexgen.X.2h r0 = r3.A0O
            com.facebook.ads.redexgen.X.2L r0 = r0.A0L()
            com.facebook.ads.redexgen.X.2O r0 = r0.A0D()
            int r0 = r0.A02()
            if (r1 < r0) goto L27
            r0 = 3
            goto L7
        L27:
            r0 = 5
            goto L7
        L29:
            r2 = 1
            r0 = 4
            goto L7
        L2c:
            r2 = 0
            r0 = 4
            goto L7
        L2f:
            r0 = 5
            goto L7
        L31:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.M3.A0c():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00be, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0524Ko
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A5L(android.content.Intent r5, android.os.Bundle r6, com.facebook.ads.redexgen.X.AnonymousClass89 r7) {
        /*
            r4 = this;
            r3 = r4
            com.facebook.ads.redexgen.X.Lb r0 = r3.A08
            if (r0 == 0) goto Lbb
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto L8e;
                case 3: goto Lbe;
                case 4: goto L60;
                case 5: goto L55;
                case 6: goto La;
                case 7: goto L6a;
                case 8: goto L9a;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.M3 r3 = (com.facebook.ads.redexgen.X.M3) r3
            com.facebook.ads.redexgen.X.89 r7 = (com.facebook.ads.redexgen.X.AnonymousClass89) r7
            r3.A0K()
            com.facebook.ads.redexgen.X.86 r0 = r3.A0P
            r7.A0J(r0)
            com.facebook.ads.redexgen.X.EV r2 = new com.facebook.ads.redexgen.X.EV
            com.facebook.ads.redexgen.X.Ec r0 = r3.A0Q
            r2.<init>(r0)
            com.facebook.ads.redexgen.X.2h r0 = r3.A0O
            com.facebook.ads.redexgen.X.2L r0 = r0.A0L()
            com.facebook.ads.redexgen.X.2O r0 = r0.A0D()
            java.lang.String r0 = r0.A07()
            com.facebook.ads.redexgen.X.Lb r1 = r3.A08
            java.lang.String r0 = r2.A0L(r0)
            r1.setVideoURI(r0)
            com.facebook.ads.AudienceNetworkActivity r0 = r7.A0H()
            android.content.res.Resources r0 = r0.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            int r0 = r0.orientation
            r3.setUpContentLayoutForVideo(r0)
            android.widget.RelativeLayout r1 = r3.A0M
            android.widget.RelativeLayout$LayoutParams r0 = com.facebook.ads.redexgen.X.M3.A0p
            r3.addView(r1, r0)
            com.facebook.ads.internal.view.FullScreenAdToolbar r0 = r3.A04
            if (r0 == 0) goto L52
            r0 = 7
            goto L6
        L52:
            r0 = 8
            goto L6
        L55:
            com.facebook.ads.redexgen.X.M3 r3 = (com.facebook.ads.redexgen.X.M3) r3
            com.facebook.ads.redexgen.X.Jz r1 = r3.A0T
            com.facebook.ads.redexgen.X.Jy r0 = com.facebook.ads.redexgen.X.EnumC0508Jy.A03
            r1.A05(r0)
            r0 = 6
            goto L6
        L60:
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 19
            if (r1 < r0) goto L68
            r0 = 5
            goto L6
        L68:
            r0 = 6
            goto L6
        L6a:
            com.facebook.ads.redexgen.X.M3 r3 = (com.facebook.ads.redexgen.X.M3) r3
            com.facebook.ads.internal.view.FullScreenAdToolbar r0 = r3.A04
            com.facebook.ads.redexgen.X.KE.A0N(r0)
            com.facebook.ads.internal.view.FullScreenAdToolbar r2 = r3.A04
            com.facebook.ads.redexgen.X.2T r1 = r3.A0N
            r0 = 1
            r2.A04(r1, r0)
            android.widget.RelativeLayout$LayoutParams r2 = new android.widget.RelativeLayout$LayoutParams
            r1 = -1
            com.facebook.ads.internal.view.FullScreenAdToolbar r0 = r3.A04
            int r0 = r0.getToolbarHeight()
            r2.<init>(r1, r0)
            com.facebook.ads.internal.view.FullScreenAdToolbar r0 = r3.A04
            r3.addView(r0, r2)
            r0 = 8
            goto L6
        L8e:
            com.facebook.ads.redexgen.X.M3 r3 = (com.facebook.ads.redexgen.X.M3) r3
            com.facebook.ads.redexgen.X.81 r0 = r3.A03
            if (r0 != 0) goto L97
            r0 = 3
            goto L6
        L97:
            r0 = 4
            goto L6
        L9a:
            com.facebook.ads.redexgen.X.M3 r3 = (com.facebook.ads.redexgen.X.M3) r3
            com.facebook.ads.redexgen.X.81 r2 = r3.A03
            r1 = 0
            android.widget.RelativeLayout$LayoutParams r0 = com.facebook.ads.redexgen.X.M3.A0p
            r2.A38(r3, r1, r0)
            r3.A0M()
            com.facebook.ads.redexgen.X.M1 r2 = new com.facebook.ads.redexgen.X.M1
            r2.<init>(r3)
            android.content.Context r0 = r3.getContext()
            int r0 = com.facebook.ads.redexgen.X.C0413Gc.A0G(r0)
            long r0 = (long) r0
            r3.postDelayed(r2, r0)
            r0 = 3
            goto L6
        Lbb:
            r0 = 3
            goto L6
        Lbe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.M3.A5L(android.content.Intent, android.os.Bundle, com.facebook.ads.redexgen.X.89):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002e, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0524Ko
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A7F(boolean r4) {
        /*
            r3 = this;
            r2 = r3
            com.facebook.ads.redexgen.X.Lb r0 = r2.A08
            if (r0 == 0) goto L2c
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
            com.facebook.ads.redexgen.X.M3 r2 = (com.facebook.ads.redexgen.X.M3) r2
            com.facebook.ads.redexgen.X.Lb r0 = r2.A08
            boolean r0 = r0.A0Y()
            if (r0 == 0) goto L16
            r0 = 3
            goto L6
        L16:
            r0 = 4
            goto L6
        L18:
            com.facebook.ads.redexgen.X.M3 r2 = (com.facebook.ads.redexgen.X.M3) r2
            com.facebook.ads.redexgen.X.Lb r0 = r2.A08
            com.facebook.ads.redexgen.X.QH r0 = r0.getVideoStartReason()
            r2.A09 = r0
            r2.A0G = r4
            com.facebook.ads.redexgen.X.Lb r1 = r2.A08
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.M3.A7F(boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x005c, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0524Ko
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A7O(boolean r4) {
        /*
            r3 = this;
            r2 = r3
            com.facebook.ads.redexgen.X.Lb r0 = r2.A08
            if (r0 == 0) goto L5a
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto L2e;
                case 3: goto L24;
                case 4: goto L5c;
                case 5: goto L14;
                case 6: goto La;
                case 7: goto L3c;
                case 8: goto L48;
                case 9: goto L4f;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.M3 r2 = (com.facebook.ads.redexgen.X.M3) r2
            com.facebook.ads.redexgen.X.QH r0 = r2.A09
            if (r0 == 0) goto L12
            r0 = 7
            goto L6
        L12:
            r0 = 4
            goto L6
        L14:
            com.facebook.ads.redexgen.X.M3 r2 = (com.facebook.ads.redexgen.X.M3) r2
            com.facebook.ads.redexgen.X.Lb r0 = r2.A08
            com.facebook.ads.redexgen.X.FR r1 = r0.getState()
            com.facebook.ads.redexgen.X.FR r0 = com.facebook.ads.redexgen.X.FR.A06
            if (r1 == r0) goto L22
            r0 = 6
            goto L6
        L22:
            r0 = 4
            goto L6
        L24:
            com.facebook.ads.redexgen.X.M3 r2 = (com.facebook.ads.redexgen.X.M3) r2
            boolean r0 = r2.A0H
            if (r0 == 0) goto L2c
            r0 = 4
            goto L6
        L2c:
            r0 = 5
            goto L6
        L2e:
            com.facebook.ads.redexgen.X.M3 r2 = (com.facebook.ads.redexgen.X.M3) r2
            com.facebook.ads.redexgen.X.Lb r0 = r2.A08
            boolean r0 = r0.A0Z()
            if (r0 != 0) goto L3a
            r0 = 3
            goto L6
        L3a:
            r0 = 4
            goto L6
        L3c:
            com.facebook.ads.redexgen.X.M3 r2 = (com.facebook.ads.redexgen.X.M3) r2
            boolean r0 = r2.A0G
            if (r0 == 0) goto L45
            r0 = 8
            goto L6
        L45:
            r0 = 9
            goto L6
        L48:
            if (r4 == 0) goto L4d
            r0 = 9
            goto L6
        L4d:
            r0 = 4
            goto L6
        L4f:
            com.facebook.ads.redexgen.X.M3 r2 = (com.facebook.ads.redexgen.X.M3) r2
            com.facebook.ads.redexgen.X.Lb r1 = r2.A08
            com.facebook.ads.redexgen.X.QH r0 = r2.A09
            r1.A0Q(r0)
            r0 = 4
            goto L6
        L5a:
            r0 = 4
            goto L6
        L5c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.M3.A7O(boolean):void");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0524Ko
    public final void A8E(Bundle bundle) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0055, code lost:            return r5;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.facebook.ads.redexgen.X.ViewOnClickListenerC0589Nc getCTAButton() {
        /*
            r13 = this;
            r4 = r13
            r0 = 0
            r5 = 0
            r3 = 1
            com.facebook.ads.redexgen.X.81 r0 = r4.A03
            if (r0 != 0) goto L51
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L53;
                case 4: goto L10;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            r5 = 0
            r0 = 3
            goto L9
        L10:
            com.facebook.ads.redexgen.X.M3 r4 = (com.facebook.ads.redexgen.X.M3) r4
            com.facebook.ads.redexgen.X.Nc r5 = new com.facebook.ads.redexgen.X.Nc
            com.facebook.ads.redexgen.X.Ec r6 = r4.A0Q
            r2 = 5
            r1 = 37
            r0 = 32
            java.lang.String r7 = A0F(r2, r1, r0)
            com.facebook.ads.redexgen.X.2T r8 = r4.A0N
            com.facebook.ads.redexgen.X.Gl r9 = r4.A0R
            com.facebook.ads.redexgen.X.81 r10 = r4.A03
            com.facebook.ads.redexgen.X.FP r11 = r4.A0e
            com.facebook.ads.redexgen.X.K5 r12 = r4.A0U
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)
            r5.setRoundedCornersEnabled(r3)
            r5.setViewShowsOverMedia(r3)
            r0 = 1001(0x3e9, float:1.403E-42)
            com.facebook.ads.redexgen.X.KE.A0I(r0, r5)
            com.facebook.ads.redexgen.X.2h r0 = r4.A0O
            com.facebook.ads.redexgen.X.2L r0 = r0.A0L()
            com.facebook.ads.redexgen.X.2U r2 = r0.A0F()
            com.facebook.ads.redexgen.X.2h r0 = r4.A0O
            java.lang.String r1 = r0.A0P()
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r5.setCta(r2, r1, r0)
            r0 = 3
            goto L9
        L51:
            r0 = 4
            goto L9
        L53:
            com.facebook.ads.redexgen.X.Nc r5 = (com.facebook.ads.redexgen.X.ViewOnClickListenerC0589Nc) r5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.M3.getCTAButton():com.facebook.ads.redexgen.X.Nc");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001b, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int getToolbarHeight() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.internal.view.FullScreenAdToolbar r0 = r2.A04
            if (r0 != 0) goto L19
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L1b;
                case 4: goto Lf;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            int r1 = com.facebook.ads.internal.view.FullScreenAdToolbar.A08
            r0 = 3
            goto L7
        Lf:
            com.facebook.ads.redexgen.X.M3 r2 = (com.facebook.ads.redexgen.X.M3) r2
            com.facebook.ads.internal.view.FullScreenAdToolbar r0 = r2.A04
            int r1 = r0.getToolbarHeight()
            r0 = 3
            goto L7
        L19:
            r0 = 4
            goto L7
        L1b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.M3.getToolbarHeight():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x003e, code lost:            r3 = r3;        r3.A00 = r5.orientation;        r3.A0O();     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0049, code lost:            return;     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onConfigurationChanged(android.content.res.Configuration r5) {
        /*
            r4 = this;
            r3 = r4
            com.facebook.ads.redexgen.X.NW r0 = r3.A05
            if (r0 == 0) goto L3c
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L1d;
                case 4: goto L27;
                case 5: goto L3e;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.M3 r3 = (com.facebook.ads.redexgen.X.M3) r3
            android.content.res.Configuration r5 = (android.content.res.Configuration) r5
            com.facebook.ads.redexgen.X.NW r1 = r3.A05
            int r0 = r5.orientation
            r1.A08(r0)
            boolean r0 = r3.A0g
            if (r0 == 0) goto L1b
            r0 = 3
            goto L6
        L1b:
            r0 = 5
            goto L6
        L1d:
            com.facebook.ads.redexgen.X.M3 r3 = (com.facebook.ads.redexgen.X.M3) r3
            com.facebook.ads.redexgen.X.Fg r0 = r3.A0D
            if (r0 == 0) goto L25
            r0 = 4
            goto L6
        L25:
            r0 = 5
            goto L6
        L27:
            com.facebook.ads.redexgen.X.M3 r3 = (com.facebook.ads.redexgen.X.M3) r3
            android.content.res.Configuration r5 = (android.content.res.Configuration) r5
            com.facebook.ads.redexgen.X.Fg r2 = r3.A0D
            com.facebook.ads.redexgen.X.NW r1 = r3.A05
            com.facebook.ads.redexgen.X.Nh r1 = (com.facebook.ads.redexgen.X.C0594Nh) r1
            int r0 = r5.orientation
            int r0 = r1.A0A(r0)
            r2.A09(r0)
            r0 = 5
            goto L6
        L3c:
            r0 = 5
            goto L6
        L3e:
            com.facebook.ads.redexgen.X.M3 r3 = (com.facebook.ads.redexgen.X.M3) r3
            android.content.res.Configuration r5 = (android.content.res.Configuration) r5
            int r0 = r5.orientation
            r3.A00 = r0
            r3.A0O()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.M3.onConfigurationChanged(android.content.res.Configuration):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0089, code lost:            r5 = r5;        r5.A0V.A0R();        r5.A08 = r4;        r5.A05 = r4;        r5.A0B = r4;        r5.A03 = r4;        r5.A0c.A09();     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x009d, code lost:            return;     */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [com.facebook.ads.redexgen.X.Mb, com.facebook.ads.redexgen.X.Lb, com.facebook.ads.redexgen.X.NW, com.facebook.ads.redexgen.X.81] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0524Ko
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onDestroy() {
        /*
            r6 = this;
            r5 = r6
            r0 = 0
            r4 = 0
            com.facebook.ads.redexgen.X.Jz r0 = r5.A0T
            r0.A03()
            r5.A0S()
            com.facebook.ads.redexgen.X.Lb r0 = r5.A08
            if (r0 == 0) goto L87
            r0 = 2
        L10:
            switch(r0) {
                case 2: goto L5e;
                case 3: goto L4c;
                case 4: goto L28;
                case 5: goto L1e;
                case 6: goto L14;
                case 7: goto L89;
                default: goto L13;
            }
        L13:
            goto L10
        L14:
            com.facebook.ads.redexgen.X.M3 r5 = (com.facebook.ads.redexgen.X.M3) r5
            r4 = 0
            com.facebook.ads.internal.view.FullScreenAdToolbar r0 = r5.A04
            r0.setToolbarListener(r4)
            r0 = 7
            goto L10
        L1e:
            com.facebook.ads.redexgen.X.M3 r5 = (com.facebook.ads.redexgen.X.M3) r5
            com.facebook.ads.internal.view.FullScreenAdToolbar r0 = r5.A04
            if (r0 == 0) goto L26
            r0 = 6
            goto L10
        L26:
            r0 = 7
            goto L10
        L28:
            com.facebook.ads.redexgen.X.M3 r5 = (com.facebook.ads.redexgen.X.M3) r5
            com.facebook.ads.redexgen.X.Gl r3 = r5.A0R
            com.facebook.ads.redexgen.X.2h r0 = r5.A0O
            java.lang.String r2 = r0.A0P()
            com.facebook.ads.redexgen.X.NS r1 = new com.facebook.ads.redexgen.X.NS
            r1.<init>()
            com.facebook.ads.redexgen.X.FP r0 = r5.A0e
            com.facebook.ads.redexgen.X.NS r1 = r1.A03(r0)
            com.facebook.ads.redexgen.X.K5 r0 = r5.A0U
            com.facebook.ads.redexgen.X.NS r0 = r1.A02(r0)
            java.util.Map r0 = r0.A05()
            r3.A5U(r2, r0)
            r0 = 5
            goto L10
        L4c:
            com.facebook.ads.redexgen.X.M3 r5 = (com.facebook.ads.redexgen.X.M3) r5
            com.facebook.ads.redexgen.X.2h r0 = r5.A0O
            java.lang.String r0 = r0.A0P()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L5c
            r0 = 4
            goto L10
        L5c:
            r0 = 5
            goto L10
        L5e:
            com.facebook.ads.redexgen.X.M3 r5 = (com.facebook.ads.redexgen.X.M3) r5
            com.facebook.ads.redexgen.X.Lb r0 = r5.A08
            com.facebook.ads.redexgen.X.GY r3 = r0.getEventBus()
            r0 = 5
            com.facebook.ads.redexgen.X.1S[] r2 = new com.facebook.ads.redexgen.X.C1S[r0]
            r1 = 0
            com.facebook.ads.redexgen.X.8s r0 = r5.A0W
            r2[r1] = r0
            r1 = 1
            com.facebook.ads.redexgen.X.8w r0 = r5.A0X
            r2[r1] = r0
            r1 = 2
            com.facebook.ads.redexgen.X.8k r0 = r5.A0Z
            r2[r1] = r0
            r1 = 3
            com.facebook.ads.redexgen.X.8m r0 = r5.A0Y
            r2[r1] = r0
            r1 = 4
            com.facebook.ads.redexgen.X.LH r0 = r5.A0a
            r2[r1] = r0
            r3.A04(r2)
            r0 = 3
            goto L10
        L87:
            r0 = 3
            goto L10
        L89:
            com.facebook.ads.redexgen.X.M3 r5 = (com.facebook.ads.redexgen.X.M3) r5
            com.facebook.ads.redexgen.X.QA r0 = r5.A0V
            r0.A0R()
            r5.A08 = r4
            r5.A05 = r4
            r5.A0B = r4
            r5.A03 = r4
            com.facebook.ads.redexgen.X.I6 r0 = r5.A0c
            r0.A09()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.M3.onDestroy():void");
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.A0U.A06(motionEvent, this, this);
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:            return;     */
    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onLayout(boolean r12, int r13, int r14, int r15, int r16) {
        /*
            r11 = this;
            r5 = r11
            r7 = r13
            r6 = r12
            r8 = r14
            r10 = r16
            r9 = r15
            super.onLayout(r6, r7, r8, r9, r10)
            boolean r0 = r5.A0g
            if (r0 == 0) goto L51
            r0 = 2
        Lf:
            switch(r0) {
                case 2: goto L13;
                case 3: goto L19;
                case 4: goto L23;
                case 5: goto L53;
                default: goto L12;
            }
        L12:
            goto Lf
        L13:
            if (r6 == 0) goto L17
            r0 = 3
            goto Lf
        L17:
            r0 = 5
            goto Lf
        L19:
            com.facebook.ads.redexgen.X.M3 r5 = (com.facebook.ads.redexgen.X.M3) r5
            com.facebook.ads.redexgen.X.Fg r0 = r5.A0D
            if (r0 != 0) goto L21
            r0 = 4
            goto Lf
        L21:
            r0 = 5
            goto Lf
        L23:
            com.facebook.ads.redexgen.X.M3 r5 = (com.facebook.ads.redexgen.X.M3) r5
            com.facebook.ads.redexgen.X.Fg r4 = new com.facebook.ads.redexgen.X.Fg
            com.facebook.ads.redexgen.X.NW r0 = r5.A05
            com.facebook.ads.redexgen.X.Nh r0 = (com.facebook.ads.redexgen.X.C0594Nh) r0
            android.view.View r3 = r0.getExpandableLayout()
            r2 = 300(0x12c, float:4.2E-43)
            com.facebook.ads.redexgen.X.NW r0 = r5.A05
            com.facebook.ads.redexgen.X.Nh r0 = (com.facebook.ads.redexgen.X.C0594Nh) r0
            android.view.View r0 = r0.getExpandableLayout()
            int r1 = r0.getHeight()
            r0 = 0
            r4.<init>(r3, r2, r1, r0)
            r5.A0D = r4
            com.facebook.ads.redexgen.X.Qs r1 = r5.A0A
            com.facebook.ads.redexgen.X.Fg r0 = r5.A0D
            r1.A0I(r0)
            com.facebook.ads.redexgen.X.Qs r0 = r5.A0A
            r0.A0G()
            r0 = 5
            goto Lf
        L51:
            r0 = 5
            goto Lf
        L53:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.M3.onLayout(boolean, int, int, int, int):void");
    }

    public void setListener(AnonymousClass81 anonymousClass81) {
    }

    @VisibleForTesting
    public void setServerSideRewardHandler(C0647Pj c0647Pj) {
        this.A07 = c0647Pj;
    }

    private void setUpContentLayoutForVideo(int i) {
        this.A0M.removeAllViews();
        A0H();
        this.A0M.addView(this.A08, A0p);
        if (this.A05 != null) {
            this.A05.A09(false);
            KE.A0N(this.A05);
            this.A05.A08(i);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.A05.setPadding(A0o, A0o, A0o, A0o);
            this.A0M.addView(this.A05, layoutParams);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(A0n, A0n);
        layoutParams2.addRule(10);
        layoutParams2.addRule(11);
        layoutParams2.setMargins(A0l, A0l + getToolbarHeight(), A0l, A0m);
        this.A0M.addView(this.A0b, layoutParams2);
        A0P();
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, this.A0g ? A0t : -2);
        if (this.A0g) {
            this.A0c.setPadding(A0u, A0u, A0u, A0u);
            this.A0c.A0A(-1, A0r);
        }
        layoutParams3.addRule(12);
        this.A0M.addView(this.A0c, layoutParams3);
    }
}
