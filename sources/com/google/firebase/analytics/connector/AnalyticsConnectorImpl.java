package com.google.firebase.analytics.connector;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.internal.zzan;
import com.google.android.gms.measurement.internal.zzbw;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.internal.zza;
import com.google.firebase.analytics.connector.internal.zzc;
import com.google.firebase.analytics.connector.internal.zzd;
import com.google.firebase.analytics.connector.internal.zzf;
import com.google.firebase.events.Event;
import com.google.firebase.events.Subscriber;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class AnalyticsConnectorImpl implements AnalyticsConnector {

    /* renamed from: a */
    private static volatile AnalyticsConnector f16343a;

    /* renamed from: b */
    @VisibleForTesting
    private final AppMeasurement f16344b;

    /* renamed from: c */
    @VisibleForTesting
    final Map<String, zza> f16345c;

    private AnalyticsConnectorImpl(AppMeasurement appMeasurement) {
        Preconditions.a(appMeasurement);
        this.f16344b = appMeasurement;
        this.f16345c = new ConcurrentHashMap();
    }

    @KeepForSdk
    public static AnalyticsConnector a(FirebaseApp firebaseApp, Context context, Subscriber subscriber) {
        Preconditions.a(firebaseApp);
        Preconditions.a(context);
        Preconditions.a(subscriber);
        Preconditions.a(context.getApplicationContext());
        if (f16343a == null) {
            synchronized (AnalyticsConnectorImpl.class) {
                if (f16343a == null) {
                    Bundle bundle = new Bundle(1);
                    if (firebaseApp.h()) {
                        subscriber.a(DataCollectionDefaultChange.class, b.f16348a, c.f16349a);
                        bundle.putBoolean("dataCollectionDefaultEnabled", firebaseApp.g());
                    }
                    f16343a = new AnalyticsConnectorImpl(zzbw.a(context, zzan.a(bundle)).v());
                }
            }
        }
        return f16343a;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @KeepForSdk
    public void logEvent(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (zzc.a(str) && zzc.a(str2, bundle) && zzc.a(str, str2, bundle)) {
            this.f16344b.logEventInternal(str, str2, bundle);
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @KeepForSdk
    public void a(String str, String str2, Object obj) {
        if (zzc.a(str) && zzc.a(str, str2)) {
            this.f16344b.a(str, str2, obj);
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @KeepForSdk
    public AnalyticsConnector.AnalyticsConnectorHandle a(String str, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        zza zzfVar;
        Preconditions.a(analyticsConnectorListener);
        if (!zzc.a(str) || a(str)) {
            return null;
        }
        AppMeasurement appMeasurement = this.f16344b;
        if ("fiam".equals(str)) {
            zzfVar = new zzd(appMeasurement, analyticsConnectorListener);
        } else {
            zzfVar = "crash".equals(str) ? new zzf(appMeasurement, analyticsConnectorListener) : null;
        }
        if (zzfVar == null) {
            return null;
        }
        this.f16345c.put(str, zzfVar);
        return new a(this, str);
    }

    public final boolean a(String str) {
        return (str.isEmpty() || !this.f16345c.containsKey(str) || this.f16345c.get(str) == null) ? false : true;
    }

    public static final /* synthetic */ void a(Event event) {
        boolean z = ((DataCollectionDefaultChange) event.a()).f16320a;
        synchronized (AnalyticsConnectorImpl.class) {
            ((AnalyticsConnectorImpl) f16343a).f16344b.c(z);
        }
    }
}
