package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.view.animation.Animation;

/* renamed from: com.facebook.ads.redexgen.X.7r, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class AnimationAnimationListenerC01977r implements Animation.AnimationListener {
    public final /* synthetic */ C01997u A00;

    public AnimationAnimationListenerC01977r(C01997u c01997u) {
        this.A00 = c01997u;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        new Handler().postDelayed(new AbstractRunnableC00351g() { // from class: com.facebook.ads.redexgen.X.7q
            @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00351g
            public final void A05() {
                boolean z;
                z = AnimationAnimationListenerC01977r.this.A00.A02;
                if (!z) {
                    return;
                }
                AnimationAnimationListenerC01977r.this.A00.A05();
            }
        }, 3000L);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }
}
