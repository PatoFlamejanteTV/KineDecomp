package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import android.view.ViewTreeObserver;

/* compiled from: OptionExpressionFragment.java */
/* loaded from: classes.dex */
class dx implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ dt f3859a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dx(dt dtVar) {
        this.f3859a = dtVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        View view;
        View view2;
        View view3;
        View view4;
        View view5;
        View view6;
        View view7;
        View view8;
        view = this.f3859a.i;
        if (view != null) {
            view5 = this.f3859a.d;
            if (view5 != null) {
                view6 = this.f3859a.i;
                float y = view6.getY();
                view7 = this.f3859a.d;
                if (y > view7.getHeight()) {
                    view8 = this.f3859a.i;
                    view8.requestLayout();
                }
            }
        }
        view2 = this.f3859a.h;
        if (view2 != null) {
            view3 = this.f3859a.h;
            if (view3.getHeight() <= 0) {
                view4 = this.f3859a.h;
                view4.requestLayout();
            }
        }
    }
}
