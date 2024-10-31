package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class M implements Callable {

    /* renamed from: a, reason: collision with root package name */
    private final InAppMessageStreamManager f17797a;

    /* renamed from: b, reason: collision with root package name */
    private final CampaignImpressionList f17798b;

    private M(InAppMessageStreamManager inAppMessageStreamManager, CampaignImpressionList campaignImpressionList) {
        this.f17797a = inAppMessageStreamManager;
        this.f17798b = campaignImpressionList;
    }

    public static Callable a(InAppMessageStreamManager inAppMessageStreamManager, CampaignImpressionList campaignImpressionList) {
        return new M(inAppMessageStreamManager, campaignImpressionList);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        FetchEligibleCampaignsResponse a2;
        a2 = this.f17797a.f17781d.a(this.f17798b);
        return a2;
    }
}
