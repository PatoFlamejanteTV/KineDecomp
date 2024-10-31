package com.squareup.okhttp.internal.http;

import com.facebook.stetho.server.http.HttpHeaders;
import com.qq.e.comm.constants.ErrorCode;
import com.squareup.okhttp.C;
import com.squareup.okhttp.C2375a;
import com.squareup.okhttp.E;
import com.squareup.okhttp.F;
import com.squareup.okhttp.H;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.I;
import com.squareup.okhttp.J;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.http.d;
import com.squareup.okhttp.x;
import com.squareup.okhttp.z;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.Date;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okio.y;

/* compiled from: HttpEngine.java */
/* loaded from: classes3.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    private static final I f25464a = new k();

    /* renamed from: b, reason: collision with root package name */
    final C f25465b;

    /* renamed from: c, reason: collision with root package name */
    public final w f25466c;

    /* renamed from: d, reason: collision with root package name */
    private final H f25467d;

    /* renamed from: e, reason: collision with root package name */
    private o f25468e;

    /* renamed from: f, reason: collision with root package name */
    long f25469f = -1;

    /* renamed from: g, reason: collision with root package name */
    private boolean f25470g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f25471h;
    private final E i;
    private E j;
    private H k;
    private H l;
    private y m;
    private okio.h n;
    private final boolean o;
    private final boolean p;
    private b q;
    private d r;

    /* compiled from: HttpEngine.java */
    /* loaded from: classes3.dex */
    class a implements z.a {

        /* renamed from: a, reason: collision with root package name */
        private final int f25472a;

        /* renamed from: b, reason: collision with root package name */
        private final E f25473b;

        /* renamed from: c, reason: collision with root package name */
        private int f25474c;

        a(int i, E e2) {
            this.f25472a = i;
            this.f25473b = e2;
        }

        @Override // com.squareup.okhttp.z.a
        public E a() {
            return this.f25473b;
        }

        public com.squareup.okhttp.m b() {
            return m.this.f25466c.a();
        }

        @Override // com.squareup.okhttp.z.a
        public H a(E e2) throws IOException {
            this.f25474c++;
            if (this.f25472a > 0) {
                z zVar = m.this.f25465b.w().get(this.f25472a - 1);
                C2375a a2 = b().getRoute().a();
                if (e2.d().g().equals(a2.k()) && e2.d().j() == a2.l()) {
                    if (this.f25474c > 1) {
                        throw new IllegalStateException("network interceptor " + zVar + " must call proceed() exactly once");
                    }
                } else {
                    throw new IllegalStateException("network interceptor " + zVar + " must retain the same host and port");
                }
            }
            if (this.f25472a >= m.this.f25465b.w().size()) {
                m.this.f25468e.a(e2);
                m.this.j = e2;
                if (m.this.a(e2) && e2.a() != null) {
                    okio.h a3 = okio.s.a(m.this.f25468e.a(e2, e2.a().a()));
                    e2.a().a(a3);
                    a3.close();
                }
                H k = m.this.k();
                int e3 = k.e();
                if ((e3 != 204 && e3 != 205) || k.a().b() <= 0) {
                    return k;
                }
                throw new ProtocolException("HTTP " + e3 + " had non-zero Content-Length: " + k.a().b());
            }
            a aVar = new a(this.f25472a + 1, e2);
            z zVar2 = m.this.f25465b.w().get(this.f25472a);
            H a4 = zVar2.a(aVar);
            if (aVar.f25474c != 1) {
                throw new IllegalStateException("network interceptor " + zVar2 + " must call proceed() exactly once");
            }
            if (a4 != null) {
                return a4;
            }
            throw new NullPointerException("network interceptor " + zVar2 + " returned null");
        }
    }

    public m(C c2, E e2, boolean z, boolean z2, boolean z3, w wVar, t tVar, H h2) {
        this.f25465b = c2;
        this.i = e2;
        this.f25471h = z;
        this.o = z2;
        this.p = z3;
        this.f25466c = wVar == null ? new w(c2.e(), a(c2, e2)) : wVar;
        this.m = tVar;
        this.f25467d = h2;
    }

    private o i() throws RouteException, RequestException, IOException {
        return this.f25466c.a(this.f25465b.d(), this.f25465b.p(), this.f25465b.t(), this.f25465b.q(), !this.j.f().equals("GET"));
    }

    private void j() throws IOException {
        com.squareup.okhttp.a.i a2 = com.squareup.okhttp.a.h.f25192b.a(this.f25465b);
        if (a2 == null) {
            return;
        }
        if (!d.a(this.l, this.j)) {
            if (n.a(this.j.f())) {
                try {
                    a2.b(this.j);
                    return;
                } catch (IOException unused) {
                    return;
                }
            }
            return;
        }
        this.q = a2.a(b(this.l));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public H k() throws IOException {
        this.f25468e.a();
        H.a b2 = this.f25468e.b();
        b2.a(this.j);
        b2.a(this.f25466c.a().b());
        b2.b(q.f25478c, Long.toString(this.f25469f));
        b2.b(q.f25479d, Long.toString(System.currentTimeMillis()));
        H a2 = b2.a();
        if (!this.p) {
            H.a j = a2.j();
            j.a(this.f25468e.a(a2));
            a2 = j.a();
        }
        if ("close".equalsIgnoreCase(a2.l().a("Connection")) || "close".equalsIgnoreCase(a2.a("Connection"))) {
            this.f25466c.c();
        }
        return a2;
    }

    public com.squareup.okhttp.m c() {
        return this.f25466c.a();
    }

    public H d() {
        H h2 = this.l;
        if (h2 != null) {
            return h2;
        }
        throw new IllegalStateException();
    }

    public void e() throws IOException {
        H k;
        if (this.l != null) {
            return;
        }
        if (this.j == null && this.k == null) {
            throw new IllegalStateException("call sendRequest() first!");
        }
        E e2 = this.j;
        if (e2 == null) {
            return;
        }
        if (this.p) {
            this.f25468e.a(e2);
            k = k();
        } else if (!this.o) {
            k = new a(0, e2).a(this.j);
        } else {
            okio.h hVar = this.n;
            if (hVar != null && hVar.d().size() > 0) {
                this.n.f();
            }
            if (this.f25469f == -1) {
                if (q.a(this.j) == -1) {
                    y yVar = this.m;
                    if (yVar instanceof t) {
                        long a2 = ((t) yVar).a();
                        E.a g2 = this.j.g();
                        g2.b(HttpHeaders.CONTENT_LENGTH, Long.toString(a2));
                        this.j = g2.a();
                    }
                }
                this.f25468e.a(this.j);
            }
            y yVar2 = this.m;
            if (yVar2 != null) {
                okio.h hVar2 = this.n;
                if (hVar2 != null) {
                    hVar2.close();
                } else {
                    yVar2.close();
                }
                y yVar3 = this.m;
                if (yVar3 instanceof t) {
                    this.f25468e.a((t) yVar3);
                }
            }
            k = k();
        }
        a(k.g());
        H h2 = this.k;
        if (h2 != null) {
            if (a(h2, k)) {
                H.a j = this.k.j();
                j.a(this.i);
                j.c(b(this.f25467d));
                j.a(a(this.k.g(), k.g()));
                j.a(b(this.k));
                j.b(b(k));
                this.l = j.a();
                k.a().close();
                f();
                com.squareup.okhttp.a.i a3 = com.squareup.okhttp.a.h.f25192b.a(this.f25465b);
                a3.a();
                a3.a(this.k, b(this.l));
                this.l = c(this.l);
                return;
            }
            com.squareup.okhttp.a.o.a(this.k.a());
        }
        H.a j2 = k.j();
        j2.a(this.i);
        j2.c(b(this.f25467d));
        j2.a(b(this.k));
        j2.b(b(k));
        this.l = j2.a();
        if (a(this.l)) {
            j();
            this.l = c(a(this.q, this.l));
        }
    }

    public void f() throws IOException {
        this.f25466c.d();
    }

    public void g() throws RequestException, RouteException, IOException {
        if (this.r != null) {
            return;
        }
        if (this.f25468e == null) {
            E b2 = b(this.i);
            com.squareup.okhttp.a.i a2 = com.squareup.okhttp.a.h.f25192b.a(this.f25465b);
            H a3 = a2 != null ? a2.a(b2) : null;
            this.r = new d.a(System.currentTimeMillis(), b2, a3).a();
            d dVar = this.r;
            this.j = dVar.f25413a;
            this.k = dVar.f25414b;
            if (a2 != null) {
                a2.a(dVar);
            }
            if (a3 != null && this.k == null) {
                com.squareup.okhttp.a.o.a(a3.a());
            }
            if (this.j != null) {
                this.f25468e = i();
                this.f25468e.a(this);
                if (this.o && a(this.j) && this.m == null) {
                    long a4 = q.a(b2);
                    if (!this.f25471h) {
                        this.f25468e.a(this.j);
                        this.m = this.f25468e.a(this.j, a4);
                        return;
                    } else {
                        if (a4 > 2147483647L) {
                            throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
                        }
                        if (a4 != -1) {
                            this.f25468e.a(this.j);
                            this.m = new t((int) a4);
                            return;
                        } else {
                            this.m = new t();
                            return;
                        }
                    }
                }
                return;
            }
            H h2 = this.k;
            if (h2 != null) {
                H.a j = h2.j();
                j.a(this.i);
                j.c(b(this.f25467d));
                j.a(b(this.k));
                this.l = j.a();
            } else {
                H.a aVar = new H.a();
                aVar.a(this.i);
                aVar.c(b(this.f25467d));
                aVar.a(Protocol.HTTP_1_1);
                aVar.a(504);
                aVar.a("Unsatisfiable Request (only-if-cached)");
                aVar.a(f25464a);
                this.l = aVar.a();
            }
            this.l = c(this.l);
            return;
        }
        throw new IllegalStateException();
    }

    public void h() {
        if (this.f25469f == -1) {
            this.f25469f = System.currentTimeMillis();
            return;
        }
        throw new IllegalStateException();
    }

    private static H b(H h2) {
        if (h2 == null || h2.a() == null) {
            return h2;
        }
        H.a j = h2.j();
        j.a((I) null);
        return j.a();
    }

    private H c(H h2) throws IOException {
        if (!this.f25470g || !"gzip".equalsIgnoreCase(this.l.a("Content-Encoding")) || h2.a() == null) {
            return h2;
        }
        okio.n nVar = new okio.n(h2.a().c());
        x.a a2 = h2.g().a();
        a2.b("Content-Encoding");
        a2.b(HttpHeaders.CONTENT_LENGTH);
        x a3 = a2.a();
        H.a j = h2.j();
        j.a(a3);
        j.a(new r(a3, okio.s.a(nVar)));
        return j.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(E e2) {
        return n.b(e2.f());
    }

    private E b(E e2) throws IOException {
        E.a g2 = e2.g();
        if (e2.a("Host") == null) {
            g2.b("Host", com.squareup.okhttp.a.o.a(e2.d()));
        }
        if (e2.a("Connection") == null) {
            g2.b("Connection", "Keep-Alive");
        }
        if (e2.a("Accept-Encoding") == null) {
            this.f25470g = true;
            g2.b("Accept-Encoding", "gzip");
        }
        CookieHandler g3 = this.f25465b.g();
        if (g3 != null) {
            q.a(g2, g3.get(e2.h(), q.b(g2.a().c(), null)));
        }
        if (e2.a(io.fabric.sdk.android.services.common.a.HEADER_USER_AGENT) == null) {
            g2.b(io.fabric.sdk.android.services.common.a.HEADER_USER_AGENT, com.squareup.okhttp.a.p.a());
        }
        return g2.a();
    }

    public m a(RouteException routeException) {
        if (!this.f25466c.a(routeException) || !this.f25465b.q()) {
            return null;
        }
        return new m(this.f25465b, this.i, this.f25471h, this.o, this.p, a(), (t) this.m, this.f25467d);
    }

    public m a(IOException iOException, y yVar) {
        if (!this.f25466c.a(iOException, yVar) || !this.f25465b.q()) {
            return null;
        }
        return new m(this.f25465b, this.i, this.f25471h, this.o, this.p, a(), (t) yVar, this.f25467d);
    }

    public w a() {
        okio.h hVar = this.n;
        if (hVar != null) {
            com.squareup.okhttp.a.o.a(hVar);
        } else {
            y yVar = this.m;
            if (yVar != null) {
                com.squareup.okhttp.a.o.a(yVar);
            }
        }
        H h2 = this.l;
        if (h2 != null) {
            com.squareup.okhttp.a.o.a(h2.a());
        } else {
            this.f25466c.b();
        }
        return this.f25466c;
    }

    public E b() throws IOException {
        Proxy n;
        String a2;
        HttpUrl d2;
        if (this.l != null) {
            com.squareup.okhttp.a.a.c a3 = this.f25466c.a();
            J route = a3 != null ? a3.getRoute() : null;
            if (route != null) {
                n = route.b();
            } else {
                n = this.f25465b.n();
            }
            int e2 = this.l.e();
            String f2 = this.i.f();
            if (e2 != 307 && e2 != 308) {
                if (e2 != 401) {
                    if (e2 != 407) {
                        switch (e2) {
                            case 300:
                            case ErrorCode.InitError.INIT_ADMANGER_ERROR /* 301 */:
                            case ErrorCode.InitError.INIT_PLUGIN_ERROR /* 302 */:
                            case ErrorCode.InitError.GET_INTERFACE_ERROR /* 303 */:
                                break;
                            default:
                                return null;
                        }
                    } else if (n.type() != Proxy.Type.HTTP) {
                        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                    }
                }
                return q.a(this.f25465b.b(), this.l, n);
            }
            if (!f2.equals("GET") && !f2.equals("HEAD")) {
                return null;
            }
            if (!this.f25465b.j() || (a2 = this.l.a("Location")) == null || (d2 = this.i.d().d(a2)) == null) {
                return null;
            }
            if (!d2.l().equals(this.i.d().l()) && !this.f25465b.k()) {
                return null;
            }
            E.a g2 = this.i.g();
            if (n.b(f2)) {
                if (n.c(f2)) {
                    g2.a("GET", (F) null);
                } else {
                    g2.a(f2, (F) null);
                }
                g2.a("Transfer-Encoding");
                g2.a(HttpHeaders.CONTENT_LENGTH);
                g2.a(HttpHeaders.CONTENT_TYPE);
            }
            if (!a(d2)) {
                g2.a("Authorization");
            }
            g2.a(d2);
            return g2.a();
        }
        throw new IllegalStateException();
    }

    public static boolean a(H h2) {
        if (h2.l().f().equals("HEAD")) {
            return false;
        }
        int e2 = h2.e();
        return (((e2 >= 100 && e2 < 200) || e2 == 204 || e2 == 304) && q.a(h2) == -1 && !"chunked".equalsIgnoreCase(h2.a("Transfer-Encoding"))) ? false : true;
    }

    private H a(b bVar, H h2) throws IOException {
        y body;
        if (bVar == null || (body = bVar.body()) == null) {
            return h2;
        }
        l lVar = new l(this, h2.a().c(), bVar, okio.s.a(body));
        H.a j = h2.j();
        j.a(new r(h2.g(), okio.s.a(lVar)));
        return j.a();
    }

    private static boolean a(H h2, H h3) {
        Date b2;
        if (h3.e() == 304) {
            return true;
        }
        Date b3 = h2.g().b("Last-Modified");
        return (b3 == null || (b2 = h3.g().b("Last-Modified")) == null || b2.getTime() >= b3.getTime()) ? false : true;
    }

    private static x a(x xVar, x xVar2) throws IOException {
        x.a aVar = new x.a();
        int b2 = xVar.b();
        for (int i = 0; i < b2; i++) {
            String a2 = xVar.a(i);
            String b3 = xVar.b(i);
            if ((!"Warning".equalsIgnoreCase(a2) || !b3.startsWith("1")) && (!q.a(a2) || xVar2.a(a2) == null)) {
                aVar.a(a2, b3);
            }
        }
        int b4 = xVar2.b();
        for (int i2 = 0; i2 < b4; i2++) {
            String a3 = xVar2.a(i2);
            if (!HttpHeaders.CONTENT_LENGTH.equalsIgnoreCase(a3) && q.a(a3)) {
                aVar.a(a3, xVar2.b(i2));
            }
        }
        return aVar.a();
    }

    public void a(x xVar) throws IOException {
        CookieHandler g2 = this.f25465b.g();
        if (g2 != null) {
            g2.put(this.i.h(), q.b(xVar, null));
        }
    }

    public boolean a(HttpUrl httpUrl) {
        HttpUrl d2 = this.i.d();
        return d2.g().equals(httpUrl.g()) && d2.j() == httpUrl.j() && d2.l().equals(httpUrl.l());
    }

    private static C2375a a(C c2, E e2) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        com.squareup.okhttp.k kVar;
        if (e2.e()) {
            SSLSocketFactory s = c2.s();
            hostnameVerifier = c2.l();
            sSLSocketFactory = s;
            kVar = c2.c();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            kVar = null;
        }
        return new C2375a(e2.d().g(), e2.d().j(), c2.i(), c2.r(), sSLSocketFactory, hostnameVerifier, kVar, c2.b(), c2.n(), c2.m(), c2.f(), c2.o());
    }
}
