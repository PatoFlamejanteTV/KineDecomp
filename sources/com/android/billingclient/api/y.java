package com.android.billingclient.api;

import com.android.billingclient.api.M;
import java.util.concurrent.Callable;

/* compiled from: BillingClientImpl.java */
/* loaded from: classes.dex */
class y implements Callable<M.a> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f7967a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C f7968b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(C c2, String str) {
        this.f7968b = c2;
        this.f7967a = str;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public M.a call() throws Exception {
        M.a b2;
        b2 = this.f7968b.b(this.f7967a);
        return b2;
    }
}
