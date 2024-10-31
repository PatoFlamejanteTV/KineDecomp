package io.fabric.sdk.android.services.settings;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import io.fabric.sdk.android.services.common.CommonUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultSettingsController.java */
/* loaded from: classes3.dex */
public class k implements t {

    /* renamed from: a, reason: collision with root package name */
    private final x f27020a;

    /* renamed from: b, reason: collision with root package name */
    private final w f27021b;

    /* renamed from: c, reason: collision with root package name */
    private final io.fabric.sdk.android.services.common.m f27022c;

    /* renamed from: d, reason: collision with root package name */
    private final h f27023d;

    /* renamed from: e, reason: collision with root package name */
    private final y f27024e;

    /* renamed from: f, reason: collision with root package name */
    private final io.fabric.sdk.android.l f27025f;

    /* renamed from: g, reason: collision with root package name */
    private final io.fabric.sdk.android.a.c.c f27026g;

    public k(io.fabric.sdk.android.l lVar, x xVar, io.fabric.sdk.android.services.common.m mVar, w wVar, h hVar, y yVar) {
        this.f27025f = lVar;
        this.f27020a = xVar;
        this.f27022c = mVar;
        this.f27021b = wVar;
        this.f27023d = hVar;
        this.f27024e = yVar;
        this.f27026g = new io.fabric.sdk.android.a.c.d(this.f27025f);
    }

    private u b(SettingsCacheBehavior settingsCacheBehavior) {
        u uVar = null;
        try {
            if (!SettingsCacheBehavior.SKIP_CACHE_LOOKUP.equals(settingsCacheBehavior)) {
                JSONObject a2 = this.f27023d.a();
                if (a2 != null) {
                    u a3 = this.f27021b.a(this.f27022c, a2);
                    if (a3 != null) {
                        a(a2, "Loaded cached settings: ");
                        long a4 = this.f27022c.a();
                        if (!SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION.equals(settingsCacheBehavior) && a3.a(a4)) {
                            io.fabric.sdk.android.f.f().d("Fabric", "Cached settings have expired.");
                        }
                        try {
                            io.fabric.sdk.android.f.f().d("Fabric", "Returning cached settings.");
                            uVar = a3;
                        } catch (Exception e2) {
                            e = e2;
                            uVar = a3;
                            io.fabric.sdk.android.f.f().c("Fabric", "Failed to get cached settings", e);
                            return uVar;
                        }
                    } else {
                        io.fabric.sdk.android.f.f().c("Fabric", "Failed to transform cached settings data.", null);
                    }
                } else {
                    io.fabric.sdk.android.f.f().d("Fabric", "No cached settings data found.");
                }
            }
        } catch (Exception e3) {
            e = e3;
        }
        return uVar;
    }

    @Override // io.fabric.sdk.android.services.settings.t
    public u a() {
        return a(SettingsCacheBehavior.USE_CACHE);
    }

    String c() {
        return CommonUtils.a(CommonUtils.n(this.f27025f.getContext()));
    }

    String d() {
        return this.f27026g.get().getString("existing_instance_identifier", "");
    }

    @Override // io.fabric.sdk.android.services.settings.t
    public u a(SettingsCacheBehavior settingsCacheBehavior) {
        JSONObject a2;
        u uVar = null;
        try {
            if (!io.fabric.sdk.android.f.h() && !b()) {
                uVar = b(settingsCacheBehavior);
            }
            if (uVar == null && (a2 = this.f27024e.a(this.f27020a)) != null) {
                uVar = this.f27021b.a(this.f27022c, a2);
                this.f27023d.a(uVar.f27061g, a2);
                a(a2, "Loaded settings: ");
                a(c());
            }
            return uVar == null ? b(SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION) : uVar;
        } catch (Exception e2) {
            io.fabric.sdk.android.f.f().c("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", e2);
            return null;
        }
    }

    private void a(JSONObject jSONObject, String str) throws JSONException {
        io.fabric.sdk.android.f.f().d("Fabric", str + jSONObject.toString());
    }

    @SuppressLint({"CommitPrefEdits"})
    boolean a(String str) {
        SharedPreferences.Editor edit = this.f27026g.edit();
        edit.putString("existing_instance_identifier", str);
        return this.f27026g.a(edit);
    }

    boolean b() {
        return !d().equals(c());
    }
}
