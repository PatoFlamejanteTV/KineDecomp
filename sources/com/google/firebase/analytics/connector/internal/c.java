package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.connector.AnalyticsConnector;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class c implements AppMeasurement.OnEventListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzf f16352a;

    public c(zzf zzfVar) {
        this.f16352a = zzfVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzcy
    public final void onEvent(String str, String str2, Bundle bundle, long j) {
        AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener;
        if (str == null || str.equals("crash") || !zzc.b(str2)) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str2);
        bundle2.putLong("timestampInMillis", j);
        bundle2.putBundle(NativeProtocol.WEB_DIALOG_PARAMS, bundle);
        analyticsConnectorListener = this.f16352a.f16363a;
        analyticsConnectorListener.a(3, bundle2);
    }
}
