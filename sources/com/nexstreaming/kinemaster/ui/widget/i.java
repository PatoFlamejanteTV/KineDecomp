package com.nexstreaming.kinemaster.ui.widget;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: PopoutListMenu.java */
/* loaded from: classes.dex */
class i implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f4394a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.f4394a = gVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f4394a.f4391a != null) {
            this.f4394a.f4391a.a(this.f4394a, (int) j);
        }
        this.f4394a.b.dismiss();
    }
}
