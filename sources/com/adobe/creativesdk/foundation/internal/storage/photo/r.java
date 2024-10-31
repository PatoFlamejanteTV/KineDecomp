package com.adobe.creativesdk.foundation.internal.storage.photo;

import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.AdobePhotoErrorCode;
import com.adobe.creativesdk.foundation.storage.AdobePhotoException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoSession.java */
/* loaded from: classes.dex */
public class r implements ra.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f6733a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f6734b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ F f6735c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(F f2, c.a.a.a.b bVar, c.a.a.a.c cVar) {
        this.f6735c = f2;
        this.f6733a = bVar;
        this.f6734b = cVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        AdobePhotoException adobePhotoException;
        JSONObject jSONObject;
        Integer num = null;
        if (lVar.g() != 200) {
            adobePhotoException = this.f6735c.a(lVar);
        } else {
            try {
                jSONObject = c.a.a.a.c.e.b.a(lVar.d());
                adobePhotoException = null;
            } catch (AdobePhotoException e2) {
                adobePhotoException = e2;
                jSONObject = null;
            }
            if (jSONObject != null) {
                try {
                    num = Integer.valueOf(jSONObject.getInt("total_count"));
                } catch (JSONException e3) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e3);
                }
            }
        }
        if (adobePhotoException == null) {
            this.f6733a.b(num);
        } else {
            this.f6734b.a(adobePhotoException);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(AdobeNetworkException adobeNetworkException) {
        com.adobe.creativesdk.foundation.internal.net.l a2;
        AdobePhotoException adobePhotoException;
        AdobePhotoException a3;
        a2 = this.f6735c.a(adobeNetworkException);
        if (a2 != null) {
            a3 = this.f6735c.a(a2);
            adobePhotoException = a3;
        } else if (adobeNetworkException.getErrorCode() == AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorNotEntitledToService) {
            adobePhotoException = new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_NOT_ENTITLED_TO_SERVICE, adobeNetworkException.getData(), null);
        } else {
            adobePhotoException = new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_UNEXPECTED_RESPONSE, adobeNetworkException.getData(), null);
        }
        this.f6734b.a(adobePhotoException);
    }
}
