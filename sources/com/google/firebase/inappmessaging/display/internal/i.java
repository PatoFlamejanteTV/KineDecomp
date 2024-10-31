package com.google.firebase.inappmessaging.display.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.google.firebase.inappmessaging.display.internal.SwipeDismissTouchListener;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public class i extends AnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ ViewGroup.LayoutParams f17612a;

    /* renamed from: b */
    final /* synthetic */ int f17613b;

    /* renamed from: c */
    final /* synthetic */ SwipeDismissTouchListener f17614c;

    public i(SwipeDismissTouchListener swipeDismissTouchListener, ViewGroup.LayoutParams layoutParams, int i) {
        this.f17614c = swipeDismissTouchListener;
        this.f17612a = layoutParams;
        this.f17613b = i;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        SwipeDismissTouchListener.DismissCallbacks dismissCallbacks;
        View view;
        Object obj;
        View view2;
        View view3;
        View view4;
        dismissCallbacks = this.f17614c.f17568f;
        view = this.f17614c.f17567e;
        obj = this.f17614c.l;
        dismissCallbacks.a(view, obj);
        view2 = this.f17614c.f17567e;
        view2.setAlpha(1.0f);
        view3 = this.f17614c.f17567e;
        view3.setTranslationX(0.0f);
        this.f17612a.height = this.f17613b;
        view4 = this.f17614c.f17567e;
        view4.setLayoutParams(this.f17612a);
    }
}
