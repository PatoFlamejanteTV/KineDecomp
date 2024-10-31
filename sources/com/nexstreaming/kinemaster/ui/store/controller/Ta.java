package com.nexstreaming.kinemaster.ui.store.controller;

import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GridPageFragment.java */
/* loaded from: classes2.dex */
public class Ta implements View.OnKeyListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ _a f23497a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ta(_a _aVar) {
        this.f23497a = _aVar;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        RecyclerView recyclerView;
        if (keyEvent.getAction() == 0) {
            if (i == 21) {
                com.nexstreaming.kinemaster.ui.store.view.a a2 = com.nexstreaming.kinemaster.ui.store.view.a.a();
                com.nexstreaming.kinemaster.ui.store.view.a.a().getClass();
                a2.a("main_category_view", false);
                return true;
            }
            if (i == 61) {
                if (keyEvent.hasModifiers(1)) {
                    com.nexstreaming.kinemaster.ui.store.view.a a3 = com.nexstreaming.kinemaster.ui.store.view.a.a();
                    com.nexstreaming.kinemaster.ui.store.view.a.a().getClass();
                    a3.a("main_category_view", false);
                } else {
                    com.nexstreaming.kinemaster.ui.store.view.a a4 = com.nexstreaming.kinemaster.ui.store.view.a.a();
                    com.nexstreaming.kinemaster.ui.store.view.a.a().getClass();
                    recyclerView = this.f23497a.f23525g;
                    a4.a("asset_view", recyclerView);
                    com.nexstreaming.kinemaster.ui.store.view.a a5 = com.nexstreaming.kinemaster.ui.store.view.a.a();
                    com.nexstreaming.kinemaster.ui.store.view.a.a().getClass();
                    a5.a("asset_view", false);
                }
                return true;
            }
        }
        return false;
    }
}
