package com.google.firebase.inappmessaging.display.internal;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public class j implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a */
    final /* synthetic */ ViewGroup.LayoutParams f17678a;

    /* renamed from: b */
    final /* synthetic */ SwipeDismissTouchListener f17679b;

    public j(SwipeDismissTouchListener swipeDismissTouchListener, ViewGroup.LayoutParams layoutParams) {
        this.f17679b = swipeDismissTouchListener;
        this.f17678a = layoutParams;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        View view;
        this.f17678a.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        view = this.f17679b.f17567e;
        view.setLayoutParams(this.f17678a);
    }
}
