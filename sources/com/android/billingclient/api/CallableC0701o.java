package com.android.billingclient.api;

import android.content.Context;
import android.os.Bundle;
import com.android.vending.billing.IInAppBillingService;
import java.util.concurrent.Callable;

/* compiled from: BillingClientImpl.java */
/* renamed from: com.android.billingclient.api.o */
/* loaded from: classes.dex */
public class CallableC0701o implements Callable<Void> {

    /* renamed from: a */
    final /* synthetic */ C0688b f7934a;

    /* renamed from: b */
    final /* synthetic */ InterfaceC0689c f7935b;

    /* renamed from: c */
    final /* synthetic */ C f7936c;

    public CallableC0701o(C c2, C0688b c0688b, InterfaceC0689c interfaceC0689c) {
        this.f7936c = c2;
        this.f7934a = c0688b;
        this.f7935b = interfaceC0689c;
    }

    @Override // java.util.concurrent.Callable
    public Void call() {
        IInAppBillingService iInAppBillingService;
        Context context;
        try {
            iInAppBillingService = this.f7936c.f7856h;
            context = this.f7936c.f7853e;
            Bundle a2 = iInAppBillingService.a(9, context.getPackageName(), this.f7934a.b(), c.b.a.a.a.a(this.f7934a));
            this.f7936c.a(new RunnableC0700n(this, c.b.a.a.a.b(a2, "BillingClient"), c.b.a.a.a.a(a2, "BillingClient")));
            return null;
        } catch (Exception e2) {
            this.f7936c.a(new RunnableC0699m(this, e2));
            return null;
        }
    }
}
