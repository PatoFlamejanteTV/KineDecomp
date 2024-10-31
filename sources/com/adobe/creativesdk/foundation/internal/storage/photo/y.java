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
public class y implements ra.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobePhotoAsset f6762a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f6763b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f6764c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ F f6765d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(F f2, AdobePhotoAsset adobePhotoAsset, c.a.a.a.b bVar, c.a.a.a.c cVar) {
        this.f6765d = f2;
        this.f6762a = adobePhotoAsset;
        this.f6763b = bVar;
        this.f6764c = cVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        AdobePhotoException a2;
        if (lVar.g() != 200) {
            a2 = this.f6765d.a(lVar);
        } else {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "PhotoSession:downloadRendition", String.format("Rendition retrieve for asset %s", this.f6762a.getName()));
            a2 = null;
        }
        if (a2 == null) {
            this.f6763b.b(lVar.c());
        } else {
            this.f6764c.a(a2);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(AdobeNetworkException adobeNetworkException) {
        com.adobe.creativesdk.foundation.internal.net.l a2;
        AdobePhotoException adobePhotoException;
        AdobePhotoException a3;
        a2 = this.f6765d.a(adobeNetworkException);
        if (a2 != null) {
            a3 = this.f6765d.a(a2);
            adobePhotoException = a3;
        } else {
            AdobeNetworkException.AdobeNetworkErrorCode errorCode = adobeNetworkException.getErrorCode();
            AdobeNetworkException.AdobeNetworkErrorCode adobeNetworkErrorCode = AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorCancelled;
            if (errorCode == adobeNetworkErrorCode) {
                this.f6764c.a(new AdobeNetworkException(adobeNetworkErrorCode));
                return;
            } else if (adobeNetworkException.getErrorCode() == AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorNotEntitledToService) {
                adobePhotoException = new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_NOT_ENTITLED_TO_SERVICE, adobeNetworkException.getData(), null);
            } else {
                adobePhotoException = new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_UNEXPECTED_RESPONSE, adobeNetworkException.getData(), null);
            }
        }
        this.f6764c.a(adobePhotoException);
    }
}
