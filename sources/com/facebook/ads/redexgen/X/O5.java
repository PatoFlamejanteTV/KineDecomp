package com.facebook.ads.redexgen.X;

/* loaded from: assets/audience_network.dex */
public class O5 extends AbstractRunnableC00351g {
    public final /* synthetic */ OD A00;

    public O5(OD od) {
        this.A00 = od;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00351g
    public final void A05() {
        OG og;
        og = this.A00.A0F;
        KE.A0H(1000, og);
        this.A00.postDelayed(this, 2000L);
    }
}
