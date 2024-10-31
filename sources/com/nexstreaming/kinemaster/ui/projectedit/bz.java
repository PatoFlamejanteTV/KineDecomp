package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.ViewTreeObserver;

/* compiled from: MediaEditFragment.java */
/* loaded from: classes.dex */
public class bz implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    final /* synthetic */ bo f3807a;

    public bz(bo boVar) {
        this.f3807a = boVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.f3807a.getActivity() != null && this.f3807a.getResources() != null && this.f3807a.getResources().getConfiguration().screenWidthDp >= this.f3807a.getResources().getConfiguration().screenHeightDp) {
            this.f3807a.w().requestLayout();
            this.f3807a.w().getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }
}
