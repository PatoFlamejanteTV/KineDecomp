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
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.photo.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0519b implements ra.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobePhotoCatalog.AdobePhotoCatalogType f6658a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeCloud f6659b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ArrayList f6660c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ F f6661d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f6662e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f6663f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ F f6664g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0519b(F f2, AdobePhotoCatalog.AdobePhotoCatalogType adobePhotoCatalogType, AdobeCloud adobeCloud, ArrayList arrayList, F f3, c.a.a.a.c cVar, c.a.a.a.b bVar) {
        this.f6664g = f2;
        this.f6658a = adobePhotoCatalogType;
        this.f6659b = adobeCloud;
        this.f6660c = arrayList;
        this.f6661d = f3;
        this.f6662e = cVar;
        this.f6663f = bVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        AdobePhotoException a2;
        JSONObject jSONObject;
        boolean z;
        if (lVar.g() != 200) {
            a2 = this.f6664g.a(lVar);
        } else {
            try {
                jSONObject = c.a.a.a.c.e.b.a(lVar.d());
                a2 = null;
            } catch (AdobePhotoException e2) {
                a2 = e2;
                jSONObject = null;
            }
            if (jSONObject != null) {
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray("catalogs");
                    if (jSONArray.length() == 0 && this.f6658a == AdobePhotoCatalog.AdobePhotoCatalogType.AdobePhotoCatalogTypeLightroom) {
                        this.f6660c.add(new AdobePhotoCatalog("lightroom", null, this.f6659b, AdobePhotoCatalog.AdobePhotoCatalogType.AdobePhotoCatalogTypeLightroom));
                    } else {
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            if (jSONObject2 != null) {
                                AdobePhotoCatalog adobePhotoCatalog = new AdobePhotoCatalog(null, null, this.f6659b);
                                if (this.f6661d.e() != null && this.f6661d.e().d() != null) {
                                    adobePhotoCatalog.setHref(this.f6661d.e().d().toString());
                                    try {
                                        z = adobePhotoCatalog.updateFromDictionary(jSONObject2);
                                    } catch (AdobePhotoException e3) {
                                        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobePhotoSession.listCatalogsOfType", e3.getMessage(), e3);
                                        z = false;
                                    }
                                    if (z) {
                                        this.f6660c.add(adobePhotoCatalog);
                                    }
                                }
                                this.f6662e.a(new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_UNEXPECTED_RESPONSE));
                                return;
                            }
                        }
                    }
                } catch (JSONException e4) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobePhotoSession.listCatalogsOfType", e4.getMessage(), e4);
                }
            } else if (jSONObject == null) {
                a2 = new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_MISSING_JSON_DATA);
            }
        }
        if (a2 == null) {
            this.f6663f.b(this.f6660c);
        } else {
            this.f6662e.a(a2);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(AdobeNetworkException adobeNetworkException) {
        com.adobe.creativesdk.foundation.internal.net.l a2;
        AdobePhotoException adobePhotoException;
        AdobePhotoException a3;
        a2 = this.f6664g.a(adobeNetworkException);
        if (a2 != null) {
            a3 = this.f6664g.a(a2);
            adobePhotoException = a3;
        } else if (adobeNetworkException.getErrorCode() == AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorNotEntitledToService) {
            adobePhotoException = new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_NOT_ENTITLED_TO_SERVICE, adobeNetworkException.getData(), null);
        } else {
            adobePhotoException = new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_UNEXPECTED_RESPONSE, adobeNetworkException.getData(), null);
        }
        this.f6662e.a(adobePhotoException);
    }
}
