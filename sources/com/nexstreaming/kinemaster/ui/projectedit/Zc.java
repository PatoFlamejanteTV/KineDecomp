package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionListView.java */
/* loaded from: classes2.dex */
public class Zc implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AbstractC1855bd f22194a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Zc(AbstractC1855bd abstractC1855bd) {
        this.f22194a = abstractC1855bd;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f22194a.a(OptionMenuItem.a((int) adapterView.getItemIdAtPosition(i)));
    }
}
