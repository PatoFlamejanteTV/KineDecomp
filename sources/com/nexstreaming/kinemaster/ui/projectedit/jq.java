package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.animation.Animation;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
public class jq implements Animation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f4014a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public jq(ProjectEditActivity projectEditActivity) {
        this.f4014a = projectEditActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        TimelineView timelineView;
        timelineView = this.f4014a.k;
        timelineView.setExpandingAnimation(false);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
