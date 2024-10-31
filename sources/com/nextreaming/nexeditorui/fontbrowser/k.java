package com.nextreaming.nexeditorui.fontbrowser;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/* compiled from: FontListAdapter.java */
/* loaded from: classes2.dex */
class k implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ListView f24274a;

    /* renamed from: b */
    final /* synthetic */ int f24275b;

    /* renamed from: c */
    final /* synthetic */ m f24276c;

    public k(m mVar, ListView listView, int i) {
        this.f24276c = mVar;
        this.f24274a = listView;
        this.f24275b = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AdapterView.OnItemClickListener onItemClickListener = this.f24274a.getOnItemClickListener();
        ListView listView = this.f24274a;
        int i = this.f24275b;
        onItemClickListener.onItemClick(listView, view, i, this.f24276c.getItemId(i));
    }
}
