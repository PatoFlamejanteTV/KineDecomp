package com.nexstreaming.kinemaster.ui.projectedit.audioeffect;

import android.view.ViewTreeObserver;

/* compiled from: OptionAudioEffectFragment.kt */
/* loaded from: classes2.dex */
public final class v implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ w f22269a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(w wVar) {
        this.f22269a = wVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (w.b(this.f22269a).getY() > w.a(this.f22269a).getHeight()) {
            w.b(this.f22269a).requestLayout();
        }
        if (w.c(this.f22269a).getHeight() <= 0) {
            w.c(this.f22269a).requestLayout();
        }
        w.a(this.f22269a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
}
