package com.facebook.ads.redexgen.X;

import android.os.SystemClock;

/* loaded from: assets/audience_network.dex */
public class DE implements InterfaceC0267Al {
    public final /* synthetic */ DG A00;

    public DE(DG dg) {
        this.A00 = dg;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0267Al
    public final AbstractC0351Dr A44() {
        return this.A00.A03(((float) SystemClock.elapsedRealtime()) / 1000.0f);
    }
}
