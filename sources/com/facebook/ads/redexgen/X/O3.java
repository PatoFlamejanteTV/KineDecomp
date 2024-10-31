package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.view.FullScreenAdToolbar;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: assets/audience_network.dex */
public final class O3 extends AbstractC0605Ns {
    public static byte[] A0D;
    public static final int A0E;
    public static final int A0F;
    public static final /* synthetic */ boolean A0G;

    @Nullable
    public View A00;
    public C0362Ec A01;

    @Nullable
    public FullScreenAdToolbar A02;
    public C0641Pd A03;

    @Nullable
    public FX A04;
    public boolean A05;
    public boolean A06;
    public final FrameLayout A07;
    public final AnonymousClass81 A08;
    public final NU A09;
    public final C0537Lb A0A;
    public final I6 A0B;
    public final AtomicBoolean A0C;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A0B(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.O3.A0D
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
            int r0 = r0 + (-122)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.O3.A0B(int, int, int):java.lang.String");
    }

    public static void A0J() {
        A0D = new byte[]{-54, -61, -40, -57, -31, -43, -42, -61, -44, -42, -53, -48, -55, -31, -61, -48, -53, -49, -61, -42, -53, -47, -48, -43, -31, -46, -50, -61, -37, -57, -58, 45, 23, 41, 53, 27, 36, 26, 53, 25, 23, 40, 26, 53, 41, 30, 37, 45, 36, -6, -3, 1, -13, 13, 0, -13, 5, -17, 0, -14, 13, 1, -15, 0, -13, -13, -4, 13, 1, -10, -3, 5, -4};
    }

    static {
        A0J();
        A0G = !O3.class.desiredAssertionStatus();
        A0E = C4G.A01(3618615, 255);
        A0F = (int) (KE.A01 * 16.0f);
    }

    public O3(C0610Nx c0610Nx, C2T c2t) {
        super(c0610Nx, c2t, false);
        this.A0C = new AtomicBoolean(false);
        this.A05 = false;
        this.A06 = false;
        this.A01 = c0610Nx.A05();
        this.A02 = c0610Nx.A09();
        A0E();
        this.A08 = c0610Nx.A08();
        C0602Np.A00(c0610Nx.A05(), this, getAdInfo().A0D().A06());
        this.A0A = A07(c0610Nx);
        getAdDetailsView().bringToFront();
        if (C0413Gc.A0b(this.A01)) {
            getAdDetailsView().A0B();
        }
        this.A0B = A09(c0610Nx);
        A0e();
        this.A09 = A05();
        this.A03 = new C0641Pd(this.A01, c0610Nx.A06(), getAdDataBundle());
        this.A07 = new FrameLayout(getContext());
        A0C();
    }

    private NU A05() {
        NU nu = new NU(this.A01);
        nu.setIcon(KM.REWARD_ICON);
        nu.setBackgroundColor(A0E);
        nu.setHighlightColor(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(KE.A02.widthPixels / 2, -2);
        layoutParams.leftMargin = A0F;
        layoutParams.topMargin = A0d(this.A02);
        addView(nu, layoutParams);
        KE.A0J(nu);
        return nu;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x002c. Please report as an issue. */
    private C0537Lb A07(C0610Nx c0610Nx) {
        View view = (C0537Lb) c0610Nx.A02();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        addView(view, layoutParams);
        int A0d = A0d(c0610Nx.A09());
        ImageView imageView = (ImageView) c0610Nx.A03();
        int toolbarHeight = !A0G ? 2 : 4;
        while (true) {
            switch (toolbarHeight) {
                case 2:
                    imageView = imageView;
                    toolbarHeight = imageView == null ? 3 : 4;
                case 3:
                    throw new AssertionError();
                case 4:
                    C0537Lb c0537Lb = (C0537Lb) view;
                    ImageView imageView2 = imageView;
                    int i = AbstractC0605Ns.A0D;
                    int i2 = AbstractC0605Ns.A0D;
                    int i3 = AbstractC0605Ns.A0D;
                    int toolbarHeight2 = AbstractC0605Ns.A0D;
                    imageView2.setPadding(i, i2, i3, toolbarHeight2);
                    int i4 = AbstractC0605Ns.A0E;
                    int toolbarHeight3 = AbstractC0605Ns.A0E;
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i4, toolbarHeight3);
                    int toolbarHeight4 = AbstractC0605Ns.A0C;
                    layoutParams2.setMargins(0, A0d, toolbarHeight4, 0);
                    layoutParams2.addRule(11);
                    layoutParams2.addRule(10);
                    c0537Lb.addView(imageView2, layoutParams2);
                    return c0537Lb;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x000c. Please report as an issue. */
    private I6 A09(C0610Nx c0610Nx) {
        I6 A0A = c0610Nx.A0A();
        char c = !A0G ? (char) 2 : (char) 4;
        while (true) {
            switch (c) {
                case 2:
                    A0A = A0A;
                    c = A0A == null ? (char) 3 : (char) 4;
                case 3:
                    throw new AssertionError();
                case 4:
                    I6 i6 = A0A;
                    i6.setPadding(AbstractC0605Ns.A0H, AbstractC0605Ns.A0H, AbstractC0605Ns.A0H, AbstractC0605Ns.A0H);
                    i6.A0A(-1, AbstractC0605Ns.A09);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, AbstractC0605Ns.A0G);
                    layoutParams.addRule(12);
                    addView(i6, layoutParams);
                    return i6;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0040, code lost:            r2 = r2;        r3 = new com.facebook.ads.redexgen.X.C0539Ld(r2.getAdContextWrapper(), -1, -16777216, r7, null, r2.getAdDataBundle().A0M().A04(), r2.getAdDataBundle().A0M().A03(), com.facebook.ads.redexgen.X.KN.A00(com.facebook.ads.redexgen.X.KM.REWARD_ICON));        r3.A02.setOnClickListener(new com.facebook.ads.redexgen.X.ViewOnClickListenerC0612Nz(r2));        r3.A01.setOnClickListener(new com.facebook.ads.redexgen.X.O0(r2));        r2.A07.addView(r3, new android.widget.RelativeLayout.LayoutParams(-1, -1));     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x008c, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0C() {
        /*
            r12 = this;
            r2 = r12
            r0 = 0
            r7 = 0
            r0 = 0
            r5 = -1
            com.facebook.ads.redexgen.X.2I r0 = r2.getAdDataBundle()
            com.facebook.ads.RewardData r4 = r0.A0J()
            if (r4 != 0) goto L3e
            r0 = 2
        L10:
            switch(r0) {
                case 2: goto L14;
                case 3: goto L40;
                case 4: goto L24;
                default: goto L13;
            }
        L13:
            goto L10
        L14:
            com.facebook.ads.redexgen.X.O3 r2 = (com.facebook.ads.redexgen.X.O3) r2
            com.facebook.ads.redexgen.X.2I r0 = r2.getAdDataBundle()
            com.facebook.ads.redexgen.X.2Z r0 = r0.A0M()
            java.lang.String r7 = r0.A05()
            r0 = 3
            goto L10
        L24:
            com.facebook.ads.redexgen.X.O3 r2 = (com.facebook.ads.redexgen.X.O3) r2
            com.facebook.ads.RewardData r4 = (com.facebook.ads.RewardData) r4
            com.facebook.ads.redexgen.X.2I r0 = r2.getAdDataBundle()
            com.facebook.ads.redexgen.X.2Z r3 = r0.A0M()
            java.lang.String r1 = r4.getCurrency()
            int r0 = r4.getQuantity()
            java.lang.String r7 = r3.A07(r1, r0)
            r0 = 3
            goto L10
        L3e:
            r0 = 4
            goto L10
        L40:
            com.facebook.ads.redexgen.X.O3 r2 = (com.facebook.ads.redexgen.X.O3) r2
            java.lang.String r7 = (java.lang.String) r7
            com.facebook.ads.redexgen.X.Ld r3 = new com.facebook.ads.redexgen.X.Ld
            com.facebook.ads.redexgen.X.Ec r4 = r2.getAdContextWrapper()
            r6 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r8 = 0
            com.facebook.ads.redexgen.X.2I r0 = r2.getAdDataBundle()
            com.facebook.ads.redexgen.X.2Z r0 = r0.A0M()
            java.lang.String r9 = r0.A04()
            com.facebook.ads.redexgen.X.2I r0 = r2.getAdDataBundle()
            com.facebook.ads.redexgen.X.2Z r0 = r0.A0M()
            java.lang.String r10 = r0.A03()
            com.facebook.ads.redexgen.X.KM r0 = com.facebook.ads.redexgen.X.KM.REWARD_ICON
            android.graphics.Bitmap r11 = com.facebook.ads.redexgen.X.KN.A00(r0)
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            android.widget.Button r1 = r3.A02
            com.facebook.ads.redexgen.X.Nz r0 = new com.facebook.ads.redexgen.X.Nz
            r0.<init>(r2)
            r1.setOnClickListener(r0)
            android.widget.Button r1 = r3.A01
            com.facebook.ads.redexgen.X.O0 r0 = new com.facebook.ads.redexgen.X.O0
            r0.<init>(r2)
            r1.setOnClickListener(r0)
            android.widget.RelativeLayout$LayoutParams r1 = new android.widget.RelativeLayout$LayoutParams
            r1.<init>(r5, r5)
            android.widget.FrameLayout r0 = r2.A07
            r0.addView(r3, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.O3.A0C():void");
    }

    private void A0D() {
        getAnimationPlugin().A0E();
        this.A0A.A0T(getAnimationPlugin());
    }

    private void A0E() {
        if (this.A02 == null) {
            return;
        }
        this.A04 = new FX(this.A02, 400, -this.A02.getToolbarHeight(), 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00d8, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0F() {
        /*
            r10 = this;
            r7 = r10
            r0 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            r6 = 2
            r5 = 1
            r4 = -1
            r3 = 0
            com.facebook.ads.redexgen.X.Gv r2 = new com.facebook.ads.redexgen.X.Gv
            com.facebook.ads.redexgen.X.2I r0 = r7.getAdDataBundle()
            java.lang.String r1 = r0.A0P()
            com.facebook.ads.redexgen.X.Gl r0 = r7.getAdEventManager()
            r2.<init>(r1, r0)
            com.facebook.ads.redexgen.X.Gu r1 = com.facebook.ads.redexgen.X.EnumC0431Gu.A0m
            r0 = 0
            r2.A02(r1, r0)
            com.facebook.ads.redexgen.X.2L r0 = r7.getAdInfo()
            boolean r0 = r0.A0M()
            if (r0 != 0) goto Ld5
            r0 = 2
        L2b:
            switch(r0) {
                case 2: goto Ld8;
                case 3: goto L2f;
                case 4: goto L87;
                case 5: goto Lab;
                default: goto L2e;
            }
        L2e:
            goto L2b
        L2f:
            com.facebook.ads.redexgen.X.O3 r7 = (com.facebook.ads.redexgen.X.O3) r7
            r3 = 0
            java.util.concurrent.atomic.AtomicBoolean r0 = r7.A0C
            r0.set(r5)
            com.facebook.ads.redexgen.X.KE.A0U(r7)
            com.facebook.ads.redexgen.X.Nh r0 = r7.getAdDetailsView()
            r0.A0C()
            com.facebook.ads.redexgen.X.Lb r0 = r7.A0A
            com.facebook.ads.redexgen.X.KE.A0J(r0)
            r0 = 4
            android.view.View[] r2 = new android.view.View[r0]
            com.facebook.ads.redexgen.X.Lb r0 = r7.A0A
            r2[r3] = r0
            com.facebook.ads.redexgen.X.I6 r0 = r7.A0B
            r2[r5] = r0
            android.widget.FrameLayout r0 = r7.A07
            r2[r6] = r0
            r1 = 3
            android.view.View r0 = r7.A00
            r2[r1] = r0
            com.facebook.ads.redexgen.X.KE.A0a(r2)
            com.facebook.ads.internal.view.FullScreenAdToolbar r0 = r7.A02
            com.facebook.ads.redexgen.X.KE.A0O(r0)
            com.facebook.ads.redexgen.X.Pd r1 = r7.A03
            com.facebook.ads.redexgen.X.Nc r0 = r7.getCtaButton()
            android.util.Pair r2 = r1.A02(r0)
            java.lang.Object r0 = r2.second
            android.view.View r0 = (android.view.View) r0
            r7.A00 = r0
            int[] r1 = com.facebook.ads.redexgen.X.O2.A00
            java.lang.Object r0 = r2.first
            com.facebook.ads.redexgen.X.Pc r0 = (com.facebook.ads.redexgen.X.EnumC0640Pc) r0
            int r0 = r0.ordinal()
            r0 = r1[r0]
            switch(r0) {
                case 1: goto L83;
                case 2: goto L85;
                default: goto L81;
            }
        L81:
            r0 = 2
            goto L2b
        L83:
            r0 = 5
            goto L2b
        L85:
            r0 = 4
            goto L2b
        L87:
            com.facebook.ads.redexgen.X.O3 r7 = (com.facebook.ads.redexgen.X.O3) r7
            android.view.View[] r1 = new android.view.View[r5]
            com.facebook.ads.redexgen.X.Nh r0 = r7.getAdDetailsView()
            r1[r3] = r0
            com.facebook.ads.redexgen.X.KE.A0a(r1)
            android.widget.RelativeLayout$LayoutParams r9 = new android.widget.RelativeLayout$LayoutParams
            r9.<init>(r4, r4)
            int r8 = com.facebook.ads.redexgen.X.AbstractC0605Ns.A0F
            int r2 = com.facebook.ads.redexgen.X.AbstractC0605Ns.A0F
            int r1 = com.facebook.ads.redexgen.X.AbstractC0605Ns.A0F
            int r0 = com.facebook.ads.redexgen.X.AbstractC0605Ns.A0F
            r9.setMargins(r8, r2, r1, r0)
            android.view.View r0 = r7.A00
            r7.addView(r0, r9)
            r0 = 2
            goto L2b
        Lab:
            com.facebook.ads.redexgen.X.O3 r7 = (com.facebook.ads.redexgen.X.O3) r7
            com.facebook.ads.redexgen.X.Nh r0 = r7.getAdDetailsView()
            r0.setVisibility(r3)
            android.widget.RelativeLayout$LayoutParams r1 = new android.widget.RelativeLayout$LayoutParams
            r1.<init>(r4, r4)
            com.facebook.ads.internal.view.FullScreenAdToolbar r0 = r7.A02
            int r0 = r7.A0d(r0)
            r1.setMargins(r3, r0, r3, r3)
            com.facebook.ads.redexgen.X.Nh r0 = r7.getAdDetailsView()
            int r0 = r0.getId()
            r1.addRule(r6, r0)
            android.view.View r0 = r7.A00
            r7.addView(r0, r1)
            r0 = 2
            goto L2b
        Ld5:
            r0 = 3
            goto L2b
        Ld8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.O3.A0F():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0033, code lost:            r4 = r4;        com.facebook.ads.redexgen.X.KE.A0Q(r4.A0A, 4);        com.facebook.ads.redexgen.X.KE.A0Q(r4.A0B, 4);        com.facebook.ads.redexgen.X.KE.A0Q(r4.getAdDetailsView(), 4);        r4.addView(r4.A07, new android.widget.RelativeLayout.LayoutParams(-1, -1));        r4.A05 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0053, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0G() {
        /*
            r5 = this;
            r4 = r5
            r0 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            r3 = -1
            r2 = 4
            com.facebook.ads.internal.view.FullScreenAdToolbar r0 = r4.A02
            if (r0 == 0) goto L31
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L19;
                case 4: goto L27;
                case 5: goto L33;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            com.facebook.ads.redexgen.X.O3 r4 = (com.facebook.ads.redexgen.X.O3) r4
            com.facebook.ads.internal.view.FullScreenAdToolbar r0 = r4.A02
            com.facebook.ads.redexgen.X.KE.A0J(r0)
            r0 = 3
            goto Lc
        L19:
            com.facebook.ads.redexgen.X.O3 r4 = (com.facebook.ads.redexgen.X.O3) r4
            com.facebook.ads.redexgen.X.Lb r0 = r4.A0A
            boolean r0 = r0.A0Z()
            if (r0 != 0) goto L25
            r0 = 4
            goto Lc
        L25:
            r0 = 5
            goto Lc
        L27:
            com.facebook.ads.redexgen.X.O3 r4 = (com.facebook.ads.redexgen.X.O3) r4
            r1 = 0
            com.facebook.ads.redexgen.X.Lb r0 = r4.A0A
            r0.A0V(r1, r1)
            r0 = 5
            goto Lc
        L31:
            r0 = 3
            goto Lc
        L33:
            com.facebook.ads.redexgen.X.O3 r4 = (com.facebook.ads.redexgen.X.O3) r4
            com.facebook.ads.redexgen.X.Lb r0 = r4.A0A
            com.facebook.ads.redexgen.X.KE.A0Q(r0, r2)
            com.facebook.ads.redexgen.X.I6 r0 = r4.A0B
            com.facebook.ads.redexgen.X.KE.A0Q(r0, r2)
            com.facebook.ads.redexgen.X.Nh r0 = r4.getAdDetailsView()
            com.facebook.ads.redexgen.X.KE.A0Q(r0, r2)
            android.widget.RelativeLayout$LayoutParams r1 = new android.widget.RelativeLayout$LayoutParams
            r1.<init>(r3, r3)
            android.widget.FrameLayout r0 = r4.A07
            r4.addView(r0, r1)
            r0 = 1
            r4.A05 = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.O3.A0G():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x007c, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0H() {
        /*
            r5 = this;
            r4 = r5
            r0 = 0
            com.facebook.ads.redexgen.X.2I r0 = r4.getAdDataBundle()
            com.facebook.ads.RewardData r3 = r0.A0J()
            boolean r0 = r4.A06
            if (r0 != 0) goto L7a
            r0 = 2
        Lf:
            switch(r0) {
                case 2: goto L13;
                case 3: goto L23;
                case 4: goto L37;
                case 5: goto L7c;
                case 6: goto L3f;
                default: goto L12;
            }
        L12:
            goto Lf
        L13:
            com.facebook.ads.redexgen.X.O3 r4 = (com.facebook.ads.redexgen.X.O3) r4
            com.facebook.ads.redexgen.X.2L r0 = r4.getAdInfo()
            boolean r0 = r0.A0K()
            if (r0 == 0) goto L21
            r0 = 3
            goto Lf
        L21:
            r0 = 5
            goto Lf
        L23:
            com.facebook.ads.redexgen.X.O3 r4 = (com.facebook.ads.redexgen.X.O3) r4
            com.facebook.ads.redexgen.X.2L r0 = r4.getAdInfo()
            com.facebook.ads.redexgen.X.2O r0 = r0.A0D()
            int r0 = r0.A02()
            if (r0 <= 0) goto L35
            r0 = 4
            goto Lf
        L35:
            r0 = 5
            goto Lf
        L37:
            com.facebook.ads.RewardData r3 = (com.facebook.ads.RewardData) r3
            if (r3 != 0) goto L3d
            r0 = 5
            goto Lf
        L3d:
            r0 = 6
            goto Lf
        L3f:
            com.facebook.ads.redexgen.X.O3 r4 = (com.facebook.ads.redexgen.X.O3) r4
            com.facebook.ads.RewardData r3 = (com.facebook.ads.RewardData) r3
            com.facebook.ads.redexgen.X.2I r0 = r4.getAdDataBundle()
            com.facebook.ads.redexgen.X.2Z r2 = r0.A0M()
            java.lang.String r1 = r3.getCurrency()
            int r0 = r3.getQuantity()
            java.lang.String r1 = r2.A06(r1, r0)
            com.facebook.ads.redexgen.X.NU r0 = r4.A09
            r0.setText(r1)
            com.facebook.ads.redexgen.X.NU r0 = r4.A09
            r0.bringToFront()
            com.facebook.ads.redexgen.X.NU r0 = r4.A09
            com.facebook.ads.redexgen.X.KE.A0K(r0)
            com.facebook.ads.redexgen.X.NU r0 = r4.A09
            com.facebook.ads.redexgen.X.KE.A0O(r0)
            com.facebook.ads.redexgen.X.O1 r2 = new com.facebook.ads.redexgen.X.O1
            r2.<init>(r4)
            r0 = 3000(0xbb8, double:1.482E-320)
            r4.postDelayed(r2, r0)
            r0 = 1
            r4.A06 = r0
            r0 = 5
            goto Lf
        L7a:
            r0 = 5
            goto Lf
        L7c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.O3.A0H():void");
    }

    private void A0I() {
        if (this.A04 != null) {
            this.A04.A3A(true, false);
        }
        getAdDetailsAnimation().A3A(true, false);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0604Nr
    public final void A0L(Bundle bundle) {
        bundle.putBoolean(A0B(0, 31, 8), true);
        bundle.putBoolean(A0B(31, 18, 92), this.A0C.get());
        bundle.putBoolean(A0B(49, 24, 52), this.A05);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0604Nr
    public final void A0M(QM qm) {
        super.A0M(qm);
        A0F();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0604Nr
    public final void A0N(QS qs) {
        super.A0N(qs);
        A0H();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0035, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.AbstractC0604Nr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0O(com.facebook.ads.redexgen.X.QT r5) {
        /*
            r4 = this;
            r3 = r4
            super.A0O(r5)
            int r2 = r5.A00()
            com.facebook.ads.redexgen.X.Lb r0 = r3.A0A
            int r1 = r0.getDuration()
            int r1 = r1 - r2
            r0 = 3000(0xbb8, float:4.204E-42)
            if (r1 >= r0) goto L33
            r0 = 2
        L14:
            switch(r0) {
                case 2: goto L18;
                case 3: goto L28;
                case 4: goto L35;
                default: goto L17;
            }
        L17:
            goto L14
        L18:
            com.facebook.ads.redexgen.X.O3 r3 = (com.facebook.ads.redexgen.X.O3) r3
            com.facebook.ads.redexgen.X.Qs r0 = r3.getAnimationPlugin()
            boolean r0 = r0.A0J()
            if (r0 == 0) goto L26
            r0 = 3
            goto L14
        L26:
            r0 = 4
            goto L14
        L28:
            com.facebook.ads.redexgen.X.O3 r3 = (com.facebook.ads.redexgen.X.O3) r3
            com.facebook.ads.redexgen.X.Qs r0 = r3.getAnimationPlugin()
            r0.A0F()
            r0 = 4
            goto L14
        L33:
            r0 = 4
            goto L14
        L35:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.O3.A0O(com.facebook.ads.redexgen.X.QT):void");
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0604Nr
    public final void A0U() {
        super.A0U();
        A0D();
        this.A02 = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0074, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.AbstractC0605Ns, com.facebook.ads.redexgen.X.AbstractC0604Nr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0Z(com.facebook.ads.redexgen.X.C2L r11, java.lang.String r12, double r13, @android.support.annotation.Nullable android.os.Bundle r15) {
        /*
            r10 = this;
            r9 = r15
            r4 = r10
            r0 = 0
            r3 = 0
            r6 = r12
            r5 = r11
            r7 = r13
            super.A0Z(r5, r6, r7, r9)
            if (r9 != 0) goto L72
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L18;
                case 3: goto L3c;
                case 4: goto L35;
                case 5: goto L1f;
                case 6: goto L11;
                case 7: goto L52;
                case 8: goto L6a;
                case 9: goto L74;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            com.facebook.ads.redexgen.X.O3 r4 = (com.facebook.ads.redexgen.X.O3) r4
            r4.A0F()
            r0 = 7
            goto Ld
        L18:
            android.os.Bundle r9 = new android.os.Bundle
            r9.<init>()
            r0 = 3
            goto Ld
        L1f:
            android.os.Bundle r9 = (android.os.Bundle) r9
            r2 = 31
            r1 = 18
            r0 = 92
            java.lang.String r0 = A0B(r2, r1, r0)
            boolean r0 = r9.getBoolean(r0, r3)
            if (r0 == 0) goto L33
            r0 = 6
            goto Ld
        L33:
            r0 = 7
            goto Ld
        L35:
            com.facebook.ads.redexgen.X.O3 r4 = (com.facebook.ads.redexgen.X.O3) r4
            r4.A0I()
            r0 = 5
            goto Ld
        L3c:
            android.os.Bundle r9 = (android.os.Bundle) r9
            r3 = 0
            r2 = 0
            r1 = 31
            r0 = 8
            java.lang.String r0 = A0B(r2, r1, r0)
            boolean r0 = r9.getBoolean(r0, r3)
            if (r0 != 0) goto L50
            r0 = 4
            goto Ld
        L50:
            r0 = 5
            goto Ld
        L52:
            android.os.Bundle r9 = (android.os.Bundle) r9
            r2 = 49
            r1 = 24
            r0 = 52
            java.lang.String r0 = A0B(r2, r1, r0)
            boolean r0 = r9.getBoolean(r0, r3)
            if (r0 == 0) goto L67
            r0 = 8
            goto Ld
        L67:
            r0 = 9
            goto Ld
        L6a:
            com.facebook.ads.redexgen.X.O3 r4 = (com.facebook.ads.redexgen.X.O3) r4
            r4.A0G()
            r0 = 9
            goto Ld
        L72:
            r0 = 3
            goto Ld
        L74:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.O3.A0Z(com.facebook.ads.redexgen.X.2L, java.lang.String, double, android.os.Bundle):void");
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0604Nr
    public final boolean A0b() {
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x005a, code lost:            return r2;     */
    @Override // com.facebook.ads.redexgen.X.AbstractC0604Nr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0c(boolean r5) {
        /*
            r4 = this;
            r3 = r4
            r0 = 0
            r2 = 1
            if (r5 == 0) goto L58
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto L30;
                case 3: goto L1b;
                case 4: goto L29;
                case 5: goto L5a;
                case 6: goto La;
                case 7: goto L3a;
                case 8: goto L4a;
                case 9: goto L55;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.O3 r3 = (com.facebook.ads.redexgen.X.O3) r3
            com.facebook.ads.redexgen.X.2L r0 = r3.getAdInfo()
            boolean r0 = r0.A0M()
            if (r0 == 0) goto L18
            r0 = 7
            goto L6
        L18:
            r0 = 9
            goto L6
        L1b:
            com.facebook.ads.redexgen.X.O3 r3 = (com.facebook.ads.redexgen.X.O3) r3
            java.util.concurrent.atomic.AtomicBoolean r0 = r3.A0C
            boolean r0 = r0.get()
            if (r0 != 0) goto L27
            r0 = 4
            goto L6
        L27:
            r0 = 6
            goto L6
        L29:
            com.facebook.ads.redexgen.X.O3 r3 = (com.facebook.ads.redexgen.X.O3) r3
            r3.A0G()
            r0 = 5
            goto L6
        L30:
            com.facebook.ads.redexgen.X.O3 r3 = (com.facebook.ads.redexgen.X.O3) r3
            boolean r0 = r3.A05
            if (r0 != 0) goto L38
            r0 = 3
            goto L6
        L38:
            r0 = 6
            goto L6
        L3a:
            com.facebook.ads.redexgen.X.O3 r3 = (com.facebook.ads.redexgen.X.O3) r3
            java.util.concurrent.atomic.AtomicBoolean r0 = r3.A0C
            boolean r0 = r0.get()
            if (r0 != 0) goto L47
            r0 = 8
            goto L6
        L47:
            r0 = 9
            goto L6
        L4a:
            com.facebook.ads.redexgen.X.O3 r3 = (com.facebook.ads.redexgen.X.O3) r3
            com.facebook.ads.redexgen.X.Lb r1 = r3.A0A
            com.facebook.ads.redexgen.X.QE r0 = com.facebook.ads.redexgen.X.QE.A06
            r1.A0P(r0)
            r0 = 5
            goto L6
        L55:
            r2 = 0
            r0 = 5
            goto L6
        L58:
            r0 = 6
            goto L6
        L5a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.O3.A0c(boolean):boolean");
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0605Ns
    public final void A0e() {
        super.A0e();
        getAnimationPlugin().A5M(this.A0A);
    }

    public final boolean A0f() {
        return getAdInfo().A0M();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0028, code lost:            return r1;     */
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
            boolean r0 = r2.A0f()
            if (r0 == 0) goto L26
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L1b;
                case 4: goto L28;
                case 5: goto L1e;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.O3 r2 = (com.facebook.ads.redexgen.X.O3) r2
            java.util.concurrent.atomic.AtomicBoolean r0 = r2.A0C
            boolean r0 = r0.get()
            if (r0 != 0) goto L19
            r0 = 3
            goto L9
        L19:
            r0 = 5
            goto L9
        L1b:
            r1 = 1
            r0 = 4
            goto L9
        L1e:
            com.facebook.ads.redexgen.X.O3 r2 = (com.facebook.ads.redexgen.X.O3) r2
            int r1 = super.getCloseButtonStyle()
            r0 = 4
            goto L9
        L26:
            r0 = 5
            goto L9
        L28:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.O3.getCloseButtonStyle():int");
    }
}
