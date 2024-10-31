package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import android.view.ViewTreeObserver;

/* compiled from: EffectLayerEditFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.wa, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class ViewTreeObserverOnGlobalLayoutListenerC2062wa implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f22747a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Aa f22748b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewTreeObserverOnGlobalLayoutListenerC2062wa(Aa aa, View view) {
        this.f22748b = aa;
        this.f22747a = view;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        View view;
        View view2;
        View view3;
        if (this.f22748b.getContext() != null && this.f22748b.isAdded() && this.f22747a.getViewTreeObserver().isAlive()) {
            view = this.f22748b.H;
            if (view != null) {
                view2 = this.f22748b.H;
                if (view2.getHeight() <= 0) {
                    view3 = this.f22748b.H;
                    view3.requestLayout();
                }
            }
            View view4 = this.f22747a;
            if (view4 != null) {
                view4.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }
    }
}
