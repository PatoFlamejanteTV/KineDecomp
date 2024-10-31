package com.facebook.ads.redexgen.X;

/* loaded from: assets/audience_network.dex */
public class ED implements Runnable {
    public final /* synthetic */ EE A00;

    public ED(EE ee) {
        this.A00 = ee;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            this.A00.A03();
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }
}
