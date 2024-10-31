package com.facebook.ads.redexgen.X;

import android.widget.RelativeLayout;

/* renamed from: com.facebook.ads.redexgen.X.Mh, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0568Mh extends MZ {
    public static final int A02 = (int) (8.0f * KE.A01);
    public final RelativeLayout A00;
    public final C0362Ec A01;

    public C0568Mh(C0362Ec c0362Ec, InterfaceC0422Gl interfaceC0422Gl, String str, C00572c c00572c, InterfaceC0524Ko interfaceC0524Ko, AnonymousClass81 anonymousClass81) {
        super(c0362Ec, interfaceC0422Gl, str, c00572c, interfaceC0524Ko, anonymousClass81);
        this.A01 = c0362Ec;
        this.A00 = new RelativeLayout(getContext());
        addView(this.A00, new RelativeLayout.LayoutParams(-1, -1));
        KE.A0P(this.A00, -1728053248);
        this.A00.setOnClickListener(new Md(this));
    }

    public static RelativeLayout.LayoutParams A0A(boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, z ? -1 : -2);
        layoutParams.addRule(12);
        return layoutParams;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0036, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0B() {
        /*
            r4 = this;
            r3 = r4
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 21
            if (r1 < r0) goto L34
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L36;
                case 4: goto L2d;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.Mh r3 = (com.facebook.ads.redexgen.X.C0568Mh) r3
            android.transition.TransitionSet r2 = new android.transition.TransitionSet
            r2.<init>()
            r0 = 0
            r2.setOrdering(r0)
            android.transition.ChangeBounds r0 = new android.transition.ChangeBounds
            r0.<init>()
            android.transition.TransitionSet r1 = r2.addTransition(r0)
            android.transition.Explode r0 = new android.transition.Explode
            r0.<init>()
            r1.addTransition(r0)
            com.facebook.ads.redexgen.X.KE.A0W(r3, r2)
            r0 = 3
            goto L8
        L2d:
            com.facebook.ads.redexgen.X.Mh r3 = (com.facebook.ads.redexgen.X.C0568Mh) r3
            com.facebook.ads.redexgen.X.KE.A0U(r3)
            r0 = 3
            goto L8
        L34:
            r0 = 4
            goto L8
        L36:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0568Mh.A0B():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00ea, code lost:            r1 = r12;        r3 = r3;        r3.addView(r5, r4);        r1.A0B();        r1.A00.removeAllViews();        r1.A00.addView(r3, A0A(false));     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0108, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.MZ
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0K() {
        /*
            Method dump skipped, instructions count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0568Mh.A0K():void");
    }

    @Override // com.facebook.ads.redexgen.X.MZ
    public final void A0L() {
        KE.A0K(this);
        this.A00.removeAllViews();
        KE.A0L(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:86:0x00fd, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.MZ
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0M(com.facebook.ads.redexgen.X.AnonymousClass46 r17, com.facebook.ads.redexgen.X.AnonymousClass44 r18) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0568Mh.A0M(com.facebook.ads.redexgen.X.46, com.facebook.ads.redexgen.X.44):void");
    }

    @Override // com.facebook.ads.redexgen.X.MZ
    public final void A0N(AnonymousClass46 anonymousClass46, AnonymousClass44 anonymousClass44) {
        String A0B;
        boolean isReportFlow = anonymousClass44 == AnonymousClass44.A05;
        C0362Ec c0362Ec = this.A01;
        MX mx = this.A0A;
        if (isReportFlow) {
            A0B = AnonymousClass43.A0F(this.A01.A00());
        } else {
            A0B = AnonymousClass43.A0B(this.A01.A00());
        }
        C0579Ms c0579Ms = new C0579Ms(c0362Ec, anonymousClass46, mx, A0B, isReportFlow ? KM.REPORT_AD : KM.HIDE_AD);
        c0579Ms.setClickable(true);
        KE.A0P(c0579Ms, -1);
        c0579Ms.setPadding(A02 * 2, A02, A02 * 2, A02);
        A0B();
        this.A00.removeAllViews();
        this.A00.addView(c0579Ms, A0A(false));
    }

    @Override // com.facebook.ads.redexgen.X.MZ
    public final boolean A0O() {
        return false;
    }
}
