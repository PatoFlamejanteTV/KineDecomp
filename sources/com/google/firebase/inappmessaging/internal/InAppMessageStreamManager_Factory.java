package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.vendored.Clock;
import com.google.firebase.inappmessaging.model.RateLimit;
import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class InAppMessageStreamManager_Factory implements d.a.c<InAppMessageStreamManager> {

    /* renamed from: a, reason: collision with root package name */
    private final Provider<io.reactivex.b.a<String>> f17786a;

    /* renamed from: b, reason: collision with root package name */
    private final Provider<CampaignCacheClient> f17787b;

    /* renamed from: c, reason: collision with root package name */
    private final Provider<Clock> f17788c;

    /* renamed from: d, reason: collision with root package name */
    private final Provider<ApiClient> f17789d;

    /* renamed from: e, reason: collision with root package name */
    private final Provider<AnalyticsEventsManager> f17790e;

    /* renamed from: f, reason: collision with root package name */
    private final Provider<Schedulers> f17791f;

    /* renamed from: g, reason: collision with root package name */
    private final Provider<ImpressionStorageClient> f17792g;

    /* renamed from: h, reason: collision with root package name */
    private final Provider<RateLimiterClient> f17793h;
    private final Provider<RateLimit> i;
    private final Provider<TestDeviceHelper> j;

    public InAppMessageStreamManager_Factory(Provider<io.reactivex.b.a<String>> provider, Provider<CampaignCacheClient> provider2, Provider<Clock> provider3, Provider<ApiClient> provider4, Provider<AnalyticsEventsManager> provider5, Provider<Schedulers> provider6, Provider<ImpressionStorageClient> provider7, Provider<RateLimiterClient> provider8, Provider<RateLimit> provider9, Provider<TestDeviceHelper> provider10) {
        this.f17786a = provider;
        this.f17787b = provider2;
        this.f17788c = provider3;
        this.f17789d = provider4;
        this.f17790e = provider5;
        this.f17791f = provider6;
        this.f17792g = provider7;
        this.f17793h = provider8;
        this.i = provider9;
        this.j = provider10;
    }

    public static d.a.c<InAppMessageStreamManager> a(Provider<io.reactivex.b.a<String>> provider, Provider<CampaignCacheClient> provider2, Provider<Clock> provider3, Provider<ApiClient> provider4, Provider<AnalyticsEventsManager> provider5, Provider<Schedulers> provider6, Provider<ImpressionStorageClient> provider7, Provider<RateLimiterClient> provider8, Provider<RateLimit> provider9, Provider<TestDeviceHelper> provider10) {
        return new InAppMessageStreamManager_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    @Override // javax.inject.Provider
    public InAppMessageStreamManager get() {
        return new InAppMessageStreamManager(this.f17786a.get(), this.f17787b.get(), this.f17788c.get(), this.f17789d.get(), this.f17790e.get(), this.f17791f.get(), this.f17792g.get(), this.f17793h.get(), this.i.get(), this.j.get());
    }
}
