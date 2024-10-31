package com.adobe.creativesdk.foundation.internal.storage.photo;

import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.AdobePhotoCollection;
import com.adobe.creativesdk.foundation.storage.AdobePhotoErrorCode;
import com.adobe.creativesdk.foundation.storage.AdobePhotoException;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoSession.java */
/* loaded from: classes.dex */
public class o implements ra.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobePhotoCollection f6718a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f6719b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ArrayList f6720c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f6721d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ F f6722e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(F f2, AdobePhotoCollection adobePhotoCollection, c.a.a.a.b bVar, ArrayList arrayList, c.a.a.a.c cVar) {
        this.f6722e = f2;
        this.f6718a = adobePhotoCollection;
        this.f6719b = bVar;
        this.f6720c = arrayList;
        this.f6721d = cVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        AdobePhotoException a2;
        if (lVar.g() != 204) {
            a2 = this.f6722e.a(lVar);
        } else {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "PhotoSession:RemoveAssets", String.format("ssets successfully removed from collection %s.", this.f6718a.getName()));
            a2 = null;
        }
        if (a2 == null) {
            this.f6719b.b(this.f6720c);
        } else {
            this.f6721d.a(a2);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(AdobeNetworkException adobeNetworkException) {
        com.adobe.creativesdk.foundation.internal.net.l a2;
        AdobePhotoException adobePhotoException;
        AdobePhotoException a3;
        a2 = this.f6722e.a(adobeNetworkException);
        if (a2 != null) {
            a3 = this.f6722e.a(a2);
            adobePhotoException = a3;
        } else if (adobeNetworkException.getErrorCode() == AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorNotEntitledToService) {
            adobePhotoException = new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_NOT_ENTITLED_TO_SERVICE, adobeNetworkException.getData(), null);
        } else {
            adobePhotoException = new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_UNEXPECTED_RESPONSE, adobeNetworkException.getData(), null);
        }
        this.f6721d.a(adobePhotoException);
    }
}
