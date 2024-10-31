package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.ViewTreeObserver;

/* compiled from: TextEditFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.jh, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class ViewTreeObserverOnGlobalLayoutListenerC1930jh implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1939kh f22409a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewTreeObserverOnGlobalLayoutListenerC1930jh(C1939kh c1939kh) {
        this.f22409a = c1939kh;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.f22409a.getActivity() == null || this.f22409a.getResources() == null || this.f22409a.getResources().getConfiguration().screenWidthDp < this.f22409a.getResources().getConfiguration().screenHeightDp) {
            return;
        }
        this.f22409a.Q().requestLayout();
        this.f22409a.Q().getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
}
