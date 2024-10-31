package com.nexstreaming.kinemaster.ui.projectedit;

import android.widget.ListView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionExpressionFragment.java */
/* loaded from: classes.dex */
public class dw implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f3858a;
    final /* synthetic */ dt b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dw(dt dtVar, int i) {
        this.b = dtVar;
        this.f3858a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        ListView listView;
        ListView listView2;
        ListView listView3;
        ListView listView4;
        ListView listView5;
        ListView listView6;
        listView = this.b.b;
        if (listView != null) {
            listView2 = this.b.b;
            listView2.setSelection(this.f3858a);
            dt dtVar = this.b;
            listView3 = this.b.b;
            listView4 = this.b.b;
            int firstVisiblePosition = listView4.getFirstVisiblePosition();
            listView5 = this.b.b;
            int childCount = listView5.getChildCount();
            listView6 = this.b.b;
            dtVar.onScroll(listView3, firstVisiblePosition, childCount, listView6.getCount());
        }
    }
}
