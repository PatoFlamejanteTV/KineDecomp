package com.adobe.creativesdk.foundation.internal.storage.a.b;

import android.os.Handler;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloudEndpoint;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloudServiceType;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeEntitlementServices;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXErrorCode;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0225c;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.hb;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ib;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.mb;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.pb;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.vb;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.zb;
import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIdentityManagementService;
import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthKeychain;
import com.adobe.creativesdk.foundation.internal.cache.AdobeCommonCachePolicies;
import com.adobe.creativesdk.foundation.internal.cache.AdobeInvalidCacheSettingsException;
import com.adobe.creativesdk.foundation.internal.net.AdobeNetworkHttpRequestMethod;
import com.adobe.creativesdk.foundation.internal.net.AdobeNetworkRequestPriority;
import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.internal.storage.model.resources.AdobeStoragePagingMode;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetErrorCode;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFile;
import com.adobe.creativesdk.foundation.storage.AdobeCollaborationType;
import com.adobe.creativesdk.foundation.storage.C0533a;
import com.adobe.creativesdk.foundation.storage.C0578la;
import com.adobe.creativesdk.foundation.storage.ud;
import com.facebook.stetho.server.http.HttpHeaders;
import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: AdobeStorageSession.java */
/* loaded from: classes.dex */
public class ra extends com.adobe.creativesdk.foundation.adobeinternal.cloud.g implements zb {
    private static Map<com.adobe.creativesdk.foundation.internal.net.j, com.adobe.creativesdk.foundation.internal.net.E> j = new HashMap();
    protected boolean k;
    private hb l;
    private Handler m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AdobeStorageSession.java */
    /* loaded from: classes.dex */
    public interface a {
    }

    /* compiled from: AdobeStorageSession.java */
    /* loaded from: classes.dex */
    public interface b extends ud {
        void a(com.adobe.creativesdk.foundation.internal.net.l lVar);

        void a(AdobeNetworkException adobeNetworkException);
    }

    public ra(AdobeCloudEndpoint adobeCloudEndpoint) {
        super(adobeCloudEndpoint);
        g();
        a(AdobeInternalNotificationID.AdobeStorageServiceDisconnectedNotification);
        a(15L, false);
    }

    public static com.adobe.creativesdk.foundation.adobeinternal.cloud.g b(AdobeCloudEndpoint adobeCloudEndpoint) {
        if (adobeCloudEndpoint == null) {
            if (c.a.a.a.a.a.a.b().d()) {
                return null;
            }
            adobeCloudEndpoint = l();
        }
        return new ra(adobeCloudEndpoint);
    }

    protected static AdobeCloudEndpoint l() {
        String str;
        AdobeCloudEndpoint adobeCloudEndpoint;
        int i = na.f5452a[AdobeAuthIdentityManagementService.K().w().ordinal()];
        if (i == 1) {
            str = "https://cc-api-storage.adobe.io";
        } else if (i == 2) {
            str = "https://cc-api-storage-stage.adobe.io";
        } else {
            if (i != 3) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, ra.class.getSimpleName(), "An undefined authentication endpoint has been specified.");
                return null;
            }
            str = "https://cc-api-storage-labs.adobe.io";
        }
        try {
            adobeCloudEndpoint = new AdobeCloudEndpoint("files", new URL(str), AdobeCloudServiceType.AdobeCloudServiceTypeStorage);
            try {
                adobeCloudEndpoint.addServiceSchemaId("assets", new URL(str));
                adobeCloudEndpoint.addServiceSchemaId("libraries", new URL(str));
            } catch (MalformedURLException e2) {
                e = e2;
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e);
                return adobeCloudEndpoint;
            }
        } catch (MalformedURLException e3) {
            e = e3;
            adobeCloudEndpoint = null;
        }
        return adobeCloudEndpoint;
    }

    private AdobeNetworkException n() {
        boolean z = true;
        if (f()) {
            if (!AdobeEntitlementServices.b().c()) {
                z = false;
            }
        } else {
            AdobeEntitlementServices.b().d();
        }
        if (z) {
            return null;
        }
        return new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorNotEntitledToService);
    }

    public com.adobe.creativesdk.foundation.internal.net.j a(com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar, InputStream inputStream, boolean z, va vaVar, Handler handler) {
        String e2;
        com.adobe.creativesdk.foundation.internal.net.j a2 = a((com.adobe.creativesdk.foundation.internal.storage.model.resources.b) fVar, AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodPUT, fVar.f6613e == null ? null : "If-Match", true);
        if (fVar.f6612d == null && f() && (e2 = com.adobe.creativesdk.foundation.internal.storage.model.util.i.e(fVar.i())) != null) {
            a2.b(HttpHeaders.CONTENT_TYPE, e2);
        }
        if (z) {
            a2.b("If-Match", "*");
        }
        a(a2, inputStream, new C0345o(this, fVar, vaVar), handler);
        return a2;
    }

    public com.adobe.creativesdk.foundation.internal.storage.model.resources.f c(C0231f c0231f) throws AdobeCSDKException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition newCondition = reentrantLock.newCondition();
        ka kaVar = new ka(this);
        a(c0231f, new Y(this, reentrantLock, kaVar, newCondition), (Handler) null);
        reentrantLock.lock();
        while (!kaVar.f5430a) {
            try {
                try {
                    newCondition.await();
                } catch (InterruptedException e2) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e2);
                }
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        reentrantLock.unlock();
        AdobeCSDKException adobeCSDKException = kaVar.f5432c;
        if (adobeCSDKException == null) {
            return kaVar.f5431b;
        }
        throw adobeCSDKException;
    }

    protected com.adobe.creativesdk.foundation.internal.net.A d(String str) {
        URL url;
        com.adobe.creativesdk.foundation.internal.net.A c2 = c("files");
        try {
            url = new URL(str);
        } catch (MalformedURLException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e2);
            url = null;
        }
        if (url != null && url.getPath() != null) {
            str = url.getPath();
        }
        if (!str.startsWith("/")) {
            str = String.format("/%s", str);
        }
        if (str.startsWith("/archive")) {
            com.adobe.creativesdk.foundation.internal.net.A c3 = c("archive");
            return c3 == null ? c((String) null) : c3;
        }
        if (str.startsWith("/assets/adobe-libraries")) {
            return c("libraries");
        }
        return str.startsWith("/assets") ? c("assets") : c2;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.cloud.g
    public void g() {
        String c2 = AdobeAuthKeychain.r().c();
        if (m() || c2 == null || c2.length() <= 0) {
            return;
        }
        try {
            com.adobe.creativesdk.foundation.internal.cache.d.b().a("com.adobe.cc.storage", 100, 1.34217728E8d, EnumSet.of(AdobeCommonCachePolicies.AdobeCommonCacheEvictionLRU));
            e = null;
        } catch (AdobeInvalidCacheSettingsException e2) {
            e = e2;
        }
        if (e != null) {
            this.k = true;
        } else {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, ra.class.getSimpleName(), (String) null);
        }
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.cloud.g
    public void i() {
        super.i();
        if (com.adobe.creativesdk.foundation.internal.cache.d.b().a("com.adobe.cc.storage")) {
            com.adobe.creativesdk.foundation.internal.cache.d.b().b("com.adobe.cc.storage");
            if (!com.adobe.creativesdk.foundation.internal.cache.d.b().c("com.adobe.cc.storage")) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, ra.class.getSimpleName(), "Removal of cache failed");
            }
        }
        this.k = false;
    }

    protected boolean m() {
        return this.k;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.adobe.creativesdk.foundation.internal.net.j b(com.adobe.creativesdk.foundation.internal.storage.model.resources.f r6, com.adobe.creativesdk.foundation.internal.storage.model.resources.a r7, java.lang.String r8) {
        /*
            r5 = this;
            java.lang.String r0 = "AssetStorage.requestRendition"
            java.lang.String r1 = "files"
            com.adobe.creativesdk.foundation.internal.net.A r1 = r5.c(r1)
            java.lang.String r2 = r6.j()     // Catch: java.net.MalformedURLException -> L39 java.net.URISyntaxException -> L42
            java.lang.String r2 = com.adobe.creativesdk.foundation.internal.storage.model.util.i.a(r2, r7)     // Catch: java.net.MalformedURLException -> L39 java.net.URISyntaxException -> L42
            if (r2 != 0) goto L18
            java.net.URI r2 = r6.f6610b     // Catch: java.net.MalformedURLException -> L39 java.net.URISyntaxException -> L42
            java.lang.String r2 = r5.a(r2, r7)     // Catch: java.net.MalformedURLException -> L39 java.net.URISyntaxException -> L42
        L18:
            java.net.URI r3 = new java.net.URI     // Catch: java.net.MalformedURLException -> L39 java.net.URISyntaxException -> L42
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.net.MalformedURLException -> L39 java.net.URISyntaxException -> L42
            r4.<init>()     // Catch: java.net.MalformedURLException -> L39 java.net.URISyntaxException -> L42
            java.net.URL r1 = r1.a()     // Catch: java.net.MalformedURLException -> L39 java.net.URISyntaxException -> L42
            java.lang.String r1 = r1.toString()     // Catch: java.net.MalformedURLException -> L39 java.net.URISyntaxException -> L42
            r4.append(r1)     // Catch: java.net.MalformedURLException -> L39 java.net.URISyntaxException -> L42
            r4.append(r2)     // Catch: java.net.MalformedURLException -> L39 java.net.URISyntaxException -> L42
            java.lang.String r1 = r4.toString()     // Catch: java.net.MalformedURLException -> L39 java.net.URISyntaxException -> L42
            r3.<init>(r1)     // Catch: java.net.MalformedURLException -> L39 java.net.URISyntaxException -> L42
            java.net.URL r0 = r3.toURL()     // Catch: java.net.MalformedURLException -> L39 java.net.URISyntaxException -> L42
            goto L4b
        L39:
            r1 = move-exception
            com.adobe.creativesdk.foundation.internal.utils.logging.Level r2 = com.adobe.creativesdk.foundation.internal.utils.logging.Level.INFO
            java.lang.String r3 = "MalformedURLException"
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(r2, r0, r3, r1)
            goto L4a
        L42:
            r1 = move-exception
            com.adobe.creativesdk.foundation.internal.utils.logging.Level r2 = com.adobe.creativesdk.foundation.internal.utils.logging.Level.INFO
            java.lang.String r3 = "URISyntaxException"
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(r2, r0, r3, r1)
        L4a:
            r0 = 0
        L4b:
            com.adobe.creativesdk.foundation.internal.net.j r1 = new com.adobe.creativesdk.foundation.internal.net.j
            r1.<init>()
            r1.a(r0)
            com.adobe.creativesdk.foundation.internal.net.AdobeNetworkHttpRequestMethod r0 = com.adobe.creativesdk.foundation.internal.net.AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodGET
            r1.a(r0)
            if (r8 == 0) goto L63
            java.lang.String r6 = r6.f6613e
            if (r6 != 0) goto L60
            java.lang.String r6 = "*"
        L60:
            r1.b(r8, r6)
        L63:
            java.lang.String r6 = r7.b()
            java.lang.String r7 = "Accept"
            r1.b(r7, r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b(com.adobe.creativesdk.foundation.internal.storage.model.resources.f, com.adobe.creativesdk.foundation.internal.storage.model.resources.a, java.lang.String):com.adobe.creativesdk.foundation.internal.net.j");
    }

    public ra(com.adobe.creativesdk.foundation.internal.net.A a2) {
        super(a2, null);
    }

    public com.adobe.creativesdk.foundation.internal.net.j a(com.adobe.creativesdk.foundation.internal.storage.model.resources.b bVar, AdobeNetworkHttpRequestMethod adobeNetworkHttpRequestMethod, String str, boolean z) {
        return a(bVar, adobeNetworkHttpRequestMethod, str, z, (List<String>) null);
    }

    public com.adobe.creativesdk.foundation.internal.net.j a(com.adobe.creativesdk.foundation.internal.storage.model.resources.b bVar, AdobeNetworkHttpRequestMethod adobeNetworkHttpRequestMethod, String str, boolean z, List<String> list) {
        try {
            com.adobe.creativesdk.foundation.internal.net.A d2 = d(bVar.f6610b.toString());
            if (d2 == null) {
                return null;
            }
            URI uri = new URI(com.adobe.creativesdk.foundation.internal.storage.model.util.g.a(bVar.f6610b.toString(), d2.a().toString()));
            boolean z2 = bVar.f6616h;
            String str2 = adobeNetworkHttpRequestMethod.toString();
            if (z2 && "AdobeNetworkHttpRequestMethodGET".equals(str2) && (bVar instanceof com.adobe.creativesdk.foundation.internal.storage.model.resources.e)) {
                String k = ((com.adobe.creativesdk.foundation.internal.storage.model.resources.e) bVar).k();
                if (!k.isEmpty()) {
                    uri = new URI(uri.toString() + "?" + k);
                }
            }
            URL url = uri.toURL();
            com.adobe.creativesdk.foundation.internal.net.j jVar = new com.adobe.creativesdk.foundation.internal.net.j();
            jVar.a(url);
            jVar.a(adobeNetworkHttpRequestMethod);
            if (str != null) {
                jVar.b(str, bVar.f6613e == null ? "*" : bVar.f6613e);
            }
            if (z && bVar.f6612d != null) {
                jVar.b(HttpHeaders.CONTENT_TYPE, bVar.f6612d);
            }
            if (list != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    sb.append(list.get(i) + ",");
                }
                jVar.b("X-Update", sb.toString().substring(0, r9.length() - 1));
            }
            if (list != null && list.contains("X-Ordinal")) {
                jVar.b("X-Ordinal", Long.toString(bVar.i));
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

    private com.adobe.creativesdk.foundation.internal.net.j b(String str, C0533a c0533a, wa waVar) {
        try {
            if (c0533a == null) {
                waVar.a(com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorBadRequest, (String) null));
                return null;
            }
            URL url = new URI(c("files").a().toString() + str).toURL();
            com.adobe.creativesdk.foundation.internal.net.j jVar = new com.adobe.creativesdk.foundation.internal.net.j();
            jVar.a(url);
            if (!f()) {
                jVar.a("invocation_mode", "async");
            }
            jVar.b("Link", String.format("<%s>;rel=self", c0533a.getHref().toString()));
            if (c0533a instanceof C0578la) {
                jVar.b(HttpHeaders.CONTENT_TYPE, "application/vnd.adobe.directory+json");
            } else {
                jVar.b(HttpHeaders.CONTENT_TYPE, "*/*");
            }
            jVar.a(AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodPUT);
            a(jVar, (String) null, (byte[]) null, new C0341k(this, waVar, this));
            return jVar;
        } catch (MalformedURLException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e2);
            waVar.a(com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorBadRequest, (String) null));
            return null;
        } catch (URISyntaxException e3) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e3);
            waVar.a(com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorBadRequest, (String) null));
            return null;
        }
    }

    public void a(com.adobe.creativesdk.foundation.internal.net.j jVar) {
        if (j.containsKey(jVar)) {
            j.get(jVar).a();
            j.remove(jVar);
        }
    }

    public com.adobe.creativesdk.foundation.internal.net.E a(com.adobe.creativesdk.foundation.internal.net.j jVar, String str, byte[] bArr, b bVar) {
        Handler handler;
        try {
            handler = new Handler();
        } catch (Exception e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e2);
            handler = null;
        }
        return a(jVar, str, bArr, bVar, handler);
    }

    public com.adobe.creativesdk.foundation.internal.net.j b(com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar, AdobeStoragePagingMode adobeStoragePagingMode, ta taVar, Handler handler) {
        if (adobeStoragePagingMode == AdobeStoragePagingMode.AdobeStorageFirstPage) {
            eVar.n();
        } else {
            if (adobeStoragePagingMode == AdobeStoragePagingMode.AdobeStorageNextPageAppend || adobeStoragePagingMode == AdobeStoragePagingMode.AdobeStorageNextPageReplace) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "StorageSession.getDirectory", "Unexpected Paging mode");
            }
            if (!eVar.m()) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "StorageSession.getDirectory", "Specified Paging mode should only be used with an incomplete collection that was populated by a previous request");
            }
            eVar.c(eVar.g());
        }
        com.adobe.creativesdk.foundation.internal.net.j a2 = a((com.adobe.creativesdk.foundation.internal.storage.model.resources.b) eVar, AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodGET, eVar.f6613e != null && eVar.d() != null && adobeStoragePagingMode == AdobeStoragePagingMode.AdobeStorageFirstPage ? "If-None-Match" : null, false, (List<String>) null);
        a(a2, (String) null, (byte[]) null, new C0343m(this, eVar, adobeStoragePagingMode, taVar), handler);
        return a2;
    }

    public com.adobe.creativesdk.foundation.internal.net.E a(com.adobe.creativesdk.foundation.internal.net.j jVar, InputStream inputStream, b bVar, Handler handler) {
        com.adobe.creativesdk.foundation.internal.net.A d2 = d(jVar.g().toString());
        if (d2 == null) {
            if (bVar != null) {
                AdobeNetworkException adobeNetworkException = new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorNoCloudSpecified);
                if (handler != null) {
                    handler.post(new D(this, bVar, adobeNetworkException));
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
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, ra.class.getSimpleName(), "Entitlement Check failed", n);
            } else if (handler != null) {
                handler.post(new O(this, bVar, n));
            } else {
                bVar.a(n);
            }
            return null;
        }
        ba baVar = new ba(this, jVar, bVar);
        d2.a(AdobeAuthIdentityManagementService.K().c());
        com.adobe.creativesdk.foundation.internal.net.E a2 = d2.a(jVar, inputStream, AdobeNetworkRequestPriority.NORMAL, baVar, handler);
        j.put(jVar, a2);
        a2.a(new ja(this, bVar));
        return a2;
    }

    public com.adobe.creativesdk.foundation.internal.net.j b(com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar, va vaVar, String str) {
        Handler handler;
        try {
            handler = new Handler();
        } catch (Exception e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e2);
            handler = null;
        }
        com.adobe.creativesdk.foundation.internal.net.j a2 = a((com.adobe.creativesdk.foundation.internal.storage.model.resources.b) fVar, AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodGET, (String) null, false);
        a2.b("Accept-Encoding", "");
        B b2 = new B(this, fVar, vaVar);
        if (str == null) {
            a(a2, fVar.i(), (byte[]) null, b2, handler);
        } else {
            a(a2, str, (byte[]) null, b2, handler);
        }
        return a2;
    }

    public com.adobe.creativesdk.foundation.internal.net.E a(com.adobe.creativesdk.foundation.internal.net.j jVar, String str, byte[] bArr, b bVar, Handler handler) {
        com.adobe.creativesdk.foundation.internal.net.E b2;
        if (jVar == null) {
            bVar.a(new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorBadRequest));
            return null;
        }
        com.adobe.creativesdk.foundation.internal.net.A d2 = d(jVar.g().toString());
        if (d2 == null) {
            if (bVar != null) {
                AdobeNetworkException adobeNetworkException = new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorNoCloudSpecified);
                if (handler != null) {
                    handler.post(new ma(this, bVar, adobeNetworkException));
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
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, ra.class.getSimpleName(), "Entitlement Check failed", n);
            } else if (handler != null) {
                handler.post(new oa(this, bVar, n));
            } else {
                bVar.a(n);
            }
            return null;
        }
        pa paVar = new pa(this, jVar, bVar);
        d2.a(AdobeAuthIdentityManagementService.K().c());
        if (str == null) {
            if (bArr != null) {
                jVar.a(bArr);
            }
            b2 = d2.a(jVar, AdobeNetworkRequestPriority.NORMAL, paVar, handler);
        } else if (jVar.e() == AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodGET) {
            b2 = d2.a(jVar, str, AdobeNetworkRequestPriority.NORMAL, paVar, handler);
        } else if (jVar.e() == AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodHEAD) {
            b2 = d2.a(jVar, AdobeNetworkRequestPriority.NORMAL, paVar, handler);
        } else {
            b2 = d2.b(jVar, str, AdobeNetworkRequestPriority.NORMAL, paVar, handler);
        }
        j.put(jVar, b2);
        b2.a(new qa(this, bVar));
        return b2;
    }

    public com.adobe.creativesdk.foundation.internal.net.j b(com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar, va vaVar, Handler handler, String str) {
        com.adobe.creativesdk.foundation.internal.net.j a2 = a((com.adobe.creativesdk.foundation.internal.storage.model.resources.b) fVar, AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodGET, (String) null, false);
        a2.b("Accept-Encoding", "");
        C c2 = new C(this, fVar, str, vaVar);
        if (str == null) {
            a(a2, fVar.i(), (byte[]) null, c2, handler);
        } else {
            a(a2, str, (byte[]) null, c2, handler);
        }
        return a2;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.yb
    public boolean b(C0231f c0231f) throws AdobeCSDKException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition newCondition = reentrantLock.newCondition();
        E e2 = new E(this);
        a(c0231f, new N(this, reentrantLock, e2, newCondition), (Handler) null);
        reentrantLock.lock();
        while (!e2.f5299a) {
            try {
                try {
                    newCondition.await();
                } catch (InterruptedException e3) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e3);
                }
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        reentrantLock.unlock();
        AdobeCSDKException adobeCSDKException = e2.f5300b;
        if (adobeCSDKException == null) {
            return true;
        }
        throw adobeCSDKException;
    }

    public com.adobe.creativesdk.foundation.internal.net.E b(C0231f c0231f, mb mbVar, Handler handler) {
        return a(c0231f, mbVar, handler);
    }

    public com.adobe.creativesdk.foundation.internal.storage.model.resources.f b(Fa fa, C0231f c0231f) {
        return C0333c.a(fa, c0231f);
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.xb
    public String b(String str) {
        if (str == null) {
            return null;
        }
        return "assets/" + str + "/";
    }

    public static AdobeAssetException a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        AdobeAssetException adobeAssetException = null;
        if (lVar == null) {
            adobeAssetException = com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorCancelled, null, null, -1, null);
        } else if (lVar.j()) {
            adobeAssetException = com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeNoStorageSpaceInDeviceToDownload, lVar.h(), lVar.c(), lVar.g(), lVar.e());
        } else if (lVar.g() == 412) {
            adobeAssetException = com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorConflictingChanges, lVar.h(), lVar.c(), lVar.g(), lVar.e());
        } else if (lVar.g() == 507) {
            adobeAssetException = com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorExceededQuota, lVar.h(), lVar.c(), lVar.g(), lVar.e());
        } else if (lVar.g() == 415) {
            adobeAssetException = com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorUnsupportedMedia, lVar.h(), lVar.c(), lVar.g(), lVar.e());
        } else if (lVar.g() == 404) {
            if (c.a.a.a.c.a.a.b().a() != null && !com.adobe.creativesdk.foundation.adobeinternal.net.a.c()) {
                adobeAssetException = com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorOffline, lVar.h(), lVar.c(), lVar.g(), lVar.e());
            }
        } else if (lVar.g() == 403) {
            adobeAssetException = com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorForbiddenRequest, lVar.h(), lVar.c(), lVar.g(), lVar.e());
        } else if (lVar.g() == 600) {
            adobeAssetException = com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorOffline, lVar.h(), lVar.c(), lVar.g(), lVar.e());
        }
        return adobeAssetException == null ? com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorUnexpectedResponse, lVar.h(), lVar.c(), lVar.g(), lVar.e()) : adobeAssetException;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.yb
    public hb b() {
        return this.l;
    }

    public static AdobeAssetException a(AdobeNetworkException adobeNetworkException) {
        com.adobe.creativesdk.foundation.internal.net.l lVar = null;
        if (adobeNetworkException.getErrorCode() == AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorOffline) {
            return com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorOffline, null, null, -1, null);
        }
        if (adobeNetworkException.getErrorCode() == AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorNoEnoughDeviceStorage) {
            return com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeNoStorageSpaceInDeviceToDownload, null, null, -1, null);
        }
        if (adobeNetworkException.getErrorCode() == AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorNotEntitledToService) {
            return com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorNotEntitledToService, null, null, -1, null);
        }
        if (adobeNetworkException.getErrorCode() == AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorTimeout) {
            return com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorTimeout, null, null, -1, null);
        }
        if (adobeNetworkException.getData() != null && adobeNetworkException.getData().containsKey("Response")) {
            lVar = (com.adobe.creativesdk.foundation.internal.net.l) adobeNetworkException.getData().get("Response");
        }
        return a(lVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.adobe.creativesdk.foundation.internal.net.j a(com.adobe.creativesdk.foundation.internal.storage.model.resources.f r5, java.lang.String r6) {
        /*
            r4 = this;
            java.lang.String r0 = "AssetStorage.requestMetadata"
            java.lang.String r1 = r5.g()     // Catch: java.net.MalformedURLException -> L28 java.net.URISyntaxException -> L31
            if (r1 != 0) goto Le
            java.net.URI r1 = r5.f6610b     // Catch: java.net.MalformedURLException -> L28 java.net.URISyntaxException -> L31
            java.lang.String r1 = r4.a(r1)     // Catch: java.net.MalformedURLException -> L28 java.net.URISyntaxException -> L31
        Le:
            com.adobe.creativesdk.foundation.internal.net.A r2 = r4.d(r1)     // Catch: java.net.MalformedURLException -> L28 java.net.URISyntaxException -> L31
            java.net.URI r3 = new java.net.URI     // Catch: java.net.MalformedURLException -> L28 java.net.URISyntaxException -> L31
            java.net.URL r2 = r2.a()     // Catch: java.net.MalformedURLException -> L28 java.net.URISyntaxException -> L31
            java.lang.String r2 = r2.toString()     // Catch: java.net.MalformedURLException -> L28 java.net.URISyntaxException -> L31
            java.lang.String r1 = com.adobe.creativesdk.foundation.internal.storage.model.util.g.a(r1, r2)     // Catch: java.net.MalformedURLException -> L28 java.net.URISyntaxException -> L31
            r3.<init>(r1)     // Catch: java.net.MalformedURLException -> L28 java.net.URISyntaxException -> L31
            java.net.URL r0 = r3.toURL()     // Catch: java.net.MalformedURLException -> L28 java.net.URISyntaxException -> L31
            goto L3a
        L28:
            r1 = move-exception
            com.adobe.creativesdk.foundation.internal.utils.logging.Level r2 = com.adobe.creativesdk.foundation.internal.utils.logging.Level.INFO
            java.lang.String r3 = "MalformedURLException"
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(r2, r0, r3, r1)
            goto L39
        L31:
            r1 = move-exception
            com.adobe.creativesdk.foundation.internal.utils.logging.Level r2 = com.adobe.creativesdk.foundation.internal.utils.logging.Level.INFO
            java.lang.String r3 = "URISyntaxException"
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(r2, r0, r3, r1)
        L39:
            r0 = 0
        L3a:
            com.adobe.creativesdk.foundation.internal.net.j r1 = new com.adobe.creativesdk.foundation.internal.net.j
            r1.<init>()
            r1.a(r0)
            com.adobe.creativesdk.foundation.internal.net.AdobeNetworkHttpRequestMethod r0 = com.adobe.creativesdk.foundation.internal.net.AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodGET
            r1.a(r0)
            if (r6 == 0) goto L52
            java.lang.String r5 = r5.f6613e
            if (r5 != 0) goto L4f
            java.lang.String r5 = "*"
        L4f:
            r1.b(r6, r5)
        L52:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.internal.storage.a.b.ra.a(com.adobe.creativesdk.foundation.internal.storage.model.resources.f, java.lang.String):com.adobe.creativesdk.foundation.internal.net.j");
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.adobe.creativesdk.foundation.internal.net.j a(com.adobe.creativesdk.foundation.internal.storage.model.resources.f r5, com.adobe.creativesdk.foundation.internal.storage.model.resources.a r6, java.lang.String r7) {
        /*
            r4 = this;
            java.lang.String r0 = "AssetStorage.requestRendition"
            java.lang.String r1 = "files"
            com.adobe.creativesdk.foundation.internal.net.A r1 = r4.c(r1)     // Catch: java.net.MalformedURLException -> L2e java.net.URISyntaxException -> L37
            java.lang.String r2 = r5.j()     // Catch: java.net.MalformedURLException -> L2e java.net.URISyntaxException -> L37
            java.lang.String r2 = com.adobe.creativesdk.foundation.internal.storage.model.util.i.a(r2, r6)     // Catch: java.net.MalformedURLException -> L2e java.net.URISyntaxException -> L37
            if (r2 != 0) goto L18
            java.net.URI r2 = r5.f6610b     // Catch: java.net.MalformedURLException -> L2e java.net.URISyntaxException -> L37
            java.lang.String r2 = r4.a(r2, r6)     // Catch: java.net.MalformedURLException -> L2e java.net.URISyntaxException -> L37
        L18:
            java.net.URI r3 = new java.net.URI     // Catch: java.net.MalformedURLException -> L2e java.net.URISyntaxException -> L37
            java.net.URL r1 = r1.a()     // Catch: java.net.MalformedURLException -> L2e java.net.URISyntaxException -> L37
            java.lang.String r1 = r1.toString()     // Catch: java.net.MalformedURLException -> L2e java.net.URISyntaxException -> L37
            java.lang.String r1 = com.adobe.creativesdk.foundation.internal.storage.model.util.g.a(r2, r1)     // Catch: java.net.MalformedURLException -> L2e java.net.URISyntaxException -> L37
            r3.<init>(r1)     // Catch: java.net.MalformedURLException -> L2e java.net.URISyntaxException -> L37
            java.net.URL r0 = r3.toURL()     // Catch: java.net.MalformedURLException -> L2e java.net.URISyntaxException -> L37
            goto L40
        L2e:
            r1 = move-exception
            com.adobe.creativesdk.foundation.internal.utils.logging.Level r2 = com.adobe.creativesdk.foundation.internal.utils.logging.Level.INFO
            java.lang.String r3 = "MalformedURLException"
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(r2, r0, r3, r1)
            goto L3f
        L37:
            r1 = move-exception
            com.adobe.creativesdk.foundation.internal.utils.logging.Level r2 = com.adobe.creativesdk.foundation.internal.utils.logging.Level.INFO
            java.lang.String r3 = "URISyntaxException"
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(r2, r0, r3, r1)
        L3f:
            r0 = 0
        L40:
            com.adobe.creativesdk.foundation.internal.net.j r1 = new com.adobe.creativesdk.foundation.internal.net.j
            r1.<init>()
            r1.a(r0)
            com.adobe.creativesdk.foundation.internal.net.AdobeNetworkHttpRequestMethod r0 = com.adobe.creativesdk.foundation.internal.net.AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodGET
            r1.a(r0)
            if (r7 == 0) goto L58
            java.lang.String r5 = r5.f6613e
            if (r5 != 0) goto L55
            java.lang.String r5 = "*"
        L55:
            r1.b(r7, r5)
        L58:
            java.lang.String r5 = r6.b()
            java.lang.String r6 = "Accept"
            r1.b(r6, r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.internal.storage.a.b.ra.a(com.adobe.creativesdk.foundation.internal.storage.model.resources.f, com.adobe.creativesdk.foundation.internal.storage.model.resources.a, java.lang.String):com.adobe.creativesdk.foundation.internal.net.j");
    }

    public void a(xa xaVar, Handler handler) {
        com.adobe.creativesdk.foundation.internal.net.A d2;
        if (c.a.a.a.a.a.a.b().a(new C0335e(this, handler, xaVar), "Getting the quota requires an authenticated user.")) {
            return;
        }
        URL url = null;
        try {
            d2 = d("/profile/quota");
        } catch (MalformedURLException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e2);
        }
        if (d2 == null) {
            return;
        }
        url = new URL(d2.a().toString() + "/profile/quota");
        com.adobe.creativesdk.foundation.internal.net.j jVar = new com.adobe.creativesdk.foundation.internal.net.j();
        jVar.a(url);
        jVar.a(AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodGET);
        a(jVar, (String) null, (byte[]) null, new C0339i(this, xaVar, handler), handler);
    }

    public com.adobe.creativesdk.foundation.internal.net.j a(C0533a c0533a, String str, wa waVar) {
        String name;
        int lastIndexOf;
        String uri = c0533a.getParentHref().toString();
        String validatedAssetName = C0533a.getValidatedAssetName(str);
        String str2 = null;
        if (validatedAssetName == null) {
            waVar.a(com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorBadRequest, (String) null));
            return null;
        }
        int lastIndexOf2 = validatedAssetName.lastIndexOf(".");
        String substring = lastIndexOf2 == -1 ? validatedAssetName : validatedAssetName.substring(0, lastIndexOf2);
        if ((c0533a instanceof AdobeAssetFile) && (lastIndexOf = (name = c0533a.getName()).lastIndexOf(".")) != -1) {
            str2 = name.substring(lastIndexOf);
        }
        if (str2 != null) {
            validatedAssetName = substring.concat(str2);
        }
        return b(uri.concat(validatedAssetName), c0533a, waVar);
    }

    public com.adobe.creativesdk.foundation.internal.net.j a(C0533a c0533a, wa waVar) {
        String uri = c0533a.getHref().toString();
        String str = "/archive/" + uri.substring(uri.substring(0, uri.length() - 1).lastIndexOf("/") + 1);
        if (str.endsWith("/")) {
            str = str.substring(0, str.length() - 1);
        }
        return b(str, c0533a, waVar);
    }

    public com.adobe.creativesdk.foundation.internal.net.j a(String str, C0533a c0533a, wa waVar) {
        String name = c0533a.getName();
        if (str.endsWith("/")) {
            str = str.substring(0, str.length() - 1);
        }
        return b(str + "/" + C0533a.getValidatedAssetName(name), c0533a, waVar);
    }

    public com.adobe.creativesdk.foundation.internal.net.j a(com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar, AdobeStoragePagingMode adobeStoragePagingMode, c.a.a.a.b<String> bVar, c.a.a.a.c<AdobeAssetException> cVar, Handler handler) {
        if (adobeStoragePagingMode == AdobeStoragePagingMode.AdobeStorageFirstPage) {
            eVar.n();
        } else {
            if (adobeStoragePagingMode == AdobeStoragePagingMode.AdobeStorageNextPageAppend || adobeStoragePagingMode == AdobeStoragePagingMode.AdobeStorageNextPageReplace) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "StorageSession.getDirectory", "Unexpected Paging mode");
            }
            if (!eVar.m()) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "StorageSession.getDirectory", "Specified Paging mode should only be used with an incomplete collection that was populated by a previous request");
            }
            eVar.c(eVar.g());
        }
        com.adobe.creativesdk.foundation.internal.net.j a2 = a((com.adobe.creativesdk.foundation.internal.storage.model.resources.b) eVar, AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodGET, eVar.f6613e != null && eVar.d() != null && adobeStoragePagingMode == AdobeStoragePagingMode.AdobeStorageFirstPage ? "If-None-Match" : null, false, (List<String>) null);
        a(a2, (String) null, (byte[]) null, new C0342l(this, eVar, bVar, cVar), handler);
        return a2;
    }

    public com.adobe.creativesdk.foundation.internal.net.j a(com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar, AdobeStoragePagingMode adobeStoragePagingMode, ta taVar) {
        Handler handler;
        try {
            handler = new Handler();
        } catch (Exception e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e2);
            handler = null;
        }
        return b(eVar, adobeStoragePagingMode, taVar, handler);
    }

    public com.adobe.creativesdk.foundation.internal.net.j a(com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar, ta taVar, Handler handler) {
        com.adobe.creativesdk.foundation.internal.net.j a2 = a((com.adobe.creativesdk.foundation.internal.storage.model.resources.b) eVar, AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodPUT, (String) null, true);
        a(a2, (String) null, (byte[]) null, new C0344n(this, eVar, taVar), handler);
        return a2;
    }

    public com.adobe.creativesdk.foundation.internal.net.j a(com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar, ta taVar) {
        Handler handler;
        try {
            handler = new Handler();
        } catch (Exception e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e2);
            handler = null;
        }
        return a(eVar, taVar, handler);
    }

    public com.adobe.creativesdk.foundation.internal.net.j a(com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar, boolean z, va vaVar, Handler handler) {
        String e2;
        com.adobe.creativesdk.foundation.internal.net.j a2 = a((com.adobe.creativesdk.foundation.internal.storage.model.resources.b) fVar, AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodPUT, fVar.f6613e == null ? null : "If-Match", true);
        if (fVar.f6612d == null && f() && (e2 = com.adobe.creativesdk.foundation.internal.storage.model.util.i.e(fVar.i())) != null) {
            a2.b(HttpHeaders.CONTENT_TYPE, e2);
        }
        if (z) {
            a2.b("If-Match", "*");
        }
        a(a2, fVar.i(), fVar.d(), new C0352w(this, fVar, vaVar), handler);
        return a2;
    }

    public com.adobe.creativesdk.foundation.internal.net.j a(com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar, boolean z, va vaVar) {
        Handler handler;
        try {
            handler = new Handler();
        } catch (Exception e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e2);
            handler = null;
        }
        return a(fVar, z, vaVar, handler);
    }

    public com.adobe.creativesdk.foundation.internal.net.j a(com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar, String str, ua uaVar) {
        Handler handler;
        try {
            handler = new Handler();
        } catch (Exception e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e2);
            handler = null;
        }
        return a(fVar, str, uaVar, handler);
    }

    public com.adobe.creativesdk.foundation.internal.net.j a(com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar, ua uaVar, Handler handler) {
        com.adobe.creativesdk.foundation.internal.net.j a2 = a(fVar, fVar.f6613e != null ? "If-None-Match" : null);
        a(a2, (String) null, (byte[]) null, new C0353x(this, uaVar), handler);
        return a2;
    }

    public com.adobe.creativesdk.foundation.internal.net.j a(com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar, String str, ua uaVar, Handler handler) {
        if (!str.equals(AdobeAssetFile.STREAMING_VIDEO_TYPE) && !str.startsWith("video/")) {
            uaVar.a((ua) new AdobeAssetException(AdobeAssetErrorCode.AdobeAssetErrorUnsupportedMedia));
            return null;
        }
        com.adobe.creativesdk.foundation.internal.storage.model.resources.a aVar = new com.adobe.creativesdk.foundation.internal.storage.model.resources.a();
        aVar.b(AdobeAssetFile.STREAMING_VIDEO_TYPE);
        com.adobe.creativesdk.foundation.internal.net.j b2 = b(fVar, aVar, fVar.f6613e != null ? "If-None-Match" : null);
        a(b2, (String) null, (byte[]) null, new C0354y(this, uaVar), handler);
        return b2;
    }

    public com.adobe.creativesdk.foundation.internal.net.E a(com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar, int i, String str, int i2, ua uaVar, Handler handler) {
        com.adobe.creativesdk.foundation.internal.storage.model.resources.a aVar = new com.adobe.creativesdk.foundation.internal.storage.model.resources.a();
        aVar.b(str);
        aVar.a(i2);
        if (i < 0) {
            i = 0;
        }
        aVar.b(i);
        return a(a(fVar, aVar, fVar.f6613e == null ? null : "If-None-Match"), fVar.i(), (byte[]) null, new C0355z(this, uaVar), handler);
    }

    public com.adobe.creativesdk.foundation.internal.net.E a(com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar, int i, String str, int i2, ua uaVar) {
        Handler handler;
        try {
            handler = new Handler();
        } catch (Exception e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e2);
            handler = null;
        }
        return a(fVar, i, str, i2, uaVar, handler);
    }

    public com.adobe.creativesdk.foundation.internal.net.j a(com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar, va vaVar, Handler handler, String str) {
        com.adobe.creativesdk.foundation.internal.net.j a2 = a((com.adobe.creativesdk.foundation.internal.storage.model.resources.b) fVar, AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodGET, fVar.f6613e == null ? null : "If-None-Match", false);
        if (a2 == null) {
            vaVar.a((va) new AdobeAssetException(AdobeAssetErrorCode.AdobeAssetErrorServiceDisconnected));
            return null;
        }
        a2.b("Accept-Encoding", "");
        A a3 = new A(this, fVar, str, vaVar);
        if (str == null) {
            a(a2, fVar.i(), (byte[]) null, a3, handler);
        } else {
            a(a2, str, (byte[]) null, a3, handler);
        }
        return a2;
    }

    public com.adobe.creativesdk.foundation.internal.net.j a(com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar, va vaVar, String str) {
        Handler handler;
        try {
            handler = new Handler();
        } catch (Exception e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e2);
            handler = null;
        }
        return b(fVar, vaVar, handler, str);
    }

    public com.adobe.creativesdk.foundation.internal.net.j a(com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar, va vaVar, Handler handler) {
        com.adobe.creativesdk.foundation.internal.net.j a2 = a((com.adobe.creativesdk.foundation.internal.storage.model.resources.b) fVar, AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodHEAD, (String) null, false);
        a2.b("Accept-Encoding", "");
        a(a2, fVar.i(), (byte[]) null, new F(this, fVar, vaVar), handler);
        return a2;
    }

    public com.adobe.creativesdk.foundation.internal.net.j a(com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar, va vaVar) {
        Handler handler;
        try {
            handler = new Handler();
        } catch (Exception e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e2);
            handler = null;
        }
        return a(fVar, vaVar, handler);
    }

    public com.adobe.creativesdk.foundation.internal.net.E a(C0231f c0231f, boolean z, mb mbVar, Handler handler) {
        URI uri;
        com.adobe.creativesdk.foundation.internal.storage.model.resources.f a2 = C0333c.a(c0231f);
        URI uri2 = a2.f6610b;
        if (uri2 != null && !uri2.toString().endsWith("/")) {
            try {
                uri = new URI(a2.f6610b.toString() + "/");
            } catch (URISyntaxException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e2);
                uri = null;
            }
            a2.f6610b = uri;
        }
        if (z) {
            a2.f6613e = null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("content");
        arrayList.add("X-Ordinal");
        com.adobe.creativesdk.foundation.internal.net.j a3 = a((com.adobe.creativesdk.foundation.internal.storage.model.resources.b) a2, AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodPUT, z ? "If-Match" : null, true, (List<String>) arrayList);
        return a(a3, (String) null, (byte[]) null, new G(this, mbVar, a3, a2, arrayList, c0231f), handler);
    }

    public boolean a(C0231f c0231f, boolean z) throws AdobeCSDKException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition newCondition = reentrantLock.newCondition();
        C0346p c0346p = new C0346p(this);
        a(c0231f, z, new H(this, reentrantLock, c0346p, newCondition), (Handler) null);
        reentrantLock.lock();
        while (!c0346p.f5459a) {
            try {
                try {
                    newCondition.await();
                } catch (InterruptedException e2) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e2);
                }
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        reentrantLock.unlock();
        AdobeCSDKException adobeCSDKException = c0346p.f5461c;
        if (adobeCSDKException == null) {
            return true;
        }
        throw adobeCSDKException;
    }

    public com.adobe.creativesdk.foundation.internal.net.E a(C0231f c0231f, mb mbVar, Handler handler) {
        com.adobe.creativesdk.foundation.internal.storage.model.resources.f a2 = C0333c.a(c0231f);
        URI uri = a2.f6610b;
        if (uri != null && !uri.toString().endsWith("/")) {
            URI uri2 = null;
            try {
                uri2 = new URI(a2.f6610b.toString() + "/");
            } catch (URISyntaxException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e2);
            }
            a2.f6610b = uri2;
        }
        com.adobe.creativesdk.foundation.internal.net.j a3 = a((com.adobe.creativesdk.foundation.internal.storage.model.resources.b) a2, AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodDELETE, "If-Match", false);
        try {
            try {
                a3.a(new URI(Za.c(a3.g().toString(), "?recursive=true")).toURL());
            } catch (MalformedURLException e3) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, ra.class.getSimpleName(), "Creation of URL failed", e3);
            }
        } catch (URISyntaxException e4) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, ra.class.getSimpleName(), "Creation of URL failed", e4);
        }
        return a(a3, a2.i(), a2.d(), new M(this, mbVar, handler, c0231f), handler);
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.yb
    public boolean a(C0231f c0231f) throws AdobeCSDKException {
        return b(c0231f);
    }

    public com.adobe.creativesdk.foundation.internal.net.E a(Fa fa, C0231f c0231f, boolean z, pb pbVar, Handler handler) {
        com.adobe.creativesdk.foundation.internal.storage.model.resources.f a2 = C0333c.a(fa, c0231f);
        a2.a(fa.q().getBytes(org.apache.commons.io.a.f29306f));
        if (z) {
            a2.f6613e = null;
        }
        com.adobe.creativesdk.foundation.internal.net.j a3 = a((com.adobe.creativesdk.foundation.internal.storage.model.resources.b) a2, AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodPUT, (a2.f6613e != null || z) ? "If-Match" : null, true);
        b q = new Q(this, pbVar, fa, c0231f);
        if (a2.i() != null && !new File(a2.i()).exists()) {
            AdobeDCXException adobeDCXException = new AdobeDCXException(AdobeDCXErrorCode.AdobeDCXErrorComponentReadFailure, "File " + a2.i() + " does not exist", null, null);
            if (handler != null) {
                handler.post(new S(this, pbVar, adobeDCXException));
            } else {
                new Thread(new T(this, pbVar, adobeDCXException)).start();
            }
            return null;
        }
        return a(a3, a2.i(), a2.d(), q, handler);
    }

    public Fa a(Fa fa, C0231f c0231f, boolean z) throws AdobeCSDKException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition newCondition = reentrantLock.newCondition();
        P p = new P(this);
        a(fa, c0231f, z, new U(this, reentrantLock, p, newCondition), (Handler) null);
        reentrantLock.lock();
        while (!p.f5333a) {
            try {
                try {
                    newCondition.await();
                } catch (InterruptedException e2) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e2);
                }
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        reentrantLock.unlock();
        AdobeCSDKException adobeCSDKException = p.f5335c;
        if (adobeCSDKException == null) {
            return p.f5334b;
        }
        throw adobeCSDKException;
    }

    public com.adobe.creativesdk.foundation.internal.net.E a(Fa fa, C0231f c0231f, pb pbVar, Handler handler) {
        if (fa == null) {
            fa = c0231f.w();
        }
        com.adobe.creativesdk.foundation.internal.storage.model.resources.f a2 = C0333c.a(fa, c0231f);
        return a(a((com.adobe.creativesdk.foundation.internal.storage.model.resources.b) a2, AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodGET, a2.f6613e != null ? "If-None-Match" : null, false), (String) null, (byte[]) null, new V(this, pbVar, c0231f), handler);
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.yb
    public Fa a(Fa fa, C0231f c0231f) throws AdobeCSDKException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition newCondition = reentrantLock.newCondition();
        ca caVar = new ca(this);
        a(fa, c0231f, new W(this, reentrantLock, caVar, newCondition), (Handler) null);
        reentrantLock.lock();
        while (!caVar.f5383a) {
            try {
                try {
                    newCondition.await();
                } catch (InterruptedException e2) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e2);
                }
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        reentrantLock.unlock();
        AdobeCSDKException adobeCSDKException = caVar.f5385c;
        if (adobeCSDKException == null) {
            return caVar.f5384b;
        }
        throw adobeCSDKException;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.yb
    public com.adobe.creativesdk.foundation.internal.net.E a(C0231f c0231f, vb vbVar, Handler handler) {
        com.adobe.creativesdk.foundation.internal.storage.model.resources.f a2 = C0333c.a(c0231f.w(), c0231f);
        return a(a((com.adobe.creativesdk.foundation.internal.storage.model.resources.b) a2, AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodHEAD, (String) null, false), (String) null, (byte[]) null, new X(this, vbVar, a2), handler);
    }

    public com.adobe.creativesdk.foundation.internal.net.E a(C0225c c0225c, C0231f c0231f, String str, boolean z, ib ibVar, Handler handler) {
        return a(c0225c, c0231f, str, z, ibVar, null, handler);
    }

    public com.adobe.creativesdk.foundation.internal.net.E a(C0225c c0225c, C0231f c0231f, String str, boolean z, ib ibVar, ud udVar, Handler handler) {
        com.adobe.creativesdk.foundation.internal.storage.model.resources.f a2 = C0333c.a(c0225c, c0231f, str, false);
        com.adobe.creativesdk.foundation.internal.net.j a3 = a((com.adobe.creativesdk.foundation.internal.storage.model.resources.b) a2, AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodPUT, (String) null, true);
        if (c0231f.m() == AdobeCollaborationType.ADOBE_COLLABORATION_TYPE_SHAREDWITHUSER) {
            Map<String, String> c2 = a3.c();
            if (a3.c() == null) {
                c2 = new HashMap<>();
            }
            c2.put("intermediates", "false");
            a3.b(c2);
        }
        if (!z) {
            a3.b("If-Match", "*");
        }
        b z2 = new Z(this, udVar, ibVar, str, c0225c);
        if (a2.i() != null && !new File(a2.i()).exists()) {
            AdobeDCXException adobeDCXException = new AdobeDCXException(AdobeDCXErrorCode.AdobeDCXErrorComponentReadFailure, "File " + a2.i() + " does not exist", null, null);
            if (handler != null) {
                handler.post(new aa(this, ibVar, adobeDCXException));
            } else {
                new Thread(new da(this, ibVar, adobeDCXException)).start();
            }
            return null;
        }
        return a(a3, a2.i(), a2.d(), z2, handler);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.adobe.creativesdk.foundation.internal.net.l a(com.adobe.creativesdk.foundation.internal.net.l lVar, com.adobe.creativesdk.foundation.internal.net.j jVar) {
        com.adobe.creativesdk.foundation.internal.net.l lVar2 = new com.adobe.creativesdk.foundation.internal.net.l();
        lVar2.a(jVar.g());
        String d2 = lVar.d();
        int indexOf = d2.indexOf("\r\n\r\n");
        if (indexOf != -1) {
            int i = indexOf + 4;
            if (i < d2.length()) {
                lVar2.a(ByteBuffer.wrap(d2.substring(i).getBytes(org.apache.commons.io.a.f29306f)));
            }
            d2 = d2.substring(0, i);
        }
        int indexOf2 = d2.indexOf("\r\n");
        if (indexOf2 == -1) {
            return null;
        }
        String[] split = d2.substring(0, indexOf2).split(" ");
        if (split.length < 2) {
            return null;
        }
        lVar2.c(Integer.parseInt(split[1]));
        int indexOf3 = d2.indexOf("\r\n\r\n");
        if (indexOf3 == -1) {
            indexOf3 = d2.length();
        }
        int i2 = indexOf2 + 2;
        if (indexOf3 > i2) {
            lVar2.a(com.adobe.creativesdk.foundation.internal.utils.n.c(d2.substring(i2)));
        }
        return lVar2;
    }

    public com.adobe.creativesdk.foundation.internal.net.E a(String str, C0225c c0225c, C0231f c0231f, boolean z, ib ibVar, Handler handler) {
        String str2;
        com.adobe.creativesdk.foundation.internal.net.j a2 = a((com.adobe.creativesdk.foundation.internal.storage.model.resources.b) C0333c.a(c0225c, c0231f, null, false), AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodPUT, (String) null, true);
        String query = a2.g().getQuery();
        if (query != null) {
            str2 = query + "&invocation_mode=sync,async";
        } else {
            str2 = "invocation_mode=sync,async";
        }
        String str3 = a2.g().toString().split("\\?")[0] + "?" + str2;
        URL g2 = a2.g();
        try {
            g2 = new URL(str3);
        } catch (MalformedURLException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e2);
        }
        a2.a(g2);
        if (c0231f.m() == AdobeCollaborationType.ADOBE_COLLABORATION_TYPE_SHAREDWITHUSER) {
            Map<String, String> c2 = a2.c();
            if (a2.c() == null) {
                c2 = new HashMap<>();
            }
            c2.put("intermediates", "false");
            a2.b(c2);
        }
        a2.b("Link", String.format("<%s>;rel=source", str));
        ea eaVar = new ea(this, c0225c, ibVar);
        C0351v c0351v = new C0351v(this);
        c0351v.f5480a = new C0350u(this, a2, handler, this).a(!z, null, new fa(this, this, handler, a2, z, c0351v, eaVar));
        return c0351v.f5480a;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.yb
    public com.adobe.creativesdk.foundation.internal.net.E a(C0225c c0225c, C0231f c0231f, String str, ib ibVar, Handler handler) {
        com.adobe.creativesdk.foundation.internal.storage.model.resources.f a2 = C0333c.a(c0225c, c0231f, str, true);
        com.adobe.creativesdk.foundation.internal.net.j a3 = a((com.adobe.creativesdk.foundation.internal.storage.model.resources.b) a2, AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodGET, (String) null, false);
        a3.b("Accept-Encoding", "");
        return a(a3, a2.i(), (byte[]) null, new ga(this, ibVar, c0225c), handler);
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.yb
    public com.adobe.creativesdk.foundation.internal.net.E a(String str, C0225c c0225c, C0231f c0231f, String str2, ib ibVar, Handler handler) {
        com.adobe.creativesdk.foundation.internal.storage.model.resources.f b2 = com.adobe.creativesdk.foundation.internal.storage.model.resources.f.b(str);
        b2.d(str2);
        return a(a((com.adobe.creativesdk.foundation.internal.storage.model.resources.b) b2, AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodGET, (String) null, false), b2.i(), (byte[]) null, new ha(this, c0225c, ibVar), handler);
    }

    public com.adobe.creativesdk.foundation.internal.net.E a(C0225c c0225c, C0231f c0231f, ib ibVar, Handler handler) {
        com.adobe.creativesdk.foundation.internal.net.j a2 = a((com.adobe.creativesdk.foundation.internal.storage.model.resources.b) C0333c.a(c0225c, c0231f, null, false), AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodDELETE, (String) null, false);
        a2.b("If-Match", "*");
        return a(a2, (String) null, (byte[]) null, new ia(this, ibVar, c0225c), handler);
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.xb
    public com.adobe.creativesdk.foundation.internal.storage.model.resources.e a(String str) {
        return com.adobe.creativesdk.foundation.internal.storage.model.resources.e.a(URI.create(b(str)));
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.xb
    public com.adobe.creativesdk.foundation.internal.net.E a(com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar, AdobeStoragePagingMode adobeStoragePagingMode, ta taVar, Handler handler) {
        if (adobeStoragePagingMode == AdobeStoragePagingMode.AdobeStorageFirstPage) {
            eVar.n();
        } else {
            eVar.c(eVar.g());
        }
        com.adobe.creativesdk.foundation.internal.net.j a2 = a((com.adobe.creativesdk.foundation.internal.storage.model.resources.b) eVar, AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodGET, eVar.f6613e != null && eVar.d() != null && adobeStoragePagingMode == AdobeStoragePagingMode.AdobeStorageFirstPage ? "If-None-Match" : null, false, (List<String>) null);
        if (a2 == null) {
            taVar.a((ta) new AdobeAssetException(AdobeAssetErrorCode.AdobeAssetErrorServiceDisconnected));
            return null;
        }
        return a(a2, (String) null, (byte[]) null, new la(this, taVar, eVar, adobeStoragePagingMode), handler);
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.yb
    public Handler a() {
        return this.m;
    }

    private String a(URI uri) {
        return String.format("%s/:metadata", uri);
    }

    private String a(URI uri, com.adobe.creativesdk.foundation.internal.storage.model.resources.a aVar) {
        return uri + "/:rendition" + aVar.a();
    }
}
