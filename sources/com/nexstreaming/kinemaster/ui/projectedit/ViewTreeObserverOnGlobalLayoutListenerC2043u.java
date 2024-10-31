package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.ViewTreeObserver;

/* compiled from: AssetLayerEditFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.u, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class ViewTreeObserverOnGlobalLayoutListenerC2043u implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2052v f22712a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewTreeObserverOnGlobalLayoutListenerC2043u(C2052v c2052v) {
        this.f22712a = c2052v;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.f22712a.getActivity() == null || this.f22712a.getResources() == null || this.f22712a.getResources().getConfiguration().screenWidthDp < this.f22712a.getResources().getConfiguration().screenHeightDp) {
            return;
        }
        this.f22712a.Q().requestLayout();
        this.f22712a.Q().getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
}
