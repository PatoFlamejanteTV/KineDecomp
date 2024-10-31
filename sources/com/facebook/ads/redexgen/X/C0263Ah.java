package com.facebook.ads.redexgen.X;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.Ah, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0263Ah extends AbstractC0260Ae {
    public final List<C0343Dj> A00;

    public C0263Ah(Context context, AA aa) {
        super(context, aa);
        this.A00 = new ArrayList();
    }

    public final void A02(C0343Dj c0343Dj) {
        if (!c0343Dj.A03().contains(EnumC0349Dp.A0A)) {
            this.A00.add(c0343Dj);
        }
    }

    public final void A03(EnumC0346Dm enumC0346Dm) {
        A01(enumC0346Dm, this.A00);
    }
}
