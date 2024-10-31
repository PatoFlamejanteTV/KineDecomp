package com.facebook.ads.redexgen.X;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.Mt, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC0580Mt implements View.OnClickListener {
    public final /* synthetic */ C0585My A00;

    public ViewOnClickListenerC0580Mt(C0585My c0585My) {
        this.A00 = c0585My;
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
