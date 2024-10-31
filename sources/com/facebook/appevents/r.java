package com.facebook.appevents;

import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.BundleJSONConverter;
import com.facebook.internal.Logger;
import com.facebook.share.internal.ShareConstants;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppEventsLogger.java */
/* loaded from: classes.dex */
public class r implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bundle f9222a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f9223b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ GraphRequest.Callback f9224c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(Bundle bundle, String str, GraphRequest.Callback callback) {
        this.f9222a = bundle;
        this.f9223b = str;
        this.f9224c = callback;
    }

    @Override // java.lang.Runnable
    public void run() {
        String userID = AppEventsLogger.getUserID();
        if (userID != null && !userID.isEmpty()) {
            Bundle bundle = new Bundle();
            bundle.putString("user_unique_id", userID);
            bundle.putBundle("custom_data", this.f9222a);
            AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
            if (attributionIdentifiers != null && attributionIdentifiers.getAndroidAdvertiserId() != null) {
                bundle.putString("advertiser_id", attributionIdentifiers.getAndroidAdvertiserId());
            }
            Bundle bundle2 = new Bundle();
            try {
                JSONObject convertToJSON = BundleJSONConverter.convertToJSON(bundle);
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(convertToJSON);
                bundle2.putString(ShareConstants.WEB_DIALOG_PARAM_DATA, jSONArray.toString());
                GraphRequest graphRequest = new GraphRequest(AccessToken.getCurrentAccessToken(), String.format(Locale.US, "%s/user_properties", this.f9223b), bundle2, HttpMethod.POST, this.f9224c);
                graphRequest.setSkipClientToken(true);
                graphRequest.executeAsync();
                return;
            } catch (JSONException e2) {
                throw new FacebookException("Failed to construct request", e2);
            }
        }
        Logger.log(LoggingBehavior.APP_EVENTS, AppEventsLogger.TAG, "AppEventsLogger userID cannot be null or empty");
    }
}
