package com.android.billingclient.api;

import com.android.billingclient.api.C;

/* compiled from: BillingClientImpl.java */
/* loaded from: classes.dex */
class B implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C.a f7848a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public B(C.a aVar) {
        this.f7848a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        C.this.f7849a = 0;
        C.this.f7856h = null;
        this.f7848a.a(I.q);
    }
}
