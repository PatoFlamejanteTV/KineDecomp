package com.facebook.ads.redexgen.X;

import java.util.concurrent.ThreadPoolExecutor;

/* renamed from: com.facebook.ads.redexgen.X.Gj, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0420Gj extends AbstractRunnableC00351g {
    public final /* synthetic */ C0421Gk A00;

    public C0420Gj(C0421Gk c0421Gk) {
        this.A00 = c0421Gk;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00351g
    public final void A05() {
        ThreadPoolExecutor threadPoolExecutor;
        ThreadPoolExecutor threadPoolExecutor2;
        Runnable runnable;
        this.A00.A0D = false;
        threadPoolExecutor = this.A00.A0C;
        if (!threadPoolExecutor.getQueue().isEmpty()) {
            return;
        }
        threadPoolExecutor2 = this.A00.A0C;
        runnable = this.A00.A0B;
        threadPoolExecutor2.execute(runnable);
    }
}
