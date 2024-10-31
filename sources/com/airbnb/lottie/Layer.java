package com.airbnb.lottie;

import android.graphics.Color;
import android.graphics.Rect;
import com.airbnb.lottie.Mask;
import com.airbnb.lottie.r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Layer {

    /* renamed from: a */
    private final List<Object> f7642a;

    /* renamed from: b */
    private final C0657ka f7643b;

    /* renamed from: c */
    private final String f7644c;

    /* renamed from: d */
    private final long f7645d;

    /* renamed from: e */
    private final LayerType f7646e;

    /* renamed from: f */
    private final long f7647f;

    /* renamed from: g */
    private final String f7648g;

    /* renamed from: h */
    private final List<Mask> f7649h;
    private final r i;
    private final int j;
    private final int k;
    private final int l;
    private final float m;
    private final float n;
    private final int o;
    private final int p;
    private final List<C0649ga<Float>> q;
    private final MatteType r;

    /* loaded from: classes.dex */
    public enum LayerType {
        PreComp,
        Solid,
        Image,
        Null,
        Shape,
        Text,
        Unknown
    }

    /* loaded from: classes.dex */
    public enum MatteType {
        None,
        Add,
        Invert,
        Unknown
    }

    /* synthetic */ Layer(List list, C0657ka c0657ka, String str, long j, LayerType layerType, long j2, String str2, List list2, r rVar, int i, int i2, int i3, float f2, float f3, int i4, int i5, List list3, MatteType matteType, C0653ia c0653ia) {
        this(list, c0657ka, str, j, layerType, j2, str2, list2, rVar, i, i2, i3, f2, f3, i4, i5, list3, matteType);
    }

    public long a() {
        return this.f7645d;
    }

    public List<C0649ga<Float>> b() {
        return this.q;
    }

    public LayerType c() {
        return this.f7646e;
    }

    public List<Mask> d() {
        return this.f7649h;
    }

    public MatteType e() {
        return this.r;
    }

    public String f() {
        return this.f7644c;
    }

    public long g() {
        return this.f7647f;
    }

    public String h() {
        return this.f7648g;
    }

    public List<Object> i() {
        return this.f7642a;
    }

    public int j() {
        return this.l;
    }

    public int k() {
        return this.k;
    }

    public int l() {
        return this.j;
    }

    public float m() {
        return this.n;
    }

    public r n() {
        return this.i;
    }

    public String toString() {
        return a("");
    }

    private Layer(List<Object> list, C0657ka c0657ka, String str, long j, LayerType layerType, long j2, String str2, List<Mask> list2, r rVar, int i, int i2, int i3, float f2, float f3, int i4, int i5, List<C0649ga<Float>> list3, MatteType matteType) {
        this.f7642a = list;
        this.f7643b = c0657ka;
        this.f7644c = str;
        this.f7645d = j;
        this.f7646e = layerType;
        this.f7647f = j2;
        this.f7648g = str2;
        this.f7649h = list2;
        this.i = rVar;
        this.j = i;
        this.k = i2;
        this.l = i3;
        this.m = f2;
        this.n = f3;
        this.o = i4;
        this.p = i5;
        this.q = list3;
        this.r = matteType;
    }

    public String a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(f());
        sb.append("\n");
        Layer a2 = this.f7643b.a(g());
        if (a2 != null) {
            sb.append("\t\tParents: ");
            sb.append(a2.f());
            Layer a3 = this.f7643b.a(a2.g());
            while (a3 != null) {
                sb.append("->");
                sb.append(a3.f());
                a3 = this.f7643b.a(a3.g());
            }
            sb.append(str);
            sb.append("\n");
        }
        if (!d().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(d().size());
            sb.append("\n");
        }
        if (l() != 0 && k() != 0) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(l()), Integer.valueOf(k()), Integer.valueOf(j())));
        }
        if (!this.f7642a.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (Object obj : this.f7642a) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(obj);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    /* loaded from: classes.dex */
    public static class a {
        public static Layer a(C0657ka c0657ka) {
            Rect a2 = c0657ka.a();
            return new Layer(Collections.emptyList(), c0657ka, null, -1L, LayerType.PreComp, -1L, null, Collections.emptyList(), r.a.a(), 0, 0, 0, 0.0f, 0.0f, a2.width(), a2.height(), Collections.emptyList(), MatteType.None);
        }

        public static Layer a(JSONObject jSONObject, C0657ka c0657ka) {
            LayerType layerType;
            int i;
            int i2;
            int i3;
            int i4;
            int i5;
            float f2;
            float f3;
            float f4;
            ArrayList arrayList;
            ArrayList arrayList2;
            int i6;
            ArrayList arrayList3;
            String optString = jSONObject.optString("nm");
            String optString2 = jSONObject.optString("refId");
            long optLong = jSONObject.optLong("ind");
            int optInt = jSONObject.optInt("ty", -1);
            if (optInt < LayerType.Unknown.ordinal()) {
                layerType = LayerType.values()[optInt];
            } else {
                layerType = LayerType.Unknown;
            }
            LayerType layerType2 = layerType;
            long optLong2 = jSONObject.optLong("parent", -1L);
            if (layerType2 == LayerType.Solid) {
                i = (int) (jSONObject.optInt("sw") * c0657ka.b());
                i2 = (int) (jSONObject.optInt("sh") * c0657ka.b());
                i3 = Color.parseColor(jSONObject.optString("sc"));
            } else {
                i = 0;
                i2 = 0;
                i3 = 0;
            }
            r a2 = r.a.a(jSONObject.optJSONObject("ks"), c0657ka);
            MatteType matteType = MatteType.values()[jSONObject.optInt("tt")];
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            ArrayList arrayList6 = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("masksProperties");
            if (optJSONArray != null) {
                for (int i7 = 0; i7 < optJSONArray.length(); i7++) {
                    arrayList5.add(Mask.a.a(optJSONArray.optJSONObject(i7), c0657ka));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("shapes");
            if (optJSONArray2 != null) {
                for (int i8 = 0; i8 < optJSONArray2.length(); i8++) {
                    Object a3 = Ra.a(optJSONArray2.optJSONObject(i8), c0657ka);
                    if (a3 != null) {
                        arrayList4.add(a3);
                    }
                }
            }
            float optDouble = (float) jSONObject.optDouble("sr", 1.0d);
            float optDouble2 = ((float) jSONObject.optDouble("st")) / c0657ka.d();
            if (layerType2 == LayerType.PreComp) {
                i4 = (int) (jSONObject.optInt("w") * c0657ka.b());
                i5 = (int) (jSONObject.optInt("h") * c0657ka.b());
            } else {
                i4 = 0;
                i5 = 0;
            }
            float optLong3 = (float) jSONObject.optLong("ip");
            float optLong4 = (float) jSONObject.optLong("op");
            if (optLong3 > 0.0f) {
                f2 = optLong4;
                f3 = optLong3;
                f4 = optDouble;
                i6 = i;
                arrayList3 = arrayList6;
                arrayList = arrayList5;
                arrayList2 = arrayList4;
                arrayList3.add(new C0649ga(c0657ka, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(optLong3)));
            } else {
                f2 = optLong4;
                f3 = optLong3;
                f4 = optDouble;
                arrayList = arrayList5;
                arrayList2 = arrayList4;
                i6 = i;
                arrayList3 = arrayList6;
            }
            if (f2 <= 0.0f) {
                f2 = (float) (c0657ka.e() + 1);
            }
            arrayList3.add(new C0649ga(c0657ka, Float.valueOf(1.0f), Float.valueOf(1.0f), null, f3, Float.valueOf(f2)));
            if (f2 <= c0657ka.d()) {
                arrayList3.add(new C0649ga(c0657ka, Float.valueOf(0.0f), Float.valueOf(0.0f), null, f2, Float.valueOf((float) c0657ka.e())));
            }
            return new Layer(arrayList2, c0657ka, optString, optLong, layerType2, optLong2, optString2, arrayList, a2, i6, i2, i3, f4, optDouble2, i4, i5, arrayList3, matteType);
        }
    }
}
