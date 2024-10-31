package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import android.view.ViewTreeObserver;

/* compiled from: OptionColorTintFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.ic, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class ViewTreeObserverOnGlobalLayoutListenerC1917ic implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f22388a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C1943lc f22389b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewTreeObserverOnGlobalLayoutListenerC1917ic(C1943lc c1943lc, View view) {
        this.f22389b = c1943lc;
        this.f22388a = view;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        View view;
        View view2;
        View view3;
        if (this.f22389b.getContext() != null && this.f22389b.isAdded() && this.f22388a.getViewTreeObserver().isAlive()) {
            view = this.f22389b.r;
            if (view != null && this.f22388a != null) {
                view2 = this.f22389b.r;
                if (view2.getY() > this.f22388a.getHeight()) {
                    view3 = this.f22389b.r;
                    view3.requestLayout();
                }
            }
            this.f22388a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }
}
