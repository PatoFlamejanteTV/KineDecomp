package com.facebook.ads.redexgen.X;

/* loaded from: assets/audience_network.dex */
public class NG implements Runnable {
    public final /* synthetic */ NH A00;
    public final /* synthetic */ C1N A01;

    public NG(NH nh, C1N c1n) {
        this.A00 = nh;
        this.A01 = c1n;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            this.A01.A6C();
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }
}
