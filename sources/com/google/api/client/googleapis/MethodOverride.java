package com.google.api.client.googleapis;

import com.google.api.client.http.EmptyContent;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.UrlEncodedContent;
import java.io.IOException;

/* loaded from: classes.dex */
public final class MethodOverride implements HttpExecuteInterceptor, HttpRequestInitializer {

    /* renamed from: a */
    private final boolean f2425a;

    /* loaded from: classes.dex */
    public static final class Builder {
    }

    public MethodOverride() {
        this(false);
    }

    MethodOverride(boolean z) {
        this.f2425a = z;
    }

    @Override // com.google.api.client.http.HttpRequestInitializer
    public void a(HttpRequest httpRequest) {
        httpRequest.a(this);
    }

    @Override // com.google.api.client.http.HttpExecuteInterceptor
    public void b(HttpRequest httpRequest) throws IOException {
        if (c(httpRequest)) {
            String b = httpRequest.b();
            httpRequest.a("POST");
            httpRequest.g().set("X-HTTP-Method-Override", (Object) b);
            if (b.equals("GET")) {
                httpRequest.a(new UrlEncodedContent(httpRequest.c().clone()));
                httpRequest.c().clear();
            } else if (httpRequest.d() == null) {
                httpRequest.a(new EmptyContent());
            }
        }
    }

    private boolean c(HttpRequest httpRequest) throws IOException {
        String b = httpRequest.b();
        if (b.equals("POST")) {
            return false;
        }
        if (b.equals("GET")) {
            if (httpRequest.c().j().length() > 2048) {
                return true;
            }
        } else if (this.f2425a) {
            return true;
        }
        return !httpRequest.a().supportsMethod(b);
    }
}
