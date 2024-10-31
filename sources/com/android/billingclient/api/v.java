package com.android.billingclient.api;

import android.content.Context;
import android.os.Bundle;
import com.android.vending.billing.IInAppBillingService;
import java.util.concurrent.Callable;

/* compiled from: BillingClientImpl.java */
/* loaded from: classes.dex */
class v implements Callable<Bundle> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f7956a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f7957b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f7958c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Bundle f7959d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ C f7960e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(C c2, int i, String str, String str2, Bundle bundle) {
        this.f7960e = c2;
        this.f7956a = i;
        this.f7957b = str;
        this.f7958c = str2;
        this.f7959d = bundle;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Bundle call() throws Exception {
        IInAppBillingService iInAppBillingService;
        Context context;
        iInAppBillingService = this.f7960e.f7856h;
        int i = this.f7956a;
        context = this.f7960e.f7853e;
        return iInAppBillingService.a(i, context.getPackageName(), this.f7957b, this.f7958c, (String) null, this.f7959d);
    }
}
