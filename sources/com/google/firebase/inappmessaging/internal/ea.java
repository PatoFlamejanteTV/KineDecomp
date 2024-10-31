package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class ea implements io.reactivex.c.h {

    /* renamed from: a, reason: collision with root package name */
    private final InAppMessageStreamManager f17857a;

    private ea(InAppMessageStreamManager inAppMessageStreamManager) {
        this.f17857a = inAppMessageStreamManager;
    }

    public static io.reactivex.c.h a(InAppMessageStreamManager inAppMessageStreamManager) {
        return new ea(inAppMessageStreamManager);
    }

    @Override // io.reactivex.c.h
    public boolean test(Object obj) {
        return InAppMessageStreamManager.b(this.f17857a, (CampaignProto.ThickContent) obj);
    }
}
