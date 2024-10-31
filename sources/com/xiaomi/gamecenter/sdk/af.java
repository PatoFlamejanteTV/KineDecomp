package com.xiaomi.gamecenter.sdk;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class af {

    /* renamed from: a */
    private long f26563a;

    /* renamed from: b */
    private String f26564b;

    /* renamed from: c */
    private String f26565c;

    /* renamed from: d */
    private String f26566d;

    /* renamed from: e */
    private int f26567e;

    /* renamed from: f */
    private String f26568f;

    public af(JSONObject jSONObject) {
        this.f26563a = 0L;
        this.f26564b = "";
        this.f26565c = "";
        this.f26566d = "";
        this.f26567e = 0;
        this.f26568f = "";
        this.f26563a = jSONObject.getLong("expireTime");
        this.f26564b = jSONObject.getString("miid");
        this.f26565c = jSONObject.getString("imei");
        this.f26566d = jSONObject.getString("mac");
        this.f26567e = jSONObject.getInt("versionCode");
        this.f26568f = jSONObject.getString("productCode");
    }

    public long a() {
        return this.f26563a;
    }

    public String b() {
        return this.f26564b;
    }

    public String c() {
        return this.f26565c;
    }

    public String d() {
        return this.f26566d;
    }
}
