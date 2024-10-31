package com.adobe.creativesdk.foundation.internal.storage.photo;

import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.AdobePhotoCollection;
import com.adobe.creativesdk.foundation.storage.AdobePhotoErrorCode;
import com.adobe.creativesdk.foundation.storage.AdobePhotoException;
import com.adobe.creativesdk.foundation.storage.td;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoSession.java */
/* loaded from: classes.dex */
public class p implements ra.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobePhotoCollection f6723a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeCloud f6724b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.net.A f6725c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ td f6726d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f6727e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ F f6728f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(F f2, AdobePhotoCollection adobePhotoCollection, AdobeCloud adobeCloud, com.adobe.creativesdk.foundation.internal.net.A a2, td tdVar, c.a.a.a.c cVar) {
        this.f6728f = f2;
        this.f6723a = adobePhotoCollection;
        this.f6724b = adobeCloud;
        this.f6725c = a2;
        this.f6726d = tdVar;
        this.f6727e = cVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:6:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00f0  */
    /* JADX WARN: Type inference failed for: r10v11, types: [com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException] */
    /* JADX WARN: Type inference failed for: r10v5, types: [com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException] */
    /* JADX WARN: Type inference failed for: r10v8, types: [com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException] */
    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.adobe.creativesdk.foundation.internal.net.l r10) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.internal.storage.photo.p.a(com.adobe.creativesdk.foundation.internal.net.l):void");
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(AdobeNetworkException adobeNetworkException) {
        com.adobe.creativesdk.foundation.internal.net.l a2;
        AdobePhotoException adobePhotoException;
        AdobePhotoException a3;
        a2 = this.f6728f.a(adobeNetworkException);
        if (a2 != null) {
            a3 = this.f6728f.a(a2);
            adobePhotoException = a3;
        } else if (adobeNetworkException.getErrorCode() == AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorNotEntitledToService) {
            adobePhotoException = new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_NOT_ENTITLED_TO_SERVICE, adobeNetworkException.getData(), null);
        } else {
            adobePhotoException = new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_UNEXPECTED_RESPONSE, adobeNetworkException.getData(), null);
        }
        this.f6727e.a(adobePhotoException);
    }
}
