package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.support.v4.widget.SwipeRefreshLayout;
import java.lang.ref.WeakReference;

/* compiled from: AssetsRecyclerListView.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.rb, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0466rb implements SwipeRefreshLayout.OnRefreshListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AbstractC0476tb f6386a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0466rb(AbstractC0476tb abstractC0476tb) {
        this.f6386a = abstractC0476tb;
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
    public void onRefresh() {
        WeakReference<InterfaceC0362ad> weakReference = this.f6386a.f6373b;
        InterfaceC0362ad interfaceC0362ad = weakReference != null ? weakReference.get() : null;
        if (interfaceC0362ad != null) {
            if (com.adobe.creativesdk.foundation.adobeinternal.net.a.b().b()) {
                this.f6386a.p();
                interfaceC0362ad.q();
            } else {
                this.f6386a.h();
            }
        }
    }
}
