package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzf implements zza {

    /* renamed from: a */
    private AnalyticsConnector.AnalyticsConnectorListener f16363a;

    /* renamed from: b */
    private AppMeasurement f16364b;

    /* renamed from: c */
    private c f16365c = new c(this);

    public zzf(AppMeasurement appMeasurement, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        this.f16363a = analyticsConnectorListener;
        this.f16364b = appMeasurement;
        this.f16364b.a(this.f16365c);
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final void a(Set<String> set) {
    }
}
