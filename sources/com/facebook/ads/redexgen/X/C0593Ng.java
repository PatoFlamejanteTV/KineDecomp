package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Ng, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0593Ng extends AbstractRunnableC00351g {
    public final /* synthetic */ C0588Nb A00;

    public C0593Ng(C0588Nb c0588Nb) {
        this.A00 = c0588Nb;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00351g
    public final void A05() {
        float f;
        int i;
        this.A00.clearAnimation();
        f = this.A00.A04;
        KE.A0G(1000, f, this.A00);
        C0588Nb c0588Nb = this.A00;
        i = this.A00.A05;
        c0588Nb.postDelayed(this, i);
    }
}
