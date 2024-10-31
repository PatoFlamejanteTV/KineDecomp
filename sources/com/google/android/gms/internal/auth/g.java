package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
final class g implements ProxyApi.ProxyResult {

    /* renamed from: a */
    private Status f12750a;

    /* renamed from: b */
    private ProxyResponse f12751b;

    public g(ProxyResponse proxyResponse) {
        this.f12751b = proxyResponse;
        this.f12750a = Status.f10704a;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f12750a;
    }

    public g(Status status) {
        this.f12750a = status;
    }
}
