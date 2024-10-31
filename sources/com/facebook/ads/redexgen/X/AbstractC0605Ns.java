package com.facebook.ads.redexgen.X;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.view.FullScreenAdToolbar;

/* renamed from: com.facebook.ads.redexgen.X.Ns, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC0605Ns extends AbstractC0604Nr {
    public static byte[] A07;
    public static final int A08;
    public static final int A09;
    public static final int A0A;
    public static final int A0B;
    public static final int A0C;
    public static final int A0D;
    public static final int A0E;
    public static final int A0F;
    public static final int A0G;
    public static final int A0H;
    public C0682Qs A00;

    @Nullable
    public C0392Fg A01;
    public FX A02;
    public final C2I A03;
    public final C2L A04;

    @Nullable
    public final FullScreenAdToolbar A05;
    public final C0594Nh A06;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A02(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.AbstractC0605Ns.A07
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
            int r0 = r0 + (-111)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC0605Ns.A02(int, int, int):java.lang.String");
    }

    public static void A03() {
        A07 = new byte[]{-6, 6, 4, -59, -3, -8, -6, -4, -7, 6, 6, 2, -59, -8, -5, 10, -59, 0, 5, 11, -4, 9, 10, 11, 0, 11, 0, -8, 3, -59, -6, 3, 0, -6, 2, -4, -5};
    }

    static {
        A03();
        A0B = (int) (48.0f * KE.A01);
        A0F = (int) (16.0f * KE.A01);
        A08 = (int) (4.0f * KE.A01);
        A0E = (int) (44.0f * KE.A01);
        A0C = (int) (8.0f * KE.A01);
        A0D = (int) (KE.A01 * 12.0f);
        A0H = (int) (KE.A01 * 12.0f);
        A0G = (int) (26.0f * KE.A01);
        A09 = C4G.A01(-1, 77);
        A0A = C4G.A01(A09, 90);
    }

    public AbstractC0605Ns(C0610Nx c0610Nx, C2T c2t, boolean z) {
        super(c0610Nx, c2t, z);
        this.A03 = c0610Nx.A04();
        this.A04 = this.A03.A0L();
        this.A06 = A01(c0610Nx, c2t);
        this.A05 = c0610Nx.A09();
        if (this.A05 != null) {
            this.A05.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.A05.getToolbarHeight()));
            this.A05.setPageDetailsVisible(false);
        }
    }

    private C0594Nh A01(C0610Nx c0610Nx, C2T c2t) {
        C0594Nh c0594Nh = new C0594Nh(c0610Nx.A05(), A0B, this.A04.A0E().A00() == C2Q.A04, c2t, A02(0, 37, 40), c0610Nx.A06(), c0610Nx.A08(), c0610Nx.A0B(), c0610Nx.A07());
        KE.A0N(c0594Nh);
        c0594Nh.A08(c0610Nx.A00());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.A02 = new FX(c0594Nh, 400, 100, 0);
        addView(c0594Nh, layoutParams);
        return c0594Nh;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0604Nr
    public void A0Z(C2L c2l, String str, double d, @Nullable Bundle bundle) {
        super.A0Z(c2l, str, d, bundle);
        this.A06.setInfo(c2l.A0E(), c2l.A0F(), str, this.A03.A0N().A01(), null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0016, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A0d(@android.support.annotation.Nullable com.facebook.ads.internal.view.FullScreenAdToolbar r3) {
        /*
            r2 = this;
            r1 = 0
            if (r3 != 0) goto L14
            r0 = 2
        L4:
            switch(r0) {
                case 2: goto L8;
                case 3: goto L16;
                case 4: goto Lc;
                default: goto L7;
            }
        L7:
            goto L4
        L8:
            int r1 = com.facebook.ads.internal.view.FullScreenAdToolbar.A08
            r0 = 3
            goto L4
        Lc:
            com.facebook.ads.internal.view.FullScreenAdToolbar r3 = (com.facebook.ads.internal.view.FullScreenAdToolbar) r3
            int r1 = r3.getToolbarHeight()
            r0 = 3
            goto L4
        L14:
            r0 = 4
            goto L4
        L16:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC0605Ns.A0d(com.facebook.ads.internal.view.FullScreenAdToolbar):int");
    }

    public void A0e() {
        this.A00 = new C0682Qs(true);
        if (this.A01 != null) {
            this.A00.A0I(this.A01);
        }
        C2T A01 = this.A03.A0K().A01();
        this.A00.A0I(new C0387Fb(getAdDetailsView().getCTAButton(), 300, -1, A01.A09(true)));
        this.A00.A0I(new C0428Gr(getAdDetailsView().getCTAButton(), 300, KE.A09(A09, A0A, A08), KE.A06(A01.A08(true), A08)));
        this.A00.A0I(new C0389Fd(getAdDetailsView().getExpandableLayout(), 150, false));
        this.A00.A0H(2300);
    }

    public C2I getAdDataBundle() {
        return this.A03;
    }

    public FX getAdDetailsAnimation() {
        return this.A02;
    }

    public C0594Nh getAdDetailsView() {
        return this.A06;
    }

    public C2L getAdInfo() {
        return this.A04;
    }

    public C0682Qs getAnimationPlugin() {
        return this.A00;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        getAdDetailsView().A08(configuration.orientation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004b, code lost:            return;     */
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
            if (r6 == 0) goto L49
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L11;
                case 3: goto L1b;
                case 4: goto L4b;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            com.facebook.ads.redexgen.X.Ns r5 = (com.facebook.ads.redexgen.X.AbstractC0605Ns) r5
            com.facebook.ads.redexgen.X.Fg r0 = r5.A01
            if (r0 != 0) goto L19
            r0 = 3
            goto Ld
        L19:
            r0 = 4
            goto Ld
        L1b:
            com.facebook.ads.redexgen.X.Ns r5 = (com.facebook.ads.redexgen.X.AbstractC0605Ns) r5
            com.facebook.ads.redexgen.X.Fg r4 = new com.facebook.ads.redexgen.X.Fg
            com.facebook.ads.redexgen.X.Nh r0 = r5.getAdDetailsView()
            android.view.View r3 = r0.getExpandableLayout()
            r2 = 300(0x12c, float:4.2E-43)
            com.facebook.ads.redexgen.X.Nh r0 = r5.getAdDetailsView()
            android.view.View r0 = r0.getExpandableLayout()
            int r1 = r0.getHeight()
            r0 = 0
            r4.<init>(r3, r2, r1, r0)
            r5.A01 = r4
            com.facebook.ads.redexgen.X.Qs r1 = r5.A00
            com.facebook.ads.redexgen.X.Fg r0 = r5.A01
            r1.A0I(r0)
            com.facebook.ads.redexgen.X.Qs r0 = r5.A00
            r0.A0G()
            r0 = 4
            goto Ld
        L49:
            r0 = 4
            goto Ld
        L4b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC0605Ns.onLayout(boolean, int, int, int, int):void");
    }
}
