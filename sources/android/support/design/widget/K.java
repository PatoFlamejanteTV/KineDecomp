package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: TextInputLayout.java */
/* loaded from: classes.dex */
class K extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CharSequence f425a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ TextInputLayout f426b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public K(TextInputLayout textInputLayout, CharSequence charSequence) {
        this.f426b = textInputLayout;
        this.f425a = charSequence;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f426b.l.setText(this.f425a);
        this.f426b.l.setVisibility(4);
    }
}
