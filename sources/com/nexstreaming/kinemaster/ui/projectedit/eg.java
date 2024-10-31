package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionListFragment.java */
/* loaded from: classes.dex */
public class eg implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ed f3867a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eg(ed edVar) {
        this.f3867a = edVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        view = this.f3867a.g;
        if (view != null) {
            view2 = this.f3867a.g;
            view2.requestLayout();
        }
    }
}
