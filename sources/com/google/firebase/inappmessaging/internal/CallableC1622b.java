package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* renamed from: com.google.firebase.inappmessaging.internal.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class CallableC1622b implements Callable {

    /* renamed from: a, reason: collision with root package name */
    private final CampaignCacheClient f17850a;

    private CallableC1622b(CampaignCacheClient campaignCacheClient) {
        this.f17850a = campaignCacheClient;
    }

    public static Callable a(CampaignCacheClient campaignCacheClient) {
        return new CallableC1622b(campaignCacheClient);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse;
        fetchEligibleCampaignsResponse = this.f17850a.f17722d;
        return fetchEligibleCampaignsResponse;
    }
}
