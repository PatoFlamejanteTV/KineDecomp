package com.facebook.ads.redexgen.X;

import android.animation.ValueAnimator;
import android.view.View;

/* loaded from: assets/audience_network.dex */
public class OB implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ OD A00;

    public OB(OD od) {
        this.A00 = od;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        View view;
        View view2;
        Integer num = (Integer) valueAnimator.getAnimatedValue();
        view = this.A00.A06;
        view.getLayoutParams().height = num.intValue();
        view2 = this.A00.A06;
        view2.requestLayout();
    }
}
