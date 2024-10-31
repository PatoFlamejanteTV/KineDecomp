package com.google.firebase.inappmessaging.internal.injection.components;

import android.app.Application;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inappmessaging.internal.AnalyticsEventsManager;
import com.google.firebase.inappmessaging.internal.CampaignCacheClient;
import com.google.firebase.inappmessaging.internal.ImpressionStorageClient;
import com.google.firebase.inappmessaging.internal.RateLimiterClient;
import com.google.firebase.inappmessaging.internal.Schedulers;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.AppForeground;
import com.google.firebase.inappmessaging.internal.vendored.Clock;
import com.google.firebase.inappmessaging.model.RateLimit;
import io.grpc.AbstractC2407f;
import javax.inject.Singleton;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
@Singleton
/* loaded from: classes2.dex */
public interface UniversalComponent {
    @AppForeground
    RateLimit a();

    AnalyticsEventsManager b();

    ImpressionStorageClient c();

    RateLimiterClient d();

    @AppForeground
    io.reactivex.b.a<String> e();

    Clock f();

    AbstractC2407f g();

    Application h();

    Subscriber i();

    Schedulers j();

    CampaignCacheClient k();

    AnalyticsConnector l();
}
