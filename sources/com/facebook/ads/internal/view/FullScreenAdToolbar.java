package com.facebook.ads.internal.view;

import android.support.annotation.Nullable;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.facebook.ads.redexgen.X.AnonymousClass81;
import com.facebook.ads.redexgen.X.C00572c;
import com.facebook.ads.redexgen.X.C00652k;
import com.facebook.ads.redexgen.X.C0362Ec;
import com.facebook.ads.redexgen.X.C0432Gv;
import com.facebook.ads.redexgen.X.C0523Kn;
import com.facebook.ads.redexgen.X.KE;
import com.facebook.ads.redexgen.X.L0;
import com.facebook.ads.redexgen.X.ME;
import com.facebook.ads.redexgen.X.PC;
import com.facebook.ads.redexgen.X.ViewOnClickListenerC0535Kz;

/* loaded from: assets/audience_network.dex */
public final class FullScreenAdToolbar extends LinearLayout {
    public static byte[] A07;
    public static final int A08;
    public static final int A09;
    public static final int A0A;
    public static final int A0B;
    public static final int A0C;
    public static final int A0D;

    @Nullable
    public L0 A00;
    public final RelativeLayout A01;
    public final C0432Gv A02;
    public final C0523Kn A03;
    public final AnonymousClass81 A04;
    public final ME A05;
    public final PC A06;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A02(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.internal.view.FullScreenAdToolbar.A07
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
            r0 = r0 ^ 122(0x7a, float:1.71E-43)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.view.FullScreenAdToolbar.A02(int, int, int):java.lang.String");
    }

    public static void A03() {
        A07 = new byte[]{29, 42, 63, 32, 61, 59, 111, 14, 43, 86, 121, 122, 102, 112, 53, 84, 113};
    }

    static {
        A03();
        A09 = (int) (10.0f * KE.A01);
        A0D = (int) (16.0f * KE.A01);
        A0B = A0D - A09;
        A0C = (A0D * 2) - A09;
        A0A = (int) (4.0f * KE.A01);
        A08 = (int) (56.0f * KE.A01);
    }

    public FullScreenAdToolbar(C0362Ec c0362Ec, AnonymousClass81 anonymousClass81, C0432Gv c0432Gv, @ToolbarActionView$ToolbarActionMode int i, int i2) {
        super(c0362Ec);
        this.A04 = anonymousClass81;
        this.A02 = c0432Gv;
        setGravity(16);
        this.A05 = new ME(c0362Ec, i);
        this.A05.setContentDescription(A02(9, 8, 111));
        this.A05.setActionClickListener(new ViewOnClickListenerC0535Kz(this));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(A0B, A0B, A0C, A0B);
        addView(this.A05, layoutParams);
        this.A01 = new RelativeLayout(c0362Ec);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        layoutParams2.weight = 1.0f;
        this.A06 = new PC(c0362Ec);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 17;
        this.A06.setLayoutParams(layoutParams3);
        this.A01.addView(this.A06);
        addView(this.A01, layoutParams2);
        this.A03 = new C0523Kn(c0362Ec, i2);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams4.setMargins(0, A0D / 2, A0D / 2, A0D / 2);
        addView(this.A03, layoutParams4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x005b, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A04(com.facebook.ads.redexgen.X.C2T r7, boolean r8) {
        /*
            r6 = this;
            r4 = r6
            r0 = 0
            r0 = 0
            int r5 = r7.A04(r8)
            com.facebook.ads.redexgen.X.PC r1 = r4.A06
            int r0 = r7.A0A(r8)
            r1.A01(r0, r5)
            com.facebook.ads.redexgen.X.Kn r0 = r4.A03
            r0.setIconColors(r5)
            com.facebook.ads.redexgen.X.Kn r3 = r4.A03
            r2 = 0
            r1 = 9
            r0 = 53
            java.lang.String r0 = A02(r2, r1, r0)
            r3.setContentDescription(r0)
            com.facebook.ads.redexgen.X.ME r0 = r4.A05
            r0.setColors(r5)
            if (r8 == 0) goto L59
            r0 = 2
        L2b:
            switch(r0) {
                case 2: goto L2f;
                case 3: goto L5b;
                case 4: goto L51;
                default: goto L2e;
            }
        L2e:
            goto L2b
        L2f:
            com.facebook.ads.internal.view.FullScreenAdToolbar r4 = (com.facebook.ads.internal.view.FullScreenAdToolbar) r4
            r3 = 0
            android.graphics.drawable.GradientDrawable r2 = new android.graphics.drawable.GradientDrawable
            android.graphics.drawable.GradientDrawable$Orientation r1 = android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM
            r0 = 2
            int[] r0 = new int[r0]
            r0 = {x005c: FILL_ARRAY_DATA , data: [-1778384896, 0} // fill-array
            r2.<init>(r1, r0)
            r0 = 0
            r2.setCornerRadius(r0)
            com.facebook.ads.redexgen.X.KE.A0T(r4, r2)
            com.facebook.ads.redexgen.X.Kn r2 = r4.A03
            r1 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            int r0 = com.facebook.ads.internal.view.FullScreenAdToolbar.A0A
            com.facebook.ads.redexgen.X.KE.A0S(r2, r3, r1, r0)
            r0 = 3
            goto L2b
        L51:
            com.facebook.ads.internal.view.FullScreenAdToolbar r4 = (com.facebook.ads.internal.view.FullScreenAdToolbar) r4
            r0 = 0
            com.facebook.ads.redexgen.X.KE.A0P(r4, r0)
            r0 = 3
            goto L2b
        L59:
            r0 = 4
            goto L2b
        L5b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.view.FullScreenAdToolbar.A04(com.facebook.ads.redexgen.X.2T, boolean):void");
    }

    public final boolean A05() {
        return this.A05.A01();
    }

    public int getToolbarHeight() {
        return A08;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0014, code lost:            r1.setVisibility(r2);     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0019, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setAdReportingVisible(boolean r4) {
        /*
            r3 = this;
            r2 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.Kn r1 = r3.A03
            if (r4 == 0) goto L12
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L14;
                case 4: goto Le;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            r2 = 0
            r0 = 3
            goto L7
        Le:
            r2 = 8
            r0 = 3
            goto L7
        L12:
            r0 = 4
            goto L7
        L14:
            com.facebook.ads.redexgen.X.Kn r1 = (com.facebook.ads.redexgen.X.C0523Kn) r1
            r1.setVisibility(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.view.FullScreenAdToolbar.setAdReportingVisible(boolean):void");
    }

    public void setPageDetails(C00572c c00572c, String str, int i, C00652k c00652k) {
        this.A05.setInitialUnskippableSeconds(i);
        this.A06.setPageDetails(c00572c);
        this.A03.setAdDetails(c00572c, str, this.A02, this.A04);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x002c, code lost:            r2.setToolbarMessageEnabled(r3);     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0031, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setPageDetailsVisible(boolean r6) {
        /*
            r5 = this;
            r4 = r5
            r3 = 0
            r2 = 0
            android.widget.RelativeLayout r0 = r4.A01
            r0.removeAllViews()
            if (r6 == 0) goto L2a
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L1d;
                case 4: goto L27;
                case 5: goto L2c;
                case 6: goto L1a;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            com.facebook.ads.internal.view.FullScreenAdToolbar r4 = (com.facebook.ads.internal.view.FullScreenAdToolbar) r4
            android.widget.RelativeLayout r1 = r4.A01
            com.facebook.ads.redexgen.X.PC r0 = r4.A06
            r1.addView(r0)
            r0 = 3
            goto Lb
        L1a:
            r3 = 0
            r0 = 5
            goto Lb
        L1d:
            com.facebook.ads.internal.view.FullScreenAdToolbar r4 = (com.facebook.ads.internal.view.FullScreenAdToolbar) r4
            com.facebook.ads.redexgen.X.ME r2 = r4.A05
            if (r6 != 0) goto L25
            r0 = 4
            goto Lb
        L25:
            r0 = 6
            goto Lb
        L27:
            r3 = 1
            r0 = 5
            goto Lb
        L2a:
            r0 = 3
            goto Lb
        L2c:
            com.facebook.ads.redexgen.X.ME r2 = (com.facebook.ads.redexgen.X.ME) r2
            r2.setToolbarMessageEnabled(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.view.FullScreenAdToolbar.setPageDetailsVisible(boolean):void");
    }

    public void setProgress(float f) {
        this.A05.setProgress(f);
    }

    public void setToolbarActionMessage(String str) {
        this.A05.setToolbarMessage(str);
    }

    public void setToolbarActionMode(@ToolbarActionView$ToolbarActionMode int i) {
        this.A05.setToolbarActionMode(i);
    }

    public void setToolbarListener(L0 l0) {
        this.A00 = l0;
    }
}
