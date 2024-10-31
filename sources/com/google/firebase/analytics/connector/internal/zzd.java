package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzd implements zza {

    /* renamed from: a, reason: collision with root package name */
    Set<String> f16359a;

    /* renamed from: b, reason: collision with root package name */
    private AnalyticsConnector.AnalyticsConnectorListener f16360b;

    /* renamed from: c, reason: collision with root package name */
    private AppMeasurement f16361c;

    /* renamed from: d, reason: collision with root package name */
    private b f16362d = new b(this);

    public zzd(AppMeasurement appMeasurement, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        this.f16360b = analyticsConnectorListener;
        this.f16361c = appMeasurement;
        this.f16361c.a(this.f16362d);
        this.f16359a = new HashSet();
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final void a(Set<String> set) {
        this.f16359a.clear();
        Set<String> set2 = this.f16359a;
        HashSet hashSet = new HashSet();
        for (String str : set) {
            if (hashSet.size() >= 50) {
                break;
            } else if (zzc.d(str) && zzc.c(str)) {
                hashSet.add(zzc.f(str));
            }
        }
        set2.addAll(hashSet);
    }
}
