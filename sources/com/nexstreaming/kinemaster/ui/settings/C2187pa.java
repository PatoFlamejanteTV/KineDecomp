package com.nexstreaming.kinemaster.ui.settings;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: NewSettingFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.settings.pa */
/* loaded from: classes2.dex */
class C2187pa extends AnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ C2189qa f23177a;

    public C2187pa(C2189qa c2189qa) {
        this.f23177a = c2189qa;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f23177a.f23181a.setVisibility(8);
    }
}
