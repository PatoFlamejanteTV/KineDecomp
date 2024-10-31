package com.facebook.ads.redexgen.X;

import java.util.Locale;

/* renamed from: com.facebook.ads.redexgen.X.Ca, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0308Ca implements InterfaceC0267Al {
    public final /* synthetic */ C0311Cd A00;

    public C0308Ca(C0311Cd c0311Cd) {
        this.A00 = c0311Cd;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0267Al
    public final AbstractC0351Dr A44() {
        return this.A00.A08(Locale.getDefault().getCountry());
    }
}
