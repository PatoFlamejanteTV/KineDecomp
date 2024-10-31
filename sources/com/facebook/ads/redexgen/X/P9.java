package com.facebook.ads.redexgen.X;

import android.view.View;

/* loaded from: assets/audience_network.dex */
public class P9 extends AbstractC02238s {
    public final /* synthetic */ C0563Mb A00;

    public P9(C0563Mb c0563Mb) {
        this.A00 = c0563Mb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C1S
    /* renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A03(QM qm) {
        NA na;
        View view;
        View view2;
        na = this.A00.A02;
        if (na != NA.A03) {
            view = this.A00.A00;
            view.setAlpha(1.0f);
            view2 = this.A00.A00;
            view2.setVisibility(0);
        }
    }
}
