package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.injection.qualifiers.ImpressionStore;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpression;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList;
import javax.inject.Inject;
import javax.inject.Singleton;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
@Singleton
/* loaded from: classes2.dex */
public class ImpressionStorageClient {

    /* renamed from: a */
    private static final CampaignImpressionList f17774a = CampaignImpressionList.o();

    /* renamed from: b */
    private final ProtoStorageClient f17775b;

    /* renamed from: c */
    private io.reactivex.i<CampaignImpressionList> f17776c = io.reactivex.i.b();

    @Inject
    public ImpressionStorageClient(@ImpressionStore ProtoStorageClient protoStorageClient) {
        this.f17775b = protoStorageClient;
    }

    private static CampaignImpressionList a(CampaignImpressionList campaignImpressionList, CampaignImpression campaignImpression) {
        return CampaignImpressionList.a(campaignImpressionList).a(campaignImpression).build();
    }

    public void b() {
        this.f17776c = io.reactivex.i.b();
    }

    public io.reactivex.a a(CampaignImpression campaignImpression) {
        return a().a((io.reactivex.i<CampaignImpressionList>) f17774a).b(C1640u.a(this, campaignImpression));
    }

    public static /* synthetic */ io.reactivex.c a(ImpressionStorageClient impressionStorageClient, CampaignImpression campaignImpression, CampaignImpressionList campaignImpressionList) throws Exception {
        CampaignImpressionList a2 = a(campaignImpressionList, campaignImpression);
        return impressionStorageClient.f17775b.a(a2).a(A.a(impressionStorageClient, a2));
    }

    public io.reactivex.i<CampaignImpressionList> a() {
        return this.f17776c.b(this.f17775b.a(CampaignImpressionList.p()).b(C1641v.a(this))).a(C1642w.a(this));
    }

    public void a(CampaignImpressionList campaignImpressionList) {
        this.f17776c = io.reactivex.i.b(campaignImpressionList);
    }

    public io.reactivex.s<Boolean> a(String str) {
        return a().d(C1643x.a()).c((io.reactivex.c.f<? super R, ? extends io.reactivex.p<? extends R>>) C1644y.a()).c(C1645z.a()).a(str);
    }
}
