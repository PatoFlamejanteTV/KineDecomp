package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0225c;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdobeLibraryRepresentation.java */
/* loaded from: classes.dex */
public class Hb {

    /* renamed from: a, reason: collision with root package name */
    protected com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha f7004a;

    /* renamed from: b, reason: collision with root package name */
    private C0225c f7005b;

    /* JADX INFO: Access modifiers changed from: protected */
    public Hb(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha ha) {
        this.f7004a = ha;
        this.f7005b = null;
    }

    public Object a(String str) {
        com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha ha = this.f7004a;
        if (ha != null) {
            return ha.c().opt(str);
        }
        return null;
    }

    public C0225c b() {
        return this.f7005b;
    }

    public URI c() {
        com.adobe.creativesdk.foundation.internal.storage.model.util.e.b(false, "getContentURL not valid on AdobeLibraryRepresentation when using deprecated immutable/mutable model.");
        return null;
    }

    public com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na d() {
        com.adobe.creativesdk.foundation.internal.storage.model.util.e.b(false, "This method not allowed on AdobeLibraryRepresentation when using deprecated immutable/mutable model.");
        return null;
    }

    public int e() {
        Object a2;
        if (g() != null) {
            if (!"application/vnd.adobe.library.link+dcx".equals(h()) || (a2 = a("library#height")) == null) {
                return 0;
            }
            return ((Integer) a2).intValue();
        }
        C0225c c0225c = this.f7005b;
        if (c0225c != null) {
            return c0225c.e();
        }
        return 0;
    }

    @Deprecated
    public com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha f() {
        return this.f7004a;
    }

    public String g() {
        com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha ha = this.f7004a;
        if (ha != null) {
            return ha.g();
        }
        return null;
    }

    public String h() {
        com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha ha = this.f7004a;
        if (ha != null) {
            return ha.k();
        }
        return null;
    }

    public int i() {
        Object a2;
        if (g() != null) {
            Object a3 = a("library#representationOrder");
            if (a3 != null) {
                return ((Integer) a3).intValue();
            }
            return 0;
        }
        C0225c c0225c = this.f7005b;
        if (c0225c == null || (a2 = c0225c.a("library#representationOrder")) == null) {
            return 0;
        }
        return ((Integer) a2).intValue();
    }

    public String j() {
        if (g() != null) {
            String str = (String) a("library#rel");
            return str == null ? (String) a("relationship") : str;
        }
        C0225c c0225c = this.f7005b;
        if (c0225c != null) {
            return c0225c.l();
        }
        return null;
    }

    public String k() {
        if (g() != null) {
            return g();
        }
        C0225c c0225c = this.f7005b;
        if (c0225c != null) {
            return c0225c.b();
        }
        return null;
    }

    public JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        for (String str : a()) {
            if (str.endsWith("#trackingdata")) {
                try {
                    jSONObject.put(str.substring(0, str.lastIndexOf("#trackingdata")), a(str));
                } catch (JSONException e2) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Hb.class.getSimpleName(), null, e2);
                }
            }
        }
        return jSONObject;
    }

    public String m() {
        if (g() != null) {
            if (o()) {
                return (String) a("library#linktype");
            }
            return h();
        }
        C0225c c0225c = this.f7005b;
        if (c0225c != null) {
            return c0225c.n();
        }
        return null;
    }

    public int n() {
        Object a2;
        if (g() != null) {
            if (!"application/vnd.adobe.library.link+dcx".equals(h()) || (a2 = a("library#width")) == null) {
                return 0;
            }
            return ((Integer) a2).intValue();
        }
        C0225c c0225c = this.f7005b;
        if (c0225c != null) {
            return c0225c.p();
        }
        return 0;
    }

    public boolean o() {
        return g() != null && "application/vnd.adobe.library.link+dcx".equals(h());
    }

    public boolean p() {
        int i;
        Object a2;
        if (g() != null) {
            if (!"application/vnd.adobe.library.link+dcx".equals(h()) || (a2 = a("library#isfullSize")) == null) {
                return false;
            }
            i = ((Integer) a2).intValue();
        } else {
            C0225c c0225c = this.f7005b;
            if (c0225c != null) {
                Object a3 = c0225c.a("library#isfullSize");
                if (a3 == null) {
                    return false;
                }
                i = ((Integer) a3).intValue();
            } else {
                i = 0;
            }
        }
        return i != 0;
    }

    public List<String> a() {
        com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha ha = this.f7004a;
        if (ha == null) {
            return new ArrayList();
        }
        Iterator<String> keys = ha.c().keys();
        ArrayList arrayList = new ArrayList();
        while (keys.hasNext()) {
            arrayList.add(keys.next());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Hb(C0225c c0225c) {
        this.f7005b = c0225c;
        this.f7004a = null;
    }

    public Hb() {
    }

    public Object a(String str, String str2) {
        if (str2 == null) {
            return null;
        }
        if (g() != null) {
            return a(String.format("%s#%s", str2, str));
        }
        C0225c c0225c = this.f7005b;
        if (c0225c != null) {
            return c0225c.a(String.format("%s#%s", str2, str));
        }
        return null;
    }

    public boolean a(Object obj, String str, String str2) throws AdobeLibraryException {
        com.adobe.creativesdk.foundation.internal.storage.model.util.e.b(false, "Setters not allowed on AdobeLibraryRepresentation when using deprecated immutable/mutable model.");
        return false;
    }

    public void a(int i) {
        com.adobe.creativesdk.foundation.internal.storage.model.util.e.b(false, "Setters not allowed on AdobeLibraryRepresentation when using deprecated immutable/mutable model.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(C0225c c0225c) {
        this.f7005b = c0225c;
        this.f7004a = null;
    }
}
