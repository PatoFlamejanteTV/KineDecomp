package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class E implements io.reactivex.c.e {

    /* renamed from: a, reason: collision with root package name */
    private final InAppMessageStreamManager f17757a;

    private E(InAppMessageStreamManager inAppMessageStreamManager) {
        this.f17757a = inAppMessageStreamManager;
    }

    public static io.reactivex.c.e a(InAppMessageStreamManager inAppMessageStreamManager) {
        return new E(inAppMessageStreamManager);
    }

    @Override // io.reactivex.c.e
    public void accept(Object obj) {
        this.f17757a.f17779b.a((FetchEligibleCampaignsResponse) obj).a(W.a()).a(Y.a()).a(Z.a()).c();
    }
}
