package com.adobe.creativesdk.foundation.internal.storage.photo;

import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.AdobePhotoCollection;
import com.adobe.creativesdk.foundation.storage.AdobePhotoErrorCode;
import com.adobe.creativesdk.foundation.storage.AdobePhotoException;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoSession.java */
/* loaded from: classes.dex */
public class n implements ra.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ArrayList f6712a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f6713b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AdobePhotoCollection f6714c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f6715d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f6716e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ F f6717f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(F f2, ArrayList arrayList, String str, AdobePhotoCollection adobePhotoCollection, c.a.a.a.b bVar, c.a.a.a.c cVar) {
        this.f6717f = f2;
        this.f6712a = arrayList;
        this.f6713b = str;
        this.f6714c = adobePhotoCollection;
        this.f6715d = bVar;
        this.f6716e = cVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x010e  */
    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.adobe.creativesdk.foundation.internal.net.l r15) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.internal.storage.photo.n.a(com.adobe.creativesdk.foundation.internal.net.l):void");
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(AdobeNetworkException adobeNetworkException) {
        com.adobe.creativesdk.foundation.internal.net.l a2;
        AdobePhotoException adobePhotoException;
        AdobePhotoException a3;
        a2 = this.f6717f.a(adobeNetworkException);
        if (a2 != null) {
            a3 = this.f6717f.a(a2);
            adobePhotoException = a3;
        } else if (adobeNetworkException.getErrorCode() == AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorNotEntitledToService) {
            adobePhotoException = new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_NOT_ENTITLED_TO_SERVICE, adobeNetworkException.getData(), null);
        } else {
            adobePhotoException = new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_UNEXPECTED_RESPONSE, adobeNetworkException.getData(), null);
        }
        this.f6716e.a(adobePhotoException);
    }
}
