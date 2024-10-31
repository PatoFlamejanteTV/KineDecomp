package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class B implements io.reactivex.c.f {

    /* renamed from: a, reason: collision with root package name */
    private final InAppMessageStreamManager f17716a;

    /* renamed from: b, reason: collision with root package name */
    private final String f17717b;

    private B(InAppMessageStreamManager inAppMessageStreamManager, String str) {
        this.f17716a = inAppMessageStreamManager;
        this.f17717b = str;
    }

    public static io.reactivex.c.f a(InAppMessageStreamManager inAppMessageStreamManager, String str) {
        return new B(inAppMessageStreamManager, str);
    }

    @Override // io.reactivex.c.f
    public Object apply(Object obj) {
        io.reactivex.k a2;
        a2 = this.f17716a.a((CampaignProto.ThickContent) obj, this.f17717b);
        return a2;
    }
}
