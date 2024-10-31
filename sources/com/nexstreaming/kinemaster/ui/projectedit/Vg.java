package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.ViewTreeObserver;

/* compiled from: StickerEditFragment.java */
/* loaded from: classes2.dex */
class Vg implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Xg f22160a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Vg(Xg xg) {
        this.f22160a = xg;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.f22160a.getActivity() == null || this.f22160a.getResources() == null || this.f22160a.getResources().getConfiguration().screenWidthDp < this.f22160a.getResources().getConfiguration().screenHeightDp) {
            return;
        }
        this.f22160a.Q().requestLayout();
        this.f22160a.Q().getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
}
