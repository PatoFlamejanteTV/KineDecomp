package com.google.api.client.http;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class HttpRequestFactory {

    /* renamed from: a, reason: collision with root package name */
    private final HttpTransport f14772a;

    /* renamed from: b, reason: collision with root package name */
    private final HttpRequestInitializer f14773b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpRequestFactory(HttpTransport httpTransport, HttpRequestInitializer httpRequestInitializer) {
        this.f14772a = httpTransport;
        this.f14773b = httpRequestInitializer;
    }

    public HttpRequestInitializer a() {
        return this.f14773b;
    }

    public HttpTransport b() {
        return this.f14772a;
    }

    public HttpRequest a(String str, GenericUrl genericUrl, HttpContent httpContent) throws IOException {
        HttpRequest buildRequest = this.f14772a.buildRequest();
        HttpRequestInitializer httpRequestInitializer = this.f14773b;
        if (httpRequestInitializer != null) {
            httpRequestInitializer.b(buildRequest);
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

    public HttpRequest b(GenericUrl genericUrl, HttpContent httpContent) throws IOException {
        return a("PUT", genericUrl, httpContent);
    }

    public HttpRequest a(GenericUrl genericUrl) throws IOException {
        return a("GET", genericUrl, null);
    }

    public HttpRequest a(GenericUrl genericUrl, HttpContent httpContent) throws IOException {
        return a("POST", genericUrl, httpContent);
    }
}
