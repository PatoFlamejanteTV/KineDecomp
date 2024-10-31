package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: TextInputLayout.java */
/* loaded from: classes.dex */
class J extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TextInputLayout f424a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public J(TextInputLayout textInputLayout) {
        this.f424a = textInputLayout;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f424a.l.setVisibility(0);
    }
}
