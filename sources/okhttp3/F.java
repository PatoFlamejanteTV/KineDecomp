package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.InterfaceC2562f;
import okhttp3.w;

/* compiled from: OkHttpClient.java */
/* loaded from: classes3.dex */
public class F implements Cloneable, InterfaceC2562f.a, Q {

    /* renamed from: a, reason: collision with root package name */
    static final List<Protocol> f28777a = okhttp3.a.e.a(Protocol.HTTP_2, Protocol.HTTP_1_1);

    /* renamed from: b, reason: collision with root package name */
    static final List<C2570n> f28778b = okhttp3.a.e.a(C2570n.f29185d, C2570n.f29187f);
    final int A;
    final int B;
    final int C;
    final int D;

    /* renamed from: c, reason: collision with root package name */
    final r f28779c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    final Proxy f28780d;

    /* renamed from: e, reason: collision with root package name */
    final List<Protocol> f28781e;

    /* renamed from: f, reason: collision with root package name */
    final List<C2570n> f28782f;

    /* renamed from: g, reason: collision with root package name */
    final List<B> f28783g;

    /* renamed from: h, reason: collision with root package name */
    final List<B> f28784h;
    final w.a i;
    final ProxySelector j;
    final InterfaceC2573q k;

    @Nullable
    final C2560d l;

    @Nullable
    final okhttp3.a.a.e m;
    final SocketFactory n;
    final SSLSocketFactory o;
    final okhttp3.a.f.c p;
    final HostnameVerifier q;
    final C2564h r;
    final InterfaceC2559c s;
    final InterfaceC2559c t;
    final C2569m u;
    final t v;
    final boolean w;
    final boolean x;
    final boolean y;
    final int z;

    /* compiled from: OkHttpClient.java */
    /* loaded from: classes3.dex */
    public static final class a {
        int A;
        int B;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        Proxy f28786b;

        /* renamed from: h, reason: collision with root package name */
        ProxySelector f28792h;
        InterfaceC2573q i;

        @Nullable
        C2560d j;

        @Nullable
        okhttp3.a.a.e k;
        SocketFactory l;

        @Nullable
        SSLSocketFactory m;

        @Nullable
        okhttp3.a.f.c n;
        HostnameVerifier o;
        C2564h p;
        InterfaceC2559c q;
        InterfaceC2559c r;
        C2569m s;
        t t;
        boolean u;
        boolean v;
        boolean w;
        int x;
        int y;
        int z;

        /* renamed from: e, reason: collision with root package name */
        final List<B> f28789e = new ArrayList();

        /* renamed from: f, reason: collision with root package name */
        final List<B> f28790f = new ArrayList();

        /* renamed from: a, reason: collision with root package name */
        r f28785a = new r();

        /* renamed from: c, reason: collision with root package name */
        List<Protocol> f28787c = F.f28777a;

        /* renamed from: d, reason: collision with root package name */
        List<C2570n> f28788d = F.f28778b;

        /* renamed from: g, reason: collision with root package name */
        w.a f28791g = w.a(w.f29212a);

        public a() {
            this.f28792h = ProxySelector.getDefault();
            if (this.f28792h == null) {
                this.f28792h = new okhttp3.a.e.a();
            }
            this.i = InterfaceC2573q.f29202a;
            this.l = SocketFactory.getDefault();
            this.o = okhttp3.a.f.d.f28964a;
            this.p = C2564h.f28983a;
            InterfaceC2559c interfaceC2559c = InterfaceC2559c.f28965a;
            this.q = interfaceC2559c;
            this.r = interfaceC2559c;
            this.s = new C2569m();
            this.t = t.f29210a;
            this.u = true;
            this.v = true;
            this.w = true;
            this.x = 0;
            this.y = io.fabric.sdk.android.services.common.a.DEFAULT_TIMEOUT;
            this.z = io.fabric.sdk.android.services.common.a.DEFAULT_TIMEOUT;
            this.A = io.fabric.sdk.android.services.common.a.DEFAULT_TIMEOUT;
            this.B = 0;
        }

        public a a(long j, TimeUnit timeUnit) {
            this.y = okhttp3.a.e.a("timeout", j, timeUnit);
            return this;
        }

        public a b(long j, TimeUnit timeUnit) {
            this.z = okhttp3.a.e.a("timeout", j, timeUnit);
            return this;
        }

        public a a(B b2) {
            if (b2 != null) {
                this.f28789e.add(b2);
                return this;
            }
            throw new IllegalArgumentException("interceptor == null");
        }

        public F a() {
            return new F(this);
        }
    }

    static {
        okhttp3.a.a.f28854a = new E();
    }

    public F() {
        this(new a());
    }

    private static SSLSocketFactory a(X509TrustManager x509TrustManager) {
        try {
            SSLContext b2 = okhttp3.a.d.f.a().b();
            b2.init(null, new TrustManager[]{x509TrustManager}, null);
            return b2.getSocketFactory();
        } catch (GeneralSecurityException e2) {
            throw okhttp3.a.e.a("No System TLS", (Exception) e2);
        }
    }

    public int b() {
        return this.z;
    }

    public C2564h c() {
        return this.r;
    }

    public int d() {
        return this.A;
    }

    public C2569m e() {
        return this.u;
    }

    public List<C2570n> f() {
        return this.f28782f;
    }

    public InterfaceC2573q g() {
        return this.k;
    }

    public r h() {
        return this.f28779c;
    }

    public t i() {
        return this.v;
    }

    public w.a j() {
        return this.i;
    }

    public boolean k() {
        return this.x;
    }

    public boolean l() {
        return this.w;
    }

    public HostnameVerifier m() {
        return this.q;
    }

    public List<B> n() {
        return this.f28783g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public okhttp3.a.a.e o() {
        C2560d c2560d = this.l;
        return c2560d != null ? c2560d.f28966a : this.m;
    }

    public List<B> p() {
        return this.f28784h;
    }

    public int q() {
        return this.D;
    }

    public List<Protocol> r() {
        return this.f28781e;
    }

    @Nullable
    public Proxy s() {
        return this.f28780d;
    }

    public InterfaceC2559c t() {
        return this.s;
    }

    public ProxySelector u() {
        return this.j;
    }

    public int v() {
        return this.B;
    }

    public boolean w() {
        return this.y;
    }

    public SocketFactory x() {
        return this.n;
    }

    public SSLSocketFactory y() {
        return this.o;
    }

    public int z() {
        return this.C;
    }

    F(a aVar) {
        boolean z;
        this.f28779c = aVar.f28785a;
        this.f28780d = aVar.f28786b;
        this.f28781e = aVar.f28787c;
        this.f28782f = aVar.f28788d;
        this.f28783g = okhttp3.a.e.a(aVar.f28789e);
        this.f28784h = okhttp3.a.e.a(aVar.f28790f);
        this.i = aVar.f28791g;
        this.j = aVar.f28792h;
        this.k = aVar.i;
        this.l = aVar.j;
        this.m = aVar.k;
        this.n = aVar.l;
        Iterator<C2570n> it = this.f28782f.iterator();
        loop0: while (true) {
            while (it.hasNext()) {
                z = z || it.next().b();
            }
        }
        if (aVar.m == null && z) {
            X509TrustManager a2 = okhttp3.a.e.a();
            this.o = a(a2);
            this.p = okhttp3.a.f.c.a(a2);
        } else {
            this.o = aVar.m;
            this.p = aVar.n;
        }
        if (this.o != null) {
            okhttp3.a.d.f.a().a(this.o);
        }
        this.q = aVar.o;
        this.r = aVar.p.a(this.p);
        this.s = aVar.q;
        this.t = aVar.r;
        this.u = aVar.s;
        this.v = aVar.t;
        this.w = aVar.u;
        this.x = aVar.v;
        this.y = aVar.w;
        this.z = aVar.x;
        this.A = aVar.y;
        this.B = aVar.z;
        this.C = aVar.A;
        this.D = aVar.B;
        if (!this.f28783g.contains(null)) {
            if (this.f28784h.contains(null)) {
                throw new IllegalStateException("Null network interceptor: " + this.f28784h);
            }
            return;
        }
        throw new IllegalStateException("Null interceptor: " + this.f28783g);
    }

    public InterfaceC2559c a() {
        return this.t;
    }

    @Override // okhttp3.InterfaceC2562f.a
    public InterfaceC2562f a(I i) {
        return H.a(this, i, false);
    }
}
