package com.facebook;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.internal.Validate;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AccessTokenCache.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a */
    private final SharedPreferences f260a;
    private final a b;
    private y c;

    c(SharedPreferences sharedPreferences, a aVar) {
        this.f260a = sharedPreferences;
        this.b = aVar;
    }

    public c() {
        this(FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0), new a());
    }

    public AccessToken a() {
        if (c()) {
            return d();
        }
        if (!e()) {
            return null;
        }
        AccessToken f = f();
        if (f != null) {
            a(f);
            g().b();
            return f;
        }
        return f;
    }

    public void a(AccessToken accessToken) {
        Validate.notNull(accessToken, "accessToken");
        try {
            this.f260a.edit().putString("com.facebook.AccessTokenManager.CachedAccessToken", accessToken.toJSONObject().toString()).apply();
        } catch (JSONException e) {
        }
    }

    public void b() {
        this.f260a.edit().remove("com.facebook.AccessTokenManager.CachedAccessToken").apply();
        if (e()) {
            g().b();
        }
    }

    private boolean c() {
        return this.f260a.contains("com.facebook.AccessTokenManager.CachedAccessToken");
    }

    private AccessToken d() {
        String string = this.f260a.getString("com.facebook.AccessTokenManager.CachedAccessToken", null);
        if (string == null) {
            return null;
        }
        try {
            return AccessToken.createFromJSONObject(new JSONObject(string));
        } catch (JSONException e) {
            return null;
        }
    }

    private boolean e() {
        return FacebookSdk.isLegacyTokenUpgradeSupported();
    }

    private AccessToken f() {
        Bundle a2 = g().a();
        if (a2 == null || !y.a(a2)) {
            return null;
        }
        return AccessToken.createFromLegacyCache(a2);
    }

    private y g() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.c = this.b.a();
                }
            }
        }
        return this.c;
    }

    /* compiled from: AccessTokenCache.java */
    /* loaded from: classes.dex */
    public static class a {
        a() {
        }

        public y a() {
            return new y(FacebookSdk.getApplicationContext());
        }
    }
}
