package com.adobe.creativesdk.foundation.internal.storage.photo;

import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.AdobePhotoAsset;
import com.adobe.creativesdk.foundation.storage.AdobePhotoErrorCode;
import com.adobe.creativesdk.foundation.storage.AdobePhotoException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoSession.java */
/* loaded from: classes.dex */
public class A implements ra.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobePhotoAsset f6638a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f6639b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f6640c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ F f6641d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public A(F f2, AdobePhotoAsset adobePhotoAsset, c.a.a.a.b bVar, c.a.a.a.c cVar) {
        this.f6641d = f2;
        this.f6638a = adobePhotoAsset;
        this.f6639b = bVar;
        this.f6640c = cVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        int g2 = lVar.g();
        AdobePhotoAsset adobePhotoAsset = this.f6638a;
        if (g2 != 200) {
            e = this.f6641d.a(lVar);
        } else {
            try {
                adobePhotoAsset.updateFromDictionary(c.a.a.a.c.e.b.a(lVar.d()), adobePhotoAsset.getCatalog());
                e = null;
            } catch (AdobePhotoException e2) {
                e = e2;
            }
        }
        if (e == null) {
            this.f6639b.b(adobePhotoAsset);
        } else {
            this.f6640c.a(e);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(AdobeNetworkException adobeNetworkException) {
        com.adobe.creativesdk.foundation.internal.net.l a2;
        AdobePhotoException adobePhotoException;
        AdobePhotoException a3;
        a2 = this.f6641d.a(adobeNetworkException);
        if (a2 != null) {
            a3 = this.f6641d.a(a2);
            adobePhotoException = a3;
        } else if (adobeNetworkException.getErrorCode() == AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorNotEntitledToService) {
            adobePhotoException = new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_NOT_ENTITLED_TO_SERVICE, adobeNetworkException.getData(), null);
        } else {
            adobePhotoException = new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_UNEXPECTED_RESPONSE, adobeNetworkException.getData(), null);
        }
        this.f6640c.a(adobePhotoException);
    }
}
