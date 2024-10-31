package com.adobe.creativesdk.foundation.storage;

import android.os.Handler;
import com.adobe.creativesdk.foundation.adobeinternal.analytics.AdobeAnalyticsEventParams;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0225c;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0233g;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0235h;
import com.adobe.creativesdk.foundation.adobeinternal.storage.library.C0289s;
import com.adobe.creativesdk.foundation.internal.storage.a.b.C0333c;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.facebook.GraphResponse;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdobeLibraryComposite.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.ub, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0614ub {

    /* renamed from: a, reason: collision with root package name */
    private String f7438a;

    /* renamed from: b, reason: collision with root package name */
    protected AdobeCollaborationType f7439b;

    /* renamed from: c, reason: collision with root package name */
    private ReentrantLock f7440c;

    /* renamed from: d, reason: collision with root package name */
    private int f7441d;

    /* renamed from: e, reason: collision with root package name */
    private String f7442e;

    /* renamed from: f, reason: collision with root package name */
    private JSONObject f7443f;

    /* renamed from: g, reason: collision with root package name */
    protected C0231f f7444g;

    /* renamed from: h, reason: collision with root package name */
    protected com.adobe.creativesdk.foundation.adobeinternal.storage.library.D f7445h;
    protected C0235h i;

    /* JADX INFO: Access modifiers changed from: protected */
    public C0614ub(String str, com.adobe.creativesdk.foundation.adobeinternal.storage.library.D d2, String str2) throws AdobeLibraryException {
        a(str, d2, str2);
    }

    private String f(String str) throws AdobeLibraryException {
        String e2 = this.f7445h.e();
        if (e2 != null) {
            String d2 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.d(e2, str);
            if (new File(d2).mkdirs()) {
                return d2;
            }
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, C0614ub.class.getSimpleName(), "Failed to create library directory");
            throw com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorLocalLibraryCreateFailure, null, d2, null);
        }
        throw com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorStartupFailure, null, null, null);
    }

    private boolean g(String str) throws AdobeLibraryException {
        Gb f2 = Gb.f();
        if (f2 != null && f2.i()) {
            String f3 = this.f7445h.f();
            if (f3 == null) {
                return false;
            }
            this.f7442e = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.d(f3, str);
            if (new File(this.f7442e).exists() || new File(this.f7442e).mkdirs()) {
                return true;
            }
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, C0614ub.class.getSimpleName(), "Failed to create library renditions directory");
            throw com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorLocalLibraryCreateFailure, null, this.f7442e, null);
        }
        throw com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorStartupFailure, null, null, null);
    }

    private String h(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String trim = str.trim();
        if (trim == null || trim.length() <= 0) {
            return null;
        }
        return trim;
    }

    private boolean x() throws AdobeLibraryException {
        boolean z = false;
        if (a()) {
            return false;
        }
        v();
        try {
            z = this.f7444g.c();
            e = null;
        } catch (AdobeDCXException e2) {
            e = e2;
        }
        if (z) {
            this.f7445h.b(this);
            this.i = this.f7444g.p().i();
            return true;
        }
        throw com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorLibraryFailedToSave, e, null, null);
    }

    private String y() {
        String e2 = this.f7445h.e();
        if (e2 != null) {
            return com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.d(e2, this.f7438a);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na b(C0622wb c0622wb) {
        if (c0622wb == null) {
            return null;
        }
        if (c0622wb instanceof C0626xb) {
            return c0622wb.b();
        }
        return this.f7444g.p().c(c0622wb.c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean c() throws AdobeLibraryException {
        s();
        C0231f c0231f = this.f7444g;
        if (c0231f != null) {
            if (c0231f.I()) {
                try {
                    this.f7444g.p().p();
                    this.f7444g.c();
                } catch (AdobeDCXException e2) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeLibraryComposite.deleteLibrary", "library deletion failed", e2);
                }
            } else {
                try {
                    this.f7444g.M();
                    this.f7444g = null;
                } catch (AdobeDCXException e3) {
                    throw com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorLocalLibraryDoesNotExist, e3, null, this.f7444g.k());
                }
            }
        }
        a(this.f7438a);
        u();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean d(String str) {
        if (c(str) == null) {
            return false;
        }
        if (this.f7443f == null) {
            return true;
        }
        this.f7440c.lock();
        try {
            JSONObject optJSONObject = this.f7443f.optJSONObject(str);
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String optString = optJSONObject.optString(keys.next());
                    if (optString != null && optString.charAt(0) != '/') {
                        String c2 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.c(this.f7442e, optString);
                        if (!org.apache.commons.io.b.c(new File(c2))) {
                            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, C0614ub.class.getSimpleName(), "Failed to delete rendition cache: " + c2, null);
                        }
                    }
                }
            }
            this.f7443f.remove(str);
            this.f7440c.unlock();
            w();
            return true;
        } catch (Throwable th) {
            this.f7440c.unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(String str) throws AdobeLibraryException {
        if (a()) {
            return;
        }
        this.f7440c.lock();
        try {
            if (this.f7444g != null) {
                b();
                C0235h p = this.f7444g.p();
                if (p != null) {
                    p.e(h(str));
                }
                try {
                    d();
                } catch (AdobeLibraryException e2) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeLibraryComposite.setName", "failed in endChanges", e2);
                }
            }
        } finally {
            this.f7440c.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public C0231f i() {
        return this.f7444g;
    }

    protected com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na j() throws AdobeLibraryException {
        C0231f c0231f = this.f7444g;
        if (c0231f == null || c0231f.p() == null) {
            return null;
        }
        return a((C0233g) this.f7444g.p());
    }

    public String k() {
        return this.f7438a;
    }

    public double l() {
        return ((Number) this.f7444g.p().a("library#modified")).doubleValue() / 1000.0d;
    }

    public String m() {
        C0235h p;
        this.f7440c.lock();
        try {
            return (this.f7444g == null || (p = this.f7444g.p()) == null) ? null : p.j();
        } finally {
            this.f7440c.unlock();
        }
    }

    public int n() {
        List<com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na> a2;
        this.f7440c.lock();
        int i = 0;
        try {
            try {
                com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na j = j();
                if (j != null && (a2 = this.f7444g.p().a(j)) != null) {
                    i = a2.size();
                }
            } catch (AdobeLibraryException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeLibraryComposite.getTotalElementCount", "count fetching failed", e2);
            }
            return i;
        } finally {
            this.f7440c.unlock();
        }
    }

    public int o() {
        C0235h p;
        Object a2;
        this.f7440c.lock();
        try {
            return (this.f7444g == null || (p = this.f7444g.p()) == null || (a2 = p.a("library#version")) == null) ? 0 : ((Integer) a2).intValue();
        } finally {
            this.f7440c.unlock();
        }
    }

    public boolean p() {
        com.adobe.creativesdk.foundation.adobeinternal.storage.library.D d2 = this.f7445h;
        if (d2 != null) {
            return d2.g();
        }
        return false;
    }

    public boolean q() {
        if (i() != null) {
            return i().J();
        }
        return false;
    }

    public boolean r() {
        if (i() != null) {
            return i().K();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s() {
        this.f7440c.lock();
    }

    void t() {
        this.f7440c.lock();
        try {
            String a2 = com.adobe.creativesdk.foundation.internal.storage.model.util.g.a("library.plist", this.f7442e);
            if (new File(a2).exists()) {
                try {
                    this.f7443f = new JSONObject(new String(org.apache.commons.io.b.g(new File(a2)), "UTF-8")).optJSONObject("renditions");
                } catch (IOException | JSONException e2) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, C0614ub.class.getSimpleName(), null, e2);
                }
            }
            if (this.f7443f == null) {
                this.f7443f = new JSONObject();
            }
        } finally {
            this.f7440c.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u() {
        this.f7440c.unlock();
    }

    void v() {
        this.f7444g.p().a(Long.valueOf(com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a()), "library#modified");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean w() {
        /*
            r5 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r5.f7440c
            r0.lock()
            java.lang.String r0 = "library.plist"
            java.lang.String r1 = r5.f7442e     // Catch: java.lang.Throwable -> L8a
            java.lang.String r0 = com.adobe.creativesdk.foundation.internal.storage.model.util.g.a(r0, r1)     // Catch: java.lang.Throwable -> L8a
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L8a
            r1.<init>()     // Catch: java.lang.Throwable -> L8a
            r2 = 0
            java.lang.String r3 = "renditions"
            org.json.JSONObject r4 = r5.f7443f     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4d org.json.JSONException -> L4f
            r1.put(r3, r4)     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4d org.json.JSONException -> L4f
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4d org.json.JSONException -> L4f
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4d org.json.JSONException -> L4f
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4d org.json.JSONException -> L4f
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4d org.json.JSONException -> L4f
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4d org.json.JSONException -> L4f
            java.nio.charset.Charset r3 = org.apache.commons.io.a.f29306f     // Catch: java.io.IOException -> L46 org.json.JSONException -> L48 java.lang.Throwable -> L76
            byte[] r1 = r1.getBytes(r3)     // Catch: java.io.IOException -> L46 org.json.JSONException -> L48 java.lang.Throwable -> L76
            r0.write(r1)     // Catch: java.io.IOException -> L46 org.json.JSONException -> L48 java.lang.Throwable -> L76
            r0.close()     // Catch: java.io.IOException -> L46 org.json.JSONException -> L48 java.lang.Throwable -> L76
            r0.close()     // Catch: java.io.IOException -> L38 java.lang.Throwable -> L8a
            goto L44
        L38:
            r0 = move-exception
            com.adobe.creativesdk.foundation.internal.utils.logging.Level r1 = com.adobe.creativesdk.foundation.internal.utils.logging.Level.DEBUG     // Catch: java.lang.Throwable -> L8a
            java.lang.Class<com.adobe.creativesdk.foundation.storage.ub> r3 = com.adobe.creativesdk.foundation.storage.C0614ub.class
            java.lang.String r3 = r3.getSimpleName()     // Catch: java.lang.Throwable -> L8a
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(r1, r3, r2, r0)     // Catch: java.lang.Throwable -> L8a
        L44:
            r0 = 1
            goto L70
        L46:
            r1 = move-exception
            goto L51
        L48:
            r1 = move-exception
            goto L51
        L4a:
            r1 = move-exception
            r0 = r2
            goto L77
        L4d:
            r1 = move-exception
            goto L50
        L4f:
            r1 = move-exception
        L50:
            r0 = r2
        L51:
            com.adobe.creativesdk.foundation.internal.utils.logging.Level r3 = com.adobe.creativesdk.foundation.internal.utils.logging.Level.DEBUG     // Catch: java.lang.Throwable -> L76
            java.lang.Class<com.adobe.creativesdk.foundation.storage.ub> r4 = com.adobe.creativesdk.foundation.storage.C0614ub.class
            java.lang.String r4 = r4.getSimpleName()     // Catch: java.lang.Throwable -> L76
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(r3, r4, r2, r1)     // Catch: java.lang.Throwable -> L76
            r1 = 0
            if (r0 == 0) goto L6f
            r0.close()     // Catch: java.io.IOException -> L63 java.lang.Throwable -> L8a
            goto L6f
        L63:
            r0 = move-exception
            com.adobe.creativesdk.foundation.internal.utils.logging.Level r3 = com.adobe.creativesdk.foundation.internal.utils.logging.Level.DEBUG     // Catch: java.lang.Throwable -> L8a
            java.lang.Class<com.adobe.creativesdk.foundation.storage.ub> r4 = com.adobe.creativesdk.foundation.storage.C0614ub.class
            java.lang.String r4 = r4.getSimpleName()     // Catch: java.lang.Throwable -> L8a
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(r3, r4, r2, r0)     // Catch: java.lang.Throwable -> L8a
        L6f:
            r0 = 0
        L70:
            java.util.concurrent.locks.ReentrantLock r1 = r5.f7440c
            r1.unlock()
            return r0
        L76:
            r1 = move-exception
        L77:
            if (r0 == 0) goto L89
            r0.close()     // Catch: java.io.IOException -> L7d java.lang.Throwable -> L8a
            goto L89
        L7d:
            r0 = move-exception
            com.adobe.creativesdk.foundation.internal.utils.logging.Level r3 = com.adobe.creativesdk.foundation.internal.utils.logging.Level.DEBUG     // Catch: java.lang.Throwable -> L8a
            java.lang.Class<com.adobe.creativesdk.foundation.storage.ub> r4 = com.adobe.creativesdk.foundation.storage.C0614ub.class
            java.lang.String r4 = r4.getSimpleName()     // Catch: java.lang.Throwable -> L8a
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(r3, r4, r2, r0)     // Catch: java.lang.Throwable -> L8a
        L89:
            throw r1     // Catch: java.lang.Throwable -> L8a
        L8a:
            r0 = move-exception
            java.util.concurrent.locks.ReentrantLock r1 = r5.f7440c
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.storage.C0614ub.w():boolean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public C0614ub(C0231f c0231f, com.adobe.creativesdk.foundation.adobeinternal.storage.library.D d2, String str) throws AdobeLibraryException {
        a(c0231f, d2, str);
    }

    boolean a(String str) {
        String f2 = this.f7445h.f();
        if (f2 == null) {
            return false;
        }
        this.f7442e = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.d(f2, str);
        return org.apache.commons.io.b.c(new File(this.f7442e));
    }

    public ArrayList<C0622wb> b(AbstractC0618vb abstractC0618vb) {
        return a(true, abstractC0618vb);
    }

    public int h() {
        ArrayList<C0622wb> e2 = e();
        if (e2 == null) {
            return 0;
        }
        return e2.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public C0614ub(String str, com.adobe.creativesdk.foundation.adobeinternal.storage.library.D d2) throws AdobeLibraryException {
        a(str, d2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject b(String str) {
        this.f7440c.lock();
        try {
            JSONObject optJSONObject = this.f7443f.optJSONObject(str);
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
                try {
                    this.f7443f.put(str, optJSONObject);
                } catch (JSONException e2) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, C0614ub.class.getSimpleName(), null, e2);
                }
            }
            return optJSONObject;
        } finally {
            this.f7440c.unlock();
        }
    }

    void a(String str, com.adobe.creativesdk.foundation.adobeinternal.storage.library.D d2) throws AdobeLibraryException {
        com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na na;
        com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na na2;
        String h2 = h(str);
        if (h2 != null) {
            this.f7445h = d2;
            this.f7441d = 0;
            this.f7440c = new ReentrantLock();
            String a2 = com.adobe.creativesdk.foundation.internal.storage.model.util.i.a();
            String f2 = f(a2);
            try {
                this.f7444g = C0231f.a(h2, "application/vnd.adobe.library+dcx", null, a2, f2.endsWith("/") ? f2.substring(0, f2.lastIndexOf("/")) : f2, null);
                e = null;
            } catch (AdobeDCXException e2) {
                e = e2;
            }
            C0231f c0231f = this.f7444g;
            if (c0231f != null) {
                c0231f.a(false);
                this.f7438a = this.f7444g.n();
                C0235h p = this.f7444g.p();
                try {
                    na = p.a(MessengerShareContentUtility.ELEMENTS, null, null, null, null, 0L);
                } catch (AdobeDCXException e3) {
                    e = e3;
                    na = null;
                }
                if (na != null) {
                    try {
                        na2 = p.a("categories", null, null, null, null, 1L);
                    } catch (AdobeDCXException e4) {
                        e = e4;
                        na2 = null;
                    }
                    if (na2 != null) {
                        p.a((Object) 1, "library#version");
                        long a3 = com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a();
                        p.a(Long.valueOf(a3), "library#created");
                        p.a(Long.valueOf(a3), "library#modified");
                        this.i = this.f7444g.p().i();
                        x();
                        this.f7443f = new JSONObject();
                        g(a2);
                        return;
                    }
                    throw com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorLibraryCreateFailure, e, null, null);
                }
                throw com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorLibraryCreateFailure, e, null, null);
            }
            throw com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorLibraryCreateFailure, e, null, null);
        }
        throw com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorBadParameter, null, null, null);
    }

    public AdobeCollaborationType f() {
        C0231f c0231f = this.f7444g;
        if (c0231f != null) {
            return c0231f.m();
        }
        return AdobeCollaborationType.ADOBE_COLLABORATION_TYPE_PRIVATE;
    }

    public AdobeCollaborationRoleType g() {
        return i().l();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        this.f7441d++;
    }

    public ArrayList<C0622wb> e() {
        return a(false, (AbstractC0618vb) null);
    }

    public C0622wb c(String str) {
        C0231f c0231f;
        com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na c2;
        if (str == null || (c0231f = this.f7444g) == null || c0231f.p() == null || (c2 = this.f7444g.p().c(str)) == null || !Gb.f().e(c2.f())) {
            return null;
        }
        return new C0626xb(c2, this);
    }

    public C0622wb e(C0622wb c0622wb) throws AdobeLibraryException {
        if (a()) {
            return null;
        }
        C0289s c0289s = new C0289s("deleteElement", this, c0622wb, null);
        com.adobe.creativesdk.foundation.internal.analytics.k kVar = new com.adobe.creativesdk.foundation.internal.analytics.k(AdobeAnalyticsEventParams.Type.AdobeEventTypeAppDelete.getValue());
        kVar.a(c0622wb.c(), c0622wb.e(), "", "libray_element", "");
        s();
        b();
        d(c0622wb.c());
        com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na b2 = b(c0622wb);
        this.f7444g.p().c(b2);
        if (b2 != null) {
            this.f7444g.N();
            u();
            d();
            kVar.a(GraphResponse.SUCCESS_KEY);
            c0289s.a(null);
            return new C0626xb(b2, null);
        }
        kVar.a("failure");
        AdobeLibraryException a2 = com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorElementDoesNotExist, null, null, null);
        c0289s.a(a2);
        throw a2;
    }

    @Deprecated
    public Hb c(C0622wb c0622wb) {
        List<com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha> a2;
        s();
        com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha f2 = c0622wb.f();
        C0231f c0231f = this.f7444g;
        Hb hb = null;
        if (c0231f != null && f2 != null) {
            List<C0225c> b2 = c0231f.p().b(f2);
            if (b2 != null) {
                Iterator<C0225c> it = b2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    C0225c next = it.next();
                    String l = next.l();
                    if (l != null && l.equals("primary")) {
                        hb = new Hb(next);
                        break;
                    }
                }
            }
            if (hb == null && (a2 = this.f7444g.p().a(f2)) != null) {
                Iterator<com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha> it2 = a2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha next2 = it2.next();
                    String str = (String) next2.a("library#rel");
                    if (str == null) {
                        str = (String) next2.a("relationship");
                    }
                    if (str != null && str.equals("primary")) {
                        hb = new Hb(next2);
                        break;
                    }
                }
            }
        }
        u();
        return hb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean d() throws AdobeLibraryException {
        int i = this.f7441d;
        if (i > 0) {
            int i2 = i - 1;
            this.f7441d = i2;
            if (i2 == 0) {
                x();
            }
            return true;
        }
        throw com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorLibraryEndWithoutBegin, null, null, null);
    }

    @Deprecated
    public ArrayList<Hb> d(C0622wb c0622wb) {
        C0231f c0231f;
        s();
        com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha f2 = c0622wb.f();
        if (f2 == null || (c0231f = this.f7444g) == null) {
            return null;
        }
        List<com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha> a2 = c0231f.p().a(f2);
        List<C0225c> b2 = this.f7444g.p().b(f2);
        ArrayList<Hb> arrayList = new ArrayList<>((a2 != null ? a2.size() : 0) + (b2 != null ? b2.size() : 0));
        if (a2 != null) {
            Iterator<com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha> it = a2.iterator();
            while (it.hasNext()) {
                arrayList.add(new Hb(it.next()));
            }
        }
        if (b2 != null) {
            Iterator<C0225c> it2 = b2.iterator();
            while (it2.hasNext()) {
                arrayList.add(new Hb(it2.next()));
            }
        }
        u();
        return arrayList;
    }

    void a(String str, com.adobe.creativesdk.foundation.adobeinternal.storage.library.D d2, String str2) throws AdobeLibraryException {
        this.f7445h = d2;
        this.f7441d = 0;
        this.f7440c = new ReentrantLock();
        try {
            this.f7444g = C0231f.a(str, (com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Aa) null);
            this.f7444g.a(false);
            if (str2 == null) {
                str2 = this.f7444g.n();
            }
            this.f7438a = str2;
            g(this.f7438a);
            t();
        } catch (AdobeDCXException e2) {
            throw com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorLibraryCreateFailure, e2, null, null);
        }
    }

    void a(C0231f c0231f, com.adobe.creativesdk.foundation.adobeinternal.storage.library.D d2, String str) throws AdobeLibraryException {
        if (c0231f != null) {
            this.f7445h = d2;
            this.f7441d = 0;
            this.f7440c = new ReentrantLock();
            this.f7444g = c0231f;
            this.f7444g.a(false);
            if (str == null) {
                str = this.f7444g.n();
            }
            this.f7438a = str;
            this.f7443f = new JSONObject();
            if (this.f7444g.p() != null) {
                this.i = this.f7444g.p().i();
            }
            g(this.f7438a);
            return;
        }
        throw com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorLibraryCreateFailure, null, null, null);
    }

    public void a(AdobeCollaborationRoleType adobeCollaborationRoleType) {
        i().a(adobeCollaborationRoleType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(C0231f c0231f, String str) {
        try {
            s();
            if (c0231f != null) {
                this.f7444g = c0231f;
                if (str == null) {
                    str = c0231f.n();
                }
                this.f7438a = str;
                if (this.f7444g.p() != null) {
                    this.i = this.f7444g.p().i();
                }
            }
        } finally {
            u();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Handler handler, c.a.a.a.b<Void> bVar, c.a.a.a.c<AdobeLibraryException> cVar) {
        if (!Gb.f().i()) {
            if (cVar != null) {
                a(cVar, handler, com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorStartupFailure, null, null, null));
                return;
            }
            return;
        }
        C0231f c0231f = this.f7444g;
        if (!"modified".equals((c0231f == null || c0231f.p() == null) ? null : this.f7444g.p().c())) {
            if (bVar != null) {
                a(bVar, handler);
                return;
            }
            return;
        }
        com.adobe.creativesdk.foundation.adobeinternal.storage.library.D d2 = this.f7445h;
        com.adobe.creativesdk.foundation.adobeinternal.storage.library.ha haVar = d2 != null ? d2.m : null;
        if (haVar != null && !haVar.k(k())) {
            if (cVar != null) {
                a(cVar, handler, com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorLibraryFailedToSave, null, null, "Cannot revert. Library sync in progress"));
                return;
            }
            return;
        }
        try {
            if (this.f7444g.R()) {
                if (bVar != null) {
                    a(bVar, handler);
                } else if (cVar != null) {
                    a(cVar, handler, com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorLibraryFailedToSave, null, null, null));
                }
            }
        } catch (AdobeDCXException e2) {
            if (cVar != null) {
                a(cVar, handler, com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorLibraryFailedToSave, e2, null, null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na a(C0233g c0233g) throws AdobeLibraryException {
        if (c0233g == null) {
            return null;
        }
        List<com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na> a2 = c0233g.a((com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na) null);
        if (!a2.isEmpty()) {
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na na = a2.get(0);
            if (na == null || !MessengerShareContentUtility.ELEMENTS.equals(na.d())) {
                throw com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorLibraryNotInitialized, null, null, null);
            }
            return na;
        }
        throw com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorLibraryNotInitialized, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na a(C0235h c0235h) throws AdobeLibraryException {
        com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na na = null;
        if (c0235h == null) {
            return null;
        }
        List<com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na> a2 = c0235h.a((com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na) null);
        if (a2.isEmpty()) {
            throw com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorLibraryNotInitialized, null, null, null);
        }
        int i = 0;
        while (true) {
            if (i >= a2.size()) {
                break;
            }
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na na2 = a2.get(i);
            if (na2.d().equals("removed_elements")) {
                na = na2;
                break;
            }
            i++;
        }
        if (na != null) {
            return na;
        }
        try {
            return c0235h.a("removed_elements", (String) null, (String) null, (String) null, (com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na) null);
        } catch (AdobeDCXException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "Unable to create removed elements child", e2.getMessage());
            return na;
        }
    }

    public int a(AbstractC0618vb abstractC0618vb) {
        ArrayList<C0622wb> b2 = b(abstractC0618vb);
        if (b2 == null) {
            return 0;
        }
        return b2.size();
    }

    ArrayList<C0622wb> a(boolean z, AbstractC0618vb abstractC0618vb) {
        com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na j;
        s();
        ArrayList<C0622wb> arrayList = null;
        try {
            j = j();
        } catch (AdobeLibraryException e2) {
            e = e2;
        }
        if (j == null) {
            return null;
        }
        List<com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na> a2 = this.f7444g.p().a(j);
        if (a2 != null) {
            ArrayList<C0622wb> arrayList2 = new ArrayList<>(a2.size());
            try {
                Iterator<com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na> it = a2.iterator();
                while (it.hasNext()) {
                    C0626xb c0626xb = new C0626xb(it.next(), this);
                    if (!z || Gb.f().a(c0626xb.j(), abstractC0618vb)) {
                        arrayList2.add(c0626xb);
                    }
                }
                arrayList = arrayList2;
            } catch (AdobeLibraryException e3) {
                e = e3;
                arrayList = arrayList2;
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeLibraryComposite:getElements", "fetch failed", e);
                u();
                return arrayList;
            }
        }
        u();
        return arrayList;
    }

    boolean a(String str, String str2, boolean z, C0622wb c0622wb, ArrayList<C0622wb> arrayList) {
        if (str2 == null || !str2.toLowerCase().contains(str.toLowerCase())) {
            return !z;
        }
        if (!z) {
            return false;
        }
        arrayList.add(c0622wb);
        return true;
    }

    public ArrayList<C0622wb> a(C0630yb c0630yb, AbstractC0618vb abstractC0618vb) {
        return a(c0630yb, abstractC0618vb, true);
    }

    public ArrayList<C0622wb> a(C0630yb c0630yb) {
        return a(c0630yb, (AbstractC0618vb) null, false);
    }

    ArrayList<C0622wb> a(C0630yb c0630yb, AbstractC0618vb abstractC0618vb, boolean z) {
        s();
        com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na na = null;
        try {
            na = j();
        } catch (AdobeLibraryException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, C0614ub.class.getSimpleName(), null, e2);
        }
        ArrayList<C0622wb> arrayList = new ArrayList<>();
        if (na == null) {
            u();
            return arrayList;
        }
        List<com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na> a2 = this.f7444g.p().a(na);
        u();
        if (a2 != null) {
            Iterator<com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na> it = a2.iterator();
            while (it.hasNext()) {
                C0626xb c0626xb = new C0626xb(it.next(), this);
                if (!z || Gb.f().a(c0626xb.j(), abstractC0618vb)) {
                    if (c0630yb.b() != null) {
                        if (c0626xb.e() != null) {
                            if (a(c0630yb.b(), c0626xb.e(), c0630yb.d(), c0626xb, arrayList)) {
                            }
                        } else if (c0626xb.j().equalsIgnoreCase("application/vnd.adobe.element.characterstyle+dcx") && a(c0630yb.b(), c0626xb.c(), c0630yb.d(), c0626xb, arrayList)) {
                        }
                    }
                    if (c0630yb.c() == null || !a(c0630yb.c(), c0626xb.j(), c0630yb.d(), c0626xb, arrayList)) {
                        if (c0630yb.a() != null) {
                            boolean z2 = false;
                            Iterator<Hb> it2 = c0626xb.i().iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                if (c0630yb.a().contains(it2.next().m())) {
                                    z2 = true;
                                    break;
                                }
                            }
                            if (z2) {
                                if (c0630yb.d()) {
                                    arrayList.add(c0626xb);
                                }
                            } else if (!c0630yb.d()) {
                            }
                        }
                        if (!c0630yb.d()) {
                            arrayList.add(c0626xb);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public C0622wb a(String str, String str2) throws AdobeLibraryException {
        AdobeDCXException adobeDCXException;
        com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na na;
        if (a()) {
            return null;
        }
        com.adobe.creativesdk.foundation.adobeinternal.storage.library.r rVar = new com.adobe.creativesdk.foundation.adobeinternal.storage.library.r("createElement", this, null, null);
        s();
        b();
        com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na j = j();
        if (j != null) {
            if (this.f7444g.p().a(j).size() < 1000) {
                String a2 = com.adobe.creativesdk.foundation.internal.storage.model.util.i.a();
                try {
                    na = this.f7444g.p().a(str, a2, str2, a2, j);
                    adobeDCXException = null;
                } catch (AdobeDCXException e2) {
                    adobeDCXException = e2;
                    na = null;
                }
                if (na != null) {
                    Date date = new Date();
                    na.a(Long.valueOf(date.getTime()), "library#created");
                    na.a(Long.valueOf(date.getTime()), "library#modified");
                    C0626xb c0626xb = new C0626xb(na, this);
                    u();
                    d();
                    rVar.a(null);
                    return c0626xb;
                }
                u();
                d();
                AdobeLibraryException a3 = com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorLibraryFailedToAddElement, adobeDCXException, null, null);
                rVar.a(a3);
                throw a3;
            }
            u();
            d();
            AdobeLibraryException a4 = com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorLibraryMaximumElementsReached, null, null, null);
            rVar.a(a4);
            throw a4;
        }
        u();
        d();
        AdobeLibraryException a5 = com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorInvalidLibraryComposite, null, null, null);
        rVar.a(a5);
        throw a5;
    }

    public C0622wb a(C0622wb c0622wb) throws AdobeLibraryException {
        com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na na;
        if (a()) {
            return null;
        }
        s();
        b();
        try {
            na = this.f7444g.p().b(b(c0622wb), a(true), this.f7444g.p().a(r0).size());
        } catch (AdobeDCXException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "archive node failure", e2.getMessage());
            na = null;
        }
        if (na != null) {
            this.f7444g.N();
            u();
            d();
            C0626xb c0626xb = new C0626xb(na, null);
            c0626xb.m();
            return c0626xb;
        }
        throw com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorElementDoesNotExist, null, null, null);
    }

    private com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na a(boolean z) {
        C0231f c0231f = this.f7444g;
        if (c0231f == null || c0231f.p() == null) {
            return null;
        }
        try {
            return a(this.f7444g.p());
        } catch (AdobeLibraryException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "archive node failure", e2.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public C0622wb a(C0622wb c0622wb, C0614ub c0614ub) throws AdobeLibraryException {
        com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na c2;
        if (a()) {
            return null;
        }
        C0289s c0289s = new C0289s("copyElement", this, c0622wb, null);
        s();
        if (c0614ub == null) {
            c0614ub = this;
        }
        if (c0614ub != null && c0614ub.i() != null && c0614ub.i().p() != null) {
            C0235h p = c0614ub.i().p();
            if (c0622wb != null && p.c(c0622wb.c()) != null) {
                try {
                    com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na j = j();
                    int size = this.f7444g.p().a(j).size();
                    if (size < 1000) {
                        b();
                        String c3 = c0622wb.c();
                        String a2 = (c0614ub == this || this.f7444g.p().c(c3) != null) ? com.adobe.creativesdk.foundation.internal.storage.model.util.i.a() : c3;
                        if (c0622wb instanceof C0626xb) {
                            c2 = c0622wb.b();
                        } else {
                            c2 = p.c(c0622wb.c());
                        }
                        try {
                            C0626xb c0626xb = new C0626xb(this.f7444g.p().a(c2, j, size, a2, a2), this);
                            u();
                            d();
                            c0289s.a(null);
                            return c0626xb;
                        } catch (AdobeDCXException e2) {
                            u();
                            d();
                            AdobeLibraryException a3 = com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorElementCopyFailed, e2, null, null);
                            c0289s.a(a3);
                            throw a3;
                        }
                    }
                    u();
                    AdobeLibraryException a4 = com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorLibraryMaximumElementsReached, null, null, null);
                    c0289s.a(a4);
                    throw a4;
                } catch (AdobeLibraryException e3) {
                    u();
                    AdobeLibraryException a5 = com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorInvalidLibraryComposite, e3, null, null);
                    c0289s.a(a5);
                    throw a5;
                }
            }
            u();
            AdobeLibraryException a6 = com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorElementDoesNotExist, null, null, null);
            c0289s.a(a6);
            throw a6;
        }
        u();
        AdobeLibraryException a7 = com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorInvalidLibraryComposite, null, null, null);
        c0289s.a(a7);
        throw a7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c.a.a.a.b<String> bVar, Handler handler, String str) {
        if (handler != null) {
            handler.post(new RunnableC0579lb(this, bVar, str));
        } else {
            new Thread(new RunnableC0583mb(this, bVar, str)).start();
        }
    }

    private void a(c.a.a.a.b<Void> bVar, Handler handler) {
        if (handler != null) {
            handler.post(new RunnableC0587nb(this, bVar));
        } else {
            new Thread(new RunnableC0591ob(this, bVar)).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c.a.a.a.c<AdobeLibraryException> cVar, Handler handler, AdobeLibraryException adobeLibraryException) {
        if (handler != null) {
            handler.post(new RunnableC0595pb(this, cVar, adobeLibraryException));
        } else {
            new Thread(new RunnableC0599qb(this, cVar, adobeLibraryException)).start();
        }
    }

    public boolean a(Hb hb, c.a.a.a.b<String> bVar, c.a.a.a.c<AdobeLibraryException> cVar, Handler handler) {
        try {
            this.f7440c.lock();
            return a(hb, bVar, cVar, handler, (ArrayList<com.adobe.creativesdk.foundation.internal.net.E>) null);
        } finally {
            this.f7440c.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(Hb hb, c.a.a.a.b<String> bVar, c.a.a.a.c<AdobeLibraryException> cVar, Handler handler, ArrayList<com.adobe.creativesdk.foundation.internal.net.E> arrayList) {
        String str;
        com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na c2;
        String str2;
        C0225c b2 = hb.b();
        com.adobe.creativesdk.foundation.internal.net.E e2 = null;
        if (b2 != null) {
            try {
                str = this.f7444g.p().c(b2);
            } catch (AdobeDCXException e3) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, C0614ub.class.getSimpleName(), null, e3);
                str = null;
            }
            if (str == null) {
                com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na a2 = this.f7444g.p().a(hb.b());
                com.adobe.creativesdk.foundation.adobeinternal.storage.library.D d2 = this.f7445h;
                com.adobe.creativesdk.foundation.adobeinternal.storage.library.ha haVar = d2 != null ? d2.m : null;
                if (haVar != null) {
                    e2 = haVar.a(hb, a2 != null ? a2.e() : null, this.f7444g, this.f7438a, new C0602rb(this, bVar, handler, cVar));
                }
                if (e2 == null) {
                    return false;
                }
                if (arrayList != null) {
                    arrayList.add(e2);
                }
            } else if (bVar != null) {
                a(bVar, handler, str);
            }
            return true;
        }
        if (!hb.o()) {
            if (cVar == null) {
                return false;
            }
            a(cVar, handler, com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorRepresentationHasNoFile, null, null, null));
            return false;
        }
        if (hb instanceof Ib) {
            c2 = hb.d();
        } else {
            c2 = this.f7444g.p().c(hb.k());
        }
        com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na a3 = this.f7444g.p().a(c2, (com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ba) null);
        if (a3 == null) {
            return true;
        }
        String e4 = a3.e();
        String k = hb.k();
        JSONObject b3 = b(e4);
        try {
            String optString = b3.optString(k, null);
            if (optString != null) {
                if (optString.startsWith("ERROR")) {
                    if (cVar != null) {
                        a(cVar, handler, new AdobeLibraryException(AdobeLibraryErrorCode.AdobeLibraryErrorDownloadingRepresentationAsset));
                    }
                    return false;
                }
                if (bVar == null) {
                    return true;
                }
                a(bVar, handler, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.c(this.f7442e, optString));
                return true;
            }
            if (!Gb.f().k()) {
                if (cVar != null) {
                    a(cVar, handler, new AdobeLibraryException(AdobeLibraryErrorCode.AdobeLibraryErrorSyncNotEnabled));
                }
                return false;
            }
            String str3 = (String) hb.f().a("library#linktype");
            String str4 = (String) hb.f().a("library#linkurl");
            if (!com.adobe.creativesdk.foundation.internal.storage.a.a.b.a(str4)) {
                b3.put(k, "ERROR");
                if (cVar != null) {
                    a(cVar, handler, new AdobeLibraryException(AdobeLibraryErrorCode.AdobeLibraryErrorDownloadingRepresentationAsset));
                }
                return false;
            }
            String c3 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.c(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.c(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.c(this.f7442e, e4), k), com.adobe.creativesdk.foundation.internal.storage.model.util.i.a());
            String a4 = V.a(str3);
            if (a4 != null) {
                str2 = c3 + "." + a4;
            } else {
                str2 = c3;
            }
            com.adobe.creativesdk.foundation.internal.net.E a5 = com.adobe.creativesdk.foundation.internal.storage.a.a.b.a().a(new URL(str4), str2, new C0606sb(this, e4, k, str2, b3, bVar, handler), new C0610tb(this, b3, k, cVar, handler));
            if (a5 == null) {
                return false;
            }
            if (arrayList == null) {
                return true;
            }
            arrayList.add(a5);
            return true;
        } catch (MalformedURLException | JSONException e5) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, C0614ub.class.getSimpleName(), null, e5);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na na) {
        s();
        if (na.f().equals("application/vnd.adobe.library.link+dcx")) {
            String optString = b(this.f7444g.p().a(na, new com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ba()).e()).optString(na.e());
            u();
            return optString == null;
        }
        u();
        return false;
    }

    public boolean a(String str, int i, boolean z, c.a.a.a.b<String> bVar, c.a.a.a.c<AdobeLibraryException> cVar, Handler handler) {
        return a(str, i, z, bVar, cVar, handler, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(C0622wb c0622wb, Hb hb, int i, Handler handler, c.a.a.a.b<String> bVar, c.a.a.a.c<AdobeLibraryException> cVar) {
        String a2;
        String str;
        String str2;
        boolean equals = hb.j().equals("primary");
        URI a3 = a(hb);
        if (a3 == null || (a2 = com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(a3.getHost(), i)) == null) {
            return false;
        }
        if ((a3.getPath() + a3.getQuery()) != null) {
            str = "&";
        } else {
            str = "?" + a2;
        }
        String str3 = (String) hb.f().a("library#linktype");
        try {
            if (!com.adobe.creativesdk.foundation.internal.storage.a.a.b.a(str)) {
                return false;
            }
            String c2 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.c(this.f7442e, c0622wb.c());
            File file = new File(c2);
            if (!file.exists()) {
                file.mkdirs();
            }
            String num = Integer.toString(i);
            String c3 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.c(c2, num);
            String a4 = V.a(str3);
            if (a4 != null) {
                str2 = c3 + "." + a4;
            } else {
                str2 = c3;
            }
            return com.adobe.creativesdk.foundation.internal.storage.a.a.b.a().a(a3.toURL(), str2, new C0555fb(this, c0622wb, num, a4, bVar, handler, str2), new C0559gb(this, equals, c0622wb, bVar, cVar, handler, num)) != null;
        } catch (MalformedURLException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, C0614ub.class.getSimpleName(), null, e2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b7, code lost:            a(r16, new com.adobe.creativesdk.foundation.storage.C0563hb(r26, r27, r13, r30, r32), new com.adobe.creativesdk.foundation.storage.C0567ib(r26, r31, r32), (android.os.Handler) null, r33);     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00db, code lost:            return true;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(java.lang.String r27, int r28, boolean r29, c.a.a.a.b<java.lang.String> r30, c.a.a.a.c<com.adobe.creativesdk.foundation.storage.AdobeLibraryException> r31, android.os.Handler r32, java.util.ArrayList<com.adobe.creativesdk.foundation.internal.net.E> r33) {
        /*
            Method dump skipped, instructions count: 660
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.storage.C0614ub.a(java.lang.String, int, boolean, c.a.a.a.b, c.a.a.a.c, android.os.Handler, java.util.ArrayList):boolean");
    }

    private String a(String str, int i, boolean z) {
        String optString;
        String num = z ? MessengerShareContentUtility.WEBVIEW_RATIO_FULL : Integer.toString(i);
        JSONObject b2 = b(str);
        if (b2 == null || (optString = b2.optString(num, null)) == null) {
            return null;
        }
        if (optString.charAt(0) == '/') {
            return optString;
        }
        if (optString.startsWith("<library>")) {
            return com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.c(y(), optString.substring(9));
        }
        if (optString.startsWith("<cache>")) {
            return com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.c(this.f7442e, optString.substring(7));
        }
        return optString.startsWith("ERROR") ? optString : com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.c(this.f7442e, optString);
    }

    @Deprecated
    URI a(Hb hb) {
        if (hb.o()) {
            return URI.create((String) hb.f().a("library#linkurl"));
        }
        com.adobe.creativesdk.foundation.internal.storage.model.resources.f a2 = C0333c.a(hb.b(), this.f7444g, null, false);
        com.adobe.creativesdk.foundation.adobeinternal.storage.library.D d2 = this.f7445h;
        com.adobe.creativesdk.foundation.adobeinternal.cloud.g gVar = d2 != null ? (com.adobe.creativesdk.foundation.adobeinternal.cloud.g) d2.m.o() : null;
        if (gVar != null) {
            com.adobe.creativesdk.foundation.internal.net.A c2 = gVar.c("libraries");
            if (a2 != null && c2 != null) {
                try {
                    return new URI(com.adobe.creativesdk.foundation.internal.storage.model.util.g.a(a2.f6610b.toString(), c2.a().toString()));
                } catch (URISyntaxException e2) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, C0614ub.class.getSimpleName(), null, e2);
                    return null;
                }
            }
        }
        return null;
    }

    @Deprecated
    public Hb a(String str, C0622wb c0622wb) {
        List<com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha> a2;
        s();
        com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha f2 = c0622wb.f();
        Hb hb = null;
        if (f2 != null) {
            List<C0225c> b2 = this.f7444g.p().b(f2);
            if (b2 != null) {
                Iterator<C0225c> it = b2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    C0225c next = it.next();
                    String n = next.n();
                    if (n != null && n.equals(str)) {
                        hb = new Hb(next);
                        break;
                    }
                }
            }
            if (hb == null && (a2 = this.f7444g.p().a(f2)) != null) {
                Iterator<com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha> it2 = a2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha next2 = it2.next();
                    String k = next2.k();
                    if (k != null && k.equals(str)) {
                        hb = new Hb(next2);
                        break;
                    }
                }
            }
        }
        u();
        return hb;
    }

    public boolean a() throws AdobeLibraryException {
        if (q()) {
            throw com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorNoWriteAccess, null, null, null);
        }
        return false;
    }
}
