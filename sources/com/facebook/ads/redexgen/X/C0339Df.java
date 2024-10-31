package com.facebook.ads.redexgen.X;

import android.net.TrafficStats;

/* renamed from: com.facebook.ads.redexgen.X.Df, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0339Df implements InterfaceC0267Al {
    public final /* synthetic */ C0340Dg A00;

    public C0339Df(C0340Dg c0340Dg) {
        this.A00 = c0340Dg;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0267Al
    public final AbstractC0351Dr A44() {
        return this.A00.A06(EJ.A02(TrafficStats.getTotalTxBytes()));
    }
}
