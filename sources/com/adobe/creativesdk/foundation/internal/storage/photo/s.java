package com.adobe.creativesdk.foundation.internal.storage.photo;

import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.AdobePhotoAsset;
import com.adobe.creativesdk.foundation.storage.AdobePhotoCatalog;
import com.adobe.creativesdk.foundation.storage.AdobePhotoErrorCode;
import com.adobe.creativesdk.foundation.storage.AdobePhotoException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoSession.java */
/* loaded from: classes.dex */
public class s implements ra.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobePhotoAsset f6736a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobePhotoCatalog f6737b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f6738c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f6739d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ F f6740e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(F f2, AdobePhotoAsset adobePhotoAsset, AdobePhotoCatalog adobePhotoCatalog, c.a.a.a.b bVar, c.a.a.a.c cVar) {
        this.f6740e = f2;
        this.f6736a = adobePhotoAsset;
        this.f6737b = adobePhotoCatalog;
        this.f6738c = bVar;
        this.f6739d = cVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        if (lVar.g() != 202) {
            e = this.f6740e.a(lVar);
        } else {
            try {
                this.f6736a.updateFromDictionary(c.a.a.a.c.e.b.a(lVar.d()), this.f6737b);
                e = null;
            } catch (AdobePhotoException e2) {
                e = e2;
            }
        }
        if (e == null) {
            this.f6738c.b(this.f6736a);
        } else {
            this.f6739d.a(e);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(AdobeNetworkException adobeNetworkException) {
        com.adobe.creativesdk.foundation.internal.net.l a2;
        AdobePhotoException adobePhotoException;
        AdobePhotoException a3;
        a2 = this.f6740e.a(adobeNetworkException);
        if (a2 != null) {
            a3 = this.f6740e.a(a2);
            adobePhotoException = a3;
        } else if (adobeNetworkException.getErrorCode() == AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorNotEntitledToService) {
            adobePhotoException = new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_NOT_ENTITLED_TO_SERVICE, adobeNetworkException.getData(), null);
        } else {
            adobePhotoException = new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_UNEXPECTED_RESPONSE, adobeNetworkException.getData(), null);
        }
        this.f6739d.a(adobePhotoException);
    }
}
