package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.ViewTreeObserver;

/* compiled from: OptionChromaKeyFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.fc, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class ViewTreeObserverOnGlobalLayoutListenerC1890fc implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1899gc f22333a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewTreeObserverOnGlobalLayoutListenerC1890fc(C1899gc c1899gc) {
        this.f22333a = c1899gc;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        Slider slider;
        Slider slider2;
        if (this.f22333a.getContext() == null) {
            return;
        }
        if (!this.f22333a.isAdded()) {
            slider2 = this.f22333a.s;
            if (!slider2.getViewTreeObserver().isAlive()) {
                return;
            }
        }
        if (this.f22333a.getResources().getConfiguration().screenWidthDp < this.f22333a.getResources().getConfiguration().screenHeightDp) {
            return;
        }
        this.f22333a.wa();
        slider = this.f22333a.s;
        slider.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
}
