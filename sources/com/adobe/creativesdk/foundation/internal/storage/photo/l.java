package com.adobe.creativesdk.foundation.internal.storage.photo;

import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.AdobePhotoCollection;
import com.adobe.creativesdk.foundation.storage.AdobePhotoErrorCode;
import com.adobe.creativesdk.foundation.storage.AdobePhotoException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoSession.java */
/* loaded from: classes.dex */
public class l implements ra.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobePhotoCollection f6704a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f6705b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f6706c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ F f6707d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(F f2, AdobePhotoCollection adobePhotoCollection, c.a.a.a.b bVar, c.a.a.a.c cVar) {
        this.f6707d = f2;
        this.f6704a = adobePhotoCollection;
        this.f6705b = bVar;
        this.f6706c = cVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0033  */
    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.adobe.creativesdk.foundation.internal.net.l r3) {
        /*
            r2 = this;
            int r0 = r3.g()
            r1 = 200(0xc8, float:2.8E-43)
            if (r0 != r1) goto L1e
            java.lang.String r3 = r3.d()     // Catch: com.adobe.creativesdk.foundation.storage.AdobePhotoException -> L1c
            org.json.JSONObject r3 = c.a.a.a.c.e.b.a(r3)     // Catch: com.adobe.creativesdk.foundation.storage.AdobePhotoException -> L1c
            com.adobe.creativesdk.foundation.storage.AdobePhotoCollection r0 = r2.f6704a     // Catch: com.adobe.creativesdk.foundation.storage.AdobePhotoException -> L1c
            com.adobe.creativesdk.foundation.storage.AdobePhotoCollection r1 = r2.f6704a     // Catch: com.adobe.creativesdk.foundation.storage.AdobePhotoException -> L1c
            com.adobe.creativesdk.foundation.storage.AdobePhotoCatalog r1 = r1.getCatalog()     // Catch: com.adobe.creativesdk.foundation.storage.AdobePhotoException -> L1c
            r0.updateFromDictionary(r3, r1)     // Catch: com.adobe.creativesdk.foundation.storage.AdobePhotoException -> L1c
            goto L29
        L1c:
            r3 = move-exception
            goto L31
        L1e:
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 != r1) goto L2b
            c.a.a.a.b r3 = r2.f6705b
            com.adobe.creativesdk.foundation.storage.AdobePhotoCollection r0 = r2.f6704a
            r3.b(r0)
        L29:
            r3 = 0
            goto L31
        L2b:
            com.adobe.creativesdk.foundation.internal.storage.photo.F r0 = r2.f6707d
            com.adobe.creativesdk.foundation.storage.AdobePhotoException r3 = com.adobe.creativesdk.foundation.internal.storage.photo.F.a(r0, r3)
        L31:
            if (r3 != 0) goto L3b
            c.a.a.a.b r3 = r2.f6705b
            com.adobe.creativesdk.foundation.storage.AdobePhotoCollection r0 = r2.f6704a
            r3.b(r0)
            goto L40
        L3b:
            c.a.a.a.c r0 = r2.f6706c
            r0.a(r3)
        L40:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.internal.storage.photo.l.a(com.adobe.creativesdk.foundation.internal.net.l):void");
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(AdobeNetworkException adobeNetworkException) {
        com.adobe.creativesdk.foundation.internal.net.l a2;
        AdobePhotoException adobePhotoException;
        AdobePhotoException a3;
        a2 = this.f6707d.a(adobeNetworkException);
        if (a2 != null) {
            a3 = this.f6707d.a(a2);
            adobePhotoException = a3;
        } else if (adobeNetworkException.getErrorCode() == AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorNotEntitledToService) {
            adobePhotoException = new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_NOT_ENTITLED_TO_SERVICE, adobeNetworkException.getData(), null);
        } else {
            adobePhotoException = new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_UNEXPECTED_RESPONSE, adobeNetworkException.getData(), null);
        }
        this.f6706c.a(adobePhotoException);
    }
}
