package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inappmessaging.internal.AnalyticsConnectorHandleManager;
import com.google.firebase.inappmessaging.internal.AnalyticsEventsManager;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.AnalyticsListener;
import javax.inject.Singleton;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public class AnalyticsEventsModule {
    @Singleton
    @AnalyticsListener
    public io.reactivex.b.a<String> a(AnalyticsEventsManager analyticsEventsManager) {
        return analyticsEventsManager.a();
    }

    @Singleton
    public AnalyticsConnectorHandleManager b(AnalyticsEventsManager analyticsEventsManager) {
        return new AnalyticsConnectorHandleManager(analyticsEventsManager.b());
    }

    @Singleton
    public AnalyticsEventsManager a(AnalyticsConnector analyticsConnector) {
        return new AnalyticsEventsManager(analyticsConnector);
    }
}
