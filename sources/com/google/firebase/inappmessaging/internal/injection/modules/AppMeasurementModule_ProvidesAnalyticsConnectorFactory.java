package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.analytics.connector.AnalyticsConnector;
import d.a.f;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class AppMeasurementModule_ProvidesAnalyticsConnectorFactory implements d.a.c<AnalyticsConnector> {

    /* renamed from: a */
    private final AppMeasurementModule f17930a;

    public AppMeasurementModule_ProvidesAnalyticsConnectorFactory(AppMeasurementModule appMeasurementModule) {
        this.f17930a = appMeasurementModule;
    }

    public static d.a.c<AnalyticsConnector> a(AppMeasurementModule appMeasurementModule) {
        return new AppMeasurementModule_ProvidesAnalyticsConnectorFactory(appMeasurementModule);
    }

    @Override // javax.inject.Provider
    public AnalyticsConnector get() {
        AnalyticsConnector a2 = this.f17930a.a();
        f.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }
}
