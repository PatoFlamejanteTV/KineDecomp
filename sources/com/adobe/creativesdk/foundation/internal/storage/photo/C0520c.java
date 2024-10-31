package com.adobe.creativesdk.foundation.internal.storage.photo;

import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.AdobePhotoCatalog;
import com.adobe.creativesdk.foundation.storage.AdobePhotoErrorCode;
import com.adobe.creativesdk.foundation.storage.AdobePhotoException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoSession.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.photo.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0520c implements ra.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeCloud f6665a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.net.A f6666b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AdobePhotoCatalog f6667c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f6668d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f6669e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ F f6670f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0520c(F f2, AdobeCloud adobeCloud, com.adobe.creativesdk.foundation.internal.net.A a2, AdobePhotoCatalog adobePhotoCatalog, c.a.a.a.b bVar, c.a.a.a.c cVar) {
        this.f6670f = f2;
        this.f6665a = adobeCloud;
        this.f6666b = a2;
        this.f6667c = adobePhotoCatalog;
        this.f6668d = bVar;
        this.f6669e = cVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        JSONObject jSONObject;
        boolean z;
        ArrayList arrayList = new ArrayList();
        int g2 = lVar.g();
        AdobePhotoException adobePhotoException = null;
        if (g2 == 200) {
            try {
                jSONObject = c.a.a.a.c.e.b.a(lVar.d());
            } catch (AdobePhotoException e2) {
                adobePhotoException = e2;
                jSONObject = null;
            }
            if (jSONObject != null) {
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray("albums");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            AdobePhotoCollectionInternal adobePhotoCollectionInternal = new AdobePhotoCollectionInternal();
                            adobePhotoCollectionInternal.setCloud(this.f6665a);
                            adobePhotoCollectionInternal.setBaseHref(this.f6666b.d().toString());
                            try {
                                z = adobePhotoCollectionInternal.updateFromDictionary(jSONObject2, this.f6667c);
                            } catch (AdobePhotoException e3) {
                                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobePhotoSession.listCollectionsInCatalog", e3.getMessage(), e3);
                                z = false;
                            }
                            if (z) {
                                arrayList.add(adobePhotoCollectionInternal);
                            }
                        }
                    }
                } catch (JSONException e4) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e4);
                }
            }
        } else if (this.f6667c.getType() != AdobePhotoCatalog.AdobePhotoCatalogType.AdobePhotoCatalogTypeLightroom || this.f6667c.isInSync() || g2 != 404) {
            adobePhotoException = this.f6670f.a(lVar);
        }
        if (adobePhotoException == null) {
            this.f6668d.b(arrayList);
        } else {
            this.f6669e.a(adobePhotoException);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(AdobeNetworkException adobeNetworkException) {
        com.adobe.creativesdk.foundation.internal.net.l a2;
        AdobePhotoException adobePhotoException;
        AdobePhotoException a3;
        a2 = this.f6670f.a(adobeNetworkException);
        if (a2 != null) {
            a3 = this.f6670f.a(a2);
            adobePhotoException = a3;
        } else if (adobeNetworkException.getErrorCode() == AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorNotEntitledToService) {
            adobePhotoException = new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_NOT_ENTITLED_TO_SERVICE, adobeNetworkException.getData(), null);
        } else {
            adobePhotoException = new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_UNEXPECTED_RESPONSE, adobeNetworkException.getData(), null);
        }
        this.f6669e.a(adobePhotoException);
    }
}
