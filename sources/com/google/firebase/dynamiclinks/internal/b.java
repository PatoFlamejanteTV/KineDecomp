package com.google.firebase.dynamiclinks.internal;

import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* loaded from: classes2.dex */
final /* synthetic */ class b implements ComponentFactory {

    /* renamed from: a, reason: collision with root package name */
    static final ComponentFactory f17274a = new b();

    private b() {
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object a(ComponentContainer componentContainer) {
        return new zzg((FirebaseApp) componentContainer.a(FirebaseApp.class), (AnalyticsConnector) componentContainer.a(AnalyticsConnector.class));
    }
}
