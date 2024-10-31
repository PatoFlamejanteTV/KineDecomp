package com.facebook.ads.redexgen.X;

import android.view.View;

/* loaded from: assets/audience_network.dex */
public class PK implements View.OnClickListener {
    public final /* synthetic */ PL A00;

    public PK(PL pl) {
        this.A00 = pl;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ID id;
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            id = this.A00.A04;
            id.performClick();
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }
}
