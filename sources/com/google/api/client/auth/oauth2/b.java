package com.google.api.client.auth.oauth2;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TokenRequest.java */
/* loaded from: classes2.dex */
public class b implements HttpRequestInitializer {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TokenRequest f14624a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(TokenRequest tokenRequest) {
        this.f14624a = tokenRequest;
    }

    @Override // com.google.api.client.http.HttpRequestInitializer
    public void b(HttpRequest httpRequest) throws IOException {
        HttpRequestInitializer httpRequestInitializer = this.f14624a.f14615a;
        if (httpRequestInitializer != null) {
            httpRequestInitializer.b(httpRequest);
        }
        httpRequest.a(new a(this, httpRequest.g()));
    }
}
