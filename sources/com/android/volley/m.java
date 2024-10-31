package com.android.volley;

import com.android.volley.a;

/* compiled from: Response.java */
/* loaded from: classes.dex */
public class m<T> {

    /* renamed from: a */
    public final T f8087a;

    /* renamed from: b */
    public final a.C0040a f8088b;

    /* renamed from: c */
    public final VolleyError f8089c;

    /* renamed from: d */
    public boolean f8090d;

    /* compiled from: Response.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(VolleyError volleyError);
    }

    /* compiled from: Response.java */
    /* loaded from: classes.dex */
    public interface b<T> {
        void a(T t);
    }

    private m(T t, a.C0040a c0040a) {
        this.f8090d = false;
        this.f8087a = t;
        this.f8088b = c0040a;
        this.f8089c = null;
    }

    public static <T> m<T> a(T t, a.C0040a c0040a) {
        return new m<>(t, c0040a);
    }

    public static <T> m<T> a(VolleyError volleyError) {
        return new m<>(volleyError);
    }

    public boolean a() {
        return this.f8089c == null;
    }

    private m(VolleyError volleyError) {
        this.f8090d = false;
        this.f8087a = null;
        this.f8088b = null;
        this.f8089c = volleyError;
    }
}
