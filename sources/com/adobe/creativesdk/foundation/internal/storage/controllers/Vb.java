package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.support.v7.widget.RecyclerView;
import com.adobe.creativesdk.foundation.internal.storage.controllers.Ub;

/* compiled from: CCFilesSectionListView.java */
/* loaded from: classes.dex */
class Vb extends RecyclerView.AdapterDataObserver {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Ub.b f5873a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Vb(Ub.b bVar) {
        this.f5873a = bVar;
    }

    @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
    public void onChanged() {
        this.f5873a.i.a();
    }
}
