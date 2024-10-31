package com.airbnb.lottie;

import android.graphics.PointF;
import com.airbnb.lottie.InterfaceC0671s;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: PointFFactory.java */
/* loaded from: classes.dex */
class Ca implements InterfaceC0671s.a<PointF> {

    /* renamed from: a */
    static final Ca f7600a = new Ca();

    private Ca() {
    }

    @Override // com.airbnb.lottie.InterfaceC0671s.a
    public PointF a(Object obj, float f2) {
        if (obj instanceof JSONArray) {
            return C0647fa.a((JSONArray) obj, f2);
        }
        if (obj instanceof JSONObject) {
            return C0647fa.a((JSONObject) obj, f2);
        }
        throw new IllegalArgumentException("Unable to parse point from " + obj);
    }
}
