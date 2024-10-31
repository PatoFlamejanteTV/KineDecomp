package com.facebook.ads.redexgen.X;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.Ag, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0262Ag extends AbstractC0260Ae {
    public final List<C0343Dj> A00;

    public C0262Ag(Context context, AA aa) {
        super(context, aa);
        this.A00 = new ArrayList();
    }

    public final List<C0343Dj> A02() {
        return Collections.unmodifiableList(this.A00);
    }

    public final void A03(C0343Dj c0343Dj) {
        if (c0343Dj.A03().contains(EnumC0349Dp.A0A)) {
            this.A00.add(c0343Dj);
        }
    }

    public final void A04(EnumC0346Dm enumC0346Dm) {
        A01(enumC0346Dm, this.A00);
    }
}
