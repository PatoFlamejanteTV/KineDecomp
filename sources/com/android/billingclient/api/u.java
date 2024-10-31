package com.android.billingclient.api;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BillingClientImpl.java */
/* loaded from: classes.dex */
public class u implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Exception f7952a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ L f7953b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f7954c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ C f7955d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(C c2, Exception exc, L l, String str) {
        this.f7955d = c2;
        this.f7952a = exc;
        this.f7953b = l;
        this.f7954c = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        c.b.a.a.a.b("BillingClient", "Error consuming purchase; ex: " + this.f7952a);
        this.f7953b.a(I.p, this.f7954c);
    }
}
