package com.google.firebase.analytics.connector.internal;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnectorImpl;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.events.Subscriber;

/* loaded from: classes2.dex */
final /* synthetic */ class a implements ComponentFactory {

    /* renamed from: a, reason: collision with root package name */
    static final ComponentFactory f16350a = new a();

    private a() {
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object a(ComponentContainer componentContainer) {
        return AnalyticsConnectorImpl.a((FirebaseApp) componentContainer.a(FirebaseApp.class), (Context) componentContainer.a(Context.class), (Subscriber) componentContainer.a(Subscriber.class));
    }
}
