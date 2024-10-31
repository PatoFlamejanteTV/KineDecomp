package com.nexstreaming.kinemaster.ui.widget;

import android.view.View;
import android.widget.AdapterView;
import com.nexstreaming.kinemaster.ui.widget.PopoutBookmarkListMenu;

/* compiled from: PopoutBookmarkListMenu.java */
/* loaded from: classes2.dex */
class j implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ PopoutBookmarkListMenu f23871a;

    public j(PopoutBookmarkListMenu popoutBookmarkListMenu) {
        this.f23871a = popoutBookmarkListMenu;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        PopoutBookmarkListMenu popoutBookmarkListMenu = this.f23871a;
        PopoutBookmarkListMenu.b bVar = popoutBookmarkListMenu.k;
        if (bVar != null) {
            bVar.a(popoutBookmarkListMenu, (int) j);
        }
        this.f23871a.f23878b.dismiss();
    }
}
