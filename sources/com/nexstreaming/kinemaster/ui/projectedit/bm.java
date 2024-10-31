package com.nexstreaming.kinemaster.ui.projectedit;

import android.animation.ValueAnimator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LayerSubMenuPopupVideoLayer.java */
/* loaded from: classes.dex */
public class bm implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ bl f3793a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bl blVar) {
        this.f3793a = blVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        AngleMaskImageView angleMaskImageView;
        angleMaskImageView = this.f3793a.c;
        angleMaskImageView.invalidate();
    }
}
