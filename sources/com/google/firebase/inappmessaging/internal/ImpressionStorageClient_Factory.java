package com.google.firebase.inappmessaging.internal;

import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class ImpressionStorageClient_Factory implements d.a.c<ImpressionStorageClient> {

    /* renamed from: a, reason: collision with root package name */
    private final Provider<ProtoStorageClient> f17777a;

    public ImpressionStorageClient_Factory(Provider<ProtoStorageClient> provider) {
        this.f17777a = provider;
    }

    public static d.a.c<ImpressionStorageClient> a(Provider<ProtoStorageClient> provider) {
        return new ImpressionStorageClient_Factory(provider);
    }

    @Override // javax.inject.Provider
    public ImpressionStorageClient get() {
        return new ImpressionStorageClient(this.f17777a.get());
    }
}
