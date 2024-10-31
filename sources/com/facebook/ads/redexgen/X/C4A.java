package com.facebook.ads.redexgen.X;

import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.4A, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public abstract class C4A implements C4V {
    public final EnumC01294w A00;
    public final C01244r A01;

    public C4A(C01244r c01244r, EnumC01294w enumC01294w) {
        this.A01 = c01244r;
        this.A00 = enumC01294w;
    }

    @Override // com.facebook.ads.redexgen.X.C4V
    public void A3B(Map<InterfaceC01455p, AnonymousClass06> map, Map<InterfaceC01254s, EnumC01294w> map2) {
        map2.put(this.A01, this.A00);
    }
}
