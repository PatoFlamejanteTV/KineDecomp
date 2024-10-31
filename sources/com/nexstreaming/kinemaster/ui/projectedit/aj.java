package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.ViewTreeObserver;

/* compiled from: HandwritingEditFragment.java */
/* loaded from: classes.dex */
public class aj implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    final /* synthetic */ HandwritingEditFragment f3763a;

    public aj(HandwritingEditFragment handwritingEditFragment) {
        this.f3763a = handwritingEditFragment;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.f3763a.getActivity() != null && this.f3763a.getResources() != null && this.f3763a.getResources().getConfiguration().screenWidthDp >= this.f3763a.getResources().getConfiguration().screenHeightDp) {
            this.f3763a.w().requestLayout();
            this.f3763a.w().getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }
}
