package com.airbnb.lottie;

import org.json.JSONObject;

/* compiled from: LottieImageAsset.java */
/* renamed from: com.airbnb.lottie.oa */
/* loaded from: classes.dex */
public class C0665oa {

    /* renamed from: a */
    private final int f7802a;

    /* renamed from: b */
    private final int f7803b;

    /* renamed from: c */
    private final String f7804c;

    /* renamed from: d */
    private final String f7805d;

    /* compiled from: LottieImageAsset.java */
    /* renamed from: com.airbnb.lottie.oa$a */
    /* loaded from: classes.dex */
    static class a {
        public static C0665oa a(JSONObject jSONObject) {
            return new C0665oa(jSONObject.optInt("w"), jSONObject.optInt("h"), jSONObject.optString("id"), jSONObject.optString("p"));
        }
    }

    /* synthetic */ C0665oa(int i, int i2, String str, String str2, C0663na c0663na) {
        this(i, i2, str, str2);
    }

    public String a() {
        return this.f7805d;
    }

    public String b() {
        return this.f7804c;
    }

    private C0665oa(int i, int i2, String str, String str2) {
        this.f7802a = i;
        this.f7803b = i2;
        this.f7804c = str;
        this.f7805d = str2;
    }
}
