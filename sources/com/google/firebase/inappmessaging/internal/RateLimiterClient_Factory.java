package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.vendored.Clock;
import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class RateLimiterClient_Factory implements d.a.c<RateLimiterClient> {

    /* renamed from: a, reason: collision with root package name */
    private final Provider<ProtoStorageClient> f17824a;

    /* renamed from: b, reason: collision with root package name */
    private final Provider<Clock> f17825b;

    public RateLimiterClient_Factory(Provider<ProtoStorageClient> provider, Provider<Clock> provider2) {
        this.f17824a = provider;
        this.f17825b = provider2;
    }

    public static d.a.c<RateLimiterClient> a(Provider<ProtoStorageClient> provider, Provider<Clock> provider2) {
        return new RateLimiterClient_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public RateLimiterClient get() {
        return new RateLimiterClient(this.f17824a.get(), this.f17825b.get());
    }
}
