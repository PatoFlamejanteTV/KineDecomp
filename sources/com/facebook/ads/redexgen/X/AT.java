package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.view.OrientationEventListener;

/* loaded from: assets/audience_network.dex */
public class AT extends OrientationEventListener {
    public final /* synthetic */ long A00;
    public final /* synthetic */ AU A01;
    public final /* synthetic */ E7 A02;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AT(AU au, Context context, int i, long j, E7 e7) {
        super(context, i);
        this.A01 = au;
        this.A00 = j;
        this.A02 = e7;
    }

    @Override // android.view.OrientationEventListener
    public final void onOrientationChanged(int i) {
        AS as;
        C0357Dx c0357Dx = new C0357Dx(this.A00, this.A02, i);
        as = this.A01.A00;
        as.A02(c0357Dx, AR.A09);
    }
}
