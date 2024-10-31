package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.connector.AnalyticsConnector;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b implements AppMeasurement.OnEventListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzd f16351a;

    public b(zzd zzdVar) {
        this.f16351a = zzdVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzcy
    public final void onEvent(String str, String str2, Bundle bundle, long j) {
        AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener;
        if (this.f16351a.f16359a.contains(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(com.umeng.analytics.pro.b.ao, zzc.e(str2));
            analyticsConnectorListener = this.f16351a.f16360b;
            analyticsConnectorListener.a(2, bundle2);
        }
    }
}
