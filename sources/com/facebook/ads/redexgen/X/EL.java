package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;

/* loaded from: assets/audience_network.dex */
public final class EL implements Runnable {
    public final Runnable A00;

    public EL(Runnable runnable) {
        this.A00 = runnable;
    }

    @Override // java.lang.Runnable
    @SuppressLint({"CatchGeneralException"})
    public final void run() {
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            this.A00.run();
        } catch (Throwable th) {
            try {
                AK.A03(th);
            } catch (Throwable th2) {
                C0466Ig.A00(th2, this);
            }
        }
    }
}
