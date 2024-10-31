package android.support.design.widget;

import android.animation.ValueAnimator;
import android.support.design.widget.AppBarLayout;

/* compiled from: AppBarLayout.java */
/* renamed from: android.support.design.widget.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0177c implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CoordinatorLayout f468a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AppBarLayout f469b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AppBarLayout.Behavior f470c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0177c(AppBarLayout.Behavior behavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        this.f470c = behavior;
        this.f468a = coordinatorLayout;
        this.f469b = appBarLayout;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f470c.c(this.f468a, (CoordinatorLayout) this.f469b, ((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
