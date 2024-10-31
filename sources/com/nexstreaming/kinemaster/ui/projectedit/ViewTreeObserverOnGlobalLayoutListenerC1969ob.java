package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.ViewTreeObserver;

/* compiled from: LayerAnimationFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.ob, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class ViewTreeObserverOnGlobalLayoutListenerC1969ob implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1978pb f22465a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewTreeObserverOnGlobalLayoutListenerC1969ob(C1978pb c1978pb) {
        this.f22465a = c1978pb;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.f22465a.getResources().getConfiguration().screenWidthDp < this.f22465a.getResources().getConfiguration().screenHeightDp) {
            return;
        }
        this.f22465a.Q().requestLayout();
        this.f22465a.Q().getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
}
