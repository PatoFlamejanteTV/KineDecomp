package com.nexstreaming.kinemaster.ui.widget;

import android.animation.Animator;

/* compiled from: ShutterView.kt */
/* loaded from: classes2.dex */
public final class q implements Animator.AnimatorListener {

    /* renamed from: a */
    final /* synthetic */ ShutterView f23882a;

    public q(ShutterView shutterView) {
        this.f23882a = shutterView;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f23882a.setVisibility(4);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f23882a.setVisibility(4);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f23882a.setVisibility(0);
    }
}
