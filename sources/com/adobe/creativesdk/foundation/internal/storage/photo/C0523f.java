package com.adobe.creativesdk.foundation.internal.storage.photo;

import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.AdobePhotoCatalog;
import com.adobe.creativesdk.foundation.storage.AdobePhotoErrorCode;
import com.adobe.creativesdk.foundation.storage.AdobePhotoException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoSession.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.photo.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0523f implements ra.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobePhotoCatalog f6679a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f6680b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f6681c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ F f6682d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0523f(F f2, AdobePhotoCatalog adobePhotoCatalog, c.a.a.a.b bVar, c.a.a.a.c cVar) {
        this.f6682d = f2;
        this.f6679a = adobePhotoCatalog;
        this.f6680b = bVar;
        this.f6681c = cVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        AdobePhotoException adobePhotoException;
        JSONObject jSONObject;
        AdobePhotoException adobePhotoException2;
        int g2 = lVar.g();
        Integer num = null;
        if (g2 == 200) {
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
            adobePhotoException2 = adobePhotoException;
        } else {
            adobePhotoException2 = (this.f6679a.getType() == AdobePhotoCatalog.AdobePhotoCatalogType.AdobePhotoCatalogTypeLightroom && !this.f6679a.isInSync() && g2 == 404) ? null : this.f6682d.a(lVar);
        }
        if (adobePhotoException2 == null) {
            this.f6680b.b(num);
        } else {
            this.f6681c.a(adobePhotoException2);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(AdobeNetworkException adobeNetworkException) {
        com.adobe.creativesdk.foundation.internal.net.l a2;
        AdobePhotoException adobePhotoException;
        AdobePhotoException a3;
        a2 = this.f6682d.a(adobeNetworkException);
        if (a2 != null) {
            a3 = this.f6682d.a(a2);
            adobePhotoException = a3;
        } else if (adobeNetworkException.getErrorCode() == AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorNotEntitledToService) {
            adobePhotoException = new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_NOT_ENTITLED_TO_SERVICE, adobeNetworkException.getData(), null);
        } else {
            adobePhotoException = new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_UNEXPECTED_RESPONSE, adobeNetworkException.getData(), null);
        }
        this.f6681c.a(adobePhotoException);
    }
}
