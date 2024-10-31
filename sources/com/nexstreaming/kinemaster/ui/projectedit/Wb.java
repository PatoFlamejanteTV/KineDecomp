package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import android.view.ViewTreeObserver;

/* compiled from: OptionBlendModeFragment.java */
/* loaded from: classes2.dex */
class Wb implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Xb f22163a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Wb(Xb xb) {
        this.f22163a = xb;
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
        if (this.f22163a.getContext() != null && this.f22163a.isAdded()) {
            view = this.f22163a.q;
            if (view.getViewTreeObserver().isAlive()) {
                view2 = this.f22163a.s;
                if (view2 != null) {
                    view8 = this.f22163a.q;
                    if (view8 != null) {
                        view9 = this.f22163a.s;
                        float y = view9.getY();
                        view10 = this.f22163a.q;
                        if (y > view10.getHeight()) {
                            view11 = this.f22163a.s;
                            view11.requestLayout();
                        }
                    }
                }
                view3 = this.f22163a.r;
                if (view3 != null) {
                    view6 = this.f22163a.r;
                    if (view6.getHeight() <= 0) {
                        view7 = this.f22163a.r;
                        view7.requestLayout();
                    }
                }
                view4 = this.f22163a.q;
                if (view4 != null) {
                    view5 = this.f22163a.q;
                    view5.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            }
        }
    }
}
