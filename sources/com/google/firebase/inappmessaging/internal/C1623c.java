package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* renamed from: com.google.firebase.inappmessaging.internal.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C1623c implements io.reactivex.c.e {

    /* renamed from: a, reason: collision with root package name */
    private final CampaignCacheClient f17852a;

    private C1623c(CampaignCacheClient campaignCacheClient) {
        this.f17852a = campaignCacheClient;
    }

    public static io.reactivex.c.e a(CampaignCacheClient campaignCacheClient) {
        return new C1623c(campaignCacheClient);
    }

    @Override // io.reactivex.c.e
    public void accept(Object obj) {
        this.f17852a.f17722d = (FetchEligibleCampaignsResponse) obj;
    }
}
