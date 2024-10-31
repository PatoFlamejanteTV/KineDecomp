package com.nextreaming.nexeditorui.fontbrowser;

import android.view.View;
import android.widget.ListView;

/* compiled from: FontListAdapter.java */
/* loaded from: classes.dex */
class m implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ListView f4637a;
    final /* synthetic */ int b;
    final /* synthetic */ l c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, ListView listView, int i) {
        this.c = lVar;
        this.f4637a = listView;
        this.b = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4637a.getOnItemClickListener().onItemClick(this.f4637a, view, this.b, this.c.getItemId(this.b));
    }
}
