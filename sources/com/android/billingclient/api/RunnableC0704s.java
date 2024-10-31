package com.android.billingclient.api;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BillingClientImpl.java */
/* renamed from: com.android.billingclient.api.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class RunnableC0704s implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ L f7943a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ H f7944b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f7945c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ C f7946d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0704s(C c2, L l, H h2, String str) {
        this.f7946d = c2;
        this.f7943a = l;
        this.f7944b = h2;
        this.f7945c = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        c.b.a.a.a.a("BillingClient", "Successfully consumed purchase.");
        this.f7943a.a(this.f7944b, this.f7945c);
    }
}
