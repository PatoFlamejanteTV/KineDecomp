package com.nexstreaming.kinemaster.ui.settings;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: NewSettingFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.settings.oa */
/* loaded from: classes2.dex */
class C2185oa extends AnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ C2189qa f23173a;

    public C2185oa(C2189qa c2189qa) {
        this.f23173a = c2189qa;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f23173a.f23181a.setVisibility(0);
        this.f23173a.f23181a.setAlpha(1.0f);
        this.f23173a.f23181a.setTranslationY(1.0f);
    }
}
