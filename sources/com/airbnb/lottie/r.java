package com.airbnb.lottie;

import android.graphics.PointF;
import android.util.Log;
import com.airbnb.lottie.C0642d;
import com.airbnb.lottie.C0650h;
import com.airbnb.lottie.C0660m;
import java.util.Collections;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnimatableTransform.java */
/* loaded from: classes.dex */
public class r implements InterfaceC0678va {

    /* renamed from: a, reason: collision with root package name */
    private final C0652i f7810a;

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC0671s<PointF> f7811b;

    /* renamed from: c, reason: collision with root package name */
    private final C0660m f7812c;

    /* renamed from: d, reason: collision with root package name */
    private final C0642d f7813d;

    /* renamed from: e, reason: collision with root package name */
    private final C0650h f7814e;

    public bb a() {
        return new bb(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0652i b() {
        return this.f7810a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0650h c() {
        return this.f7814e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InterfaceC0671s<PointF> d() {
        return this.f7811b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0642d e() {
        return this.f7813d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0660m f() {
        return this.f7812c;
    }

    private r(C0652i c0652i, InterfaceC0671s<PointF> interfaceC0671s, C0660m c0660m, C0642d c0642d, C0650h c0650h) {
        this.f7810a = c0652i;
        this.f7811b = interfaceC0671s;
        this.f7812c = c0660m;
        this.f7813d = c0642d;
        this.f7814e = c0650h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnimatableTransform.java */
    /* loaded from: classes.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static r a() {
            return new r(new C0652i(), new C0652i(), C0660m.a.a(), C0642d.a.a(), C0650h.a.a());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static r a(JSONObject jSONObject, C0657ka c0657ka) {
            C0652i c0652i;
            C0660m c0660m;
            C0650h c0650h;
            JSONObject optJSONObject = jSONObject.optJSONObject(com.umeng.commonsdk.proguard.e.al);
            if (optJSONObject != null) {
                c0652i = new C0652i(optJSONObject.opt("k"), c0657ka);
            } else {
                Log.w("LOTTIE", "Layer has no transform property. You may be using an unsupported layer type such as a camera.");
                c0652i = new C0652i();
            }
            C0652i c0652i2 = c0652i;
            JSONObject optJSONObject2 = jSONObject.optJSONObject("p");
            if (optJSONObject2 != null) {
                InterfaceC0671s<PointF> a2 = C0652i.a(optJSONObject2, c0657ka);
                JSONObject optJSONObject3 = jSONObject.optJSONObject(com.umeng.commonsdk.proguard.e.ap);
                if (optJSONObject3 != null) {
                    c0660m = C0660m.a.a(optJSONObject3, c0657ka);
                } else {
                    c0660m = new C0660m(Collections.emptyList(), new La());
                }
                C0660m c0660m2 = c0660m;
                JSONObject optJSONObject4 = jSONObject.optJSONObject("r");
                if (optJSONObject4 == null) {
                    optJSONObject4 = jSONObject.optJSONObject("rz");
                }
                if (optJSONObject4 != null) {
                    C0642d a3 = C0642d.a.a(optJSONObject4, c0657ka, false);
                    JSONObject optJSONObject5 = jSONObject.optJSONObject("o");
                    if (optJSONObject5 != null) {
                        c0650h = C0650h.a.a(optJSONObject5, c0657ka);
                    } else {
                        c0650h = new C0650h(Collections.emptyList(), 100);
                    }
                    return new r(c0652i2, a2, c0660m2, a3, c0650h);
                }
                a("rotation");
                throw null;
            }
            a("position");
            throw null;
        }

        private static void a(String str) {
            throw new IllegalArgumentException("Missing transform for " + str);
        }
    }
}
