package com.facebook.ads.redexgen.X;

/* loaded from: assets/audience_network.dex */
public class O9 implements InterfaceC0528Ks {
    public final /* synthetic */ OD A00;

    public O9(OD od) {
        this.A00 = od;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0528Ks
    public final void A7C(String str) {
        N4 n4;
        N4 n42;
        this.A00.A0I = false;
        n4 = this.A00.A0C;
        n4.setProgress(100);
        n42 = this.A00.A0C;
        KE.A0Q(n42, 8);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0528Ks
    public final void A7E(String str) {
        N4 n4;
        N3 n3;
        this.A00.A0I = true;
        n4 = this.A00.A0C;
        KE.A0Q(n4, 0);
        n3 = this.A00.A0B;
        n3.setUrl(str);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0528Ks
    public final void A7L(int i) {
        boolean z;
        N4 n4;
        z = this.A00.A0I;
        if (!z) {
            return;
        }
        n4 = this.A00.A0C;
        n4.setProgress(i);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0528Ks
    public final void A7N(String str) {
        N3 n3;
        n3 = this.A00.A0B;
        n3.setTitle(str);
    }
}
