package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.animation.Animation;

/* compiled from: TimelineView.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.nh, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class AnimationAnimationListenerC1966nh implements Animation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TimelineView f22462a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AnimationAnimationListenerC1966nh(TimelineView timelineView) {
        this.f22462a = timelineView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f22462a.rb = null;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
