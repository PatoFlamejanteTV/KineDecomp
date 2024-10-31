package com.nexstreaming.kinemaster.ui.projectedit;

import android.animation.ValueAnimator;

/* compiled from: LayerSubMenuPopupEffectLayer.kt */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.sb */
/* loaded from: classes2.dex */
public final class C2004sb implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a */
    final /* synthetic */ DialogC2045ub f22519a;

    public C2004sb(DialogC2045ub dialogC2045ub) {
        this.f22519a = dialogC2045ub;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        AngleMaskImageView angleMaskImageView;
        angleMaskImageView = this.f22519a.f22718e;
        angleMaskImageView.invalidate();
    }
}
