package com.nexstreaming.kinemaster.ui.projectedit.timeline;

import android.animation.ValueAnimator;

/* compiled from: SecondaryTrackDragDecoration.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.timeline.w, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C2041w implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2042x f22710a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2041w(C2042x c2042x) {
        this.f22710a = c2042x;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int round = (Math.round(this.f22710a.f22711a.r) - this.f22710a.f22711a.p.getBounds().top) + Math.round(this.f22710a.f22711a.h().u);
        y yVar = this.f22710a.f22711a;
        y.a(yVar, y.a(yVar), y.b(this.f22710a.f22711a), -round);
    }
}
