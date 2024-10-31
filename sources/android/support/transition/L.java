package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: Transition.java */
/* loaded from: classes.dex */
public class L extends AnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ M f536a;

    public L(M m) {
        this.f536a = m;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f536a.a();
        animator.removeListener(this);
    }
}
