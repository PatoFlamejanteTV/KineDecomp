package com.adobe.creativesdk.foundation.adobeinternal.cloud;

import android.os.Handler;
import android.util.Base64;
import android.util.Log;
import com.adobe.creativesdk.foundation.adobeinternal.analytics.AdobeAnalyticsEventParams;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za;
import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIdentityManagementService;
import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthKeychain;
import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import org.json.JSONObject;

/* compiled from: AdobeCloudManager.java */
/* loaded from: classes.dex */
public class d implements Observer {

    /* renamed from: a, reason: collision with root package name */
    private static d f3947a;

    /* renamed from: d, reason: collision with root package name */
    private Object f3950d;

    /* renamed from: c, reason: collision with root package name */
    private boolean f3949c = false;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<AdobeCloud> f3951e = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private AdobeCloud f3948b = null;

    protected d() {
        this.f3950d = null;
        this.f3950d = new Object();
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeAuthLogoutNotification, this);
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeEntilementUserProfileDataFetchNotification, this);
    }

    public static boolean b(JSONObject jSONObject) {
        if (jSONObject.opt("public_cloud") != null) {
            return jSONObject.optBoolean("public_cloud");
        }
        return true;
    }

    private static String e(AdobeCloud adobeCloud) throws IOException {
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeCloudManager", "Adobe Cloud being saved to cache =" + adobeCloud.toString());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(adobeCloud);
        objectOutputStream.close();
        return new String(Base64.encode(byteArrayOutputStream.toByteArray(), 0), "UTF-8");
    }

    private AdobeCloud g() {
        ArrayList<AdobeCloud> arrayList = this.f3951e;
        if (arrayList == null || arrayList.isEmpty()) {
            f();
        }
        if (this.f3951e.size() == 1) {
            return this.f3951e.get(0);
        }
        Iterator<AdobeCloud> it = this.f3951e.iterator();
        while (it.hasNext()) {
            AdobeCloud next = it.next();
            if (!next.isPrivateCloud()) {
                return next;
            }
        }
        return null;
    }

    public AdobeCloud c() {
        try {
            return d();
        } catch (AdobeCloudException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, d.class.getSimpleName(), null, e2);
            return null;
        }
    }

    public AdobeCloud d() throws AdobeCloudException {
        AdobeCloudException adobeCloudException;
        AdobeCloud adobeCloud;
        if (this.f3948b == null) {
            if (c.a.a.a.a.a.a.b().d()) {
                String b2 = AdobeAuthKeychain.r().b("defaultCloud");
                if (b2 != null) {
                    try {
                        adobeCloud = a(b2);
                        adobeCloudException = null;
                    } catch (IOException | ClassNotFoundException e2) {
                        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, d.class.getSimpleName(), null, e2);
                        adobeCloudException = new AdobeCloudException(AdobeCloudErrorCode.ADOBE_CLOUD_ERROR_DECODE_FAILURE, "Failed to decode default cloud from AdobeAuthKeychain", null, e2);
                        adobeCloud = null;
                    }
                    if (adobeCloud != null && h.a(adobeCloud)) {
                        a(adobeCloud);
                        this.f3948b = adobeCloud;
                        com.adobe.creativesdk.foundation.internal.analytics.g.b(AdobeAnalyticsEventParams.Core.AdobeEventPropertyCloud.getValue(), this.f3948b.getHref());
                    } else {
                        if (adobeCloud != null) {
                            adobeCloudException = new AdobeCloudException(AdobeCloudErrorCode.ADOBE_CLOUD_ERROR_INVALID_CLOUD, "Invalid cloud", null, null);
                        }
                        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeCloudManager", "Should not hit this condition");
                        Za.a(d.class.getSimpleName(), "getDefaultCloudWithError", "default cloud error: " + Log.getStackTraceString(adobeCloudException), adobeCloud != null ? adobeCloud.toString() : null);
                        throw adobeCloudException;
                    }
                } else {
                    this.f3948b = g();
                    if (this.f3948b != null) {
                        com.adobe.creativesdk.foundation.internal.analytics.g.b(AdobeAnalyticsEventParams.Core.AdobeEventPropertyCloud.getValue(), this.f3948b.getHref());
                    } else {
                        Za.a(d.class.getSimpleName(), "getDefaultCloudWithError", "default cloud not found", null);
                        throw new AdobeCloudException(AdobeCloudErrorCode.ADOBE_CLOUD_ERROR_CLOUD_NOT_FOUND, "Default cloud not found", null, null);
                    }
                }
            } else {
                AdobeCloud adobeCloud2 = new AdobeCloud();
                adobeCloud2.setGUID("00000000-0000-0000-0000-000000000000");
                adobeCloud2.setName("Adobe Creative Cloud");
                adobeCloud2.setAvailable(true);
                adobeCloud2.setPrivateCloud(false);
                a(adobeCloud2);
                this.f3948b = adobeCloud2;
                com.adobe.creativesdk.foundation.internal.analytics.g.b(AdobeAnalyticsEventParams.Core.AdobeEventPropertyCloud.getValue(), this.f3948b.getHref());
            }
        }
        if (this.f3948b != null) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeCloudManager", "Getting default cloud =" + this.f3948b.toString());
        }
        String simpleName = d.class.getSimpleName();
        StringBuilder sb = new StringBuilder();
        sb.append("default cloud returned: ");
        AdobeCloud adobeCloud3 = this.f3948b;
        sb.append(adobeCloud3 == null ? null : adobeCloud3.getGUID());
        Za.a(simpleName, "getDefaultCloudWithError", sb.toString(), null);
        return this.f3948b;
    }

    protected void f() {
        ArrayList<AdobeCloud> b2 = b();
        if (b2 != null) {
            a(b2);
        }
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        ArrayList<AdobeCloud> arrayList = this.f3951e;
        if (arrayList != null) {
            hashMap.put("clouds", arrayList);
        }
        AdobeCloud adobeCloud = this.f3948b;
        if (adobeCloud != null) {
            hashMap.put("defaultCloud", adobeCloud);
        }
        return hashMap.toString();
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        com.adobe.creativesdk.foundation.internal.notification.c cVar = (com.adobe.creativesdk.foundation.internal.notification.c) obj;
        if (cVar.a() == AdobeInternalNotificationID.AdobeAuthLogoutNotification && cVar.b() == null) {
            Iterator<AdobeCloud> it = this.f3951e.iterator();
            while (it.hasNext()) {
                it.next().removeAllServices();
            }
            this.f3951e.clear();
            c(null);
            return;
        }
        if (cVar.a() == AdobeInternalNotificationID.AdobeEntilementUserProfileDataFetchNotification) {
            if (this.f3949c) {
                this.f3949c = false;
                return;
            }
            JSONObject jSONObject = (JSONObject) cVar.b().get("AdobeEntitlementSessionUserProfileData");
            boolean b2 = b(jSONObject);
            AdobeEntitlementServices.b().d();
            AdobeEntitlementServices.b().b(b2);
            boolean a2 = a(jSONObject);
            AdobeEntitlementServices.b().c();
            AdobeEntitlementServices.b().a(a2);
            ArrayList arrayList = new ArrayList();
            try {
                h.a(jSONObject, arrayList);
                boolean a3 = h.a(arrayList, f3947a.f3951e);
                if (arrayList.isEmpty() || a3) {
                    return;
                }
                a(arrayList);
            } catch (AdobeCSDKException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, d.class.getSimpleName(), null, e2);
            }
        }
    }

    private static AdobeCloud a(String str) throws IOException, ClassNotFoundException {
        j jVar = new j(new ByteArrayInputStream(Base64.decode(str.getBytes(org.apache.commons.io.a.f29306f), 0)));
        AdobeCloud adobeCloud = (AdobeCloud) jVar.readObject();
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeCloudManager", "Adobe Cloud being retrieved from cache =" + adobeCloud.toString());
        jVar.close();
        return adobeCloud;
    }

    public AdobeCloud b(AdobeCloud adobeCloud) {
        ArrayList<AdobeCloud> arrayList;
        if (adobeCloud != null && (arrayList = this.f3951e) != null && !arrayList.isEmpty()) {
            Iterator<AdobeCloud> it = this.f3951e.iterator();
            while (it.hasNext()) {
                AdobeCloud next = it.next();
                if (next.equals(adobeCloud)) {
                    return next;
                }
            }
        }
        return null;
    }

    public void c(AdobeCloud adobeCloud) {
        synchronized (this.f3950d) {
            if (adobeCloud != null) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeCloudManager", "Getting default cloud =" + adobeCloud.toString());
            }
            if (this.f3948b != null && adobeCloud != null) {
                boolean z = false;
                Iterator<AdobeCloud> it = this.f3951e.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (it.next().isStrictlyEqual(this.f3948b)) {
                        z = true;
                        break;
                    }
                }
                if (!adobeCloud.isStrictlyEqual(this.f3948b) && !z) {
                    this.f3948b.removeAllServices();
                }
            }
            this.f3948b = adobeCloud;
            if (this.f3948b != null) {
                com.adobe.creativesdk.foundation.internal.analytics.g.b(AdobeAnalyticsEventParams.Core.AdobeEventPropertyCloud.getValue(), this.f3948b.getHref());
            }
            if (c.a.a.a.a.a.a.b().d()) {
                if (adobeCloud != null) {
                    String str = null;
                    try {
                        str = e(adobeCloud);
                    } catch (IOException unused) {
                    }
                    AdobeAuthKeychain.r().a("defaultCloud", str);
                } else {
                    AdobeAuthKeychain.r().a("defaultCloud");
                }
                com.adobe.creativesdk.foundation.internal.notification.b.a().a(new com.adobe.creativesdk.foundation.internal.notification.c(AdobeInternalNotificationID.AdobeCloudManagerDefaultCloudUpdatedNotification, new HashMap()));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0047, code lost:            if (r2.isEmpty() == false) goto L17;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected java.util.ArrayList<com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud> b() {
        /*
            r6 = this;
            com.adobe.creativesdk.foundation.adobeinternal.entitlement.h r0 = com.adobe.creativesdk.foundation.adobeinternal.entitlement.h.k()
            org.json.JSONObject r0 = r0.l()
            com.adobe.creativesdk.foundation.internal.utils.logging.Level r1 = com.adobe.creativesdk.foundation.internal.utils.logging.Level.DEBUG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "The cached userprofile information = "
            r2.append(r3)
            if (r0 == 0) goto L1b
            java.lang.String r3 = r0.toString()
            goto L1d
        L1b:
            java.lang.String r3 = ""
        L1d:
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "AdobeCloudManager"
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(r1, r3, r2)
            r1 = 0
            if (r0 == 0) goto L4a
            java.util.ArrayList r2 = new java.util.ArrayList
            java.util.ArrayList<com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud> r4 = r6.f3951e
            r2.<init>(r4)
            com.adobe.creativesdk.foundation.adobeinternal.cloud.h.a(r0, r2)     // Catch: com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException -> L37
            goto L43
        L37:
            r0 = move-exception
            com.adobe.creativesdk.foundation.internal.utils.logging.Level r4 = com.adobe.creativesdk.foundation.internal.utils.logging.Level.DEBUG
            java.lang.Class<com.adobe.creativesdk.foundation.adobeinternal.cloud.d> r5 = com.adobe.creativesdk.foundation.adobeinternal.cloud.d.class
            java.lang.String r5 = r5.getSimpleName()
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(r4, r5, r1, r0)
        L43:
            boolean r0 = r2.isEmpty()
            if (r0 != 0) goto L4a
            goto L4b
        L4a:
            r2 = r1
        L4b:
            if (r2 == 0) goto L6b
            java.util.Iterator r0 = r2.iterator()
        L51:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L6b
            java.lang.Object r4 = r0.next()
            com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud r4 = (com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud) r4
            boolean r4 = com.adobe.creativesdk.foundation.adobeinternal.cloud.h.a(r4)
            if (r4 != 0) goto L51
            com.adobe.creativesdk.foundation.internal.utils.logging.Level r0 = com.adobe.creativesdk.foundation.internal.utils.logging.Level.DEBUG
            java.lang.String r2 = "Should not hit this condition"
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(r0, r3, r2)
            goto L6c
        L6b:
            r1 = r2
        L6c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.adobeinternal.cloud.d.b():java.util.ArrayList");
    }

    public static d e() {
        synchronized (d.class) {
            if (f3947a == null) {
                f3947a = new d();
                JSONObject l = com.adobe.creativesdk.foundation.adobeinternal.entitlement.h.k().l();
                if (l != null) {
                    boolean z = true;
                    try {
                        AdobeEntitlementServices.b().b(b(l));
                        z = a(l);
                    } catch (NullPointerException e2) {
                        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, d.class.getSimpleName(), null, e2);
                    }
                    AdobeEntitlementServices.b().a(z);
                    a(l, new ArrayList());
                }
            }
        }
        return f3947a;
    }

    public static void a(JSONObject jSONObject, List<AdobeCloud> list) {
        try {
            h.a(jSONObject, list);
            if (list.isEmpty()) {
                return;
            }
            f3947a.a(list);
        } catch (AdobeCSDKException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, d.class.getSimpleName(), null, e2);
        }
    }

    public static boolean a(JSONObject jSONObject) {
        if (jSONObject.opt("private_cloud") != null) {
            return jSONObject.optBoolean("private_cloud");
        }
        return true;
    }

    protected void a(AdobeCloud adobeCloud) {
        if (this.f3951e.contains(adobeCloud)) {
            return;
        }
        d(adobeCloud);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.util.List<com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud> r7) {
        /*
            r6 = this;
            int r0 = r7.size()
            java.util.ArrayList<com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud> r1 = r6.f3951e
            int r1 = r1.size()
            r2 = 1
            r3 = 0
            if (r0 != r1) goto L42
            java.util.Iterator r0 = r7.iterator()
        L12:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L3d
            java.lang.Object r1 = r0.next()
            com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud r1 = (com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud) r1
            java.util.ArrayList<com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud> r4 = r6.f3951e
            boolean r4 = r4.contains(r1)
            if (r4 != 0) goto L28
        L26:
            r0 = 0
            goto L3e
        L28:
            java.util.ArrayList<com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud> r4 = r6.f3951e
            int r4 = r4.indexOf(r1)
            java.util.ArrayList<com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud> r5 = r6.f3951e
            java.lang.Object r4 = r5.get(r4)
            com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud r4 = (com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud) r4
            boolean r1 = r4.isStrictlyEqual(r1)
            if (r1 != 0) goto L12
            goto L26
        L3d:
            r0 = 1
        L3e:
            if (r0 == 0) goto L42
            r0 = 0
            goto L43
        L42:
            r0 = 1
        L43:
            if (r0 == 0) goto La1
            int r0 = r7.size()
            if (r0 != r2) goto L64
            java.lang.Object r0 = r7.get(r3)
            com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud r0 = (com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud) r0
            r6.d(r0)
            com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud r0 = r6.c()
            if (r0 != 0) goto L87
            java.lang.Object r7 = r7.get(r3)
            com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud r7 = (com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud) r7
            r6.c(r7)
            goto L87
        L64:
            java.util.Iterator r7 = r7.iterator()
        L68:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L87
            java.lang.Object r0 = r7.next()
            com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud r0 = (com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud) r0
            r6.d(r0)
            com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud r1 = r6.c()
            if (r1 != 0) goto L68
            boolean r1 = r0.isPrivateCloud()
            if (r1 != 0) goto L68
            r6.c(r0)
            goto L68
        L87:
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            java.util.ArrayList<com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud> r0 = r6.f3951e
            java.lang.String r1 = "Clouds"
            r7.put(r1, r0)
            com.adobe.creativesdk.foundation.internal.notification.c r0 = new com.adobe.creativesdk.foundation.internal.notification.c
            com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID r1 = com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID.AdobeCloudManagerCloudsUpdatedNotification
            r0.<init>(r1, r7)
            com.adobe.creativesdk.foundation.internal.notification.b r7 = com.adobe.creativesdk.foundation.internal.notification.b.a()
            r7.a(r0)
        La1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.adobeinternal.cloud.d.a(java.util.List):void");
    }

    protected void d(AdobeCloud adobeCloud) {
        synchronized (this.f3950d) {
            if (!this.f3951e.contains(adobeCloud)) {
                this.f3951e.add(adobeCloud);
            } else {
                int indexOf = this.f3951e.indexOf(adobeCloud);
                if (!this.f3951e.get(indexOf).getEtag().equals(adobeCloud.getEtag())) {
                    this.f3951e.set(indexOf, adobeCloud);
                }
            }
        }
    }

    public void a(c.a.a.a.b<ArrayList<AdobeCloud>> bVar, c.a.a.a.c<AdobeCSDKException> cVar, Handler handler) {
        AdobeAuthIdentityManagementService K = AdobeAuthIdentityManagementService.K();
        this.f3949c = true;
        Za.a(d.class.getSimpleName(), "refreshClouds", "refreshClouds called: " + Arrays.toString(Thread.currentThread().getStackTrace()), null);
        com.adobe.creativesdk.foundation.adobeinternal.entitlement.h.k().a(K.c(), new b(this, this, bVar, cVar), new c(this, cVar), handler);
    }
}
