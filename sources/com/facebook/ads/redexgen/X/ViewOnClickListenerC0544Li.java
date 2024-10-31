package com.facebook.ads.redexgen.X;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.Li, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC0544Li implements View.OnClickListener {
    public final /* synthetic */ C0549Ln A00;

    public ViewOnClickListenerC0544Li(C0549Ln c0549Ln) {
        this.A00 = c0549Ln;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            this.A00.A0Q(false);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }
}
