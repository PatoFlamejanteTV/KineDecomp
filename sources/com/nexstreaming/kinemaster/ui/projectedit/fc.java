package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import android.view.ViewTreeObserver;

/* compiled from: OptionExpressionFragment.java */
/* loaded from: classes2.dex */
class Fc implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Jc f21844a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fc(Jc jc) {
        this.f21844a = jc;
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
        View view9;
        View view10;
        View view11;
        if (this.f21844a.getContext() != null && this.f21844a.isAdded()) {
            view = this.f21844a.n;
            if (view.getViewTreeObserver().isAlive()) {
                view2 = this.f21844a.s;
                if (view2 != null) {
                    view8 = this.f21844a.n;
                    if (view8 != null) {
                        view9 = this.f21844a.s;
                        float y = view9.getY();
                        view10 = this.f21844a.n;
                        if (y > view10.getHeight()) {
                            view11 = this.f21844a.s;
                            view11.requestLayout();
                        }
                    }
                }
                view3 = this.f21844a.r;
                if (view3 != null) {
                    view6 = this.f21844a.r;
                    if (view6.getHeight() <= 0) {
                        view7 = this.f21844a.r;
                        view7.requestLayout();
                    }
                }
                view4 = this.f21844a.n;
                if (view4 != null) {
                    view5 = this.f21844a.n;
                    view5.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            }
        }
    }
}
