package com.squareup.okhttp;

import com.squareup.okhttp.HttpUrl;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: Address.java */
/* renamed from: com.squareup.okhttp.a */
/* loaded from: classes3.dex */
public final class C2375a {

    /* renamed from: a */
    final HttpUrl f25127a;

    /* renamed from: b */
    final u f25128b;

    /* renamed from: c */
    final SocketFactory f25129c;

    /* renamed from: d */
    final InterfaceC2376b f25130d;

    /* renamed from: e */
    final List<Protocol> f25131e;

    /* renamed from: f */
    final List<q> f25132f;

    /* renamed from: g */
    final ProxySelector f25133g;

    /* renamed from: h */
    final Proxy f25134h;
    final SSLSocketFactory i;
    final HostnameVerifier j;
    final k k;

    public C2375a(String str, int i, u uVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, k kVar, InterfaceC2376b interfaceC2376b, Proxy proxy, List<Protocol> list, List<q> list2, ProxySelector proxySelector) {
        HttpUrl.Builder builder = new HttpUrl.Builder();
        builder.c(sSLSocketFactory != null ? "https" : "http");
        builder.b(str);
        builder.a(i);
        this.f25127a = builder.a();
        if (uVar != null) {
            this.f25128b = uVar;
            if (socketFactory != null) {
                this.f25129c = socketFactory;
                if (interfaceC2376b != null) {
                    this.f25130d = interfaceC2376b;
                    if (list != null) {
                        this.f25131e = com.squareup.okhttp.a.o.a(list);
                        if (list2 != null) {
                            this.f25132f = com.squareup.okhttp.a.o.a(list2);
                            if (proxySelector != null) {
                                this.f25133g = proxySelector;
                                this.f25134h = proxy;
                                this.i = sSLSocketFactory;
                                this.j = hostnameVerifier;
                                this.k = kVar;
                                return;
                            }
                            throw new IllegalArgumentException("proxySelector == null");
                        }
                        throw new IllegalArgumentException("connectionSpecs == null");
                    }
                    throw new IllegalArgumentException("protocols == null");
                }
                throw new IllegalArgumentException("authenticator == null");
            }
            throw new IllegalArgumentException("socketFactory == null");
        }
        throw new IllegalArgumentException("dns == null");
    }

    public InterfaceC2376b a() {
        return this.f25130d;
    }

    public k b() {
        return this.k;
    }

    public List<q> c() {
        return this.f25132f;
    }

    public u d() {
        return this.f25128b;
    }

    public HostnameVerifier e() {
        return this.j;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2375a)) {
            return false;
        }
        C2375a c2375a = (C2375a) obj;
        return this.f25127a.equals(c2375a.f25127a) && this.f25128b.equals(c2375a.f25128b) && this.f25130d.equals(c2375a.f25130d) && this.f25131e.equals(c2375a.f25131e) && this.f25132f.equals(c2375a.f25132f) && this.f25133g.equals(c2375a.f25133g) && com.squareup.okhttp.a.o.a(this.f25134h, c2375a.f25134h) && com.squareup.okhttp.a.o.a(this.i, c2375a.i) && com.squareup.okhttp.a.o.a(this.j, c2375a.j) && com.squareup.okhttp.a.o.a(this.k, c2375a.k);
    }

    public List<Protocol> f() {
        return this.f25131e;
    }

    public Proxy g() {
        return this.f25134h;
    }

    public ProxySelector h() {
        return this.f25133g;
    }

    public int hashCode() {
        int hashCode = (((((((((((527 + this.f25127a.hashCode()) * 31) + this.f25128b.hashCode()) * 31) + this.f25130d.hashCode()) * 31) + this.f25131e.hashCode()) * 31) + this.f25132f.hashCode()) * 31) + this.f25133g.hashCode()) * 31;
        Proxy proxy = this.f25134h;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.i;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.j;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        k kVar = this.k;
        return hashCode4 + (kVar != null ? kVar.hashCode() : 0);
    }

    public SocketFactory i() {
        return this.f25129c;
    }

    public SSLSocketFactory j() {
        return this.i;
    }

    @Deprecated
    public String k() {
        return this.f25127a.g();
    }

    @Deprecated
    public int l() {
        return this.f25127a.j();
    }

    public HttpUrl m() {
        return this.f25127a;
    }
}
