package com.adobe.creativesdk.foundation.storage;

/* compiled from: AdobePhotoAsset.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.kc, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0576kc implements c.a.a.a.b<AdobePhotoAsset> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ sd f7323a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobePhotoAsset f7324b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0576kc(AdobePhotoAsset adobePhotoAsset, sd sdVar) {
        this.f7324b = adobePhotoAsset;
        this.f7323a = sdVar;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(AdobePhotoAsset adobePhotoAsset) {
        this.f7324b.handleCommonUploadCompletionBookKeeping();
        this.f7323a.b(adobePhotoAsset);
    }
}
