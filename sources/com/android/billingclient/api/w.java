package com.android.billingclient.api;

import android.content.Context;
import android.os.Bundle;
import com.android.vending.billing.IInAppBillingService;
import java.util.Arrays;
import java.util.concurrent.Callable;

/* compiled from: BillingClientImpl.java */
/* loaded from: classes.dex */
class w implements Callable<Bundle> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ F f7961a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f7962b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C f7963c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(C c2, F f2, String str) {
        this.f7963c = c2;
        this.f7961a = f2;
        this.f7962b = str;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Bundle call() throws Exception {
        IInAppBillingService iInAppBillingService;
        Context context;
        iInAppBillingService = this.f7963c.f7856h;
        context = this.f7963c.f7853e;
        return iInAppBillingService.a(5, context.getPackageName(), Arrays.asList(this.f7961a.c()), this.f7962b, "subs", (String) null);
    }
}
