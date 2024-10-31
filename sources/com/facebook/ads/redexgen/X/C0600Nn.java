package com.facebook.ads.redexgen.X;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;

/* renamed from: com.facebook.ads.redexgen.X.Nn, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0600Nn extends AnimatorListenerAdapter {
    public final /* synthetic */ C0599Nm A00;

    public C0600Nn(C0599Nm c0599Nm) {
        this.A00 = c0599Nm;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        Handler handler;
        handler = this.A00.A00.A04;
        handler.postDelayed(new OF(this), 2000L);
    }
}
