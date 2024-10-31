package com.nextreaming.nexeditorui;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.facebook.appevents.AppEventsConstants;
import com.nexstreaming.kinemaster.usage.c;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: KineMasterApplication.kt */
/* loaded from: classes.dex */
final class F implements c.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ KineMasterApplication f24034a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public F(KineMasterApplication kineMasterApplication) {
        this.f24034a = kineMasterApplication;
    }

    @Override // com.nexstreaming.kinemaster.usage.c.a
    public final void a(Activity activity, long j, boolean z) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f24034a);
        boolean z2 = defaultSharedPreferences.getBoolean("km.firstLaunch", true);
        if (z2) {
            defaultSharedPreferences.edit().putBoolean("km.firstLaunch", false).apply();
        }
        if (z2) {
            JSONObject jSONObject = new JSONObject();
            if (z2) {
                try {
                    jSONObject.put("Type", "First");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            jSONObject.put("Background Time", j);
            jSONObject.put("Activity", this.f24034a.getClass().getSimpleName());
            if (!PreferenceManager.getDefaultSharedPreferences(this.f24034a).getBoolean("put_user_type", false)) {
                com.nexstreaming.kinemaster.usage.analytics.d.f23910b.a(this.f24034a, "User Type", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            this.f24034a.y();
        }
        this.f24034a.z();
    }
}
