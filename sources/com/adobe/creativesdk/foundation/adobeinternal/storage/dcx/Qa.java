package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdobeDCXPushJournal.java */
/* loaded from: classes.dex */
public class Qa extends Ca {

    /* renamed from: c, reason: collision with root package name */
    private JSONObject f4225c;

    /* renamed from: d, reason: collision with root package name */
    private JSONObject f4226d;

    /* renamed from: e, reason: collision with root package name */
    private JSONArray f4227e;

    /* renamed from: f, reason: collision with root package name */
    private JSONObject f4228f;

    /* renamed from: g, reason: collision with root package name */
    private WeakReference<C0231f> f4229g;

    Qa(C0231f c0231f, String str, boolean z) throws AdobeDCXException {
        super(str, new Oa(c0231f), z ? null : new Pa(c0231f));
        this.f4229g = new WeakReference<>(c0231f);
        this.f4225c = c().optJSONObject("uploaded-components");
        this.f4226d = c().optJSONObject("deleted-components");
        this.f4227e = c().optJSONArray("pending-delete-components");
        this.f4228f = c().optJSONObject("immutable-path-to-href-lookup");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Qa a(C0231f c0231f, String str) throws AdobeDCXException {
        return new Qa(c0231f, str, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Qa b(C0231f c0231f, String str) throws AdobeDCXException {
        return new Qa(c0231f, str, false);
    }

    public boolean c(C0225c c0225c) {
        boolean z;
        synchronized (this) {
            z = Za.a(c0225c.b(), this.f4227e) != -1;
        }
        return z;
    }

    public String d(C0225c c0225c) {
        synchronized (this) {
            JSONObject optJSONObject = this.f4225c.optJSONObject(c0225c.b());
            if (optJSONObject == null) {
                return null;
            }
            return optJSONObject.optString("srcHref");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ka e(C0225c c0225c) {
        Ka ka;
        synchronized (this) {
            JSONObject optJSONObject = this.f4225c.optJSONObject(c0225c.b());
            if (optJSONObject != null) {
                ka = c0225c.i();
                a(optJSONObject, ka);
            } else {
                ka = null;
            }
        }
        return ka;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(C0225c c0225c) {
        synchronized (this) {
            try {
                this.f4226d.put(c0225c.b(), c0225c.k());
            } catch (JSONException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXPushJournal.recordDeletionOfComponent", e2.getMessage());
            }
            this.f4225c.remove(c0225c.b());
            int a2 = Za.a(c0225c.b(), this.f4227e);
            if (a2 >= 0) {
                try {
                    this.f4227e.put(a2, (Object) null);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            e();
            d();
        }
    }

    public String g() {
        return c().optString("composite-href");
    }

    boolean h() {
        return c().optString("etag", null) != null;
    }

    boolean i() {
        return c().optString(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, null) != null;
    }

    public boolean j() {
        return (c().optString("push-completed", null) != null && h()) || l();
    }

    public boolean k() {
        return (c() == null || c().optString("composite-created", null) == null) ? false : true;
    }

    public boolean l() {
        return (c() == null || c().optString("composite-deleted", null) == null) ? false : true;
    }

    public boolean m() {
        return c() == null || (c().optJSONObject("deleted-components").length() == 0 && c().optJSONObject("uploaded-components").length() == 0 && !j());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fa fa) {
        if (fa.l() != null) {
            try {
                c().put("etag", fa.l());
                c().put("composite-href", fa.g());
                c().put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, fa.w());
                c().put("push-completed", 1);
            } catch (JSONException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXPushJournal.recordUploadedManifest", e2.getMessage());
            }
        }
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Fa fa) {
        boolean z;
        if (h()) {
            fa.g(c().optString("etag"));
            z = true;
        } else {
            z = false;
        }
        if (i()) {
            fa.i(c().optString(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION));
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(C0225c c0225c) {
        synchronized (this) {
            this.f4227e.put(c0225c.b());
            this.f4225c.remove(c0225c.b());
            this.f4226d.remove(c0225c.b());
            e();
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(C0225c c0225c) {
        boolean z;
        synchronized (this) {
            z = this.f4226d.opt(c0225c.b()) != null;
        }
        return z;
    }

    boolean e() {
        if (c().opt("push-completed") == null) {
            return false;
        }
        c().remove("push-completed");
        this.f4229g.get().g();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(C0225c c0225c, String str, String str2) {
        a(c0225c, str, null, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        if (c() != null) {
            if (str == null) {
                c().remove("composite-href");
            } else {
                try {
                    c().put("composite-href", str);
                } catch (JSONException e2) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXPushJournal.setCompositeHref", e2.getMessage());
                }
            }
            d();
        }
    }

    void a(C0225c c0225c, String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (c0225c.d() != null) {
                jSONObject.put("etag", c0225c.d());
            }
            if (c0225c.f() != 0) {
                jSONObject.put("length", c0225c.f());
            }
            if (c0225c.h() != null) {
                jSONObject.put("md5", c0225c.h());
            }
            if (c0225c.o() != null) {
                jSONObject.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, c0225c.o());
            }
            if (str3 != null) {
                jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_HREF, str3);
            }
            if (str2 != null) {
                jSONObject.put("srcHref", str2);
            }
        } catch (JSONException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXPushJournal.recordUploadedComponent", e2.getMessage());
        }
        synchronized (this) {
            try {
                this.f4225c.put(c0225c.b(), jSONObject);
            } catch (JSONException e3) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXPushJournal.recordUploadedComponent", e3.getMessage());
            }
            if (this.f4228f != null && str != null && str3 != null) {
                try {
                    this.f4228f.put(str, str3);
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }
            this.f4226d.remove(c0225c.b());
            int a2 = Za.a(c0225c.b(), this.f4227e);
            if (a2 >= 0) {
                try {
                    this.f4227e.put(a2, (Object) null);
                } catch (JSONException e5) {
                    e5.printStackTrace();
                }
            }
            e();
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<String> f() {
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<String> keys = this.f4225c.keys();
        while (keys.hasNext()) {
            arrayList.add(keys.next());
        }
        JSONObject jSONObject = this.f4226d;
        if (jSONObject != null && jSONObject.length() > 0) {
            Iterator<String> keys2 = this.f4226d.keys();
            while (keys2.hasNext()) {
                arrayList.add(keys2.next());
            }
        }
        JSONArray jSONArray = this.f4227e;
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i = 0; i < this.f4227e.length(); i++) {
                String optString = this.f4227e.optString(i, null);
                if (optString != null) {
                    arrayList.add(optString);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(boolean z) {
        if (c() != null) {
            if (!z) {
                c().remove("composite-deleted");
            } else {
                try {
                    c().put("composite-deleted", 1);
                } catch (JSONException e2) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXPushJournal.recordCompositeHasBeenDeleted", e2.getMessage());
                }
            }
            d();
        }
    }

    public String a(String str) {
        synchronized (this) {
            if (this.f4228f == null || str == null) {
                return null;
            }
            return this.f4228f.optString(str, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(C0225c c0225c) {
        synchronized (this) {
            boolean z = false;
            if (this.f4225c.has(c0225c.b())) {
                this.f4225c.remove(c0225c.b());
                z = true;
            }
            int a2 = Za.a(c0225c.b(), this.f4227e);
            if (a2 != -1) {
                try {
                    this.f4227e.put(a2, (Object) null);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                z = true;
            }
            if (this.f4226d.has(c0225c.b())) {
                this.f4226d.remove(c0225c.b());
                z = true;
            }
            if (e()) {
                z = true;
            }
            if (z) {
                d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        if (c() != null) {
            if (!z) {
                c().remove("composite-created");
            } else {
                try {
                    c().put("composite-created", 1);
                } catch (JSONException e2) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXPushJournal.recordCompositeHasBeenCreated", e2.getMessage());
                }
            }
            d();
        }
    }

    void a(JSONObject jSONObject, Ka ka) {
        ka.c((String) jSONObject.opt("etag"));
        ka.a(jSONObject.optLong("length"));
        ka.d((String) jSONObject.opt("md5"));
        ka.h(jSONObject.optString(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION));
    }
}
