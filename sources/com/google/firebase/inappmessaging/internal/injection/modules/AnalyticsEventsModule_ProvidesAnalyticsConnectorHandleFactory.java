package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.internal.AnalyticsConnectorHandleManager;
import com.google.firebase.inappmessaging.internal.AnalyticsEventsManager;
import d.a.f;
import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class AnalyticsEventsModule_ProvidesAnalyticsConnectorHandleFactory implements d.a.c<AnalyticsConnectorHandleManager> {

    /* renamed from: a, reason: collision with root package name */
    private final AnalyticsEventsModule f17909a;

    /* renamed from: b, reason: collision with root package name */
    private final Provider<AnalyticsEventsManager> f17910b;

    public AnalyticsEventsModule_ProvidesAnalyticsConnectorHandleFactory(AnalyticsEventsModule analyticsEventsModule, Provider<AnalyticsEventsManager> provider) {
        this.f17909a = analyticsEventsModule;
        this.f17910b = provider;
    }

    public static d.a.c<AnalyticsConnectorHandleManager> a(AnalyticsEventsModule analyticsEventsModule, Provider<AnalyticsEventsManager> provider) {
        return new AnalyticsEventsModule_ProvidesAnalyticsConnectorHandleFactory(analyticsEventsModule, provider);
    }

    @Override // javax.inject.Provider
    public AnalyticsConnectorHandleManager get() {
        AnalyticsConnectorHandleManager b2 = this.f17909a.b(this.f17910b.get());
        f.a(b2, "Cannot return null from a non-@Nullable @Provides method");
        return b2;
    }
}
