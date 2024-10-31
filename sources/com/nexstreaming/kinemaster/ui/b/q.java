package com.nexstreaming.kinemaster.ui.b;

import android.view.View;
import android.view.ViewTreeObserver;

/* compiled from: MiniFxGroupBrowserFragment.java */
/* loaded from: classes.dex */
class q implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f3704a;
    final /* synthetic */ o b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar, View view) {
        this.b = oVar;
        this.f3704a = view;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        View view;
        View view2;
        View view3;
        view = this.b.g;
        if (view != null && this.f3704a != null) {
            view2 = this.b.g;
            if (view2.getY() > this.f3704a.getHeight()) {
                view3 = this.b.g;
                view3.requestLayout();
            }
        }
    }
}
