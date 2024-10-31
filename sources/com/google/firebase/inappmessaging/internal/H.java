package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class H implements io.reactivex.c.f {

    /* renamed from: a, reason: collision with root package name */
    private static final H f17768a = new H();

    private H() {
    }

    public static io.reactivex.c.f a() {
        return f17768a;
    }

    @Override // io.reactivex.c.f
    public Object apply(Object obj) {
        return InAppMessageStreamManager.a((CampaignProto.ThickContent) obj);
    }
}
