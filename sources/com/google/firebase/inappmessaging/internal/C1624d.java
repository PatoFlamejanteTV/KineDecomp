package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* renamed from: com.google.firebase.inappmessaging.internal.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C1624d implements io.reactivex.c.h {

    /* renamed from: a, reason: collision with root package name */
    private final CampaignCacheClient f17854a;

    private C1624d(CampaignCacheClient campaignCacheClient) {
        this.f17854a = campaignCacheClient;
    }

    public static io.reactivex.c.h a(CampaignCacheClient campaignCacheClient) {
        return new C1624d(campaignCacheClient);
    }

    @Override // io.reactivex.c.h
    public boolean test(Object obj) {
        boolean b2;
        b2 = this.f17854a.b((FetchEligibleCampaignsResponse) obj);
        return b2;
    }
}
