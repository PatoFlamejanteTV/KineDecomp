package com.facebook.ads.redexgen.X;

import android.animation.Animator;
import android.view.View;

/* loaded from: assets/audience_network.dex */
public class FZ implements Animator.AnimatorListener {
    public final /* synthetic */ FX A00;

    public FZ(FX fx) {
        this.A00 = fx;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.A00.A09(false);
        this.A00.A04();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        View view;
        this.A00.A01 = EnumC0459Hy.A04;
        view = this.A00.A05;
        KE.A0J(view);
        this.A00.A04();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }
}
