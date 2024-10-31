package com.android.billingclient.api;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BillingClientImpl.java */
/* renamed from: com.android.billingclient.api.m */
/* loaded from: classes.dex */
public class RunnableC0699m implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Exception f7929a;

    /* renamed from: b */
    final /* synthetic */ CallableC0701o f7930b;

    public RunnableC0699m(CallableC0701o callableC0701o, Exception exc) {
        this.f7930b = callableC0701o;
        this.f7929a = exc;
    }

    @Override // java.lang.Runnable
    public void run() {
        c.b.a.a.a.b("BillingClient", "Error acknowledge purchase; ex: " + this.f7929a);
        this.f7930b.f7935b.a(I.p);
    }
}
