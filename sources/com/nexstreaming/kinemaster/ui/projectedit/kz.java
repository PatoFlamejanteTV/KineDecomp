package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import android.view.ViewTreeObserver;

/* compiled from: StickerEditFragment.java */
/* loaded from: classes.dex */
class kz implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ kx f4052a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public kz(kx kxVar) {
        this.f4052a = kxVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        View view;
        View view2;
        View view3;
        view = this.f4052a.g;
        if (view != null) {
            view2 = this.f4052a.g;
            if (view2.getHeight() <= 0) {
                view3 = this.f4052a.g;
                view3.requestLayout();
            }
        }
    }
}
