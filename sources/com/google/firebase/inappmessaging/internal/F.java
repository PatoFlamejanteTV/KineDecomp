package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class F implements io.reactivex.c.f {

    /* renamed from: a, reason: collision with root package name */
    private final InAppMessageStreamManager f17758a;

    private F(InAppMessageStreamManager inAppMessageStreamManager) {
        this.f17758a = inAppMessageStreamManager;
    }

    public static io.reactivex.c.f a(InAppMessageStreamManager inAppMessageStreamManager) {
        return new F(inAppMessageStreamManager);
    }

    @Override // io.reactivex.c.f
    public Object apply(Object obj) {
        return InAppMessageStreamManager.a(this.f17758a, (CampaignProto.ThickContent) obj);
    }
}
