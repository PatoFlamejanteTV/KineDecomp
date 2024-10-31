package com.google.firebase.inappmessaging.internal;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* renamed from: com.google.firebase.inappmessaging.internal.e */
/* loaded from: classes2.dex */
public final /* synthetic */ class C1625e implements io.reactivex.c.e {

    /* renamed from: a */
    private final CampaignCacheClient f17856a;

    private C1625e(CampaignCacheClient campaignCacheClient) {
        this.f17856a = campaignCacheClient;
    }

    public static io.reactivex.c.e a(CampaignCacheClient campaignCacheClient) {
        return new C1625e(campaignCacheClient);
    }

    @Override // io.reactivex.c.e
    public void accept(Object obj) {
        this.f17856a.f17722d = null;
    }
}
