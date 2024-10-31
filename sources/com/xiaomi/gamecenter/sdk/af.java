package com.xiaomi.gamecenter.sdk;

import org.json.JSONObject;

/* loaded from: classes.dex */
public final class af {

    /* renamed from: a, reason: collision with root package name */
    private long f4882a;
    private String b;
    private String c;
    private String d;
    private int e;
    private String f;

    public af(JSONObject jSONObject) {
        this.f4882a = 0L;
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = 0;
        this.f = "";
        this.f4882a = jSONObject.getLong("expireTime");
        this.b = jSONObject.getString("miid");
        this.c = jSONObject.getString("imei");
        this.d = jSONObject.getString("mac");
        this.e = jSONObject.getInt("versionCode");
        this.f = jSONObject.getString("productCode");
    }

    public long a() {
        return this.f4882a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }
}
