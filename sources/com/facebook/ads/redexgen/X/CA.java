package com.facebook.ads.redexgen.X;

import android.os.Build;

/* loaded from: assets/audience_network.dex */
public class CA implements InterfaceC0267Al {
    public final /* synthetic */ CD A00;

    public CA(CD cd) {
        this.A00 = cd;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0267Al
    public final AbstractC0351Dr A44() {
        return this.A00.A08(Build.HARDWARE);
    }
}
