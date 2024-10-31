package com.google.firebase.analytics.connector;

import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Set;

/* loaded from: classes2.dex */
public interface AnalyticsConnector {

    @KeepForSdk
    /* loaded from: classes2.dex */
    public interface AnalyticsConnectorHandle {
        @KeepForSdk
        void a(Set<String> set);
    }

    @KeepForSdk
    /* loaded from: classes2.dex */
    public interface AnalyticsConnectorListener {
        @KeepForSdk
        void a(int i, Bundle bundle);
    }

    @KeepForSdk
    /* loaded from: classes2.dex */
    public static class ConditionalUserProperty {
    }

    @KeepForSdk
    AnalyticsConnectorHandle a(String str, AnalyticsConnectorListener analyticsConnectorListener);

    @KeepForSdk
    void a(String str, String str2, Object obj);

    @KeepForSdk
    void logEvent(String str, String str2, Bundle bundle);
}
