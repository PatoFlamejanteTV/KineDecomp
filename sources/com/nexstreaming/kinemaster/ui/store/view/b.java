package com.nexstreaming.kinemaster.ui.store.view;

import android.animation.ValueAnimator;
import kotlin.TypeCastException;
import kotlin.jvm.internal.h;

/* compiled from: ExpandableLayout.kt */
/* loaded from: classes2.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a */
    final /* synthetic */ ExpandableLayout f23687a;

    /* renamed from: b */
    final /* synthetic */ float f23688b;

    public b(ExpandableLayout expandableLayout, float f2) {
        this.f23687a = expandableLayout;
        this.f23688b = f2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ExpandableLayout expandableLayout = this.f23687a;
        h.a((Object) valueAnimator, "valueAnimator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
        }
        expandableLayout.setExpansion(((Float) animatedValue).floatValue());
    }
}
