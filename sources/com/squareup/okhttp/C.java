package com.squareup.okhttp;

import java.net.CookieHandler;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: OkHttpClient.java */
/* loaded from: classes3.dex */
public class C implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private static final List<Protocol> f25072a = com.squareup.okhttp.a.o.a(Protocol.HTTP_2, Protocol.SPDY_3, Protocol.HTTP_1_1);

    /* renamed from: b, reason: collision with root package name */
    private static final List<q> f25073b = com.squareup.okhttp.a.o.a(q.f25519b, q.f25520c, q.f25521d);

    /* renamed from: c, reason: collision with root package name */
    private static SSLSocketFactory f25074c;
    private int A;

    /* renamed from: d, reason: collision with root package name */
    private final com.squareup.okhttp.a.m f25075d;

    /* renamed from: e, reason: collision with root package name */
    private s f25076e;

    /* renamed from: f, reason: collision with root package name */
    private Proxy f25077f;

    /* renamed from: g, reason: collision with root package name */
    private List<Protocol> f25078g;

    /* renamed from: h, reason: collision with root package name */
    private List<q> f25079h;
    private final List<z> i;
    private final List<z> j;
    private ProxySelector k;
    private CookieHandler l;
    private com.squareup.okhttp.a.i m;
    private C2379e n;
    private SocketFactory o;
    private SSLSocketFactory p;
    private HostnameVerifier q;
    private k r;
    private InterfaceC2376b s;
    private o t;
    private u u;
    private boolean v;
    private boolean w;
    private boolean x;
    private int y;
    private int z;

    static {
        com.squareup.okhttp.a.h.f25192b = new B();
    }

    public C() {
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.v = true;
        this.w = true;
        this.x = true;
        this.y = io.fabric.sdk.android.services.common.a.DEFAULT_TIMEOUT;
        this.z = io.fabric.sdk.android.services.common.a.DEFAULT_TIMEOUT;
        this.A = io.fabric.sdk.android.services.common.a.DEFAULT_TIMEOUT;
        this.f25075d = new com.squareup.okhttp.a.m();
        this.f25076e = new s();
    }

    private synchronized SSLSocketFactory x() {
        if (f25074c == null) {
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, null, null);
                f25074c = sSLContext.getSocketFactory();
            } catch (GeneralSecurityException unused) {
                throw new AssertionError();
            }
        }
        return f25074c;
    }

    public void a(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0");
        }
        if (timeUnit != null) {
            long millis = timeUnit.toMillis(j);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException("Timeout too large.");
            }
            if (millis == 0 && j > 0) {
                throw new IllegalArgumentException("Timeout too small.");
            }
            this.y = (int) millis;
            return;
        }
        throw new IllegalArgumentException("unit == null");
    }

    public void b(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0");
        }
        if (timeUnit != null) {
            long millis = timeUnit.toMillis(j);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException("Timeout too large.");
            }
            if (millis == 0 && j > 0) {
                throw new IllegalArgumentException("Timeout too small.");
            }
            this.z = (int) millis;
            return;
        }
        throw new IllegalArgumentException("unit == null");
    }

    public void c(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0");
        }
        if (timeUnit != null) {
            long millis = timeUnit.toMillis(j);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException("Timeout too large.");
            }
            if (millis == 0 && j > 0) {
                throw new IllegalArgumentException("Timeout too small.");
            }
            this.A = (int) millis;
            return;
        }
        throw new IllegalArgumentException("unit == null");
    }

    public int d() {
        return this.y;
    }

    public o e() {
        return this.t;
    }

    public List<q> f() {
        return this.f25079h;
    }

    public CookieHandler g() {
        return this.l;
    }

    public s h() {
        return this.f25076e;
    }

    public u i() {
        return this.u;
    }

    public boolean j() {
        return this.w;
    }

    public boolean k() {
        return this.v;
    }

    public HostnameVerifier l() {
        return this.q;
    }

    public List<Protocol> m() {
        return this.f25078g;
    }

    public Proxy n() {
        return this.f25077f;
    }

    public ProxySelector o() {
        return this.k;
    }

    public int p() {
        return this.z;
    }

    public boolean q() {
        return this.x;
    }

    public SocketFactory r() {
        return this.o;
    }

    public SSLSocketFactory s() {
        return this.p;
    }

    public int t() {
        return this.A;
    }

    public List<z> u() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.squareup.okhttp.a.i v() {
        return this.m;
    }

    public List<z> w() {
        return this.j;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public C m21clone() {
        return new C(this);
    }

    public C a(C2379e c2379e) {
        this.n = c2379e;
        this.m = null;
        return this;
    }

    public InterfaceC2376b b() {
        return this.s;
    }

    public k c() {
        return this.r;
    }

    public C2383i a(E e2) {
        return new C2383i(this, e2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C a() {
        C c2 = new C(this);
        if (c2.k == null) {
            c2.k = ProxySelector.getDefault();
        }
        if (c2.l == null) {
            c2.l = CookieHandler.getDefault();
        }
        if (c2.o == null) {
            c2.o = SocketFactory.getDefault();
        }
        if (c2.p == null) {
            c2.p = x();
        }
        if (c2.q == null) {
            c2.q = com.squareup.okhttp.a.b.d.f25159a;
        }
        if (c2.r == null) {
            c2.r = k.f25505a;
        }
        if (c2.s == null) {
            c2.s = com.squareup.okhttp.internal.http.a.f25412a;
        }
        if (c2.t == null) {
            c2.t = o.a();
        }
        if (c2.f25078g == null) {
            c2.f25078g = f25072a;
        }
        if (c2.f25079h == null) {
            c2.f25079h = f25073b;
        }
        if (c2.u == null) {
            c2.u = u.f25535a;
        }
        return c2;
    }

    private C(C c2) {
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.v = true;
        this.w = true;
        this.x = true;
        this.y = io.fabric.sdk.android.services.common.a.DEFAULT_TIMEOUT;
        this.z = io.fabric.sdk.android.services.common.a.DEFAULT_TIMEOUT;
        this.A = io.fabric.sdk.android.services.common.a.DEFAULT_TIMEOUT;
        this.f25075d = c2.f25075d;
        this.f25076e = c2.f25076e;
        this.f25077f = c2.f25077f;
        this.f25078g = c2.f25078g;
        this.f25079h = c2.f25079h;
        this.i.addAll(c2.i);
        this.j.addAll(c2.j);
        this.k = c2.k;
        this.l = c2.l;
        this.n = c2.n;
        C2379e c2379e = this.n;
        this.m = c2379e != null ? c2379e.f25224a : c2.m;
        this.o = c2.o;
        this.p = c2.p;
        this.q = c2.q;
        this.r = c2.r;
        this.s = c2.s;
        this.t = c2.t;
        this.u = c2.u;
        this.v = c2.v;
        this.w = c2.w;
        this.x = c2.x;
        this.y = c2.y;
        this.z = c2.z;
        this.A = c2.A;
    }
}
