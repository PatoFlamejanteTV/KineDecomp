package com.facebook.ads.redexgen.X;

/* loaded from: assets/audience_network.dex */
public class LU implements JV {
    public final /* synthetic */ int A00;
    public final /* synthetic */ LC A01;

    public LU(LC lc, int i) {
        this.A01 = lc;
        this.A00 = i;
    }

    @Override // com.facebook.ads.redexgen.X.JV
    public final void A6O() {
        this.A01.A03 = false;
        this.A01.A06();
        this.A01.A0D.setToolbarActionMode(this.A01.getCloseButtonStyle());
    }

    @Override // com.facebook.ads.redexgen.X.JV
    public final void A7K(float f) {
        this.A01.A0D.setProgress(100.0f * (1.0f - (f / this.A00)));
    }
}
