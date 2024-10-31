package com.google.api.client.googleapis.services;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseInterceptor;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractGoogleClientRequest.java */
/* loaded from: classes2.dex */
public class a implements HttpResponseInterceptor {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ HttpResponseInterceptor f14706a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ HttpRequest f14707b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AbstractGoogleClientRequest f14708c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbstractGoogleClientRequest abstractGoogleClientRequest, HttpResponseInterceptor httpResponseInterceptor, HttpRequest httpRequest) {
        this.f14708c = abstractGoogleClientRequest;
        this.f14706a = httpResponseInterceptor;
        this.f14707b = httpRequest;
    }

    @Override // com.google.api.client.http.HttpResponseInterceptor
    public void a(HttpResponse httpResponse) throws IOException {
        HttpResponseInterceptor httpResponseInterceptor = this.f14706a;
        if (httpResponseInterceptor != null) {
            httpResponseInterceptor.a(httpResponse);
        }
        if (!httpResponse.j() && this.f14707b.l()) {
            throw this.f14708c.newExceptionOnError(httpResponse);
        }
    }
}
