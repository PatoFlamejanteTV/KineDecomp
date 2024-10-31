package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class A implements io.reactivex.c.a {

    /* renamed from: a, reason: collision with root package name */
    private final ImpressionStorageClient f17702a;

    /* renamed from: b, reason: collision with root package name */
    private final CampaignImpressionList f17703b;

    private A(ImpressionStorageClient impressionStorageClient, CampaignImpressionList campaignImpressionList) {
        this.f17702a = impressionStorageClient;
        this.f17703b = campaignImpressionList;
    }

    public static io.reactivex.c.a a(ImpressionStorageClient impressionStorageClient, CampaignImpressionList campaignImpressionList) {
        return new A(impressionStorageClient, campaignImpressionList);
    }

    @Override // io.reactivex.c.a
    public void run() {
        this.f17702a.a(this.f17703b);
    }
}
