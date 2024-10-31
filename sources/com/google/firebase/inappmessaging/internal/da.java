package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class da implements io.reactivex.c.h {

    /* renamed from: a, reason: collision with root package name */
    private static final da f17855a = new da();

    private da() {
    }

    public static io.reactivex.c.h a() {
        return f17855a;
    }

    @Override // io.reactivex.c.h
    public boolean test(Object obj) {
        boolean equals;
        equals = ((CampaignProto.ThickContent) obj).p().equals(CampaignProto.ThickContent.PayloadCase.VANILLA_PAYLOAD);
        return equals;
    }
}
