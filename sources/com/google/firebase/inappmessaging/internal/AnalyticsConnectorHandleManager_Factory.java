package com.google.firebase.inappmessaging.internal;

import com.google.firebase.analytics.connector.AnalyticsConnector;
import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class AnalyticsConnectorHandleManager_Factory implements d.a.c<AnalyticsConnectorHandleManager> {

    /* renamed from: a */
    private final Provider<AnalyticsConnector.AnalyticsConnectorHandle> f17705a;

    @Override // javax.inject.Provider
    public AnalyticsConnectorHandleManager get() {
        return new AnalyticsConnectorHandleManager(this.f17705a.get());
    }
}
