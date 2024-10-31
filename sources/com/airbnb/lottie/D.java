package com.airbnb.lottie;

import android.graphics.PointF;
import com.airbnb.lottie.C0656k;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CircleShape.java */
/* loaded from: classes.dex */
public class D {

    /* renamed from: a, reason: collision with root package name */
    private final String f7601a;

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC0671s<PointF> f7602b;

    /* renamed from: c, reason: collision with root package name */
    private final C0656k f7603c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CircleShape.java */
    /* loaded from: classes.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static D a(JSONObject jSONObject, C0657ka c0657ka) {
            return new D(jSONObject.optString("nm"), C0652i.a(jSONObject.optJSONObject("p"), c0657ka), C0656k.a.a(jSONObject.optJSONObject(com.umeng.commonsdk.proguard.e.ap), c0657ka));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        return this.f7601a;
    }

    public InterfaceC0671s<PointF> b() {
        return this.f7602b;
    }

    public C0656k c() {
        return this.f7603c;
    }

    private D(String str, InterfaceC0671s<PointF> interfaceC0671s, C0656k c0656k) {
        this.f7601a = str;
        this.f7602b = interfaceC0671s;
        this.f7603c = c0656k;
    }
}
