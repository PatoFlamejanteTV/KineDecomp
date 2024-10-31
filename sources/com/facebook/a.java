package com.facebook;

import android.content.SharedPreferences;
import com.facebook.internal.Validate;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProfileCache.java */
/* loaded from: classes.dex */
public final class A {

    /* renamed from: a, reason: collision with root package name */
    private final SharedPreferences f9114a = FacebookSdk.getApplicationContext().getSharedPreferences(AccessTokenManager.SHARED_PREFERENCES_NAME, 0);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Profile profile) {
        Validate.notNull(profile, "profile");
        JSONObject jSONObject = profile.toJSONObject();
        if (jSONObject != null) {
            this.f9114a.edit().putString("com.facebook.ProfileManager.CachedProfile", jSONObject.toString()).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Profile b() {
        String string = this.f9114a.getString("com.facebook.ProfileManager.CachedProfile", null);
        if (string != null) {
            try {
                return new Profile(new JSONObject(string));
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f9114a.edit().remove("com.facebook.ProfileManager.CachedProfile").apply();
    }
}
