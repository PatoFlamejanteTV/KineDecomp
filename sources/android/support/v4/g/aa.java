package android.support.v4.g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* compiled from: ViewPropertyAnimatorCompatICS.java */
/* loaded from: classes.dex */
final class aa extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ad f88a;
    final /* synthetic */ View b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(ad adVar, View view) {
        this.f88a = adVar;
        this.b = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f88a.c(this.b);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f88a.b(this.b);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f88a.a(this.b);
    }
}
