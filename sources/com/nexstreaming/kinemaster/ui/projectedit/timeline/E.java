package com.nexstreaming.kinemaster.ui.projectedit.timeline;

import android.animation.ValueAnimator;
import android.graphics.PathMeasure;

/* compiled from: TimelineItemDragDecoration.java */
/* loaded from: classes2.dex */
class E implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    final float[] f22566a = new float[2];

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ PathMeasure f22567b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ float f22568c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ float f22569d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ ValueAnimator.AnimatorUpdateListener f22570e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ I f22571f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public E(I i, PathMeasure pathMeasure, float f2, float f3, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f22571f = i;
        this.f22567b = pathMeasure;
        this.f22568c = f2;
        this.f22569d = f3;
        this.f22570e = animatorUpdateListener;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = valueAnimator.getAnimatedFraction();
        PathMeasure pathMeasure = this.f22567b;
        pathMeasure.getPosTan(pathMeasure.getLength() * animatedFraction, this.f22566a, null);
        I i = this.f22571f;
        float f2 = this.f22568c;
        float[] fArr = this.f22566a;
        i.q = f2 + fArr[0];
        i.r = this.f22569d + fArr[1];
        i.n().postInvalidateOnAnimation();
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.f22570e;
        if (animatorUpdateListener != null) {
            animatorUpdateListener.onAnimationUpdate(valueAnimator);
        }
    }
}
