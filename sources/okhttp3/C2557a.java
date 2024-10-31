package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.A;

/* compiled from: Address.java */
/* renamed from: okhttp3.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2557a {

    /* renamed from: a, reason: collision with root package name */
    final A f28846a;

    /* renamed from: b, reason: collision with root package name */
    final t f28847b;

    /* renamed from: c, reason: collision with root package name */
    final SocketFactory f28848c;

    /* renamed from: d, reason: collision with root package name */
    final InterfaceC2559c f28849d;

    /* renamed from: e, reason: collision with root package name */
    final List<Protocol> f28850e;

    /* renamed from: f, reason: collision with root package name */
    final List<C2570n> f28851f;

    /* renamed from: g, reason: collision with root package name */
    final ProxySelector f28852g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    final Proxy f28853h;

    @Nullable
    final SSLSocketFactory i;

    @Nullable
    final HostnameVerifier j;

    @Nullable
    final C2564h k;

    public C2557a(String str, int i, t tVar, SocketFactory socketFactory, @Nullable SSLSocketFactory sSLSocketFactory, @Nullable HostnameVerifier hostnameVerifier, @Nullable C2564h c2564h, InterfaceC2559c interfaceC2559c, @Nullable Proxy proxy, List<Protocol> list, List<C2570n> list2, ProxySelector proxySelector) {
        A.a aVar = new A.a();
        aVar.d(sSLSocketFactory != null ? "https" : "http");
        aVar.b(str);
        aVar.a(i);
        this.f28846a = aVar.a();
        if (tVar != null) {
            this.f28847b = tVar;
            if (socketFactory != null) {
                this.f28848c = socketFactory;
                if (interfaceC2559c != null) {
                    this.f28849d = interfaceC2559c;
                    if (list != null) {
                        this.f28850e = okhttp3.a.e.a(list);
                        if (list2 != null) {
                            this.f28851f = okhttp3.a.e.a(list2);
                            if (proxySelector != null) {
                                this.f28852g = proxySelector;
                                this.f28853h = proxy;
                                this.i = sSLSocketFactory;
                                this.j = hostnameVerifier;
                                this.k = c2564h;
                                return;
                            }
                            throw new NullPointerException("proxySelector == null");
                        }
                        throw new NullPointerException("connectionSpecs == null");
                    }
                    throw new NullPointerException("protocols == null");
                }
                throw new NullPointerException("proxyAuthenticator == null");
            }
            throw new NullPointerException("socketFactory == null");
        }
        throw new NullPointerException("dns == null");
    }

    @Nullable
    public C2564h a() {
        return this.k;
    }

    public List<C2570n> b() {
        return this.f28851f;
    }

    public t c() {
        return this.f28847b;
    }

    @Nullable
    public HostnameVerifier d() {
        return this.j;
    }

    public List<Protocol> e() {
        return this.f28850e;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof C2557a) {
            C2557a c2557a = (C2557a) obj;
            if (this.f28846a.equals(c2557a.f28846a) && a(c2557a)) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public Proxy f() {
        return this.f28853h;
    }

    public InterfaceC2559c g() {
        return this.f28849d;
    }

    public ProxySelector h() {
        return this.f28852g;
    }

    public int hashCode() {
        int hashCode = (((((((((((527 + this.f28846a.hashCode()) * 31) + this.f28847b.hashCode()) * 31) + this.f28849d.hashCode()) * 31) + this.f28850e.hashCode()) * 31) + this.f28851f.hashCode()) * 31) + this.f28852g.hashCode()) * 31;
        Proxy proxy = this.f28853h;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.i;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.j;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        C2564h c2564h = this.k;
        return hashCode4 + (c2564h != null ? c2564h.hashCode() : 0);
    }

    public SocketFactory i() {
        return this.f28848c;
    }

    @Nullable
    public SSLSocketFactory j() {
        return this.i;
    }

    public A k() {
        return this.f28846a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.f28846a.g());
        sb.append(":");
        sb.append(this.f28846a.k());
        if (this.f28853h != null) {
            sb.append(", proxy=");
            sb.append(this.f28853h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.f28852g);
        }
        sb.append("}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(C2557a c2557a) {
        return this.f28847b.equals(c2557a.f28847b) && this.f28849d.equals(c2557a.f28849d) && this.f28850e.equals(c2557a.f28850e) && this.f28851f.equals(c2557a.f28851f) && this.f28852g.equals(c2557a.f28852g) && okhttp3.a.e.a(this.f28853h, c2557a.f28853h) && okhttp3.a.e.a(this.i, c2557a.i) && okhttp3.a.e.a(this.j, c2557a.j) && okhttp3.a.e.a(this.k, c2557a.k) && k().k() == c2557a.k().k();
    }
}
