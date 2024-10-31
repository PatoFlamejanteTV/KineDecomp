package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Kt, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0529Kt implements InterfaceC0528Ks {
    public final /* synthetic */ C0530Ku A00;

    public C0529Kt(C0530Ku c0530Ku) {
        this.A00 = c0530Ku;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0528Ks
    public final void A7C(String str) {
        N4 n4;
        n4 = this.A00.A0A;
        n4.setProgress(100);
        this.A00.A05 = false;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0528Ks
    public final void A7E(String str) {
        N3 n3;
        this.A00.A05 = true;
        n3 = this.A00.A09;
        n3.setUrl(str);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0528Ks
    public final void A7L(int i) {
        boolean z;
        N4 n4;
        z = this.A00.A05;
        if (!z) {
            return;
        }
        n4 = this.A00.A0A;
        n4.setProgress(i);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0528Ks
    public final void A7N(String str) {
        N3 n3;
        n3 = this.A00.A09;
        n3.setTitle(str);
    }
}
