package com.facebook.ads.redexgen.X;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.Me, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC0565Me implements View.OnClickListener {
    public final /* synthetic */ C0568Mh A00;

    public ViewOnClickListenerC0565Me(C0568Mh c0568Mh) {
        this.A00 = c0568Mh;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            this.A00.A0A.A74(AnonymousClass44.A03);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }
}
