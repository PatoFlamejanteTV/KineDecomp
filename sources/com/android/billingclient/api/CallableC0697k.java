package com.android.billingclient.api;

import java.util.concurrent.Callable;

/* compiled from: BillingClientImpl.java */
/* renamed from: com.android.billingclient.api.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class CallableC0697k implements Callable<Void> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ K f7924a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ L f7925b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C f7926c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallableC0697k(C c2, K k, L l) {
        this.f7926c = c2;
        this.f7924a = k;
        this.f7925b = l;
    }

    @Override // java.util.concurrent.Callable
    public Void call() {
        this.f7926c.b(this.f7924a, this.f7925b);
        return null;
    }
}
