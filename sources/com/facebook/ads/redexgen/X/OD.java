package com.facebook.ads.redexgen.X;

import android.R;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.HashMap;

/* loaded from: assets/audience_network.dex */
public final class OD extends AbstractC0604Nr {

    @Nullable
    public static OD A0O;
    public static byte[] A0P;
    public static final int A0Q;
    public static final int A0R;
    public static final int A0S;
    public static final int A0T;
    public static final int A0U;
    public float A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public View A06;
    public LinearLayout A07;
    public LinearLayout A08;
    public TextView A09;
    public C2I A0A;
    public N3 A0B;
    public N4 A0C;

    @Nullable
    public NE A0D;
    public C0610Nx A0E;
    public OG A0F;
    public boolean A0G;
    public boolean A0H;
    public boolean A0I;
    public boolean A0J;
    public final View A0K;
    public final AnonymousClass11 A0L;
    public final C0432Gv A0M;
    public final I6 A0N;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A0C(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.OD.A0P
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
            r0 = r0 ^ 15
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.OD.A0C(int, int, int):java.lang.String");
    }

    public static void A0L() {
        A0P = new byte[]{21};
    }

    static {
        A0L();
        A0S = (int) (26.0f * KE.A01);
        A0Q = (int) (4.0f * KE.A01);
        A0U = (int) (KE.A01 * 8.0f);
        A0R = C4G.A01(-1, 77);
        A0T = (int) (12.0f * KE.A01);
        A0O = null;
    }

    public OD(C0610Nx c0610Nx, C2T c2t, boolean z) {
        super(c0610Nx, c2t, true);
        this.A01 = 0;
        this.A0G = false;
        this.A0I = false;
        this.A0J = false;
        this.A0E = c0610Nx;
        this.A0A = this.A0E.A04();
        this.A0M = new C0432Gv(c0610Nx.A04().A0P(), c0610Nx.A06());
        this.A0N = this.A0E.A0A();
        if (this.A0N != null) {
            KE.A0N(this.A0N);
        }
        this.A0K = this.A0E.A03();
        this.A0L = AnonymousClass12.A01(c0610Nx.A05(), c0610Nx.A06(), c0610Nx.A04().A0P(), Uri.parse(c0610Nx.A04().A0L().A0F().A04()), new HashMap(), false, true);
        C0602Np.A00(c0610Nx.A05(), this, c0610Nx.A04().A0L().A0D().A06());
        setupLayoutConfiguration(z);
        setUpWatchContent(c2t);
        A0E();
        A0F();
        postDelayed(new O5(this), 1000L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0047, code lost:            com.facebook.ads.redexgen.X.OD.A0O.A0H();        com.facebook.ads.redexgen.X.OD.A0O.A0G();        com.facebook.ads.redexgen.X.OD.A0O.A0I();     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005a, code lost:            return com.facebook.ads.redexgen.X.OD.A0O;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.OD A0A(com.facebook.ads.redexgen.X.C0610Nx r2, com.facebook.ads.redexgen.X.C2T r3, boolean r4) {
        /*
            com.facebook.ads.redexgen.X.OD r0 = com.facebook.ads.redexgen.X.OD.A0O
            if (r0 == 0) goto L45
            r0 = 2
        L5:
            switch(r0) {
                case 2: goto L9;
                case 3: goto L2b;
                case 4: goto L47;
                case 5: goto L38;
                default: goto L8;
            }
        L8:
            goto L5
        L9:
            com.facebook.ads.redexgen.X.Nx r2 = (com.facebook.ads.redexgen.X.C0610Nx) r2
            com.facebook.ads.redexgen.X.OD r0 = com.facebook.ads.redexgen.X.OD.A0O
            java.lang.String r1 = r0.getUrl()
            com.facebook.ads.redexgen.X.2I r0 = r2.A04()
            com.facebook.ads.redexgen.X.2L r0 = r0.A0L()
            com.facebook.ads.redexgen.X.2U r0 = r0.A0F()
            java.lang.String r0 = r0.A04()
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L29
            r0 = 3
            goto L5
        L29:
            r0 = 5
            goto L5
        L2b:
            com.facebook.ads.redexgen.X.Nx r2 = (com.facebook.ads.redexgen.X.C0610Nx) r2
            com.facebook.ads.redexgen.X.2T r3 = (com.facebook.ads.redexgen.X.C2T) r3
            com.facebook.ads.redexgen.X.OD r0 = new com.facebook.ads.redexgen.X.OD
            r0.<init>(r2, r3, r4)
            com.facebook.ads.redexgen.X.OD.A0O = r0
            r0 = 4
            goto L5
        L38:
            com.facebook.ads.redexgen.X.Nx r2 = (com.facebook.ads.redexgen.X.C0610Nx) r2
            com.facebook.ads.redexgen.X.OD r0 = com.facebook.ads.redexgen.X.OD.A0O
            r0.A0E = r2
            com.facebook.ads.redexgen.X.OD r0 = com.facebook.ads.redexgen.X.OD.A0O
            r0.A0R(r4)
            r0 = 4
            goto L5
        L45:
            r0 = 3
            goto L5
        L47:
            com.facebook.ads.redexgen.X.OD r0 = com.facebook.ads.redexgen.X.OD.A0O
            r0.A0H()
            com.facebook.ads.redexgen.X.OD r0 = com.facebook.ads.redexgen.X.OD.A0O
            r0.A0G()
            com.facebook.ads.redexgen.X.OD r0 = com.facebook.ads.redexgen.X.OD.A0O
            r0.A0I()
            com.facebook.ads.redexgen.X.OD r0 = com.facebook.ads.redexgen.X.OD.A0O
            com.facebook.ads.redexgen.X.OD r0 = (com.facebook.ads.redexgen.X.OD) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.OD.A0A(com.facebook.ads.redexgen.X.Nx, com.facebook.ads.redexgen.X.2T, boolean):com.facebook.ads.redexgen.X.OD");
    }

    private void A0D() {
        KE.A0L(this.A08);
        this.A08 = new LinearLayout(this.A0E.A05());
        KE.A0M(this.A08);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.A0G ? this.A02 / 4 : this.A02 / 5);
        layoutParams.addRule(12);
        this.A08.setLayoutParams(layoutParams);
        addView(this.A08, 2);
    }

    private void A0E() {
        KE.A0L(this.A07);
        this.A07 = new LinearLayout(this.A0E.A05());
        this.A07.setOrientation(1);
        KE.A0N(this.A07);
        A0J();
        this.A07.setBackgroundColor(-1);
        addView(this.A07);
    }

    private void A0F() {
        KE.A0L(this.A0B);
        this.A0B = new N3(this.A0E.A05());
        KE.A0N(this.A0B);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.weight = 0.1f;
        this.A0B.setListener(new O7(this));
        this.A0B.setOnTouchListener(new O8(this));
        this.A07.addView(this.A0B, layoutParams);
        KE.A0L(this.A0C);
        this.A0C = new N4(this.A0E.A05(), null, R.attr.progressBarStyleHorizontal);
        this.A07.addView(this.A0C, new LinearLayout.LayoutParams(-1, A0Q));
    }

    private void A0G() {
        if (this.A0K != null) {
            KE.A0L(this.A0K);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(AbstractC0604Nr.A06, AbstractC0604Nr.A06);
            layoutParams.addRule(10);
            layoutParams.addRule(11);
            layoutParams.setMargins(AbstractC0604Nr.A05, this.A05, AbstractC0604Nr.A05, AbstractC0604Nr.A05);
            addView(this.A0K, layoutParams);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0064, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0H() {
        /*
            r7 = this;
            r4 = r7
            r2 = 0
            r0 = 0
            r3 = -1
            com.facebook.ads.redexgen.X.I6 r0 = r4.A0N
            if (r0 == 0) goto L62
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L3d;
                case 4: goto L4e;
                case 5: goto L64;
                case 6: goto L59;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.OD r4 = (com.facebook.ads.redexgen.X.OD) r4
            com.facebook.ads.redexgen.X.I6 r0 = r4.A0N
            com.facebook.ads.redexgen.X.KE.A0L(r0)
            com.facebook.ads.redexgen.X.I6 r6 = r4.A0N
            int r5 = com.facebook.ads.redexgen.X.OD.A0T
            int r2 = com.facebook.ads.redexgen.X.OD.A0T
            int r1 = com.facebook.ads.redexgen.X.OD.A0T
            int r0 = com.facebook.ads.redexgen.X.OD.A0T
            r6.setPadding(r5, r2, r1, r0)
            com.facebook.ads.redexgen.X.I6 r1 = r4.A0N
            int r0 = com.facebook.ads.redexgen.X.OD.A0R
            r1.A0A(r3, r0)
            com.facebook.ads.redexgen.X.I6 r1 = r4.A0N
            r0 = 0
            r1.setTranslationY(r0)
            android.widget.RelativeLayout$LayoutParams r2 = new android.widget.RelativeLayout$LayoutParams
            int r0 = com.facebook.ads.redexgen.X.OD.A0S
            r2.<init>(r3, r0)
            boolean r0 = r4.A0H
            if (r0 == 0) goto L3b
            r0 = 3
            goto L9
        L3b:
            r0 = 6
            goto L9
        L3d:
            com.facebook.ads.redexgen.X.OD r4 = (com.facebook.ads.redexgen.X.OD) r4
            android.widget.RelativeLayout$LayoutParams r2 = (android.widget.RelativeLayout.LayoutParams) r2
            r1 = 8
            android.view.View r0 = r4.A06
            int r0 = r0.getId()
            r2.addRule(r1, r0)
            r0 = 4
            goto L9
        L4e:
            com.facebook.ads.redexgen.X.OD r4 = (com.facebook.ads.redexgen.X.OD) r4
            android.widget.RelativeLayout$LayoutParams r2 = (android.widget.RelativeLayout.LayoutParams) r2
            com.facebook.ads.redexgen.X.I6 r0 = r4.A0N
            r4.addView(r0, r2)
            r0 = 5
            goto L9
        L59:
            android.widget.RelativeLayout$LayoutParams r2 = (android.widget.RelativeLayout.LayoutParams) r2
            r0 = 12
            r2.addRule(r0)
            r0 = 4
            goto L9
        L62:
            r0 = 5
            goto L9
        L64:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.OD.A0H():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0035, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0I() {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.Nx r0 = r3.A0E
            com.facebook.ads.internal.view.FullScreenAdToolbar r1 = r0.A09()
            if (r1 != 0) goto L33
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L35;
                case 3: goto L26;
                case 4: goto L1a;
                case 5: goto L17;
                case 6: goto L10;
                case 7: goto L30;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            com.facebook.ads.internal.view.FullScreenAdToolbar r1 = (com.facebook.ads.internal.view.FullScreenAdToolbar) r1
            r1.setPageDetailsVisible(r2)
            r0 = 2
            goto Lc
        L17:
            r2 = 1
            r0 = 6
            goto Lc
        L1a:
            com.facebook.ads.internal.view.FullScreenAdToolbar r1 = (com.facebook.ads.internal.view.FullScreenAdToolbar) r1
            boolean r0 = r1.A05()
            if (r0 != 0) goto L24
            r0 = 5
            goto Lc
        L24:
            r0 = 7
            goto Lc
        L26:
            com.facebook.ads.redexgen.X.OD r3 = (com.facebook.ads.redexgen.X.OD) r3
            boolean r0 = r3.A0H
            if (r0 != 0) goto L2e
            r0 = 4
            goto Lc
        L2e:
            r0 = 7
            goto Lc
        L30:
            r2 = 0
            r0 = 6
            goto Lc
        L33:
            r0 = 3
            goto Lc
        L35:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.OD.A0I():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003f, code lost:            r3 = r3;        r3.A07.setTranslationY(0.0f);        r3.A07.setLayoutParams(r2);     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004e, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A0J() {
        /*
            r4 = this;
            r3 = r4
            r0 = 0
            r0 = 0
            r0 = 0
            android.widget.RelativeLayout$LayoutParams r2 = new android.widget.RelativeLayout$LayoutParams
            r1 = -1
            int r0 = r3.A03
            int r0 = r0 * 4
            int r0 = r0 / 5
            r2.<init>(r1, r0)
            boolean r0 = r3.A0a()
            if (r0 == 0) goto L3d
            r0 = 2
        L17:
            switch(r0) {
                case 2: goto L1b;
                case 3: goto L3f;
                case 4: goto L2f;
                default: goto L1a;
            }
        L1a:
            goto L17
        L1b:
            com.facebook.ads.redexgen.X.OD r3 = (com.facebook.ads.redexgen.X.OD) r3
            android.widget.RelativeLayout$LayoutParams r2 = (android.widget.RelativeLayout.LayoutParams) r2
            r0 = 0
            r2.setMargins(r0, r0, r0, r0)
            r0 = 12
            r2.addRule(r0)
            android.widget.LinearLayout r0 = r3.A07
            r0.setLayoutParams(r2)
            r0 = 3
            goto L17
        L2f:
            com.facebook.ads.redexgen.X.OD r3 = (com.facebook.ads.redexgen.X.OD) r3
            android.widget.RelativeLayout$LayoutParams r2 = (android.widget.RelativeLayout.LayoutParams) r2
            r1 = 0
            int r0 = r3.A03
            int r0 = r0 + 1
            r2.setMargins(r1, r0, r1, r1)
            r0 = 3
            goto L17
        L3d:
            r0 = 4
            goto L17
        L3f:
            com.facebook.ads.redexgen.X.OD r3 = (com.facebook.ads.redexgen.X.OD) r3
            android.widget.RelativeLayout$LayoutParams r2 = (android.widget.RelativeLayout.LayoutParams) r2
            android.widget.LinearLayout r1 = r3.A07
            r0 = 0
            r1.setTranslationY(r0)
            android.widget.LinearLayout r0 = r3.A07
            r0.setLayoutParams(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.OD.A0J():void");
    }

    private void A0K() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.A0G ? this.A02 / 4 : this.A02 / 5);
        layoutParams.addRule(14);
        layoutParams.addRule(2, this.A09.getId());
        layoutParams.setMargins(0, 0, 0, 0);
        this.A0F.setLayoutParams(layoutParams);
        if (!this.A0A.A0e()) {
            KE.A0L(this.A0F);
            addView(this.A0F, 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0P(String str) {
        KE.A0L(this.A0D);
        this.A0D = new NE(this.A0E.A05(), new O9(this));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 0.9f;
        this.A07.addView(this.A0D, layoutParams);
        this.A0D.loadUrl(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0251, code lost:            r15 = r15;        r15.addListener(new com.facebook.ads.redexgen.X.OC(r14, r32));        r15.start();     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0260, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A0Q(boolean r32) {
        /*
            Method dump skipped, instructions count: 666
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.OD.A0Q(boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0050, code lost:            r3 = r3;        r3.A06.setTranslationY(0.0f);        r3.addView(r3.A06, 1, r2);        r3.A0D();        r3.A0K();     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0066, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0R(boolean r5) {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            r0 = 0
            r1 = -1
            r3.setupLayoutConfiguration(r5)
            android.view.View r0 = r3.A06
            com.facebook.ads.redexgen.X.KE.A0L(r0)
            com.facebook.ads.redexgen.X.Nx r0 = r3.A0E
            android.view.View r0 = r0.A02()
            r3.A06 = r0
            android.view.View r0 = r3.A06
            com.facebook.ads.redexgen.X.KE.A0N(r0)
            boolean r0 = r3.A0H
            if (r0 == 0) goto L4e
            r0 = 2
        L1e:
            switch(r0) {
                case 2: goto L22;
                case 3: goto L50;
                case 4: goto L39;
                default: goto L21;
            }
        L21:
            goto L1e
        L22:
            com.facebook.ads.redexgen.X.OD r3 = (com.facebook.ads.redexgen.X.OD) r3
            android.widget.RelativeLayout$LayoutParams r2 = new android.widget.RelativeLayout$LayoutParams
            int r0 = r3.A03
            int r0 = r0 / 5
            r2.<init>(r1, r0)
            r0 = 14
            r2.addRule(r0)
            r0 = 10
            r2.addRule(r0)
            r0 = 3
            goto L1e
        L39:
            com.facebook.ads.redexgen.X.OD r3 = (com.facebook.ads.redexgen.X.OD) r3
            android.widget.RelativeLayout$LayoutParams r2 = new android.widget.RelativeLayout$LayoutParams
            r0 = -2
            r2.<init>(r1, r0)
            r0 = 13
            r2.addRule(r0)
            r3.A0E()
            r3.A0F()
            r0 = 3
            goto L1e
        L4e:
            r0 = 4
            goto L1e
        L50:
            com.facebook.ads.redexgen.X.OD r3 = (com.facebook.ads.redexgen.X.OD) r3
            android.widget.RelativeLayout$LayoutParams r2 = (android.widget.RelativeLayout.LayoutParams) r2
            android.view.View r1 = r3.A06
            r0 = 0
            r1.setTranslationY(r0)
            android.view.View r1 = r3.A06
            r0 = 1
            r3.addView(r1, r0, r2)
            r3.A0D()
            r3.A0K()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.OD.A0R(boolean):void");
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0604Nr
    public final void A0U() {
        super.A0U();
        A0O = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0037, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.AbstractC0604Nr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0V() {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.Nx r0 = r3.A0E
            com.facebook.ads.internal.view.FullScreenAdToolbar r1 = r0.A09()
            if (r1 == 0) goto L35
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L29;
                case 3: goto L17;
                case 4: goto L23;
                case 5: goto L10;
                case 6: goto L37;
                case 7: goto L26;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            com.facebook.ads.internal.view.FullScreenAdToolbar r1 = (com.facebook.ads.internal.view.FullScreenAdToolbar) r1
            r1.setPageDetailsVisible(r2)
            r0 = 6
            goto Lc
        L17:
            com.facebook.ads.internal.view.FullScreenAdToolbar r1 = (com.facebook.ads.internal.view.FullScreenAdToolbar) r1
            boolean r0 = r1.A05()
            if (r0 != 0) goto L21
            r0 = 4
            goto Lc
        L21:
            r0 = 7
            goto Lc
        L23:
            r2 = 1
            r0 = 5
            goto Lc
        L26:
            r2 = 0
            r0 = 5
            goto Lc
        L29:
            com.facebook.ads.redexgen.X.OD r3 = (com.facebook.ads.redexgen.X.OD) r3
            boolean r0 = r3.A0a()
            if (r0 != 0) goto L33
            r0 = 3
            goto Lc
        L33:
            r0 = 7
            goto Lc
        L35:
            r0 = 6
            goto Lc
        L37:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.OD.A0V():void");
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0604Nr
    public final void A0W() {
        if (this.A0E.A09() != null) {
            this.A0E.A09().setPageDetailsVisible(false);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0604Nr
    public final void A0X() {
        this.A0J = false;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0604Nr
    public final void A0Y() {
        this.A0J = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0071, code lost:            r5.A01 = r4;     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0075, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.AbstractC0604Nr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0Z(com.facebook.ads.redexgen.X.C2L r12, java.lang.String r13, double r14, @android.support.annotation.Nullable android.os.Bundle r16) {
        /*
            r11 = this;
            r5 = r11
            r4 = 0
            r0 = 0
            r7 = r13
            r6 = r12
            r10 = r16
            r8 = r14
            super.A0Z(r6, r7, r8, r10)
            com.facebook.ads.redexgen.X.2S r0 = r6.A0E()
            java.lang.String r3 = r0.A05()
            if (r3 == 0) goto L6f
            r0 = 2
        L16:
            switch(r0) {
                case 2: goto L45;
                case 3: goto L30;
                case 4: goto L3b;
                case 5: goto L25;
                case 6: goto L1a;
                case 7: goto L61;
                case 8: goto L71;
                case 9: goto L68;
                case 10: goto L56;
                default: goto L19;
            }
        L19:
            goto L16
        L1a:
            com.facebook.ads.redexgen.X.OD r5 = (com.facebook.ads.redexgen.X.OD) r5
            boolean r0 = r5.A0G
            if (r0 == 0) goto L22
            r0 = 7
            goto L16
        L22:
            r0 = 9
            goto L16
        L25:
            com.facebook.ads.redexgen.X.OD r5 = (com.facebook.ads.redexgen.X.OD) r5
            int r0 = r5.A04
            double r1 = (double) r0
            double r1 = r1 / r8
            int r0 = (int) r1
            r5.A01 = r0
            r0 = 6
            goto L16
        L30:
            com.facebook.ads.redexgen.X.OD r5 = (com.facebook.ads.redexgen.X.OD) r5
            android.widget.LinearLayout r1 = r5.A08
            r0 = 8
            com.facebook.ads.redexgen.X.KE.A0Q(r1, r0)
            r0 = 4
            goto L16
        L3b:
            r1 = 0
            int r0 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r0 <= 0) goto L43
            r0 = 5
            goto L16
        L43:
            r0 = 6
            goto L16
        L45:
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r0 = r3.trim()
            int r0 = r0.length()
            if (r0 != 0) goto L53
            r0 = 3
            goto L16
        L53:
            r0 = 10
            goto L16
        L56:
            com.facebook.ads.redexgen.X.OD r5 = (com.facebook.ads.redexgen.X.OD) r5
            java.lang.String r3 = (java.lang.String) r3
            android.widget.TextView r0 = r5.A09
            r0.setText(r3)
            r0 = 4
            goto L16
        L61:
            com.facebook.ads.redexgen.X.OD r5 = (com.facebook.ads.redexgen.X.OD) r5
            int r4 = r5.A02
            r0 = 8
            goto L16
        L68:
            com.facebook.ads.redexgen.X.OD r5 = (com.facebook.ads.redexgen.X.OD) r5
            int r4 = r5.A01
            r0 = 8
            goto L16
        L6f:
            r0 = 3
            goto L16
        L71:
            com.facebook.ads.redexgen.X.OD r5 = (com.facebook.ads.redexgen.X.OD) r5
            r5.A01 = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.OD.A0Z(com.facebook.ads.redexgen.X.2L, java.lang.String, double, android.os.Bundle):void");
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0604Nr
    public final boolean A0a() {
        return this.A0H;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0604Nr
    public final boolean A0b() {
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0604Nr
    public final boolean A0c(boolean z) {
        if (!A0a()) {
            return false;
        }
        A0Q(false);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0027, code lost:            return r1;     */
    @Override // com.facebook.ads.redexgen.X.AbstractC0604Nr
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
            boolean r0 = r2.A0a()
            if (r0 == 0) goto L25
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L27;
                case 4: goto L10;
                case 5: goto L1a;
                case 6: goto L1d;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            r1 = 3
            r0 = 3
            goto L9
        L10:
            com.facebook.ads.redexgen.X.OD r2 = (com.facebook.ads.redexgen.X.OD) r2
            boolean r0 = r2.A0J
            if (r0 == 0) goto L18
            r0 = 5
            goto L9
        L18:
            r0 = 6
            goto L9
        L1a:
            r1 = 2
            r0 = 3
            goto L9
        L1d:
            com.facebook.ads.redexgen.X.OD r2 = (com.facebook.ads.redexgen.X.OD) r2
            int r1 = super.getCloseButtonStyle()
            r0 = 3
            goto L9
        L25:
            r0 = 4
            goto L9
        L27:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.OD.getCloseButtonStyle():int");
    }

    private String getUrl() {
        return this.A0E.A04().A0L().A0F().A04();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.A0A.A0e()) {
            A0A(this.A0E, null, A0a());
        }
        setupLayoutConfiguration(A0a());
        A0J();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0078, code lost:            r4 = r7;        r5 = r5;        r5.setMargins(r3, r2, r1, r6);        r4.addView(r4.A09, r5);        com.facebook.ads.redexgen.X.KE.A0N(r4.A09);        r4.A0F = new com.facebook.ads.redexgen.X.OG(r4.A0E, r4.A0E.A04().A0L().A0F().A03(), r8, new com.facebook.ads.redexgen.X.O6(r4));        com.facebook.ads.redexgen.X.KE.A0I(1001, r4.A0F);        r4.addView(r4.A0F);        r4.A0K();        r4.A0D();     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00be, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void setUpWatchContent(com.facebook.ads.redexgen.X.C2T r8) {
        /*
            r7 = this;
            r6 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            r4 = 1
            r3 = -1
            r2 = -2
            com.facebook.ads.redexgen.X.Nx r0 = r7.A0E
            android.view.View r0 = r0.A02()
            r7.A06 = r0
            android.view.View r0 = r7.A06
            com.facebook.ads.redexgen.X.KE.A0N(r0)
            android.widget.RelativeLayout$LayoutParams r1 = new android.widget.RelativeLayout$LayoutParams
            r1.<init>(r3, r2)
            r0 = 15
            r1.addRule(r0)
            android.view.View r0 = r7.A06
            r7.addView(r0, r4, r1)
            android.widget.TextView r1 = new android.widget.TextView
            com.facebook.ads.redexgen.X.Nx r0 = r7.A0E
            com.facebook.ads.redexgen.X.Ec r0 = r0.A05()
            r1.<init>(r0)
            r7.A09 = r1
            android.widget.TextView r0 = r7.A09
            com.facebook.ads.redexgen.X.KE.A0N(r0)
            android.widget.TextView r1 = r7.A09
            r0 = 17
            r1.setGravity(r0)
            android.widget.TextView r1 = r7.A09
            int r0 = r8.A05(r4)
            r1.setTextColor(r0)
            android.widget.TextView r1 = r7.A09
            android.text.TextUtils$TruncateAt r0 = android.text.TextUtils.TruncateAt.END
            r1.setEllipsize(r0)
            android.widget.TextView r1 = r7.A09
            r0 = 2
            r1.setMaxLines(r0)
            android.widget.RelativeLayout$LayoutParams r5 = new android.widget.RelativeLayout$LayoutParams
            r5.<init>(r3, r2)
            r0 = 12
            r5.addRule(r0)
            int r3 = com.facebook.ads.redexgen.X.OD.A0U
            int r0 = com.facebook.ads.redexgen.X.OD.A0U
            int r2 = r0 / 2
            int r1 = com.facebook.ads.redexgen.X.OD.A0U
            com.facebook.ads.redexgen.X.I6 r0 = r7.A0N
            if (r0 != 0) goto L76
            r0 = 2
        L6a:
            switch(r0) {
                case 2: goto L6e;
                case 3: goto L78;
                case 4: goto L72;
                default: goto L6d;
            }
        L6d:
            goto L6a
        L6e:
            int r6 = com.facebook.ads.redexgen.X.OD.A0U
            r0 = 3
            goto L6a
        L72:
            int r6 = com.facebook.ads.redexgen.X.OD.A0S
            r0 = 3
            goto L6a
        L76:
            r0 = 4
            goto L6a
        L78:
            r4 = r7
            com.facebook.ads.redexgen.X.OD r4 = (com.facebook.ads.redexgen.X.OD) r4
            com.facebook.ads.redexgen.X.2T r8 = (com.facebook.ads.redexgen.X.C2T) r8
            android.widget.RelativeLayout$LayoutParams r5 = (android.widget.RelativeLayout.LayoutParams) r5
            r5.setMargins(r3, r2, r1, r6)
            android.widget.TextView r0 = r4.A09
            r4.addView(r0, r5)
            android.widget.TextView r0 = r4.A09
            com.facebook.ads.redexgen.X.KE.A0N(r0)
            com.facebook.ads.redexgen.X.OG r3 = new com.facebook.ads.redexgen.X.OG
            com.facebook.ads.redexgen.X.Nx r2 = r4.A0E
            com.facebook.ads.redexgen.X.Nx r0 = r4.A0E
            com.facebook.ads.redexgen.X.2I r0 = r0.A04()
            com.facebook.ads.redexgen.X.2L r0 = r0.A0L()
            com.facebook.ads.redexgen.X.2U r0 = r0.A0F()
            java.lang.String r1 = r0.A03()
            com.facebook.ads.redexgen.X.O6 r0 = new com.facebook.ads.redexgen.X.O6
            r0.<init>(r4)
            r3.<init>(r2, r1, r8, r0)
            r4.A0F = r3
            r1 = 1001(0x3e9, float:1.403E-42)
            com.facebook.ads.redexgen.X.OG r0 = r4.A0F
            com.facebook.ads.redexgen.X.KE.A0I(r1, r0)
            com.facebook.ads.redexgen.X.OG r0 = r4.A0F
            r4.addView(r0)
            r4.A0K()
            r4.A0D()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.OD.setUpWatchContent(com.facebook.ads.redexgen.X.2T):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0090, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void setupLayoutConfiguration(boolean r8) {
        /*
            r7 = this;
            r3 = r7
            r5 = 0
            r4 = 0
            r0 = 0
            r2 = 0
            r1 = 0
            android.content.res.Resources r0 = r3.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            int r6 = r0.orientation
            r0 = 2
            if (r6 != r0) goto L8d
            r0 = 2
        L14:
            switch(r0) {
                case 2: goto L80;
                case 3: goto L61;
                case 4: goto L5d;
                case 5: goto L2b;
                case 6: goto L18;
                case 7: goto L54;
                case 8: goto L90;
                case 9: goto L83;
                case 10: goto L72;
                case 11: goto L89;
                default: goto L17;
            }
        L17:
            goto L14
        L18:
            com.facebook.ads.redexgen.X.OD r3 = (com.facebook.ads.redexgen.X.OD) r3
            int r0 = r5 + r1
            r3.A03 = r0
            com.facebook.ads.redexgen.X.2I r0 = r3.A0A
            boolean r0 = r0.A0e()
            if (r0 == 0) goto L28
            r0 = 7
            goto L14
        L28:
            r0 = 8
            goto L14
        L2b:
            com.facebook.ads.redexgen.X.OD r3 = (com.facebook.ads.redexgen.X.OD) r3
            r3.A05 = r4
            r3.A0H = r8
            android.content.res.Resources r0 = android.content.res.Resources.getSystem()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            int r0 = r0.heightPixels
            r3.A02 = r0
            android.content.res.Resources r0 = android.content.res.Resources.getSystem()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            int r0 = r0.widthPixels
            r3.A04 = r0
            int r5 = r3.A02
            boolean r0 = r3.A0G
            if (r0 == 0) goto L51
            r0 = 6
            goto L14
        L51:
            r0 = 9
            goto L14
        L54:
            com.facebook.ads.redexgen.X.OD r3 = (com.facebook.ads.redexgen.X.OD) r3
            int r0 = r3.A02
            r3.A01 = r0
            r0 = 8
            goto L14
        L5d:
            r1 = 0
            r4 = r1
            r0 = 5
            goto L14
        L61:
            com.facebook.ads.redexgen.X.OD r3 = (com.facebook.ads.redexgen.X.OD) r3
            r3.A0G = r2
            com.facebook.ads.redexgen.X.Nx r0 = r3.A0E
            com.facebook.ads.internal.view.FullScreenAdToolbar r0 = r0.A09()
            if (r0 != 0) goto L6f
            r0 = 4
            goto L14
        L6f:
            r0 = 10
            goto L14
        L72:
            com.facebook.ads.redexgen.X.OD r3 = (com.facebook.ads.redexgen.X.OD) r3
            com.facebook.ads.redexgen.X.Nx r0 = r3.A0E
            com.facebook.ads.internal.view.FullScreenAdToolbar r0 = r0.A09()
            int r4 = r0.getToolbarHeight()
            r0 = 5
            goto L14
        L80:
            r2 = 1
            r0 = 3
            goto L14
        L83:
            com.facebook.ads.redexgen.X.OD r3 = (com.facebook.ads.redexgen.X.OD) r3
            int r1 = r3.A05
            r0 = 6
            goto L14
        L89:
            r1 = 0
            r2 = r1
            r0 = 3
            goto L14
        L8d:
            r0 = 11
            goto L14
        L90:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.OD.setupLayoutConfiguration(boolean):void");
    }
}
