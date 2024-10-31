package com.facebook.ads.redexgen.X;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;

/* renamed from: com.facebook.ads.redexgen.X.Ot, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0631Ot extends AbstractRunnableC00351g {
    public final /* synthetic */ LS A00;
    public final /* synthetic */ C0633Ov A01;

    public C0631Ot(C0633Ov c0633Ov, LS ls) {
        this.A01 = c0633Ov;
        this.A00 = ls;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00351g
    public final void A05() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setInterpolator(new AccelerateInterpolator());
        alphaAnimation.setAnimationListener(new C0630Os(this));
        this.A01.startAnimation(alphaAnimation);
    }
}
