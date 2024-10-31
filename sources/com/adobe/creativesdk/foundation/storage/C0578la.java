package com.adobe.creativesdk.foundation.storage;

import android.os.Handler;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloudServiceType;
import com.adobe.creativesdk.foundation.adobeinternal.entitlement.AdobeEntitlementException;
import com.adobe.creativesdk.foundation.internal.cache.AdobeCommonCacheOptions;
import com.adobe.creativesdk.foundation.internal.storage.C0512k;
import com.adobe.creativesdk.foundation.internal.storage.model.resources.AdobeStorageOrderByProperty;
import com.adobe.creativesdk.foundation.internal.storage.model.resources.AdobeStorageOrderRelation;
import com.adobe.creativesdk.foundation.internal.storage.model.resources.AdobeStoragePagingMode;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.facebook.share.internal.ShareConstants;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.EnumSet;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdobeAssetFolder.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.la, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0578la extends C0533a implements com.adobe.creativesdk.foundation.internal.storage.controllers.upload.A<C0578la> {

    /* renamed from: a, reason: collision with root package name */
    protected com.adobe.creativesdk.foundation.internal.storage.model.resources.e f7328a;

    /* renamed from: b, reason: collision with root package name */
    protected boolean f7329b;

    /* renamed from: c, reason: collision with root package name */
    private int f7330c;

    /* renamed from: d, reason: collision with root package name */
    private int f7331d;

    /* renamed from: e, reason: collision with root package name */
    private int f7332e;

    /* renamed from: f, reason: collision with root package name */
    private String f7333f;

    /* renamed from: g, reason: collision with root package name */
    private String f7334g;

    /* renamed from: h, reason: collision with root package name */
    private String f7335h;
    private String i;
    private String j;
    private String k;
    private long l;
    private int m;
    private long n;
    private long o;

    /* JADX INFO: Access modifiers changed from: protected */
    public C0578la(com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar, AdobeStorageOrderByProperty adobeStorageOrderByProperty, AdobeStorageOrderRelation adobeStorageOrderRelation, URI uri) {
        this.f7330c = 0;
        this.f7331d = 0;
        this.f7332e = 0;
        this.f7333f = null;
        this.f7334g = null;
        this.f7335h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = 0L;
        this.m = 0;
        this.n = 0L;
        this.o = 0L;
        this.f7328a = eVar;
        this.GUID = eVar.f6609a;
        this.href = eVar.f6610b;
        this.etag = eVar.f6613e;
        this.name = eVar.f6611c;
        this.mCloud = eVar.a();
        this.parentHref = uri;
        this.creationDate = com.adobe.creativesdk.foundation.internal.storage.model.util.i.b(eVar.f6614f);
        this.modificationDate = com.adobe.creativesdk.foundation.internal.storage.model.util.i.b(eVar.f6615g);
        this.links = eVar.j;
        this.f7328a.a(adobeStorageOrderByProperty);
        this.f7328a.a(adobeStorageOrderRelation);
        this.f7329b = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int c(C0578la c0578la) {
        int i = c0578la.f7331d;
        c0578la.f7331d = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int h(C0578la c0578la) {
        int i = c0578la.f7332e;
        c0578la.f7332e = i + 1;
        return i;
    }

    @Override // com.adobe.creativesdk.foundation.storage.C0533a
    public boolean equals(Object obj) {
        if (obj instanceof C0578la) {
            return super.equals(obj);
        }
        return false;
    }

    public String getDescription() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.GUID != null) {
                jSONObject.put("guid", this.GUID);
            }
            if (this.etag != null) {
                jSONObject.put("etag", this.etag);
            }
            if (this.href != null) {
                jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_HREF, this.href);
            }
            if (this.parentHref != null) {
                jSONObject.put("parent-href", this.parentHref);
            }
            if (this.name != null) {
                jSONObject.put("name", this.name);
            }
            if (this.creationDate != null) {
                jSONObject.put("created", this.creationDate.toString());
            }
            if (this.modificationDate != null) {
                jSONObject.put("modified", this.modificationDate.toString());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.upload.A
    @Deprecated
    public String getId() {
        String uri = getHref().toString();
        String substring = (uri == null || uri.length() <= 0 || uri.charAt(uri.length() + (-1)) != '/') ? null : uri.substring(0, uri.length() - 1);
        int lastIndexOf = (substring != null ? substring.lastIndexOf("/") : uri.lastIndexOf("/")) + 1;
        int length = getHref().toString().length();
        if (uri != null) {
            return uri.substring(lastIndexOf, length);
        }
        return null;
    }

    @Override // com.adobe.creativesdk.foundation.storage.C0533a
    public int hashCode() {
        return super.hashCode();
    }

    @Deprecated
    public boolean p(C0578la c0578la) {
        return getHref().toString().equalsIgnoreCase(c0578la.getHref().toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.adobe.creativesdk.foundation.internal.storage.model.resources.e g() {
        if (this.f7328a == null) {
            this.f7328a = com.adobe.creativesdk.foundation.internal.storage.model.resources.e.a(this.href);
            com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar = this.f7328a;
            eVar.f6611c = this.name;
            eVar.f6613e = this.etag;
            eVar.f6609a = this.GUID;
            eVar.a(getCloud());
        }
        return this.f7328a;
    }

    public boolean d() {
        com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar = this.f7328a;
        if (eVar != null) {
            return eVar.b();
        }
        return false;
    }

    public boolean e() {
        com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar = this.f7328a;
        if (eVar != null) {
            return eVar.c();
        }
        return false;
    }

    public void f() {
        this.f7329b = false;
    }

    public boolean c() {
        return (this.f7329b && this.f7328a.m()) ? false : true;
    }

    public void b(AdobeAssetFolderOrderBy adobeAssetFolderOrderBy, AdobeAssetFolderOrderDirection adobeAssetFolderOrderDirection) {
        this.f7329b = false;
        g().a(a(adobeAssetFolderOrderBy));
        g().a(a(adobeAssetFolderOrderDirection));
    }

    public AdobeCollaborationType a() {
        com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar = this.f7328a;
        return eVar == null ? AdobeCollaborationType.ADOBE_COLLABORATION_TYPE_PRIVATE : eVar.k;
    }

    public static C0578la b() {
        return a(com.adobe.creativesdk.foundation.adobeinternal.cloud.d.e().c());
    }

    public void a(int i, qd qdVar) {
        g().a(i);
        g().f6613e = null;
        W w = new W(this, qdVar);
        com.adobe.creativesdk.foundation.internal.storage.a.b.ra session = getSession();
        if (session == null) {
            return;
        }
        session.a(g(), this.f7329b ? AdobeStoragePagingMode.AdobeStorageNextPageReplace : AdobeStoragePagingMode.AdobeStorageFirstPage, w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c.a.a.a.b<JSONObject> bVar, c.a.a.a.c<AdobeAssetException> cVar) {
        f();
        g().a(1000);
        this.f7330c = 0;
        this.f7332e = 0;
        this.f7331d = 0;
        a(bVar, cVar, new Handler());
    }

    public static C0578la a(AdobeAssetFolderOrderBy adobeAssetFolderOrderBy, AdobeAssetFolderOrderDirection adobeAssetFolderOrderDirection) {
        return a(com.adobe.creativesdk.foundation.adobeinternal.cloud.d.e().c(), a(adobeAssetFolderOrderBy), a(adobeAssetFolderOrderDirection));
    }

    public static C0578la a(URI uri, AdobeAssetFolderOrderBy adobeAssetFolderOrderBy, AdobeAssetFolderOrderDirection adobeAssetFolderOrderDirection) {
        C0512k c0512k;
        if (uri == null) {
            return null;
        }
        try {
            c0512k = new C0512k(com.adobe.creativesdk.foundation.internal.storage.model.resources.e.a(uri), a(adobeAssetFolderOrderBy), a(adobeAssetFolderOrderDirection), new URI(com.adobe.creativesdk.foundation.internal.storage.model.util.g.b(uri.getRawPath())));
            try {
                c0512k.setCloud(com.adobe.creativesdk.foundation.adobeinternal.cloud.d.e().c());
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return c0512k;
            }
        } catch (Exception e3) {
            e = e3;
            c0512k = null;
        }
        return c0512k;
    }

    public static void a(String str, C0578la c0578la, c.a.a.a.b<C0578la> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        a(str, c0578la, com.adobe.creativesdk.foundation.adobeinternal.cloud.d.e().c(), bVar, cVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static AdobeStorageOrderByProperty a(AdobeAssetFolderOrderBy adobeAssetFolderOrderBy) {
        int i = C0574ka.f7314a[adobeAssetFolderOrderBy.ordinal()];
        if (i == 1) {
            return AdobeStorageOrderByProperty.ADOBE_STORAGE_ORDER_BY_NAME;
        }
        if (i != 2) {
            return AdobeStorageOrderByProperty.ADOBE_STORAGE_ORDER_BY_NAME;
        }
        return AdobeStorageOrderByProperty.ADOBE_STORAGE_ORDER_BY_MODIFIED;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static AdobeStorageOrderRelation a(AdobeAssetFolderOrderDirection adobeAssetFolderOrderDirection) {
        int i = C0574ka.f7315b[adobeAssetFolderOrderDirection.ordinal()];
        if (i == 1) {
            return AdobeStorageOrderRelation.ADOBE_STORAGE_ORDER_ASCENDING;
        }
        if (i != 2) {
            return AdobeStorageOrderRelation.ADOBE_STORAGE_ORDER_ASCENDING;
        }
        return AdobeStorageOrderRelation.ADOBE_STORAGE_ORDER_DESCENDING;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public C0578la(com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar, com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar2) {
        this(eVar, eVar2.j(), eVar2.i(), eVar2.f6610b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public C0578la() {
        this.f7330c = 0;
        this.f7331d = 0;
        this.f7332e = 0;
        this.f7333f = null;
        this.f7334g = null;
        this.f7335h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = 0L;
        this.m = 0;
        this.n = 0L;
        this.o = 0L;
    }

    protected static C0578la a(AdobeCloud adobeCloud) {
        return a(adobeCloud, AdobeStorageOrderByProperty.ADOBE_STORAGE_ORDER_BY_NAME, AdobeStorageOrderRelation.ADOBE_STORAGE_ORDER_ASCENDING);
    }

    protected static C0578la a(AdobeCloud adobeCloud, AdobeStorageOrderByProperty adobeStorageOrderByProperty, AdobeStorageOrderRelation adobeStorageOrderRelation) {
        try {
            com.adobe.creativesdk.foundation.internal.storage.model.resources.e a2 = com.adobe.creativesdk.foundation.internal.storage.model.resources.e.a(new URI("/files/"));
            a2.a(adobeCloud);
            return new C0512k(a2, adobeStorageOrderByProperty, adobeStorageOrderRelation, null);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static C0578la a(URI uri, AdobeCloud adobeCloud) {
        return a(uri, adobeCloud, AdobeAssetFolderOrderBy.ADOBE_ASSET_FOLDER_ORDER_BY_NAME, AdobeAssetFolderOrderDirection.ADOBE_ASSET_FOLDER_ORDER_ASCENDING);
    }

    protected static C0578la a(URI uri, AdobeCloud adobeCloud, AdobeAssetFolderOrderBy adobeAssetFolderOrderBy, AdobeAssetFolderOrderDirection adobeAssetFolderOrderDirection) {
        C0512k c0512k;
        if (uri == null) {
            return null;
        }
        String rawPath = uri.getRawPath();
        if (rawPath.startsWith("/")) {
            rawPath = rawPath.substring(1);
        }
        if (rawPath.endsWith("/")) {
            rawPath = rawPath.substring(0, rawPath.length() - 1);
        }
        try {
            URI uri2 = new URI(String.format("/files/%s/", rawPath));
            c0512k = new C0512k(com.adobe.creativesdk.foundation.internal.storage.model.resources.e.a(uri2), a(adobeAssetFolderOrderBy), a(adobeAssetFolderOrderDirection), new URI(com.adobe.creativesdk.foundation.internal.storage.model.util.g.b(uri2.getRawPath())));
            try {
                c0512k.setCloud(adobeCloud);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return c0512k;
            }
        } catch (Exception e3) {
            e = e3;
            c0512k = null;
        }
        return c0512k;
    }

    protected static void a(String str, C0578la c0578la, AdobeCloud adobeCloud, c.a.a.a.b<C0578la> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        String concat;
        if (c.a.a.a.a.a.a.b().b(new Y(cVar), "Update requires an authenticated user.") || c0578la == null) {
            return;
        }
        String validatedAssetName = C0533a.getValidatedAssetName(str);
        if (validatedAssetName == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("ADOBE_ASSET_DETAILS_STRING_KEY", "Illegal Characters in name");
            hashMap.put(AdobeEntitlementException.AdobeNetworkHTTPStatusKey, 400);
            cVar.a(new AdobeAssetException(AdobeAssetErrorCode.AdobeAssetErrorFileReadFailure, hashMap));
            return;
        }
        String rawPath = c0578la.href.getRawPath();
        if (rawPath.endsWith("/")) {
            concat = rawPath.concat(validatedAssetName);
        } else {
            concat = rawPath.concat("/").concat(validatedAssetName);
        }
        try {
            com.adobe.creativesdk.foundation.internal.storage.model.resources.e a2 = com.adobe.creativesdk.foundation.internal.storage.model.resources.e.a(new URI(concat.concat("/")));
            Z z = new Z(c0578la, bVar, cVar);
            com.adobe.creativesdk.foundation.internal.storage.a.b.ra raVar = (com.adobe.creativesdk.foundation.internal.storage.a.b.ra) adobeCloud.getSessionForService(AdobeCloudServiceType.AdobeCloudServiceTypeStorage);
            if (raVar == null) {
                return;
            }
            raVar.a(a2, z);
        } catch (URISyntaxException e2) {
            e2.printStackTrace();
        }
    }

    @Deprecated
    public void a(c.a.a.a.b<JSONObject> bVar, c.a.a.a.c<AdobeAssetException> cVar) {
        X x = new X(this);
        try {
            x.f7160a = new Handler();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (com.adobe.creativesdk.foundation.internal.cache.d.b().a(this.GUID, "PAGE_RESOURCE_COLLECTION_DATA", EnumSet.of(AdobeCommonCacheOptions.AdobeCommonCacheKeepInMemoryCache, AdobeCommonCacheOptions.AdobeCommonCacheKeepOnDiskCache), "com.adobe.cc.storage", new C0538ba(this, bVar, cVar, x), x.f7160a)) {
            return;
        }
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeAssetFile:GetRenditionFromCache", String.format("Rendition request for %s ended in error.", this.href));
        cVar.a(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c.a.a.a.b<JSONObject> bVar, c.a.a.a.c<AdobeAssetException> cVar, Handler handler) {
        getSession().a(g(), this.f7330c == 0 ? AdobeStoragePagingMode.AdobeStorageFirstPage : AdobeStoragePagingMode.AdobeStorageNextPageReplace, new C0566ia(this, handler, cVar, bVar), new C0570ja(this), handler);
    }
}
