package com.nexstreaming.kinemaster.ui.b;

import android.widget.ExpandableListView;

/* compiled from: MiniFxGroupBrowserFragment.java */
/* loaded from: classes.dex */
class s implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ExpandableListView f3706a;
    final /* synthetic */ int b;
    final /* synthetic */ o c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(o oVar, ExpandableListView expandableListView, int i) {
        this.c = oVar;
        this.f3706a = expandableListView;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3706a.setSelection(this.b);
        this.c.onScroll(this.f3706a, this.b, this.f3706a.getChildCount(), this.f3706a.getCount());
    }
}
