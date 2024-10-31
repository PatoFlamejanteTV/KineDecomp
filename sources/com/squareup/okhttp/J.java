package com.squareup.okhttp;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* compiled from: Route.java */
/* loaded from: classes3.dex */
public final class J {

    /* renamed from: a */
    final C2375a f25124a;

    /* renamed from: b */
    final Proxy f25125b;

    /* renamed from: c */
    final InetSocketAddress f25126c;

    public J(C2375a c2375a, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (c2375a == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress != null) {
            this.f25124a = c2375a;
            this.f25125b = proxy;
            this.f25126c = inetSocketAddress;
            return;
        }
        throw new NullPointerException("inetSocketAddress == null");
    }

    public C2375a a() {
        return this.f25124a;
    }

    public Proxy b() {
        return this.f25125b;
    }

    public InetSocketAddress c() {
        return this.f25126c;
    }

    public boolean d() {
        return this.f25124a.i != null && this.f25125b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof J)) {
            return false;
        }
        J j = (J) obj;
        return this.f25124a.equals(j.f25124a) && this.f25125b.equals(j.f25125b) && this.f25126c.equals(j.f25126c);
    }

    public int hashCode() {
        return ((((527 + this.f25124a.hashCode()) * 31) + this.f25125b.hashCode()) * 31) + this.f25126c.hashCode();
    }
}
