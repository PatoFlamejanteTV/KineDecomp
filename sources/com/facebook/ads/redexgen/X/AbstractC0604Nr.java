package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.view.ToolbarActionView$ToolbarActionMode;

/* renamed from: com.facebook.ads.redexgen.X.Nr, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC0604Nr extends RelativeLayout {
    public static byte[] A04;
    public static final int A05;
    public static final int A06;
    public final C0362Ec A00;
    public final InterfaceC0422Gl A01;
    public final ViewOnClickListenerC0589Nc A02;
    public final C0601No A03;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.AbstractC0604Nr.A04
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
            r0 = r0 ^ 73
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC0604Nr.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A04 = new byte[]{67, 79, 77, 14, 70, 65, 67, 69, 66, 79, 79, 75, 14, 65, 68, 83, 14, 73, 78, 84, 69, 82, 83, 84, 73, 84, 73, 65, 76, 14, 67, 76, 73, 67, 75, 69, 68};
    }

    public abstract boolean A0b();

    static {
        A01();
        A05 = (int) (16.0f * KE.A01);
        A06 = (int) (28.0f * KE.A01);
    }

    public AbstractC0604Nr(C0610Nx c0610Nx, C2T c2t, boolean z) {
        super(c0610Nx.A05());
        this.A00 = c0610Nx.A05();
        this.A01 = c0610Nx.A06();
        this.A02 = new ViewOnClickListenerC0589Nc(c0610Nx.A05(), A00(0, 37, 105), c2t, c0610Nx.A06(), c0610Nx.A08(), c0610Nx.A0B(), c0610Nx.A07());
        this.A02.setRoundedCornersEnabled(A02());
        this.A02.setViewShowsOverMedia(A07());
        KE.A0I(1001, this.A02);
        this.A03 = new C0601No(this.A00, c2t, z, A03(), A04());
        KE.A0N(this.A03);
    }

    public boolean A02() {
        return true;
    }

    public boolean A03() {
        return true;
    }

    public boolean A04() {
        return true;
    }

    public boolean A07() {
        return true;
    }

    public void A0L(Bundle bundle) {
    }

    public void A0M(QM qm) {
    }

    public void A0N(QS qs) {
    }

    public void A0O(QT qt) {
    }

    public void A0U() {
    }

    public void A0V() {
    }

    public void A0W() {
    }

    public void A0X() {
    }

    public void A0Y() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0041, code lost:            r3.A00(r4, r5, null, false, r8);        r9.A02.setCta(r10.A0F(), r11, new java.util.HashMap());     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0061, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A0Z(com.facebook.ads.redexgen.X.C2L r10, java.lang.String r11, double r12, @android.support.annotation.Nullable android.os.Bundle r14) {
        /*
            r9 = this;
            r0 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            r8 = 0
            r0 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.No r3 = r9.A03
            com.facebook.ads.redexgen.X.2S r0 = r10.A0E()
            java.lang.String r4 = r0.A05()
            com.facebook.ads.redexgen.X.2S r0 = r10.A0E()
            java.lang.String r5 = r0.A01()
            r0 = 0
            boolean r0 = r9.A0b()
            if (r0 != 0) goto L3f
            r0 = 2
        L21:
            switch(r0) {
                case 2: goto L25;
                case 3: goto L32;
                case 4: goto L2f;
                case 5: goto L41;
                case 6: goto L3c;
                default: goto L24;
            }
        L24:
            goto L21
        L25:
            r1 = 0
            int r0 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r0 <= 0) goto L2d
            r0 = 3
            goto L21
        L2d:
            r0 = 6
            goto L21
        L2f:
            r8 = 1
            r0 = 5
            goto L21
        L32:
            r1 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r0 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r0 >= 0) goto L3a
            r0 = 4
            goto L21
        L3a:
            r0 = 6
            goto L21
        L3c:
            r8 = 0
            r0 = 5
            goto L21
        L3f:
            r0 = 6
            goto L21
        L41:
            r0 = r9
            com.facebook.ads.redexgen.X.Nr r0 = (com.facebook.ads.redexgen.X.AbstractC0604Nr) r0
            com.facebook.ads.redexgen.X.2L r10 = (com.facebook.ads.redexgen.X.C2L) r10
            java.lang.String r11 = (java.lang.String) r11
            com.facebook.ads.redexgen.X.No r3 = (com.facebook.ads.redexgen.X.C0601No) r3
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r5 = (java.lang.String) r5
            r6 = 0
            r7 = 0
            r3.A00(r4, r5, r6, r7, r8)
            com.facebook.ads.redexgen.X.Nc r2 = r0.A02
            com.facebook.ads.redexgen.X.2U r1 = r10.A0F()
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r2.setCta(r1, r11, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC0604Nr.A0Z(com.facebook.ads.redexgen.X.2L, java.lang.String, double, android.os.Bundle):void");
    }

    public boolean A0a() {
        return false;
    }

    public boolean A0c(boolean z) {
        return false;
    }

    public C0362Ec getAdContextWrapper() {
        return this.A00;
    }

    public InterfaceC0422Gl getAdEventManager() {
        return this.A01;
    }

    @ToolbarActionView$ToolbarActionMode
    public int getCloseButtonStyle() {
        return 0;
    }

    public ViewOnClickListenerC0589Nc getCtaButton() {
        return this.A02;
    }

    public C0601No getTitleDescContainer() {
        return this.A03;
    }
}
