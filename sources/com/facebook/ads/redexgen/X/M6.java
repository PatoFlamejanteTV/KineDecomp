package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/* loaded from: assets/audience_network.dex */
public final class M6 extends QJ {
    public final ImageView A00;
    public final C0362Ec A01;
    public final C1S<QM> A02;
    public final C1S<QR> A03;

    public M6(C0362Ec c0362Ec) {
        super(c0362Ec);
        this.A03 = new M8(this);
        this.A02 = new M7(this);
        this.A01 = c0362Ec;
        this.A00 = new ImageView(c0362Ec);
        this.A00.setScaleType(ImageView.ScaleType.FIT_CENTER);
        KE.A0P(this.A00, -16777216);
        this.A00.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(this.A00);
    }

    @Override // com.facebook.ads.redexgen.X.QJ
    public final void A09() {
        super.A09();
        if (getVideoView() != null) {
            getVideoView().getEventBus().A03(this.A03, this.A02);
        }
    }

    @Override // com.facebook.ads.redexgen.X.QJ
    public final void A0A() {
        if (getVideoView() != null) {
            getVideoView().getEventBus().A04(this.A02, this.A03);
        }
        super.A0A();
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.A00.layout(0, 0, i3 - i, i4 - i2);
    }

    public void setImage(@Nullable String str) {
        setImage(str, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0041, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setImage(@android.support.annotation.Nullable java.lang.String r5, @android.support.annotation.Nullable com.facebook.ads.redexgen.X.C2B r6) {
        /*
            r4 = this;
            r3 = r4
            r1 = 0
            if (r5 != 0) goto L3f
            r0 = 2
        L5:
            switch(r0) {
                case 2: goto L9;
                case 3: goto L41;
                case 4: goto L12;
                case 5: goto L2d;
                case 6: goto L36;
                default: goto L8;
            }
        L8:
            goto L5
        L9:
            com.facebook.ads.redexgen.X.M6 r3 = (com.facebook.ads.redexgen.X.M6) r3
            r0 = 8
            r3.setVisibility(r0)
            r0 = 3
            goto L5
        L12:
            com.facebook.ads.redexgen.X.M6 r3 = (com.facebook.ads.redexgen.X.M6) r3
            com.facebook.ads.redexgen.X.2B r6 = (com.facebook.ads.redexgen.X.C2B) r6
            r0 = 0
            r3.setVisibility(r0)
            com.facebook.ads.redexgen.X.NR r2 = new com.facebook.ads.redexgen.X.NR
            android.widget.ImageView r1 = r3.A00
            com.facebook.ads.redexgen.X.Ec r0 = r3.A01
            r2.<init>(r1, r0)
            com.facebook.ads.redexgen.X.NR r1 = r2.A04()
            if (r6 == 0) goto L2b
            r0 = 5
            goto L5
        L2b:
            r0 = 6
            goto L5
        L2d:
            com.facebook.ads.redexgen.X.2B r6 = (com.facebook.ads.redexgen.X.C2B) r6
            com.facebook.ads.redexgen.X.NR r1 = (com.facebook.ads.redexgen.X.NR) r1
            r1.A06(r6)
            r0 = 6
            goto L5
        L36:
            java.lang.String r5 = (java.lang.String) r5
            com.facebook.ads.redexgen.X.NR r1 = (com.facebook.ads.redexgen.X.NR) r1
            r1.A07(r5)
            r0 = 3
            goto L5
        L3f:
            r0 = 4
            goto L5
        L41:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.M6.setImage(java.lang.String, com.facebook.ads.redexgen.X.2B):void");
    }
}
