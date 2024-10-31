package com.android.billingclient.api;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Purchase.java */
/* loaded from: classes.dex */
public class M {

    /* renamed from: a */
    private final String f7887a;

    /* renamed from: b */
    private final String f7888b;

    /* renamed from: c */
    private final JSONObject f7889c;

    /* compiled from: Purchase.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        private List<M> f7890a;

        /* renamed from: b */
        private H f7891b;

        public a(H h2, List<M> list) {
            this.f7890a = list;
            this.f7891b = h2;
        }

        public H a() {
            return this.f7891b;
        }

        public List<M> b() {
            return this.f7890a;
        }

        public int c() {
            return a().a();
        }
    }

    public M(String str, String str2) throws JSONException {
        this.f7887a = str;
        this.f7888b = str2;
        this.f7889c = new JSONObject(this.f7887a);
    }

    public String a() {
        return this.f7887a;
    }

    public int b() {
        return this.f7889c.optInt("purchaseState", 1) != 4 ? 1 : 2;
    }

    public String c() {
        JSONObject jSONObject = this.f7889c;
        return jSONObject.optString("token", jSONObject.optString("purchaseToken"));
    }

    public String d() {
        return this.f7888b;
    }

    public String e() {
        return this.f7889c.optString("productId");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof M)) {
            return false;
        }
        M m = (M) obj;
        return TextUtils.equals(this.f7887a, m.a()) && TextUtils.equals(this.f7888b, m.d());
    }

    public boolean f() {
        return this.f7889c.optBoolean("acknowledged", true);
    }

    public int hashCode() {
        return this.f7887a.hashCode();
    }

    public String toString() {
        return "Purchase. Json: " + this.f7887a;
    }
}
