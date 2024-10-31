package com.adobe.creativesdk.foundation.storage;

import com.facebook.GraphResponse;

/* compiled from: AdobePhotoAsset.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.cc, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0544cc implements c.a.a.a.b<AdobePhotoAsset> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.analytics.l f7222a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ vd f7223b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AdobePhotoAsset f7224c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0544cc(AdobePhotoAsset adobePhotoAsset, com.adobe.creativesdk.foundation.internal.analytics.l lVar, vd vdVar) {
        this.f7224c = adobePhotoAsset;
        this.f7222a = lVar;
        this.f7223b = vdVar;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(AdobePhotoAsset adobePhotoAsset) {
        this.f7222a.a(GraphResponse.SUCCESS_KEY);
        this.f7223b.a();
    }
}
