package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.auth.AdobeAuthException;

/* compiled from: AdobePhotoAsset.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.ec, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0552ec implements c.a.a.a.c<AdobeAuthException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ sd f7238a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobePhotoAsset f7239b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0552ec(AdobePhotoAsset adobePhotoAsset, sd sdVar) {
        this.f7239b = adobePhotoAsset;
        this.f7238a = sdVar;
    }

    @Override // c.a.a.a.c
    public void a(AdobeAuthException adobeAuthException) {
        sd sdVar = this.f7238a;
        if (sdVar != null) {
            sdVar.a((sd) adobeAuthException);
        }
    }
}
