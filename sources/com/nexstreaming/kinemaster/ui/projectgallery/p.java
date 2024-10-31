package com.nexstreaming.kinemaster.ui.projectgallery;

import android.view.View;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

/* compiled from: ExportFileListActivity.java */
/* loaded from: classes.dex */
class p implements View.OnLayoutChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ExportFileListActivity f4217a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ExportFileListActivity exportFileListActivity) {
        this.f4217a = exportFileListActivity;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        View view2;
        ListView listView;
        ListView listView2;
        BaseAdapter baseAdapter;
        view2 = this.f4217a.b;
        view2.removeOnLayoutChangeListener(this);
        View view3 = new View(this.f4217a);
        view3.setLayoutParams(new AbsListView.LayoutParams(0, i2));
        listView = this.f4217a.f4122a;
        listView.addHeaderView(view3);
        listView2 = this.f4217a.f4122a;
        baseAdapter = this.f4217a.f;
        listView2.setAdapter((ListAdapter) baseAdapter);
    }
}
