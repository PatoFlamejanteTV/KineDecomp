package com.google.api.client.http;

import java.io.IOException;

/* loaded from: classes.dex */
public final class HttpRequestFactory {

    /* renamed from: a */
    private final HttpTransport f2466a;
    private final HttpRequestInitializer b;

    public HttpRequestFactory(HttpTransport httpTransport, HttpRequestInitializer httpRequestInitializer) {
        this.f2466a = httpTransport;
        this.b = httpRequestInitializer;
    }

    public HttpTransport a() {
        return this.f2466a;
    }

    public HttpRequestInitializer b() {
        return this.b;
    }

    public HttpRequest a(String str, GenericUrl genericUrl, HttpContent httpContent) throws IOException {
        HttpRequest buildRequest = this.f2466a.buildRequest();
        if (this.b != null) {
            this.b.a(buildRequest);
        }
        buildRequest.a(str);
        if (genericUrl != null) {
            buildRequest.a(genericUrl);
        }
        if (httpContent != null) {
            buildRequest.a(httpContent);
        }
        return buildRequest;
    }

    public HttpRequest a(GenericUrl genericUrl) throws IOException {
        return a("GET", genericUrl, null);
    }

    public HttpRequest a(GenericUrl genericUrl, HttpContent httpContent) throws IOException {
        return a("POST", genericUrl, httpContent);
    }

    public HttpRequest b(GenericUrl genericUrl, HttpContent httpContent) throws IOException {
        return a("PUT", genericUrl, httpContent);
    }
}
