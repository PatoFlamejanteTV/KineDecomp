package com.airbnb.lottie;

import com.airbnb.lottie.C0664o;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShapePath.java */
/* loaded from: classes.dex */
public class Va {

    /* renamed from: a, reason: collision with root package name */
    private final String f7713a;

    /* renamed from: b, reason: collision with root package name */
    private final int f7714b;

    /* renamed from: c, reason: collision with root package name */
    private final C0664o f7715c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ShapePath.java */
    /* loaded from: classes.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static Va a(JSONObject jSONObject, C0657ka c0657ka) {
            return new Va(jSONObject.optString("nm"), jSONObject.optInt("ind"), C0664o.a.a(jSONObject.optJSONObject("ks"), c0657ka));
        }
    }

    public String a() {
        return this.f7713a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0664o b() {
        return this.f7715c;
    }

    public String toString() {
        return "ShapePath{name=" + this.f7713a + ", index=" + this.f7714b + ", hasAnimation=" + this.f7715c.c() + '}';
    }

    private Va(String str, int i, C0664o c0664o) {
        this.f7713a = str;
        this.f7714b = i;
        this.f7715c = c0664o;
    }
}
