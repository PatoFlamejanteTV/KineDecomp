package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.support.v7.widget.RecyclerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetsRecyclerView.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.ub, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0481ub extends RecyclerView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Db f6433a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0481ub(Db db) {
        this.f6433a = db;
    }

    @Override // android.support.v7.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            this.f6433a.l();
        }
    }
}
