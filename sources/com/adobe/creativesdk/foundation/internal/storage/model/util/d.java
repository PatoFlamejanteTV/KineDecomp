package com.adobe.creativesdk.foundation.internal.storage.model.util;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0225c;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdobeStorageCopyUtils.java */
/* loaded from: classes.dex */
public class d {
    public static void a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                jSONObject2.put(next, jSONObject.get(next));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void b(Map<String, C0225c> map, Map<String, C0225c> map2) {
        if (map == null || map2 == null) {
            return;
        }
        for (Map.Entry<String, C0225c> entry : map.entrySet()) {
            map2.put(entry.getKey(), entry.getValue());
        }
    }

    public static void a(JSONObject jSONObject, JSONArray jSONArray) {
        if (jSONObject == null || jSONArray == null) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                jSONArray.put(jSONObject.get(keys.next()));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(Map<String, Ha> map, Map<String, Ha> map2) {
        if (map == null || map2 == null) {
            return;
        }
        for (Map.Entry<String, Ha> entry : map.entrySet()) {
            map2.put(entry.getKey(), entry.getValue());
        }
    }

    public static void a(Map<String, C0225c> map, ArrayList<C0225c> arrayList) {
        if (map == null || arrayList == null) {
            return;
        }
        Iterator<Map.Entry<String, C0225c>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue());
        }
    }

    public static JSONObject a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                Object obj = jSONObject.get(next);
                if (obj.getClass().equals(JSONObject.class)) {
                    jSONObject2.put(next, a((JSONObject) obj));
                } else if (obj.getClass().equals(JSONArray.class)) {
                    jSONObject2.put(next, a((JSONArray) obj));
                } else {
                    jSONObject2.put(next, obj);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject2;
    }

    public static JSONArray a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        JSONArray jSONArray2 = new JSONArray();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            try {
                Object obj = jSONArray.get(i);
                if (obj.getClass().equals(JSONObject.class)) {
                    jSONArray2.put(i, a((JSONObject) obj));
                } else if (obj.getClass().equals(JSONArray.class)) {
                    jSONArray2.put(i, a((JSONArray) obj));
                } else {
                    jSONArray2.put(i, obj);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONArray2;
    }
}
