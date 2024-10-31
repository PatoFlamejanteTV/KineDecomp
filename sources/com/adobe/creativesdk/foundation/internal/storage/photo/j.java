package com.adobe.creativesdk.foundation.internal.storage.photo;

import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.AdobePhotoCollection;
import com.adobe.creativesdk.foundation.storage.AdobePhotoErrorCode;
import com.adobe.creativesdk.foundation.storage.AdobePhotoException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoSession.java */
/* loaded from: classes.dex */
public class j implements ra.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobePhotoCollection f6696a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f6697b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f6698c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ F f6699d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(F f2, AdobePhotoCollection adobePhotoCollection, c.a.a.a.b bVar, c.a.a.a.c cVar) {
        this.f6699d = f2;
        this.f6696a = adobePhotoCollection;
        this.f6697b = bVar;
        this.f6698c = cVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        AdobePhotoException adobePhotoException;
        if (lVar.g() != 204) {
            adobePhotoException = this.f6699d.a(lVar);
        } else {
            try {
                this.f6696a.updateFromData(lVar.d(), this.f6696a.getCatalog());
            } catch (AdobePhotoException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobePhotoSession.updateCollection", e2.getMessage(), e2);
            }
            adobePhotoException = null;
        }
        if (adobePhotoException == null) {
            this.f6697b.b(this.f6696a);
        } else {
            this.f6698c.a(adobePhotoException);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(AdobeNetworkException adobeNetworkException) {
        com.adobe.creativesdk.foundation.internal.net.l a2;
        AdobePhotoException adobePhotoException;
        AdobePhotoException a3;
        a2 = this.f6699d.a(adobeNetworkException);
        if (a2 != null) {
            a3 = this.f6699d.a(a2);
            adobePhotoException = a3;
        } else if (adobeNetworkException.getErrorCode() == AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorNotEntitledToService) {
            adobePhotoException = new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_NOT_ENTITLED_TO_SERVICE, adobeNetworkException.getData(), null);
        } else {
            adobePhotoException = new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_UNEXPECTED_RESPONSE, adobeNetworkException.getData(), null);
        }
        this.f6698c.a(adobePhotoException);
    }
}
