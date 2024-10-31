package com.airbnb.lottie;

import android.graphics.PointF;
import com.airbnb.lottie.Aa;
import com.airbnb.lottie.C0642d;
import com.airbnb.lottie.InterfaceC0671s;
import com.nexstreaming.kinemaster.ui.settings.FragmentC2201x;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnimatablePathValue.java */
/* renamed from: com.airbnb.lottie.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0652i implements InterfaceC0671s<PointF> {

    /* renamed from: a, reason: collision with root package name */
    private final List<Aa> f7778a;

    /* renamed from: b, reason: collision with root package name */
    private PointF f7779b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0652i() {
        this.f7778a = new ArrayList();
        this.f7779b = new PointF(0.0f, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InterfaceC0671s<PointF> a(JSONObject jSONObject, C0657ka c0657ka) {
        if (jSONObject.has("k")) {
            return new C0652i(jSONObject.opt("k"), c0657ka);
        }
        return new C0666p(C0642d.a.a(jSONObject.optJSONObject(FragmentC2201x.f23219a), c0657ka), C0642d.a.a(jSONObject.optJSONObject("y"), c0657ka));
    }

    public boolean b() {
        return !this.f7778a.isEmpty();
    }

    public String toString() {
        return "initialPoint=" + this.f7779b;
    }

    /* compiled from: AnimatablePathValue.java */
    /* renamed from: com.airbnb.lottie.i$a */
    /* loaded from: classes.dex */
    private static class a implements InterfaceC0671s.a<PointF> {

        /* renamed from: a, reason: collision with root package name */
        private static final InterfaceC0671s.a<PointF> f7780a = new a();

        private a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.airbnb.lottie.InterfaceC0671s.a
        public PointF a(Object obj, float f2) {
            return C0647fa.a((JSONArray) obj, f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0652i(Object obj, C0657ka c0657ka) {
        this.f7778a = new ArrayList();
        if (a(obj)) {
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                this.f7778a.add(Aa.a.a(jSONArray.optJSONObject(i), c0657ka, a.f7780a));
            }
            C0649ga.a(this.f7778a);
            return;
        }
        this.f7779b = C0647fa.a((JSONArray) obj, c0657ka.b());
    }

    private boolean a(Object obj) {
        if (!(obj instanceof JSONArray)) {
            return false;
        }
        Object opt = ((JSONArray) obj).opt(0);
        return (opt instanceof JSONObject) && ((JSONObject) opt).has(com.umeng.commonsdk.proguard.e.ar);
    }

    @Override // com.airbnb.lottie.InterfaceC0671s
    /* renamed from: a */
    public AbstractC0677v<?, PointF> a2() {
        if (!b()) {
            return new _a(this.f7779b);
        }
        return new Ba(this.f7778a);
    }
}
