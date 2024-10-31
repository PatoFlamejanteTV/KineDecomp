package com.nexstreaming.kinemaster.ui.projectedit;

import android.widget.ListView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionAudioEffectFragment.java */
/* loaded from: classes.dex */
public class cf implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f3813a;
    final /* synthetic */ ce b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(ce ceVar, int i) {
        this.b = ceVar;
        this.f3813a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        ListView listView;
        ListView listView2;
        ListView listView3;
        ListView listView4;
        ListView listView5;
        ListView listView6;
        listView = this.b.f3812a;
        if (listView != null) {
            listView2 = this.b.f3812a;
            listView2.setSelection(this.f3813a);
            ce ceVar = this.b;
            listView3 = this.b.f3812a;
            listView4 = this.b.f3812a;
            int firstVisiblePosition = listView4.getFirstVisiblePosition();
            listView5 = this.b.f3812a;
            int childCount = listView5.getChildCount();
            listView6 = this.b.f3812a;
            ceVar.onScroll(listView3, firstVisiblePosition, childCount, listView6.getCount());
        }
    }
}
