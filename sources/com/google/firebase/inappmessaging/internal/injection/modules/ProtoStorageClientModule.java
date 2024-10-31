package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.internal.ProtoStorageClient;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.CampaignCache;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.ImpressionStore;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.RateLimit;
import javax.inject.Singleton;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public class ProtoStorageClientModule {
    @Singleton
    @CampaignCache
    public ProtoStorageClient a(Application application) {
        return new ProtoStorageClient(application, "fiam_eligible_campaigns_cache_file");
    }

    @Singleton
    @ImpressionStore
    public ProtoStorageClient b(Application application) {
        return new ProtoStorageClient(application, "fiam_impressions_store_file");
    }

    @RateLimit
    @Singleton
    public ProtoStorageClient c(Application application) {
        return new ProtoStorageClient(application, "rate_limit_store_file");
    }
}
