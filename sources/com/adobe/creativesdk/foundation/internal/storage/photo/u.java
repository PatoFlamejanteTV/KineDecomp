package com.adobe.creativesdk.foundation.internal.storage.photo;

import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.AdobePhotoAsset;
import com.adobe.creativesdk.foundation.storage.AdobePhotoErrorCode;
import com.adobe.creativesdk.foundation.storage.AdobePhotoException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoSession.java */
/* loaded from: classes.dex */
public class u implements ra.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobePhotoAsset f6746a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f6747b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f6748c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ F f6749d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(F f2, AdobePhotoAsset adobePhotoAsset, c.a.a.a.b bVar, c.a.a.a.c cVar) {
        this.f6749d = f2;
        this.f6746a = adobePhotoAsset;
        this.f6747b = bVar;
        this.f6748c = cVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        AdobePhotoException a2;
        if (lVar.g() != 204) {
            a2 = this.f6749d.a(lVar);
        } else {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "PhotoSession:DeleteAsset", String.format("Asset %s deleted", this.f6746a.getName()));
            a2 = null;
        }
        if (a2 == null) {
            this.f6747b.b(this.f6746a);
        } else {
            this.f6748c.a(a2);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(AdobeNetworkException adobeNetworkException) {
        com.adobe.creativesdk.foundation.internal.net.l a2;
        AdobePhotoException adobePhotoException;
        AdobePhotoException a3;
        a2 = this.f6749d.a(adobeNetworkException);
        if (a2 != null) {
            a3 = this.f6749d.a(a2);
            adobePhotoException = a3;
        } else if (adobeNetworkException.getErrorCode() == AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorNotEntitledToService) {
            adobePhotoException = new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_NOT_ENTITLED_TO_SERVICE, adobeNetworkException.getData(), null);
        } else {
            adobePhotoException = new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_UNEXPECTED_RESPONSE, adobeNetworkException.getData(), null);
        }
        this.f6748c.a(adobePhotoException);
    }
}
