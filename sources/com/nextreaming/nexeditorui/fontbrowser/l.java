package com.nextreaming.nexeditorui.fontbrowser;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/* compiled from: FontListAdapter.java */
/* loaded from: classes2.dex */
class l implements View.OnLongClickListener {

    /* renamed from: a */
    final /* synthetic */ ListView f24277a;

    /* renamed from: b */
    final /* synthetic */ int f24278b;

    /* renamed from: c */
    final /* synthetic */ m f24279c;

    public l(m mVar, ListView listView, int i) {
        this.f24279c = mVar;
        this.f24277a = listView;
        this.f24278b = i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (this.f24277a.getOnItemLongClickListener() == null) {
            return true;
        }
        AdapterView.OnItemLongClickListener onItemLongClickListener = this.f24277a.getOnItemLongClickListener();
        ListView listView = this.f24277a;
        int i = this.f24278b;
        onItemLongClickListener.onItemLongClick(listView, view, i, this.f24279c.getItemId(i));
        return true;
    }
}
