package com.facebook.ads.redexgen.X;

import android.view.animation.Animation;

/* renamed from: com.facebook.ads.redexgen.X.Os, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0630Os extends KC {
    public final /* synthetic */ C0631Ot A00;

    public C0630Os(C0631Ot c0631Ot) {
        this.A00 = c0631Ot;
    }

    @Override // com.facebook.ads.redexgen.X.KC, android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        KE.A0J(this.A00.A01);
        this.A00.A00.A6z();
    }
}
