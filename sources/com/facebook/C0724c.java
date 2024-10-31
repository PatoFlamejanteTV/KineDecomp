package com.facebook;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.internal.Validate;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AccessTokenCache.java */
/* renamed from: com.facebook.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0724c {

    /* renamed from: a, reason: collision with root package name */
    private final SharedPreferences f9244a;

    /* renamed from: b, reason: collision with root package name */
    private final a f9245b;

    /* renamed from: c, reason: collision with root package name */
    private x f9246c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AccessTokenCache.java */
    /* renamed from: com.facebook.c$a */
    /* loaded from: classes.dex */
    public static class a {
        a() {
        }

        public x a() {
            return new x(FacebookSdk.getApplicationContext());
        }
    }

    C0724c(SharedPreferences sharedPreferences, a aVar) {
        this.f9244a = sharedPreferences;
        this.f9245b = aVar;
    }

    private AccessToken c() {
        String string = this.f9244a.getString("com.facebook.AccessTokenManager.CachedAccessToken", null);
        if (string != null) {
            try {
                return AccessToken.createFromJSONObject(new JSONObject(string));
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    private AccessToken d() {
        Bundle b2 = e().b();
        if (b2 == null || !x.d(b2)) {
            return null;
        }
        return AccessToken.createFromLegacyCache(b2);
    }

    private x e() {
        if (this.f9246c == null) {
            synchronized (this) {
                if (this.f9246c == null) {
                    this.f9246c = this.f9245b.a();
                }
            }
        }
        return this.f9246c;
    }

    private boolean f() {
        return this.f9244a.contains("com.facebook.AccessTokenManager.CachedAccessToken");
    }

    private boolean g() {
        return FacebookSdk.isLegacyTokenUpgradeSupported();
    }

    public void a(AccessToken accessToken) {
        Validate.notNull(accessToken, "accessToken");
        try {
            this.f9244a.edit().putString("com.facebook.AccessTokenManager.CachedAccessToken", accessToken.toJSONObject().toString()).apply();
        } catch (JSONException unused) {
        }
    }

    public AccessToken b() {
        if (f()) {
            return c();
        }
        if (!g()) {
            return null;
        }
        AccessToken d2 = d();
        if (d2 == null) {
            return d2;
        }
        a(d2);
        e().a();
        return d2;
    }

    public C0724c() {
        this(FacebookSdk.getApplicationContext().getSharedPreferences(AccessTokenManager.SHARED_PREFERENCES_NAME, 0), new a());
    }

    public void a() {
        this.f9244a.edit().remove("com.facebook.AccessTokenManager.CachedAccessToken").apply();
        if (g()) {
            e().a();
        }
    }
}
