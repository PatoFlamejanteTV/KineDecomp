package com.facebook.ads.redexgen.X;

import android.widget.ImageView;
import android.widget.RelativeLayout;

/* renamed from: com.facebook.ads.redexgen.X.Pf, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0643Pf extends C0596Nj {
    public final ImageView A00;
    public final C0362Ec A01;

    public C0643Pf(C0362Ec c0362Ec) {
        super(c0362Ec);
        this.A01 = c0362Ec;
        this.A00 = new ImageView(c0362Ec);
        this.A00.setAdjustViewBounds(true);
        addView(this.A00, new RelativeLayout.LayoutParams(-2, -1));
    }

    public final void A00(String str) {
        NR nr = new NR(this.A00, this.A01);
        nr.A04();
        nr.A07(str);
    }
}
