package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.ViewTreeObserver;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaEditFragment.java */
/* loaded from: classes2.dex */
public class Ib implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Mb f21899a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ib(Mb mb) {
        this.f21899a = mb;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.f21899a.getActivity() == null || this.f21899a.getResources() == null || this.f21899a.getResources().getConfiguration().screenWidthDp < this.f21899a.getResources().getConfiguration().screenHeightDp) {
            return;
        }
        this.f21899a.Q().requestLayout();
        this.f21899a.Q().getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
}
