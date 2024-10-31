package com.android.billingclient.api;

import com.android.billingclient.api.H;
import com.android.billingclient.api.P;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BillingClientImpl.java */
/* renamed from: com.android.billingclient.api.h */
/* loaded from: classes.dex */
public class RunnableC0694h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ P.a f7916a;

    /* renamed from: b */
    final /* synthetic */ CallableC0695i f7917b;

    public RunnableC0694h(CallableC0695i callableC0695i, P.a aVar) {
        this.f7917b = callableC0695i;
        this.f7916a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        T t = this.f7917b.f7920c;
        H.a b2 = H.b();
        b2.a(this.f7916a.b());
        b2.a(this.f7916a.a());
        t.a(b2.a(), this.f7916a.c());
    }
}
