package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.auth.AdobeAuthException;

/* compiled from: AdobePhotoAsset.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.bc, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0540bc implements c.a.a.a.c<AdobeAuthException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f7211a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobePhotoAsset f7212b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0540bc(AdobePhotoAsset adobePhotoAsset, c.a.a.a.c cVar) {
        this.f7212b = adobePhotoAsset;
        this.f7211a = cVar;
    }

    @Override // c.a.a.a.c
    public void a(AdobeAuthException adobeAuthException) {
        c.a.a.a.c cVar = this.f7211a;
        if (cVar != null) {
            cVar.a(adobeAuthException);
        }
    }
}
