package com.android.billingclient.api;

import com.android.billingclient.api.C;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BillingClientImpl.java */
/* loaded from: classes.dex */
public class z implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ H f7969a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C.a f7970b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(C.a aVar, H h2) {
        this.f7970b = aVar;
        this.f7969a = h2;
    }

    @Override // java.lang.Runnable
    public void run() {
        D d2;
        d2 = this.f7970b.f7857a;
        d2.a(this.f7969a);
    }
}
