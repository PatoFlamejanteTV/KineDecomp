package com.facebook.ads.redexgen.X;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.Mq, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC0577Mq implements View.OnClickListener {
    public final /* synthetic */ C0579Ms A00;

    public ViewOnClickListenerC0577Mq(C0579Ms c0579Ms) {
        this.A00 = c0579Ms;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MX mx;
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            mx = this.A00.A02;
            mx.A52();
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }
}
