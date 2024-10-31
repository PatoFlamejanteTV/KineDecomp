package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionListFragment.java */
/* loaded from: classes2.dex */
public class Sc implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Xc f22077a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Sc(Xc xc) {
        this.f22077a = xc;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f22077a.isAdded()) {
            this.f22077a.b(OptionMenuItem.a((int) adapterView.getItemIdAtPosition(i)));
        }
    }
}
