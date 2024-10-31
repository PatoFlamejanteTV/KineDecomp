package com.adobe.creativesdk.foundation.storage;

/* compiled from: AdobePhotoAsset.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.gc, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0560gc implements c.a.a.a.b<AdobePhotoAsset> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ sd f7268a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobePhotoAsset f7269b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0560gc(AdobePhotoAsset adobePhotoAsset, sd sdVar) {
        this.f7269b = adobePhotoAsset;
        this.f7268a = sdVar;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(AdobePhotoAsset adobePhotoAsset) {
        this.f7269b.handleCommonUploadCompletionBookKeeping();
        this.f7268a.b(adobePhotoAsset);
    }
}
