package com.adobe.creativesdk.foundation.internal.storage.photo;

import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.AdobePhotoCollection;
import com.adobe.creativesdk.foundation.storage.AdobePhotoErrorCode;
import com.adobe.creativesdk.foundation.storage.AdobePhotoException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoSession.java */
/* loaded from: classes.dex */
public class k implements ra.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f6700a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobePhotoCollection f6701b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f6702c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ F f6703d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(F f2, c.a.a.a.b bVar, AdobePhotoCollection adobePhotoCollection, c.a.a.a.c cVar) {
        this.f6703d = f2;
        this.f6700a = bVar;
        this.f6701b = adobePhotoCollection;
        this.f6702c = cVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        AdobePhotoException a2 = lVar.g() == 204 ? null : this.f6703d.a(lVar);
        if (a2 == null) {
            this.f6700a.b(this.f6701b);
        } else {
            this.f6702c.a(a2);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(AdobeNetworkException adobeNetworkException) {
        com.adobe.creativesdk.foundation.internal.net.l a2;
        AdobePhotoException adobePhotoException;
        AdobePhotoException a3;
        a2 = this.f6703d.a(adobeNetworkException);
        if (a2 != null) {
            a3 = this.f6703d.a(a2);
            adobePhotoException = a3;
        } else if (adobeNetworkException.getErrorCode() == AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorNotEntitledToService) {
            adobePhotoException = new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_NOT_ENTITLED_TO_SERVICE, adobeNetworkException.getData(), null);
        } else {
            adobePhotoException = new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_UNEXPECTED_RESPONSE, adobeNetworkException.getData(), null);
        }
        this.f6702c.a(adobePhotoException);
    }
}
