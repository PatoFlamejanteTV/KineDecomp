package com.squareup.okhttp;

import com.squareup.okhttp.x;
import java.util.Collections;
import java.util.List;

/* compiled from: Response.java */
/* loaded from: classes3.dex */
public final class H {

    /* renamed from: a */
    private final E f25092a;

    /* renamed from: b */
    private final Protocol f25093b;

    /* renamed from: c */
    private final int f25094c;

    /* renamed from: d */
    private final String f25095d;

    /* renamed from: e */
    private final v f25096e;

    /* renamed from: f */
    private final x f25097f;

    /* renamed from: g */
    private final I f25098g;

    /* renamed from: h */
    private H f25099h;
    private H i;
    private final H j;
    private volatile C2382h k;

    /* compiled from: Response.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a */
        private E f25100a;

        /* renamed from: b */
        private Protocol f25101b;

        /* renamed from: c */
        private int f25102c;

        /* renamed from: d */
        private String f25103d;

        /* renamed from: e */
        private v f25104e;

        /* renamed from: f */
        private x.a f25105f;

        /* renamed from: g */
        private I f25106g;

        /* renamed from: h */
        private H f25107h;
        private H i;
        private H j;

        /* synthetic */ a(H h2, G g2) {
            this(h2);
        }

        public a() {
            this.f25102c = -1;
            this.f25105f = new x.a();
        }

        private void d(H h2) {
            if (h2.f25098g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public a a(E e2) {
            this.f25100a = e2;
            return this;
        }

        public a b(String str, String str2) {
            this.f25105f.c(str, str2);
            return this;
        }

        public a c(H h2) {
            if (h2 != null) {
                d(h2);
            }
            this.j = h2;
            return this;
        }

        public a a(Protocol protocol) {
            this.f25101b = protocol;
            return this;
        }

        public a b(H h2) {
            if (h2 != null) {
                a("networkResponse", h2);
            }
            this.f25107h = h2;
            return this;
        }

        public a a(int i) {
            this.f25102c = i;
            return this;
        }

        private a(H h2) {
            this.f25102c = -1;
            this.f25100a = h2.f25092a;
            this.f25101b = h2.f25093b;
            this.f25102c = h2.f25094c;
            this.f25103d = h2.f25095d;
            this.f25104e = h2.f25096e;
            this.f25105f = h2.f25097f.a();
            this.f25106g = h2.f25098g;
            this.f25107h = h2.f25099h;
            this.i = h2.i;
            this.j = h2.j;
        }

        public a a(String str) {
            this.f25103d = str;
            return this;
        }

        public a a(v vVar) {
            this.f25104e = vVar;
            return this;
        }

        public a a(String str, String str2) {
            this.f25105f.a(str, str2);
            return this;
        }

        public a a(x xVar) {
            this.f25105f = xVar.a();
            return this;
        }

        public a a(I i) {
            this.f25106g = i;
            return this;
        }

        public a a(H h2) {
            if (h2 != null) {
                a("cacheResponse", h2);
            }
            this.i = h2;
            return this;
        }

        private void a(String str, H h2) {
            if (h2.f25098g == null) {
                if (h2.f25099h == null) {
                    if (h2.i == null) {
                        if (h2.j == null) {
                            return;
                        }
                        throw new IllegalArgumentException(str + ".priorResponse != null");
                    }
                    throw new IllegalArgumentException(str + ".cacheResponse != null");
                }
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            throw new IllegalArgumentException(str + ".body != null");
        }

        public H a() {
            if (this.f25100a != null) {
                if (this.f25101b != null) {
                    if (this.f25102c >= 0) {
                        return new H(this);
                    }
                    throw new IllegalStateException("code < 0: " + this.f25102c);
                }
                throw new IllegalStateException("protocol == null");
            }
            throw new IllegalStateException("request == null");
        }
    }

    /* synthetic */ H(a aVar, G g2) {
        this(aVar);
    }

    public Protocol k() {
        return this.f25093b;
    }

    public E l() {
        return this.f25092a;
    }

    public String toString() {
        return "Response{protocol=" + this.f25093b + ", code=" + this.f25094c + ", message=" + this.f25095d + ", url=" + this.f25092a.i() + '}';
    }

    private H(a aVar) {
        this.f25092a = aVar.f25100a;
        this.f25093b = aVar.f25101b;
        this.f25094c = aVar.f25102c;
        this.f25095d = aVar.f25103d;
        this.f25096e = aVar.f25104e;
        this.f25097f = aVar.f25105f.a();
        this.f25098g = aVar.f25106g;
        this.f25099h = aVar.f25107h;
        this.i = aVar.i;
        this.j = aVar.j;
    }

    public String a(String str) {
        return a(str, null);
    }

    public C2382h b() {
        C2382h c2382h = this.k;
        if (c2382h != null) {
            return c2382h;
        }
        C2382h a2 = C2382h.a(this.f25097f);
        this.k = a2;
        return a2;
    }

    public H c() {
        return this.i;
    }

    public List<l> d() {
        String str;
        int i = this.f25094c;
        if (i == 401) {
            str = "WWW-Authenticate";
        } else {
            if (i != 407) {
                return Collections.emptyList();
            }
            str = "Proxy-Authenticate";
        }
        return com.squareup.okhttp.internal.http.q.a(g(), str);
    }

    public int e() {
        return this.f25094c;
    }

    public v f() {
        return this.f25096e;
    }

    public x g() {
        return this.f25097f;
    }

    public String h() {
        return this.f25095d;
    }

    public H i() {
        return this.f25099h;
    }

    public a j() {
        return new a();
    }

    public String a(String str, String str2) {
        String a2 = this.f25097f.a(str);
        return a2 != null ? a2 : str2;
    }

    public I a() {
        return this.f25098g;
    }
}
