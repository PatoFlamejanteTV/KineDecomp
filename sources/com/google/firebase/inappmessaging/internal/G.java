package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class G implements io.reactivex.c.f {

    /* renamed from: a, reason: collision with root package name */
    private final InAppMessageStreamManager f17764a;

    /* renamed from: b, reason: collision with root package name */
    private final String f17765b;

    private G(InAppMessageStreamManager inAppMessageStreamManager, String str) {
        this.f17764a = inAppMessageStreamManager;
        this.f17765b = str;
    }

    public static io.reactivex.c.f a(InAppMessageStreamManager inAppMessageStreamManager, String str) {
        return new G(inAppMessageStreamManager, str);
    }

    @Override // io.reactivex.c.f
    public Object apply(Object obj) {
        io.reactivex.i c2;
        c2 = this.f17764a.c(this.f17765b, (CampaignProto.ThickContent) obj);
        return c2;
    }
}
