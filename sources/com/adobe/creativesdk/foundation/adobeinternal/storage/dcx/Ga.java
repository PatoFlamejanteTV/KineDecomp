package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import android.support.v4.app.NotificationCompat;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdobeDCXManifestFormatConverter.java */
/* loaded from: classes.dex */
public class Ga {

    /* renamed from: a, reason: collision with root package name */
    static JSONObject f4163a = new JSONObject();

    public static boolean a(JSONObject jSONObject, long j) {
        if (j < 1 && !f(jSONObject)) {
            return false;
        }
        if (j < 2 && !g(jSONObject)) {
            return false;
        }
        if (j < 3 && !h(jSONObject)) {
            return false;
        }
        if (j < 4 && !i(jSONObject)) {
            return false;
        }
        if (j < 5 && !j(jSONObject)) {
            return false;
        }
        if (j > 6 || k(jSONObject)) {
            return (jSONObject.optJSONObject("local") != null ? jSONObject.optJSONObject("local").optInt(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, 0) : 0) >= 1 || e(jSONObject);
        }
        return false;
    }

    static boolean b(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("components");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("_links");
                    String optString = optJSONObject.optString("etag");
                    if (optJSONObject2 != null && optString != null) {
                        JSONObject optJSONObject3 = optJSONObject2.optJSONObject("stormcloud#asset");
                        if (optJSONObject3 != null) {
                            try {
                                optJSONObject3.put("etag", optString);
                            } catch (JSONException unused) {
                            }
                        }
                        optJSONObject.remove("etag");
                    }
                }
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("children");
        if (optJSONArray2 == null) {
            return true;
        }
        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
            if (!b(optJSONArray2.optJSONObject(i2))) {
                Za.a("csdk_android_dcx", "FromatConverter-recursiveUpdateComponentsToVersion3", "inside for lopp", jSONObject.toString());
                return false;
            }
        }
        return true;
    }

    static boolean c(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return true;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("components");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("_links")) != null) {
                    if (optJSONObject.opt("stormcloud#asset") != null) {
                        optJSONObject.remove("stormcloud#asset");
                    }
                    if (optJSONObject.opt("stormcloud#asset-version") != null) {
                        optJSONObject.remove("stormcloud#asset-version");
                    }
                    if (optJSONObject.length() == 0) {
                        optJSONObject2.remove("_links");
                    }
                }
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("children");
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                if (!c(optJSONArray2.optJSONObject(i2))) {
                    Za.a("csdk_android_dcx", "FromatConverter-recursiveUpdateComponentsToVersion4", "inside for loop", jSONObject.toString());
                    return false;
                }
            }
        }
        return true;
    }

    static boolean d(JSONObject jSONObject) {
        Object opt;
        JSONArray optJSONArray = jSONObject.optJSONArray("components");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null && (opt = optJSONObject.opt(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION)) != null && !(opt instanceof String)) {
                    if (!(opt instanceof Number)) {
                        Za.a("csdk_android_dcx", "ManifestConverter-Recursive6", "versionValue: " + opt.toString(), jSONObject.toString());
                        return false;
                    }
                    try {
                        optJSONObject.putOpt(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, opt.toString());
                    } catch (JSONException e2) {
                        Za.a("csdk_android_dcx", "ManifestConverter-Recursive6", e2.getMessage(), jSONObject.toString());
                        e2.printStackTrace();
                        return false;
                    }
                }
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("children");
        if (optJSONArray2 == null) {
            return true;
        }
        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
            if (!d(optJSONArray2.optJSONObject(i2))) {
                Za.a("csdk_android_dcx", "ManifestConverter-Recursive6", "inside for loop", jSONObject.toString());
                return false;
            }
        }
        return true;
    }

    static boolean e(JSONObject jSONObject) {
        String optString;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("local");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
                jSONObject.put("local", optJSONObject);
            }
            if (optJSONObject.opt("manifestEtag") == null && (optString = jSONObject.optString("etag", null)) != null) {
                optJSONObject.put("manifestEtag", optString);
                jSONObject.remove("etag");
            }
            optJSONObject.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, 1);
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    static boolean f(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("_links");
        if (optJSONObject == null) {
            Za.a("csdk_android_dcx", "FromatConverter-updateManifestDictionaryToVersion1", "_links", jSONObject.toString());
            return false;
        }
        try {
            String optString = optJSONObject.optJSONObject("self").optString("etag");
            if (optString != null) {
                jSONObject.put("etag", optString);
                optJSONObject.optJSONObject("self").remove("etag");
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("components");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                    if (optJSONObject2 != null) {
                        if (optJSONObject2.opt("id") == null) {
                            optJSONObject2.put("id", com.adobe.creativesdk.foundation.internal.storage.model.util.i.a());
                        }
                        String optString2 = optJSONObject2.optString(ShareConstants.WEB_DIALOG_PARAM_HREF);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(ShareConstants.WEB_DIALOG_PARAM_HREF, optString2);
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(ShareConstants.WEB_DIALOG_PARAM_HREF, optString2);
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("self", jSONObject2);
                        jSONObject4.put("latest-version", jSONObject3);
                        optJSONObject2.put("_links", jSONObject4);
                        optJSONObject2.remove(ShareConstants.WEB_DIALOG_PARAM_HREF);
                    }
                }
                jSONObject.put("components", optJSONArray);
                optJSONObject.remove("components");
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("container");
            if (optJSONObject3 != null) {
                optJSONObject.put("dma#container", optJSONObject3);
                optJSONObject.remove("container");
            }
            jSONObject.put("manifest-format-version", 1);
            return true;
        } catch (JSONException e2) {
            Za.a("csdk_android_dcx", "FromatConverter-updateManifestDictionaryToVersion1", e2.getMessage(), jSONObject.toString());
            return false;
        }
    }

    static boolean g(JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("_links");
            if (optJSONObject != null) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("dma#container");
                if (optJSONObject2 != null) {
                    optJSONObject2.put(NotificationCompat.CATEGORY_SERVICE, "stormcloud");
                    optJSONObject.put("dma#document", optJSONObject2);
                    optJSONObject.remove("dma#container");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("self");
                if (optJSONObject3 != null) {
                    optJSONObject.put("stormcloud#asset", optJSONObject3);
                    optJSONObject.remove("self");
                }
            }
            if (!a(jSONObject)) {
                Za.a("csdk_android_dcx", "FromatConverter-updateManifestDictionaryToVersion2", "recursivecomponents2 failed", jSONObject.toString());
                return false;
            }
            jSONObject.put("manifest-format-version", 2);
            return true;
        } catch (JSONException e2) {
            Za.a("csdk_android_dcx", "FromatConverter-updateManifestDictionaryToVersion2", e2.getMessage(), jSONObject.toString());
            return false;
        }
    }

    static boolean h(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("_links");
        String optString = jSONObject.optString("etag");
        if (optJSONObject != null && optString != null) {
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("stormcloud#asset");
            if (optJSONObject2 != null) {
                try {
                    optJSONObject2.put("etag", optString);
                } catch (JSONException unused) {
                }
            }
            jSONObject.remove("etag");
        }
        if (!b(jSONObject)) {
            Za.a("csdk_android_dcx", "FromatConverter-updateManifestDictionaryToVersion3", "components3 failure", jSONObject.toString());
            return false;
        }
        try {
            jSONObject.put("manifest-format-version", 3);
            return true;
        } catch (JSONException e2) {
            e2.printStackTrace();
            Za.a("csdk_android_dcx", "FromatConverter-updateManifestDictionaryToVersion3", e2.getMessage(), jSONObject.toString());
            return false;
        }
    }

    static boolean i(JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("_links");
            if (optJSONObject != null) {
                if (optJSONObject.opt("stormcloud#asset") != null) {
                    optJSONObject.remove("stormcloud#asset");
                }
                if (optJSONObject.opt("dma#document") != null) {
                    optJSONObject.remove("dma#document");
                }
                if (optJSONObject.length() == 0) {
                    jSONObject.remove("_links");
                }
            }
            if (!c(jSONObject)) {
                Za.a("csdk_android_dcx", "FromatConverter-updateManifestDictionaryToVersion4", "components4 failure", jSONObject.toString());
                return false;
            }
            if (f4163a.length() == 0) {
                f4163a.put("application/vnd.adobe.html+cd", "application/vnd.adobe.html+dcx");
                f4163a.put("application/vnd.adobe.violet.sketchBook+cd", "application/vnd.adobe.sketch.project+dcx");
                f4163a.put("application/vnd.adobe.test+cd", "application/vnd.adobe.test+dcx");
            }
            String optString = f4163a.optString(jSONObject.optString("type"));
            if (optString != null) {
                jSONObject.put("type", optString);
            }
            jSONObject.put("manifest-format-version", 4);
            return true;
        } catch (JSONException e2) {
            Za.a("csdk_android_dcx", "FromatConverter-updateManifestDictionaryToVersion4", e2.getMessage(), jSONObject.toString());
            return false;
        }
    }

    static boolean j(JSONObject jSONObject) {
        JSONObject a2 = a(jSONObject, new JSONObject());
        if (a2 == null) {
            Za.a("csdk_android_dcx", "FromatConverter-updateManifestDictionaryToVersion5", "storageIdLookup", jSONObject.toString());
            return false;
        }
        try {
            if (a2.length() > 0) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("copyOnWrite#storageIds", a2);
                jSONObject.put("local", jSONObject2);
            }
            jSONObject.put("manifest-format-version", 5);
            return true;
        } catch (JSONException e2) {
            Za.a("csdk_android_dcx", "FromatConverter-updateManifestDictionaryToVersion5", e2.getMessage(), jSONObject.toString());
            return false;
        }
    }

    static boolean k(JSONObject jSONObject) {
        if (jSONObject.optString("path", null) != null) {
            jSONObject.remove("path");
        }
        if (!d(jSONObject)) {
            Za.a("csdk_android_dcx", "FromatConverter-updateManifestDictionaryToVersion6", "component6 failure", jSONObject.toString());
            return false;
        }
        try {
            jSONObject.put("manifest-format-version", 6);
            return true;
        } catch (JSONException e2) {
            e2.printStackTrace();
            Za.a("csdk_android_dcx", "FromatConverter-updateManifestDictionaryToVersion6", e2.getMessage(), jSONObject.toString());
            return false;
        }
    }

    static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        String optString;
        if (jSONObject == null) {
            return jSONObject2;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("components");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null && (optString = optJSONObject.optString("localStorageAssetId")) != null) {
                    try {
                        jSONObject2.put(optJSONObject.optString("id"), optString);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    optJSONObject.remove("localStorageAssetId");
                }
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("children");
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                jSONObject2 = a(optJSONArray2.optJSONObject(i2), jSONObject2);
                if (jSONObject2 == null) {
                    return null;
                }
            }
        }
        return jSONObject2;
    }

    static boolean a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("components");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                    if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("_links")) != null) {
                        JSONObject optJSONObject3 = optJSONObject.optJSONObject("latest-version");
                        JSONObject optJSONObject4 = optJSONObject.optJSONObject("self");
                        if (optJSONObject3 != null) {
                            optJSONObject.put("stormcloud#asset", optJSONObject3);
                            optJSONObject.remove("latest-version");
                        }
                        if (optJSONObject4 != null) {
                            optJSONObject.put("stormcloud#asset-version", optJSONObject4);
                            optJSONObject.remove("self");
                        }
                        if (optJSONObject3 != null && optJSONObject4 == null) {
                            optJSONObject.put("stormcloud#asset-version", optJSONObject3);
                        } else if (optJSONObject3 == null && optJSONObject4 != null) {
                            optJSONObject.put("stormcloud#asset", optJSONObject4);
                        }
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("children");
            if (optJSONArray2 == null) {
                return true;
            }
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                if (!a(optJSONArray2.optJSONObject(i2))) {
                    Za.a("csdk_android_dcx", "FromatConverter-recursiveUpdateComponentsToVersion2", "inside for looop", jSONObject.toString());
                    return false;
                }
            }
            return true;
        } catch (JSONException e2) {
            e2.printStackTrace();
            Za.a("csdk_android_dcx", "FromatConverter-recursiveUpdateComponentsToVersion2", e2.getMessage(), jSONObject.toString());
            return false;
        }
    }
}
