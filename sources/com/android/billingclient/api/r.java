package com.android.billingclient.api;

import java.util.concurrent.Future;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BillingClientImpl.java */
/* loaded from: classes.dex */
public class r implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Future f7940a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Runnable f7941b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C f7942c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(C c2, Future future, Runnable runnable) {
        this.f7942c = c2;
        this.f7940a = future;
        this.f7941b = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f7940a.isDone() || this.f7940a.isCancelled()) {
            return;
        }
        this.f7940a.cancel(true);
        c.b.a.a.a.b("BillingClient", "Async task is taking too long, cancel it!");
        Runnable runnable = this.f7941b;
        if (runnable != null) {
            runnable.run();
        }
    }
}
