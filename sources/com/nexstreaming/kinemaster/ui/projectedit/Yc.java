package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;

/* compiled from: OptionListView.java */
/* loaded from: classes2.dex */
public class Yc implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AbstractC1855bd f22180a;

    public Yc(AbstractC1855bd abstractC1855bd) {
        this.f22180a = abstractC1855bd;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        view = this.f22180a.f22276b;
        if (view != null) {
            view2 = this.f22180a.f22276b;
            view2.requestLayout();
        }
    }
}
