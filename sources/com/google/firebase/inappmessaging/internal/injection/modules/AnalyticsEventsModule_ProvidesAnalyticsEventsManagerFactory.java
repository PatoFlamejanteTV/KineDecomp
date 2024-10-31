package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inappmessaging.internal.AnalyticsEventsManager;
import d.a.f;
import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class AnalyticsEventsModule_ProvidesAnalyticsEventsManagerFactory implements d.a.c<AnalyticsEventsManager> {

    /* renamed from: a, reason: collision with root package name */
    private final AnalyticsEventsModule f17911a;

    /* renamed from: b, reason: collision with root package name */
    private final Provider<AnalyticsConnector> f17912b;

    public AnalyticsEventsModule_ProvidesAnalyticsEventsManagerFactory(AnalyticsEventsModule analyticsEventsModule, Provider<AnalyticsConnector> provider) {
        this.f17911a = analyticsEventsModule;
        this.f17912b = provider;
    }

    public static d.a.c<AnalyticsEventsManager> a(AnalyticsEventsModule analyticsEventsModule, Provider<AnalyticsConnector> provider) {
        return new AnalyticsEventsModule_ProvidesAnalyticsEventsManagerFactory(analyticsEventsModule, provider);
    }

    @Override // javax.inject.Provider
    public AnalyticsEventsManager get() {
        AnalyticsEventsManager a2 = this.f17911a.a(this.f17912b.get());
        f.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }
}
