package com.facebook;

import android.content.SharedPreferences;
import com.facebook.internal.Validate;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProfileCache.java */
/* loaded from: classes.dex */
public final class ab {

    /* renamed from: a, reason: collision with root package name */
    private final SharedPreferences f239a = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Profile a() {
        String string = this.f239a.getString("com.facebook.ProfileManager.CachedProfile", null);
        if (string != null) {
            try {
                return new Profile(new JSONObject(string));
            } catch (JSONException e) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Profile profile) {
        Validate.notNull(profile, "profile");
        JSONObject jSONObject = profile.toJSONObject();
        if (jSONObject != null) {
            this.f239a.edit().putString("com.facebook.ProfileManager.CachedProfile", jSONObject.toString()).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f239a.edit().remove("com.facebook.ProfileManager.CachedProfile").apply();
    }
}
