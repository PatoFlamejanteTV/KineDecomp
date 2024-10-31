package com.airbnb.lottie;

import android.graphics.Path;
import com.airbnb.lottie.C0646f;
import com.airbnb.lottie.C0650h;
import com.airbnb.lottie.C0656k;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GradientFill.java */
/* loaded from: classes.dex */
public class W {

    /* renamed from: a, reason: collision with root package name */
    private final GradientType f7716a;

    /* renamed from: b, reason: collision with root package name */
    private final Path.FillType f7717b;

    /* renamed from: c, reason: collision with root package name */
    private final C0646f f7718c;

    /* renamed from: d, reason: collision with root package name */
    private final C0650h f7719d;

    /* renamed from: e, reason: collision with root package name */
    private final C0656k f7720e;

    /* renamed from: f, reason: collision with root package name */
    private final C0656k f7721f;

    /* renamed from: g, reason: collision with root package name */
    private final String f7722g;

    /* renamed from: h, reason: collision with root package name */
    private final C0642d f7723h;
    private final C0642d i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GradientFill.java */
    /* loaded from: classes.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static W a(JSONObject jSONObject, C0657ka c0657ka) {
            String optString = jSONObject.optString("nm");
            JSONObject optJSONObject = jSONObject.optJSONObject("g");
            if (optJSONObject != null && optJSONObject.has("k")) {
                int optInt = optJSONObject.optInt("p");
                optJSONObject = optJSONObject.optJSONObject("k");
                try {
                    optJSONObject.put("p", optInt);
                } catch (JSONException unused) {
                }
            }
            C0646f a2 = optJSONObject != null ? C0646f.a.a(optJSONObject, c0657ka) : null;
            JSONObject optJSONObject2 = jSONObject.optJSONObject("o");
            C0650h a3 = optJSONObject2 != null ? C0650h.a.a(optJSONObject2, c0657ka) : null;
            Path.FillType fillType = jSONObject.optInt("r", 1) == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
            GradientType gradientType = jSONObject.optInt(com.umeng.commonsdk.proguard.e.ar, 1) == 1 ? GradientType.Linear : GradientType.Radial;
            JSONObject optJSONObject3 = jSONObject.optJSONObject(com.umeng.commonsdk.proguard.e.ap);
            C0656k a4 = optJSONObject3 != null ? C0656k.a.a(optJSONObject3, c0657ka) : null;
            JSONObject optJSONObject4 = jSONObject.optJSONObject("e");
            return new W(optString, gradientType, fillType, a2, a3, a4, optJSONObject4 != null ? C0656k.a.a(optJSONObject4, c0657ka) : null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0656k a() {
        return this.f7721f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Path.FillType b() {
        return this.f7717b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0646f c() {
        return this.f7718c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GradientType d() {
        return this.f7716a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String e() {
        return this.f7722g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0650h f() {
        return this.f7719d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0656k g() {
        return this.f7720e;
    }

    private W(String str, GradientType gradientType, Path.FillType fillType, C0646f c0646f, C0650h c0650h, C0656k c0656k, C0656k c0656k2, C0642d c0642d, C0642d c0642d2) {
        this.f7716a = gradientType;
        this.f7717b = fillType;
        this.f7718c = c0646f;
        this.f7719d = c0650h;
        this.f7720e = c0656k;
        this.f7721f = c0656k2;
        this.f7722g = str;
        this.f7723h = c0642d;
        this.i = c0642d2;
    }
}
