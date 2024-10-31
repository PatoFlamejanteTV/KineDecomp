package com.google.api.client.auth.oauth2;

import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequest;
import java.io.IOException;

/* compiled from: TokenRequest.java */
/* loaded from: classes.dex */
class b implements HttpExecuteInterceptor {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ HttpExecuteInterceptor f2417a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, HttpExecuteInterceptor httpExecuteInterceptor) {
        this.b = aVar;
        this.f2417a = httpExecuteInterceptor;
    }

    @Override // com.google.api.client.http.HttpExecuteInterceptor
    public void b(HttpRequest httpRequest) throws IOException {
        if (this.f2417a != null) {
            this.f2417a.b(httpRequest);
        }
        if (this.b.f2416a.b != null) {
            this.b.f2416a.b.b(httpRequest);
        }
    }
}
