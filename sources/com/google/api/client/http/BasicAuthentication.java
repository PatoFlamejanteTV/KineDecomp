package com.google.api.client.http;

import java.io.IOException;

/* loaded from: classes.dex */
public final class BasicAuthentication implements HttpExecuteInterceptor, HttpRequestInitializer {

    /* renamed from: a, reason: collision with root package name */
    private final String f2451a;
    private final String b;

    @Override // com.google.api.client.http.HttpRequestInitializer
    public void a(HttpRequest httpRequest) throws IOException {
        httpRequest.a(this);
    }

    @Override // com.google.api.client.http.HttpExecuteInterceptor
    public void b(HttpRequest httpRequest) throws IOException {
        httpRequest.g().a(this.f2451a, this.b);
    }
}
