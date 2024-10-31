package com.nextreaming.nexeditorui.newproject.b;

import android.widget.GridView;

/* compiled from: ThemeBrowserFragment.java */
/* loaded from: classes3.dex */
public class d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ g f24353a;

    public d(g gVar) {
        this.f24353a = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        GridView gridView;
        GridView gridView2;
        c.d.b.i.a aVar;
        int a2;
        gridView = this.f24353a.f24360e;
        if (gridView != null) {
            gridView2 = this.f24353a.f24360e;
            g gVar = this.f24353a;
            aVar = gVar.f24357b;
            a2 = gVar.a(aVar);
            gridView2.setItemChecked(a2, true);
        }
    }
}
