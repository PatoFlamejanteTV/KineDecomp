package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class I implements io.reactivex.c.f {

    /* renamed from: a, reason: collision with root package name */
    private final InAppMessageStreamManager f17769a;

    /* renamed from: b, reason: collision with root package name */
    private final String f17770b;

    /* renamed from: c, reason: collision with root package name */
    private final io.reactivex.c.f f17771c;

    /* renamed from: d, reason: collision with root package name */
    private final io.reactivex.c.f f17772d;

    /* renamed from: e, reason: collision with root package name */
    private final io.reactivex.c.f f17773e;

    private I(InAppMessageStreamManager inAppMessageStreamManager, String str, io.reactivex.c.f fVar, io.reactivex.c.f fVar2, io.reactivex.c.f fVar3) {
        this.f17769a = inAppMessageStreamManager;
        this.f17770b = str;
        this.f17771c = fVar;
        this.f17772d = fVar2;
        this.f17773e = fVar3;
    }

    public static io.reactivex.c.f a(InAppMessageStreamManager inAppMessageStreamManager, String str, io.reactivex.c.f fVar, io.reactivex.c.f fVar2, io.reactivex.c.f fVar3) {
        return new I(inAppMessageStreamManager, str, fVar, fVar2, fVar3);
    }

    @Override // io.reactivex.c.f
    public Object apply(Object obj) {
        io.reactivex.i a2;
        a2 = this.f17769a.a(this.f17770b, this.f17771c, this.f17772d, this.f17773e, (FetchEligibleCampaignsResponse) obj);
        return a2;
    }
}
