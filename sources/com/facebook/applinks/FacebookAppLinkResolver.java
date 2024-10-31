package com.facebook.applinks;

import a.b;
import a.g;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class FacebookAppLinkResolver {
    private static final String APP_LINK_ANDROID_TARGET_KEY = "android";
    private static final String APP_LINK_KEY = "app_links";
    private static final String APP_LINK_TARGET_APP_NAME_KEY = "app_name";
    private static final String APP_LINK_TARGET_CLASS_KEY = "class";
    private static final String APP_LINK_TARGET_PACKAGE_KEY = "package";
    private static final String APP_LINK_TARGET_SHOULD_FALLBACK_KEY = "should_fallback";
    private static final String APP_LINK_TARGET_URL_KEY = "url";
    private static final String APP_LINK_WEB_TARGET_KEY = "web";
    private final HashMap<Uri, a.b> cachedAppLinks = new HashMap<>();

    public g<a.b> getAppLinkFromUrlInBackground(Uri uri) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(uri);
        return getAppLinkFromUrlsInBackground(arrayList).b(new b(this, uri));
    }

    public g<Map<Uri, a.b>> getAppLinkFromUrlsInBackground(List<Uri> list) {
        a.b bVar;
        HashMap hashMap = new HashMap();
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (Uri uri : list) {
            synchronized (this.cachedAppLinks) {
                bVar = this.cachedAppLinks.get(uri);
            }
            if (bVar != null) {
                hashMap.put(uri, bVar);
            } else {
                if (!hashSet.isEmpty()) {
                    sb.append(',');
                }
                sb.append(uri.toString());
                hashSet.add(uri);
            }
        }
        if (hashSet.isEmpty()) {
            return g.a(hashMap);
        }
        g.a a2 = g.a();
        Bundle bundle = new Bundle();
        bundle.putString("ids", sb.toString());
        bundle.putString(GraphRequest.FIELDS_PARAM, String.format("%s.fields(%s,%s)", APP_LINK_KEY, APP_LINK_ANDROID_TARGET_KEY, "web"));
        new GraphRequest(AccessToken.getCurrentAccessToken(), "", bundle, null, new c(this, a2, hashMap, hashSet)).executeAsync();
        return a2.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static b.a getAndroidTargetFromJson(JSONObject jSONObject) {
        String tryGetStringFromJson = tryGetStringFromJson(jSONObject, APP_LINK_TARGET_PACKAGE_KEY, null);
        if (tryGetStringFromJson == null) {
            return null;
        }
        String tryGetStringFromJson2 = tryGetStringFromJson(jSONObject, APP_LINK_TARGET_CLASS_KEY, null);
        String tryGetStringFromJson3 = tryGetStringFromJson(jSONObject, "app_name", null);
        String tryGetStringFromJson4 = tryGetStringFromJson(jSONObject, "url", null);
        return new b.a(tryGetStringFromJson, tryGetStringFromJson2, tryGetStringFromJson4 != null ? Uri.parse(tryGetStringFromJson4) : null, tryGetStringFromJson3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Uri getWebFallbackUriFromJson(Uri uri, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("web");
            if (!tryGetBooleanFromJson(jSONObject2, APP_LINK_TARGET_SHOULD_FALLBACK_KEY, true)) {
                return null;
            }
            String tryGetStringFromJson = tryGetStringFromJson(jSONObject2, "url", null);
            Uri parse = tryGetStringFromJson != null ? Uri.parse(tryGetStringFromJson) : null;
            return parse != null ? parse : uri;
        } catch (JSONException e) {
            return uri;
        }
    }

    private static String tryGetStringFromJson(JSONObject jSONObject, String str, String str2) {
        try {
            return jSONObject.getString(str);
        } catch (JSONException e) {
            return str2;
        }
    }

    private static boolean tryGetBooleanFromJson(JSONObject jSONObject, String str, boolean z) {
        try {
            return jSONObject.getBoolean(str);
        } catch (JSONException e) {
            return z;
        }
    }
}
