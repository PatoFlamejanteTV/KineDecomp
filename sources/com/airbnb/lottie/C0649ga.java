package com.airbnb.lottie;

import android.graphics.PointF;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.airbnb.lottie.InterfaceC0671s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Keyframe.java */
/* renamed from: com.airbnb.lottie.ga */
/* loaded from: classes.dex */
public class C0649ga<T> {

    /* renamed from: a */
    private static final Interpolator f7770a = new LinearInterpolator();

    /* renamed from: b */
    private final C0657ka f7771b;

    /* renamed from: c */
    final T f7772c;

    /* renamed from: d */
    final T f7773d;

    /* renamed from: e */
    final Interpolator f7774e;

    /* renamed from: f */
    final float f7775f;

    /* renamed from: g */
    Float f7776g;

    public C0649ga(C0657ka c0657ka, T t, T t2, Interpolator interpolator, float f2, Float f3) {
        this.f7771b = c0657ka;
        this.f7772c = t;
        this.f7773d = t2;
        this.f7774e = interpolator;
        this.f7775f = f2;
        this.f7776g = f3;
    }

    public float b() {
        Float f2 = this.f7776g;
        if (f2 == null) {
            return 1.0f;
        }
        return f2.floatValue() / this.f7771b.d();
    }

    public float c() {
        return this.f7775f / this.f7771b.d();
    }

    public boolean d() {
        return this.f7774e == null;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f7772c + ", endValue=" + this.f7773d + ", startFrame=" + this.f7775f + ", endFrame=" + this.f7776g + ", interpolator=" + this.f7774e + '}';
    }

    public static void a(List<? extends C0649ga<?>> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            C0649ga<?> c0649ga = list.get(i2);
            i2++;
            c0649ga.f7776g = Float.valueOf(list.get(i2).f7775f);
        }
        C0649ga<?> c0649ga2 = list.get(i);
        if (c0649ga2.f7772c == null) {
            list.remove(c0649ga2);
        }
    }

    public boolean a(float f2) {
        return f2 >= c() && f2 <= b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Keyframe.java */
    /* renamed from: com.airbnb.lottie.ga$a */
    /* loaded from: classes.dex */
    public static class a {
        public static <T> C0649ga<T> a(JSONObject jSONObject, C0657ka c0657ka, float f2, InterfaceC0671s.a<T> aVar) {
            T a2;
            T t;
            Interpolator interpolator;
            float f3;
            PointF pointF;
            Interpolator interpolator2;
            Interpolator interpolator3;
            PointF pointF2 = null;
            if (jSONObject.has(com.umeng.commonsdk.proguard.e.ar)) {
                float optDouble = (float) jSONObject.optDouble(com.umeng.commonsdk.proguard.e.ar, 0.0d);
                Object opt = jSONObject.opt(com.umeng.commonsdk.proguard.e.ap);
                T a3 = opt != null ? aVar.a(opt, f2) : null;
                Object opt2 = jSONObject.opt("e");
                T a4 = opt2 != null ? aVar.a(opt2, f2) : null;
                JSONObject optJSONObject = jSONObject.optJSONObject("o");
                JSONObject optJSONObject2 = jSONObject.optJSONObject(com.umeng.commonsdk.proguard.e.aq);
                if (optJSONObject == null || optJSONObject2 == null) {
                    pointF = null;
                } else {
                    pointF2 = C0647fa.a(optJSONObject, f2);
                    pointF = C0647fa.a(optJSONObject2, f2);
                }
                if (jSONObject.optInt("h", 0) == 1) {
                    interpolator3 = C0649ga.f7770a;
                    a4 = a3;
                } else {
                    if (pointF2 == null) {
                        interpolator2 = C0649ga.f7770a;
                    } else {
                        pointF2.x = C0676ua.a(pointF2.x, -100.0f, 100.0f);
                        pointF2.y = C0676ua.a(pointF2.y, -100.0f, 100.0f);
                        pointF.x = C0676ua.a(pointF.x, -100.0f, 100.0f);
                        pointF.y = C0676ua.a(pointF.y, -100.0f, 100.0f);
                        interpolator2 = PathInterpolatorCompat.create(pointF2.x / f2, pointF2.y / f2, pointF.x / f2, pointF.y / f2);
                    }
                    interpolator3 = interpolator2;
                }
                t = a4;
                f3 = optDouble;
                a2 = a3;
                interpolator = interpolator3;
            } else {
                a2 = aVar.a(jSONObject, f2);
                t = a2;
                interpolator = null;
                f3 = 0.0f;
            }
            return new C0649ga<>(c0657ka, a2, t, interpolator, f3, null);
        }

        public static <T> List<C0649ga<T>> a(JSONArray jSONArray, C0657ka c0657ka, float f2, InterfaceC0671s.a<T> aVar) {
            int length = jSONArray.length();
            if (length == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                arrayList.add(a(jSONArray.optJSONObject(i), c0657ka, f2, aVar));
            }
            C0649ga.a(arrayList);
            return arrayList;
        }
    }
}
