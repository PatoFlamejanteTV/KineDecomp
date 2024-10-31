package com.facebook.ads.redexgen.X;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.Mr, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC0578Mr implements View.OnClickListener {
    public final /* synthetic */ AnonymousClass46 A00;
    public final /* synthetic */ C0564Mc A01;
    public final /* synthetic */ C0579Ms A02;

    public ViewOnClickListenerC0578Mr(C0579Ms c0579Ms, C0564Mc c0564Mc, AnonymousClass46 anonymousClass46) {
        this.A02 = c0579Ms;
        this.A01 = c0564Mc;
        this.A00 = anonymousClass46;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MX mx;
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            this.A01.A01();
            mx = this.A02.A02;
            mx.A7B(this.A00);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }
}
