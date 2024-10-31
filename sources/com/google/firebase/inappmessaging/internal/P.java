package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class P implements io.reactivex.c.e {

    /* renamed from: a */
    private final TestDeviceHelper f17808a;

    private P(TestDeviceHelper testDeviceHelper) {
        this.f17808a = testDeviceHelper;
    }

    public static io.reactivex.c.e a(TestDeviceHelper testDeviceHelper) {
        return new P(testDeviceHelper);
    }

    @Override // io.reactivex.c.e
    public void accept(Object obj) {
        this.f17808a.a((FetchEligibleCampaignsResponse) obj);
    }
}
