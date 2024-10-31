package com.android.billingclient.api;

import android.content.Context;
import android.os.Bundle;
import com.android.vending.billing.IInAppBillingService;
import java.util.concurrent.Callable;

/* compiled from: BillingClientImpl.java */
/* loaded from: classes.dex */
class x implements Callable<Bundle> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f7964a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f7965b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C f7966c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(C c2, String str, String str2) {
        this.f7966c = c2;
        this.f7964a = str;
        this.f7965b = str2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Bundle call() throws Exception {
        IInAppBillingService iInAppBillingService;
        Context context;
        iInAppBillingService = this.f7966c.f7856h;
        context = this.f7966c.f7853e;
        return iInAppBillingService.a(3, context.getPackageName(), this.f7964a, this.f7965b, (String) null);
    }
}
