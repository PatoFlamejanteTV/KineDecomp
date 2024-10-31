package com.airbnb.lottie;

import android.graphics.PointF;
import com.airbnb.lottie.C0642d;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class PolystarShape {

    /* renamed from: a */
    private final String f7680a;

    /* renamed from: b */
    private final Type f7681b;

    /* renamed from: c */
    private final C0642d f7682c;

    /* renamed from: d */
    private final InterfaceC0671s<PointF> f7683d;

    /* renamed from: e */
    private final C0642d f7684e;

    /* renamed from: f */
    private final C0642d f7685f;

    /* renamed from: g */
    private final C0642d f7686g;

    /* renamed from: h */
    private final C0642d f7687h;
    private final C0642d i;

    /* loaded from: classes.dex */
    public enum Type {
        Star(1),
        Polygon(2);

        private final int value;

        Type(int i) {
            this.value = i;
        }

        static Type forValue(int i) {
            for (Type type : values()) {
                if (type.value == i) {
                    return type;
                }
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    static class a {
        public static PolystarShape a(JSONObject jSONObject, C0657ka c0657ka) {
            C0642d c0642d;
            String optString = jSONObject.optString("nm");
            Type forValue = Type.forValue(jSONObject.optInt("sy"));
            C0642d a2 = C0642d.a.a(jSONObject.optJSONObject("pt"), c0657ka, false);
            InterfaceC0671s<PointF> a3 = C0652i.a(jSONObject.optJSONObject("p"), c0657ka);
            C0642d a4 = C0642d.a.a(jSONObject.optJSONObject("r"), c0657ka, false);
            C0642d a5 = C0642d.a.a(jSONObject.optJSONObject("or"), c0657ka);
            C0642d a6 = C0642d.a.a(jSONObject.optJSONObject(com.umeng.commonsdk.proguard.e.w), c0657ka, false);
            C0642d c0642d2 = null;
            if (forValue == Type.Star) {
                C0642d a7 = C0642d.a.a(jSONObject.optJSONObject("ir"), c0657ka);
                c0642d = C0642d.a.a(jSONObject.optJSONObject(com.umeng.commonsdk.proguard.e.ac), c0657ka, false);
                c0642d2 = a7;
            } else {
                c0642d = null;
            }
            return new PolystarShape(optString, forValue, a2, a3, a4, c0642d2, a5, c0642d, a6);
        }
    }

    /* synthetic */ PolystarShape(String str, Type type, C0642d c0642d, InterfaceC0671s interfaceC0671s, C0642d c0642d2, C0642d c0642d3, C0642d c0642d4, C0642d c0642d5, C0642d c0642d6, Ga ga) {
        this(str, type, c0642d, interfaceC0671s, c0642d2, c0642d3, c0642d4, c0642d5, c0642d6);
    }

    public C0642d a() {
        return this.f7685f;
    }

    public C0642d b() {
        return this.f7687h;
    }

    public String c() {
        return this.f7680a;
    }

    public C0642d d() {
        return this.f7686g;
    }

    public C0642d e() {
        return this.i;
    }

    public C0642d f() {
        return this.f7682c;
    }

    public InterfaceC0671s<PointF> g() {
        return this.f7683d;
    }

    public C0642d h() {
        return this.f7684e;
    }

    public Type i() {
        return this.f7681b;
    }

    private PolystarShape(String str, Type type, C0642d c0642d, InterfaceC0671s<PointF> interfaceC0671s, C0642d c0642d2, C0642d c0642d3, C0642d c0642d4, C0642d c0642d5, C0642d c0642d6) {
        this.f7680a = str;
        this.f7681b = type;
        this.f7682c = c0642d;
        this.f7683d = interfaceC0671s;
        this.f7684e = c0642d2;
        this.f7685f = c0642d3;
        this.f7686g = c0642d4;
        this.f7687h = c0642d5;
        this.i = c0642d6;
    }
}
