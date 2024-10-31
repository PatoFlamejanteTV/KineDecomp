package com.google.api.client.auth.oauth2;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import java.io.IOException;

/* compiled from: TokenRequest.java */
/* loaded from: classes.dex */
public class a implements HttpRequestInitializer {

    /* renamed from: a */
    final /* synthetic */ TokenRequest f2416a;

    public a(TokenRequest tokenRequest) {
        this.f2416a = tokenRequest;
    }

    @Override // com.google.api.client.http.HttpRequestInitializer
    public void a(HttpRequest httpRequest) throws IOException {
        if (this.f2416a.f2414a != null) {
            this.f2416a.f2414a.a(httpRequest);
        }
        httpRequest.a(new b(this, httpRequest.i()));
    }
}
