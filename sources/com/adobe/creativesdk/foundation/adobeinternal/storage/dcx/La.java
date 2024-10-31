package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdobeDCXMutableManifestNode.java */
/* loaded from: classes.dex */
public class La extends Ha {

    /* renamed from: f, reason: collision with root package name */
    private WeakReference<Na> f4198f;

    public La(String str, String str2, String str3) {
        n();
        try {
            this.f4172a.put("id", com.adobe.creativesdk.foundation.internal.storage.model.util.i.a());
            if (str != null) {
                this.f4172a.put("type", str);
            }
            if (str3 != null) {
                this.f4172a.put("name", str3);
            }
            if (str2 != null) {
                this.f4172a.put("path", str2);
            }
        } catch (JSONException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXMutableManifestNode.Constructor", e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static La a(JSONObject jSONObject, Fa fa, String str, String str2) {
        return new La(jSONObject, fa, str, str2);
    }

    private void n() {
        this.f4172a = new JSONObject();
    }

    public void b(String str) {
        com.adobe.creativesdk.foundation.internal.storage.model.util.e.a((str.equals("children") || str.equals("components")) ? false : true, "The key " + str + " is a reserved key for a AdobeDCXManifestNode.");
        this.f4172a.remove(str);
    }

    public void c(String str) {
        if (str != null) {
            try {
                this.f4172a.put("name", str);
                return;
            } catch (JSONException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXMutableManifestNode.setName", e2.getMessage());
                return;
            }
        }
        this.f4172a.remove("name");
    }

    public void d(String str) {
        if (str != null) {
            try {
                this.f4172a.put("id", str);
                return;
            } catch (JSONException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXMutableManifestNode.setNodeId", e2.getMessage());
                return;
            }
        }
        this.f4172a.remove("id");
    }

    public void e(String str) {
        if (str != null) {
            try {
                this.f4172a.put("type", str);
                return;
            } catch (JSONException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXMutableManifestNode.setType", e2.getMessage());
                return;
            }
        }
        this.f4172a.remove("type");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Na m() {
        WeakReference<Na> weakReference = this.f4198f;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static La a(JSONObject jSONObject, Fa fa) {
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!Fa.o().contains(next)) {
                try {
                    jSONObject2.putOpt(next, jSONObject.opt(next));
                } catch (JSONException e2) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, La.class.getSimpleName(), null, e2);
                }
            }
        }
        try {
            jSONObject2.putOpt("id", fa.h());
        } catch (JSONException e3) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, La.class.getSimpleName(), null, e3);
        }
        La la = new La(jSONObject2, fa, "", null);
        la.f4176e = true;
        return la;
    }

    public La(JSONObject jSONObject, String str, String str2) {
        this.f4172a = jSONObject;
        this.f4174c = str;
        this.f4175d = str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public La(JSONObject jSONObject, Fa fa, String str, String str2) {
        this.f4172a = jSONObject;
        this.f4173b = new WeakReference<>(fa);
        this.f4174c = str;
        this.f4175d = str2;
        this.f4176e = false;
    }

    public void a(Object obj, String str) {
        com.adobe.creativesdk.foundation.internal.storage.model.util.e.a((str.equals("children") || str.equals("components")) ? false : true, "The key " + str + " is a reserved key for a AdobeDCXManifestNode.");
        try {
            this.f4172a.put(str, obj);
        } catch (JSONException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXMutableManifestNode.setValue", e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z) {
        this.f4176e = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Na na) {
        this.f4198f = new WeakReference<>(na);
    }
}
