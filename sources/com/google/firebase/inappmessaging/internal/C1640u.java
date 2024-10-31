package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpression;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* renamed from: com.google.firebase.inappmessaging.internal.u, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C1640u implements io.reactivex.c.f {

    /* renamed from: a, reason: collision with root package name */
    private final ImpressionStorageClient f17999a;

    /* renamed from: b, reason: collision with root package name */
    private final CampaignImpression f18000b;

    private C1640u(ImpressionStorageClient impressionStorageClient, CampaignImpression campaignImpression) {
        this.f17999a = impressionStorageClient;
        this.f18000b = campaignImpression;
    }

    public static io.reactivex.c.f a(ImpressionStorageClient impressionStorageClient, CampaignImpression campaignImpression) {
        return new C1640u(impressionStorageClient, campaignImpression);
    }

    @Override // io.reactivex.c.f
    public Object apply(Object obj) {
        return ImpressionStorageClient.a(this.f17999a, this.f18000b, (CampaignImpressionList) obj);
    }
}
