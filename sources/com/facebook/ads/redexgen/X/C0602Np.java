package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;

/* renamed from: com.facebook.ads.redexgen.X.Np, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0602Np {
    public static final int A01 = C4G.A01(-16777216, 115);
    public static final int A00 = C4G.A01(-1, 0);

    public static void A00(C0362Ec c0362Ec, ViewGroup viewGroup, String str) {
        new NR(viewGroup, c0362Ec).A07(str);
        View view = new View(c0362Ec);
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        KE.A0M(view);
        viewGroup.addView(view, 0);
    }
}
