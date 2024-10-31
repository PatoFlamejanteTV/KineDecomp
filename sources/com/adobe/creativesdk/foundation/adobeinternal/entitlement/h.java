package com.adobe.creativesdk.foundation.adobeinternal.entitlement;

import android.content.SharedPreferences;
import android.os.Handler;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloudEndpoint;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloudServiceType;
import com.adobe.creativesdk.foundation.auth.k;
import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIdentityManagementService;
import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthKeychain;
import com.adobe.creativesdk.foundation.internal.cache.AdobeCommonCacheOptions;
import com.adobe.creativesdk.foundation.internal.cache.AdobeCommonCachePolicies;
import com.adobe.creativesdk.foundation.internal.cache.AdobeInvalidCacheSettingsException;
import com.adobe.creativesdk.foundation.internal.net.AdobeNetworkHttpRequestMethod;
import com.adobe.creativesdk.foundation.internal.net.AdobeNetworkRequestPriority;
import com.adobe.creativesdk.foundation.internal.net.E;
import com.adobe.creativesdk.foundation.internal.net.F;
import com.adobe.creativesdk.foundation.internal.net.j;
import com.adobe.creativesdk.foundation.internal.net.l;
import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Timer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdobeEntitlementSession.java */
/* loaded from: classes.dex */
public class h extends com.adobe.creativesdk.foundation.adobeinternal.cloud.g {
    private static h j;
    private SharedPreferences k;
    protected boolean l;
    private Timer m;

    public h(AdobeCloudEndpoint adobeCloudEndpoint) {
        super(adobeCloudEndpoint);
        g();
        a(AdobeInternalNotificationID.AdobeEntitlementServiceDisconnectedNotification);
        a(15L, false);
        this.l = false;
        this.k = c.a.a.a.c.a.a.b().a().getSharedPreferences("com.adobe.cc.entitlements", 0);
    }

    public static h k() {
        synchronized (h.class) {
            if (j == null) {
                j = b(o());
            }
        }
        return j;
    }

    private static AdobeCloudEndpoint o() {
        String str;
        int i = g.f3985a[AdobeAuthIdentityManagementService.K().w().ordinal()];
        if (i == 1) {
            str = "https://entitlements.adobe.io";
        } else {
            if (i != 2 && i != 3) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, h.class.getSimpleName(), "An undefined authentication endpoint has been specified.");
                return null;
            }
            str = "https://entitlements-stage.adobe.io";
        }
        try {
            return new AdobeCloudEndpoint(null, new URL(str), AdobeCloudServiceType.AdobeCloudServiceTypeEntitlement);
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (k.a().c() && com.adobe.creativesdk.foundation.adobeinternal.net.a.c()) {
            a(AdobeAuthIdentityManagementService.K().c(), (c.a.a.a.b<JSONObject>) null, (c.a.a.a.c<AdobeCSDKException>) null, (Handler) null);
        }
    }

    private void q() {
        if (this.m != null) {
            synchronized (this) {
                this.m.cancel();
                this.m = null;
            }
        }
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.cloud.g
    public void g() {
        String c2 = AdobeAuthKeychain.r().c();
        if (!m() && c2 != null && c2.length() > 0) {
            try {
                com.adobe.creativesdk.foundation.internal.cache.d.b().a("com.adobe.cc.entitlements", 100, 1.34217728E8d, EnumSet.of(AdobeCommonCachePolicies.AdobeCommonCacheEvictionLRU));
                e = null;
            } catch (AdobeInvalidCacheSettingsException e2) {
                e = e2;
            }
            if (e == null) {
                this.l = true;
            } else {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, h.class.getSimpleName(), null, e);
            }
        }
        a(43200000L);
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.cloud.g
    public void i() {
        if (com.adobe.creativesdk.foundation.internal.cache.d.b().a("com.adobe.cc.entitlements")) {
            com.adobe.creativesdk.foundation.internal.cache.d.b().b("com.adobe.cc.entitlements");
            if (!com.adobe.creativesdk.foundation.internal.cache.d.b().c("com.adobe.cc.entitlements")) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, h.class.getSimpleName(), "Removal of cache failed");
            }
        }
        this.l = false;
        q();
    }

    public JSONObject l() {
        String string;
        String c2 = AdobeAuthKeychain.r().c();
        b bVar = new b(this);
        if (c2 != null) {
            Date b2 = com.adobe.creativesdk.foundation.internal.cache.d.b().b(c2, "profile", "com.adobe.cc.entitlements");
            if (b2 != null) {
                if ((new Date().getTime() - b2.getTime()) / 1000 > 2592000) {
                    com.adobe.creativesdk.foundation.internal.cache.d.b().c(c2, "profile", "com.adobe.cc.entitlements");
                } else {
                    ReentrantLock reentrantLock = new ReentrantLock();
                    Condition newCondition = reentrantLock.newCondition();
                    com.adobe.creativesdk.foundation.internal.cache.d.b().c(c2, "profile", EnumSet.of(AdobeCommonCacheOptions.AdobeCommonCacheKeepInMemoryCache), "com.adobe.cc.entitlements", new a(this, reentrantLock, bVar, newCondition), null);
                    reentrantLock.lock();
                    while (!bVar.f3967a) {
                        try {
                            try {
                                newCondition.await();
                            } catch (InterruptedException e2) {
                                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeEntitlementSession.getUserProfileFromCache", e2.getMessage(), e2);
                            }
                        } finally {
                            reentrantLock.unlock();
                        }
                    }
                }
            }
            if (bVar.f3968b == null && (string = this.k.getString("profile", null)) != null) {
                try {
                    bVar.f3968b = new JSONObject(string);
                } catch (JSONException e3) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeEntitlement:Cache", "USER PROFILE CACHE READ FAILED FROM SHARED PREFS", e3);
                }
            }
        }
        return bVar.f3968b;
    }

    protected boolean m() {
        return this.l;
    }

    public void n() {
        a(o());
    }

    public static h b(AdobeCloudEndpoint adobeCloudEndpoint) {
        if (adobeCloudEndpoint == null) {
            adobeCloudEndpoint = o();
        }
        return new h(adobeCloudEndpoint);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AdobeCSDKException a(l lVar, String str, String str2) {
        AdobeNetworkException adobeNetworkException;
        if (lVar.g() == 400) {
            adobeNetworkException = new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorBadRequest);
        } else {
            adobeNetworkException = lVar.g() == 401 ? new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorAuthenticationFailed) : null;
        }
        return adobeNetworkException == null ? c.a.a.a.c.b.a.a(AdobeEntitlementErrorCode.AdobeEntitlementErrorUnexpectedResponse, null, str, str2) : adobeNetworkException;
    }

    private static String a(String str, String str2) {
        if (str.startsWith("/")) {
            str = str.substring(1);
        }
        if (str2.endsWith("/")) {
            str2 = str2.substring(0, str2.lastIndexOf("/"));
        }
        return str2 + "/" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("AdobeEntitlementSessionUserProfileData", jSONObject);
        hashMap.put("AdobeEntitlementSessionEndPoint", c());
        hashMap.put("AdobeEntitlementSessionAccessToken", str);
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(new com.adobe.creativesdk.foundation.internal.notification.c(AdobeInternalNotificationID.AdobeEntilementUserProfileDataFetchNotification, hashMap));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(JSONObject jSONObject, String str, c.a.a.a.b<JSONObject> bVar, Handler handler) {
        if (bVar != null) {
            if (handler != null) {
                handler.post(new c(this, bVar, jSONObject, str));
            } else {
                bVar.b(jSONObject);
                a(jSONObject, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(AdobeCSDKException adobeCSDKException, c.a.a.a.c<AdobeCSDKException> cVar, Handler handler) {
        if (cVar != null) {
            if (handler != null) {
                handler.post(new d(this, cVar, adobeCSDKException));
            } else {
                cVar.a(adobeCSDKException);
            }
        }
    }

    public E a(String str, c.a.a.a.b<JSONObject> bVar, c.a.a.a.c<AdobeCSDKException> cVar, Handler handler) {
        JSONObject l = l();
        URL url = null;
        if (!com.adobe.creativesdk.foundation.adobeinternal.net.a.c() || e() == null) {
            if (l != null) {
                a(l, str, bVar, handler);
            } else {
                a(new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorOffline), cVar, handler);
            }
            return null;
        }
        boolean z = l == null && k.a().c();
        try {
            url = new URL(a("/api/v2/profile", e().a().toString()));
        } catch (MalformedURLException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, h.class.getSimpleName(), null, e2);
        }
        j jVar = new j();
        jVar.a(url);
        jVar.a(AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodGET);
        return a(jVar, null, null, new e(this, str, bVar, handler, z, cVar, l), handler);
    }

    protected E a(j jVar, String str, byte[] bArr, F f2, Handler handler) {
        if (str == null) {
            jVar.a(bArr);
            return e().a(jVar, AdobeNetworkRequestPriority.NORMAL, f2, handler);
        }
        if (jVar.e() == AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodGET) {
            return e().a(jVar, str, AdobeNetworkRequestPriority.NORMAL, f2, handler);
        }
        return e().b(jVar, str, AdobeNetworkRequestPriority.NORMAL, f2, handler);
    }

    private void a(long j2) {
        if (this.m == null) {
            this.m = new Timer();
            this.m.scheduleAtFixedRate(new f(this), j2, j2);
        }
    }
}
