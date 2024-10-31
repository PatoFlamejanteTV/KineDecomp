package com.facebook.ads.redexgen.X;

import android.view.View;

/* loaded from: assets/audience_network.dex */
public class MJ implements View.OnClickListener {
    public final /* synthetic */ ML A00;

    public MJ(ML ml) {
        this.A00 = ml;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        AnonymousClass83 anonymousClass83;
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            anonymousClass83 = this.A00.A05;
            anonymousClass83.A6e();
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }
}
