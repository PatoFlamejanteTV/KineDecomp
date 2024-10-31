package com.airbnb.lottie;

import com.airbnb.lottie.C0642d;
import com.airbnb.lottie.C0646f;
import com.airbnb.lottie.C0650h;
import com.airbnb.lottie.C0656k;
import com.airbnb.lottie.ShapeStroke;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GradientStroke.java */
/* loaded from: classes.dex */
public class Z {

    /* renamed from: a, reason: collision with root package name */
    private final String f7734a;

    /* renamed from: b, reason: collision with root package name */
    private final GradientType f7735b;

    /* renamed from: c, reason: collision with root package name */
    private final C0646f f7736c;

    /* renamed from: d, reason: collision with root package name */
    private final C0650h f7737d;

    /* renamed from: e, reason: collision with root package name */
    private final C0656k f7738e;

    /* renamed from: f, reason: collision with root package name */
    private final C0656k f7739f;

    /* renamed from: g, reason: collision with root package name */
    private final C0642d f7740g;

    /* renamed from: h, reason: collision with root package name */
    private final ShapeStroke.LineCapType f7741h;
    private final ShapeStroke.LineJoinType i;
    private final List<C0642d> j;
    private final C0642d k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GradientStroke.java */
    /* loaded from: classes.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static Z a(JSONObject jSONObject, C0657ka c0657ka) {
            ShapeStroke.LineJoinType lineJoinType;
            C0642d c0642d;
            String optString = jSONObject.optString("nm");
            JSONObject optJSONObject = jSONObject.optJSONObject("g");
            if (optJSONObject != null && optJSONObject.has("k")) {
                optJSONObject = optJSONObject.optJSONObject("k");
            }
            C0646f a2 = optJSONObject != null ? C0646f.a.a(optJSONObject, c0657ka) : null;
            String str = "o";
            JSONObject optJSONObject2 = jSONObject.optJSONObject("o");
            C0650h a3 = optJSONObject2 != null ? C0650h.a.a(optJSONObject2, c0657ka) : null;
            GradientType gradientType = jSONObject.optInt(com.umeng.commonsdk.proguard.e.ar, 1) == 1 ? GradientType.Linear : GradientType.Radial;
            JSONObject optJSONObject3 = jSONObject.optJSONObject(com.umeng.commonsdk.proguard.e.ap);
            C0656k a4 = optJSONObject3 != null ? C0656k.a.a(optJSONObject3, c0657ka) : null;
            JSONObject optJSONObject4 = jSONObject.optJSONObject("e");
            C0656k a5 = optJSONObject4 != null ? C0656k.a.a(optJSONObject4, c0657ka) : null;
            C0642d a6 = C0642d.a.a(jSONObject.optJSONObject("w"), c0657ka);
            ShapeStroke.LineCapType lineCapType = ShapeStroke.LineCapType.values()[jSONObject.optInt("lc") - 1];
            ShapeStroke.LineJoinType lineJoinType2 = ShapeStroke.LineJoinType.values()[jSONObject.optInt("lj") - 1];
            ArrayList arrayList = new ArrayList();
            if (jSONObject.has(com.umeng.commonsdk.proguard.e.am)) {
                JSONArray optJSONArray = jSONObject.optJSONArray(com.umeng.commonsdk.proguard.e.am);
                lineJoinType = lineJoinType2;
                int i = 0;
                C0642d c0642d2 = null;
                while (i < optJSONArray.length()) {
                    JSONObject optJSONObject5 = optJSONArray.optJSONObject(i);
                    JSONArray jSONArray = optJSONArray;
                    String optString2 = optJSONObject5.optString("n");
                    String str2 = str;
                    if (optString2.equals(str)) {
                        c0642d2 = C0642d.a.a(optJSONObject5.optJSONObject("v"), c0657ka);
                    } else if (optString2.equals(com.umeng.commonsdk.proguard.e.am) || optString2.equals("g")) {
                        arrayList.add(C0642d.a.a(optJSONObject5.optJSONObject("v"), c0657ka));
                    }
                    i++;
                    optJSONArray = jSONArray;
                    str = str2;
                }
                if (arrayList.size() == 1) {
                    arrayList.add(arrayList.get(0));
                }
                c0642d = c0642d2;
            } else {
                lineJoinType = lineJoinType2;
                c0642d = null;
            }
            return new Z(optString, gradientType, a2, a3, a4, a5, a6, lineCapType, lineJoinType, arrayList, c0642d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeStroke.LineCapType a() {
        return this.f7741h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0642d b() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0656k c() {
        return this.f7739f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0646f d() {
        return this.f7736c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GradientType e() {
        return this.f7735b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeStroke.LineJoinType f() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<C0642d> g() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String h() {
        return this.f7734a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0650h i() {
        return this.f7737d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0656k j() {
        return this.f7738e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0642d k() {
        return this.f7740g;
    }

    private Z(String str, GradientType gradientType, C0646f c0646f, C0650h c0650h, C0656k c0656k, C0656k c0656k2, C0642d c0642d, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, List<C0642d> list, C0642d c0642d2) {
        this.f7734a = str;
        this.f7735b = gradientType;
        this.f7736c = c0646f;
        this.f7737d = c0650h;
        this.f7738e = c0656k;
        this.f7739f = c0656k2;
        this.f7740g = c0642d;
        this.f7741h = lineCapType;
        this.i = lineJoinType;
        this.j = list;
        this.k = c0642d2;
    }
}
