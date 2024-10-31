package com.google.api.client.googleapis.services;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseInterceptor;
import java.io.IOException;

/* compiled from: AbstractGoogleClientRequest.java */
/* loaded from: classes.dex */
public class a implements HttpResponseInterceptor {

    /* renamed from: a */
    final /* synthetic */ HttpResponseInterceptor f2443a;
    final /* synthetic */ HttpRequest b;
    final /* synthetic */ AbstractGoogleClientRequest c;

    public a(AbstractGoogleClientRequest abstractGoogleClientRequest, HttpResponseInterceptor httpResponseInterceptor, HttpRequest httpRequest) {
        this.c = abstractGoogleClientRequest;
        this.f2443a = httpResponseInterceptor;
        this.b = httpRequest;
    }

    @Override // com.google.api.client.http.HttpResponseInterceptor
    public void a(HttpResponse httpResponse) throws IOException {
        if (this.f2443a != null) {
            this.f2443a.a(httpResponse);
        }
        if (!httpResponse.c() && this.b.o()) {
            throw this.c.newExceptionOnError(httpResponse);
        }
    }
}
