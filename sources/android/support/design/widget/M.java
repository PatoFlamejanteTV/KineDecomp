package android.support.design.widget;

import android.animation.ValueAnimator;

/* compiled from: TextInputLayout.java */
/* loaded from: classes.dex */
class M implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TextInputLayout f428a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public M(TextInputLayout textInputLayout) {
        this.f428a = textInputLayout;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f428a.J.b(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
