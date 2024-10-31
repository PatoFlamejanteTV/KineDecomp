package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.vendored.Clock;
import com.google.firebase.inappmessaging.model.RateLimit;
import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class DisplayCallbacksFactory_Factory implements d.a.c<DisplayCallbacksFactory> {

    /* renamed from: a, reason: collision with root package name */
    private final Provider<ImpressionStorageClient> f17741a;

    /* renamed from: b, reason: collision with root package name */
    private final Provider<Clock> f17742b;

    /* renamed from: c, reason: collision with root package name */
    private final Provider<Schedulers> f17743c;

    /* renamed from: d, reason: collision with root package name */
    private final Provider<RateLimiterClient> f17744d;

    /* renamed from: e, reason: collision with root package name */
    private final Provider<CampaignCacheClient> f17745e;

    /* renamed from: f, reason: collision with root package name */
    private final Provider<RateLimit> f17746f;

    /* renamed from: g, reason: collision with root package name */
    private final Provider<MetricsLoggerClient> f17747g;

    /* renamed from: h, reason: collision with root package name */
    private final Provider<DataCollectionHelper> f17748h;

    public DisplayCallbacksFactory_Factory(Provider<ImpressionStorageClient> provider, Provider<Clock> provider2, Provider<Schedulers> provider3, Provider<RateLimiterClient> provider4, Provider<CampaignCacheClient> provider5, Provider<RateLimit> provider6, Provider<MetricsLoggerClient> provider7, Provider<DataCollectionHelper> provider8) {
        this.f17741a = provider;
        this.f17742b = provider2;
        this.f17743c = provider3;
        this.f17744d = provider4;
        this.f17745e = provider5;
        this.f17746f = provider6;
        this.f17747g = provider7;
        this.f17748h = provider8;
    }

    public static d.a.c<DisplayCallbacksFactory> a(Provider<ImpressionStorageClient> provider, Provider<Clock> provider2, Provider<Schedulers> provider3, Provider<RateLimiterClient> provider4, Provider<CampaignCacheClient> provider5, Provider<RateLimit> provider6, Provider<MetricsLoggerClient> provider7, Provider<DataCollectionHelper> provider8) {
        return new DisplayCallbacksFactory_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    @Override // javax.inject.Provider
    public DisplayCallbacksFactory get() {
        return new DisplayCallbacksFactory(this.f17741a.get(), this.f17742b.get(), this.f17743c.get(), this.f17744d.get(), this.f17745e.get(), this.f17746f.get(), this.f17747g.get(), this.f17748h.get());
    }
}
