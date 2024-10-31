package com.nextreaming.nexeditorui.fontbrowser;

import android.view.View;
import android.widget.ListView;

/* compiled from: FontListAdapter.java */
/* loaded from: classes.dex */
class n implements View.OnLongClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ListView f4638a;
    final /* synthetic */ int b;
    final /* synthetic */ l c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar, ListView listView, int i) {
        this.c = lVar;
        this.f4638a = listView;
        this.b = i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f4638a.getOnItemLongClickListener().onItemLongClick(this.f4638a, view, this.b, this.c.getItemId(this.b));
        return true;
    }
}
