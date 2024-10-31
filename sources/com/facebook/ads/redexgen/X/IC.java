package com.facebook.ads.redexgen.X;

import android.graphics.Paint;

/* loaded from: assets/audience_network.dex */
public class IC extends Paint {
    public final /* synthetic */ IB A00;
    public final /* synthetic */ boolean A01;

    public IC(IB ib, boolean z) {
        this.A00 = ib;
        this.A01 = z;
        setStyle(Paint.Style.FILL_AND_STROKE);
        setStrokeCap(Paint.Cap.ROUND);
        setStrokeWidth(3.0f);
        setAntiAlias(true);
        setColor(this.A01 ? -1 : -10066330);
    }
}
