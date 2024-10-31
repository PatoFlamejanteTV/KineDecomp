package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Ok, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0622Ok implements JV {
    public final /* synthetic */ int A00;
    public final /* synthetic */ AbstractRunnableC00351g A01;
    public final /* synthetic */ AbstractC0625On A02;

    public C0622Ok(AbstractC0625On abstractC0625On, int i, AbstractRunnableC00351g abstractRunnableC00351g) {
        this.A02 = abstractC0625On;
        this.A00 = i;
        this.A01 = abstractRunnableC00351g;
    }

    @Override // com.facebook.ads.redexgen.X.JV
    public final void A6O() {
        this.A01.run();
    }

    @Override // com.facebook.ads.redexgen.X.JV
    public final void A7K(float f) {
        this.A02.A08.setProgress(100.0f * (1.0f - (f / this.A00)));
    }
}
