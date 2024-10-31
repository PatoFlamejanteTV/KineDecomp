package com.adobe.creativesdk.foundation.internal.collaboration;

import android.net.Uri;
import android.os.Handler;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloudServiceType;
import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIMSEnvironment;
import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIdentityManagementService;
import com.adobe.creativesdk.foundation.internal.net.A;
import com.adobe.creativesdk.foundation.internal.net.AdobeNetworkHttpRequestMethod;
import com.adobe.creativesdk.foundation.internal.net.AdobeNetworkRequestPriority;
import com.adobe.creativesdk.foundation.internal.net.E;
import com.adobe.creativesdk.foundation.internal.net.l;
import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.facebook.internal.NativeProtocol;
import com.facebook.stetho.server.http.HttpHeaders;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdobeCollaborationSession.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static h f4999a;

    /* renamed from: b, reason: collision with root package name */
    private static AdobeAuthIMSEnvironment f5000b;

    /* renamed from: c, reason: collision with root package name */
    private static b f5001c;

    /* renamed from: d, reason: collision with root package name */
    private static String f5002d;

    /* renamed from: e, reason: collision with root package name */
    private static Map<com.adobe.creativesdk.foundation.internal.net.j, E> f5003e;

    /* renamed from: f, reason: collision with root package name */
    private A f5004f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AdobeCollaborationSession.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(l lVar);

        void a(AdobeNetworkException adobeNetworkException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AdobeCollaborationSession.java */
    /* loaded from: classes.dex */
    public class b implements Observer {
        private b() {
        }

        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            com.adobe.creativesdk.foundation.internal.notification.c cVar = (com.adobe.creativesdk.foundation.internal.notification.c) obj;
            if (cVar.a() != AdobeInternalNotificationID.AdobeAuthLoginNotification && cVar.a() != AdobeInternalNotificationID.AdobeAuthLoginExternalNotification) {
                if (cVar.a() == AdobeInternalNotificationID.AdobeAuthLogoutNotification) {
                    A d2 = h.this.d();
                    d2.b();
                    d2.g();
                    d2.a((String) null);
                    j.a().c();
                    return;
                }
                return;
            }
            AdobeAuthIdentityManagementService K = AdobeAuthIdentityManagementService.K();
            A d3 = h.this.d();
            d3.a(K.c());
            d3.a(false);
            j.a().b();
        }

        /* synthetic */ b(h hVar, f fVar) {
            this();
        }
    }

    private h() {
        synchronized (h.class) {
            if (f5001c == null) {
                f5001c = new b(this, null);
            }
        }
    }

    public static h c() {
        h hVar;
        synchronized (h.class) {
            if (f4999a == null) {
                f4999a = new h();
                AdobeAuthIdentityManagementService K = AdobeAuthIdentityManagementService.K();
                String c2 = K.c();
                f5000b = K.w();
                String str = null;
                HashMap hashMap = new HashMap();
                int i = e.f4996a[f5000b.ordinal()];
                if (i == 1) {
                    str = "https://cc-collab-dev.adobe.io";
                } else if (i == 2) {
                    str = "https://cc-collab-stage.adobe.io";
                    hashMap.put("x-api-key", K.h());
                } else if (i != 3) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "Collaboration Session", "An undefined authentication endpoint has been specified for the collaboration session");
                } else {
                    str = "https://cc-collab.adobe.io";
                    hashMap.put("x-api-key", K.h());
                }
                e();
                f5003e = new HashMap();
                A a2 = new A(str, K.h(), hashMap);
                a2.a(c2);
                f4999a.a(a2);
                a2.a(j.a());
                com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeAuthLoginNotification, f5001c);
                com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeAuthLogoutNotification, f5001c);
                com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeAuthLoginExternalNotification, f5001c);
            }
            hVar = f4999a;
        }
        return hVar;
    }

    private static void e() {
        com.adobe.creativesdk.foundation.adobeinternal.cloud.d e2 = com.adobe.creativesdk.foundation.adobeinternal.cloud.d.e();
        if (e2 != null && e2.c() != null) {
            ra raVar = (ra) e2.c().getSessionForService(AdobeCloudServiceType.AdobeCloudServiceTypeStorage);
            if (raVar != null) {
                f5002d = raVar.e().d().toString();
                return;
            } else {
                f();
                return;
            }
        }
        f();
    }

    private static void f() {
        int i = e.f4996a[f5000b.ordinal()];
        if (i == 2) {
            f5002d = "https://cc-api-storage-stage.adobe.io";
            return;
        }
        if (i == 3) {
            f5002d = "https://cc-api-storage.adobe.io";
        } else if (i != 5) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, ra.class.getSimpleName(), "An undefined authentication endpoint has been specified.");
        } else {
            f5002d = "https://cc-api-storage-labs.adobe.io";
        }
    }

    public A d() {
        return this.f5004f;
    }

    private com.adobe.creativesdk.foundation.internal.net.j b(String str, AdobeNetworkHttpRequestMethod adobeNetworkHttpRequestMethod, String str2, String str3, a aVar) {
        if (a(str)) {
            return null;
        }
        if (!a(str2) && a(str3)) {
            return null;
        }
        try {
            com.adobe.creativesdk.foundation.internal.net.j jVar = new com.adobe.creativesdk.foundation.internal.net.j();
            jVar.a(new URI(this.f5004f.a().toString() + "/" + str).toURL());
            jVar.a(adobeNetworkHttpRequestMethod);
            if (str2 != null) {
                jVar.b(io.fabric.sdk.android.services.common.a.HEADER_ACCEPT, str3);
                jVar.b(HttpHeaders.CONTENT_TYPE, str3);
            }
            if (str2 == null) {
                str2 = null;
            }
            a(jVar, null, str2, aVar);
            return jVar;
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
            return null;
        } catch (URISyntaxException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public h a(A a2) {
        this.f5004f = a2;
        return this;
    }

    public com.adobe.creativesdk.foundation.internal.net.j a(String str, String str2, com.adobe.creativesdk.foundation.internal.collaboration.a.c cVar) {
        if (str == null) {
            cVar.a(com.adobe.creativesdk.foundation.internal.collaboration.a.a(AdobeCollaborationErrorCode.ADOBE_COLLABORATION_ERROR_INVALID_FOLDER, null, "Invalid Folder"));
            return null;
        }
        if (str2 != null && str2.length() != 0) {
            return a(String.format("collaborators%s?user=%s", Uri.encode(str).replace("%2F", "/"), str2), AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodDELETE, new g(this, cVar));
        }
        cVar.a(com.adobe.creativesdk.foundation.internal.collaboration.a.a(AdobeCollaborationErrorCode.ADOBE_COLLABORATION_ERROR_INVALID_USER_ID, null, "Invalid User ID"));
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.adobe.creativesdk.foundation.internal.net.j a(java.lang.String r9, java.lang.String r10, com.adobe.creativesdk.foundation.internal.collaboration.a.b r11) {
        /*
            r8 = this;
            r0 = 400(0x190, float:5.6E-43)
            r1 = 0
            if (r9 != 0) goto L9
            r11.onError(r0)
            return r1
        L9:
            java.lang.String r2 = "application/vnd.adobe"
            boolean r2 = r10.contains(r2)
            java.lang.String r3 = "links%s"
            r4 = 0
            r5 = 1
            if (r2 != 0) goto L1f
            java.lang.Object[] r10 = new java.lang.Object[r5]
            r10[r4] = r9
            java.lang.String r9 = java.lang.String.format(r3, r10)
        L1d:
            r3 = r9
            goto L67
        L1f:
            java.lang.String r2 = "vnd.adobe.directory"
            boolean r2 = r10.contains(r2)
            if (r2 == 0) goto L30
            java.lang.Object[] r10 = new java.lang.Object[r5]
            r10[r4] = r9
            java.lang.String r9 = java.lang.String.format(r3, r10)
            goto L1d
        L30:
            java.lang.String r2 = "vnd.adobe.library"
            boolean r2 = r10.contains(r2)
            if (r2 != 0) goto L40
            java.lang.String r2 = "vnd.adobe.element"
            boolean r10 = r10.contains(r2)
            if (r10 == 0) goto L66
        L40:
            int[] r10 = com.adobe.creativesdk.foundation.internal.collaboration.e.f4996a
            com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIMSEnvironment r2 = com.adobe.creativesdk.foundation.internal.collaboration.h.f5000b
            int r2 = r2.ordinal()
            r10 = r10[r2]
            r2 = 2
            if (r10 == r2) goto L55
            r3 = 3
            if (r10 == r3) goto L52
            r10 = r1
            goto L57
        L52:
            java.lang.String r10 = "https://cc-api-storage.adobe.io"
            goto L57
        L55:
            java.lang.String r10 = "https://cc-api-storage-stage.adobe.io"
        L57:
            if (r10 == 0) goto L66
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r4] = r10
            r2[r5] = r9
            java.lang.String r9 = "links/%s/assets/adobe-libraries/%s"
            java.lang.String r9 = java.lang.String.format(r9, r2)
            goto L1d
        L66:
            r3 = r1
        L67:
            if (r3 != 0) goto L6d
            r11.onError(r0)
            return r1
        L6d:
            com.adobe.creativesdk.foundation.internal.collaboration.b r7 = new com.adobe.creativesdk.foundation.internal.collaboration.b
            r7.<init>(r8, r11)
            com.adobe.creativesdk.foundation.internal.net.AdobeNetworkHttpRequestMethod r4 = com.adobe.creativesdk.foundation.internal.net.AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodGET
            r5 = 0
            r6 = 0
            r2 = r8
            com.adobe.creativesdk.foundation.internal.net.j r9 = r2.a(r3, r4, r5, r6, r7)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.internal.collaboration.h.a(java.lang.String, java.lang.String, com.adobe.creativesdk.foundation.internal.collaboration.a.b):com.adobe.creativesdk.foundation.internal.net.j");
    }

    public com.adobe.creativesdk.foundation.internal.net.j a(String str, String str2, String str3, boolean z, boolean z2, com.adobe.creativesdk.foundation.internal.collaboration.a.b bVar) {
        if (str == null) {
            bVar.onError(400);
            return null;
        }
        c cVar = new c(this, bVar);
        if (!str2.contains("application/vnd.adobe")) {
            str2 = "application/vnd.adobe.asset";
        } else if (str2.contains("vnd.adobe.directory")) {
            str2 = "application/x-sharedcloud-collection+json";
        } else if (str2.contains("vnd.adobe.library") || str2.contains("vnd.adobe.element")) {
            int i = e.f4996a[f5000b.ordinal()];
            String str4 = i != 2 ? i != 3 ? null : "https://cc-api-storage.adobe.io" : "https://cc-api-storage-stage.adobe.io";
            str = str4 != null ? String.format("%s/assets/adobe-libraries/%s", str4, str) : null;
            if (str2.contains("vnd.adobe.library")) {
                str2 = "application/vnd.adobe.library+dcx";
            }
        } else {
            str = null;
            str2 = null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("download", z);
            jSONObject.put("comment", z2);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("resource", str);
            jSONObject2.put("name", str3);
            jSONObject2.put("resourceType", str2);
            jSONObject2.put(NativeProtocol.RESULT_ARGS_PERMISSIONS, jSONObject);
            String jSONObject3 = jSONObject2.toString();
            if (jSONObject3 != null) {
                return a("links", AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodPOST, jSONObject3, io.fabric.sdk.android.services.common.a.ACCEPT_JSON_VALUE, cVar);
            }
            return null;
        } catch (JSONException unused) {
            bVar.onError(400);
            return null;
        }
    }

    private com.adobe.creativesdk.foundation.internal.net.j a(String str, AdobeNetworkHttpRequestMethod adobeNetworkHttpRequestMethod, a aVar) {
        return b(str, adobeNetworkHttpRequestMethod, null, null, aVar);
    }

    private com.adobe.creativesdk.foundation.internal.net.j a(String str, AdobeNetworkHttpRequestMethod adobeNetworkHttpRequestMethod, String str2, String str3, a aVar) {
        if (a(str)) {
            return null;
        }
        if (!a(str2) && a(str3)) {
            return null;
        }
        try {
            com.adobe.creativesdk.foundation.internal.net.j jVar = new com.adobe.creativesdk.foundation.internal.net.j();
            jVar.a(new URI(this.f5004f.a().toString() + "/" + str).toURL());
            jVar.a(adobeNetworkHttpRequestMethod);
            if (str2 != null) {
                jVar.b(io.fabric.sdk.android.services.common.a.HEADER_ACCEPT, str3);
                jVar.b(HttpHeaders.CONTENT_TYPE, str3);
            }
            jVar.b("X-Feature-Override", "publish_link_backward");
            if (str2 == null) {
                str2 = null;
            }
            a(jVar, null, str2, aVar);
            return jVar;
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
            return null;
        } catch (URISyntaxException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    private com.adobe.creativesdk.foundation.internal.net.j a(com.adobe.creativesdk.foundation.internal.net.j jVar, String str, String str2, a aVar) {
        Handler handler;
        E b2;
        try {
            handler = new Handler();
        } catch (Exception unused) {
            handler = null;
        }
        Handler handler2 = handler;
        d dVar = new d(this, jVar, aVar);
        if (str == null) {
            if (str2 != null) {
                jVar.a(str2.getBytes(org.apache.commons.io.a.f29306f));
            }
            b2 = this.f5004f.a(jVar, AdobeNetworkRequestPriority.NORMAL, dVar, handler2);
        } else if (jVar.e() == AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodGET) {
            b2 = this.f5004f.a(jVar, str, AdobeNetworkRequestPriority.NORMAL, dVar, handler2);
        } else if (jVar.e() == AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodHEAD) {
            b2 = this.f5004f.a(jVar, AdobeNetworkRequestPriority.NORMAL, dVar, handler2);
        } else {
            b2 = this.f5004f.b(jVar, str, AdobeNetworkRequestPriority.NORMAL, dVar, handler2);
        }
        f5003e.put(jVar, b2);
        return jVar;
    }

    private boolean a(String str) {
        return str == null || str.length() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AdobeCollaborationException a(l lVar) {
        if (lVar == null) {
            return null;
        }
        AdobeCollaborationException a2 = lVar.g() == 401 ? com.adobe.creativesdk.foundation.internal.collaboration.a.a(AdobeCollaborationErrorCode.ADOBE_COLLABORATION_ERROR_UNAUTHORIZED, lVar.h(), lVar.c(), lVar.g(), lVar.e()) : null;
        return a2 == null ? com.adobe.creativesdk.foundation.internal.collaboration.a.a(AdobeCollaborationErrorCode.ADOBE_COLLABORATION_ERROR_UNEXPECTED_RESPONSE, lVar.h(), lVar.c(), lVar.g(), lVar.e()) : a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public l a(AdobeNetworkException adobeNetworkException) {
        if (adobeNetworkException.getData() == null || !adobeNetworkException.getData().containsKey("Response")) {
            return null;
        }
        return (l) adobeNetworkException.getData().get("Response");
    }
}
