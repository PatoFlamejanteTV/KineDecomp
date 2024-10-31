package com.airbnb.lottie;

import android.graphics.Paint;
import com.airbnb.lottie.C0638b;
import com.airbnb.lottie.C0642d;
import com.airbnb.lottie.C0650h;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ShapeStroke {

    /* renamed from: a */
    private final String f7697a;

    /* renamed from: b */
    private final C0642d f7698b;

    /* renamed from: c */
    private final List<C0642d> f7699c;

    /* renamed from: d */
    private final C0638b f7700d;

    /* renamed from: e */
    private final C0650h f7701e;

    /* renamed from: f */
    private final C0642d f7702f;

    /* renamed from: g */
    private final LineCapType f7703g;

    /* renamed from: h */
    private final LineJoinType f7704h;

    /* loaded from: classes.dex */
    public enum LineCapType {
        Butt,
        Round,
        Unknown;

        public Paint.Cap toPaintCap() {
            int i = Wa.f7724a[ordinal()];
            if (i == 1) {
                return Paint.Cap.BUTT;
            }
            if (i != 2) {
                return Paint.Cap.SQUARE;
            }
            return Paint.Cap.ROUND;
        }
    }

    /* loaded from: classes.dex */
    public enum LineJoinType {
        Miter,
        Round,
        Bevel;

        public Paint.Join toPaintJoin() {
            int i = Wa.f7725b[ordinal()];
            if (i == 1) {
                return Paint.Join.BEVEL;
            }
            if (i == 2) {
                return Paint.Join.MITER;
            }
            if (i != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    /* loaded from: classes.dex */
    static class a {
        public static ShapeStroke a(JSONObject jSONObject, C0657ka c0657ka) {
            C0642d c0642d;
            JSONArray jSONArray;
            String optString = jSONObject.optString("nm");
            ArrayList arrayList = new ArrayList();
            C0638b a2 = C0638b.a.a(jSONObject.optJSONObject("c"), c0657ka);
            C0642d a3 = C0642d.a.a(jSONObject.optJSONObject("w"), c0657ka);
            C0650h a4 = C0650h.a.a(jSONObject.optJSONObject("o"), c0657ka);
            LineCapType lineCapType = LineCapType.values()[jSONObject.optInt("lc") - 1];
            LineJoinType lineJoinType = LineJoinType.values()[jSONObject.optInt("lj") - 1];
            if (jSONObject.has(com.umeng.commonsdk.proguard.e.am)) {
                JSONArray optJSONArray = jSONObject.optJSONArray(com.umeng.commonsdk.proguard.e.am);
                C0642d c0642d2 = null;
                int i = 0;
                while (i < optJSONArray.length()) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    String optString2 = optJSONObject.optString("n");
                    if (optString2.equals("o")) {
                        jSONArray = optJSONArray;
                        c0642d2 = C0642d.a.a(optJSONObject.optJSONObject("v"), c0657ka);
                    } else {
                        if (optString2.equals(com.umeng.commonsdk.proguard.e.am)) {
                            jSONArray = optJSONArray;
                        } else {
                            jSONArray = optJSONArray;
                            if (!optString2.equals("g")) {
                            }
                        }
                        arrayList.add(C0642d.a.a(optJSONObject.optJSONObject("v"), c0657ka));
                    }
                    i++;
                    optJSONArray = jSONArray;
                }
                if (arrayList.size() == 1) {
                    arrayList.add(arrayList.get(0));
                }
                c0642d = c0642d2;
            } else {
                c0642d = null;
            }
            return new ShapeStroke(optString, c0642d, arrayList, a2, a4, a3, lineCapType, lineJoinType, null);
        }
    }

    /* synthetic */ ShapeStroke(String str, C0642d c0642d, List list, C0638b c0638b, C0650h c0650h, C0642d c0642d2, LineCapType lineCapType, LineJoinType lineJoinType, Wa wa) {
        this(str, c0642d, list, c0638b, c0650h, c0642d2, lineCapType, lineJoinType);
    }

    public LineCapType a() {
        return this.f7703g;
    }

    public C0638b b() {
        return this.f7700d;
    }

    public C0642d c() {
        return this.f7698b;
    }

    public LineJoinType d() {
        return this.f7704h;
    }

    public List<C0642d> e() {
        return this.f7699c;
    }

    public String f() {
        return this.f7697a;
    }

    public C0650h g() {
        return this.f7701e;
    }

    public C0642d h() {
        return this.f7702f;
    }

    private ShapeStroke(String str, C0642d c0642d, List<C0642d> list, C0638b c0638b, C0650h c0650h, C0642d c0642d2, LineCapType lineCapType, LineJoinType lineJoinType) {
        this.f7697a = str;
        this.f7698b = c0642d;
        this.f7699c = list;
        this.f7700d = c0638b;
        this.f7701e = c0650h;
        this.f7702f = c0642d2;
        this.f7703g = lineCapType;
        this.f7704h = lineJoinType;
    }
}
