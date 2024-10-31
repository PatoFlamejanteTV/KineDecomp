package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.ViewTreeObserver;

/* compiled from: OptionChromaKeyFragment.java */
/* loaded from: classes.dex */
class da implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ cr f3835a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public da(cr crVar) {
        this.f3835a = crVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        Slider slider;
        if (this.f3835a.getResources().getConfiguration().screenWidthDp >= this.f3835a.getResources().getConfiguration().screenHeightDp) {
            this.f3835a.h();
            slider = this.f3835a.h;
            slider.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }
}
