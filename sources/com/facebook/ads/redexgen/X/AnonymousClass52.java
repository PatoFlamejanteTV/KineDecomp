package com.facebook.ads.redexgen.X;

import android.support.annotation.RequiresApi;
import android.view.View;

@RequiresApi(16)
/* renamed from: com.facebook.ads.redexgen.X.52, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class AnonymousClass52 extends AnonymousClass51 {
    @Override // com.facebook.ads.redexgen.X.AnonymousClass50
    public final int A03(View view) {
        return view.getImportantForAccessibility();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass50
    public final int A05(View view) {
        return view.getMinimumHeight();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass50
    public final int A06(View view) {
        return view.getMinimumWidth();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass50
    public final void A0A(View view) {
        view.postInvalidateOnAnimation();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass50
    public void A0C(View view, int i) {
        if (i == 4) {
            i = 2;
        }
        view.setImportantForAccessibility(i);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass50
    public final void A0F(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass50
    public final void A0G(View view, Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass50
    public final boolean A0H(View view) {
        return view.hasTransientState();
    }
}
