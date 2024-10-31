package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class T implements io.reactivex.c.e {

    /* renamed from: a, reason: collision with root package name */
    private final CampaignProto.ThickContent f17835a;

    private T(CampaignProto.ThickContent thickContent) {
        this.f17835a = thickContent;
    }

    public static io.reactivex.c.e a(CampaignProto.ThickContent thickContent) {
        return new T(thickContent);
    }

    @Override // io.reactivex.c.e
    public void accept(Object obj) {
        Logging.c(String.format("Already impressed %s ? : %s", this.f17835a.s().p(), (Boolean) obj));
    }
}
