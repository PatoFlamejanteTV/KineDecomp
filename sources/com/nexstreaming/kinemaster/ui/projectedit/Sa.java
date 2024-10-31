package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.ViewTreeObserver;

/* compiled from: HandwritingEditFragment.java */
/* loaded from: classes2.dex */
class Sa implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ HandwritingEditFragment f22076a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Sa(HandwritingEditFragment handwritingEditFragment) {
        this.f22076a = handwritingEditFragment;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.f22076a.getActivity() == null || this.f22076a.getResources() == null || this.f22076a.getResources().getConfiguration().screenWidthDp < this.f22076a.getResources().getConfiguration().screenHeightDp) {
            return;
        }
        this.f22076a.Q().requestLayout();
        this.f22076a.Q().getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
}
