package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import android.os.Handler;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0225c;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.hb;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ib;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.pb;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.vb;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.zb;
import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIdentityManagementService;
import com.adobe.creativesdk.foundation.internal.net.AdobeNetworkHttpRequestMethod;
import com.adobe.creativesdk.foundation.internal.net.AdobeNetworkRequestPriority;
import com.adobe.creativesdk.foundation.internal.storage.a.b.C0333c;
import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.internal.storage.a.b.ta;
import com.adobe.creativesdk.foundation.internal.storage.a.b.ua;
import com.adobe.creativesdk.foundation.internal.storage.model.resources.AdobeStoragePagingMode;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetErrorCode;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.adobe.creativesdk.foundation.storage.AdobeCommunityAssetImageDimension;
import com.facebook.stetho.server.http.HttpHeaders;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: AdobeCommunitySession.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.library.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0287p extends com.adobe.creativesdk.foundation.adobeinternal.cloud.g implements zb {
    public static String j;
    private static Map<com.adobe.creativesdk.foundation.internal.net.j, com.adobe.creativesdk.foundation.internal.net.E> k = new HashMap();

    public C0287p() {
    }

    public static C0287p a(com.adobe.creativesdk.foundation.internal.net.A a2, String str) {
        C0287p c0287p = new C0287p(a2, str);
        if (c0287p.l() == null) {
            return null;
        }
        return c0287p;
    }

    private String b(C0225c c0225c, C0231f c0231f) {
        String str;
        try {
            str = URLEncoder.encode(c0225c.o(), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            str = null;
        }
        return Za.c(a(c0225c, c0231f), "version/" + str);
    }

    private AdobeNetworkException n() {
        return null;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.yb
    public Handler a() {
        return null;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.xb
    public com.adobe.creativesdk.foundation.internal.net.E a(com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar, AdobeStoragePagingMode adobeStoragePagingMode, ta taVar, Handler handler) {
        return null;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.yb
    public com.adobe.creativesdk.foundation.internal.net.E a(String str, C0225c c0225c, C0231f c0231f, String str2, ib ibVar, Handler handler) {
        return null;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.xb
    public com.adobe.creativesdk.foundation.internal.storage.model.resources.e a(String str) {
        return null;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.yb
    public boolean a(C0231f c0231f) throws AdobeCSDKException {
        return false;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.yb
    public hb b() {
        return null;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.xb
    public String b(String str) {
        return null;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.yb
    public boolean b(C0231f c0231f) throws AdobeCSDKException {
        return false;
    }

    String c(C0231f c0231f) {
        return Za.c(c0231f.r().toString(), "manifest");
    }

    String l() {
        String str = org.apache.commons.io.b.a() + "temp/CommunityPlatformSessionTemp";
        File file = new File(str);
        if (file.exists()) {
            return str;
        }
        if (!file.mkdirs()) {
            return null;
        }
        j = str;
        return str;
    }

    protected com.adobe.creativesdk.foundation.internal.net.A m() {
        return c((String) null);
    }

    C0287p(com.adobe.creativesdk.foundation.internal.net.A a2, String str) {
        super(a2, str);
    }

    public com.adobe.creativesdk.foundation.internal.net.E a(Fa fa, C0231f c0231f, pb pbVar, Handler handler) {
        URL url;
        try {
            url = new URL(c(c0231f));
        } catch (MalformedURLException unused) {
            url = null;
        }
        com.adobe.creativesdk.foundation.internal.net.j jVar = new com.adobe.creativesdk.foundation.internal.net.j();
        jVar.a(url);
        jVar.a(AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodGET);
        jVar.b("If-None-Match", fa != null ? fa.l() : null);
        jVar.b(io.fabric.sdk.android.services.common.a.HEADER_ACCEPT, "application/vnd.adobe.dcx-manifest+json");
        return a(jVar, (String) null, (byte[]) null, new C0279h(this, pbVar, c0231f), handler);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdobeAssetException a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        return a(lVar, (String) null);
    }

    public static AdobeAssetException a(com.adobe.creativesdk.foundation.internal.net.l lVar, String str) {
        AdobeAssetException adobeAssetException = null;
        if (lVar == null) {
            adobeAssetException = com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorCancelled, null, null, -1, null);
        } else if (lVar.g() == 412) {
            adobeAssetException = com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorConflictingChanges, lVar.h(), lVar.c(), lVar.g(), lVar.e());
        } else if (lVar.g() == 507) {
            adobeAssetException = com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorExceededQuota, lVar.h(), lVar.c(), lVar.g(), lVar.e());
        } else if (lVar.g() == 415) {
            adobeAssetException = com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorUnsupportedMedia, lVar.h(), lVar.c(), lVar.g(), lVar.e());
        } else if (lVar.g() == 404 && c.a.a.a.c.a.a.b().a() != null && !com.adobe.creativesdk.foundation.adobeinternal.net.a.c()) {
            adobeAssetException = com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorOffline, lVar.h(), lVar.c(), lVar.g(), lVar.e());
        }
        return adobeAssetException == null ? com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeAssetErrorCode.AdobeAssetErrorUnexpectedResponse, lVar.h(), lVar.c(), lVar.g(), lVar.e()) : adobeAssetException;
    }

    public com.adobe.creativesdk.foundation.internal.net.E a(com.adobe.creativesdk.foundation.internal.net.j jVar, String str, byte[] bArr, ra.b bVar, Handler handler) {
        com.adobe.creativesdk.foundation.internal.net.E b2;
        if (jVar == null) {
            bVar.a(new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorBadRequest));
            return null;
        }
        com.adobe.creativesdk.foundation.internal.net.A m = m();
        if (m == null) {
            if (bVar != null) {
                AdobeNetworkException adobeNetworkException = new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorNoCloudSpecified);
                if (handler != null) {
                    handler.post(new RunnableC0280i(this, bVar, adobeNetworkException));
                } else {
                    bVar.a(adobeNetworkException);
                }
            }
            return null;
        }
        AdobeNetworkException n = n();
        if (n != null) {
            if (bVar != null) {
                if (handler != null) {
                    handler.post(new RunnableC0281j(this, bVar, n));
                } else {
                    bVar.a(n);
                }
            }
            return null;
        }
        C0282k c0282k = new C0282k(this, jVar, bVar);
        m.a(AdobeAuthIdentityManagementService.K().c());
        if (str == null) {
            if (bArr != null) {
                jVar.a(bArr);
            }
            b2 = m.a(jVar, AdobeNetworkRequestPriority.NORMAL, c0282k, handler);
        } else if (jVar.e() == AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodGET) {
            b2 = m.a(jVar, str, AdobeNetworkRequestPriority.NORMAL, c0282k, handler);
        } else if (jVar.e() == AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodHEAD) {
            b2 = m.a(jVar, AdobeNetworkRequestPriority.NORMAL, c0282k, handler);
        } else {
            b2 = m.b(jVar, str, AdobeNetworkRequestPriority.NORMAL, c0282k, handler);
        }
        k.put(jVar, b2);
        b2.a(new C0283l(this, bVar));
        return b2;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.yb
    public com.adobe.creativesdk.foundation.internal.net.E a(C0231f c0231f, vb vbVar, Handler handler) {
        URL url;
        com.adobe.creativesdk.foundation.internal.storage.model.resources.f a2 = C0333c.a(c0231f.w(), c0231f);
        try {
            url = new URL(c(c0231f));
        } catch (MalformedURLException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "Community : ", e2.toString());
            url = null;
        }
        com.adobe.creativesdk.foundation.internal.net.j jVar = new com.adobe.creativesdk.foundation.internal.net.j();
        jVar.a(url);
        jVar.a(AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodHEAD);
        jVar.b(HttpHeaders.CONTENT_TYPE, "application/vnd.adobe.dcx-manifest+json");
        return a(jVar, (String) null, (byte[]) null, new C0284m(this, vbVar, a2), handler);
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.yb
    public Fa a(Fa fa, C0231f c0231f) throws AdobeDCXException, AdobeCSDKException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition newCondition = reentrantLock.newCondition();
        C0278g c0278g = new C0278g(this);
        a(fa, c0231f, new C0285n(this, reentrantLock, c0278g, newCondition), (Handler) null);
        reentrantLock.lock();
        while (!c0278g.f4614a) {
            try {
                try {
                    newCondition.await();
                } catch (InterruptedException e2) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "Community : ", e2.toString());
                }
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        reentrantLock.unlock();
        AdobeCSDKException adobeCSDKException = c0278g.f4616c;
        if (adobeCSDKException == null) {
            return c0278g.f4615b;
        }
        throw adobeCSDKException;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.yb
    public com.adobe.creativesdk.foundation.internal.net.E a(C0225c c0225c, C0231f c0231f, String str, ib ibVar, Handler handler) {
        URL url;
        try {
            url = new URL(b(c0225c, c0231f));
        } catch (Exception unused) {
            url = null;
        }
        com.adobe.creativesdk.foundation.internal.net.j jVar = new com.adobe.creativesdk.foundation.internal.net.j();
        jVar.a(url);
        jVar.a(AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodGET);
        return a(jVar, str, (byte[]) null, new C0286o(this, c0225c, ibVar), handler);
    }

    private String a(C0225c c0225c, C0231f c0231f) {
        return Za.c(c0231f.r().toString(), c0225c.a().substring(1));
    }

    public com.adobe.creativesdk.foundation.internal.net.E a(C0225c c0225c, C0231f c0231f, String str, AdobeCommunityAssetImageDimension adobeCommunityAssetImageDimension, int i, String str2, ua uaVar, Handler handler) {
        String sb;
        URL url;
        String str3;
        String substring = c0225c.a().substring(1);
        String path = c0231f.r().getPath();
        URI r = c0231f.r();
        if (path.substring(0, 11).equals("/content/2/")) {
            if (str2.equals("image/jpeg") || str2.equals("image/jpg")) {
                str3 = "jpg";
            } else {
                str3 = str2.equals("image/png") ? "png" : null;
            }
            if (!Pattern.compile("^\\/?content\\/2\\/[^\\/]+\\/[^\\/]+").matcher(path).matches()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(r.toString().substring(0, r.toString().lastIndexOf("/")));
                sb2.append("/rendition/");
                sb2.append(substring);
                sb2.append("/version/");
                sb2.append(c0225c.o().toString());
                sb2.append("/format/");
                sb2.append(str3);
                sb2.append("/dimension/");
                sb2.append(adobeCommunityAssetImageDimension == AdobeCommunityAssetImageDimension.AdobeCommunityAssetImageDimensionHeight ? "height" : "width");
                sb2.append("/size/");
                sb2.append(Integer.toString(i));
                sb = sb2.toString();
            }
            sb = null;
        } else {
            Matcher matcher = Pattern.compile("^\\\\/?api\\\\/v2\\\\/[^\\\\/]+\\\\/assets\\\\/[^\\\\/]+").matcher(path);
            if (!matcher.matches()) {
                try {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(r.toString().substring(matcher.start()));
                    sb3.append("/rendition/");
                    sb3.append(adobeCommunityAssetImageDimension == AdobeCommunityAssetImageDimension.AdobeCommunityAssetImageDimensionHeight ? "height/" : "width/");
                    sb3.append(Integer.toString(i));
                    sb3.append("/");
                    sb3.append(substring);
                    sb3.append("?version=");
                    sb3.append(c0225c.o());
                    sb = sb3.toString();
                } catch (IllegalStateException e2) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "Not able to form urlString", e2.getMessage());
                }
            }
            sb = null;
        }
        if (sb == null) {
            return null;
        }
        com.adobe.creativesdk.foundation.internal.net.j jVar = new com.adobe.creativesdk.foundation.internal.net.j();
        try {
            url = new URL(sb);
        } catch (MalformedURLException e3) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "CommunityServiceSession", e3.toString());
            url = null;
        }
        if (url != null) {
            jVar.a(url);
            jVar.a(AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodGET);
        }
        return a(jVar, str, (byte[]) null, new C0277f(this, uaVar), handler);
    }
}
