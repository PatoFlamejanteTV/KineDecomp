package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.view.animation.Animation;

/* loaded from: assets/audience_network.dex */
public class LR implements Animation.AnimationListener {
    public final /* synthetic */ AnonymousClass89 A00;
    public final /* synthetic */ LC A01;
    public final /* synthetic */ LC A02;

    public LR(LC lc, LC lc2, AnonymousClass89 anonymousClass89) {
        this.A01 = lc;
        this.A02 = lc2;
        this.A00 = anonymousClass89;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        this.A01.A04 = false;
        KE.A0J(this.A02);
        new Handler().postDelayed(new LQ(this), 200L);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }
}
