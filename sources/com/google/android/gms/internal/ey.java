package com.google.android.gms.internal;

import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
class ey implements ProxyApi.ProxyResult {

    /* renamed from: a, reason: collision with root package name */
    private Status f1543a;
    private ProxyResponse b;

    public ey(ProxyResponse proxyResponse) {
        this.b = proxyResponse;
        this.f1543a = Status.f979a;
    }

    public ey(Status status) {
        this.f1543a = status;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.f1543a;
    }
}
