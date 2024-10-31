package com.android.billingclient.api;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BillingClientImpl.java */
/* renamed from: com.android.billingclient.api.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class RunnableC0705t implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f7947a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ L f7948b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ H f7949c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f7950d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ C f7951e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0705t(C c2, int i, L l, H h2, String str) {
        this.f7951e = c2;
        this.f7947a = i;
        this.f7948b = l;
        this.f7949c = h2;
        this.f7950d = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        c.b.a.a.a.b("BillingClient", "Error consuming purchase with token. Response code: " + this.f7947a);
        this.f7948b.a(this.f7949c, this.f7950d);
    }
}
