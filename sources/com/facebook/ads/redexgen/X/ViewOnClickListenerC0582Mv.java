package com.facebook.ads.redexgen.X;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.Mv, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC0582Mv implements View.OnClickListener {
    public final /* synthetic */ C0564Mc A00;
    public final /* synthetic */ C0585My A01;

    public ViewOnClickListenerC0582Mv(C0585My c0585My, C0564Mc c0564Mc) {
        this.A01 = c0585My;
        this.A00 = c0564Mc;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            this.A00.A01();
            this.A01.A0A.A74(AnonymousClass44.A05);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }
}
