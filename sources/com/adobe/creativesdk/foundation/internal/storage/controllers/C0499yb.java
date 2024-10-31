package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.support.v4.widget.SwipeRefreshLayout;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetsRecyclerView.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.yb, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0499yb implements SwipeRefreshLayout.OnRefreshListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Db f6543a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0499yb(Db db) {
        this.f6543a = db;
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
    public void onRefresh() {
        WeakReference<InterfaceC0362ad> weakReference = this.f6543a.f6373b;
        InterfaceC0362ad interfaceC0362ad = weakReference != null ? weakReference.get() : null;
        if (interfaceC0362ad != null) {
            if (com.adobe.creativesdk.foundation.adobeinternal.net.a.b().b()) {
                this.f6543a.o();
                interfaceC0362ad.q();
            } else {
                this.f6543a.h();
            }
        }
    }
}
