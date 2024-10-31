package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.ViewTreeObserver;

/* compiled from: GroupEditFragment.java */
/* loaded from: classes2.dex */
class Oa implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Pa f21978a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Oa(Pa pa) {
        this.f21978a = pa;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.f21978a.getActivity() == null || this.f21978a.getResources() == null || this.f21978a.getResources().getConfiguration().screenWidthDp < this.f21978a.getResources().getConfiguration().screenHeightDp) {
            return;
        }
        this.f21978a.Q().requestLayout();
        this.f21978a.Q().getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
}
