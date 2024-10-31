package com.facebook.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.appevents.internal.InAppPurchaseActivityLifecycleTracker;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FetchedAppSettingsManager.java */
/* loaded from: classes.dex */
public class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f9324a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f9325b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f9326c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(Context context, String str, String str2) {
        this.f9324a = context;
        this.f9325b = str;
        this.f9326c = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONObject jSONObject;
        JSONObject appSettingsQueryResponse;
        AtomicBoolean atomicBoolean;
        boolean z;
        String str;
        SharedPreferences sharedPreferences = this.f9324a.getSharedPreferences("com.facebook.internal.preferences.APP_SETTINGS", 0);
        FetchedAppSettings fetchedAppSettings = null;
        String string = sharedPreferences.getString(this.f9325b, null);
        if (!Utility.isNullOrEmpty(string)) {
            try {
                jSONObject = new JSONObject(string);
            } catch (JSONException e2) {
                Utility.logd("FacebookSDK", e2);
                jSONObject = null;
            }
            if (jSONObject != null) {
                fetchedAppSettings = FetchedAppSettingsManager.parseAppSettingsFromJSON(this.f9326c, jSONObject);
            }
        }
        appSettingsQueryResponse = FetchedAppSettingsManager.getAppSettingsQueryResponse(this.f9326c);
        if (appSettingsQueryResponse != null) {
            FetchedAppSettingsManager.parseAppSettingsFromJSON(this.f9326c, appSettingsQueryResponse);
            sharedPreferences.edit().putString(this.f9325b, appSettingsQueryResponse.toString()).apply();
        }
        if (fetchedAppSettings != null) {
            String sdkUpdateMessage = fetchedAppSettings.getSdkUpdateMessage();
            z = FetchedAppSettingsManager.printedSDKUpdatedMessage;
            if (!z && sdkUpdateMessage != null && sdkUpdateMessage.length() > 0) {
                boolean unused = FetchedAppSettingsManager.printedSDKUpdatedMessage = true;
                str = FetchedAppSettingsManager.TAG;
                Log.w(str, sdkUpdateMessage);
            }
        }
        AutomaticAnalyticsLogger.logActivateAppEvent();
        InAppPurchaseActivityLifecycleTracker.update();
        atomicBoolean = FetchedAppSettingsManager.loadingSettings;
        atomicBoolean.set(false);
    }
}
