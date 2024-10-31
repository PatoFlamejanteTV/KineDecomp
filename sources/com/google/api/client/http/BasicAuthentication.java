package com.google.api.client.http;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class BasicAuthentication implements HttpRequestInitializer, HttpExecuteInterceptor {

    /* renamed from: a, reason: collision with root package name */
    private final String f14726a;

    /* renamed from: b, reason: collision with root package name */
    private final String f14727b;

    @Override // com.google.api.client.http.HttpExecuteInterceptor
    public void a(HttpRequest httpRequest) throws IOException {
        httpRequest.e().e(this.f14726a, this.f14727b);
    }

    @Override // com.google.api.client.http.HttpRequestInitializer
    public void b(HttpRequest httpRequest) throws IOException {
        httpRequest.a(this);
    }
}
