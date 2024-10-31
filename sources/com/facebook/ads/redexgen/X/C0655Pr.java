package com.facebook.ads.redexgen.X;

import android.os.Handler;

/* renamed from: com.facebook.ads.redexgen.X.Pr, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0655Pr extends AbstractRunnableC00351g {
    public final /* synthetic */ C0537Lb A00;

    public C0655Pr(C0537Lb c0537Lb) {
        this.A00 = c0537Lb;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00351g
    public final void A05() {
        boolean z;
        GY gy;
        Handler handler;
        int i;
        z = this.A00.A03;
        if (!z) {
            gy = this.A00.A0B;
            gy.A02(new QT(this.A00.getCurrentPositionInMillis()));
            handler = this.A00.A07;
            i = this.A00.A00;
            handler.postDelayed(this, i);
        }
    }
}
