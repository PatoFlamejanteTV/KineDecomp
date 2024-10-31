package com.facebook.ads.redexgen.X;

import android.support.annotation.RequiresApi;
import android.view.View;

@RequiresApi(19)
/* renamed from: com.facebook.ads.redexgen.X.55, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class AnonymousClass55 extends AnonymousClass54 {
    @Override // com.facebook.ads.redexgen.X.AnonymousClass52, com.facebook.ads.redexgen.X.AnonymousClass50
    public final void A0C(View view, int i) {
        view.setImportantForAccessibility(i);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass50
    public final boolean A0I(View view) {
        return view.isAttachedToWindow();
    }
}
