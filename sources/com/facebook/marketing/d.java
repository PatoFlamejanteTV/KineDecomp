package com.facebook.marketing;

import android.content.SharedPreferences;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.ServerProtocol;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FacebookUninstallTracker.java */
/* loaded from: classes.dex */
public class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f9433a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.f9433a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        GraphRequest buildPushDeviceTokenRequest;
        String str;
        String str2;
        SharedPreferences sharedPreferences;
        buildPushDeviceTokenRequest = FacebookUninstallTracker.buildPushDeviceTokenRequest(FacebookSdk.getApplicationId(), this.f9433a, null);
        if (buildPushDeviceTokenRequest != null) {
            GraphResponse executeAndWait = buildPushDeviceTokenRequest.executeAndWait();
            try {
                JSONObject jSONObject = executeAndWait.getJSONObject();
                if (jSONObject != null) {
                    if (!jSONObject.has(GraphResponse.SUCCESS_KEY) || !jSONObject.getString(GraphResponse.SUCCESS_KEY).equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                        str2 = FacebookUninstallTracker.TAG;
                        Log.e(str2, "Error sending device token to Facebook: " + executeAndWait.getError());
                    } else {
                        sharedPreferences = FacebookUninstallTracker.uploadedTokenSharedPrefs;
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString("uploaded_token", this.f9433a);
                        edit.putBoolean("pre_track_uninstall_enabled", true);
                        edit.apply();
                    }
                }
            } catch (JSONException e2) {
                str = FacebookUninstallTracker.TAG;
                Log.e(str, "Error decoding server response.", e2);
            }
        }
    }
}
