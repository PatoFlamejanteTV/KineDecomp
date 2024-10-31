package com.adobe.creativesdk.foundation.storage;

import com.facebook.GraphResponse;

/* compiled from: AdobePhotoAsset.java */
/* loaded from: classes.dex */
class Bc implements c.a.a.a.b<AdobePhotoAsset> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.analytics.l f6932a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ sd f6933b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bc(com.adobe.creativesdk.foundation.internal.analytics.l lVar, sd sdVar) {
        this.f6932a = lVar;
        this.f6933b = sdVar;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(AdobePhotoAsset adobePhotoAsset) {
        adobePhotoAsset.handleCommonUploadCompletionBookKeeping();
        this.f6932a.a(GraphResponse.SUCCESS_KEY);
        this.f6933b.b(adobePhotoAsset);
    }
}
