package com.nexstreaming.kinemaster.ui.projectedit;

import android.widget.ListView;

/* compiled from: OptionExpressionFragment.java */
/* loaded from: classes2.dex */
public class Ec implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f21827a;

    /* renamed from: b */
    final /* synthetic */ Jc f21828b;

    public Ec(Jc jc, int i) {
        this.f21828b = jc;
        this.f21827a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        ListView listView;
        ListView listView2;
        ListView listView3;
        ListView listView4;
        ListView listView5;
        ListView listView6;
        listView = this.f21828b.l;
        if (listView != null) {
            listView2 = this.f21828b.l;
            listView2.setSelection(this.f21827a);
            Jc jc = this.f21828b;
            listView3 = jc.l;
            listView4 = this.f21828b.l;
            int firstVisiblePosition = listView4.getFirstVisiblePosition();
            listView5 = this.f21828b.l;
            int childCount = listView5.getChildCount();
            listView6 = this.f21828b.l;
            jc.onScroll(listView3, firstVisiblePosition, childCount, listView6.getCount());
        }
    }
}
