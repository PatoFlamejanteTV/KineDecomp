package com.facebook.marketing;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import java.util.Locale;

/* loaded from: classes.dex */
public class FacebookUninstallTracker {
    private static final String SUCCESS = "success";
    private static final String TAG = "com.facebook.marketing.FacebookUninstallTracker";
    private static final String UPLOADED_TOKEN_STORE = "com.facebook.marketing.FacebookUninstallTracker.UPLOADED_TOKEN";
    private static final SharedPreferences uploadedTokenSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences(UPLOADED_TOKEN_STORE, 0);

    /* JADX INFO: Access modifiers changed from: private */
    public static GraphRequest buildPushDeviceTokenRequest(String str, String str2, AccessToken accessToken) {
        GraphRequest newPostRequest = GraphRequest.newPostRequest(accessToken, String.format(Locale.US, "%s/app_push_device_token", str), null, null);
        AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
        if (attributionIdentifiers == null) {
            return null;
        }
        String androidAdvertiserId = attributionIdentifiers.getAndroidAdvertiserId();
        Bundle parameters = newPostRequest.getParameters();
        if (parameters == null) {
            parameters = new Bundle();
        }
        parameters.putString("device_id", androidAdvertiserId);
        parameters.putString("device_token", str2);
        parameters.putString("platform", "android");
        newPostRequest.setParameters(parameters);
        return newPostRequest;
    }

    private static void sendToServer(String str) {
        FacebookSdk.getExecutor().execute(new d(str));
    }

    public static void updateDeviceToken(String str) {
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        if (appSettingsWithoutQuery == null) {
            return;
        }
        boolean trackUninstallEnabled = appSettingsWithoutQuery.getTrackUninstallEnabled();
        String string = uploadedTokenSharedPrefs.getString("uploaded_token", null);
        boolean z = uploadedTokenSharedPrefs.getBoolean("pre_track_uninstall_enabled", false);
        if (trackUninstallEnabled && (!z || !str.equals(string))) {
            sendToServer(str);
        } else {
            if (trackUninstallEnabled || !z) {
                return;
            }
            SharedPreferences.Editor edit = uploadedTokenSharedPrefs.edit();
            edit.putBoolean("pre_track_uninstall_enabled", false);
            edit.apply();
        }
    }
}
