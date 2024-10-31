package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.ViewTreeObserver;

/* compiled from: StickerEditFragment.java */
/* loaded from: classes.dex */
class le implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ kx f4058a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public le(kx kxVar) {
        this.f4058a = kxVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.f4058a.getActivity() != null && this.f4058a.getResources() != null && this.f4058a.getResources().getConfiguration().screenWidthDp >= this.f4058a.getResources().getConfiguration().screenHeightDp) {
            this.f4058a.w().requestLayout();
            this.f4058a.w().getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }
}
