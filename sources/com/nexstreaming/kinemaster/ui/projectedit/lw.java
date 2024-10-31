package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.animation.Animation;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TimelineView.java */
/* loaded from: classes.dex */
public class lw implements Animation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TimelineView f4077a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public lw(TimelineView timelineView) {
        this.f4077a = timelineView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f4077a.bI = null;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
