package com.facebook.ads.redexgen.X;

/* loaded from: assets/audience_network.dex */
public final class L3 extends C01636i {
    public float A00;
    public int A01;
    public int A02;
    public L2 A03;
    public int[] A04;
    public final C0362Ec A05;
    public final P7 A06;
    public final P8 A07;

    public L3(C0362Ec c0362Ec, P8 p8, P7 p7) {
        super(c0362Ec);
        this.A02 = 0;
        this.A00 = 50.0f;
        this.A05 = c0362Ec;
        this.A07 = p8;
        this.A06 = p7;
        this.A01 = -1;
        this.A03 = new L2(this, this.A05);
    }

    /* JADX WARN: Code restructure failed: missing block: B:160:0x01a7, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.AbstractC01616g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A1J(com.facebook.ads.redexgen.X.C7O r18, com.facebook.ads.redexgen.X.C7W r19, int r20, int r21) {
        /*
            Method dump skipped, instructions count: 488
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.L3.A1J(com.facebook.ads.redexgen.X.7O, com.facebook.ads.redexgen.X.7W, int, int):void");
    }

    @Override // com.facebook.ads.redexgen.X.C01636i, com.facebook.ads.redexgen.X.AbstractC01616g
    public final void A1t(int i) {
        super.A2F(i, this.A02);
    }

    @Override // com.facebook.ads.redexgen.X.C01636i, com.facebook.ads.redexgen.X.AbstractC01616g
    public final void A21(C01807a c01807a, C7W c7w, int i) {
        this.A03.A0A(i);
        A1L(this.A03);
    }

    public final void A2K(double d) {
        if (d <= 0.0d) {
            d = 1.0d;
        }
        this.A00 = (float) (50.0d / d);
        this.A03 = new L2(this, this.A05);
    }

    public final void A2L(int i) {
        this.A01 = i;
    }

    public final void A2M(int i) {
        this.A02 = i;
    }
}
