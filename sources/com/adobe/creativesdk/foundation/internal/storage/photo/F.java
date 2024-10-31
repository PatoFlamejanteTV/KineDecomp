package com.adobe.creativesdk.foundation.internal.storage.photo;

import android.os.Handler;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloudEndpoint;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloudServiceType;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeEntitlementServices;
import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIdentityManagementService;
import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthKeychain;
import com.adobe.creativesdk.foundation.internal.cache.AdobeCommonCachePolicies;
import com.adobe.creativesdk.foundation.internal.cache.AdobeInvalidCacheSettingsException;
import com.adobe.creativesdk.foundation.internal.net.AdobeNetworkHttpRequestMethod;
import com.adobe.creativesdk.foundation.internal.net.AdobeNetworkRequestPriority;
import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.AdobePhoto;
import com.adobe.creativesdk.foundation.storage.AdobePhotoAsset;
import com.adobe.creativesdk.foundation.storage.AdobePhotoAssetRendition;
import com.adobe.creativesdk.foundation.storage.AdobePhotoAssetRevision;
import com.adobe.creativesdk.foundation.storage.AdobePhotoCatalog;
import com.adobe.creativesdk.foundation.storage.AdobePhotoCollection;
import com.adobe.creativesdk.foundation.storage.AdobePhotoErrorCode;
import com.adobe.creativesdk.foundation.storage.AdobePhotoException;
import com.adobe.creativesdk.foundation.storage.AdobePhotoPage;
import com.facebook.places.model.PlaceFields;
import com.facebook.stetho.server.http.HttpHeaders;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdobePhotoSession.java */
/* loaded from: classes.dex */
public class F extends com.adobe.creativesdk.foundation.adobeinternal.cloud.g {
    private static final Map<com.adobe.creativesdk.foundation.internal.net.j, com.adobe.creativesdk.foundation.internal.net.E> j = new HashMap();
    protected boolean k;

    public F(AdobeCloudEndpoint adobeCloudEndpoint) {
        super(adobeCloudEndpoint);
        g();
        a(AdobeInternalNotificationID.AdobePhotoServiceDisconnectedNotification);
        a(15L, false);
    }

    public static com.adobe.creativesdk.foundation.adobeinternal.cloud.g b(AdobeCloudEndpoint adobeCloudEndpoint) {
        if (adobeCloudEndpoint == null) {
            adobeCloudEndpoint = l();
        }
        return new F(adobeCloudEndpoint);
    }

    private String d(String str) {
        if (str == null) {
            return null;
        }
        return str;
    }

    protected static AdobeCloudEndpoint l() {
        String str;
        int i = E.f6651a[AdobeAuthIdentityManagementService.K().w().ordinal()];
        if (i == 1) {
            str = "https://photo-api.adobe.io";
        } else if (i == 2 || i == 3) {
            str = "https://photo-api-stage.adobe.io";
        } else {
            if (i != 4) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, F.class.getSimpleName(), "An undefined authentication endpoint has been specified.");
                return null;
            }
            str = "https://photo-api-next.adobe.io";
        }
        try {
            return new AdobeCloudEndpoint(null, new URL(str), AdobeCloudServiceType.AdobeCloudServiceTypePhoto);
        } catch (MalformedURLException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e2);
            return null;
        }
    }

    private AdobeNetworkException n() {
        AdobeEntitlementServices b2 = AdobeEntitlementServices.b();
        if (b2.a() == null || b2.a().optJSONObject("lightroom") == null || b2.a().optJSONObject("lightroom").optBoolean("entitled")) {
            return null;
        }
        return new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorNotEntitledToService);
    }

    public com.adobe.creativesdk.foundation.internal.net.E c(AdobePhotoCatalog adobePhotoCatalog, c.a.a.a.b<AdobePhotoCatalog> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        return a(a((AdobePhoto) adobePhotoCatalog, AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodGET, false), (String) null, (byte[]) null, new C0518a(this, adobePhotoCatalog, bVar, cVar));
    }

    public com.adobe.creativesdk.foundation.internal.net.E d(AdobePhotoCatalog adobePhotoCatalog, c.a.a.a.b<Integer> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        com.adobe.creativesdk.foundation.internal.net.A e2 = e();
        if (e2 == null) {
            if (cVar != null) {
                cVar.a(new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorNoCloudSpecified));
            } else {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, ra.class.getSimpleName(), "Adobe cloud not specified.");
            }
            return null;
        }
        try {
            URL url = new URI(com.adobe.creativesdk.foundation.internal.storage.model.util.g.a(String.format("%s/albums/count", adobePhotoCatalog.getHref()), e2.d().toString())).toURL();
            com.adobe.creativesdk.foundation.internal.net.j jVar = new com.adobe.creativesdk.foundation.internal.net.j();
            jVar.a(url);
            jVar.a(AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodGET);
            return a(jVar, (String) null, (byte[]) null, new C0523f(this, adobePhotoCatalog, bVar, cVar));
        } catch (MalformedURLException e3) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e3);
            return null;
        } catch (URISyntaxException e4) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e4);
            return null;
        }
    }

    public com.adobe.creativesdk.foundation.internal.net.E e(AdobePhotoCatalog adobePhotoCatalog, c.a.a.a.b<AdobePhotoCatalog> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        com.adobe.creativesdk.foundation.internal.net.j a2 = a((AdobePhoto) adobePhotoCatalog, AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodPOST, false);
        a2.b(HttpHeaders.CONTENT_TYPE, io.fabric.sdk.android.services.common.a.ACCEPT_JSON_VALUE);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", d(adobePhotoCatalog.getName()));
        } catch (JSONException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobePhotoSession.updateCatalog", e2.getMessage(), e2);
        }
        return a(a2, (String) null, jSONObject.toString().getBytes(org.apache.commons.io.a.f29306f), new q(this, adobePhotoCatalog, bVar, cVar));
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.cloud.g
    public void g() {
        String c2 = AdobeAuthKeychain.r().c();
        if (m() || c2 == null || c2.length() <= 0) {
            return;
        }
        try {
            com.adobe.creativesdk.foundation.internal.cache.d.b().a("com.adobe.cc.photo", 100, 1.34217728E8d, EnumSet.of(AdobeCommonCachePolicies.AdobeCommonCacheEvictionLRU));
            e = null;
        } catch (AdobeInvalidCacheSettingsException e2) {
            e = e2;
        }
        if (e == null) {
            this.k = true;
        } else {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, ra.class.getSimpleName(), (String) null);
        }
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.cloud.g
    public void i() {
        super.i();
        if (com.adobe.creativesdk.foundation.internal.cache.d.b().a("com.adobe.cc.photo")) {
            com.adobe.creativesdk.foundation.internal.cache.d.b().b("com.adobe.cc.photo");
            if (!com.adobe.creativesdk.foundation.internal.cache.d.b().c("com.adobe.cc.photo")) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, ra.class.getSimpleName(), "Removal of cache failed");
            }
        }
        this.k = false;
    }

    protected boolean m() {
        return this.k;
    }

    public com.adobe.creativesdk.foundation.internal.net.E b(AdobePhotoCatalog adobePhotoCatalog, c.a.a.a.b<Integer> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        com.adobe.creativesdk.foundation.internal.net.A e2 = e();
        if (e2 == null) {
            if (cVar != null) {
                cVar.a(new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorNoCloudSpecified));
            } else {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, ra.class.getSimpleName(), "Adobe cloud not specified.");
            }
            return null;
        }
        try {
            URL url = new URI(com.adobe.creativesdk.foundation.internal.storage.model.util.g.a(String.format("%s/assets/count", adobePhotoCatalog.getHref()), e2.d().toString())).toURL();
            com.adobe.creativesdk.foundation.internal.net.j jVar = new com.adobe.creativesdk.foundation.internal.net.j();
            jVar.a(url);
            jVar.a(AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodGET);
            return a(jVar, (String) null, (byte[]) null, new g(this, adobePhotoCatalog, bVar, cVar));
        } catch (MalformedURLException e3) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e3);
            return null;
        } catch (URISyntaxException e4) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e4);
            return null;
        }
    }

    public com.adobe.creativesdk.foundation.internal.net.E a(AdobePhotoCatalog adobePhotoCatalog, AdobePhotoCatalog.AdobePhotoCatalogType adobePhotoCatalogType, c.a.a.a.b<AdobePhotoCatalog> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        com.adobe.creativesdk.foundation.internal.net.j a2 = a((AdobePhoto) adobePhotoCatalog, AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodPUT, true);
        String str = adobePhotoCatalogType == AdobePhotoCatalog.AdobePhotoCatalogType.AdobePhotoCatalogTypeLightroom ? "lightroom" : "";
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", d(adobePhotoCatalog.getName()));
            jSONObject.put("subtype", str);
        } catch (JSONException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e2);
        }
        return a(a2, (String) null, jSONObject.toString().getBytes(org.apache.commons.io.a.f29306f), new C0521d(this, adobePhotoCatalog, bVar, cVar));
    }

    public com.adobe.creativesdk.foundation.internal.net.E c(AdobePhotoCollection adobePhotoCollection, c.a.a.a.b<AdobePhotoCollection> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        return a(a((AdobePhoto) adobePhotoCollection, AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodGET, false), (String) null, (byte[]) null, new l(this, adobePhotoCollection, bVar, cVar));
    }

    public com.adobe.creativesdk.foundation.internal.net.E c(ArrayList<AdobePhotoAsset> arrayList, AdobePhotoCollection adobePhotoCollection, c.a.a.a.b<ArrayList<AdobePhotoAsset>> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        return a(arrayList, adobePhotoCollection, AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodPOST, bVar, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AdobePhotoPage e(String str) throws AdobeCSDKException {
        if (str != null) {
            Matcher matcher = Pattern.compile("((captured|updated|order)_(before|after|since))=([a-zA-Z_0-9-:.%]+)", 2).matcher(str);
            if (matcher.find()) {
                return new AdobePhotoPage(str.substring(matcher.start(), matcher.end()));
            }
            throw new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_UNEXPECTED_RESPONSE);
        }
        throw new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_UNEXPECTED_RESPONSE);
    }

    public com.adobe.creativesdk.foundation.internal.net.E c(AdobePhotoAsset adobePhotoAsset, c.a.a.a.b<AdobePhotoAsset> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        return a(adobePhotoAsset, (AdobePhotoAssetRevision) null, bVar, cVar);
    }

    public AdobePhotoCatalog a(AdobePhotoCatalog adobePhotoCatalog, AdobePhotoCatalog.AdobePhotoCatalogType adobePhotoCatalogType) throws AdobeCSDKException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition newCondition = reentrantLock.newCondition();
        C0522e c0522e = new C0522e(this);
        i iVar = new i(this, reentrantLock, c0522e, newCondition);
        m mVar = new m(this, reentrantLock, c0522e, newCondition);
        reentrantLock.lock();
        a(adobePhotoCatalog, adobePhotoCatalogType, iVar, mVar);
        while (!c0522e.f6675a) {
            try {
                newCondition.await();
            } catch (InterruptedException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobePhotoSession.createCatalog", e2.getMessage());
            }
        }
        AdobeCSDKException adobeCSDKException = c0522e.f6677c;
        if (adobeCSDKException == null) {
            return c0522e.f6676b;
        }
        throw adobeCSDKException;
    }

    public com.adobe.creativesdk.foundation.internal.net.E d(AdobePhotoCollection adobePhotoCollection, c.a.a.a.b<AdobePhotoCollection> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        com.adobe.creativesdk.foundation.internal.net.j a2 = a((AdobePhoto) adobePhotoCollection, AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodPOST, false);
        a2.b(HttpHeaders.CONTENT_TYPE, io.fabric.sdk.android.services.common.a.ACCEPT_JSON_VALUE);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", d(adobePhotoCollection.getName()));
            if (adobePhotoCollection.getCoverAsset() != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("_id", adobePhotoCollection.getCoverAsset().getGUID());
                jSONObject.put(PlaceFields.COVER, jSONObject2);
            }
            return a(a2, (String) null, jSONObject.toString().getBytes(org.apache.commons.io.a.f29306f), new j(this, adobePhotoCollection, bVar, cVar));
        } catch (JSONException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e2);
            return null;
        }
    }

    public com.adobe.creativesdk.foundation.internal.net.E b(ArrayList<AdobePhotoAsset> arrayList, AdobePhotoCollection adobePhotoCollection, c.a.a.a.b<ArrayList<AdobePhotoAsset>> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        if (arrayList.size() > 100) {
            AdobeNetworkException adobeNetworkException = new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorBadRequest);
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "PhotoSession:RemoveAssets", "Too many assets specified to remove at one time. Limited to 100.");
            cVar.a(adobeNetworkException);
            return null;
        }
        com.adobe.creativesdk.foundation.internal.net.A e2 = e();
        if (e2 == null) {
            if (cVar != null) {
                cVar.a(new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorNoCloudSpecified));
            } else {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, ra.class.getSimpleName(), "Adobe cloud not specified.");
            }
            return null;
        }
        String str = "";
        for (int i = 0; i < arrayList.size(); i++) {
            AdobePhotoAsset adobePhotoAsset = arrayList.get(i);
            if (adobePhotoAsset != null) {
                str = i == 0 ? adobePhotoAsset.getGUID() : str + String.format("%%3B%s", adobePhotoAsset.getGUID());
            }
        }
        try {
            URL url = new URI(com.adobe.creativesdk.foundation.internal.storage.model.util.g.a(String.format("%s/assets?asset_ids=%s", adobePhotoCollection.getHref(), str), e2.d().toString())).toURL();
            com.adobe.creativesdk.foundation.internal.net.j jVar = new com.adobe.creativesdk.foundation.internal.net.j();
            jVar.a(url);
            jVar.a(AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodDELETE);
            return a(jVar, (String) null, (byte[]) null, new o(this, adobePhotoCollection, bVar, arrayList, cVar));
        } catch (MalformedURLException e3) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e3);
            return null;
        } catch (URISyntaxException e4) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e4);
            return null;
        }
    }

    public com.adobe.creativesdk.foundation.internal.net.E a(AdobePhotoCatalog adobePhotoCatalog, c.a.a.a.b<AdobePhotoCatalog> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        com.adobe.creativesdk.foundation.internal.net.j a2 = a((AdobePhoto) adobePhotoCatalog, AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodDELETE, false);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", d(adobePhotoCatalog.getName()));
        } catch (JSONException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e2);
        }
        return a(a2, (String) null, jSONObject.toString().getBytes(org.apache.commons.io.a.f29306f), new z(this, adobePhotoCatalog, bVar, cVar));
    }

    public com.adobe.creativesdk.foundation.internal.net.E a(AdobePhotoCatalog.AdobePhotoCatalogType adobePhotoCatalogType, AdobeCloud adobeCloud, c.a.a.a.b<ArrayList<AdobePhotoCatalog>> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        com.adobe.creativesdk.foundation.internal.net.j jVar;
        String str = adobePhotoCatalogType == AdobePhotoCatalog.AdobePhotoCatalogType.AdobePhotoCatalogTypeLightroom ? "lightroom%3BX-lightroom" : "all";
        if (e() == null) {
            return null;
        }
        try {
            URL url = new URI(com.adobe.creativesdk.foundation.internal.storage.model.util.g.a(String.format("/v1.0/catalogs?%s", String.format("subtype=%s", str)), e().d().toString())).toURL();
            jVar = new com.adobe.creativesdk.foundation.internal.net.j();
            jVar.a(url);
            jVar.a(AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodGET);
        } catch (MalformedURLException e2) {
            e = e2;
        } catch (URISyntaxException e3) {
            e = e3;
        }
        try {
            return a(jVar, (String) null, (byte[]) null, new C0519b(this, adobePhotoCatalogType, adobeCloud, new ArrayList(), this, cVar, bVar));
        } catch (MalformedURLException e4) {
            e = e4;
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e);
            return null;
        } catch (URISyntaxException e5) {
            e = e5;
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e);
            return null;
        }
    }

    public com.adobe.creativesdk.foundation.internal.net.E b(AdobePhotoCollection adobePhotoCollection, c.a.a.a.b<Integer> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        com.adobe.creativesdk.foundation.internal.net.A e2 = e();
        if (e2 == null) {
            if (cVar != null) {
                cVar.a(new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorNoCloudSpecified));
            } else {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, ra.class.getSimpleName(), "Adobe cloud not specified.");
            }
            return null;
        }
        try {
            URL url = new URI(com.adobe.creativesdk.foundation.internal.storage.model.util.g.a(String.format("%s/assets/count", adobePhotoCollection.getHref()), e2.d().toString())).toURL();
            com.adobe.creativesdk.foundation.internal.net.j jVar = new com.adobe.creativesdk.foundation.internal.net.j();
            jVar.a(url);
            jVar.a(AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodGET);
            return a(jVar, (String) null, (byte[]) null, new r(this, bVar, cVar));
        } catch (MalformedURLException e3) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e3);
            return null;
        } catch (URISyntaxException e4) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e4);
            return null;
        }
    }

    public com.adobe.creativesdk.foundation.internal.net.E a(AdobePhotoCatalog adobePhotoCatalog, AdobeCloud adobeCloud, c.a.a.a.b<ArrayList<AdobePhotoCollection>> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        com.adobe.creativesdk.foundation.internal.net.A e2 = e();
        if (e2 == null) {
            if (cVar != null) {
                cVar.a(new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorNoCloudSpecified));
            } else {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, ra.class.getSimpleName(), "Adobe cloud not specified.");
            }
            return null;
        }
        try {
            URL url = new URI(com.adobe.creativesdk.foundation.internal.storage.model.util.g.a(String.format("%s/albums", adobePhotoCatalog.getHref()), e2.d().toString())).toURL();
            com.adobe.creativesdk.foundation.internal.net.j jVar = new com.adobe.creativesdk.foundation.internal.net.j();
            jVar.a(url);
            jVar.a(AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodGET);
            return a(jVar, (String) null, (byte[]) null, new C0520c(this, adobeCloud, e2, adobePhotoCatalog, bVar, cVar));
        } catch (MalformedURLException e3) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e3);
            return null;
        } catch (URISyntaxException e4) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e4);
            return null;
        }
    }

    public com.adobe.creativesdk.foundation.internal.net.E b(AdobePhotoAsset adobePhotoAsset, c.a.a.a.b<byte[]> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        com.adobe.creativesdk.foundation.internal.net.A e2 = e();
        if (e2 == null) {
            if (cVar != null) {
                cVar.a(new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorNoCloudSpecified));
            } else {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, ra.class.getSimpleName(), "Adobe cloud not specified.");
            }
            return null;
        }
        try {
            URL url = new URI(com.adobe.creativesdk.foundation.internal.storage.model.util.g.a(String.format("%s/revisions/%s/master", adobePhotoAsset.getHref(), adobePhotoAsset.getRevision().getGUID()), e2.d().toString())).toURL();
            com.adobe.creativesdk.foundation.internal.net.j jVar = new com.adobe.creativesdk.foundation.internal.net.j();
            jVar.a(url);
            jVar.a(AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodGET);
            return a(jVar, (String) null, (byte[]) null, new w(this, adobePhotoAsset, bVar, cVar));
        } catch (MalformedURLException e3) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e3);
            return null;
        } catch (URISyntaxException e4) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e4);
            return null;
        }
    }

    public com.adobe.creativesdk.foundation.internal.net.E a(AdobePhotoCollection adobePhotoCollection, AdobePhotoCatalog adobePhotoCatalog, c.a.a.a.b<AdobePhotoCollection> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        if (adobePhotoCatalog == null) {
            cVar.a(new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorBadRequest));
            return null;
        }
        if (adobePhotoCatalog.getType() == AdobePhotoCatalog.AdobePhotoCatalogType.AdobePhotoCatalogTypeLightroom && !adobePhotoCatalog.isInSync()) {
            try {
                adobePhotoCatalog = a(adobePhotoCatalog, AdobePhotoCatalog.AdobePhotoCatalogType.AdobePhotoCatalogTypeLightroom);
            } catch (AdobeCSDKException e2) {
                cVar.a(e2);
                return null;
            }
        }
        AdobePhotoCatalog adobePhotoCatalog2 = adobePhotoCatalog;
        com.adobe.creativesdk.foundation.internal.net.j a2 = a((AdobePhoto) adobePhotoCollection, AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodPUT, true);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", d(adobePhotoCollection.getName()));
            return a(a2, (String) null, jSONObject.toString().getBytes(org.apache.commons.io.a.f29306f), new h(this, adobePhotoCollection, adobePhotoCatalog2, bVar, cVar));
        } catch (JSONException e3) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e3);
            return null;
        }
    }

    public com.adobe.creativesdk.foundation.internal.net.E b(AdobePhotoAssetRendition adobePhotoAssetRendition, AdobePhotoAsset adobePhotoAsset, c.a.a.a.b<AdobePhotoAsset> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        String str;
        if (adobePhotoAssetRendition.getDataPath() == null) {
            cVar.a(new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorBadRequest));
            return null;
        }
        com.adobe.creativesdk.foundation.internal.net.A e2 = e();
        if (e2 == null) {
            if (cVar != null) {
                cVar.a(new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorNoCloudSpecified));
            } else {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, ra.class.getSimpleName(), "Adobe cloud not specified.");
            }
            return null;
        }
        try {
            URL url = new URI(com.adobe.creativesdk.foundation.internal.storage.model.util.g.a(String.format("%s/revisions/%s/renditions/%s", adobePhotoAsset.getHref(), adobePhotoAsset.getRevision() == null ? "(null)" : adobePhotoAsset.getRevision().getGUID(), adobePhotoAssetRendition.getGUID()), e2.d().toString())).toURL();
            com.adobe.creativesdk.foundation.internal.net.j jVar = new com.adobe.creativesdk.foundation.internal.net.j();
            jVar.a(url);
            jVar.a(AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodPUT);
            jVar.b(HttpHeaders.CONTENT_TYPE, "image/jpeg");
            switch (E.f6653c[adobePhotoAssetRendition.getType().ordinal()]) {
                case 1:
                    str = AdobePhotoAsset.AdobePhotoAssetRenditionImage2048;
                    break;
                case 2:
                    str = AdobePhotoAsset.AdobePhotoAssetRenditionImage1024;
                    break;
                case 3:
                    str = AdobePhotoAsset.AdobePhotoAssetRenditionImageFavorite;
                    break;
                case 4:
                    str = AdobePhotoAsset.AdobePhotoAssetRenditionImageFullSize;
                    break;
                case 5:
                    str = AdobePhotoAsset.AdobePhotoAssetRenditionImagePreview;
                    break;
                case 6:
                    str = AdobePhotoAsset.AdobePhotoAssetRenditionImageThumbnail;
                    break;
                case 7:
                    str = AdobePhotoAsset.AdobePhotoAssetRenditionImageThumbnail2x;
                    break;
                default:
                    str = null;
                    break;
            }
            if (str != null) {
                jVar.b("X-Rendition-Type", str);
            }
            return a(jVar, adobePhotoAssetRendition.getDataPath().getPath(), (byte[]) null, new x(this, adobePhotoAsset, bVar, cVar));
        } catch (MalformedURLException e3) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e3);
            return null;
        } catch (URISyntaxException e4) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e4);
            return null;
        }
    }

    public com.adobe.creativesdk.foundation.internal.net.E a(AdobePhotoCollection adobePhotoCollection, c.a.a.a.b<AdobePhotoCollection> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        return a(a((AdobePhoto) adobePhotoCollection, AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodDELETE, false), (String) null, (byte[]) null, new k(this, bVar, adobePhotoCollection, cVar));
    }

    private com.adobe.creativesdk.foundation.internal.net.E a(ArrayList<AdobePhotoAsset> arrayList, AdobePhotoCollection adobePhotoCollection, AdobeNetworkHttpRequestMethod adobeNetworkHttpRequestMethod, c.a.a.a.b<ArrayList<AdobePhotoAsset>> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        com.adobe.creativesdk.foundation.internal.net.A e2 = e();
        if (e2 == null) {
            if (cVar != null) {
                cVar.a(new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorNoCloudSpecified));
            } else {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, ra.class.getSimpleName(), "Adobe cloud not specified.");
            }
            return null;
        }
        try {
            URL url = new URI(com.adobe.creativesdk.foundation.internal.storage.model.util.g.a(String.format("%s/assets", adobePhotoCollection.getHref()), e2.d().toString())).toURL();
            com.adobe.creativesdk.foundation.internal.net.j jVar = new com.adobe.creativesdk.foundation.internal.net.j();
            jVar.a(url);
            jVar.a(adobeNetworkHttpRequestMethod);
            jVar.b(HttpHeaders.CONTENT_TYPE, io.fabric.sdk.android.services.common.a.ACCEPT_JSON_VALUE);
            String str = adobeNetworkHttpRequestMethod == AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodPUT ? "added" : "updated";
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i) instanceof AdobePhotoAsset) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("_id", arrayList.get(i).getGUID());
                        if (arrayList.get(i).getOrder() != null) {
                            jSONObject.put("order", arrayList.get(i).getOrder());
                        }
                        jSONArray.put(jSONObject);
                    } catch (JSONException e3) {
                        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e3);
                    }
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("assets", jSONArray);
                jVar.b(HttpHeaders.CONTENT_LENGTH, Integer.toString(jSONObject2.toString().length()));
                try {
                    try {
                        return a(jVar, (String) null, jSONObject2.toString().getBytes(org.apache.commons.io.a.f29306f), new n(this, arrayList, str, adobePhotoCollection, bVar, cVar));
                    } catch (MalformedURLException e4) {
                        e = e4;
                        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e);
                        return null;
                    } catch (URISyntaxException e5) {
                        e = e5;
                        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e);
                        return null;
                    }
                } catch (JSONException e6) {
                    e = e6;
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e);
                    return null;
                }
            } catch (JSONException e7) {
                e = e7;
            }
        } catch (MalformedURLException e8) {
            e = e8;
        } catch (URISyntaxException e9) {
            e = e9;
        }
    }

    public com.adobe.creativesdk.foundation.internal.net.E a(ArrayList<AdobePhotoAsset> arrayList, AdobePhotoCollection adobePhotoCollection, c.a.a.a.b<ArrayList<AdobePhotoAsset>> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        return a(arrayList, adobePhotoCollection, AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodPUT, bVar, cVar);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:12|(1:14)(2:45|(1:47)(1:48))|15|(4:(9:(1:(1:(1:20))(1:42))(1:43)|(1:22)(1:41)|23|24|25|26|27|28|29)|27|28|29)|44|(0)(0)|23|24|25|26) */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00e2, code lost:            r0 = e;     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00da, code lost:            r0 = e;     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.adobe.creativesdk.foundation.internal.net.E a(com.adobe.creativesdk.foundation.storage.AdobePhotoCollection r14, com.adobe.creativesdk.foundation.storage.AdobePhotoPage r15, com.adobe.creativesdk.foundation.storage.AdobePhotoCollection.AdobePhotoCollectionSort r16, com.adobe.creativesdk.foundation.storage.AdobePhotoCollection.AdobePhotoCollectionFlag r17, int r18, com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud r19, com.adobe.creativesdk.foundation.storage.td r20, c.a.a.a.c<com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException> r21) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.internal.storage.photo.F.a(com.adobe.creativesdk.foundation.storage.AdobePhotoCollection, com.adobe.creativesdk.foundation.storage.AdobePhotoPage, com.adobe.creativesdk.foundation.storage.AdobePhotoCollection$AdobePhotoCollectionSort, com.adobe.creativesdk.foundation.storage.AdobePhotoCollection$AdobePhotoCollectionFlag, int, com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud, com.adobe.creativesdk.foundation.storage.td, c.a.a.a.c):com.adobe.creativesdk.foundation.internal.net.E");
    }

    public com.adobe.creativesdk.foundation.internal.net.E a(AdobePhotoAsset adobePhotoAsset, AdobePhotoCatalog adobePhotoCatalog, URI uri, String str, c.a.a.a.b<AdobePhotoAsset> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        com.adobe.creativesdk.foundation.internal.net.j jVar;
        byte[] a2;
        if (adobePhotoCatalog == null) {
            cVar.a(new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorBadRequest));
            return null;
        }
        if (uri == null) {
            cVar.a(new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorBadRequest));
            return null;
        }
        if (!new File(uri).exists()) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.WARN, "createAssetInCatalog", String.format("The Path for %s cannot be found", adobePhotoAsset.getName()));
            cVar.a(new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_FILE_READ_FAILURE));
            return null;
        }
        if (str == null) {
            cVar.a(new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorBadRequest));
            return null;
        }
        com.adobe.creativesdk.foundation.internal.net.A e2 = e();
        if (e2 == null) {
            if (cVar != null) {
                cVar.a(new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorNoCloudSpecified));
            } else {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, ra.class.getSimpleName(), "Adobe cloud not specified.");
            }
            return null;
        }
        try {
            URL url = new URI(com.adobe.creativesdk.foundation.internal.storage.model.util.g.a(String.format("%s/assets", adobePhotoCatalog.getHref()), e2.d().toString())).toURL();
            jVar = new com.adobe.creativesdk.foundation.internal.net.j();
            jVar.a(url);
            jVar.a(AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodPOST);
            File file = new File(uri.getPath());
            byte[] bArr = new byte[(int) file.length()];
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bArr);
            fileInputStream.close();
            jVar.b(HttpHeaders.CONTENT_TYPE, String.format("multipart/form-data; boundary=%s", "OzFormBoundary"));
            jVar.b(io.fabric.sdk.android.services.common.a.HEADER_ACCEPT, "*/*");
            a2 = a(bArr, str, "master", adobePhotoAsset.getName(), "OzFormBoundary");
            jVar.b(HttpHeaders.CONTENT_LENGTH, Integer.toString(a2.length));
        } catch (FileNotFoundException e3) {
            e = e3;
        } catch (MalformedURLException e4) {
            e = e4;
        } catch (IOException e5) {
            e = e5;
        } catch (URISyntaxException e6) {
            e = e6;
        }
        try {
            return a(jVar, (String) null, a2, new s(this, adobePhotoAsset, adobePhotoCatalog, bVar, cVar));
        } catch (FileNotFoundException e7) {
            e = e7;
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e);
            return null;
        } catch (MalformedURLException e8) {
            e = e8;
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e);
            return null;
        } catch (IOException e9) {
            e = e9;
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e);
            return null;
        } catch (URISyntaxException e10) {
            e = e10;
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e);
            return null;
        }
    }

    public com.adobe.creativesdk.foundation.internal.net.E a(AdobePhotoAsset adobePhotoAsset, AdobePhotoCollection adobePhotoCollection, URI uri, String str, c.a.a.a.b<AdobePhotoAsset> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        com.adobe.creativesdk.foundation.internal.net.j jVar;
        byte[] a2;
        com.adobe.creativesdk.foundation.internal.net.A e2 = e();
        if (e2 == null) {
            if (cVar != null) {
                cVar.a(new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorNoCloudSpecified));
            } else {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, ra.class.getSimpleName(), "Adobe cloud not specified.");
            }
            return null;
        }
        if (uri == null) {
            cVar.a(new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorBadRequest));
            return null;
        }
        if (!new File(uri).exists()) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.WARN, "createAssetInCatalog", String.format("The Path for %s cannot be found", adobePhotoAsset.getName()));
        }
        if (str == null) {
            cVar.a(new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorBadRequest));
            return null;
        }
        try {
            URL url = new URI(com.adobe.creativesdk.foundation.internal.storage.model.util.g.a(String.format("%s/assets", adobePhotoCollection.getHref()), e2.d().toString())).toURL();
            jVar = new com.adobe.creativesdk.foundation.internal.net.j();
            jVar.a(url);
            jVar.a(AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodPOST);
            File file = new File(uri.getPath());
            byte[] bArr = new byte[(int) file.length()];
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bArr);
            fileInputStream.close();
            jVar.b(HttpHeaders.CONTENT_TYPE, String.format("multipart/form-data; boundary=%s", "OzFormBoundary"));
            a2 = a(bArr, str, "master", adobePhotoAsset.getName(), "OzFormBoundary");
            jVar.b(HttpHeaders.CONTENT_LENGTH, "" + Integer.toString(a2.length));
        } catch (FileNotFoundException e3) {
            e = e3;
        } catch (MalformedURLException e4) {
            e = e4;
        } catch (IOException e5) {
            e = e5;
        } catch (URISyntaxException e6) {
            e = e6;
        }
        try {
            return a(jVar, (String) null, a2, new t(this, adobePhotoAsset, adobePhotoCollection, bVar, cVar));
        } catch (FileNotFoundException e7) {
            e = e7;
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e);
            return null;
        } catch (MalformedURLException e8) {
            e = e8;
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e);
            return null;
        } catch (IOException e9) {
            e = e9;
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e);
            return null;
        } catch (URISyntaxException e10) {
            e = e10;
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e);
            return null;
        }
    }

    public com.adobe.creativesdk.foundation.internal.net.E a(AdobePhotoAsset adobePhotoAsset, c.a.a.a.b<AdobePhotoAsset> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        return a(a((AdobePhoto) adobePhotoAsset, AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodDELETE, false), (String) null, (byte[]) null, new u(this, adobePhotoAsset, bVar, cVar));
    }

    public com.adobe.creativesdk.foundation.internal.net.E a(AdobePhotoAsset adobePhotoAsset, URI uri, boolean z, c.a.a.a.b<AdobePhotoAsset> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        if (uri == null) {
            cVar.a(new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorBadRequest));
            return null;
        }
        if (!new File(uri).exists()) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.WARN, "createAssetInCatalog", String.format("The Path for %s cannot be found", adobePhotoAsset.getName()));
            cVar.a(new AdobePhotoException(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_FILE_READ_FAILURE));
            return null;
        }
        com.adobe.creativesdk.foundation.internal.net.A e2 = e();
        if (e2 == null) {
            if (cVar != null) {
                cVar.a(new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorNoCloudSpecified));
            } else {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, ra.class.getSimpleName(), "Adobe cloud not specified.");
            }
            return null;
        }
        try {
            URL url = new URI(com.adobe.creativesdk.foundation.internal.storage.model.util.g.a(String.format("%s/revisions/%s/master", adobePhotoAsset.getHref(), adobePhotoAsset.getRevision() == null ? "(null)" : adobePhotoAsset.getRevision().getGUID()), e2.d().toString())).toURL();
            com.adobe.creativesdk.foundation.internal.net.j jVar = new com.adobe.creativesdk.foundation.internal.net.j();
            jVar.a(url);
            jVar.a(AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodPUT);
            jVar.b(HttpHeaders.CONTENT_TYPE, "image/jpeg");
            if (z) {
                if (adobePhotoAsset.getType() == AdobePhotoAsset.AdobePhotoAssetType.AdobePhotoAssetTypeImage) {
                    jVar.b("X-Generate-Renditions", "all");
                }
                jVar.b("X-Read-Meta", "xmp,caption,location");
            }
            return a(jVar, uri.getPath(), (byte[]) null, new v(this, adobePhotoAsset, bVar, cVar));
        } catch (MalformedURLException e3) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e3);
            return null;
        } catch (URISyntaxException e4) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e4);
            return null;
        }
    }

    public com.adobe.creativesdk.foundation.internal.net.E a(AdobePhotoAssetRendition adobePhotoAssetRendition, AdobePhotoAsset adobePhotoAsset, c.a.a.a.b<byte[]> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        com.adobe.creativesdk.foundation.internal.net.A e2 = e();
        if (e2 == null) {
            if (cVar != null) {
                cVar.a(new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorNoCloudSpecified));
            } else {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, ra.class.getSimpleName(), "Adobe cloud not specified.");
            }
            return null;
        }
        try {
            URL url = new URI(com.adobe.creativesdk.foundation.internal.storage.model.util.g.a(adobePhotoAssetRendition.getDataPath().getPath(), e2.d().toString())).toURL();
            com.adobe.creativesdk.foundation.internal.net.j jVar = new com.adobe.creativesdk.foundation.internal.net.j();
            jVar.a(url);
            jVar.a(AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodGET);
            return a(jVar, (String) null, (byte[]) null, new y(this, adobePhotoAsset, bVar, cVar));
        } catch (MalformedURLException e3) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e3);
            return null;
        } catch (URISyntaxException e4) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e4);
            return null;
        }
    }

    public com.adobe.creativesdk.foundation.internal.net.E a(AdobePhotoAsset adobePhotoAsset, AdobePhotoAssetRevision adobePhotoAssetRevision, c.a.a.a.b<AdobePhotoAsset> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        com.adobe.creativesdk.foundation.internal.net.A e2 = e();
        if (e2 == null) {
            if (cVar != null) {
                cVar.a(new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorNoCloudSpecified));
            } else {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, ra.class.getSimpleName(), "Adobe cloud not specified.");
            }
            return null;
        }
        String a2 = com.adobe.creativesdk.foundation.internal.storage.model.util.g.a(String.format("%s", adobePhotoAsset.getHref()), e2.d().toString());
        if (adobePhotoAssetRevision != null) {
            a2 = com.adobe.creativesdk.foundation.internal.storage.model.util.g.a(String.format("%s/revisions/%s", adobePhotoAsset.getHref(), adobePhotoAssetRevision.getGUID()), e2.d().toString());
        }
        try {
            URL url = new URI(a2).toURL();
            com.adobe.creativesdk.foundation.internal.net.j jVar = new com.adobe.creativesdk.foundation.internal.net.j();
            jVar.a(url);
            jVar.a(AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodGET);
            return a(jVar, (String) null, (byte[]) null, new A(this, adobePhotoAsset, bVar, cVar));
        } catch (MalformedURLException e3) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e3);
            return null;
        } catch (URISyntaxException e4) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e4);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.adobe.creativesdk.foundation.internal.net.l a(AdobeNetworkException adobeNetworkException) {
        if (adobeNetworkException.getData() == null || !adobeNetworkException.getData().containsKey("Response")) {
            return null;
        }
        return (com.adobe.creativesdk.foundation.internal.net.l) adobeNetworkException.getData().get("Response");
    }

    private com.adobe.creativesdk.foundation.internal.net.j a(AdobePhoto adobePhoto, AdobeNetworkHttpRequestMethod adobeNetworkHttpRequestMethod, boolean z) {
        return a(adobePhoto, adobeNetworkHttpRequestMethod, z, (ArrayList<String>) null);
    }

    private com.adobe.creativesdk.foundation.internal.net.j a(AdobePhoto adobePhoto, AdobeNetworkHttpRequestMethod adobeNetworkHttpRequestMethod, boolean z, ArrayList<String> arrayList) {
        try {
            URL url = new URI(com.adobe.creativesdk.foundation.internal.storage.model.util.g.a(adobePhoto.getHref().toString(), e().a().toString())).toURL();
            com.adobe.creativesdk.foundation.internal.net.j jVar = new com.adobe.creativesdk.foundation.internal.net.j();
            jVar.a(url);
            jVar.a(adobeNetworkHttpRequestMethod);
            if (z) {
                if (!(adobePhoto instanceof AdobePhotoCatalog) && !(adobePhoto instanceof AdobePhotoCollection)) {
                    if (adobePhoto instanceof AdobePhotoAsset) {
                        jVar.b(HttpHeaders.CONTENT_TYPE, ((AdobePhotoAsset) adobePhoto).getContentType());
                    }
                }
                jVar.b(HttpHeaders.CONTENT_TYPE, io.fabric.sdk.android.services.common.a.ACCEPT_JSON_VALUE);
            }
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i) + ",");
                }
                jVar.b("X-Update", sb.toString().substring(0, r5.length() - 1));
            }
            return jVar;
        } catch (MalformedURLException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e2);
            return null;
        } catch (URISyntaxException e3) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e3);
            return null;
        }
    }

    public com.adobe.creativesdk.foundation.internal.net.E a(com.adobe.creativesdk.foundation.internal.net.j jVar, String str, byte[] bArr, ra.b bVar) {
        Handler handler;
        try {
            handler = new Handler();
        } catch (Exception e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e2);
            handler = null;
        }
        return a(jVar, str, bArr, bVar, handler);
    }

    private com.adobe.creativesdk.foundation.internal.net.E a(com.adobe.creativesdk.foundation.internal.net.j jVar, String str, byte[] bArr, ra.b bVar, Handler handler) {
        com.adobe.creativesdk.foundation.internal.net.E b2;
        com.adobe.creativesdk.foundation.internal.net.A e2 = e();
        if (e2 == null) {
            if (bVar != null) {
                AdobeNetworkException adobeNetworkException = new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorNoCloudSpecified);
                if (handler != null) {
                    handler.post(new B(this, bVar, adobeNetworkException));
                } else {
                    bVar.a(adobeNetworkException);
                }
            } else {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, ra.class.getSimpleName(), "Adobe cloud not specified.");
            }
            return null;
        }
        AdobeNetworkException n = n();
        if (n != null) {
            if (bVar == null) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, F.class.getSimpleName(), "Entitlement Check failed", n);
            } else if (handler != null) {
                handler.post(new C(this, bVar, n));
            } else {
                bVar.a(n);
            }
            return null;
        }
        D d2 = new D(this, jVar, bVar);
        if (str == null) {
            jVar.a(bArr);
            b2 = e2.a(jVar, AdobeNetworkRequestPriority.NORMAL, d2, handler);
        } else if (jVar.e() == AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodGET) {
            b2 = e2.a(jVar, str, AdobeNetworkRequestPriority.NORMAL, d2, handler);
        } else {
            b2 = e2.b(jVar, str, AdobeNetworkRequestPriority.NORMAL, d2, handler);
        }
        j.put(jVar, b2);
        return b2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AdobePhotoException a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        AdobePhotoException adobePhotoException = null;
        if (lVar == null) {
            return null;
        }
        int g2 = lVar.g();
        if (g2 == 412) {
            adobePhotoException = c.a.a.a.c.e.a.a(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_CONFLICTING_CHANGES, lVar.h(), lVar.c(), lVar.g(), lVar.e());
        } else if (g2 == 507) {
            adobePhotoException = c.a.a.a.c.e.a.a(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_EXCEEDED_QUOTA, lVar.h(), lVar.c(), lVar.g(), lVar.e());
        } else if (g2 == 415) {
            adobePhotoException = c.a.a.a.c.e.a.a(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_UNSUPPORTED_MEDIA, lVar.h(), lVar.c(), lVar.g(), lVar.e());
        }
        return adobePhotoException == null ? c.a.a.a.c.e.a.a(AdobePhotoErrorCode.ADOBE_PHOTO_ERROR_UNEXPECTED_RESPONSE, lVar.h(), lVar.c(), lVar.g(), lVar.e()) : adobePhotoException;
    }

    private byte[] a(byte[] bArr, String str, String str2, String str3, String str4) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeBytes(String.format("--%s\r%n", str4));
            dataOutputStream.writeBytes(String.format("Content-Disposition: form-data; name=\"%s\"; filename=\"%s\"\r%n", str2, str3));
            dataOutputStream.writeBytes(String.format("Content-Type: %s\r%n\r%n", str));
            dataOutputStream.write(bArr);
            dataOutputStream.writeBytes("\r\n");
            dataOutputStream.writeBytes(String.format("--%s--\r%n", str4));
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e2);
            return null;
        }
    }
}
