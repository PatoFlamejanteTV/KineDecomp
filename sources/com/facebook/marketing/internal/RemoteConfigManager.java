package com.facebook.marketing.internal;

import android.os.Bundle;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.share.internal.ShareConstants;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class RemoteConfigManager {
    private static final String SAMPLING_ENDPOINT_PATH = "%s/button_auto_detection_device_selection";
    private static final String SAMPLING_RESULT_FIELD = "is_selected";
    private static final String TAG = "com.facebook.marketing.internal.RemoteConfigManager";
    private static final Map<String, RemoteConfig> remoteConfigs = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject getRemoteConfigQueryResponse(String str, String str2) {
        try {
            String format = String.format(Locale.US, SAMPLING_ENDPOINT_PATH, str);
            Bundle bundle = new Bundle();
            bundle.putString("device_id", str2);
            bundle.putString(GraphRequest.FIELDS_PARAM, SAMPLING_RESULT_FIELD);
            GraphRequest graphRequest = new GraphRequest(null, format, bundle, HttpMethod.GET, null);
            graphRequest.setSkipClientToken(true);
            return graphRequest.executeAndWait().getJSONObject();
        } catch (Exception e2) {
            Log.e(TAG, "fail to request button sampling api", e2);
            return new JSONObject();
        }
    }

    public static RemoteConfig getRemoteConfigWithoutQuery(String str) {
        if (str != null) {
            return remoteConfigs.get(str);
        }
        return null;
    }

    public static void loadRemoteConfig() {
        FacebookSdk.getExecutor().execute(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void parseRemoteConfigFromJSON(String str, JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONArray optJSONArray = jSONObject.optJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA);
        if (optJSONArray == null || optJSONArray.length() <= 0 || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
            return;
        }
        remoteConfigs.put(str, new RemoteConfig(optJSONObject.optBoolean(SAMPLING_RESULT_FIELD, false)));
    }
}
