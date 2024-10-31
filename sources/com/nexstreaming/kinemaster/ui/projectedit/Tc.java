package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionListFragment.java */
/* loaded from: classes2.dex */
public class Tc implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Xc f22099a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Tc(Xc xc) {
        this.f22099a = xc;
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
        if (this.f22099a.getContext() != null && this.f22099a.isAdded()) {
            view = this.f22099a.s;
            if (view.getViewTreeObserver().isAlive()) {
                view2 = this.f22099a.n;
                if (view2 != null) {
                    view5 = this.f22099a.s;
                    if (view5 != null) {
                        view6 = this.f22099a.n;
                        float y = view6.getY();
                        view7 = this.f22099a.s;
                        if (y > view7.getHeight()) {
                            view8 = this.f22099a.n;
                            view8.requestLayout();
                        }
                    }
                }
                view3 = this.f22099a.s;
                if (view3 != null) {
                    view4 = this.f22099a.s;
                    view4.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            }
        }
    }
}
