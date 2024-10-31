package com.squareup.okhttp;

import com.squareup.okhttp.x;
import java.io.IOException;
import java.net.URI;
import java.util.List;

/* compiled from: Request.java */
/* loaded from: classes3.dex */
public final class E {

    /* renamed from: a */
    private final HttpUrl f25080a;

    /* renamed from: b */
    private final String f25081b;

    /* renamed from: c */
    private final x f25082c;

    /* renamed from: d */
    private final F f25083d;

    /* renamed from: e */
    private final Object f25084e;

    /* renamed from: f */
    private volatile URI f25085f;

    /* renamed from: g */
    private volatile C2382h f25086g;

    /* compiled from: Request.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a */
        private HttpUrl f25087a;

        /* renamed from: b */
        private String f25088b;

        /* renamed from: c */
        private x.a f25089c;

        /* renamed from: d */
        private F f25090d;

        /* renamed from: e */
        private Object f25091e;

        /* synthetic */ a(E e2, D d2) {
            this(e2);
        }

        public a() {
            this.f25088b = "GET";
            this.f25089c = new x.a();
        }

        public a a(HttpUrl httpUrl) {
            if (httpUrl != null) {
                this.f25087a = httpUrl;
                return this;
            }
            throw new IllegalArgumentException("url == null");
        }

        public a b(String str) {
            if (str != null) {
                if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                    str = "http:" + str.substring(3);
                } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                    str = "https:" + str.substring(4);
                }
                HttpUrl b2 = HttpUrl.b(str);
                if (b2 != null) {
                    a(b2);
                    return this;
                }
                throw new IllegalArgumentException("unexpected url: " + str);
            }
            throw new IllegalArgumentException("url == null");
        }

        public a a(String str, String str2) {
            this.f25089c.a(str, str2);
            return this;
        }

        private a(E e2) {
            this.f25087a = e2.f25080a;
            this.f25088b = e2.f25081b;
            this.f25090d = e2.f25083d;
            this.f25091e = e2.f25084e;
            this.f25089c = e2.f25082c.a();
        }

        public a a(String str) {
            this.f25089c.b(str);
            return this;
        }

        public a a(x xVar) {
            this.f25089c = xVar.a();
            return this;
        }

        public a a(C2382h c2382h) {
            String c2382h2 = c2382h.toString();
            if (c2382h2.isEmpty()) {
                a("Cache-Control");
                return this;
            }
            b("Cache-Control", c2382h2);
            return this;
        }

        public a a(String str, F f2) {
            if (str != null && str.length() != 0) {
                if (f2 != null && !com.squareup.okhttp.internal.http.n.b(str)) {
                    throw new IllegalArgumentException("method " + str + " must not have a request body.");
                }
                if (f2 == null && com.squareup.okhttp.internal.http.n.d(str)) {
                    throw new IllegalArgumentException("method " + str + " must have a request body.");
                }
                this.f25088b = str;
                this.f25090d = f2;
                return this;
            }
            throw new IllegalArgumentException("method == null || method.length() == 0");
        }

        public a b(String str, String str2) {
            this.f25089c.c(str, str2);
            return this;
        }

        public E a() {
            if (this.f25087a != null) {
                return new E(this);
            }
            throw new IllegalStateException("url == null");
        }
    }

    /* synthetic */ E(a aVar, D d2) {
        this(aVar);
    }

    public String f() {
        return this.f25081b;
    }

    public a g() {
        return new a();
    }

    public URI h() throws IOException {
        try {
            URI uri = this.f25085f;
            if (uri != null) {
                return uri;
            }
            URI m = this.f25080a.m();
            this.f25085f = m;
            return m;
        } catch (IllegalStateException e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public String i() {
        return this.f25080a.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.f25081b);
        sb.append(", url=");
        sb.append(this.f25080a);
        sb.append(", tag=");
        Object obj = this.f25084e;
        if (obj == this) {
            obj = null;
        }
        sb.append(obj);
        sb.append('}');
        return sb.toString();
    }

    private E(a aVar) {
        this.f25080a = aVar.f25087a;
        this.f25081b = aVar.f25088b;
        this.f25082c = aVar.f25089c.a();
        this.f25083d = aVar.f25090d;
        this.f25084e = aVar.f25091e != null ? aVar.f25091e : this;
    }

    public String a(String str) {
        return this.f25082c.a(str);
    }

    public List<String> b(String str) {
        return this.f25082c.c(str);
    }

    public x c() {
        return this.f25082c;
    }

    public HttpUrl d() {
        return this.f25080a;
    }

    public boolean e() {
        return this.f25080a.h();
    }

    public F a() {
        return this.f25083d;
    }

    public C2382h b() {
        C2382h c2382h = this.f25086g;
        if (c2382h != null) {
            return c2382h;
        }
        C2382h a2 = C2382h.a(this.f25082c);
        this.f25086g = a2;
        return a2;
    }
}
