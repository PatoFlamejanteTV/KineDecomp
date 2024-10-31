package com.nextreaming.nexeditorui;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.facebook.appevents.AppEventsConstants;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nexstreaming.kinemaster.usage.a;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: KineMasterApplication.java */
/* loaded from: classes.dex */
class ax implements a.InterfaceC0079a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ KineMasterApplication f4533a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(KineMasterApplication kineMasterApplication) {
        this.f4533a = kineMasterApplication;
    }

    @Override // com.nexstreaming.kinemaster.usage.a.InterfaceC0079a
    public void a(Activity activity, long j, boolean z) {
        boolean z2;
        boolean z3;
        z2 = KineMasterApplication.e;
        if (z2) {
            z3 = false;
        } else {
            boolean unused = KineMasterApplication.e = true;
            z3 = true;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity);
        boolean z4 = defaultSharedPreferences.getBoolean("km.firstLaunch", true);
        if (z4) {
            defaultSharedPreferences.edit().putBoolean("km.firstLaunch", false).apply();
        }
        if (z4 || z3) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (z4) {
                    jSONObject.put("Type", "First");
                } else if (z3) {
                    jSONObject.put("Type", "Normal");
                }
                jSONObject.put("Background Time", j);
                jSONObject.put("Activity", activity.getClass().getSimpleName());
                if (!PreferenceManager.getDefaultSharedPreferences(this.f4533a).getBoolean("put_user_type", false)) {
                    KMUsage.getMixpanelInstanceFromContext(this.f4533a).a(new JSONObject().put("User Type", AppEventsConstants.EVENT_PARAM_VALUE_NO));
                    KMUsage.getMixpanelPeople(this.f4533a).a("User Type", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            KMUsage.getMixpanelInstance(activity).a("App Open", jSONObject);
        }
    }
}
