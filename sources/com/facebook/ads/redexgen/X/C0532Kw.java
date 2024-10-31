package com.facebook.ads.redexgen.X;

import android.os.Build;

/* renamed from: com.facebook.ads.redexgen.X.Kw, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0532Kw extends C01807a {
    public C0532Kw(C0362Ec c0362Ec) {
        super(c0362Ec);
        setCarouselLayoutManager(c0362Ec);
    }

    @Override // com.facebook.ads.redexgen.X.C01807a
    public C01636i getLayoutManager() {
        return (C01636i) super.getLayoutManager();
    }

    private void setCarouselLayoutManager(C0362Ec c0362Ec) {
        C01636i c01636i = new C01636i(c0362Ec, 0, false);
        if (Build.VERSION.SDK_INT >= 24) {
            c01636i.A1V(true);
        }
        super.setLayoutManager(c01636i);
    }

    @Override // com.facebook.ads.redexgen.X.C01807a
    public void setLayoutManager(AbstractC01616g abstractC01616g) {
    }
}
