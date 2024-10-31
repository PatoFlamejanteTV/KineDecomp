package com.airbnb.lottie;

import com.airbnb.lottie.C0649ga;
import com.airbnb.lottie.InterfaceC0671s;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AnimatableValueParser.java */
/* renamed from: com.airbnb.lottie.t */
/* loaded from: classes.dex */
public class C0673t<T> {

    /* renamed from: a */
    private final JSONObject f7816a;

    /* renamed from: b */
    private final float f7817b;

    /* renamed from: c */
    private final C0657ka f7818c;

    /* renamed from: d */
    private final InterfaceC0671s.a<T> f7819d;

    /* compiled from: AnimatableValueParser.java */
    /* renamed from: com.airbnb.lottie.t$a */
    /* loaded from: classes.dex */
    public static class a<T> {

        /* renamed from: a */
        final List<C0649ga<T>> f7820a;

        /* renamed from: b */
        final T f7821b;

        a(List<C0649ga<T>> list, T t) {
            this.f7820a = list;
            this.f7821b = t;
        }
    }

    private C0673t(JSONObject jSONObject, float f2, C0657ka c0657ka, InterfaceC0671s.a<T> aVar) {
        this.f7816a = jSONObject;
        this.f7817b = f2;
        this.f7818c = c0657ka;
        this.f7819d = aVar;
    }

    public static <T> C0673t<T> a(JSONObject jSONObject, float f2, C0657ka c0657ka, InterfaceC0671s.a<T> aVar) {
        return new C0673t<>(jSONObject, f2, c0657ka, aVar);
    }

    private List<C0649ga<T>> b() {
        JSONObject jSONObject = this.f7816a;
        if (jSONObject != null) {
            Object opt = jSONObject.opt("k");
            if (a(opt)) {
                return C0649ga.a.a((JSONArray) opt, this.f7818c, this.f7817b, this.f7819d);
            }
            return Collections.emptyList();
        }
        return Collections.emptyList();
    }

    public a<T> a() {
        List<C0649ga<T>> b2 = b();
        return new a<>(b2, a((List) b2));
    }

    private T a(List<C0649ga<T>> list) {
        if (this.f7816a == null) {
            return null;
        }
        if (!list.isEmpty()) {
            return list.get(0).f7772c;
        }
        return this.f7819d.a(this.f7816a.opt("k"), this.f7817b);
    }

    private static boolean a(Object obj) {
        if (!(obj instanceof JSONArray)) {
            return false;
        }
        Object opt = ((JSONArray) obj).opt(0);
        return (opt instanceof JSONObject) && ((JSONObject) opt).has(com.umeng.commonsdk.proguard.e.ar);
    }
}
