package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.AppForeground;
import com.google.firebase.inappmessaging.internal.vendored.Clock;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.RateLimit;
import javax.inject.Inject;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public class DisplayCallbacksFactory {

    /* renamed from: a, reason: collision with root package name */
    private final ImpressionStorageClient f17733a;

    /* renamed from: b, reason: collision with root package name */
    private final Clock f17734b;

    /* renamed from: c, reason: collision with root package name */
    private final Schedulers f17735c;

    /* renamed from: d, reason: collision with root package name */
    private final RateLimiterClient f17736d;

    /* renamed from: e, reason: collision with root package name */
    private final CampaignCacheClient f17737e;

    /* renamed from: f, reason: collision with root package name */
    private final RateLimit f17738f;

    /* renamed from: g, reason: collision with root package name */
    private final MetricsLoggerClient f17739g;

    /* renamed from: h, reason: collision with root package name */
    private final DataCollectionHelper f17740h;

    @Inject
    public DisplayCallbacksFactory(ImpressionStorageClient impressionStorageClient, Clock clock, Schedulers schedulers, RateLimiterClient rateLimiterClient, CampaignCacheClient campaignCacheClient, @AppForeground RateLimit rateLimit, MetricsLoggerClient metricsLoggerClient, DataCollectionHelper dataCollectionHelper) {
        this.f17733a = impressionStorageClient;
        this.f17734b = clock;
        this.f17735c = schedulers;
        this.f17736d = rateLimiterClient;
        this.f17737e = campaignCacheClient;
        this.f17738f = rateLimit;
        this.f17739g = metricsLoggerClient;
        this.f17740h = dataCollectionHelper;
    }

    public FirebaseInAppMessagingDisplayCallbacks a(InAppMessage inAppMessage, String str) {
        return new DisplayCallbacksImpl(this.f17733a, this.f17734b, this.f17735c, this.f17736d, this.f17737e, this.f17738f, this.f17739g, this.f17740h, inAppMessage, str);
    }
}
