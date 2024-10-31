package com.nexstreaming.kinemaster.ui.store.controller;

import android.view.View;
import com.nexstreaming.kinemaster.ui.store.controller.nb;
import java.util.List;

/* compiled from: StoreAssetAdapter.java */
/* loaded from: classes2.dex */
class lb implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f23578a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ nb f23579b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public lb(nb nbVar, int i) {
        this.f23579b = nbVar;
        this.f23578a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        nb.d dVar;
        nb.d dVar2;
        List list;
        dVar = this.f23579b.f23589d;
        if (dVar != null) {
            dVar2 = this.f23579b.f23589d;
            int i = this.f23578a;
            list = this.f23579b.f23588c;
            dVar2.a(view, i, (com.nexstreaming.kinemaster.ui.store.model.c) list.get(this.f23578a));
        }
    }
}
