package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import android.view.ViewTreeObserver;

/* compiled from: OptionColorTintFragment.java */
/* loaded from: classes.dex */
class dd implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f3838a;
    final /* synthetic */ dc b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dd(dc dcVar, View view) {
        this.b = dcVar;
        this.f3838a = view;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        View view;
        View view2;
        View view3;
        this.f3838a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        view = this.b.g;
        if (view != null && this.f3838a != null) {
            view2 = this.b.g;
            if (view2.getY() > this.f3838a.getHeight()) {
                view3 = this.b.g;
                view3.requestLayout();
            }
        }
    }
}
