package com.google.firebase.inappmessaging.display.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public class g extends AnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ SwipeDismissTouchListener f17606a;

    public g(SwipeDismissTouchListener swipeDismissTouchListener) {
        this.f17606a = swipeDismissTouchListener;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f17606a.c();
    }
}
