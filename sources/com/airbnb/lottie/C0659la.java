package com.airbnb.lottie;

import android.animation.ValueAnimator;

/* compiled from: LottieDrawable.java */
/* renamed from: com.airbnb.lottie.la */
/* loaded from: classes.dex */
public class C0659la implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a */
    final /* synthetic */ C0661ma f7789a;

    public C0659la(C0661ma c0661ma) {
        this.f7789a = c0661ma;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        boolean z;
        ValueAnimator valueAnimator2;
        z = this.f7789a.m;
        if (z) {
            valueAnimator2 = this.f7789a.f7792c;
            valueAnimator2.cancel();
            this.f7789a.a(1.0f);
            return;
        }
        this.f7789a.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
