package com.google.firebase.inappmessaging.internal;

import android.text.TextUtils;
import com.google.common.annotations.VisibleForTesting;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inappmessaging.CommonTypesProto;
import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import io.reactivex.BackpressureStrategy;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public class AnalyticsEventsManager {

    /* renamed from: a, reason: collision with root package name */
    private final AnalyticsConnector f17706a;

    /* renamed from: b, reason: collision with root package name */
    private final io.reactivex.b.a<String> f17707b = io.reactivex.e.a(new a(), BackpressureStrategy.BUFFER).g();

    /* renamed from: c, reason: collision with root package name */
    private AnalyticsConnector.AnalyticsConnectorHandle f17708c;

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    private class a implements io.reactivex.g<String> {
        a() {
        }

        @Override // io.reactivex.g
        public void a(io.reactivex.f<String> fVar) {
            Logging.a("Subscribing to analytics events.");
            AnalyticsEventsManager analyticsEventsManager = AnalyticsEventsManager.this;
            analyticsEventsManager.f17708c = analyticsEventsManager.f17706a.a("fiam", new C1638s(fVar));
        }
    }

    public AnalyticsEventsManager(AnalyticsConnector analyticsConnector) {
        this.f17706a = analyticsConnector;
        this.f17707b.i();
    }

    @Nullable
    public AnalyticsConnector.AnalyticsConnectorHandle b() {
        return this.f17708c;
    }

    public void b(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        Set<String> a2 = a(fetchEligibleCampaignsResponse);
        Logging.a("Updating contextual triggers for the following analytics events: " + a2);
        this.f17708c.a(a2);
    }

    public io.reactivex.b.a<String> a() {
        return this.f17707b;
    }

    @VisibleForTesting
    static Set<String> a(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        HashSet hashSet = new HashSet();
        Iterator<CampaignProto.ThickContent> it = fetchEligibleCampaignsResponse.p().iterator();
        while (it.hasNext()) {
            for (CommonTypesProto.TriggeringCondition triggeringCondition : it.next().r()) {
                if (triggeringCondition.o() != null && !TextUtils.isEmpty(triggeringCondition.o().o())) {
                    hashSet.add(triggeringCondition.o().o());
                }
            }
        }
        if (hashSet.size() > 50) {
            Logging.c("Too many contextual triggers defined - limiting to 50");
        }
        return hashSet;
    }
}
