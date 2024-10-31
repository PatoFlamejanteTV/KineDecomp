package com.facebook.ads.redexgen.X;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.Pd, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0641Pd {
    public final C2J A00;
    public final C2S A01;
    public final C2V A02;
    public final C00572c A03;
    public final C0362Ec A04;
    public final C0432Gv A05;
    public static final int A08 = (int) (4.0f * KE.A01);
    public static final int A06 = (int) (72.0f * KE.A01);
    public static final int A07 = (int) (8.0f * KE.A01);

    public C0641Pd(C0362Ec c0362Ec, InterfaceC0422Gl interfaceC0422Gl, C2I c2i) {
        this.A04 = c0362Ec;
        this.A05 = new C0432Gv(c2i.A0P(), interfaceC0422Gl);
        this.A00 = c2i.A0K();
        this.A01 = c2i.A0L().A0E();
        this.A03 = c2i.A0N();
        this.A02 = c2i.A0L().A0G();
    }

    private View A00() {
        C01807a c01807a = new C01807a(this.A04);
        c01807a.setLayoutManager(new C01636i(this.A04, 0, false));
        c01807a.setAdapter(new C0642Pe(this.A04, this.A02.A01(), A08));
        return c01807a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00aa, code lost:            return r5;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.view.View A01(@android.support.annotation.Nullable com.facebook.ads.redexgen.X.ViewOnClickListenerC0589Nc r13) {
        /*
            r12 = this;
            r0 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.No r6 = new com.facebook.ads.redexgen.X.No
            com.facebook.ads.redexgen.X.Ec r7 = r12.A04
            com.facebook.ads.redexgen.X.2J r0 = r12.A00
            com.facebook.ads.redexgen.X.2T r8 = r0.A01()
            r9 = 1
            r10 = 0
            r11 = 0
            r6.<init>(r7, r8, r9, r10, r11)
            com.facebook.ads.redexgen.X.2S r0 = r12.A01
            java.lang.String r7 = r0.A06()
            com.facebook.ads.redexgen.X.2S r0 = r12.A01
            java.lang.String r8 = r0.A01()
            r9 = 0
            r10 = 0
            r11 = 1
            r6.A00(r7, r8, r9, r10, r11)
            r0 = 17
            r6.setAlignment(r0)
            com.facebook.ads.redexgen.X.M4 r3 = new com.facebook.ads.redexgen.X.M4
            com.facebook.ads.redexgen.X.Ec r0 = r12.A04
            r3.<init>(r0)
            r0 = 0
            com.facebook.ads.redexgen.X.KE.A0P(r3, r0)
            r0 = 50
            r3.setRadius(r0)
            com.facebook.ads.redexgen.X.NR r1 = new com.facebook.ads.redexgen.X.NR
            com.facebook.ads.redexgen.X.Ec r0 = r12.A04
            r1.<init>(r3, r0)
            com.facebook.ads.redexgen.X.NR r1 = r1.A04()
            com.facebook.ads.redexgen.X.2c r0 = r12.A03
            java.lang.String r0 = r0.A01()
            r1.A07(r0)
            android.widget.LinearLayout r5 = new android.widget.LinearLayout
            com.facebook.ads.redexgen.X.Ec r0 = r12.A04
            r5.<init>(r0)
            r0 = 1
            r5.setOrientation(r0)
            r0 = 17
            r5.setGravity(r0)
            android.widget.LinearLayout$LayoutParams r2 = new android.widget.LinearLayout$LayoutParams
            int r1 = com.facebook.ads.redexgen.X.C0641Pd.A06
            int r0 = com.facebook.ads.redexgen.X.C0641Pd.A06
            r2.<init>(r1, r0)
            r5.addView(r3, r2)
            android.widget.LinearLayout$LayoutParams r4 = new android.widget.LinearLayout$LayoutParams
            r1 = -2
            r0 = -2
            r4.<init>(r1, r0)
            r3 = 0
            int r2 = com.facebook.ads.redexgen.X.C0641Pd.A07
            r1 = 0
            int r0 = com.facebook.ads.redexgen.X.C0641Pd.A07
            r4.setMargins(r3, r2, r1, r0)
            r5.addView(r6, r4)
            if (r13 == 0) goto La4
            r0 = 2
        L7f:
            switch(r0) {
                case 2: goto L83;
                case 3: goto L9d;
                case 4: goto La6;
                default: goto L82;
            }
        L82:
            goto L7f
        L83:
            com.facebook.ads.redexgen.X.Nc r13 = (com.facebook.ads.redexgen.X.ViewOnClickListenerC0589Nc) r13
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            android.widget.LinearLayout$LayoutParams r4 = (android.widget.LinearLayout.LayoutParams) r4
            com.facebook.ads.redexgen.X.KE.A0L(r13)
            r5.addView(r13, r4)
            java.lang.CharSequence r0 = r13.getText()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L9b
            r0 = 3
            goto L7f
        L9b:
            r0 = 4
            goto L7f
        L9d:
            com.facebook.ads.redexgen.X.Nc r13 = (com.facebook.ads.redexgen.X.ViewOnClickListenerC0589Nc) r13
            com.facebook.ads.redexgen.X.KE.A0J(r13)
            r0 = 4
            goto L7f
        La4:
            r0 = 4
            goto L7f
        La6:
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            android.view.View r5 = (android.view.View) r5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0641Pd.A01(com.facebook.ads.redexgen.X.Nc):android.view.View");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:            r3 = r3;        com.facebook.ads.redexgen.X.C0434Gx.A04(r3, r4.A05, com.facebook.ads.redexgen.X.EnumC0431Gu.A0R);     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003f, code lost:            return new android.util.Pair<>(r2, r3);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.util.Pair<com.facebook.ads.redexgen.X.EnumC0640Pc, android.view.View> A02(@android.support.annotation.Nullable com.facebook.ads.redexgen.X.ViewOnClickListenerC0589Nc r6) {
        /*
            r5 = this;
            r4 = r5
            r3 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.Pc r2 = r4.A03()
            int[] r1 = com.facebook.ads.redexgen.X.C0639Pb.A00
            int r0 = r2.ordinal()
            r0 = r1[r0]
            switch(r0) {
                case 1: goto L29;
                default: goto L12;
            }
        L12:
            r0 = 2
        L13:
            switch(r0) {
                case 2: goto L17;
                case 3: goto L2b;
                case 4: goto L21;
                default: goto L16;
            }
        L16:
            goto L13
        L17:
            com.facebook.ads.redexgen.X.Pd r4 = (com.facebook.ads.redexgen.X.C0641Pd) r4
            com.facebook.ads.redexgen.X.Nc r6 = (com.facebook.ads.redexgen.X.ViewOnClickListenerC0589Nc) r6
            android.view.View r3 = r4.A01(r6)
            r0 = 3
            goto L13
        L21:
            com.facebook.ads.redexgen.X.Pd r4 = (com.facebook.ads.redexgen.X.C0641Pd) r4
            android.view.View r3 = r4.A00()
            r0 = 3
            goto L13
        L29:
            r0 = 4
            goto L13
        L2b:
            com.facebook.ads.redexgen.X.Pd r4 = (com.facebook.ads.redexgen.X.C0641Pd) r4
            com.facebook.ads.redexgen.X.Pc r2 = (com.facebook.ads.redexgen.X.EnumC0640Pc) r2
            android.view.View r3 = (android.view.View) r3
            com.facebook.ads.redexgen.X.Gv r1 = r4.A05
            com.facebook.ads.redexgen.X.Gu r0 = com.facebook.ads.redexgen.X.EnumC0431Gu.A0R
            com.facebook.ads.redexgen.X.C0434Gx.A04(r3, r1, r0)
            android.util.Pair r0 = new android.util.Pair
            r0.<init>(r2, r3)
            android.util.Pair r0 = (android.util.Pair) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0641Pd.A02(com.facebook.ads.redexgen.X.Nc):android.util.Pair");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0020, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.X.EnumC0640Pc A03() {
        /*
            r2 = this;
            r1 = 0
            com.facebook.ads.redexgen.X.2V r0 = r2.A02
            java.util.List r0 = r0.A01()
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L1a
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L12;
                case 3: goto L1c;
                case 4: goto L16;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            com.facebook.ads.redexgen.X.Pc r1 = com.facebook.ads.redexgen.X.EnumC0640Pc.A03
            r0 = 3
            goto Le
        L16:
            com.facebook.ads.redexgen.X.Pc r1 = com.facebook.ads.redexgen.X.EnumC0640Pc.A02
            r0 = 3
            goto Le
        L1a:
            r0 = 4
            goto Le
        L1c:
            com.facebook.ads.redexgen.X.Pc r1 = (com.facebook.ads.redexgen.X.EnumC0640Pc) r1
            com.facebook.ads.redexgen.X.Pc r1 = (com.facebook.ads.redexgen.X.EnumC0640Pc) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0641Pd.A03():com.facebook.ads.redexgen.X.Pc");
    }
}
