package com.nexstreaming.kinemaster.ui.projectedit;

import android.widget.ListView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionBlendModeFragment.java */
/* loaded from: classes2.dex */
public class Vb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Xb f22151a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Vb(Xb xb) {
        this.f22151a = xb;
    }

    @Override // java.lang.Runnable
    public void run() {
        ListView listView;
        ListView listView2;
        ListView listView3;
        ListView listView4;
        ListView listView5;
        ListView listView6;
        listView = this.f22151a.o;
        if (listView != null) {
            listView2 = this.f22151a.o;
            listView2.setSelection(this.f22151a.t);
            Xb xb = this.f22151a;
            listView3 = xb.o;
            listView4 = this.f22151a.o;
            int firstVisiblePosition = listView4.getFirstVisiblePosition();
            listView5 = this.f22151a.o;
            int childCount = listView5.getChildCount();
            listView6 = this.f22151a.o;
            xb.onScroll(listView3, firstVisiblePosition, childCount, listView6.getCount());
        }
    }
}
