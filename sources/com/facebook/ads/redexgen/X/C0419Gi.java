package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Gi, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0419Gi extends AbstractRunnableC00351g {
    public final /* synthetic */ C0421Gk A00;

    public C0419Gi(C0421Gk c0421Gk) {
        this.A00 = c0421Gk;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00351g
    public final void A05() {
        long j;
        long j2;
        C0421Gk.A00(this.A00);
        j = this.A00.A01;
        if (j > 0) {
            try {
                j2 = this.A00.A01;
                Thread.sleep(j2);
            } catch (InterruptedException unused) {
            }
        }
        this.A00.A0B();
    }
}
