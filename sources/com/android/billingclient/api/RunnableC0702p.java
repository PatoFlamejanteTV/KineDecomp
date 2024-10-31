package com.android.billingclient.api;

/* compiled from: BillingClientImpl.java */
/* renamed from: com.android.billingclient.api.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class RunnableC0702p implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ InterfaceC0689c f7937a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C f7938b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0702p(C c2, InterfaceC0689c interfaceC0689c) {
        this.f7938b = c2;
        this.f7937a = interfaceC0689c;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7937a.a(I.q);
    }
}
