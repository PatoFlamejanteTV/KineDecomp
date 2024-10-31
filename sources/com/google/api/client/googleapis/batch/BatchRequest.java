package com.google.api.client.googleapis.batch;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sleeper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class BatchRequest {
    private final HttpRequestFactory c;
    private GenericUrl b = new GenericUrl("https://www.googleapis.com/batch");

    /* renamed from: a */
    List<a<?, ?>> f2431a = new ArrayList();
    private Sleeper d = Sleeper.f2547a;

    /* loaded from: classes.dex */
    public static class a<T, E> {

        /* renamed from: a */
        final BatchCallback<T, E> f2432a;
        final Class<T> b;
        final Class<E> c;
        final HttpRequest d;

        a(BatchCallback<T, E> batchCallback, Class<T> cls, Class<E> cls2, HttpRequest httpRequest) {
            this.f2432a = batchCallback;
            this.b = cls;
            this.c = cls2;
            this.d = httpRequest;
        }
    }

    public BatchRequest(HttpTransport httpTransport, HttpRequestInitializer httpRequestInitializer) {
        this.c = httpRequestInitializer == null ? httpTransport.createRequestFactory() : httpTransport.createRequestFactory(httpRequestInitializer);
    }

    public BatchRequest a(GenericUrl genericUrl) {
        this.b = genericUrl;
        return this;
    }

    public <T, E> BatchRequest a(HttpRequest httpRequest, Class<T> cls, Class<E> cls2, BatchCallback<T, E> batchCallback) throws IOException {
        Preconditions.a(httpRequest);
        Preconditions.a(batchCallback);
        Preconditions.a(cls);
        Preconditions.a(cls2);
        this.f2431a.add(new a<>(batchCallback, cls, cls2, httpRequest));
        return this;
    }
}
