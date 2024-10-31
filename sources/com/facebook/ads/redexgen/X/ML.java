package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

/* loaded from: assets/audience_network.dex */
public final class ML implements InterfaceC0524Ko {
    public static byte[] A0B;
    public int A00;
    public QA A01;
    public final C0362Ec A02;
    public final InterfaceC0422Gl A03;
    public final AnonymousClass81 A04;
    public final AnonymousClass83 A05;
    public final C0537Lb A06;
    public final AbstractC02178m A0A = new MF(this);
    public final AbstractC02198o A09 = new MG(this);
    public final AbstractC02238s A07 = new MH(this);
    public final AbstractC02278w A08 = new MI(this);

    static {
        A03();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A02(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.ML.A0B
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
            int r0 = r0 + (-95)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.ML.A02(int, int, int):java.lang.String");
    }

    public static void A03() {
        A0B = new byte[]{-30, -43, -48, -47, -37, -72, -37, -45, -45, -47, -34, 8, -5, -10, -9, 1, -37, 0, 6, -9, 4, 5, 6, -5, 6, -13, -2, -41, 8, -9, 0, 6, 31, 18, 13, 14, 24, -10, -7, -19, -32, -45, -50, -49, -39, -65, -68, -74, -27, -7, -8, -13, -12, -16, -27, -3, 78, 76, 62, 39, 58, 77, 66, 79, 62, 28, 77, 58, 27, 78, 77, 77, 72, 71, -17, -8, -11, -15, -6, 0, -32, -5, -9, -15, -6, 84, 71, 66, 67, 77, 49, 67, 67, 73, 50, 71, 75, 67};
    }

    public ML(C0362Ec c0362Ec, AnonymousClass83 anonymousClass83, InterfaceC0422Gl interfaceC0422Gl, AnonymousClass81 anonymousClass81) {
        this.A02 = c0362Ec;
        this.A03 = interfaceC0422Gl;
        this.A05 = anonymousClass83;
        this.A06 = new C0537Lb(c0362Ec);
        this.A06.A0S(new C0688Qy(c0362Ec));
        this.A06.getEventBus().A03(this.A0A, this.A09, this.A07, this.A08);
        this.A04 = anonymousClass81;
        this.A06.setIsFullScreen(true);
        this.A06.setVolume(1.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        anonymousClass81.A39(this.A06, layoutParams);
        C0534Ky c0534Ky = new C0534Ky(c0362Ec);
        c0534Ky.setOnClickListener(new MJ(this));
        anonymousClass81.A39(c0534Ky, c0534Ky.getDefaultLayoutParams());
    }

    public final void A04(int i) {
        this.A06.setVideoProgressReportIntervalMs(i);
    }

    public final void A05(View view) {
        this.A06.setControlsAnchorView(view);
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00fb, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0524Ko
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A5L(android.content.Intent r14, android.os.Bundle r15, com.facebook.ads.redexgen.X.AnonymousClass89 r16) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.ML.A5L(android.content.Intent, android.os.Bundle, com.facebook.ads.redexgen.X.89):void");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0524Ko
    public final void A7F(boolean z) {
        this.A04.A3c(A02(11, 21, 51), new QO());
        this.A06.A0L();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0524Ko
    public final void A7O(boolean z) {
        this.A04.A3c(A02(11, 21, 51), new QP());
        this.A06.A0Q(QH.A05);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0524Ko
    public final void A8E(Bundle bundle) {
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0524Ko
    public final void onDestroy() {
        this.A04.A3c(A02(11, 21, 51), new QU(this.A00, this.A06.getCurrentPositionInMillis()));
        this.A01.A0O(this.A06.getCurrentPositionInMillis());
        this.A06.A0N();
        this.A06.A0K();
    }
}
