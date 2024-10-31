package com.facebook.ads.redexgen.X;

import android.view.View;

/* loaded from: assets/audience_network.dex */
public class MA implements View.OnClickListener {
    public final /* synthetic */ M9 A00;

    public MA(M9 m9) {
        this.A00 = m9;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C0432Gv c0432Gv;
        C0362Ec c0362Ec;
        C0537Lb c0537Lb;
        boolean A07;
        C0537Lb c0537Lb2;
        C0537Lb c0537Lb3;
        if (!C0466Ig.A02(this)) {
            try {
                c0432Gv = this.A00.A03;
                c0432Gv.A02(EnumC0431Gu.A0Y, null);
                c0362Ec = this.A00.A02;
                c0362Ec.A08().A2v();
                c0537Lb = this.A00.A00;
                if (c0537Lb != null) {
                    A07 = this.A00.A07();
                    if (A07) {
                        c0537Lb3 = this.A00.A00;
                        c0537Lb3.setVolume(1.0f);
                    } else {
                        c0537Lb2 = this.A00.A00;
                        c0537Lb2.setVolume(0.0f);
                    }
                    this.A00.A09();
                }
            } catch (Throwable th) {
                C0466Ig.A00(th, this);
            }
        }
    }
}
