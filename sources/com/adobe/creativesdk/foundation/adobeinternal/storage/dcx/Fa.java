package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import android.annotation.SuppressLint;
import com.adobe.creativesdk.foundation.internal.storage.a.b.C0333c;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.storage.AdobeCollaborationRoleType;
import com.adobe.creativesdk.foundation.storage.AdobeCollaborationType;
import com.facebook.internal.ServerProtocol;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdobeDCXManifest.java */
/* loaded from: classes.dex */
public class Fa implements Cloneable, com.adobe.creativesdk.foundation.internal.storage.controllers.upload.A<Fa> {

    /* renamed from: a, reason: collision with root package name */
    private static SimpleDateFormat f4147a;

    /* renamed from: b, reason: collision with root package name */
    private static List<String> f4148b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private static List<String> f4149c;

    /* renamed from: d, reason: collision with root package name */
    private static List<String> f4150d;

    /* renamed from: e, reason: collision with root package name */
    private static final String f4151e;

    /* renamed from: f, reason: collision with root package name */
    private JSONObject f4152f;

    /* renamed from: g, reason: collision with root package name */
    private LinkedHashMap<String, C0225c> f4153g;

    /* renamed from: h, reason: collision with root package name */
    private LinkedHashMap<String, Ha> f4154h;
    private JSONObject i;
    String j;
    private La k = null;
    private JSONObject l;
    public boolean m;
    private JSONObject n;

    static {
        f4148b.add("id");
        f4148b.add(ServerProtocol.DIALOG_PARAM_STATE);
        f4148b.add("local");
        f4148b.add("manifest-format-version");
        f4149c = new ArrayList();
        f4149c.add("id");
        f4149c.add("name");
        f4149c.add("path");
        f4149c.add("type");
        f4149c.add("children");
        f4149c.add("components");
        f4149c.add("manifest-format-version");
        f4149c.add(ServerProtocol.DIALOG_PARAM_STATE);
        f4149c.add("local");
        f4149c.add("rel");
        f4150d = new ArrayList();
        f4150d.add("id");
        f4150d.add("name");
        f4150d.add("path");
        f4150d.add("type");
        f4150d.add("_links");
        f4150d.add("etag");
        f4150d.add("md5");
        f4150d.add(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION);
        f4150d.add("width");
        f4150d.add("height");
        f4150d.add("length");
        f4150d.add(ServerProtocol.DIALOG_PARAM_STATE);
        f4150d.add("rel");
        f4151e = Fa.class.getSimpleName();
    }

    public Fa(JSONObject jSONObject) throws AdobeDCXException {
        d(jSONObject);
    }

    private JSONObject A() {
        JSONObject optJSONObject = this.f4152f.optJSONObject("local");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
            try {
                this.f4152f.putOpt("local", optJSONObject);
            } catch (JSONException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e2);
            }
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("unmanagedComponents");
        if (optJSONObject2 == null) {
            optJSONObject2 = new JSONObject();
            try {
                optJSONObject.putOpt("unmanagedComponents", optJSONObject2);
            } catch (JSONException e3) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e3);
            }
        }
        return optJSONObject2;
    }

    private static void B() {
        synchronized (Fa.class) {
            if (f4147a == null) {
                f4147a = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.US);
                f4147a.setTimeZone(TimeZone.getTimeZone("GMT"));
            }
        }
    }

    private void C() {
        if (i().equals("unmodified")) {
            f("modified");
        } else {
            this.m = true;
        }
    }

    private void D() throws AdobeDCXException {
        if (!this.f4152f.isNull("id")) {
            if (!this.k.c().isNull("name")) {
                if (this.k.c().isNull("type")) {
                    throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorInvalidManifest, "Manifest is missing a type");
                }
                return;
            }
            throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorInvalidManifest, "Manifest is missing a name");
        }
        throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorInvalidManifest, "Manifest is missing an id");
    }

    private JSONObject j(String str) {
        if (str.equals(this.k.g())) {
            return this.k.c();
        }
        Ha ha = this.f4154h.get(str);
        if (ha != null) {
            return ha.c();
        }
        return null;
    }

    private void k(String str) {
        try {
            this.f4152f.put("id", str);
        } catch (JSONException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e2);
        }
        this.f4154h.remove(this.k.g());
        this.k.d(str);
        this.f4154h.put(this.k.g(), this.k);
        JSONObject c2 = this.k.c();
        JSONArray optJSONArray = c2.optJSONArray("components");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    C0225c a2 = C0225c.a(optJSONArray.getJSONObject(i), this, "/", str);
                    this.f4153g.put(a2.b(), a2);
                    this.i.put(a2.a().toLowerCase(), a2);
                } catch (JSONException e3) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e3);
                }
            }
        }
        JSONArray optJSONArray2 = c2.optJSONArray("children");
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                try {
                    La a3 = La.a(optJSONArray2.getJSONObject(i2), this, "/", str);
                    this.f4154h.put(a3.g(), a3);
                    if (a3.j() != null) {
                        this.i.put(a3.b().toLowerCase(), a3);
                    }
                } catch (JSONException e4) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e4);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<String> o() {
        return f4148b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<String> r() {
        return f4150d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<String> s() {
        return f4149c;
    }

    private void z() {
        JSONArray optJSONArray = this.k.c().optJSONArray("components");
        int length = optJSONArray == null ? 0 : optJSONArray.length();
        JSONArray optJSONArray2 = this.k.c().optJSONArray("children");
        int length2 = optJSONArray2 != null ? optJSONArray2.length() : 0;
        this.f4153g = new LinkedHashMap<>(length);
        this.f4154h = new LinkedHashMap<>(length2);
        this.i = new JSONObject();
        a(this.k.c(), "/", this.k.g());
        this.f4154h.put(this.k.g(), this.k);
        try {
            this.i.put("/", this.k);
        } catch (JSONException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e2);
        }
    }

    JSONObject a(boolean z) {
        JSONObject optJSONObject = this.f4152f.optJSONObject("local");
        if (optJSONObject == null) {
            if (!z) {
                return null;
            }
            optJSONObject = new JSONObject();
            try {
                optJSONObject.put("copyOnWrite#storageIds", new JSONObject());
                a(optJSONObject, "local");
            } catch (JSONException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e2);
            }
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("componentS2SCopy#srcHref");
        if (optJSONObject2 == null) {
            if (!z) {
                return null;
            }
            optJSONObject2 = new JSONObject();
            try {
                optJSONObject.put("componentS2SCopy#srcHref", optJSONObject2);
            } catch (JSONException e3) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e3);
            }
        }
        return optJSONObject2;
    }

    public void b(String str, C0225c c0225c) {
        JSONObject A = A();
        try {
            if (str == null) {
                A.remove(c0225c.b());
            } else {
                A.putOpt(c0225c.b(), str);
            }
        } catch (JSONException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e2);
        }
    }

    public String c(C0225c c0225c) {
        JSONObject a2 = a(false);
        if (a2 != null) {
            return a2.optString(c0225c.b(), null);
        }
        return null;
    }

    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Yet to be implemented");
    }

    public String d(C0225c c0225c) {
        return A().optString(c0225c.b(), null);
    }

    public AdobeCollaborationType e() {
        JSONObject optJSONObject = this.f4152f.optJSONObject("local");
        if (optJSONObject != null) {
            String optString = optJSONObject.optString("collaboration");
            if (optString.equals("sharedByUser")) {
                return AdobeCollaborationType.ADOBE_COLLABORATION_TYPE_SHAREDBYUSER;
            }
            if (optString.equals("sharedWithUser")) {
                return AdobeCollaborationType.ADOBE_COLLABORATION_TYPE_SHAREDWITHUSER;
            }
        }
        return AdobeCollaborationType.ADOBE_COLLABORATION_TYPE_PRIVATE;
    }

    public void f(String str) {
        try {
            this.f4152f.putOpt(ServerProtocol.DIALOG_PARAM_STATE, str);
            this.m = true;
        } catch (JSONException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e2);
        }
    }

    public URI g() {
        JSONObject optJSONObject = this.f4152f.optJSONObject("local");
        if (optJSONObject == null) {
            return null;
        }
        try {
            if (optJSONObject.optString("compositeHref", null) != null) {
                return new URI(optJSONObject.optString("compositeHref", null));
            }
            return null;
        } catch (Exception e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e2);
            return null;
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.upload.A
    public String getId() {
        if (h() != null) {
            return h();
        }
        return null;
    }

    public String h() {
        return this.f4152f.optString("id", null);
    }

    public String i() {
        String optString = this.f4152f.optString(ServerProtocol.DIALOG_PARAM_STATE, null);
        return optString != null ? optString : "unmodified";
    }

    public String l() {
        JSONObject optJSONObject = this.f4152f.optJSONObject("local");
        if (optJSONObject != null) {
            return optJSONObject.optString("manifestEtag", null);
        }
        return null;
    }

    public final JSONObject m() {
        return this.k.c().optJSONObject("_links");
    }

    public String n() {
        JSONObject a2 = com.adobe.creativesdk.foundation.internal.storage.model.util.d.a(this.k.c());
        com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(this.k.c().optString("id").equals(this.f4152f.optString("id")), "RootNode Id is not equal to the composite Id");
        com.adobe.creativesdk.foundation.internal.storage.model.util.d.a(this.f4152f, a2);
        return a2.toString();
    }

    public String p() {
        return this.k.c().optString("name", null);
    }

    public String q() {
        JSONObject optJSONObject = this.f4152f.optJSONObject("local");
        if (optJSONObject != null) {
            this.f4152f.remove("local");
        }
        JSONObject a2 = com.adobe.creativesdk.foundation.internal.storage.model.util.d.a(this.k.c());
        com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(this.k.c().optString("id").equals(this.f4152f.optString("id")), "RootNode Id is not equal to the composite Id");
        com.adobe.creativesdk.foundation.internal.storage.model.util.d.a(this.f4152f, a2);
        String jSONObject = a2.toString();
        if (optJSONObject != null) {
            try {
                this.f4152f.putOpt("local", optJSONObject);
            } catch (JSONException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXManifest", null, e2);
            }
        }
        return jSONObject;
    }

    public final La t() {
        return this.k;
    }

    public String u() {
        JSONObject optJSONObject = this.f4152f.optJSONObject("local");
        if (optJSONObject != null) {
            return optJSONObject.optString("manifestSaveId", null);
        }
        return null;
    }

    public String v() {
        return this.k.c().optString("type", null);
    }

    public String w() {
        JSONObject jSONObject;
        try {
            jSONObject = this.f4152f.getJSONObject("local");
        } catch (JSONException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e2);
            jSONObject = null;
        }
        if (jSONObject != null) {
            return jSONObject.optString("manifestVersion", null);
        }
        return null;
    }

    public boolean x() {
        return l() != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y() {
        l(null);
    }

    public void h(String str) {
        try {
            if (str != null) {
                this.k.c().putOpt("name", str);
            } else {
                this.k.c().remove("name");
            }
            C();
        } catch (JSONException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e2);
        }
    }

    public void i(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = this.f4152f.getJSONObject("local");
        } catch (JSONException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e2);
            jSONObject = null;
        }
        if (str != null && jSONObject != null) {
            try {
                jSONObject.put("manifestVersion", str);
            } catch (JSONException e3) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e3);
            }
        } else if (str != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("manifestVersion", str);
                this.f4152f.put("local", jSONObject2);
            } catch (JSONException e4) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e4);
            }
        } else if (jSONObject != null) {
            jSONObject.remove("manifestVersion");
        }
        this.m = true;
    }

    private JSONObject c(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (o().contains(next)) {
                try {
                    jSONObject2.putOpt(next, jSONObject.opt(next));
                } catch (JSONException e2) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, f4151e, null, e2);
                }
            }
        }
        return jSONObject2;
    }

    private void l(String str) {
        this.f4152f.remove("etag");
        if (str != null) {
            k(str);
        }
        try {
            this.f4152f.put(ServerProtocol.DIALOG_PARAM_STATE, "modified");
        } catch (JSONException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e2);
        }
        f(this.k.c());
        g(null);
        i(null);
        a((URI) null);
        this.m = true;
    }

    public AdobeCollaborationRoleType d() {
        JSONObject optJSONObject = this.f4152f.optJSONObject("local");
        if (optJSONObject != null) {
            String optString = optJSONObject.optString("collaboration_role");
            if (optString.equals("editor")) {
                return AdobeCollaborationRoleType.ADOBE_COLLABORATION_ROLE_TYPE_EDITOR;
            }
            if (optString.equals("viewer")) {
                return AdobeCollaborationRoleType.ADOBE_COLLABORATION_ROLE_TYPE_VIEWER;
            }
        }
        return AdobeCollaborationRoleType.ADOBE_COLLABORATION_ROLE_TYPE_OWNER;
    }

    public Fa(String str, String str2) throws AdobeDCXException {
        String a2 = com.adobe.creativesdk.foundation.internal.storage.model.util.i.a();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("manifest-format-version", 6L);
            jSONObject.put("name", str);
            jSONObject.put("type", str2);
            jSONObject.put("id", a2);
        } catch (JSONException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e2);
        }
        d(jSONObject);
    }

    private void f(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("components");
        if (optJSONArray != null) {
            for (int length = optJSONArray.length() - 1; length >= 0; length--) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(length);
                String optString = optJSONObject.optString(ServerProtocol.DIALOG_PARAM_STATE, null);
                if (optString != null && (optString.equals("committedDelete") || optString.equals("pendingDelete"))) {
                    optJSONArray = a(length, optJSONArray);
                    try {
                        jSONObject.putOpt("components", optJSONArray);
                    } catch (JSONException e2) {
                        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e2);
                    }
                    String optString2 = optJSONObject.optString("id", null);
                    this.i.remove(this.f4153g.get(optString2).a().toLowerCase());
                    this.f4153g.remove(optString2);
                } else {
                    optJSONObject.remove("etag");
                    optJSONObject.remove(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION);
                    optJSONObject.remove("length");
                    optJSONObject.remove("md5");
                    try {
                        optJSONObject.putOpt(ServerProtocol.DIALOG_PARAM_STATE, "modified");
                    } catch (JSONException e3) {
                        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e3);
                    }
                }
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("children");
        if (optJSONArray2 != null) {
            for (int i = 0; i < optJSONArray2.length(); i++) {
                f(optJSONArray2.optJSONObject(i));
            }
        }
    }

    public void b(JSONObject jSONObject) {
        try {
            if (jSONObject != null) {
                this.k.c().putOpt("_links", com.adobe.creativesdk.foundation.internal.storage.model.util.d.a(jSONObject));
            } else {
                this.k.c().remove("_links");
            }
            C();
        } catch (JSONException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e2);
        }
    }

    public void g(String str) {
        try {
            JSONObject optJSONObject = this.f4152f.optJSONObject("local");
            if (str != null && optJSONObject != null) {
                optJSONObject.putOpt("manifestEtag", str);
            } else if (str != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("manifestEtag", str);
                this.f4152f.putOpt("local", jSONObject);
            } else if (optJSONObject != null) {
                optJSONObject.remove("manifestEtag");
            }
        } catch (JSONException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e2);
        }
        this.m = true;
    }

    public Fa j() throws AdobeDCXException {
        return new Fa(n());
    }

    public void e(String str) {
        k(str);
        C();
    }

    public final Object b(String str) {
        if (o().contains(str)) {
            return this.f4152f.opt(str);
        }
        if (this.k == null) {
            Za.a("csdk_android_dcx", "DCXManifest:get", "_rootNode is null", "initedDictionary:" + this.l.toString());
        }
        return this.k.a(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0032 A[Catch: JSONException -> 0x007c, TryCatch #0 {JSONException -> 0x007c, blocks: (B:5:0x000f, B:8:0x0017, B:11:0x001c, B:14:0x0032, B:17:0x0055, B:19:0x0063, B:20:0x006c, B:23:0x0039, B:24:0x0049, B:27:0x004e, B:28:0x0023), top: B:4:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0063 A[Catch: JSONException -> 0x007c, TryCatch #0 {JSONException -> 0x007c, blocks: (B:5:0x000f, B:8:0x0017, B:11:0x001c, B:14:0x0032, B:17:0x0055, B:19:0x0063, B:20:0x006c, B:23:0x0039, B:24:0x0049, B:27:0x004e, B:28:0x0023), top: B:4:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d(org.json.JSONObject r10) throws com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException {
        /*
            r9 = this;
            java.lang.String r0 = "id"
            java.lang.String r1 = "manifest-format-version"
            java.lang.String r2 = "csdk_android_dcx"
            r9.l = r10
            B()
            if (r10 == 0) goto Lb9
            r3 = 0
            java.lang.Object r5 = r10.opt(r1)     // Catch: org.json.JSONException -> L7c
            java.lang.String r6 = "DCXManifest-Init"
            if (r5 == 0) goto L23
            boolean r7 = r5 instanceof java.lang.Number     // Catch: org.json.JSONException -> L7c
            if (r7 != 0) goto L1c
            goto L23
        L1c:
            java.lang.Number r5 = (java.lang.Number) r5     // Catch: org.json.JSONException -> L7c
            long r3 = r5.longValue()     // Catch: org.json.JSONException -> L7c
            goto L2c
        L23:
            java.lang.String r5 = "manifest-format-version missing"
            java.lang.String r7 = r10.toString()     // Catch: org.json.JSONException -> L7c
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.a(r2, r6, r5, r7)     // Catch: org.json.JSONException -> L7c
        L2c:
            r7 = 6
            int r5 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r5 > 0) goto L4a
            boolean r1 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ga.a(r10, r3)     // Catch: org.json.JSONException -> L7c
            if (r1 == 0) goto L39
            goto L55
        L39:
            java.lang.String r0 = "FormatConversion failed"
            java.lang.String r1 = r10.toString()     // Catch: org.json.JSONException -> L7c
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.a(r2, r6, r0, r1)     // Catch: org.json.JSONException -> L7c
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException r0 = new com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException     // Catch: org.json.JSONException -> L7c
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXErrorCode r1 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXErrorCode.AdobeDCXErrorInvalidLocalManifest     // Catch: org.json.JSONException -> L7c
            r0.<init>(r1)     // Catch: org.json.JSONException -> L7c
            throw r0     // Catch: org.json.JSONException -> L7c
        L4a:
            int r5 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r5 <= 0) goto L55
            java.lang.Long r3 = java.lang.Long.valueOf(r7)     // Catch: org.json.JSONException -> L7c
            r10.putOpt(r1, r3)     // Catch: org.json.JSONException -> L7c
        L55:
            org.json.JSONObject r1 = r9.c(r10)     // Catch: org.json.JSONException -> L7c
            r9.f4152f = r1     // Catch: org.json.JSONException -> L7c
            org.json.JSONObject r1 = r9.f4152f     // Catch: org.json.JSONException -> L7c
            boolean r1 = r1.isNull(r0)     // Catch: org.json.JSONException -> L7c
            if (r1 == 0) goto L6c
            org.json.JSONObject r1 = r9.f4152f     // Catch: org.json.JSONException -> L7c
            java.lang.String r3 = com.adobe.creativesdk.foundation.internal.storage.model.util.i.a()     // Catch: org.json.JSONException -> L7c
            r1.putOpt(r0, r3)     // Catch: org.json.JSONException -> L7c
        L6c:
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.La r0 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.La.a(r10, r9)     // Catch: org.json.JSONException -> L7c
            r9.k = r0     // Catch: org.json.JSONException -> L7c
            r9.D()     // Catch: org.json.JSONException -> L7c
            r9.z()     // Catch: org.json.JSONException -> L7c
            r0 = 0
            r9.m = r0     // Catch: org.json.JSONException -> L7c
            goto Lb8
        L7c:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "cxManifestCreation-init failed - reason:"
            r1.append(r3)
            java.lang.String r3 = r0.getMessage()
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "manifest data:"
            r3.append(r4)
            java.lang.String r10 = r10.toString()
            r3.append(r10)
            java.lang.String r10 = r3.toString()
            java.lang.String r3 = "AdobeDCXManifest"
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.a(r2, r3, r1, r10)
            com.adobe.creativesdk.foundation.internal.utils.logging.Level r10 = com.adobe.creativesdk.foundation.internal.utils.logging.Level.DEBUG
            java.lang.Class<com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa> r1 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa.class
            java.lang.String r1 = r1.getSimpleName()
            r2 = 0
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(r10, r1, r2, r0)
        Lb8:
            return
        Lb9:
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXErrorCode r10 = com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXErrorCode.AdobeDCXErrorInvalidManifest
            java.lang.String r0 = "dict is missing"
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException r10 = com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(r10, r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa.d(org.json.JSONObject):void");
    }

    private void e(JSONObject jSONObject) {
        JSONArray optJSONArray;
        a("_links", jSONObject);
        a("components", jSONObject);
        if (a("children", jSONObject) || (optJSONArray = jSONObject.optJSONArray("children")) == null) {
            return;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                e(optJSONObject);
            }
        }
    }

    public void a(String str, C0225c c0225c) {
        JSONObject a2 = a(str != null);
        if (str == null) {
            if (a2 != null) {
                a2.remove(c0225c.b());
            }
        } else {
            try {
                a2.put(c0225c.b(), str);
            } catch (JSONException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e2);
            }
        }
    }

    public C0225c c(String str) {
        Object opt = this.i.opt(str.toLowerCase());
        if (!(opt instanceof C0225c)) {
            opt = null;
        }
        return (C0225c) opt;
    }

    public List<Ha> c() {
        return a(this.k.c().optJSONArray("children"), "/", t().g());
    }

    public List<Ha> c(Ha ha) {
        JSONObject j = j(ha.g());
        if (j == null) {
            return new ArrayList();
        }
        return a(j.optJSONArray("children"), f(ha), ha.g());
    }

    public Fa(String str) throws AdobeDCXException {
        JSONObject jSONObject = null;
        if (str != null) {
            try {
                e = null;
                jSONObject = new JSONObject(str);
            } catch (JSONException e2) {
                e = e2;
                Za.a("csdk_android_dcx", "AdobeDCXManifest", "dcxManifestCreation failed - reason:" + e.getMessage(), "manifest data:" + str);
            }
            if (jSONObject != null) {
                e(jSONObject);
                d(jSONObject);
                return;
            }
            throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorInvalidManifest, "Invalid JSON", e);
        }
        throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorMissingManifest, "Missing Data");
    }

    private JSONObject b(String str, Ba ba) {
        Ha a2;
        Ha ha = this.f4154h.get(str);
        if (ha == null || (a2 = a(ha, ba)) == null || a2.c() == null) {
            return null;
        }
        return a2.c();
    }

    public void a(C0225c c0225c, C0225c c0225c2, Fa fa) {
        String c2 = fa.c(c0225c2);
        if (c2 != null) {
            a(c2, c0225c);
        } else {
            if (c0225c.d() != null || c0225c2.m() == null || !c0225c2.m().equals("unmodified") || c0225c2.d() == null) {
                return;
            }
            a(C0333c.a(c0225c2, fa.g() != null ? fa.g().toString() : null, this.n, null, true).f6610b.toString(), c0225c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Fa e(String str, String str2) throws AdobeDCXException {
        return new Fa(str, str2);
    }

    private ArrayList<C0225c> b(JSONArray jSONArray, String str, String str2) {
        ArrayList<C0225c> arrayList = new ArrayList<>();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(C0225c.a(jSONArray.optJSONObject(i), this, str, str2));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0225c e(C0225c c0225c) {
        Ba ba = new Ba();
        a(c0225c, a(c0225c.b(), ba), ba.f4127a);
        return c0225c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SimpleDateFormat k() {
        return f4147a;
    }

    public void a(AdobeCollaborationType adobeCollaborationType) {
        String str;
        if (adobeCollaborationType == AdobeCollaborationType.ADOBE_COLLABORATION_TYPE_SHAREDBYUSER) {
            str = "sharedByUser";
        } else {
            str = adobeCollaborationType == AdobeCollaborationType.ADOBE_COLLABORATION_TYPE_SHAREDWITHUSER ? "sharedWithUser" : "private";
        }
        JSONObject optJSONObject = this.f4152f.optJSONObject("local");
        if (optJSONObject != null) {
            try {
                optJSONObject.putOpt("collaboration", str);
            } catch (JSONException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e2);
            }
        } else {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("collaboration", str);
                this.f4152f.putOpt("local", jSONObject);
            } catch (JSONException e3) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e3);
            }
        }
        this.m = true;
    }

    private C0225c b(C0225c c0225c, JSONObject jSONObject, long j) throws AdobeDCXException {
        String b2 = c0225c.b();
        JSONArray optJSONArray = jSONObject.optJSONArray("components");
        if (j == -1) {
            j = b(b2, optJSONArray);
        }
        Ha ha = this.f4154h.get(jSONObject.optString("id"));
        JSONObject a2 = com.adobe.creativesdk.foundation.internal.storage.model.util.d.a(c0225c.c());
        C0225c a3 = C0225c.a(a2, this, f(ha), ha.g());
        C0225c c0225c2 = this.f4153g.get(c0225c.b());
        if (c0225c2.k() == null || !c0225c2.k().equals(a3.k())) {
            if (a3.k() != null && Za.d(a3.k())) {
                if (a3.a() != null && !Za.c(a3.a())) {
                    throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorInvalidPath, "Absolute paths cannot begin with /manifest or /mimetype: %s" + a3.a());
                }
                if (a3.a() != null && this.i.opt(a3.a().toLowerCase()) != null) {
                    throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorDuplicatePath, "Dupliacte path:" + a3.a());
                }
                this.i.remove(c0225c2.a().toLowerCase());
            } else {
                throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorInvalidPath, "Invalid path: " + a3.k());
            }
        }
        int i = (int) j;
        try {
            jSONObject.putOpt("components", a(i, a2, a(i, optJSONArray)));
            this.i.remove(this.f4153g.get(b2).a().toLowerCase());
            this.f4153g.put(b2, a3);
            this.i.put(a3.a().toLowerCase(), a3);
            C();
            return a3;
        } catch (JSONException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e2);
            return null;
        }
    }

    public La e(Ha ha) throws AdobeDCXException {
        La la;
        JSONObject jSONObject;
        JSONArray jSONArray;
        LinkedHashMap<String, C0225c> linkedHashMap;
        JSONObject jSONObject2;
        LinkedHashMap<String, Ha> linkedHashMap2;
        La la2;
        String lowerCase;
        Na m;
        Na m2;
        String g2 = ha.g();
        if (g2.equals(t().g())) {
            La t = t();
            JSONObject a2 = com.adobe.creativesdk.foundation.internal.storage.model.util.d.a(ha.c());
            a(a2, t().c());
            la2 = new La(a2, "", (String) null);
            la2.a(true);
            this.k = la2;
            this.f4154h.put(this.k.g(), this.k);
            try {
                this.i.putOpt("/", this.k);
            } catch (JSONException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e2);
            }
            if (t.m() != null && (m2 = t.m()) != null) {
                m2.a(this.k);
                this.k.a(m2);
            }
        } else {
            Ba ba = new Ba();
            JSONObject b2 = b(g2, ba);
            if (b2 == null) {
                return null;
            }
            JSONArray optJSONArray = b2.optJSONArray("children");
            JSONObject optJSONObject = optJSONArray.optJSONObject((int) ba.f4127a);
            Ha ha2 = this.f4154h.get(b2.optString("id"));
            La la3 = (La) this.f4154h.get(g2);
            JSONObject a3 = com.adobe.creativesdk.foundation.internal.storage.model.util.d.a(ha.c());
            a(a3, optJSONObject);
            La la4 = new La(a3, this, f(ha2), ha2.g());
            String j = ha.j();
            if (j != null && !Za.d(j)) {
                throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorInvalidPath, "Invalid path: " + j);
            }
            String optString = optJSONObject.optString("path", null);
            if ((j == null && optString == null) || (j != null && j.equals(optString))) {
                if (la3.m() != null && (m = la3.m()) != null) {
                    m.a(la4);
                    la4.a(m);
                }
                la = la4;
                jSONObject = a3;
                jSONArray = optJSONArray;
                linkedHashMap2 = null;
                linkedHashMap = null;
                jSONObject2 = null;
            } else {
                Ha ha3 = this.f4154h.get(g2);
                LinkedHashMap<String, C0225c> linkedHashMap3 = new LinkedHashMap<>();
                LinkedHashMap<String, Ha> linkedHashMap4 = new LinkedHashMap<>();
                JSONObject jSONObject3 = new JSONObject();
                com.adobe.creativesdk.foundation.internal.storage.model.util.d.b(this.f4153g, linkedHashMap3);
                com.adobe.creativesdk.foundation.internal.storage.model.util.d.a(this.f4154h, linkedHashMap4);
                com.adobe.creativesdk.foundation.internal.storage.model.util.d.a(this.i, jSONObject3);
                List<Ha> arrayList = new ArrayList<>();
                List<Ha> arrayList2 = new ArrayList<>();
                if (!a(ha3, linkedHashMap4, linkedHashMap3, jSONObject3, null, arrayList)) {
                    return null;
                }
                la = la4;
                jSONObject = a3;
                jSONArray = optJSONArray;
                if (!a(la4, a3, false, linkedHashMap4, linkedHashMap3, jSONObject3, null, null, arrayList2)) {
                    return null;
                }
                a(arrayList2, arrayList);
                linkedHashMap = linkedHashMap3;
                jSONObject2 = jSONObject3;
                linkedHashMap2 = linkedHashMap4;
            }
            try {
                b2.putOpt("children", a((int) ba.f4127a, jSONObject, a((int) ba.f4127a, jSONArray)));
                if (linkedHashMap2 != null) {
                    this.f4154h = linkedHashMap2;
                    this.f4153g = linkedHashMap;
                    this.i = jSONObject2;
                    la2 = la;
                } else {
                    la2 = la;
                    this.f4154h.put(g2, la2);
                    if (la2.j() != null && (lowerCase = la2.b().toLowerCase()) != null) {
                        this.i.put(lowerCase, la2);
                    }
                }
            } catch (JSONException e3) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e3);
                return null;
            }
        }
        C();
        return la2;
    }

    private String f(Ha ha) {
        return ha == null ? "/" : ha.j() == null ? ha.i() : ha.b();
    }

    public List<C0225c> f() {
        return b(this.k.c().optJSONArray("components"), f((Ha) null), t().g());
    }

    public void a(AdobeCollaborationRoleType adobeCollaborationRoleType) {
        String str;
        if (adobeCollaborationRoleType == AdobeCollaborationRoleType.ADOBE_COLLABORATION_ROLE_TYPE_EDITOR) {
            str = "editor";
        } else {
            str = adobeCollaborationRoleType == AdobeCollaborationRoleType.ADOBE_COLLABORATION_ROLE_TYPE_VIEWER ? "viewer" : "owner";
        }
        JSONObject optJSONObject = this.f4152f.optJSONObject("local");
        if (optJSONObject != null) {
            try {
                optJSONObject.putOpt("collaboration_role", str);
            } catch (JSONException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e2);
            }
        } else {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("collaboration_role", str);
                this.f4152f.putOpt("local", jSONObject);
            } catch (JSONException e3) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e3);
            }
        }
        this.m = true;
    }

    public List<C0225c> d(Ha ha) {
        JSONObject j = j(ha.g());
        if (j == null) {
            return null;
        }
        return b(j.optJSONArray("components"), f(ha), ha.g());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0225c f(C0225c c0225c) throws AdobeDCXException {
        Ba ba = new Ba();
        return b(c0225c, a(c0225c.b(), ba), ba.f4127a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Na d(String str) {
        Ha ha = this.f4154h.get(str);
        if (ha == null) {
            return null;
        }
        La la = (La) ha;
        Na m = la.m();
        if (m != null) {
            return m;
        }
        Na na = new Na(la, null);
        la.a(na);
        return na;
    }

    public void a(JSONObject jSONObject) {
        this.n = jSONObject;
    }

    public void a(URI uri) {
        try {
            JSONObject optJSONObject = this.f4152f.optJSONObject("local");
            if (uri != null && optJSONObject != null) {
                optJSONObject.putOpt("compositeHref", uri);
            } else if (uri != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("compositeHref", uri);
                this.f4152f.putOpt("local", jSONObject);
            } else if (optJSONObject != null) {
                optJSONObject.remove("compositeHref");
            }
        } catch (JSONException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e2);
        }
        this.m = true;
    }

    private long b(String str, JSONArray jSONArray) {
        for (int i = 0; i < jSONArray.length(); i++) {
            String optString = jSONArray.optJSONObject(i).optString("id", null);
            if (optString != null && optString.equals(str)) {
                return i;
            }
        }
        return -1L;
    }

    @SuppressLint({"Assert"})
    public void a(Object obj, String str) {
        String str2 = "The key " + str + "is a reserved key for a AdobeDCXManifest.";
        if (!str.equals("children")) {
            str.equals("components");
        }
        try {
            if (o().contains(str)) {
                this.f4152f.putOpt(str, obj);
            } else {
                this.k.a(obj, str);
            }
            C();
        } catch (JSONException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e2);
        }
    }

    public final Map<String, C0225c> b() {
        return this.f4153g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ha b(C0225c c0225c) {
        String str;
        if (c0225c == null || (str = c0225c.f4329d) == null) {
            return null;
        }
        return this.f4154h.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ha b(Ha ha, long j) throws AdobeDCXException {
        com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(ha != null, "Node must not be null");
        com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(true ^ ha.l(), "Root Node cannot be moved");
        return a(ha, this.k.c(), j);
    }

    private void a(JSONObject jSONObject, String str, String str2) {
        JSONArray optJSONArray = jSONObject.optJSONArray("components");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    String optString = jSONObject2.optString("id", null);
                    if (optString == null) {
                        optString = com.adobe.creativesdk.foundation.internal.storage.model.util.i.a();
                        jSONObject2.putOpt("id", optString);
                    }
                    C0225c a2 = C0225c.a(jSONObject2, this, str, str2);
                    this.f4153g.put(optString, a2);
                    this.i.put(a2.a().toLowerCase(), a2);
                } catch (JSONException e2) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e2);
                }
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("children");
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                try {
                    JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                    String optString2 = jSONObject3.optString("id", null);
                    if (optString2 == null) {
                        optString2 = com.adobe.creativesdk.foundation.internal.storage.model.util.i.a();
                        jSONObject3.putOpt("id", optString2);
                    }
                    La a3 = La.a(jSONObject3, this, str, str2);
                    this.f4154h.put(optString2, a3);
                    if (a3.j() != null) {
                        this.i.put(a3.b().toLowerCase(), a3);
                        a(jSONObject3, Za.c(str, a3.j()), a3.g());
                    } else {
                        a(jSONObject3, str, a3.g());
                    }
                } catch (JSONException e3) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ha b(Ha ha, Ha ha2, long j) throws AdobeDCXException {
        com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(ha != null, "Node must not be null");
        com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(true ^ ha.l(), "Root Node cannot be moved");
        return a(ha, j(ha2.g()), j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long b(Ha ha) {
        if (ha.l()) {
            return -1L;
        }
        Ba ba = new Ba();
        ba.f4127a = 0L;
        return a(ha.g(), this.k.c(), ba);
    }

    private boolean a(String str, JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null || optJSONArray.length() != 0) {
            return false;
        }
        jSONObject.remove(str);
        return true;
    }

    private static List<JSONObject> a(JSONArray jSONArray) {
        int length = jSONArray.length();
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(optJSONObject);
            }
        }
        return arrayList;
    }

    private static JSONArray a(int i, JSONArray jSONArray) {
        List<JSONObject> a2 = a(jSONArray);
        a2.remove(i);
        JSONArray jSONArray2 = new JSONArray();
        Iterator<JSONObject> it = a2.iterator();
        while (it.hasNext()) {
            jSONArray2.put(it.next());
        }
        return jSONArray2;
    }

    private static JSONArray a(int i, JSONObject jSONObject, JSONArray jSONArray) {
        List<JSONObject> a2 = a(jSONArray);
        a2.add(i, jSONObject);
        JSONArray jSONArray2 = new JSONArray();
        Iterator<JSONObject> it = a2.iterator();
        while (it.hasNext()) {
            jSONArray2.put(it.next());
        }
        return jSONArray2;
    }

    private long a(String str, JSONArray jSONArray) {
        for (int i = 0; i < jSONArray.length(); i++) {
            String optString = jSONArray.optJSONObject(i).optString("id", null);
            if (optString != null && optString.equals(str)) {
                return i;
            }
        }
        return -1L;
    }

    @SuppressLint({"Assert"})
    @Deprecated
    private La a(Ha ha, JSONObject jSONObject, long j, String str, String str2) throws AdobeDCXException {
        String g2 = ha.g();
        if (this.f4154h.get(g2) == null) {
            String lowerCase = ha.j() == null ? null : Za.c(str, ha.j()).toLowerCase();
            if (lowerCase != null && this.i.opt(lowerCase) != null) {
                throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorDuplicatePath, "Duplicate absolute path: " + lowerCase);
            }
            if (lowerCase != null && !Za.c(lowerCase)) {
                throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorInvalidPath, "Absolute paths cannot begin with /manifest or /mimetype: " + lowerCase);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("children");
            JSONObject a2 = com.adobe.creativesdk.foundation.internal.storage.model.util.d.a(ha.c());
            if (optJSONArray == null) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(a2);
                try {
                    jSONObject.putOpt("children", jSONArray);
                } catch (JSONException e2) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e2);
                    return null;
                }
            } else {
                try {
                    jSONObject.putOpt("children", a((int) j, a2, optJSONArray));
                } catch (JSONException e3) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e3);
                    return null;
                }
            }
            La la = new La(a2, this, str, str2);
            if (lowerCase != null) {
                try {
                    this.i.putOpt(lowerCase, la);
                } catch (JSONException e4) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e4);
                    return null;
                }
            }
            this.f4154h.put(g2, la);
            C();
            return la;
        }
        throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorDuplicateId, "Duplicate node id: " + g2);
    }

    private La a(Ha ha, JSONObject jSONObject, long j) throws AdobeDCXException {
        ArrayList arrayList;
        String str;
        La la;
        Ba ba = new Ba();
        JSONObject b2 = b(ha.g(), ba);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (b2 != jSONObject) {
            LinkedHashMap<String, C0225c> linkedHashMap = new LinkedHashMap<>();
            LinkedHashMap<String, Ha> linkedHashMap2 = new LinkedHashMap<>();
            JSONObject jSONObject2 = new JSONObject();
            com.adobe.creativesdk.foundation.internal.storage.model.util.d.b(this.f4153g, linkedHashMap);
            com.adobe.creativesdk.foundation.internal.storage.model.util.d.a(this.f4154h, linkedHashMap2);
            com.adobe.creativesdk.foundation.internal.storage.model.util.d.a(this.i, jSONObject2);
            if (!a(ha, linkedHashMap2, linkedHashMap, jSONObject2, null, arrayList3)) {
                return null;
            }
            Ha ha2 = this.f4154h.get(jSONObject.optString("id"));
            La la2 = new La(ha.c(), this, f(ha2), ha2.g());
            la = la2;
            arrayList = arrayList3;
            str = null;
            if (!a(la2, la2.c(), false, linkedHashMap2, linkedHashMap, jSONObject2, null, null, arrayList2)) {
                return null;
            }
            this.i = jSONObject2;
            this.f4153g = linkedHashMap;
            this.f4154h = linkedHashMap2;
        } else {
            arrayList = arrayList3;
            str = null;
            la = new La(ha.c(), this, ha.i(), ha.h());
        }
        JSONArray optJSONArray = b2.optJSONArray("children");
        JSONObject optJSONObject = optJSONArray.optJSONObject((int) ba.f4127a);
        try {
            b2.putOpt("children", a((int) ba.f4127a, optJSONArray));
        } catch (JSONException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), str, e2);
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("children");
        if (optJSONArray2 == null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(optJSONObject);
            try {
                jSONObject.putOpt("children", jSONArray);
            } catch (JSONException e3) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), str, e3);
            }
        } else {
            try {
                jSONObject.putOpt("children", a((int) j, optJSONObject, optJSONArray2));
            } catch (JSONException e4) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), str, e4);
            }
        }
        a(arrayList2, arrayList);
        C();
        return la;
    }

    private C0225c a(C0225c c0225c, JSONObject jSONObject, String str, boolean z) throws AdobeDCXException {
        String b2 = c0225c.b();
        JSONObject a2 = com.adobe.creativesdk.foundation.internal.storage.model.util.d.a(c0225c.c());
        if (str != null) {
            try {
                a2.putOpt("path", str);
                b2 = com.adobe.creativesdk.foundation.internal.storage.model.util.i.a();
                a2.putOpt("id", b2);
                a2.remove("etag");
                a2.remove(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION);
                a2.putOpt(ServerProtocol.DIALOG_PARAM_STATE, "modified");
            } catch (JSONException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e2);
                return null;
            }
        }
        String optString = a2.optString("path", null);
        if (Za.d(optString)) {
            C0225c c0225c2 = this.f4153g.get(b2);
            if (!z && c0225c2 != null) {
                throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorDuplicateId, "Duplicate id: " + b2);
            }
            Ba ba = new Ba();
            if (z) {
                jSONObject = a(b2, ba);
            } else {
                ba.f4127a = jSONObject.length();
            }
            Ha ha = this.f4154h.get(jSONObject.optString("id"));
            C0225c a3 = C0225c.a(a2, this, f(ha), ha.g());
            String lowerCase = a3.a().toLowerCase();
            String lowerCase2 = z ? c0225c2.a().toLowerCase() : null;
            if (lowerCase != null && !Za.c(lowerCase)) {
                throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorInvalidPath, "Absolute paths cannot begin with /manifest or /mimetype: %s" + lowerCase);
            }
            if ((z && lowerCase.equals(lowerCase2)) || this.i.opt(lowerCase) == null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("components");
                if (optJSONArray == null) {
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(a2);
                    try {
                        jSONObject.putOpt("components", jSONArray);
                    } catch (JSONException e3) {
                        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e3);
                        return null;
                    }
                } else if (z) {
                    try {
                        jSONObject.putOpt("components", a((int) ba.f4127a, a2, a((int) ba.f4127a, optJSONArray)));
                    } catch (JSONException e4) {
                        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e4);
                        return null;
                    }
                } else {
                    optJSONArray.put(a2);
                }
                this.f4153g.put(b2, a3);
                try {
                    this.i.put(lowerCase, a3);
                    if (lowerCase2 != null && !lowerCase.equals(lowerCase2)) {
                        this.i.remove(lowerCase2);
                    }
                    C();
                    return a3;
                } catch (JSONException e5) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e5);
                    return null;
                }
            }
            throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorDuplicatePath, "Duplicate absoulte path: " + lowerCase);
        }
        throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorInvalidPath, "Invalid path: " + optString);
    }

    private C0225c a(C0225c c0225c, JSONObject jSONObject, long j) {
        String b2 = c0225c.b();
        JSONArray optJSONArray = jSONObject.optJSONArray("components");
        if (j == -1) {
            j = b(b2, optJSONArray);
        }
        JSONArray a2 = a((int) j, optJSONArray);
        try {
            jSONObject.putOpt("components", a2);
        } catch (JSONException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e2);
        }
        if (a2.length() == 0) {
            jSONObject.remove("components");
        }
        this.f4153g.remove(b2);
        this.i.remove(c0225c.a().toLowerCase());
        C();
        return c0225c;
    }

    public void a(Ha ha, List<C0225c> list) {
        a(ha.f4172a, list);
    }

    void a(JSONObject jSONObject, List<C0225c> list) {
        JSONArray optJSONArray = jSONObject.optJSONArray("components");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                list.add(this.f4153g.get(optJSONArray.optJSONObject(i).optString("id")));
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("children");
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                a(optJSONArray2.optJSONObject(i2), list);
            }
        }
    }

    private JSONObject a(String str, Ba ba) {
        Ha b2;
        C0225c c0225c = this.f4153g.get(str);
        if (c0225c == null || (b2 = b(c0225c)) == null) {
            return null;
        }
        JSONObject c2 = b2.c();
        JSONArray optJSONArray = c2 != null ? c2.optJSONArray("components") : null;
        if (optJSONArray == null) {
            return null;
        }
        long b3 = b(str, optJSONArray);
        if (b3 == -1) {
            return null;
        }
        ba.f4127a = b3;
        if (b2.c() != null) {
            return b2.c();
        }
        return null;
    }

    private long a(String str, JSONObject jSONObject, Ba ba) {
        JSONArray optJSONArray = jSONObject.optJSONArray("children");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject.optString("id").equals(str)) {
                    return ba.f4127a;
                }
                ba.f4127a++;
                long a2 = a(str, optJSONObject, ba);
                if (a2 != -1) {
                    return a2;
                }
            }
        }
        return -1L;
    }

    private ArrayList<Ha> a(JSONArray jSONArray, String str, String str2) {
        ArrayList<Ha> arrayList = new ArrayList<>();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(new La(jSONArray.optJSONObject(i), this, str, str2));
            }
        }
        return arrayList;
    }

    public final Map<String, Ha> a() {
        return this.f4154h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ha a(Ha ha, Ba ba) {
        Ha ha2;
        String h2 = ha.h();
        if (h2 == null) {
            return null;
        }
        if (h2.equals(this.k.g())) {
            ha2 = this.k;
        } else {
            ha2 = this.f4154h.get(ha.h());
        }
        if (ha2 != null && ba != null) {
            JSONArray optJSONArray = ha2.c().optJSONArray("children");
            if (optJSONArray == null) {
                return null;
            }
            long a2 = a(ha.g(), optJSONArray);
            if (a2 == -1) {
                return null;
            }
            ba.f4127a = a2;
        }
        return ha2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v7, types: [java.io.IOException] */
    public boolean a(String str, boolean z) throws AdobeDCXException {
        JSONException e2;
        if (z) {
            String a2 = com.adobe.creativesdk.foundation.internal.storage.model.util.i.a();
            JSONObject optJSONObject = this.f4152f.optJSONObject("local");
            if (optJSONObject != null) {
                try {
                    optJSONObject.put("manifestSaveId", a2);
                } catch (JSONException e3) {
                    e2 = e3;
                    Za.a("csdk_android_dcx", "DCXManifest-writeToFile", "reason:" + e2.getMessage(), "saveID:" + a2);
                }
            } else {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("manifestSaveId", a2);
                    this.f4152f.put("local", jSONObject);
                } catch (JSONException e4) {
                    e2 = e4;
                    Za.a("csdk_android_dcx", "DCXManifest-writeToFile1", "reason:" + e2.getMessage(), "saveID:" + a2);
                }
            }
        }
        e2 = null;
        Object opt = this.f4152f.opt("manifest-format-version");
        if (opt == null || !(opt instanceof Number)) {
            Za.a("csdk_android_dcx", "DCXManifest-writeToFile", "manifest-format-version missing", this.f4152f.toString());
        }
        String n = n();
        if (n != null && e2 == null) {
            try {
                if (Za.b(str, n).booleanValue()) {
                    this.m = false;
                    return true;
                }
            } catch (IOException e5) {
                e2 = e5;
            }
        }
        throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorManifestWriteFailure, null, e2, str);
    }

    public static Fa a(String str) throws AdobeDCXException {
        try {
            String b2 = Za.b(str);
            if (b2 != null) {
                try {
                    return new Fa(b2);
                } catch (AdobeDCXException e2) {
                    Za.a("csdk_android_dcx", "createManifestWithContentsOfFile", "dcxManifestCreation failed - reason:" + e2.getMessage(), "manifest data:" + b2);
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "CSDK::Release::DCX", "Failure inside createManifestWithContentsOfFile-2 path= " + str);
                    throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorInvalidManifest, e2.getDescription(), e2, str);
                }
            }
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "CSDK::Release::DCX", "Failure inside createManifestWithContentsOfFile-1 path= " + str);
            throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorManifestReadFailure, "Empty manifest file", null, str);
        } catch (FileNotFoundException e3) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXManifest.createManifestWithContentsOfFile", e3.getMessage(), e3);
            throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorManifestReadFailure, "Manifest not found", e3, str);
        } catch (UnsupportedEncodingException e4) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "CSDK::Release::DCX", "Failure inside fread path= " + str);
            Za.a("csdk_android_dcx", "createManifestWithContentsOfFile", "freadFailed - reason:" + e4.getMessage(), "manifest data:" + ((String) null));
            throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorInvalidManifest, "Manifest unsupported encoding", e4, str);
        } catch (IOException e5) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXManifest.createManifestWithContentsOfFile", e5.getMessage(), e5);
            throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorManifestReadFailure, "Manifest IO exception ", e5, str);
        }
    }

    public C0225c a(C0225c c0225c, Fa fa, String str) throws AdobeDCXException {
        C0225c a2 = a(c0225c, this.k.c(), str, false);
        if (a2 != null && fa != null) {
            a(a2, c0225c, fa);
        }
        return a2;
    }

    public C0225c a(C0225c c0225c, Fa fa, Ha ha, String str) throws AdobeDCXException {
        JSONObject j = j(ha.g());
        com.adobe.creativesdk.foundation.internal.storage.model.util.e.b(j != null, "Node with id " + ha.g() + " not found\nManifest contains node: " + this.f4154h.containsKey(ha.g()));
        C0225c a2 = a(c0225c, j, str, false);
        if (a2 != null && fa != null) {
            a(a2, c0225c, fa);
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0225c a(C0225c c0225c, Fa fa) throws AdobeDCXException {
        return a(c0225c, (JSONObject) null, (String) null, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(C0225c c0225c) {
        return x() && c0225c.d() != null && c0225c.d().length() > 0;
    }

    private void a(JSONObject jSONObject, JSONObject jSONObject2) {
        Object opt = jSONObject2.opt("children");
        if (opt != null) {
            try {
                jSONObject.putOpt("children", opt);
            } catch (JSONException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e2);
            }
        } else {
            jSONObject.remove("children");
        }
        Object opt2 = jSONObject2.opt("components");
        if (opt2 != null) {
            try {
                jSONObject.putOpt("components", opt2);
                return;
            } catch (JSONException e3) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e3);
                return;
            }
        }
        jSONObject.remove("components");
    }

    boolean a(Ha ha, JSONObject jSONObject, boolean z, LinkedHashMap<String, Ha> linkedHashMap, LinkedHashMap<String, C0225c> linkedHashMap2, JSONObject jSONObject2, List<C0225c> list, List<String> list2, List<Ha> list3) throws AdobeDCXException {
        List<String> list4 = list2;
        List<Ha> list5 = list3;
        String str = "id";
        String optString = jSONObject.optString("id");
        if (linkedHashMap.get(optString) != null) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeDCXManifest.recursivelyAddNode", "Childe node with id " + optString + " already exists");
            return false;
        }
        linkedHashMap.put(optString, ha);
        String str2 = null;
        if (ha.j() != null) {
            String lowerCase = ha.b().toLowerCase();
            if (lowerCase != null && !Za.c(lowerCase)) {
                throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorInvalidPath, "Absolute paths cannot begin with /manifest or /mimetype %s" + lowerCase);
            }
            if (jSONObject2.opt(lowerCase) != null) {
                throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorDuplicatePath, "Child node with absolute path " + lowerCase + " already exists");
            }
            try {
                jSONObject2.putOpt(lowerCase, ha);
            } catch (JSONException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e2);
                return false;
            }
        }
        String f2 = f(ha);
        JSONArray optJSONArray = jSONObject.optJSONArray("children");
        if (optJSONArray != null) {
            int i = 0;
            while (i < optJSONArray.length()) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (z) {
                    try {
                        optJSONObject.putOpt(str, com.adobe.creativesdk.foundation.internal.storage.model.util.i.a());
                    } catch (JSONException e3) {
                        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), str2, e3);
                        return false;
                    }
                }
                int i2 = i;
                JSONArray jSONArray = optJSONArray;
                String str3 = f2;
                String str4 = str;
                List<String> list6 = list4;
                if (!a(new La(optJSONObject, this, f2, ha.g()), optJSONObject, z, linkedHashMap, linkedHashMap2, jSONObject2, list, list2, list3)) {
                    return false;
                }
                i = i2 + 1;
                list5 = list3;
                list4 = list6;
                f2 = str3;
                str = str4;
                optJSONArray = jSONArray;
                str2 = null;
            }
        }
        String str5 = f2;
        String str6 = str;
        List<String> list7 = list4;
        JSONArray optJSONArray2 = jSONObject.optJSONArray("components");
        if (optJSONArray2 != null) {
            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i3);
                if (list7 != null) {
                    list7.add(optJSONObject2.optString(str6));
                }
                if (z) {
                    try {
                        optJSONObject2.putOpt(str6, com.adobe.creativesdk.foundation.internal.storage.model.util.i.a());
                        optJSONObject2.remove("etag");
                        optJSONObject2.remove(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION);
                        optJSONObject2.putOpt(ServerProtocol.DIALOG_PARAM_STATE, "modified");
                    } catch (JSONException e4) {
                        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e4);
                        return false;
                    }
                }
                C0225c a2 = C0225c.a(optJSONObject2, this, str5, ha.g());
                if (linkedHashMap2.get(a2.b()) != null) {
                    throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorDuplicateId, "Component with id " + a2.b() + " already exists.");
                }
                if (list != null) {
                    list.add(a2);
                }
                linkedHashMap2.put(a2.b(), a2);
                String lowerCase2 = a2.a().toLowerCase();
                if (lowerCase2 != null && !Za.c(lowerCase2)) {
                    throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorInvalidPath, "Absolute paths cannot begin with /manifest or /mimetype: %s" + lowerCase2);
                }
                if (jSONObject2.opt(lowerCase2) != null) {
                    throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorDuplicatePath, "Component with absolute path " + lowerCase2 + " already exists.");
                }
                try {
                    jSONObject2.putOpt(lowerCase2, a2);
                } catch (JSONException e5) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e5);
                    return false;
                }
            }
        }
        if (list3 == null) {
            return true;
        }
        list3.add(ha);
        return true;
    }

    boolean a(Ha ha, LinkedHashMap<String, Ha> linkedHashMap, LinkedHashMap<String, C0225c> linkedHashMap2, JSONObject jSONObject, List<C0225c> list, List<Ha> list2) {
        String g2 = ha.g();
        JSONObject j = j(g2);
        linkedHashMap.remove(g2);
        if (list2 != null) {
            list2.add(ha);
        }
        if (ha.j() != null) {
            jSONObject.remove(ha.b().toLowerCase());
        }
        JSONArray optJSONArray = j.optJSONArray("children");
        if (optJSONArray != null) {
            int i = 0;
            while (i < optJSONArray.length()) {
                int i2 = i;
                if (!a(linkedHashMap.get(optJSONArray.optJSONObject(i).optString("id")), linkedHashMap, linkedHashMap2, jSONObject, list, list2)) {
                    return false;
                }
                i = i2 + 1;
            }
        }
        JSONArray optJSONArray2 = j.optJSONArray("components");
        if (optJSONArray2 == null) {
            return true;
        }
        for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
            C0225c c0225c = linkedHashMap2.get(optJSONArray2.optJSONObject(i3).optString("id"));
            linkedHashMap2.remove(c0225c.b());
            jSONObject.remove(c0225c.a().toLowerCase());
            if (list != null) {
                list.add(c0225c);
            }
        }
        return true;
    }

    public Ha a(Ha ha) throws AdobeDCXException {
        return a(ha, this.k.c(), this.k.c().optJSONArray("children") != null ? r2.length() : 0L, f((Ha) null), t().g());
    }

    public Ha a(Ha ha, Ha ha2) throws AdobeDCXException {
        JSONObject j = j(ha2.g());
        return a(ha, j, j.optJSONArray("children") != null ? r2.length() : 0L, f(ha2), ha2.g());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ha a(Ha ha, long j) throws AdobeDCXException {
        return a(ha, this.k.c(), j, f((Ha) null), t().g());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ha a(Ha ha, Ha ha2, long j) throws AdobeDCXException {
        return a(ha, j(ha2.g()), j, f(ha2), ha2.g());
    }

    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2, types: [com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha, java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v3 */
    public Ha a(Ha ha, Fa fa, Ha ha2, long j, boolean z, String str, String str2, boolean z2, List<C0225c> list, List<String> list2, List<C0225c> list3) throws AdobeDCXException {
        Ha ha3;
        JSONObject jSONObject;
        La a2;
        JSONObject jSONObject2;
        LinkedHashMap<String, Ha> linkedHashMap;
        La la;
        Ba ba;
        String str3;
        LinkedHashMap<String, C0225c> linkedHashMap2;
        ?? r11;
        C0225c c0225c;
        Ha ha4;
        boolean z3 = ha.g() == t().g();
        JSONObject a3 = com.adobe.creativesdk.foundation.internal.storage.model.util.d.a(fa.j(ha.g()));
        if (z3) {
            a3.remove("path");
        } else if (str != null) {
            try {
                a3.putOpt("path", str);
            } catch (JSONException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e2);
                return null;
            }
        }
        if (str2 != null) {
            try {
                a3.putOpt("id", str2);
            } catch (JSONException e3) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e3);
                return null;
            }
        } else if ((str != null || z2) && !z) {
            try {
                a3.putOpt("id", com.adobe.creativesdk.foundation.internal.storage.model.util.i.a());
            } catch (JSONException e4) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e4);
                return null;
            }
        }
        String optString = a3.optString("id", null);
        Ha ha5 = this.f4154h.get(optString);
        if (z || ha5 == null) {
            Ba ba2 = new Ba();
            ba2.f4127a = j;
            if (!z) {
                jSONObject = ha2 != null ? j(ha2.g()) : this.k.c();
                ha3 = ha2;
            } else if (z3) {
                ha3 = ha2;
                jSONObject = null;
            } else {
                JSONObject b2 = b(optString, ba2);
                ha3 = this.f4154h.get(b2.optString("id"));
                jSONObject = b2;
            }
            String f2 = f(ha3);
            if (z3) {
                a2 = new La(a3, "", (String) null);
                a2.a(true);
            } else {
                if (ha3 == null) {
                    ha3 = t();
                }
                a2 = La.a(a3, this, f2, ha3.g());
            }
            La la2 = a2;
            if (la2.b() != null && !z3 && !Za.c(la2.b())) {
                throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorInvalidPath, String.format("Absolute paths cannot begin with /manifest or /mimetype: %s", la2.b()));
            }
            if (la2.j() != null && (ha4 = (Ha) this.i.opt(la2.b().toLowerCase())) != null) {
                if (!ha4.g().equals(ha5 != null ? ha5.g() : null)) {
                    throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorDuplicatePath, "Child node with absolute path " + la2.b().toLowerCase() + " already exists.");
                }
            }
            LinkedHashMap<String, C0225c> linkedHashMap3 = new LinkedHashMap<>();
            LinkedHashMap<String, Ha> linkedHashMap4 = new LinkedHashMap<>();
            JSONObject jSONObject3 = new JSONObject();
            com.adobe.creativesdk.foundation.internal.storage.model.util.d.b(this.f4153g, linkedHashMap3);
            com.adobe.creativesdk.foundation.internal.storage.model.util.d.a(this.f4154h, linkedHashMap4);
            com.adobe.creativesdk.foundation.internal.storage.model.util.d.a(this.i, jSONObject3);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (ha5 != null) {
                jSONObject2 = jSONObject3;
                linkedHashMap = linkedHashMap4;
                la = la2;
                ba = ba2;
                str3 = optString;
                linkedHashMap2 = linkedHashMap3;
                r11 = 0;
                if (!a(ha5, linkedHashMap, linkedHashMap3, jSONObject2, list3, arrayList2)) {
                    return null;
                }
            } else {
                jSONObject2 = jSONObject3;
                linkedHashMap = linkedHashMap4;
                la = la2;
                ba = ba2;
                str3 = optString;
                linkedHashMap2 = linkedHashMap3;
                r11 = 0;
            }
            if (!a(la, a3, str != null || z2, linkedHashMap, linkedHashMap2, jSONObject2, list, list2, arrayList)) {
                return r11;
            }
            if (jSONObject != null) {
                try {
                    if (z) {
                        jSONObject.optJSONArray("children").put((int) ba.f4127a, a3);
                    } else {
                        JSONArray optJSONArray = jSONObject.optJSONArray("children");
                        if (optJSONArray == null) {
                            JSONArray jSONArray = new JSONArray();
                            jSONArray.put(a3);
                            jSONObject.putOpt("children", jSONArray);
                        } else {
                            jSONObject.putOpt("children", a((int) (j > ((long) (optJSONArray.length() + (-1))) ? optJSONArray.length() : j), a3, optJSONArray));
                        }
                    }
                } catch (JSONException e5) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), r11, e5);
                    return r11;
                }
            }
            String str4 = r11;
            LinkedHashMap linkedHashMap5 = (LinkedHashMap) this.f4153g.clone();
            this.f4154h = linkedHashMap;
            this.f4153g = linkedHashMap2;
            this.i = jSONObject2;
            if (z3) {
                this.k = la;
            }
            a(arrayList, arrayList2);
            C();
            if (list3 != null) {
                Iterator<C0225c> it = list3.iterator();
                while (it.hasNext()) {
                    a(str4, it.next());
                }
            }
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    C0225c c0225c2 = list.get(i);
                    if (linkedHashMap5.get(c0225c2.b()) == null && (c0225c = fa.b().get(list2.get(i))) != null) {
                        a(c0225c2, c0225c, fa);
                    }
                }
            }
            return this.f4154h.get(str3);
        }
        throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorDuplicateId, "Childe node with id " + optString + " already exists.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ha a(Ha ha, ArrayList<C0225c> arrayList) {
        com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(ha != null, "Node must not be null");
        com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(!ha.l(), "Root Node cannot be removed");
        String g2 = ha.g();
        com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(g2 != null, "Node must have an id");
        Ba ba = new Ba();
        JSONObject b2 = b(g2, ba);
        com.adobe.creativesdk.foundation.internal.storage.model.util.e.b(b2 != null, "Child node with id " + g2 + " could not be found.\nManifest contains node: " + this.f4154h.containsKey(g2) + "\nParent Id: " + ha.h() + ".\nManifest contains parent node: " + this.f4154h.containsKey(ha.h()));
        JSONArray optJSONArray = b2.optJSONArray("children");
        ArrayList arrayList2 = new ArrayList();
        a(ha, this.f4154h, this.f4153g, this.i, arrayList, arrayList2);
        JSONArray a2 = a((int) ba.f4127a, optJSONArray);
        try {
            b2.putOpt("children", a2);
        } catch (JSONException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Fa.class.getSimpleName(), null, e2);
        }
        if (a2.length() == 0) {
            b2.remove("children");
        }
        a((List<Ha>) null, arrayList2);
        C();
        return ha;
    }

    public static void a(Fa fa, Fa fa2) {
        String d2;
        for (Map.Entry<String, C0225c> entry : fa.f4153g.entrySet()) {
            String key = entry.getKey();
            C0225c value = entry.getValue();
            C0225c c0225c = fa2 != null ? fa2.f4153g.get(key) : null;
            if (c0225c != null && value.d().equals(c0225c.d()) && (d2 = fa2.d(c0225c)) != null) {
                fa.b(d2, value);
            }
        }
    }

    private void a(List<Ha> list, List<Ha> list2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(list == null ? 0 : list.size());
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                La la = (La) list.get(i);
                String g2 = la.g();
                if (g2 != null) {
                    linkedHashMap.put(g2, la);
                }
            }
        }
        if (list2 != null) {
            for (int i2 = 0; i2 < list2.size(); i2++) {
                La la2 = (La) list2.get(i2);
                Na m = la2.m();
                if (m != null) {
                    La la3 = (La) linkedHashMap.get(la2.g());
                    if (la3 != null) {
                        m.a(la3);
                        la3.a(m);
                    } else {
                        m.g();
                    }
                    la2.a((Na) null);
                }
            }
        }
    }

    public boolean a(Fa fa) {
        if (this == fa) {
            return true;
        }
        if (fa == null) {
            return false;
        }
        if (h() != null) {
            if (h().equals(fa.h())) {
                return true;
            }
        } else if (fa.h() == null) {
            return true;
        }
        return false;
    }
}
