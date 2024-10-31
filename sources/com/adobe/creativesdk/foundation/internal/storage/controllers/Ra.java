package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.view.animation.Animation;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetListCellView.java */
/* loaded from: classes.dex */
public class Ra implements Animation.AnimationListener {

    /* renamed from: a */
    final /* synthetic */ float f5797a;

    /* renamed from: b */
    final /* synthetic */ Sa f5798b;

    public Ra(Sa sa, float f2) {
        this.f5798b = sa;
        this.f5797a = f2;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f5798b.b(this.f5797a);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
