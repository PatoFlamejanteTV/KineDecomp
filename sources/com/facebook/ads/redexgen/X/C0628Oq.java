package com.facebook.ads.redexgen.X;

import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.ads.redexgen.X.Oq, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0628Oq implements C2B {
    public final /* synthetic */ C0629Or A00;

    public C0628Oq(C0629Or c0629Or) {
        this.A00 = c0629Or;
    }

    @Override // com.facebook.ads.redexgen.X.C2B
    public final void A6h(boolean z) {
        AtomicBoolean atomicBoolean;
        atomicBoolean = this.A00.A03;
        atomicBoolean.set(z);
        this.A00.A05();
    }
}
