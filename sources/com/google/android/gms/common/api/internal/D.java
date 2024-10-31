package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;

/* loaded from: classes.dex */
final class D implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ C f10730a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public D(C c2) {
        this.f10730a = c2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Api.Client client;
        client = this.f10730a.f10729a.f10756b;
        client.disconnect();
    }
}
