package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.Looper;

/* loaded from: assets/audience_network.dex */
public final class EK {
    public Handler A00;

    public EK(Looper looper) {
        this.A00 = new Handler(looper);
    }

    public final void A00(EL el) {
        this.A00.post(el);
    }

    public final void A01(EL el) {
        this.A00.removeCallbacks(el);
    }

    public final boolean A02(EL el, long j) {
        return this.A00.postDelayed(el, j);
    }
}
