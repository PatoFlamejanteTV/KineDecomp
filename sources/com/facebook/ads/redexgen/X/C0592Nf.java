package com.facebook.ads.redexgen.X;

import android.support.annotation.RequiresApi;

/* renamed from: com.facebook.ads.redexgen.X.Nf, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0592Nf extends AbstractRunnableC00351g {
    public final /* synthetic */ C0588Nb A00;

    public C0592Nf(C0588Nb c0588Nb) {
        this.A00 = c0588Nb;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00351g
    @RequiresApi(api = 16)
    public final void A05() {
        Runnable runnable;
        int i;
        this.A00.setPressed(false);
        C0588Nb c0588Nb = this.A00;
        runnable = this.A00.A07;
        i = this.A00.A05;
        c0588Nb.postOnAnimationDelayed(runnable, i);
    }
}
