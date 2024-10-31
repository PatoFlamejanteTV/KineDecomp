package com.facebook.ads.redexgen.X;

import java.lang.ref.WeakReference;

/* loaded from: assets/audience_network.dex */
public class NI extends AbstractRunnableC00351g {
    public final WeakReference<FP> A00;

    public NI(FP fp) {
        this.A00 = new WeakReference<>(fp);
    }

    public NI(WeakReference<FP> weakReference) {
        this.A00 = weakReference;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00351g
    public final void A05() {
        FP fp = this.A00.get();
        if (fp != null) {
            fp.A0V();
        }
    }
}
