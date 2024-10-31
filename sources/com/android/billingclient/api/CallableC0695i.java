package com.android.billingclient.api;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: BillingClientImpl.java */
/* renamed from: com.android.billingclient.api.i */
/* loaded from: classes.dex */
public class CallableC0695i implements Callable<Void> {

    /* renamed from: a */
    final /* synthetic */ String f7918a;

    /* renamed from: b */
    final /* synthetic */ List f7919b;

    /* renamed from: c */
    final /* synthetic */ T f7920c;

    /* renamed from: d */
    final /* synthetic */ C f7921d;

    public CallableC0695i(C c2, String str, List list, T t) {
        this.f7921d = c2;
        this.f7918a = str;
        this.f7919b = list;
        this.f7920c = t;
    }

    @Override // java.util.concurrent.Callable
    public Void call() {
        this.f7921d.a(new RunnableC0694h(this, this.f7921d.a(this.f7918a, this.f7919b)));
        return null;
    }
}
