package com.facebook.ads.redexgen.X;

import android.view.View;

/* loaded from: assets/audience_network.dex */
public class MT implements View.OnClickListener {
    public final /* synthetic */ MW A00;

    public MT(MW mw) {
        this.A00 = mw;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        MX mx;
        MX mx2;
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            z = this.A00.A04;
            if (z) {
                mx2 = this.A00.A03;
                mx2.A3g();
            } else {
                mx = this.A00.A03;
                mx.A3h();
            }
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }
}
