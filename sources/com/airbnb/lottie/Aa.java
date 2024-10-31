package com.airbnb.lottie;

import android.graphics.Path;
import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.C0649ga;
import com.airbnb.lottie.InterfaceC0671s;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: PathKeyframe.java */
/* loaded from: classes.dex */
public class Aa extends C0649ga<PointF> {

    /* renamed from: h */
    private Path f7596h;

    /* compiled from: PathKeyframe.java */
    /* loaded from: classes.dex */
    public static class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static Aa a(JSONObject jSONObject, C0657ka c0657ka, InterfaceC0671s.a<PointF> aVar) {
            PointF pointF;
            T t;
            C0649ga a2 = C0649ga.a.a(jSONObject, c0657ka, c0657ka.b(), aVar);
            JSONArray optJSONArray = jSONObject.optJSONArray("ti");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("to");
            PointF pointF2 = null;
            if (optJSONArray == null || optJSONArray2 == null) {
                pointF = null;
            } else {
                pointF2 = C0647fa.a(optJSONArray2, c0657ka.b());
                pointF = C0647fa.a(optJSONArray, c0657ka.b());
            }
            Aa aa = new Aa(c0657ka, (PointF) a2.f7772c, (PointF) a2.f7773d, a2.f7774e, a2.f7775f, a2.f7776g);
            T t2 = a2.f7773d;
            boolean z = (t2 == 0 || (t = a2.f7772c) == 0 || !((PointF) t).equals(((PointF) t2).x, ((PointF) t2).y)) ? false : true;
            if (aa.f7773d != 0 && !z) {
                aa.f7596h = db.a((PointF) a2.f7772c, (PointF) a2.f7773d, pointF2, pointF);
            }
            return aa;
        }
    }

    /* synthetic */ Aa(C0657ka c0657ka, PointF pointF, PointF pointF2, Interpolator interpolator, float f2, Float f3, C0686za c0686za) {
        this(c0657ka, pointF, pointF2, interpolator, f2, f3);
    }

    public Path e() {
        return this.f7596h;
    }

    private Aa(C0657ka c0657ka, PointF pointF, PointF pointF2, Interpolator interpolator, float f2, Float f3) {
        super(c0657ka, pointF, pointF2, interpolator, f2, f3);
    }
}
