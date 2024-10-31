package com.facebook.ads.redexgen.X;

import android.os.Handler;

/* loaded from: assets/audience_network.dex */
public class JU extends AbstractRunnableC00351g {
    public final /* synthetic */ JW A00;

    public JU(JW jw) {
        this.A00 = jw;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00351g
    public final void A05() {
        Handler handler;
        if (!this.A00.A05()) {
            return;
        }
        this.A00.A01();
        handler = this.A00.A03;
        handler.postDelayed(this, 250L);
    }
}
