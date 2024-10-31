package com.facebook.ads.redexgen.X;

import android.R;

/* loaded from: assets/audience_network.dex */
public class LQ extends AbstractRunnableC00351g {
    public final /* synthetic */ LR A00;

    public LQ(LR lr) {
        this.A00 = lr;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00351g
    public final void A05() {
        this.A00.A00.finish();
        this.A00.A00.A0H().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
