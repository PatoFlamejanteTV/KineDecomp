package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.facebook.internal.ServerProtocol;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdobeDCXMutableComponent.java */
/* loaded from: classes.dex */
public class Ka extends C0225c {
    public Ka(JSONObject jSONObject, Fa fa, String str, String str2) {
        super(jSONObject, fa, str, str2);
    }

    private void r() {
        this.f4326a = new JSONObject();
        try {
            this.f4326a.put("id", "");
            this.f4326a.put("path", "");
            this.f4326a.put("name", "");
            this.f4326a.put("type", "");
            this.f4326a.put("_links", (Object) null);
            this.f4326a.put(ServerProtocol.DIALOG_PARAM_STATE, "");
            this.f4326a.put("etag", "");
        } catch (JSONException unused) {
        }
    }

    public void a(long j) {
        try {
            this.f4326a.put("length", j);
        } catch (JSONException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXMutableComponent.setLength", e2.getMessage());
        }
    }

    public void b(String str) {
        if (str != null) {
            try {
                this.f4326a.put("id", str);
                return;
            } catch (JSONException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXMutableComponent.setComponentId", e2.getMessage());
                return;
            }
        }
        this.f4326a.remove("id");
    }

    public void c(String str) {
        if (str != null) {
            try {
                this.f4326a.put("etag", str);
                return;
            } catch (JSONException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXMutableComponent.setEtag", e2.getMessage());
                return;
            }
        }
        this.f4326a.remove("etag");
    }

    public void d(String str) {
        if (str != null) {
            try {
                this.f4326a.put("md5", str);
                return;
            } catch (JSONException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXMutableComponent.setMd5", e2.getMessage());
                return;
            }
        }
        this.f4326a.remove("md5");
    }

    public void e(String str) {
        if (str != null) {
            try {
                this.f4326a.put("path", str);
                return;
            } catch (JSONException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXMutableComponent.setPath", e2.getMessage());
                return;
            }
        }
        this.f4326a.remove("path");
    }

    public void f(String str) {
        if (str != null) {
            try {
                this.f4326a.put("rel", str);
                return;
            } catch (JSONException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXMutableComponent.setRelationship", e2.getMessage());
                return;
            }
        }
        this.f4326a.remove("rel");
    }

    public void g(String str) {
        if (str != null) {
            try {
                this.f4326a.put(ServerProtocol.DIALOG_PARAM_STATE, str);
                return;
            } catch (JSONException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXMutableComponent.setState", e2.getMessage());
                return;
            }
        }
        this.f4326a.remove(ServerProtocol.DIALOG_PARAM_STATE);
    }

    public void h(String str) {
        try {
            this.f4326a.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, str);
        } catch (JSONException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXMutableComponent.setVersion", e2.getMessage());
        }
    }

    public Ka(String str, String str2, String str3, String str4, JSONObject jSONObject, String str5) {
        r();
        try {
            if (str == null) {
                this.f4326a.put("id", com.adobe.creativesdk.foundation.internal.storage.model.util.i.a());
            } else {
                this.f4326a.put("id", str);
            }
            if (str2 != null) {
                this.f4326a.put("path", str2);
            }
            if (str3 != null) {
                this.f4326a.put("name", str3);
            }
            if (str4 != null) {
                this.f4326a.put("type", str4);
            }
            if (jSONObject != null) {
                this.f4326a.put("_links", str4);
            }
            if (str5 != null) {
                this.f4326a.put(ServerProtocol.DIALOG_PARAM_STATE, str5);
            }
        } catch (JSONException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXMutableComponent.Constructor", e2.getMessage());
        }
    }

    public void a(int i) {
        try {
            this.f4326a.put("height", i);
        } catch (JSONException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXMutableComponent.setHeight", e2.getMessage());
        }
    }

    public void b(int i) {
        try {
            this.f4326a.put("width", i);
        } catch (JSONException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXMutableComponent.setWidth", e2.getMessage());
        }
    }

    public void a(Object obj, String str) {
        com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(!Fa.r().contains(str), String.format("The key %s is a reserved key for a AdobeDCXMutableComponent.", str));
        try {
            this.f4326a.putOpt(str, obj);
        } catch (JSONException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXMutableComponent.setValue", e2.getMessage());
        }
    }
}
