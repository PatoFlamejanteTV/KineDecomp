package com.google.firebase.database.util;

import com.facebook.internal.ServerProtocol;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class JsonMapper {
    public static String a(Map<String, Object> map) throws IOException {
        return a((Object) map);
    }

    public static Object b(String str) throws IOException {
        try {
            return b(new JSONTokener(str).nextValue());
        } catch (JSONException e2) {
            throw new IOException(e2);
        }
    }

    public static String a(Object obj) throws IOException {
        if (obj == null) {
            return "null";
        }
        if (obj instanceof String) {
            return JSONObject.quote((String) obj);
        }
        if (obj instanceof Number) {
            try {
                return JSONObject.numberToString((Number) obj);
            } catch (JSONException e2) {
                throw new IOException("Could not serialize number", e2);
            }
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue() ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
        }
        try {
            JSONStringer jSONStringer = new JSONStringer();
            a(obj, jSONStringer);
            return jSONStringer.toString();
        } catch (JSONException e3) {
            throw new IOException("Failed to serialize JSON", e3);
        }
    }

    private static Object b(Object obj) throws JSONException {
        if (obj instanceof JSONObject) {
            return a((JSONObject) obj);
        }
        if (obj instanceof JSONArray) {
            return a((JSONArray) obj);
        }
        if (obj.equals(JSONObject.NULL)) {
            return null;
        }
        return obj;
    }

    private static void a(Object obj, JSONStringer jSONStringer) throws IOException, JSONException {
        if (obj instanceof Map) {
            jSONStringer.object();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                jSONStringer.key((String) entry.getKey());
                a(entry.getValue(), jSONStringer);
            }
            jSONStringer.endObject();
            return;
        }
        if (obj instanceof Collection) {
            jSONStringer.array();
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                a(it.next(), jSONStringer);
            }
            jSONStringer.endArray();
            return;
        }
        jSONStringer.value(obj);
    }

    public static Map<String, Object> a(String str) throws IOException {
        try {
            return a(new JSONObject(str));
        } catch (JSONException e2) {
            throw new IOException(e2);
        }
    }

    private static Map<String, Object> a(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap(jSONObject.length());
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, b(jSONObject.get(next)));
        }
        return hashMap;
    }

    private static List<Object> a(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(b(jSONArray.get(i)));
        }
        return arrayList;
    }
}
