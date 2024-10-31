package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* renamed from: com.google.firebase.inappmessaging.internal.v, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C1641v implements io.reactivex.c.e {

    /* renamed from: a, reason: collision with root package name */
    private final ImpressionStorageClient f18001a;

    private C1641v(ImpressionStorageClient impressionStorageClient) {
        this.f18001a = impressionStorageClient;
    }

    public static io.reactivex.c.e a(ImpressionStorageClient impressionStorageClient) {
        return new C1641v(impressionStorageClient);
    }

    @Override // io.reactivex.c.e
    public void accept(Object obj) {
        this.f18001a.a((CampaignImpressionList) obj);
    }
}
