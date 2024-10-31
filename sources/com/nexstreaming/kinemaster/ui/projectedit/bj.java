package com.nexstreaming.kinemaster.ui.projectedit;

import android.animation.ValueAnimator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LayerSubMenuPopupNoVideoLayer.java */
/* loaded from: classes.dex */
public class bj implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ bi f3790a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(bi biVar) {
        this.f3790a = biVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        AngleMaskImageView angleMaskImageView;
        angleMaskImageView = this.f3790a.c;
        angleMaskImageView.invalidate();
    }
}
