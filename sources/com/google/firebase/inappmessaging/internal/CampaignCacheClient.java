package com.google.firebase.inappmessaging.internal;

import android.app.Application;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.CampaignCache;
import com.google.firebase.inappmessaging.internal.vendored.Clock;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import java.io.File;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
@Singleton
@ThreadSafe
/* loaded from: classes2.dex */
public class CampaignCacheClient {

    /* renamed from: a */
    private final ProtoStorageClient f17719a;

    /* renamed from: b */
    private final Application f17720b;

    /* renamed from: c */
    private final Clock f17721c;

    /* renamed from: d */
    @Nullable
    private FetchEligibleCampaignsResponse f17722d;

    @Inject
    public CampaignCacheClient(@CampaignCache ProtoStorageClient protoStorageClient, Application application, Clock clock) {
        this.f17719a = protoStorageClient;
        this.f17720b = application;
        this.f17721c = clock;
    }

    public io.reactivex.a a(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        return this.f17719a.a(fetchEligibleCampaignsResponse).a(C1621a.a(this, fetchEligibleCampaignsResponse));
    }

    public boolean b(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        long o = fetchEligibleCampaignsResponse.o();
        long now = this.f17721c.now();
        File file = new File(this.f17720b.getApplicationContext().getFilesDir(), "fiam_eligible_campaigns_cache_file");
        return o != 0 ? now < o : !file.exists() || now < file.lastModified() + TimeUnit.DAYS.toMillis(1L);
    }

    public io.reactivex.i<FetchEligibleCampaignsResponse> a() {
        return io.reactivex.i.a(CallableC1622b.a(this)).b((io.reactivex.k) this.f17719a.a(FetchEligibleCampaignsResponse.r()).b(C1623c.a(this))).a(C1624d.a(this)).a(C1625e.a(this));
    }
}
