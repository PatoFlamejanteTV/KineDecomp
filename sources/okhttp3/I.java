package okhttp3;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;
import okhttp3.z;

/* compiled from: Request.java */
/* loaded from: classes3.dex */
public final class I {

    /* renamed from: a */
    final A f28802a;

    /* renamed from: b */
    final String f28803b;

    /* renamed from: c */
    final z f28804c;

    /* renamed from: d */
    @Nullable
    final L f28805d;

    /* renamed from: e */
    final Map<Class<?>, Object> f28806e;

    /* renamed from: f */
    @Nullable
    private volatile C2561e f28807f;

    I(a aVar) {
        this.f28802a = aVar.f28808a;
        this.f28803b = aVar.f28809b;
        this.f28804c = aVar.f28810c.a();
        this.f28805d = aVar.f28811d;
        this.f28806e = okhttp3.a.e.a(aVar.f28812e);
    }

    @Nullable
    public String a(String str) {
        return this.f28804c.b(str);
    }

    public C2561e b() {
        C2561e c2561e = this.f28807f;
        if (c2561e != null) {
            return c2561e;
        }
        C2561e a2 = C2561e.a(this.f28804c);
        this.f28807f = a2;
        return a2;
    }

    public z c() {
        return this.f28804c;
    }

    public boolean d() {
        return this.f28802a.h();
    }

    public String e() {
        return this.f28803b;
    }

    public a f() {
        return new a(this);
    }

    public A g() {
        return this.f28802a;
    }

    public String toString() {
        return "Request{method=" + this.f28803b + ", url=" + this.f28802a + ", tags=" + this.f28806e + '}';
    }

    /* compiled from: Request.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a */
        @Nullable
        A f28808a;

        /* renamed from: b */
        String f28809b;

        /* renamed from: c */
        z.a f28810c;

        /* renamed from: d */
        @Nullable
        L f28811d;

        /* renamed from: e */
        Map<Class<?>, Object> f28812e;

        public a() {
            this.f28812e = Collections.emptyMap();
            this.f28809b = "GET";
            this.f28810c = new z.a();
        }

        public a a(A a2) {
            if (a2 != null) {
                this.f28808a = a2;
                return this;
            }
            throw new NullPointerException("url == null");
        }

        public a b(String str, String str2) {
            this.f28810c.c(str, str2);
            return this;
        }

        public a a(String str, String str2) {
            this.f28810c.a(str, str2);
            return this;
        }

        public a a(String str) {
            this.f28810c.b(str);
            return this;
        }

        a(I i) {
            Map<Class<?>, Object> linkedHashMap;
            this.f28812e = Collections.emptyMap();
            this.f28808a = i.f28802a;
            this.f28809b = i.f28803b;
            this.f28811d = i.f28805d;
            if (i.f28806e.isEmpty()) {
                linkedHashMap = Collections.emptyMap();
            } else {
                linkedHashMap = new LinkedHashMap<>(i.f28806e);
            }
            this.f28812e = linkedHashMap;
            this.f28810c = i.f28804c.a();
        }

        public a a(z zVar) {
            this.f28810c = zVar.a();
            return this;
        }

        public a a(L l) {
            a("POST", l);
            return this;
        }

        public a a(String str, @Nullable L l) {
            if (str != null) {
                if (str.length() != 0) {
                    if (l != null && !okhttp3.a.b.g.b(str)) {
                        throw new IllegalArgumentException("method " + str + " must not have a request body.");
                    }
                    if (l == null && okhttp3.a.b.g.e(str)) {
                        throw new IllegalArgumentException("method " + str + " must have a request body.");
                    }
                    this.f28809b = str;
                    this.f28811d = l;
                    return this;
                }
                throw new IllegalArgumentException("method.length() == 0");
            }
            throw new NullPointerException("method == null");
        }

        public <T> a a(Class<? super T> cls, @Nullable T t) {
            if (cls == null) {
                throw new NullPointerException("type == null");
            }
            if (t == null) {
                this.f28812e.remove(cls);
            } else {
                if (this.f28812e.isEmpty()) {
                    this.f28812e = new LinkedHashMap();
                }
                this.f28812e.put(cls, cls.cast(t));
            }
            return this;
        }

        public I a() {
            if (this.f28808a != null) {
                return new I(this);
            }
            throw new IllegalStateException("url == null");
        }
    }

    @Nullable
    public L a() {
        return this.f28805d;
    }
}
