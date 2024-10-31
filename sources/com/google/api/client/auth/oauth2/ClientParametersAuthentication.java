package com.google.api.client.auth.oauth2;

import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.UrlEncodedContent;
import com.google.api.client.util.Data;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes2.dex */
public class ClientParametersAuthentication implements HttpRequestInitializer, HttpExecuteInterceptor {

    /* renamed from: a, reason: collision with root package name */
    private final String f14593a;

    /* renamed from: b, reason: collision with root package name */
    private final String f14594b;

    @Override // com.google.api.client.http.HttpExecuteInterceptor
    public void a(HttpRequest httpRequest) throws IOException {
        Map<String, Object> d2 = Data.d(UrlEncodedContent.a(httpRequest).e());
        d2.put("client_id", this.f14593a);
        String str = this.f14594b;
        if (str != null) {
            d2.put("client_secret", str);
        }
    }

    @Override // com.google.api.client.http.HttpRequestInitializer
    public void b(HttpRequest httpRequest) throws IOException {
        httpRequest.a(this);
    }
}
