package com.airbnb.lottie;

import android.util.Log;
import com.airbnb.lottie.D;
import com.airbnb.lottie.Ja;
import com.airbnb.lottie.MergePaths;
import com.airbnb.lottie.PolystarShape;
import com.airbnb.lottie.Qa;
import com.airbnb.lottie.ShapeStroke;
import com.airbnb.lottie.ShapeTrimPath;
import com.airbnb.lottie.Va;
import com.airbnb.lottie.W;
import com.airbnb.lottie.Z;
import com.airbnb.lottie.r;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShapeGroup.java */
/* loaded from: classes.dex */
public class Ra {

    /* renamed from: a, reason: collision with root package name */
    private final String f7693a;

    /* renamed from: b, reason: collision with root package name */
    private final List<Object> f7694b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ShapeGroup.java */
    /* loaded from: classes.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static Ra b(JSONObject jSONObject, C0657ka c0657ka) {
            JSONArray optJSONArray = jSONObject.optJSONArray("it");
            String optString = jSONObject.optString("nm");
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                Object a2 = Ra.a(optJSONArray.optJSONObject(i), c0657ka);
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
            return new Ra(optString, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ra(String str, List<Object> list) {
        this.f7693a = str;
        this.f7694b = list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object a(JSONObject jSONObject, C0657ka c0657ka) {
        char c2;
        String optString = jSONObject.optString("ty");
        int hashCode = optString.hashCode();
        if (hashCode == 3239) {
            if (optString.equals("el")) {
                c2 = 7;
            }
            c2 = 65535;
        } else if (hashCode == 3270) {
            if (optString.equals("fl")) {
                c2 = 3;
            }
            c2 = 65535;
        } else if (hashCode == 3295) {
            if (optString.equals("gf")) {
                c2 = 4;
            }
            c2 = 65535;
        } else if (hashCode == 3488) {
            if (optString.equals("mm")) {
                c2 = 11;
            }
            c2 = 65535;
        } else if (hashCode == 3633) {
            if (optString.equals("rc")) {
                c2 = '\b';
            }
            c2 = 65535;
        } else if (hashCode == 3669) {
            if (optString.equals("sh")) {
                c2 = 6;
            }
            c2 = 65535;
        } else if (hashCode == 3679) {
            if (optString.equals("sr")) {
                c2 = '\n';
            }
            c2 = 65535;
        } else if (hashCode == 3681) {
            if (optString.equals("st")) {
                c2 = 1;
            }
            c2 = 65535;
        } else if (hashCode == 3705) {
            if (optString.equals("tm")) {
                c2 = '\t';
            }
            c2 = 65535;
        } else if (hashCode == 3710) {
            if (optString.equals("tr")) {
                c2 = 5;
            }
            c2 = 65535;
        } else if (hashCode != 3307) {
            if (hashCode == 3308 && optString.equals("gs")) {
                c2 = 2;
            }
            c2 = 65535;
        } else {
            if (optString.equals("gr")) {
                c2 = 0;
            }
            c2 = 65535;
        }
        switch (c2) {
            case 0:
                return a.b(jSONObject, c0657ka);
            case 1:
                return ShapeStroke.a.a(jSONObject, c0657ka);
            case 2:
                return Z.a.a(jSONObject, c0657ka);
            case 3:
                return Qa.a.a(jSONObject, c0657ka);
            case 4:
                return W.a.a(jSONObject, c0657ka);
            case 5:
                return r.a.a(jSONObject, c0657ka);
            case 6:
                return Va.a.a(jSONObject, c0657ka);
            case 7:
                return D.a.a(jSONObject, c0657ka);
            case '\b':
                return Ja.a.a(jSONObject, c0657ka);
            case '\t':
                return ShapeTrimPath.a.a(jSONObject, c0657ka);
            case '\n':
                return PolystarShape.a.a(jSONObject, c0657ka);
            case 11:
                return MergePaths.a.a(jSONObject);
            default:
                Log.w("LOTTIE", "Unknown shape type " + optString);
                return null;
        }
    }

    public String b() {
        return this.f7693a;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f7693a + "' Shapes: " + Arrays.toString(this.f7694b.toArray()) + '}';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Object> a() {
        return this.f7694b;
    }
}
