package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class V implements io.reactivex.c.f {

    /* renamed from: a, reason: collision with root package name */
    private final CampaignProto.ThickContent f17842a;

    private V(CampaignProto.ThickContent thickContent) {
        this.f17842a = thickContent;
    }

    public static io.reactivex.c.f a(CampaignProto.ThickContent thickContent) {
        return new V(thickContent);
    }

    @Override // io.reactivex.c.f
    public Object apply(Object obj) {
        CampaignProto.ThickContent thickContent = this.f17842a;
        InAppMessageStreamManager.a(thickContent, (Boolean) obj);
        return thickContent;
    }
}
