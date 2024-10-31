package com.facebook.ads.redexgen.X;

import java.lang.ref.WeakReference;

/* loaded from: assets/audience_network.dex */
public class OP implements C2B {
    public final WeakReference<OH> A00;

    public OP(OH oh) {
        this.A00 = new WeakReference<>(oh);
    }

    public /* synthetic */ OP(OH oh, OJ oj) {
        this(oh);
    }

    @Override // com.facebook.ads.redexgen.X.C2B
    public final void A6h(boolean z) {
        OH oh = this.A00.get();
        if (oh != null) {
            oh.A06 = z;
            oh.A02();
        }
    }
}
