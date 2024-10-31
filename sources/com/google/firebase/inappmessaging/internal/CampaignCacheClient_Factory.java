package com.google.firebase.inappmessaging.internal;

import android.app.Application;
import com.google.firebase.inappmessaging.internal.vendored.Clock;
import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class CampaignCacheClient_Factory implements d.a.c<CampaignCacheClient> {

    /* renamed from: a, reason: collision with root package name */
    private final Provider<ProtoStorageClient> f17723a;

    /* renamed from: b, reason: collision with root package name */
    private final Provider<Application> f17724b;

    /* renamed from: c, reason: collision with root package name */
    private final Provider<Clock> f17725c;

    public CampaignCacheClient_Factory(Provider<ProtoStorageClient> provider, Provider<Application> provider2, Provider<Clock> provider3) {
        this.f17723a = provider;
        this.f17724b = provider2;
        this.f17725c = provider3;
    }

    public static d.a.c<CampaignCacheClient> a(Provider<ProtoStorageClient> provider, Provider<Application> provider2, Provider<Clock> provider3) {
        return new CampaignCacheClient_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public CampaignCacheClient get() {
        return new CampaignCacheClient(this.f17723a.get(), this.f17724b.get(), this.f17725c.get());
    }
}
