package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;
import javax.annotation.Nullable;

/* compiled from: Route.java */
/* loaded from: classes3.dex */
public final class P {

    /* renamed from: a */
    final C2557a f28843a;

    /* renamed from: b */
    final Proxy f28844b;

    /* renamed from: c */
    final InetSocketAddress f28845c;

    public P(C2557a c2557a, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (c2557a == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress != null) {
            this.f28843a = c2557a;
            this.f28844b = proxy;
            this.f28845c = inetSocketAddress;
            return;
        }
        throw new NullPointerException("inetSocketAddress == null");
    }

    public C2557a a() {
        return this.f28843a;
    }

    public Proxy b() {
        return this.f28844b;
    }

    public boolean c() {
        return this.f28843a.i != null && this.f28844b.type() == Proxy.Type.HTTP;
    }

    public InetSocketAddress d() {
        return this.f28845c;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof P) {
            P p = (P) obj;
            if (p.f28843a.equals(this.f28843a) && p.f28844b.equals(this.f28844b) && p.f28845c.equals(this.f28845c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f28843a.hashCode()) * 31) + this.f28844b.hashCode()) * 31) + this.f28845c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f28845c + "}";
    }
}
