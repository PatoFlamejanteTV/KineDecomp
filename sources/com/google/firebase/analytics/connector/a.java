package com.google.firebase.analytics.connector;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.Set;

/* loaded from: classes2.dex */
class a implements AnalyticsConnector.AnalyticsConnectorHandle {

    /* renamed from: a */
    private final /* synthetic */ String f16346a;

    /* renamed from: b */
    private final /* synthetic */ AnalyticsConnectorImpl f16347b;

    public a(AnalyticsConnectorImpl analyticsConnectorImpl, String str) {
        this.f16347b = analyticsConnectorImpl;
        this.f16346a = str;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle
    @KeepForSdk
    public void a(Set<String> set) {
        boolean a2;
        a2 = this.f16347b.a(this.f16346a);
        if (!a2 || !this.f16346a.equals("fiam") || set == null || set.isEmpty()) {
            return;
        }
        this.f16347b.f16345c.get(this.f16346a).a(set);
    }
}
