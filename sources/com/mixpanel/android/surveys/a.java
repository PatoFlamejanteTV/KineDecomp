package com.mixpanel.android.surveys;

import android.view.View;
import android.view.animation.Animation;

/* compiled from: CardCarouselLayout.java */
/* loaded from: classes.dex */
class a implements Animation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f3063a;
    final /* synthetic */ CardCarouselLayout b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(CardCarouselLayout cardCarouselLayout, View view) {
        this.b = cardCarouselLayout;
        this.f3063a = view;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f3063a.setVisibility(8);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
