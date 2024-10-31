package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.inappmessaging.internal.MetricsLoggerClient;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import com.google.firebase.inappmessaging.internal.vendored.Clock;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public class ClearcutLoggerClientModule {

    /* renamed from: a, reason: collision with root package name */
    private final FirebaseApp f17934a;

    public ClearcutLoggerClientModule(FirebaseApp firebaseApp) {
        this.f17934a = firebaseApp;
    }

    @FirebaseAppScope
    public ClearcutLogger a(Application application) {
        return new ClearcutLogger(application, "FIREBASE_INAPPMESSAGING", null);
    }

    @FirebaseAppScope
    public MetricsLoggerClient a(ClearcutLogger clearcutLogger, AnalyticsConnector analyticsConnector, FirebaseInstanceId firebaseInstanceId, Clock clock) {
        return new MetricsLoggerClient(a.a(clearcutLogger), analyticsConnector, this.f17934a, firebaseInstanceId, clock);
    }
}
