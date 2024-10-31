package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.support.v7.widget.RecyclerView;

/* compiled from: AssetsRecyclerListView.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.qb, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0462qb extends RecyclerView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AbstractC0476tb f6381a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0462qb(AbstractC0476tb abstractC0476tb) {
        this.f6381a = abstractC0476tb;
    }

    @Override // android.support.v7.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            this.f6381a.m();
        }
    }
}
