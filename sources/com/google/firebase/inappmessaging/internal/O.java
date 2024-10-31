package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class O implements io.reactivex.c.e {

    /* renamed from: a, reason: collision with root package name */
    private final AnalyticsEventsManager f17807a;

    private O(AnalyticsEventsManager analyticsEventsManager) {
        this.f17807a = analyticsEventsManager;
    }

    public static io.reactivex.c.e a(AnalyticsEventsManager analyticsEventsManager) {
        return new O(analyticsEventsManager);
    }

    @Override // io.reactivex.c.e
    public void accept(Object obj) {
        this.f17807a.b((FetchEligibleCampaignsResponse) obj);
    }
}
