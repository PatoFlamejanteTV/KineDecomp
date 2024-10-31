package com.nexstreaming.kinemaster.ui.widget;

import android.view.View;
import android.widget.AdapterView;
import com.nexstreaming.kinemaster.ui.widget.PopoutListMenu;

/* compiled from: PopoutListMenu.java */
/* loaded from: classes2.dex */
class m implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ PopoutListMenu f23874a;

    public m(PopoutListMenu popoutListMenu) {
        this.f23874a = popoutListMenu;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        PopoutListMenu popoutListMenu = this.f23874a;
        PopoutListMenu.b bVar = popoutListMenu.k;
        if (bVar != null) {
            bVar.a(popoutListMenu, (int) j);
        }
        this.f23874a.f23878b.dismiss();
    }
}
