package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StateListAnimator.java */
/* loaded from: classes.dex */
public class A extends AnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ B f306a;

    public A(B b2) {
        this.f306a = b2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        B b2 = this.f306a;
        if (b2.f322c == animator) {
            b2.f322c = null;
        }
    }
}
