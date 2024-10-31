package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdobeDCXManifestNode.java */
/* loaded from: classes.dex */
public class Ha {

    /* renamed from: a */
    protected JSONObject f4172a;

    /* renamed from: b */
    protected WeakReference<Fa> f4173b;

    /* renamed from: c */
    protected String f4174c;

    /* renamed from: d */
    protected String f4175d;

    /* renamed from: e */
    protected boolean f4176e;

    public Object a(String str) {
        return this.f4172a.opt(str);
    }

    public String b() {
        if (j() == null) {
            return null;
        }
        return Za.c(i(), j());
    }

    public final JSONObject c() {
        return this.f4172a;
    }

    public final Fa d() {
        WeakReference<Fa> weakReference = this.f4173b;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public La e() {
        JSONObject jSONObject = new JSONObject();
        Iterator<String> keys = this.f4172a.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!next.equals("children") && !next.equals("components")) {
                try {
                    Object obj = this.f4172a.get(next);
                    if (obj.getClass().equals(JSONObject.class)) {
                        jSONObject.put(next, com.adobe.creativesdk.foundation.internal.storage.model.util.d.a((JSONObject) obj));
                    } else if (obj.getClass().equals(JSONArray.class)) {
                        jSONObject.put(next, com.adobe.creativesdk.foundation.internal.storage.model.util.d.a((JSONArray) obj));
                    } else {
                        jSONObject.put(next, obj);
                    }
                } catch (JSONException e2) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXManifestNode.getMutableCopy", e2.getMessage());
                }
            }
        }
        La la = new La(jSONObject, this.f4174c, this.f4175d);
        if (this.f4176e) {
            la.f4176e = true;
        }
        return la;
    }

    public String f() {
        return this.f4172a.optString("name", null);
    }

    public String g() {
        return this.f4172a.optString("id", null);
    }

    public String h() {
        return this.f4175d;
    }

    public String i() {
        return this.f4174c;
    }

    public String j() {
        return this.f4176e ? "/" : this.f4172a.optString("path", null);
    }

    public String k() {
        return this.f4172a.optString("type", null);
    }

    public boolean l() {
        return this.f4176e;
    }

    public long a() {
        Fa fa;
        WeakReference<Fa> weakReference = this.f4173b;
        if (weakReference == null || (fa = weakReference.get()) == null) {
            return -1L;
        }
        return fa.b(this);
    }
}
