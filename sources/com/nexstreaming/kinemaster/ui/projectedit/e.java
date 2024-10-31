package com.nexstreaming.kinemaster.ui.projectedit;

import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.view.View;

/* compiled from: AudioLevelMeterFragment.java */
/* loaded from: classes2.dex */
public class E extends ViewPropertyAnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ AudioLevelMeterFragment f21823a;

    public E(AudioLevelMeterFragment audioLevelMeterFragment) {
        this.f21823a = audioLevelMeterFragment;
    }

    @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
    public void onAnimationStart(View view) {
        View view2;
        View view3;
        View view4;
        view.setPivotX(view.getWidth());
        view.setPivotY(view.getHeight() / 2);
        view2 = this.f21823a.f21767c;
        view2.setPivotX(0.0f);
        view3 = this.f21823a.f21767c;
        view4 = this.f21823a.f21767c;
        view3.setPivotY(view4.getHeight() / 2);
    }
}
