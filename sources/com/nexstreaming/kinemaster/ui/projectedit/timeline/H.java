package com.nexstreaming.kinemaster.ui.projectedit.timeline;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import android.view.ViewPropertyAnimator;

/* compiled from: TimelineItemDragDecoration.java */
/* loaded from: classes2.dex */
class H extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ViewPropertyAnimator f22575a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ I f22576b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public H(I i, ViewPropertyAnimator viewPropertyAnimator) {
        this.f22576b = i;
        this.f22575a = viewPropertyAnimator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f22575a.setUpdateListener(null);
        }
        this.f22575a.setListener(null);
        this.f22576b.n().postInvalidateOnAnimation();
    }
}
