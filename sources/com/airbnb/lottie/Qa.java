package com.airbnb.lottie;

import android.graphics.Path;
import com.airbnb.lottie.C0638b;
import com.airbnb.lottie.C0650h;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShapeFill.java */
/* loaded from: classes.dex */
public class Qa {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f7688a;

    /* renamed from: b, reason: collision with root package name */
    private final Path.FillType f7689b;

    /* renamed from: c, reason: collision with root package name */
    private final String f7690c;

    /* renamed from: d, reason: collision with root package name */
    private final C0638b f7691d;

    /* renamed from: e, reason: collision with root package name */
    private final C0650h f7692e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ShapeFill.java */
    /* loaded from: classes.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static Qa a(JSONObject jSONObject, C0657ka c0657ka) {
            String optString = jSONObject.optString("nm");
            JSONObject optJSONObject = jSONObject.optJSONObject("c");
            C0638b a2 = optJSONObject != null ? C0638b.a.a(optJSONObject, c0657ka) : null;
            JSONObject optJSONObject2 = jSONObject.optJSONObject("o");
            return new Qa(optString, jSONObject.optBoolean("fillEnabled"), jSONObject.optInt("r", 1) == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, a2, optJSONObject2 != null ? C0650h.a.a(optJSONObject2, c0657ka) : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0638b a() {
        return this.f7691d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Path.FillType b() {
        return this.f7689b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c() {
        return this.f7690c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0650h d() {
        return this.f7692e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ShapeFill{color=");
        C0638b c0638b = this.f7691d;
        sb.append(c0638b == null ? "null" : Integer.toHexString(c0638b.b().intValue()));
        sb.append(", fillEnabled=");
        sb.append(this.f7688a);
        sb.append(", opacity=");
        C0650h c0650h = this.f7692e;
        sb.append(c0650h != null ? c0650h.b() : "null");
        sb.append('}');
        return sb.toString();
    }

    private Qa(String str, boolean z, Path.FillType fillType, C0638b c0638b, C0650h c0650h) {
        this.f7690c = str;
        this.f7688a = z;
        this.f7689b = fillType;
        this.f7691d = c0638b;
        this.f7692e = c0650h;
    }
}
