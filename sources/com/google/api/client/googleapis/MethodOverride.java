package com.google.api.client.googleapis;

import com.google.api.client.http.EmptyContent;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.UrlEncodedContent;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class MethodOverride implements HttpExecuteInterceptor, HttpRequestInitializer {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f14646a;

    /* loaded from: classes2.dex */
    public static final class Builder {
    }

    public MethodOverride() {
        this(false);
    }

    private boolean c(HttpRequest httpRequest) throws IOException {
        String i = httpRequest.i();
        if (i.equals("POST")) {
            return false;
        }
        if (!i.equals("GET") ? this.f14646a : httpRequest.o().build().length() > 2048) {
            return !httpRequest.m().supportsMethod(i);
        }
        return true;
    }

    @Override // com.google.api.client.http.HttpExecuteInterceptor
    public void a(HttpRequest httpRequest) throws IOException {
        if (c(httpRequest)) {
            String i = httpRequest.i();
            httpRequest.a("POST");
            httpRequest.e().set("X-HTTP-Method-Override", (Object) i);
            if (i.equals("GET")) {
                httpRequest.a(new UrlEncodedContent(httpRequest.o().clone()));
                httpRequest.o().clear();
            } else if (httpRequest.b() == null) {
                httpRequest.a(new EmptyContent());
            }
        }
    }

    @Override // com.google.api.client.http.HttpRequestInitializer
    public void b(HttpRequest httpRequest) {
        httpRequest.a(this);
    }

    MethodOverride(boolean z) {
        this.f14646a = z;
    }
}
