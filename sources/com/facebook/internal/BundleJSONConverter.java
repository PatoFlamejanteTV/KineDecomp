package com.facebook.internal;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class BundleJSONConverter {
    private static final Map<Class<?>, Setter> SETTERS = new HashMap();

    /* loaded from: classes.dex */
    public interface Setter {
        void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException;

        void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException;
    }

    static {
        SETTERS.put(Boolean.class, new b());
        SETTERS.put(Integer.class, new c());
        SETTERS.put(Long.class, new d());
        SETTERS.put(Double.class, new e());
        SETTERS.put(String.class, new f());
        SETTERS.put(String[].class, new g());
        SETTERS.put(JSONArray.class, new h());
    }

    public static JSONObject convertToJSON(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null) {
                if (obj instanceof List) {
                    JSONArray jSONArray = new JSONArray();
                    Iterator it = ((List) obj).iterator();
                    while (it.hasNext()) {
                        jSONArray.put((String) it.next());
                    }
                    jSONObject.put(str, jSONArray);
                } else if (obj instanceof Bundle) {
                    jSONObject.put(str, convertToJSON((Bundle) obj));
                } else {
                    Setter setter = SETTERS.get(obj.getClass());
                    if (setter == null) {
                        throw new IllegalArgumentException("Unsupported type: " + obj.getClass());
                    }
                    setter.setOnJSON(jSONObject, str, obj);
                }
            }
        }
        return jSONObject;
    }

    public static Bundle convertToBundle(JSONObject jSONObject) throws JSONException {
        Bundle bundle = new Bundle();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj != null && obj != JSONObject.NULL) {
                if (obj instanceof JSONObject) {
                    bundle.putBundle(next, convertToBundle((JSONObject) obj));
                } else {
                    Setter setter = SETTERS.get(obj.getClass());
                    if (setter == null) {
                        throw new IllegalArgumentException("Unsupported type: " + obj.getClass());
                    }
                    setter.setOnBundle(bundle, next, obj);
                }
            }
        }
        return bundle;
    }
}
