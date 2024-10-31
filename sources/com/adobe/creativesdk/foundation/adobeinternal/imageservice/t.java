package com.adobe.creativesdk.foundation.adobeinternal.imageservice;

import android.os.Handler;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloudEndpoint;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloudServiceType;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeEntitlementServices;
import com.adobe.creativesdk.foundation.adobeinternal.entitlement.AdobeEntitlementException;
import com.adobe.creativesdk.foundation.adobeinternal.storage.agc.AdobeAGCCreationType;
import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIdentityManagementService;
import com.adobe.creativesdk.foundation.internal.net.AdobeNetworkHttpRequestMethod;
import com.adobe.creativesdk.foundation.internal.net.AdobeNetworkRequestPriority;
import com.adobe.creativesdk.foundation.internal.net.C0322a;
import com.adobe.creativesdk.foundation.internal.net.E;
import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.sd;
import com.facebook.places.model.PlaceFields;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.share.internal.ShareConstants;
import com.facebook.stetho.server.http.HttpHeaders;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdobeImageSession.java */
/* loaded from: classes.dex */
public class t extends com.adobe.creativesdk.foundation.adobeinternal.cloud.g {
    private static String j = "t";
    private Map<com.adobe.creativesdk.foundation.internal.net.j, E> k;
    private String l;

    public t(AdobeCloudEndpoint adobeCloudEndpoint) {
        super(adobeCloudEndpoint);
        this.l = null;
        l();
        g();
        a(AdobeInternalNotificationID.AdobeImageServiceDisconnectedNotification);
        a(15L, false);
        this.k = new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AdobeNetworkException a(AdobeNetworkException.AdobeNetworkErrorCode adobeNetworkErrorCode, String str) {
        return null;
    }

    public static com.adobe.creativesdk.foundation.adobeinternal.cloud.g b(AdobeCloudEndpoint adobeCloudEndpoint) {
        if (adobeCloudEndpoint == null) {
            adobeCloudEndpoint = m();
        }
        return new t(adobeCloudEndpoint);
    }

    static boolean d(String str) {
        return !str.matches("(^[\\/]$|^\\/\\/.*)") && str.length() > 0;
    }

    protected static AdobeCloudEndpoint m() {
        String str;
        int i = j.f4019a[AdobeAuthIdentityManagementService.K().w().ordinal()];
        if (i == 1) {
            str = "https://cc-api-image.adobe.io";
        } else if (i == 2) {
            str = "https://cc-api-image-stage.adobe.io";
        } else if (i != 3) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, t.class.getSimpleName(), "An undefined authentication endpoint has been specified.");
            str = null;
        } else {
            str = "https://cc-api-image-labs.adobe.io";
        }
        try {
            return new AdobeCloudEndpoint("imageservices", str != null ? new URL(str) : null, AdobeCloudServiceType.AdobeCloudServiceTypeImage);
        } catch (MalformedURLException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, j, "", e2);
            return null;
        }
    }

    private AdobeNetworkException n() {
        AdobeEntitlementServices b2 = AdobeEntitlementServices.b();
        if (b2.a() == null || b2.a().optJSONObject(MessengerShareContentUtility.MEDIA_IMAGE) == null || b2.a().optJSONObject(MessengerShareContentUtility.MEDIA_IMAGE).optBoolean("entitled")) {
            return null;
        }
        return new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorNotEntitledToService);
    }

    private String o() {
        return org.apache.commons.io.c.a(this.l, "temp" + com.adobe.creativesdk.foundation.internal.storage.model.util.i.a());
    }

    String e(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, j, "", e2);
            return null;
        }
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.cloud.g
    public void g() {
    }

    protected synchronized String l() {
        String a2 = org.apache.commons.io.c.a(org.apache.commons.io.b.a(), "ImageSessionTemp");
        File file = new File(a2);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (file.exists()) {
            this.l = a2;
        }
        if (file.exists()) {
            return a2;
        }
        return null;
    }

    public E a(com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar, c cVar, v vVar, Handler handler) {
        if (fVar != null && a(fVar)) {
            b bVar = new b();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(MessengerShareContentUtility.MEDIA_IMAGE, fVar);
            } catch (JSONException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, j, "", e2);
            }
            bVar.a(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.putOpt("output", cVar);
            } catch (JSONException e3) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, j, "", e3);
            }
            bVar.c(jSONObject2);
            return a("introspect", bVar, vVar, handler);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("ADOBE_ASSET_DETAILS_STRING_KEY", "image null or not valid");
        a(new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorBadRequest, hashMap), vVar, handler);
        return null;
    }

    public com.adobe.creativesdk.foundation.internal.storage.model.resources.f a(com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar, String str, String str2) throws AdobeCSDKException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition newCondition = reentrantLock.newCondition();
        boolean[] zArr = {false};
        com.adobe.creativesdk.foundation.internal.storage.model.resources.f[] fVarArr = {null};
        AdobeCSDKException[] adobeCSDKExceptionArr = {null};
        a(fVar, str, str2, new k(this, reentrantLock, fVarArr, zArr, newCondition, adobeCSDKExceptionArr, fVar), null);
        reentrantLock.lock();
        while (!zArr[0]) {
            try {
                try {
                    newCondition.await();
                } catch (InterruptedException e2) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, j, "", e2);
                }
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        reentrantLock.unlock();
        if (adobeCSDKExceptionArr[0] == null) {
            return fVarArr[0];
        }
        throw adobeCSDKExceptionArr[0];
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00c1 A[Catch: MalformedURLException | URISyntaxException -> 0x00e4, URISyntaxException -> 0x00e6, TryCatch #5 {MalformedURLException | URISyntaxException -> 0x00e4, blocks: (B:32:0x00a2, B:34:0x00c1, B:35:0x00df), top: B:31:0x00a2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.adobe.creativesdk.foundation.internal.net.E a(com.adobe.creativesdk.foundation.internal.storage.model.resources.f r6, java.lang.String r7, java.lang.String r8, com.adobe.creativesdk.foundation.storage.sd<com.adobe.creativesdk.foundation.internal.storage.model.resources.f, com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException> r9, android.os.Handler r10) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.adobeinternal.imageservice.t.a(com.adobe.creativesdk.foundation.internal.storage.model.resources.f, java.lang.String, java.lang.String, com.adobe.creativesdk.foundation.storage.sd, android.os.Handler):com.adobe.creativesdk.foundation.internal.net.E");
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00d1 A[Catch: MalformedURLException | URISyntaxException -> 0x00f4, URISyntaxException -> 0x00f6, TryCatch #5 {MalformedURLException | URISyntaxException -> 0x00f4, blocks: (B:38:0x00b2, B:40:0x00d1, B:41:0x00ef), top: B:37:0x00b2 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.adobe.creativesdk.foundation.internal.net.E a(java.lang.String r6, com.adobe.creativesdk.foundation.internal.storage.model.resources.f r7, java.lang.String r8, boolean r9, com.adobe.creativesdk.foundation.storage.sd<com.adobe.creativesdk.foundation.internal.storage.model.resources.f, com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException> r10, android.os.Handler r11) {
        /*
            Method dump skipped, instructions count: 349
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.adobeinternal.imageservice.t.a(java.lang.String, com.adobe.creativesdk.foundation.internal.storage.model.resources.f, java.lang.String, boolean, com.adobe.creativesdk.foundation.storage.sd, android.os.Handler):com.adobe.creativesdk.foundation.internal.net.E");
    }

    public E a(com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar, Number number, String str, Number number2, Number number3, Number number4, AdobeImageFitType adobeImageFitType, Number number5, Number number6, String str2, c cVar, v vVar, Handler handler) {
        JSONObject jSONObject;
        if (fVar != null && a(fVar)) {
            b bVar = new b();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(MessengerShareContentUtility.MEDIA_IMAGE, fVar);
                bVar.a(jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                if (number2 != null) {
                    jSONObject = jSONObject2;
                    jSONObject3.put("scale", number2);
                } else {
                    jSONObject = jSONObject2;
                }
                if (number3 != null) {
                    jSONObject3.put("width", number3);
                }
                if (number4 != null) {
                    jSONObject3.put("height", number4);
                }
                if (adobeImageFitType != null) {
                    String a2 = a(adobeImageFitType);
                    if (a2 == null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("ADOBE_ASSET_DETAILS_STRING_KEY", "Unknown fit type");
                        a(new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorBadRequest, hashMap), vVar, handler);
                        return null;
                    }
                    jSONObject3.put("fit", a2);
                }
                if (number != null) {
                    jSONObject3.put("layerID", number);
                }
                if (str != null) {
                    jSONObject3.put("layerName", str);
                }
                if (number5 != null) {
                    jSONObject3.put("layerCompIndex", number5);
                }
                if (number6 != null) {
                    jSONObject3.put("layerCompID", number6);
                }
                if (str2 != null) {
                    jSONObject3.put("layerCompName", str2);
                }
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(MessengerShareContentUtility.MEDIA_IMAGE, cVar);
                bVar.b(jSONObject3);
                bVar.a(jSONObject);
                bVar.c(jSONObject4);
                return a("render", bVar, vVar, handler);
            } catch (JSONException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, j, "", e2);
                return null;
            }
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("ADOBE_ASSET_DETAILS_STRING_KEY", "image null or not valid");
        a(new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorBadRequest, hashMap2), vVar, handler);
        return null;
    }

    void a(AdobeNetworkException adobeNetworkException, v vVar, Handler handler) {
        r rVar = new r(this, vVar, adobeNetworkException);
        if (handler != null) {
            handler.post(rVar);
        } else {
            new Thread(rVar).start();
        }
    }

    void a(AdobeNetworkException adobeNetworkException, sd sdVar, Handler handler) {
        s sVar = new s(this, sdVar, adobeNetworkException);
        if (handler != null) {
            handler.post(sVar);
        } else {
            new Thread(sVar).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdobeNetworkException a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        if (lVar.g() == 400) {
            HashMap hashMap = new HashMap();
            hashMap.put(AdobeEntitlementException.AdobeNetworkHTTPStatusKey, 400);
            return new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorBadRequest, hashMap);
        }
        if (lVar.g() == 401) {
            return new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorAuthenticationFailed, null);
        }
        return null;
    }

    E a(String str, b bVar, v vVar, Handler handler) {
        if (e() == null) {
            if (vVar != null) {
                AdobeNetworkException adobeNetworkException = new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorNoCloudSpecified);
                if (handler != null) {
                    handler.post(new e(this, vVar, adobeNetworkException));
                } else {
                    vVar.a(adobeNetworkException);
                }
            } else {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, t.class.getSimpleName(), "Adobe cloud not specified.");
            }
            return null;
        }
        AdobeNetworkException n = n();
        if (n != null) {
            if (vVar == null) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, t.class.getSimpleName(), "Entitlement Check failed", n);
            } else if (handler != null) {
                handler.post(new f(this, vVar, n));
            } else {
                vVar.a(n);
            }
            return null;
        }
        String o = o();
        String o2 = o();
        com.adobe.creativesdk.foundation.internal.net.j a2 = bVar.a(str, e().a(), o2);
        E a3 = e().a(a2, o, AdobeNetworkRequestPriority.NORMAL, new g(this, o, bVar, o2, a2, vVar), handler);
        this.k.put(a2, a3);
        a3.a(new h(this, vVar));
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, String str2) {
        File file = new File(str);
        if (file.exists() && !file.delete()) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, j, "unable to delete " + str);
        }
        File file2 = new File(str2);
        if (!file2.exists() || file2.delete()) {
            return;
        }
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, j, "unable to delete " + str2);
    }

    private static String a(AdobeImageFitType adobeImageFitType) {
        switch (j.f4025g[adobeImageFitType.ordinal()]) {
            case 1:
                return "fit";
            case 2:
                return "constrain";
            case 3:
                return "crop";
            case 4:
                return "wrap";
            case 5:
                return "stretch";
            case 6:
                return "hfit";
            case 7:
                return "vfit";
            default:
                return null;
        }
    }

    static boolean a(com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar) {
        URI uri = fVar.f6610b;
        if (uri != null) {
            return d(uri.toString());
        }
        return fVar.i() == null || new File(fVar.i()).exists();
    }

    public com.adobe.creativesdk.foundation.internal.net.j a(com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar, com.adobe.creativesdk.foundation.adobeinternal.storage.agc.b bVar, com.adobe.creativesdk.foundation.adobeinternal.storage.agc.a aVar, boolean z, Handler handler, v vVar) {
        return a(fVar, bVar, AdobeAGCCreationType.ADOBE_AGC_CREATION_TYPE_PSD, aVar, z, handler, vVar);
    }

    private com.adobe.creativesdk.foundation.internal.net.j a(com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar, com.adobe.creativesdk.foundation.adobeinternal.storage.agc.b bVar, AdobeAGCCreationType adobeAGCCreationType, com.adobe.creativesdk.foundation.adobeinternal.storage.agc.a aVar, boolean z, Handler handler, v vVar) {
        HashMap hashMap;
        ArrayList<C0322a> arrayList;
        String format;
        String str;
        String str2;
        try {
            hashMap = new HashMap();
            arrayList = new ArrayList<>();
            format = String.format("Boundary_%s", com.adobe.creativesdk.foundation.internal.storage.model.util.i.a());
            String format2 = String.format("cid:%s@adobe.com", com.adobe.creativesdk.foundation.internal.storage.model.util.i.a());
            C0322a c0322a = new C0322a();
            c0322a.b(bVar.a());
            c0322a.a(bVar.b().toString().getBytes("UTF-8"));
            c0322a.a(format2);
            arrayList.add(c0322a);
            hashMap.put("manifest", format2);
        } catch (UnsupportedEncodingException e2) {
            e = e2;
        } catch (MalformedURLException e3) {
            e = e3;
        } catch (JSONException e4) {
            e = e4;
        }
        try {
            if (aVar == null) {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                for (String str3 : hashMap.keySet()) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(ShareConstants.WEB_DIALOG_PARAM_HREF, hashMap.get(str3));
                    jSONObject2.put(str3, jSONObject3);
                }
                int i = j.f4026h[adobeAGCCreationType.ordinal()];
                if (i == 1) {
                    str = "aifile";
                    str2 = "createai";
                } else if (i != 2) {
                    str = "unknown";
                    str2 = null;
                } else {
                    str = MessengerShareContentUtility.MEDIA_IMAGE;
                    str2 = "createpsd";
                }
                jSONObject.put("inputs", jSONObject2);
                String uri = fVar.f6610b.toString();
                if (!uri.startsWith("/")) {
                    uri = "/" + uri;
                }
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("disposition", PlaceFields.LOCATION);
                jSONObject4.put(PlaceFields.LOCATION, uri);
                if (z) {
                    jSONObject4.put("If-Match", "!");
                }
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put(str, jSONObject4);
                jSONObject.put("outputs", jSONObject5);
                com.adobe.creativesdk.foundation.internal.net.j jVar = new com.adobe.creativesdk.foundation.internal.net.j(new URL(e().a() + "/" + str2), AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodPOST, null);
                jVar.b(HttpHeaders.CONTENT_TYPE, String.format("multipart/related; boundary=%s", format));
                byte[] bytes = jSONObject.toString().getBytes("UTF-8");
                C0322a c0322a2 = new C0322a();
                c0322a2.b("application/vnd.adobe.image-operation+json");
                c0322a2.a(bytes);
                arrayList.add(0, c0322a2);
                e().a(jVar, format, arrayList, new i(this, fVar, str, vVar), handler);
                return jVar;
            }
            aVar.a();
            throw null;
        } catch (UnsupportedEncodingException e5) {
            e = e5;
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, j, "", e);
            return null;
        } catch (MalformedURLException e6) {
            e = e6;
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, j, "", e);
            return null;
        } catch (JSONException e7) {
            e = e7;
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, j, "", e);
            return null;
        }
    }
}
