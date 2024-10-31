package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;

/* compiled from: OptionListFragment.java */
/* loaded from: classes2.dex */
public class Rc implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Xc f22047a;

    public Rc(Xc xc) {
        this.f22047a = xc;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        view = this.f22047a.m;
        if (view != null) {
            view2 = this.f22047a.m;
            view2.requestLayout();
        }
    }
}
