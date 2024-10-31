package com.android.billingclient.api;

import com.android.billingclient.api.H;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BillingClientImpl.java */
/* renamed from: com.android.billingclient.api.n */
/* loaded from: classes.dex */
public class RunnableC0700n implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f7931a;

    /* renamed from: b */
    final /* synthetic */ String f7932b;

    /* renamed from: c */
    final /* synthetic */ CallableC0701o f7933c;

    public RunnableC0700n(CallableC0701o callableC0701o, int i, String str) {
        this.f7933c = callableC0701o;
        this.f7931a = i;
        this.f7932b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        InterfaceC0689c interfaceC0689c = this.f7933c.f7935b;
        H.a b2 = H.b();
        b2.a(this.f7931a);
        b2.a(this.f7932b);
        interfaceC0689c.a(b2.a());
    }
}
