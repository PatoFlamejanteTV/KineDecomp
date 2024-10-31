package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* renamed from: com.google.firebase.inappmessaging.internal.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C1621a implements io.reactivex.c.a {

    /* renamed from: a, reason: collision with root package name */
    private final CampaignCacheClient f17847a;

    /* renamed from: b, reason: collision with root package name */
    private final FetchEligibleCampaignsResponse f17848b;

    private C1621a(CampaignCacheClient campaignCacheClient, FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        this.f17847a = campaignCacheClient;
        this.f17848b = fetchEligibleCampaignsResponse;
    }

    public static io.reactivex.c.a a(CampaignCacheClient campaignCacheClient, FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        return new C1621a(campaignCacheClient, fetchEligibleCampaignsResponse);
    }

    @Override // io.reactivex.c.a
    public void run() {
        this.f17847a.f17722d = this.f17848b;
    }
}
