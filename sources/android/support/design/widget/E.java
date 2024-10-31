package android.support.design.widget;

import android.animation.ValueAnimator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TabLayout.java */
/* loaded from: classes.dex */
public class E implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a */
    final /* synthetic */ F f365a;

    public E(F f2) {
        this.f365a = f2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f365a.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
    }
}
