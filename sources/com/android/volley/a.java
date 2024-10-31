package com.android.volley;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: Cache.java */
/* loaded from: classes.dex */
public interface a {

    /* compiled from: Cache.java */
    /* renamed from: com.android.volley.a$a */
    /* loaded from: classes.dex */
    public static class C0040a {

        /* renamed from: a */
        public byte[] f7981a;

        /* renamed from: b */
        public String f7982b;

        /* renamed from: c */
        public long f7983c;

        /* renamed from: d */
        public long f7984d;

        /* renamed from: e */
        public long f7985e;

        /* renamed from: f */
        public long f7986f;

        /* renamed from: g */
        public Map<String, String> f7987g = Collections.emptyMap();

        /* renamed from: h */
        public List<g> f7988h;

        public boolean a() {
            return this.f7985e < System.currentTimeMillis();
        }

        public boolean b() {
            return this.f7986f < System.currentTimeMillis();
        }
    }

    C0040a a(String str);

    void a(String str, C0040a c0040a);

    void clear();

    void d();
}
