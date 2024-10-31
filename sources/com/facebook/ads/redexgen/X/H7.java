package com.facebook.ads.redexgen.X;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: assets/audience_network.dex */
public class H7 implements H6 {
    public final /* synthetic */ HH A00;

    public H7(HH hh) {
        this.A00 = hh;
    }

    @Override // com.facebook.ads.redexgen.X.H6
    public final void A7a() {
        AtomicBoolean atomicBoolean;
        HF hf;
        HF hf2;
        AtomicBoolean atomicBoolean2;
        atomicBoolean = this.A00.A0E;
        atomicBoolean.set(true);
        hf = this.A00.A02;
        if (hf == null) {
            return;
        }
        hf2 = this.A00.A02;
        atomicBoolean2 = this.A00.A0D;
        hf2.A7G(atomicBoolean2.get());
    }
}
