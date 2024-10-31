package com.nexstreaming.kinemaster.ui.store.controller;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/* compiled from: StoreAssetAdapter.java */
/* loaded from: classes2.dex */
class mb implements View.OnFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ RecyclerView f23583a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ nb f23584b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public mb(nb nbVar, RecyclerView recyclerView) {
        this.f23584b = nbVar;
        this.f23583a = recyclerView;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!z) {
            this.f23584b.k();
        } else {
            this.f23584b.a(this.f23583a);
        }
    }
}
