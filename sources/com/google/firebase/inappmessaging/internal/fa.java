package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class fa implements io.reactivex.c.h {

    /* renamed from: a, reason: collision with root package name */
    private final String f17859a;

    private fa(String str) {
        this.f17859a = str;
    }

    public static io.reactivex.c.h a(String str) {
        return new fa(str);
    }

    @Override // io.reactivex.c.h
    public boolean test(Object obj) {
        boolean b2;
        b2 = InAppMessageStreamManager.b(this.f17859a, (CampaignProto.ThickContent) obj);
        return b2;
    }
}
