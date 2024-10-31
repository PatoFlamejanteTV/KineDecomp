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

/* loaded from: classes2.dex */
public final class BatchRequest {

    /* renamed from: b, reason: collision with root package name */
    private final HttpRequestFactory f14656b;

    /* renamed from: a, reason: collision with root package name */
    private GenericUrl f14655a = new GenericUrl("https://www.googleapis.com/batch");

    /* renamed from: c, reason: collision with root package name */
    List<a<?, ?>> f14657c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private Sleeper f14658d = Sleeper.f14980a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a<T, E> {

        /* renamed from: a, reason: collision with root package name */
        final BatchCallback<T, E> f14659a;

        /* renamed from: b, reason: collision with root package name */
        final Class<T> f14660b;

        /* renamed from: c, reason: collision with root package name */
        final Class<E> f14661c;

        /* renamed from: d, reason: collision with root package name */
        final HttpRequest f14662d;

        a(BatchCallback<T, E> batchCallback, Class<T> cls, Class<E> cls2, HttpRequest httpRequest) {
            this.f14659a = batchCallback;
            this.f14660b = cls;
            this.f14661c = cls2;
            this.f14662d = httpRequest;
        }
    }

    public BatchRequest(HttpTransport httpTransport, HttpRequestInitializer httpRequestInitializer) {
        this.f14656b = httpRequestInitializer == null ? httpTransport.createRequestFactory() : httpTransport.createRequestFactory(httpRequestInitializer);
    }

    public BatchRequest a(GenericUrl genericUrl) {
        this.f14655a = genericUrl;
        return this;
    }

    public <T, E> BatchRequest a(HttpRequest httpRequest, Class<T> cls, Class<E> cls2, BatchCallback<T, E> batchCallback) throws IOException {
        Preconditions.a(httpRequest);
        Preconditions.a(batchCallback);
        Preconditions.a(cls);
        Preconditions.a(cls2);
        this.f14657c.add(new a<>(batchCallback, cls, cls2, httpRequest));
        return this;
    }
}
