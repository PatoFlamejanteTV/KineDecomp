package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.ViewTreeObserver;

/* compiled from: TextEditFragment.java */
/* loaded from: classes.dex */
class ls implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ lo f4073a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ls(lo loVar) {
        this.f4073a = loVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.f4073a.getActivity() != null && this.f4073a.getResources() != null && this.f4073a.getResources().getConfiguration().screenWidthDp >= this.f4073a.getResources().getConfiguration().screenHeightDp) {
            this.f4073a.w().requestLayout();
            this.f4073a.w().getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }
}
