package android.support.v4.g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* compiled from: ViewPropertyAnimatorCompatJB.java */
/* loaded from: classes.dex */
final class ac extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ad f89a;
    final /* synthetic */ View b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ad adVar, View view) {
        this.f89a = adVar;
        this.b = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f89a.c(this.b);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f89a.b(this.b);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f89a.a(this.b);
    }
}
