package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.C2375a;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.J;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: RouteSelector.java */
/* loaded from: classes3.dex */
public final class u {

    /* renamed from: a */
    private final C2375a f25487a;

    /* renamed from: b */
    private final com.squareup.okhttp.a.m f25488b;

    /* renamed from: c */
    private Proxy f25489c;

    /* renamed from: d */
    private InetSocketAddress f25490d;

    /* renamed from: f */
    private int f25492f;

    /* renamed from: h */
    private int f25494h;

    /* renamed from: e */
    private List<Proxy> f25491e = Collections.emptyList();

    /* renamed from: g */
    private List<InetSocketAddress> f25493g = Collections.emptyList();
    private final List<J> i = new ArrayList();

    public u(C2375a c2375a, com.squareup.okhttp.a.m mVar) {
        this.f25487a = c2375a;
        this.f25488b = mVar;
        a(c2375a.m(), c2375a.g());
    }

    private boolean c() {
        return this.f25494h < this.f25493g.size();
    }

    private boolean d() {
        return !this.i.isEmpty();
    }

    private boolean e() {
        return this.f25492f < this.f25491e.size();
    }

    private InetSocketAddress f() throws IOException {
        if (c()) {
            List<InetSocketAddress> list = this.f25493g;
            int i = this.f25494h;
            this.f25494h = i + 1;
            return list.get(i);
        }
        throw new SocketException("No route to " + this.f25487a.k() + "; exhausted inet socket addresses: " + this.f25493g);
    }

    private J g() {
        return this.i.remove(0);
    }

    private Proxy h() throws IOException {
        if (e()) {
            List<Proxy> list = this.f25491e;
            int i = this.f25492f;
            this.f25492f = i + 1;
            Proxy proxy = list.get(i);
            a(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f25487a.k() + "; exhausted proxy configurations: " + this.f25491e);
    }

    public boolean a() {
        return c() || e() || d();
    }

    public J b() throws IOException {
        if (!c()) {
            if (!e()) {
                if (d()) {
                    return g();
                }
                throw new NoSuchElementException();
            }
            this.f25489c = h();
        }
        this.f25490d = f();
        J j = new J(this.f25487a, this.f25489c, this.f25490d);
        if (!this.f25488b.c(j)) {
            return j;
        }
        this.i.add(j);
        return b();
    }

    public void a(J j, IOException iOException) {
        if (j.b().type() != Proxy.Type.DIRECT && this.f25487a.h() != null) {
            this.f25487a.h().connectFailed(this.f25487a.m().m(), j.b().address(), iOException);
        }
        this.f25488b.b(j);
    }

    private void a(HttpUrl httpUrl, Proxy proxy) {
        if (proxy != null) {
            this.f25491e = Collections.singletonList(proxy);
        } else {
            this.f25491e = new ArrayList();
            List<Proxy> select = this.f25487a.h().select(httpUrl.m());
            if (select != null) {
                this.f25491e.addAll(select);
            }
            this.f25491e.removeAll(Collections.singleton(Proxy.NO_PROXY));
            this.f25491e.add(Proxy.NO_PROXY);
        }
        this.f25492f = 0;
    }

    private void a(Proxy proxy) throws IOException {
        String k;
        int l;
        this.f25493g = new ArrayList();
        if (proxy.type() != Proxy.Type.DIRECT && proxy.type() != Proxy.Type.SOCKS) {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                k = a(inetSocketAddress);
                l = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        } else {
            k = this.f25487a.k();
            l = this.f25487a.l();
        }
        if (l >= 1 && l <= 65535) {
            if (proxy.type() == Proxy.Type.SOCKS) {
                this.f25493g.add(InetSocketAddress.createUnresolved(k, l));
            } else {
                List<InetAddress> lookup = this.f25487a.d().lookup(k);
                int size = lookup.size();
                for (int i = 0; i < size; i++) {
                    this.f25493g.add(new InetSocketAddress(lookup.get(i), l));
                }
            }
            this.f25494h = 0;
            return;
        }
        throw new SocketException("No route to " + k + ":" + l + "; port is out of range");
    }

    static String a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }
}
