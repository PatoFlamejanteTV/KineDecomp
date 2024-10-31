package com.facebook.ads.redexgen.X;

import java.util.concurrent.TimeUnit;

/* loaded from: assets/audience_network.dex */
public class AE implements Runnable {
    public EnumC0346Dm A00;
    public final /* synthetic */ AF A01;

    public AE(AF af, EnumC0346Dm enumC0346Dm) {
        this.A01 = af;
        this.A00 = enumC0346Dm;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0259Ad c0259Ad;
        EK ek;
        EL el;
        AA aa;
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            c0259Ad = this.A01.A04;
            c0259Ad.A04(EnumC0348Do.A03, this.A00, null);
            ek = this.A01.A01;
            el = this.A01.A02;
            TimeUnit timeUnit = TimeUnit.SECONDS;
            aa = this.A01.A03;
            ek.A02(el, timeUnit.toMillis(aa.A0T()));
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }
}
