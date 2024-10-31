package android.support.v4.app;

import android.view.animation.Animation;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentManager.java */
/* loaded from: classes.dex */
public class t implements Animation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Fragment f66a;
    final /* synthetic */ q b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar, Fragment fragment) {
        this.b = qVar;
        this.f66a = fragment;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (this.f66a.mAnimatingAway != null) {
            this.f66a.mAnimatingAway = null;
            this.b.a(this.f66a, this.f66a.mStateAfterAnimating, 0, 0, false);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
