package com.facebook.ads.redexgen.X;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.Mj, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC0570Mj implements View.OnClickListener {
    public final /* synthetic */ C0564Mc A00;
    public final /* synthetic */ C0575Mo A01;

    public ViewOnClickListenerC0570Mj(C0575Mo c0575Mo, C0564Mc c0564Mc) {
        this.A01 = c0575Mo;
        this.A00 = c0564Mc;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            this.A00.A01();
            this.A01.A0A.A74(AnonymousClass44.A03);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }
}
