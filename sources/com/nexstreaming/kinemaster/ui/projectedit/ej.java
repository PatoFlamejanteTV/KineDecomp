package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionListFragment.java */
/* loaded from: classes.dex */
public class ej implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ed f3870a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ej(ed edVar) {
        this.f3870a = edVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        View view;
        View view2;
        View view3;
        View view4;
        View view5;
        view = this.f3870a.h;
        if (view != null) {
            view2 = this.f3870a.c;
            if (view2 != null) {
                view3 = this.f3870a.h;
                float y = view3.getY();
                view4 = this.f3870a.c;
                if (y > view4.getHeight()) {
                    view5 = this.f3870a.h;
                    view5.requestLayout();
                }
            }
        }
    }
}
