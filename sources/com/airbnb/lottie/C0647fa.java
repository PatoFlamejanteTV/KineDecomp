package com.airbnb.lottie;

import android.graphics.PointF;
import com.nexstreaming.kinemaster.ui.settings.FragmentC2201x;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JsonUtils.java */
/* renamed from: com.airbnb.lottie.fa */
/* loaded from: classes.dex */
public class C0647fa {
    public static PointF a(JSONObject jSONObject, float f2) {
        return new PointF(a(jSONObject.opt(FragmentC2201x.f23219a)) * f2, a(jSONObject.opt("y")) * f2);
    }

    public static PointF a(JSONArray jSONArray, float f2) {
        if (jSONArray.length() >= 2) {
            return new PointF(((float) jSONArray.optDouble(0, 1.0d)) * f2, ((float) jSONArray.optDouble(1, 1.0d)) * f2);
        }
        throw new IllegalArgumentException("Unable to parse point for " + jSONArray);
    }

    public static float a(Object obj) {
        if (obj instanceof Float) {
            return ((Float) obj).floatValue();
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof Double) {
            return (float) ((Double) obj).doubleValue();
        }
        if (obj instanceof JSONArray) {
            return (float) ((JSONArray) obj).optDouble(0);
        }
        return 0.0f;
    }
}
