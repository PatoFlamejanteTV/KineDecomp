package com.google.api.client.auth.oauth2;

import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.UrlEncodedContent;
import com.google.api.client.util.Data;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes.dex */
public class ClientParametersAuthentication implements HttpExecuteInterceptor, HttpRequestInitializer {

    /* renamed from: a, reason: collision with root package name */
    private final String f2409a;
    private final String b;

    @Override // com.google.api.client.http.HttpRequestInitializer
    public void a(HttpRequest httpRequest) throws IOException {
        httpRequest.a(this);
    }

    @Override // com.google.api.client.http.HttpExecuteInterceptor
    public void b(HttpRequest httpRequest) throws IOException {
        Map<String, Object> b = Data.b(UrlEncodedContent.a(httpRequest).g());
        b.put("client_id", this.f2409a);
        if (this.b != null) {
            b.put("client_secret", this.b);
        }
    }
}
