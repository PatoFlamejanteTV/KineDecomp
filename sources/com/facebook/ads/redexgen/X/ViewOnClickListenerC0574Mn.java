package com.facebook.ads.redexgen.X;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.Mn, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC0574Mn implements View.OnClickListener {
    public final /* synthetic */ AnonymousClass46 A00;
    public final /* synthetic */ C0564Mc A01;
    public final /* synthetic */ C0575Mo A02;

    public ViewOnClickListenerC0574Mn(C0575Mo c0575Mo, C0564Mc c0564Mc, AnonymousClass46 anonymousClass46) {
        this.A02 = c0575Mo;
        this.A01 = c0564Mc;
        this.A00 = anonymousClass46;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            this.A01.A01();
            this.A02.A0A.A7B(this.A00);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }
}
