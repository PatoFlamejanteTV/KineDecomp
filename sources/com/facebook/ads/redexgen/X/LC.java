package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.view.FullScreenAdToolbar;
import com.facebook.ads.internal.view.ToolbarActionView$ToolbarActionMode;

/* loaded from: assets/audience_network.dex */
public abstract class LC extends RelativeLayout implements InterfaceC0524Ko {
    public View A00;

    @Nullable
    public JW A01;

    @Nullable
    public C0633Ov A02;
    public boolean A03;
    public boolean A04;
    public boolean A05;
    public C2J A06;
    public final ViewOnSystemUiVisibilityChangeListenerC0509Jz A07;
    public final AnonymousClass81 A08;
    public final C2W A09;
    public final C0362Ec A0A;
    public final InterfaceC0422Gl A0B;
    public final C0432Gv A0C;
    public final FullScreenAdToolbar A0D;

    public abstract void A0S();

    public abstract boolean A0T();

    @ToolbarActionView$ToolbarActionMode
    public abstract int getCloseButtonStyle();

    public LC(C0362Ec c0362Ec, InterfaceC0422Gl interfaceC0422Gl, AnonymousClass81 anonymousClass81, C2W c2w) {
        super(c0362Ec);
        this.A04 = false;
        this.A03 = false;
        this.A0A = c0362Ec;
        this.A0B = interfaceC0422Gl;
        this.A08 = anonymousClass81;
        this.A07 = new ViewOnSystemUiVisibilityChangeListenerC0509Jz(this);
        this.A09 = c2w;
        this.A0C = new C0432Gv(this.A09.A0P(), this.A0B);
        this.A05 = (this instanceof LO) || ((this instanceof LD) && C0413Gc.A18(c0362Ec));
        this.A0D = new FullScreenAdToolbar(this.A0A, getAudienceNetworkListener(), this.A0C, 0, this.A09.A0D());
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0024, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.facebook.ads.redexgen.X.C2T A00(int r4) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            r0 = 1
            if (r4 != r0) goto L1e
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L20;
                case 4: goto L14;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.LC r2 = (com.facebook.ads.redexgen.X.LC) r2
            com.facebook.ads.redexgen.X.2J r0 = r2.A06
            com.facebook.ads.redexgen.X.2T r1 = r0.A01()
            r0 = 3
            goto L6
        L14:
            com.facebook.ads.redexgen.X.LC r2 = (com.facebook.ads.redexgen.X.LC) r2
            com.facebook.ads.redexgen.X.2J r0 = r2.A06
            com.facebook.ads.redexgen.X.2T r1 = r0.A00()
            r0 = 3
            goto L6
        L1e:
            r0 = 4
            goto L6
        L20:
            com.facebook.ads.redexgen.X.2T r1 = (com.facebook.ads.redexgen.X.C2T) r1
            com.facebook.ads.redexgen.X.2T r1 = (com.facebook.ads.redexgen.X.C2T) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.LC.A00(int):com.facebook.ads.redexgen.X.2T");
    }

    private void A01() {
        removeAllViews();
        KE.A0L(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0085, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A02() {
        /*
            r8 = this;
            r5 = r8
            r0 = 0
            r0 = 0
            r0 = 0
            r4 = 1
            r0 = 0
            r0 = -1
            android.widget.RelativeLayout$LayoutParams r3 = new android.widget.RelativeLayout$LayoutParams
            r3.<init>(r0, r0)
            boolean r0 = r5.A0C()
            if (r0 == 0) goto L83
            r0 = 2
        L13:
            switch(r0) {
                case 2: goto L17;
                case 3: goto L21;
                case 4: goto L85;
                case 5: goto L74;
                default: goto L16;
            }
        L16:
            goto L13
        L17:
            com.facebook.ads.redexgen.X.LC r5 = (com.facebook.ads.redexgen.X.LC) r5
            com.facebook.ads.redexgen.X.Ov r0 = r5.A02
            if (r0 != 0) goto L1f
            r0 = 3
            goto L13
        L1f:
            r0 = 5
            goto L13
        L21:
            com.facebook.ads.redexgen.X.LC r5 = (com.facebook.ads.redexgen.X.LC) r5
            android.widget.RelativeLayout$LayoutParams r3 = (android.widget.RelativeLayout.LayoutParams) r3
            r6 = 0
            r5.A04 = r4
            com.facebook.ads.redexgen.X.Ou r7 = new com.facebook.ads.redexgen.X.Ou
            com.facebook.ads.redexgen.X.Ec r2 = r5.A0A
            com.facebook.ads.redexgen.X.2W r0 = r5.A09
            com.facebook.ads.redexgen.X.2L r0 = r0.A0L()
            com.facebook.ads.redexgen.X.2S r1 = r0.A0E()
            com.facebook.ads.redexgen.X.2W r0 = r5.A09
            com.facebook.ads.redexgen.X.2c r0 = r0.A0N()
            r7.<init>(r2, r1, r0)
            com.facebook.ads.redexgen.X.2W r0 = r5.A09
            com.facebook.ads.redexgen.X.2J r0 = r0.A0K()
            com.facebook.ads.redexgen.X.2T r0 = r0.A01()
            com.facebook.ads.redexgen.X.Ou r0 = r7.A08(r0)
            com.facebook.ads.redexgen.X.Ov r0 = r0.A0B()
            r5.A02 = r0
            com.facebook.ads.redexgen.X.Ov r2 = r5.A02
            com.facebook.ads.redexgen.X.Gv r1 = r5.A0C
            com.facebook.ads.redexgen.X.Gu r0 = com.facebook.ads.redexgen.X.EnumC0431Gu.A0T
            com.facebook.ads.redexgen.X.C0434Gx.A04(r2, r1, r0)
            com.facebook.ads.redexgen.X.81 r0 = r5.A08
            r0.A38(r5, r6, r3)
            com.facebook.ads.redexgen.X.81 r1 = r5.A08
            com.facebook.ads.redexgen.X.Ov r0 = r5.A02
            r1.A38(r0, r4, r3)
            com.facebook.ads.redexgen.X.Ov r1 = r5.A02
            com.facebook.ads.redexgen.X.LT r0 = new com.facebook.ads.redexgen.X.LT
            r0.<init>(r5)
            r1.A04(r0)
            r0 = 4
            goto L13
        L74:
            com.facebook.ads.redexgen.X.LC r5 = (com.facebook.ads.redexgen.X.LC) r5
            android.widget.RelativeLayout$LayoutParams r3 = (android.widget.RelativeLayout.LayoutParams) r3
            r1 = 0
            com.facebook.ads.redexgen.X.81 r0 = r5.A08
            r0.A38(r5, r1, r3)
            r5.A0S()
            r0 = 4
            goto L13
        L83:
            r0 = 5
            goto L13
        L85:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.LC.A02():void");
    }

    private void A03(C2T c2t, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.A0D.getToolbarHeight());
        layoutParams.addRule(10);
        this.A0D.A04(c2t, z);
        addView(this.A0D, layoutParams);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x003a, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A06() {
        /*
            r2 = this;
            r1 = r2
            android.view.View r0 = r1.A00
            if (r0 == 0) goto L38
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L3a;
                case 4: goto L16;
                case 5: goto L22;
                case 6: goto L2d;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.LC r1 = (com.facebook.ads.redexgen.X.LC) r1
            android.view.View r0 = r1.A00
            boolean r0 = r0 instanceof com.facebook.ads.redexgen.X.AbstractC0604Nr
            if (r0 != 0) goto L14
            r0 = 3
            goto L6
        L14:
            r0 = 4
            goto L6
        L16:
            com.facebook.ads.redexgen.X.LC r1 = (com.facebook.ads.redexgen.X.LC) r1
            boolean r0 = r1.A0E()
            if (r0 == 0) goto L20
            r0 = 5
            goto L6
        L20:
            r0 = 6
            goto L6
        L22:
            com.facebook.ads.redexgen.X.LC r1 = (com.facebook.ads.redexgen.X.LC) r1
            android.view.View r0 = r1.A00
            com.facebook.ads.redexgen.X.Nr r0 = (com.facebook.ads.redexgen.X.AbstractC0604Nr) r0
            r0.A0Y()
            r0 = 3
            goto L6
        L2d:
            com.facebook.ads.redexgen.X.LC r1 = (com.facebook.ads.redexgen.X.LC) r1
            android.view.View r0 = r1.A00
            com.facebook.ads.redexgen.X.Nr r0 = (com.facebook.ads.redexgen.X.AbstractC0604Nr) r0
            r0.A0X()
            r0 = 3
            goto L6
        L38:
            r0 = 3
            goto L6
        L3a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.LC.A06():void");
    }

    public final void A07(int i) {
        this.A01 = new JW(i, new LU(this, i));
        this.A03 = true;
        A06();
        this.A01.A07();
    }

    public final void A08(View view, boolean z, int i) {
        A09(view, z, i, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x009d, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A09(android.view.View r10, boolean r11, int r12, boolean r13) {
        /*
            r9 = this;
            r6 = r9
            r5 = 0
            r4 = 0
            r7 = 0
            r0 = 0
            r0 = 0
            r8 = -1
            r3 = 0
            r6.A00 = r10
            com.facebook.ads.redexgen.X.Jz r1 = r6.A07
            com.facebook.ads.redexgen.X.Jy r0 = com.facebook.ads.redexgen.X.EnumC0508Jy.A02
            r1.A05(r0)
            r6.A01()
            android.widget.RelativeLayout$LayoutParams r2 = new android.widget.RelativeLayout$LayoutParams
            r2.<init>(r8, r8)
            if (r11 == 0) goto L9a
            r0 = 2
        L1c:
            switch(r0) {
                case 2: goto L5b;
                case 3: goto L40;
                case 4: goto L36;
                case 5: goto L23;
                case 6: goto L20;
                case 7: goto L5f;
                case 8: goto L8a;
                case 9: goto L74;
                case 10: goto L2a;
                case 11: goto L9d;
                case 12: goto L97;
                case 13: goto L80;
                default: goto L1f;
            }
        L1f:
            goto L1c
        L20:
            r5 = 1
            r0 = 7
            goto L1c
        L23:
            if (r11 == 0) goto L27
            r0 = 6
            goto L1c
        L27:
            r0 = 12
            goto L1c
        L2a:
            com.facebook.ads.redexgen.X.LC r6 = (com.facebook.ads.redexgen.X.LC) r6
            com.facebook.ads.redexgen.X.Jz r1 = r6.A07
            com.facebook.ads.redexgen.X.Jy r0 = com.facebook.ads.redexgen.X.EnumC0508Jy.A03
            r1.A05(r0)
            r0 = 11
            goto L1c
        L36:
            com.facebook.ads.redexgen.X.LC r6 = (com.facebook.ads.redexgen.X.LC) r6
            boolean r0 = r6.A05
            if (r0 != 0) goto L3e
            r0 = 5
            goto L1c
        L3e:
            r0 = 6
            goto L1c
        L40:
            com.facebook.ads.redexgen.X.LC r6 = (com.facebook.ads.redexgen.X.LC) r6
            android.view.View r10 = (android.view.View) r10
            android.widget.RelativeLayout$LayoutParams r2 = (android.widget.RelativeLayout.LayoutParams) r2
            r3 = 0
            r2.setMargins(r3, r7, r3, r3)
            r6.addView(r10, r2)
            com.facebook.ads.redexgen.X.2T r4 = r6.A00(r12)
            r6.A03(r4, r11)
            if (r13 != 0) goto L58
            r0 = 4
            goto L1c
        L58:
            r0 = 12
            goto L1c
        L5b:
            r3 = 0
            r7 = r3
            r0 = 3
            goto L1c
        L5f:
            com.facebook.ads.redexgen.X.LC r6 = (com.facebook.ads.redexgen.X.LC) r6
            com.facebook.ads.redexgen.X.2T r4 = (com.facebook.ads.redexgen.X.C2T) r4
            int r0 = r4.A07(r5)
            com.facebook.ads.redexgen.X.KE.A0P(r6, r0)
            com.facebook.ads.redexgen.X.81 r0 = r6.A08
            if (r0 == 0) goto L71
            r0 = 8
            goto L1c
        L71:
            r0 = 11
            goto L1c
        L74:
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 19
            if (r1 < r0) goto L7d
            r0 = 10
            goto L1c
        L7d:
            r0 = 11
            goto L1c
        L80:
            com.facebook.ads.redexgen.X.LC r6 = (com.facebook.ads.redexgen.X.LC) r6
            com.facebook.ads.internal.view.FullScreenAdToolbar r0 = r6.A0D
            int r7 = r0.getToolbarHeight()
            r0 = 3
            goto L1c
        L8a:
            com.facebook.ads.redexgen.X.LC r6 = (com.facebook.ads.redexgen.X.LC) r6
            r6.A02()
            if (r11 == 0) goto L94
            r0 = 9
            goto L1c
        L94:
            r0 = 11
            goto L1c
        L97:
            r5 = r3
            r0 = 7
            goto L1c
        L9a:
            r0 = 13
            goto L1c
        L9d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.LC.A09(android.view.View, boolean, int, boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0066, code lost:            r2 = r2;        r3.setPageDetails(r4, r6, r5, r2.A09.A0O());        r2.A0D.setToolbarListener(new com.facebook.ads.redexgen.X.LP(r2, r8));     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0083, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0A(com.facebook.ads.redexgen.X.AnonymousClass89 r8) {
        /*
            r7 = this;
            r2 = r7
            r5 = 0
            r0 = 0
            r4 = 0
            r3 = 0
            r6 = 0
            com.facebook.ads.redexgen.X.Jz r1 = r2.A07
            com.facebook.ads.AudienceNetworkActivity r0 = r8.A0H()
            android.view.Window r0 = r0.getWindow()
            r1.A04(r0)
            com.facebook.ads.redexgen.X.2W r0 = r2.A09
            com.facebook.ads.redexgen.X.2J r0 = r0.A0K()
            r2.A06 = r0
            r1 = 0
            com.facebook.ads.redexgen.X.2W r0 = r2.A09
            com.facebook.ads.redexgen.X.2L r0 = r0.A0L()
            if (r0 == 0) goto L64
            r0 = 2
        L25:
            switch(r0) {
                case 2: goto L56;
                case 3: goto L4c;
                case 4: goto L36;
                case 5: goto L2c;
                case 6: goto L66;
                case 7: goto L29;
                default: goto L28;
            }
        L28:
            goto L25
        L29:
            r5 = 0
            r0 = 6
            goto L25
        L2c:
            com.facebook.ads.redexgen.X.2O r0 = r1.A0D()
            int r5 = r0.A03()
            r0 = 6
            goto L25
        L36:
            com.facebook.ads.redexgen.X.LC r2 = (com.facebook.ads.redexgen.X.LC) r2
            com.facebook.ads.internal.view.FullScreenAdToolbar r3 = r2.A0D
            com.facebook.ads.redexgen.X.2W r0 = r2.A09
            com.facebook.ads.redexgen.X.2c r4 = r0.A0N()
            com.facebook.ads.redexgen.X.2W r0 = r2.A09
            java.lang.String r6 = r0.A0P()
            if (r1 == 0) goto L4a
            r0 = 5
            goto L25
        L4a:
            r0 = 7
            goto L25
        L4c:
            com.facebook.ads.redexgen.X.LC r2 = (com.facebook.ads.redexgen.X.LC) r2
            com.facebook.ads.redexgen.X.2W r0 = r2.A09
            com.facebook.ads.redexgen.X.2L r1 = r0.A0L()
            r0 = 4
            goto L25
        L56:
            com.facebook.ads.redexgen.X.LC r2 = (com.facebook.ads.redexgen.X.LC) r2
            com.facebook.ads.redexgen.X.2W r0 = r2.A09
            com.facebook.ads.redexgen.X.2L r0 = r0.A0L()
            if (r0 == 0) goto L62
            r0 = 3
            goto L25
        L62:
            r0 = 4
            goto L25
        L64:
            r0 = 4
            goto L25
        L66:
            com.facebook.ads.redexgen.X.LC r2 = (com.facebook.ads.redexgen.X.LC) r2
            com.facebook.ads.redexgen.X.89 r8 = (com.facebook.ads.redexgen.X.AnonymousClass89) r8
            com.facebook.ads.internal.view.FullScreenAdToolbar r3 = (com.facebook.ads.internal.view.FullScreenAdToolbar) r3
            com.facebook.ads.redexgen.X.2c r4 = (com.facebook.ads.redexgen.X.C00572c) r4
            java.lang.String r6 = (java.lang.String) r6
            com.facebook.ads.redexgen.X.2W r0 = r2.A09
            com.facebook.ads.redexgen.X.2k r0 = r0.A0O()
            r3.setPageDetails(r4, r6, r5, r0)
            com.facebook.ads.internal.view.FullScreenAdToolbar r1 = r2.A0D
            com.facebook.ads.redexgen.X.LP r0 = new com.facebook.ads.redexgen.X.LP
            r0.<init>(r2, r8)
            r1.setToolbarListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.LC.A0A(com.facebook.ads.redexgen.X.89):void");
    }

    public final void A0B(AnonymousClass89 anonymousClass89) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(200L);
        alphaAnimation.setAnimationListener(new LR(this, this, anonymousClass89));
        startAnimation(alphaAnimation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x002d, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0C() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.2W r0 = r2.A09
            java.util.List r0 = r0.A0V()
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L2b
            r0 = 2
        Lf:
            switch(r0) {
                case 2: goto L13;
                case 3: goto L25;
                case 4: goto L2d;
                case 5: goto L28;
                default: goto L12;
            }
        L12:
            goto Lf
        L13:
            com.facebook.ads.redexgen.X.LC r2 = (com.facebook.ads.redexgen.X.LC) r2
            com.facebook.ads.redexgen.X.2W r0 = r2.A09
            com.facebook.ads.redexgen.X.2L r0 = r0.A0L()
            boolean r0 = r0.A0O()
            if (r0 == 0) goto L23
            r0 = 3
            goto Lf
        L23:
            r0 = 5
            goto Lf
        L25:
            r1 = 1
            r0 = 4
            goto Lf
        L28:
            r1 = 0
            r0 = 4
            goto Lf
        L2b:
            r0 = 5
            goto Lf
        L2d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.LC.A0C():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x002d, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0D() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.2W r0 = r2.A09
            java.util.List r0 = r0.A0V()
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L2b
            r0 = 2
        Lf:
            switch(r0) {
                case 2: goto L13;
                case 3: goto L25;
                case 4: goto L2d;
                case 5: goto L28;
                default: goto L12;
            }
        L12:
            goto Lf
        L13:
            com.facebook.ads.redexgen.X.LC r2 = (com.facebook.ads.redexgen.X.LC) r2
            com.facebook.ads.redexgen.X.2W r0 = r2.A09
            com.facebook.ads.redexgen.X.2L r0 = r0.A0L()
            boolean r0 = r0.A0N()
            if (r0 == 0) goto L23
            r0 = 3
            goto Lf
        L23:
            r0 = 5
            goto Lf
        L25:
            r1 = 1
            r0 = 4
            goto Lf
        L28:
            r1 = 0
            r0 = 4
            goto Lf
        L2b:
            r0 = 5
            goto Lf
        L2d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.LC.A0D():boolean");
    }

    public final boolean A0E() {
        return this.A03;
    }

    public final boolean A0F() {
        return this.A04;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0023, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0524Ko
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A7F(boolean r3) {
        /*
            r2 = this;
            r1 = r2
            com.facebook.ads.redexgen.X.JW r0 = r1.A01
            if (r0 == 0) goto L21
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L18;
                case 4: goto L23;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.LC r1 = (com.facebook.ads.redexgen.X.LC) r1
            com.facebook.ads.redexgen.X.JW r0 = r1.A01
            boolean r0 = r0.A05()
            if (r0 == 0) goto L16
            r0 = 3
            goto L6
        L16:
            r0 = 4
            goto L6
        L18:
            com.facebook.ads.redexgen.X.LC r1 = (com.facebook.ads.redexgen.X.LC) r1
            com.facebook.ads.redexgen.X.JW r0 = r1.A01
            r0.A06()
            r0 = 4
            goto L6
        L21:
            r0 = 4
            goto L6
        L23:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.LC.A7F(boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0023, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0524Ko
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A7O(boolean r3) {
        /*
            r2 = this;
            r1 = r2
            com.facebook.ads.redexgen.X.JW r0 = r1.A01
            if (r0 == 0) goto L21
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L18;
                case 4: goto L23;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.LC r1 = (com.facebook.ads.redexgen.X.LC) r1
            com.facebook.ads.redexgen.X.JW r0 = r1.A01
            boolean r0 = r0.A04()
            if (r0 != 0) goto L16
            r0 = 3
            goto L6
        L16:
            r0 = 4
            goto L6
        L18:
            com.facebook.ads.redexgen.X.LC r1 = (com.facebook.ads.redexgen.X.LC) r1
            com.facebook.ads.redexgen.X.JW r0 = r1.A01
            r0.A07()
            r0 = 4
            goto L6
        L21:
            r0 = 4
            goto L6
        L23:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.LC.A7O(boolean):void");
    }

    public InterfaceC0422Gl getAdEventManager() {
        return this.A0B;
    }

    public AnonymousClass81 getAudienceNetworkListener() {
        return this.A08;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0524Ko
    public void onDestroy() {
        this.A07.A03();
        this.A0D.setToolbarListener(null);
        A01();
    }

    public void setForcedTimeViewIncomplete(boolean z) {
        this.A03 = z;
    }

    public void setListener(AnonymousClass81 anonymousClass81) {
    }
}
