package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.Af, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0261Af extends AbstractC0260Ae implements AZ {
    public AO A00;
    public final AA A01;
    public final Map<Integer, C0343Dj> A02;

    @SuppressLint({"UseSparseArrays"})
    public C0261Af(Context context, AA aa) {
        super(context, aa);
        this.A02 = new HashMap();
        this.A01 = aa;
    }

    public final void A02(C0343Dj c0343Dj) {
        this.A02.put(Integer.valueOf(c0343Dj.A00()), c0343Dj);
    }

    public final void A03(EnumC0346Dm enumC0346Dm, Context context) {
        this.A00 = AO.A00(context, this.A01);
        this.A00.A04(this.A02, enumC0346Dm);
    }

    @Override // com.facebook.ads.redexgen.X.AZ
    public final void A7j() {
        if (this.A00 != null) {
            this.A00.A03();
        }
    }
}
