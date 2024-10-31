package com.facebook.internal;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Utility.java */
/* loaded from: classes.dex */
public final class ac implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f282a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(Context context, String str, String str2) {
        this.f282a = context;
        this.b = str;
        this.c = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONObject jSONObject;
        JSONObject appSettingsQueryResponse;
        AtomicBoolean atomicBoolean;
        SharedPreferences sharedPreferences = this.f282a.getSharedPreferences("com.facebook.internal.preferences.APP_SETTINGS", 0);
        String string = sharedPreferences.getString(this.b, null);
        if (!Utility.isNullOrEmpty(string)) {
            try {
                jSONObject = new JSONObject(string);
            } catch (JSONException e) {
                Utility.logd("FacebookSDK", e);
                jSONObject = null;
            }
            if (jSONObject != null) {
                Utility.parseAppSettingsFromJSON(this.c, jSONObject);
            }
        }
        appSettingsQueryResponse = Utility.getAppSettingsQueryResponse(this.c);
        if (appSettingsQueryResponse != null) {
            Utility.parseAppSettingsFromJSON(this.c, appSettingsQueryResponse);
            sharedPreferences.edit().putString(this.b, appSettingsQueryResponse.toString()).apply();
        }
        atomicBoolean = Utility.loadingSettings;
        atomicBoolean.set(false);
    }
}
