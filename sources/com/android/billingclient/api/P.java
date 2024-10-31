package com.android.billingclient.api;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SkuDetails.java */
/* loaded from: classes.dex */
public class P {

    /* renamed from: a */
    private final String f7892a;

    /* renamed from: b */
    private final JSONObject f7893b;

    /* compiled from: SkuDetails.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        private List<P> f7894a;

        /* renamed from: b */
        private int f7895b;

        /* renamed from: c */
        private String f7896c;

        public a(int i, String str, List<P> list) {
            this.f7895b = i;
            this.f7896c = str;
            this.f7894a = list;
        }

        public String a() {
            return this.f7896c;
        }

        public int b() {
            return this.f7895b;
        }

        public List<P> c() {
            return this.f7894a;
        }
    }

    public P(String str) throws JSONException {
        this.f7892a = str;
        this.f7893b = new JSONObject(this.f7892a);
    }

    public String a() {
        return this.f7893b.optString("description");
    }

    public String b() {
        return this.f7893b.optString("freeTrialPeriod");
    }

    public String c() {
        return this.f7893b.optString("introductoryPrice");
    }

    public long d() {
        return this.f7893b.optLong("introductoryPriceAmountMicros");
    }

    public String e() {
        return this.f7893b.optString("introductoryPriceCycles");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || P.class != obj.getClass()) {
            return false;
        }
        return TextUtils.equals(this.f7892a, ((P) obj).f7892a);
    }

    public String f() {
        return this.f7893b.optString("introductoryPricePeriod");
    }

    public String g() {
        return this.f7892a;
    }

    public String h() {
        return this.f7893b.optString("price");
    }

    public int hashCode() {
        return this.f7892a.hashCode();
    }

    public long i() {
        return this.f7893b.optLong("price_amount_micros");
    }

    public String j() {
        return this.f7893b.optString("price_currency_code");
    }

    public String k() {
        return this.f7893b.optString("productId");
    }

    public String l() {
        return this.f7893b.optString("skuDetailsToken");
    }

    public String m() {
        return this.f7893b.optString("subscriptionPeriod");
    }

    public String n() {
        return this.f7893b.optString("title");
    }

    public String o() {
        return this.f7893b.optString("type");
    }

    public boolean p() {
        return this.f7893b.has("rewardToken");
    }

    public String q() {
        return this.f7893b.optString("rewardToken");
    }

    public String toString() {
        return "SkuDetails: " + this.f7892a;
    }
}
