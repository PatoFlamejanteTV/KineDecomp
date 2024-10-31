package com.google.firebase.inappmessaging.display.internal;

import android.animation.ValueAnimator;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public class h implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a */
    final /* synthetic */ float f17607a;

    /* renamed from: b */
    final /* synthetic */ float f17608b;

    /* renamed from: c */
    final /* synthetic */ float f17609c;

    /* renamed from: d */
    final /* synthetic */ float f17610d;

    /* renamed from: e */
    final /* synthetic */ SwipeDismissTouchListener f17611e;

    public h(SwipeDismissTouchListener swipeDismissTouchListener, float f2, float f3, float f4, float f5) {
        this.f17611e = swipeDismissTouchListener;
        this.f17607a = f2;
        this.f17608b = f3;
        this.f17609c = f4;
        this.f17610d = f5;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = this.f17607a + (valueAnimator.getAnimatedFraction() * this.f17608b);
        float animatedFraction2 = this.f17609c + (valueAnimator.getAnimatedFraction() * this.f17610d);
        this.f17611e.b(animatedFraction);
        this.f17611e.a(animatedFraction2);
    }
}
