package okhttp3.internal.connection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.A;
import okhttp3.C2557a;
import okhttp3.InterfaceC2562f;
import okhttp3.P;
import okhttp3.w;

/* compiled from: RouteSelector.java */
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final C2557a f29004a;

    /* renamed from: b, reason: collision with root package name */
    private final d f29005b;

    /* renamed from: c, reason: collision with root package name */
    private final InterfaceC2562f f29006c;

    /* renamed from: d, reason: collision with root package name */
    private final w f29007d;

    /* renamed from: f, reason: collision with root package name */
    private int f29009f;

    /* renamed from: e, reason: collision with root package name */
    private List<Proxy> f29008e = Collections.emptyList();

    /* renamed from: g, reason: collision with root package name */
    private List<InetSocketAddress> f29010g = Collections.emptyList();

    /* renamed from: h, reason: collision with root package name */
    private final List<P> f29011h = new ArrayList();

    /* compiled from: RouteSelector.java */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final List<P> f29012a;

        /* renamed from: b, reason: collision with root package name */
        private int f29013b = 0;

        a(List<P> list) {
            this.f29012a = list;
        }

        public List<P> a() {
            return new ArrayList(this.f29012a);
        }

        public boolean b() {
            return this.f29013b < this.f29012a.size();
        }

        public P c() {
            if (b()) {
                List<P> list = this.f29012a;
                int i = this.f29013b;
                this.f29013b = i + 1;
                return list.get(i);
            }
            throw new NoSuchElementException();
        }
    }

    public e(C2557a c2557a, d dVar, InterfaceC2562f interfaceC2562f, w wVar) {
        this.f29004a = c2557a;
        this.f29005b = dVar;
        this.f29006c = interfaceC2562f;
        this.f29007d = wVar;
        a(c2557a.k(), c2557a.f());
    }

    private boolean c() {
        return this.f29009f < this.f29008e.size();
    }

    private Proxy d() throws IOException {
        if (c()) {
            List<Proxy> list = this.f29008e;
            int i = this.f29009f;
            this.f29009f = i + 1;
            Proxy proxy = list.get(i);
            a(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f29004a.k().g() + "; exhausted proxy configurations: " + this.f29008e);
    }

    public boolean a() {
        return c() || !this.f29011h.isEmpty();
    }

    public a b() throws IOException {
        if (a()) {
            ArrayList arrayList = new ArrayList();
            while (c()) {
                Proxy d2 = d();
                int size = this.f29010g.size();
                for (int i = 0; i < size; i++) {
                    P p = new P(this.f29004a, d2, this.f29010g.get(i));
                    if (this.f29005b.c(p)) {
                        this.f29011h.add(p);
                    } else {
                        arrayList.add(p);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(this.f29011h);
                this.f29011h.clear();
            }
            return new a(arrayList);
        }
        throw new NoSuchElementException();
    }

    public void a(P p, IOException iOException) {
        if (p.b().type() != Proxy.Type.DIRECT && this.f29004a.h() != null) {
            this.f29004a.h().connectFailed(this.f29004a.k().o(), p.b().address(), iOException);
        }
        this.f29005b.b(p);
    }

    private void a(A a2, Proxy proxy) {
        List<Proxy> a3;
        if (proxy != null) {
            this.f29008e = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.f29004a.h().select(a2.o());
            if (select != null && !select.isEmpty()) {
                a3 = okhttp3.a.e.a(select);
            } else {
                a3 = okhttp3.a.e.a(Proxy.NO_PROXY);
            }
            this.f29008e = a3;
        }
        this.f29009f = 0;
    }

    private void a(Proxy proxy) throws IOException {
        String g2;
        int k;
        this.f29010g = new ArrayList();
        if (proxy.type() != Proxy.Type.DIRECT && proxy.type() != Proxy.Type.SOCKS) {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                g2 = a(inetSocketAddress);
                k = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        } else {
            g2 = this.f29004a.k().g();
            k = this.f29004a.k().k();
        }
        if (k >= 1 && k <= 65535) {
            if (proxy.type() == Proxy.Type.SOCKS) {
                this.f29010g.add(InetSocketAddress.createUnresolved(g2, k));
                return;
            }
            this.f29007d.a(this.f29006c, g2);
            List<InetAddress> lookup = this.f29004a.c().lookup(g2);
            if (!lookup.isEmpty()) {
                this.f29007d.a(this.f29006c, g2, lookup);
                int size = lookup.size();
                for (int i = 0; i < size; i++) {
                    this.f29010g.add(new InetSocketAddress(lookup.get(i), k));
                }
                return;
            }
            throw new UnknownHostException(this.f29004a.c() + " returned no addresses for " + g2);
        }
        throw new SocketException("No route to " + g2 + ":" + k + "; port is out of range");
    }

    static String a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }
}
