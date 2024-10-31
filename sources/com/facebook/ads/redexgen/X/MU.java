package com.facebook.ads.redexgen.X;

import android.view.View;

/* loaded from: assets/audience_network.dex */
public class MU implements View.OnClickListener {
    public final /* synthetic */ MW A00;

    public MU(MW mw) {
        this.A00 = mw;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MX mx;
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            mx = this.A00.A03;
            mx.A5J();
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }
}
