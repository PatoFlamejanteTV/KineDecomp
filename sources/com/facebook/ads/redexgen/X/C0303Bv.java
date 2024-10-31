package com.facebook.ads.redexgen.X;

import android.os.Build;

/* renamed from: com.facebook.ads.redexgen.X.Bv, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0303Bv implements InterfaceC0267Al {
    public final /* synthetic */ CD A00;

    public C0303Bv(CD cd) {
        this.A00 = cd;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0267Al
    public final AbstractC0351Dr A44() {
        return this.A00.A06(Build.TIME / 1000);
    }
}
