package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.ViewTreeObserver;

/* compiled from: LayerAnimationFragment.java */
/* loaded from: classes.dex */
class bf implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ az f3786a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(az azVar) {
        this.f3786a = azVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.f3786a.getResources().getConfiguration().screenWidthDp >= this.f3786a.getResources().getConfiguration().screenHeightDp) {
            this.f3786a.w().requestLayout();
            this.f3786a.w().getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }
}
