package com.google.api.client.auth.oauth2;

import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequest;
import java.io.IOException;

/* compiled from: TokenRequest.java */
/* loaded from: classes2.dex */
class a implements HttpExecuteInterceptor {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ HttpExecuteInterceptor f14622a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ b f14623b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar, HttpExecuteInterceptor httpExecuteInterceptor) {
        this.f14623b = bVar;
        this.f14622a = httpExecuteInterceptor;
    }

    @Override // com.google.api.client.http.HttpExecuteInterceptor
    public void a(HttpRequest httpRequest) throws IOException {
        HttpExecuteInterceptor httpExecuteInterceptor = this.f14622a;
        if (httpExecuteInterceptor != null) {
            httpExecuteInterceptor.a(httpRequest);
        }
        HttpExecuteInterceptor httpExecuteInterceptor2 = this.f14623b.f14624a.f14616b;
        if (httpExecuteInterceptor2 != null) {
            httpExecuteInterceptor2.a(httpRequest);
        }
    }
}
