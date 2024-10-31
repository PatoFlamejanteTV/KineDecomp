package com.google.firebase.inappmessaging.display.internal;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Application;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public class a extends AnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ View f17571a;

    /* renamed from: b */
    final /* synthetic */ Application f17572b;

    /* renamed from: c */
    final /* synthetic */ FiamAnimator f17573c;

    public a(FiamAnimator fiamAnimator, View view, Application application) {
        this.f17573c = fiamAnimator;
        this.f17571a = view;
        this.f17572b = application;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        this.f17571a.animate().translationX(0.0f).translationY(0.0f).alpha(1.0f).setDuration(this.f17572b.getResources().getInteger(R.integer.config_longAnimTime)).setListener(null);
    }
}
