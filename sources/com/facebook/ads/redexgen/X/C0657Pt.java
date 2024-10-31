package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Pt, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0657Pt extends AbstractRunnableC00351g {
    public final /* synthetic */ int A00;
    public final /* synthetic */ int A01;
    public final /* synthetic */ C0537Lb A02;

    public C0657Pt(C0537Lb c0537Lb, int i, int i2) {
        this.A02 = c0537Lb;
        this.A00 = i;
        this.A01 = i2;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00351g
    public final void A05() {
        GY gy;
        gy = this.A02.A0B;
        gy.A02(new QU(this.A00, this.A01));
    }
}
