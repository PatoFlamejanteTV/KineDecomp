package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.events.Subscriber;
import javax.inject.Singleton;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public class AppMeasurementModule {

    /* renamed from: a */
    private AnalyticsConnector f17928a;

    /* renamed from: b */
    private Subscriber f17929b;

    public AppMeasurementModule(AnalyticsConnector analyticsConnector, Subscriber subscriber) {
        this.f17928a = analyticsConnector;
        this.f17929b = subscriber;
    }

    @Singleton
    public AnalyticsConnector a() {
        return this.f17928a;
    }

    @Singleton
    public Subscriber b() {
        return this.f17929b;
    }
}
