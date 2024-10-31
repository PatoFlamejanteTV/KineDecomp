package com.airbnb.lottie;

import android.graphics.PointF;
import com.airbnb.lottie.C0642d;
import com.airbnb.lottie.C0656k;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RectangleShape.java */
/* loaded from: classes.dex */
public class Ja {

    /* renamed from: a, reason: collision with root package name */
    private final String f7624a;

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC0671s<PointF> f7625b;

    /* renamed from: c, reason: collision with root package name */
    private final C0656k f7626c;

    /* renamed from: d, reason: collision with root package name */
    private final C0642d f7627d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RectangleShape.java */
    /* loaded from: classes.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static Ja a(JSONObject jSONObject, C0657ka c0657ka) {
            return new Ja(jSONObject.optString("nm"), C0652i.a(jSONObject.optJSONObject("p"), c0657ka), C0656k.a.a(jSONObject.optJSONObject(com.umeng.commonsdk.proguard.e.ap), c0657ka), C0642d.a.a(jSONObject.optJSONObject("r"), c0657ka));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0642d a() {
        return this.f7627d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        return this.f7624a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InterfaceC0671s<PointF> c() {
        return this.f7625b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0656k d() {
        return this.f7626c;
    }

    public String toString() {
        return "RectangleShape{cornerRadius=" + this.f7627d.b() + ", position=" + this.f7625b + ", size=" + this.f7626c + '}';
    }

    private Ja(String str, InterfaceC0671s<PointF> interfaceC0671s, C0656k c0656k, C0642d c0642d) {
        this.f7624a = str;
        this.f7625b = interfaceC0671s;
        this.f7626c = c0656k;
        this.f7627d = c0642d;
    }
}
