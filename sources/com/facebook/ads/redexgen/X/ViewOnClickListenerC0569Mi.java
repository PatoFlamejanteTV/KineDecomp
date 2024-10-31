package com.facebook.ads.redexgen.X;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.Mi, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC0569Mi implements View.OnClickListener {
    public final /* synthetic */ C0575Mo A00;

    public ViewOnClickListenerC0569Mi(C0575Mo c0575Mo) {
        this.A00 = c0575Mo;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            this.A00.A0A.A52();
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }
}
