package com.google.api.client.testing.http.apache;

import com.google.api.client.util.Beta;
import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.RequestDirector;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.protocol.HttpContext;

/* compiled from: MockHttpClient.java */
/* loaded from: classes2.dex */
class a implements RequestDirector {

    /* renamed from: a */
    final /* synthetic */ MockHttpClient f14869a;

    public a(MockHttpClient mockHttpClient) {
        this.f14869a = mockHttpClient;
    }

    @Override // org.apache.http.client.RequestDirector
    @Beta
    public HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
        return new BasicHttpResponse(HttpVersion.HTTP_1_1, this.f14869a.f14868a, (String) null);
    }
}
