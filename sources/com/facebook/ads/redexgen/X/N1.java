package com.facebook.ads.redexgen.X;

import android.view.View;

/* loaded from: assets/audience_network.dex */
public class N1 implements View.OnClickListener {
    public final /* synthetic */ N3 A00;

    public N1(N3 n3) {
        this.A00 = n3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        InterfaceC0526Kq interfaceC0526Kq;
        InterfaceC0526Kq interfaceC0526Kq2;
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            interfaceC0526Kq = this.A00.A02;
            if (interfaceC0526Kq == null) {
                return;
            }
            interfaceC0526Kq2 = this.A00.A02;
            interfaceC0526Kq2.A6L();
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }
}
