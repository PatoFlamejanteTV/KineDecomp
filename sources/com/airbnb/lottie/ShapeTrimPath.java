package com.airbnb.lottie;

import com.airbnb.lottie.C0642d;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ShapeTrimPath {

    /* renamed from: a, reason: collision with root package name */
    private final String f7705a;

    /* renamed from: b, reason: collision with root package name */
    private final Type f7706b;

    /* renamed from: c, reason: collision with root package name */
    private final C0642d f7707c;

    /* renamed from: d, reason: collision with root package name */
    private final C0642d f7708d;

    /* renamed from: e, reason: collision with root package name */
    private final C0642d f7709e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum Type {
        Simultaneously,
        Individually;

        static Type forId(int i) {
            if (i == 1) {
                return Simultaneously;
            }
            if (i == 2) {
                return Individually;
            }
            throw new IllegalArgumentException("Unknown trim path type " + i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static ShapeTrimPath a(JSONObject jSONObject, C0657ka c0657ka) {
            return new ShapeTrimPath(jSONObject.optString("nm"), Type.forId(jSONObject.optInt("m", 1)), C0642d.a.a(jSONObject.optJSONObject(com.umeng.commonsdk.proguard.e.ap), c0657ka, false), C0642d.a.a(jSONObject.optJSONObject("e"), c0657ka, false), C0642d.a.a(jSONObject.optJSONObject("o"), c0657ka, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0642d a() {
        return this.f7708d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        return this.f7705a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0642d c() {
        return this.f7709e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0642d d() {
        return this.f7707c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Type e() {
        return this.f7706b;
    }

    public String toString() {
        return "Trim Path: {start: " + this.f7707c + ", end: " + this.f7708d + ", offset: " + this.f7709e + "}";
    }

    private ShapeTrimPath(String str, Type type, C0642d c0642d, C0642d c0642d2, C0642d c0642d3) {
        this.f7705a = str;
        this.f7706b = type;
        this.f7707c = c0642d;
        this.f7708d = c0642d2;
        this.f7709e = c0642d3;
    }
}
