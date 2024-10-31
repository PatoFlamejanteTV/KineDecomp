package com.adobe.creativesdk.foundation.internal.storage.photo;

import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.AdobePhotoCatalog;
import com.adobe.creativesdk.foundation.storage.AdobePhotoErrorCode;
import com.adobe.creativesdk.foundation.storage.AdobePhotoException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoSession.java */
/* loaded from: classes.dex */
public class z implements ra.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobePhotoCatalog f6766a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f6767b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f6768c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ F f6769d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(F f2, AdobePhotoCatalog adobePhotoCatalog, c.a.a.a.b bVar, c.a.a.a.c cVar) {
        this.f6769d = f2;
        this.f6766a = adobePhotoCatalog;
        this.f6767b = bVar;
        this.f6768c = cVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        AdobePhotoException a2;
        if (lVar.g() != 204) {
            a2 = this.f6769d.a(lVar);
        } else {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "PhotoSession:DeleteCatalog", String.format("Catalog %s deleted", this.f6766a.getName()));
            a2 = null;
        }
        if (a2 == null) {
            this.f6767b.b(this.f6766a);
        } else {
            this.f6768c.a(a2);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(AdobeNetworkException adobeNetworkException) {
        com.adobe.creativesdk.foundation.internal.net.l a2;
        AdobePhotoException adobePhotoException;
        AdobePhotoException a3;
        a2 = this.f6769d.a(adobeNetworkException);
        if (a2 != null) {
            a3 = this.f6769d.a(a2);
            adobePhotoException = a3;
        } else if (adobeNetworkException.getErrorCode() == AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorNotEntitledToService) {
            adobePhotoException = new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_NOT_ENTITLED_TO_SERVICE, adobeNetworkException.getData(), null);
        } else {
            adobePhotoException = new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_UNEXPECTED_RESPONSE, adobeNetworkException.getData(), null);
        }
        this.f6768c.a(adobePhotoException);
    }
}
