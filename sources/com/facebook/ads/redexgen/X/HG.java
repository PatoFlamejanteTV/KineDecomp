package com.facebook.ads.redexgen.X;

import java.lang.ref.WeakReference;

/* loaded from: assets/audience_network.dex */
public class HG implements HF {
    public WeakReference<HX> A00;

    public HG(HX hx) {
        this.A00 = new WeakReference<>(hx);
    }

    @Override // com.facebook.ads.redexgen.X.HF
    public final void A7G(boolean z) {
        if (this.A00.get() != null) {
            this.A00.get().A1S(z, false);
        }
    }
}
