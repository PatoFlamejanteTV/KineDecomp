package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.api.BuildConfigApi;

/* loaded from: assets/audience_network.dex */
public class GD implements InterfaceC0369Ej {
    public final /* synthetic */ C0361Eb A00;
    public final /* synthetic */ GI A01;

    public GD(GI gi, C0361Eb c0361Eb) {
        this.A01 = gi;
        this.A00 = c0361Eb;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0369Ej
    public final String A4f() {
        return IW.A03(this.A00);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0369Ej
    public final boolean A5A() {
        return BuildConfigApi.isDebug();
    }
}
