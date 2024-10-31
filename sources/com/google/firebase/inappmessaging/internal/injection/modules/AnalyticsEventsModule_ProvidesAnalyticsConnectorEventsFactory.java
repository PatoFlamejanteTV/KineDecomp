package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.internal.AnalyticsEventsManager;
import d.a.f;
import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class AnalyticsEventsModule_ProvidesAnalyticsConnectorEventsFactory implements d.a.c<io.reactivex.b.a<String>> {

    /* renamed from: a, reason: collision with root package name */
    private final AnalyticsEventsModule f17907a;

    /* renamed from: b, reason: collision with root package name */
    private final Provider<AnalyticsEventsManager> f17908b;

    public AnalyticsEventsModule_ProvidesAnalyticsConnectorEventsFactory(AnalyticsEventsModule analyticsEventsModule, Provider<AnalyticsEventsManager> provider) {
        this.f17907a = analyticsEventsModule;
        this.f17908b = provider;
    }

    public static d.a.c<io.reactivex.b.a<String>> a(AnalyticsEventsModule analyticsEventsModule, Provider<AnalyticsEventsManager> provider) {
        return new AnalyticsEventsModule_ProvidesAnalyticsConnectorEventsFactory(analyticsEventsModule, provider);
    }

    @Override // javax.inject.Provider
    public io.reactivex.b.a<String> get() {
        io.reactivex.b.a<String> a2 = this.f17907a.a(this.f17908b.get());
        f.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }
}
