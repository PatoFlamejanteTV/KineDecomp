package com.facebook.marketing.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.facebook.GraphRequest;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ButtonIndexingLogger {
    private static final String API_ENDPOINT = "%s/button_indexing";
    private static final String TAG = "com.facebook.marketing.internal.ButtonIndexingLogger";
    private static volatile Set<String> clickedKeySet = new HashSet();
    private static volatile Set<String> loadedKeySet = new HashSet();

    private static JSONObject generateButtonDetail(View view, String str, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            String[] split = str.split("\\.", -1);
            int length = split.length - 1;
            View view2 = view;
            while (view2 != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("classname", view2.getClass().getCanonicalName());
                jSONObject2.put("index", split[length]);
                jSONObject2.put("id", view2.getId());
                jSONObject2.put("text", ViewHierarchy.getTextOfView(view2));
                String str2 = "";
                jSONObject2.put("tag", view2.getTag() == null ? "" : String.valueOf(view2.getTag()));
                if (view2.getContentDescription() != null) {
                    str2 = String.valueOf(view2.getContentDescription());
                }
                jSONObject2.put("description", str2);
                jSONArray.put(jSONObject2);
                view2 = ViewHierarchy.getParentOfView(view2);
                length--;
            }
            JSONArray jSONArray2 = new JSONArray();
            for (int length2 = jSONArray.length() - 1; length2 >= 0; length2--) {
                jSONArray2.put(jSONArray.get(length2));
            }
            jSONObject.put("path", jSONArray2);
            jSONObject.put("is_from_click", z);
            if (view instanceof ImageView) {
                Bitmap bitmap = ((BitmapDrawable) ((ImageView) view).getDrawable()).getBitmap();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                jSONObject.put(MessengerShareContentUtility.MEDIA_IMAGE, Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0));
            }
            return jSONObject;
        } catch (Exception e2) {
            Log.e(TAG, "Log button indexing error", e2);
            return new JSONObject();
        }
    }

    public static void logAllIndexing(String str, HashMap<String, WeakReference<View>> hashMap, Context context) {
        View view;
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry<String, WeakReference<View>> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            if (!loadedKeySet.contains(key) && (view = entry.getValue().get()) != null) {
                loadedKeySet.add(key);
                JSONObject generateButtonDetail = generateButtonDetail(view, key, false);
                if (generateButtonDetail.length() > 0) {
                    jSONArray.put(generateButtonDetail.toString());
                }
            }
        }
        if (jSONArray.length() > 0) {
            sendGraphAPIRequest(context, jSONArray.toString(), str);
        }
    }

    public static void logIndexing(String str, View view, String str2, Context context) {
        if (clickedKeySet.contains(str2)) {
            return;
        }
        clickedKeySet.add(str2);
        JSONObject generateButtonDetail = generateButtonDetail(view, str2, true);
        if (generateButtonDetail.length() > 0) {
            sendGraphAPIRequest(context, new JSONArray((Collection) Arrays.asList(generateButtonDetail.toString())).toString(), str);
        }
    }

    private static void sendGraphAPIRequest(Context context, String str, String str2) {
        AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(context);
        if (attributionIdentifiers == null || attributionIdentifiers.getAndroidAdvertiserId() == null) {
            return;
        }
        String androidAdvertiserId = attributionIdentifiers.getAndroidAdvertiserId();
        String appVersion = MarketingUtils.getAppVersion();
        Bundle bundle = new Bundle();
        try {
            bundle.putString("app_version", appVersion);
            bundle.putString("device_id", androidAdvertiserId);
            bundle.putString("indexed_button_list", str);
            GraphRequest newPostRequest = GraphRequest.newPostRequest(null, String.format(Locale.US, API_ENDPOINT, str2), null, null);
            newPostRequest.setParameters(bundle);
            newPostRequest.executeAndWait().getJSONObject().toString();
        } catch (Exception e2) {
            Log.e(TAG, "failed to send button indexing request", e2);
        }
    }
}
