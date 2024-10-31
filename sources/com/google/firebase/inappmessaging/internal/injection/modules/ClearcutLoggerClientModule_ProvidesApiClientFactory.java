package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.inappmessaging.internal.MetricsLoggerClient;
import com.google.firebase.inappmessaging.internal.vendored.Clock;
import d.a.f;
import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class ClearcutLoggerClientModule_ProvidesApiClientFactory implements d.a.c<MetricsLoggerClient> {

    /* renamed from: a, reason: collision with root package name */
    private final ClearcutLoggerClientModule f17935a;

    /* renamed from: b, reason: collision with root package name */
    private final Provider<ClearcutLogger> f17936b;

    /* renamed from: c, reason: collision with root package name */
    private final Provider<AnalyticsConnector> f17937c;

    /* renamed from: d, reason: collision with root package name */
    private final Provider<FirebaseInstanceId> f17938d;

    /* renamed from: e, reason: collision with root package name */
    private final Provider<Clock> f17939e;

    public ClearcutLoggerClientModule_ProvidesApiClientFactory(ClearcutLoggerClientModule clearcutLoggerClientModule, Provider<ClearcutLogger> provider, Provider<AnalyticsConnector> provider2, Provider<FirebaseInstanceId> provider3, Provider<Clock> provider4) {
        this.f17935a = clearcutLoggerClientModule;
        this.f17936b = provider;
        this.f17937c = provider2;
        this.f17938d = provider3;
        this.f17939e = provider4;
    }

    public static d.a.c<MetricsLoggerClient> a(ClearcutLoggerClientModule clearcutLoggerClientModule, Provider<ClearcutLogger> provider, Provider<AnalyticsConnector> provider2, Provider<FirebaseInstanceId> provider3, Provider<Clock> provider4) {
        return new ClearcutLoggerClientModule_ProvidesApiClientFactory(clearcutLoggerClientModule, provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public MetricsLoggerClient get() {
        MetricsLoggerClient a2 = this.f17935a.a(this.f17936b.get(), this.f17937c.get(), this.f17938d.get(), this.f17939e.get());
        f.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }
}
