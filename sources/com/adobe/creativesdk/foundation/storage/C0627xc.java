package com.adobe.creativesdk.foundation.storage;

/* compiled from: AdobePhotoAsset.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.xc, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0627xc implements c.a.a.a.b<AdobePhotoAsset> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ sd f7469a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0627xc(sd sdVar) {
        this.f7469a = sdVar;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(AdobePhotoAsset adobePhotoAsset) {
        adobePhotoAsset.handleCommonUploadCompletionBookKeeping();
        this.f7469a.b(adobePhotoAsset);
    }
}
