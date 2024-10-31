package com.adobe.creativesdk.foundation.internal.storage.photo;

import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.AdobePhotoCatalog;
import com.adobe.creativesdk.foundation.storage.AdobePhotoCollection;
import com.adobe.creativesdk.foundation.storage.AdobePhotoErrorCode;
import com.adobe.creativesdk.foundation.storage.AdobePhotoException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoSession.java */
/* loaded from: classes.dex */
public class h implements ra.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobePhotoCollection f6687a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobePhotoCatalog f6688b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f6689c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f6690d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ F f6691e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(F f2, AdobePhotoCollection adobePhotoCollection, AdobePhotoCatalog adobePhotoCatalog, c.a.a.a.b bVar, c.a.a.a.c cVar) {
        this.f6691e = f2;
        this.f6687a = adobePhotoCollection;
        this.f6688b = adobePhotoCatalog;
        this.f6689c = bVar;
        this.f6690d = cVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        AdobePhotoException adobePhotoException;
        if (lVar.g() != 201) {
            adobePhotoException = this.f6691e.a(lVar);
        } else {
            try {
                this.f6687a.updateFromData(lVar.d(), this.f6688b);
            } catch (AdobePhotoException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobePhotoSession.createCollection", e2.getMessage(), e2);
            }
            adobePhotoException = null;
        }
        if (adobePhotoException == null) {
            this.f6689c.b(this.f6687a);
        } else {
            this.f6690d.a(adobePhotoException);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(AdobeNetworkException adobeNetworkException) {
        com.adobe.creativesdk.foundation.internal.net.l a2;
        AdobePhotoException adobePhotoException;
        AdobePhotoException a3;
        a2 = this.f6691e.a(adobeNetworkException);
        if (a2 != null) {
            a3 = this.f6691e.a(a2);
            adobePhotoException = a3;
        } else if (adobeNetworkException.getErrorCode() == AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorNotEntitledToService) {
            adobePhotoException = new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_NOT_ENTITLED_TO_SERVICE, adobeNetworkException.getData(), null);
        } else {
            adobePhotoException = new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_UNEXPECTED_RESPONSE, adobeNetworkException.getData(), null);
        }
        this.f6690d.a(adobePhotoException);
    }
}
