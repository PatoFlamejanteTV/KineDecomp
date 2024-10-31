package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class K implements io.reactivex.c.f {

    /* renamed from: a, reason: collision with root package name */
    private final InAppMessageStreamManager f17795a;

    private K(InAppMessageStreamManager inAppMessageStreamManager) {
        this.f17795a = inAppMessageStreamManager;
    }

    public static io.reactivex.c.f a(InAppMessageStreamManager inAppMessageStreamManager) {
        return new K(inAppMessageStreamManager);
    }

    @Override // io.reactivex.c.f
    public Object apply(Object obj) {
        return InAppMessageStreamManager.b(this.f17795a, (CampaignImpressionList) obj);
    }
}
