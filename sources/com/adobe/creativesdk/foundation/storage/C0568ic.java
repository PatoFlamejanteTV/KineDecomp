package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.auth.AdobeAuthException;

/* compiled from: AdobePhotoAsset.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.ic, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0568ic implements c.a.a.a.c<AdobeAuthException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ sd f7292a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobePhotoAsset f7293b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0568ic(AdobePhotoAsset adobePhotoAsset, sd sdVar) {
        this.f7293b = adobePhotoAsset;
        this.f7292a = sdVar;
    }

    @Override // c.a.a.a.c
    public void a(AdobeAuthException adobeAuthException) {
        sd sdVar = this.f7292a;
        if (sdVar != null) {
            sdVar.a((sd) adobeAuthException);
        }
    }
}
