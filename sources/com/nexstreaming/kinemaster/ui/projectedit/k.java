package com.nexstreaming.kinemaster.ui.projectedit;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: AudioLevelMeterFragment.java */
/* loaded from: classes2.dex */
public class K extends AnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ AudioLevelMeterFragment f21917a;

    public K(AudioLevelMeterFragment audioLevelMeterFragment) {
        this.f21917a = audioLevelMeterFragment;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        com.nexstreaming.app.kinemasterfree.a.e eVar;
        eVar = this.f21917a.f21766b;
        eVar.z.setVisibility(8);
    }
}
