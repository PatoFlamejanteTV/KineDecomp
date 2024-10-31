package com.facebook.marketing;

import android.os.Build;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Utility;
import com.facebook.marketing.internal.Constants;
import com.facebook.marketing.internal.MarketingLogger;
import com.facebook.marketing.internal.MarketingUtils;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CodelessActivityLifecycleTracker.java */
/* loaded from: classes.dex */
public class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f9431a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ MarketingLogger f9432b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str, MarketingLogger marketingLogger) {
        this.f9431a = str;
        this.f9432b = marketingLogger;
    }

    @Override // java.lang.Runnable
    public void run() {
        Boolean bool;
        ViewIndexer viewIndexer;
        GraphRequest newPostRequest = GraphRequest.newPostRequest(null, String.format(Locale.US, "%s/app_indexing_session", this.f9431a), null, null);
        Bundle parameters = newPostRequest.getParameters();
        if (parameters == null) {
            parameters = new Bundle();
        }
        AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
        JSONArray jSONArray = new JSONArray();
        String str = Build.MODEL;
        if (str == null) {
            str = "";
        }
        jSONArray.put(str);
        if (attributionIdentifiers != null && attributionIdentifiers.getAndroidAdvertiserId() != null) {
            jSONArray.put(attributionIdentifiers.getAndroidAdvertiserId());
        } else {
            jSONArray.put("");
        }
        String str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        jSONArray.put(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        if (MarketingUtils.isEmulator()) {
            str2 = "1";
        }
        jSONArray.put(str2);
        Locale currentLocale = Utility.getCurrentLocale();
        jSONArray.put(currentLocale.getLanguage() + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + currentLocale.getCountry());
        String jSONArray2 = jSONArray.toString();
        parameters.putString(Constants.DEVICE_SESSION_ID, CodelessActivityLifecycleTracker.getCurrentDeviceSessionID());
        parameters.putString(Constants.EXTINFO, jSONArray2);
        newPostRequest.setParameters(parameters);
        if (newPostRequest != null) {
            JSONObject jSONObject = newPostRequest.executeAndWait().getJSONObject();
            Boolean unused = CodelessActivityLifecycleTracker.isAppIndexingEnabled = Boolean.valueOf(jSONObject != null && jSONObject.optBoolean(Constants.APP_INDEXING_ENABLED, false));
            bool = CodelessActivityLifecycleTracker.isAppIndexingEnabled;
            if (!bool.booleanValue()) {
                String unused2 = CodelessActivityLifecycleTracker.deviceSessionID = null;
            } else {
                this.f9432b.logSessionReady();
                viewIndexer = CodelessActivityLifecycleTracker.viewIndexer;
                viewIndexer.schedule();
            }
        }
        Boolean unused3 = CodelessActivityLifecycleTracker.isCheckingSession = false;
    }
}
