package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.animation.Animation;
import android.widget.RelativeLayout;

/* compiled from: OptionPanelDefaultFragment.kt */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.ge */
/* loaded from: classes2.dex */
public final class AnimationAnimationListenerC1901ge implements Animation.AnimationListener {

    /* renamed from: a */
    final /* synthetic */ RelativeLayout f22350a;

    public AnimationAnimationListenerC1901ge(RelativeLayout relativeLayout) {
        this.f22350a = relativeLayout;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        kotlin.jvm.internal.h.b(animation, "animation");
        RelativeLayout relativeLayout = this.f22350a;
        kotlin.jvm.internal.h.a((Object) relativeLayout, "cameraHolder");
        relativeLayout.setVisibility(8);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
        kotlin.jvm.internal.h.b(animation, "animation");
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        kotlin.jvm.internal.h.b(animation, "animation");
    }
}
