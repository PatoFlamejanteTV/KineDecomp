package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.C2375a;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.WeakReference;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import okio.y;

/* compiled from: StreamAllocation.java */
/* loaded from: classes3.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final C2375a f25498a;

    /* renamed from: b, reason: collision with root package name */
    private final com.squareup.okhttp.o f25499b;

    /* renamed from: c, reason: collision with root package name */
    private u f25500c;

    /* renamed from: d, reason: collision with root package name */
    private com.squareup.okhttp.a.a.c f25501d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f25502e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f25503f;

    /* renamed from: g, reason: collision with root package name */
    private o f25504g;

    public w(com.squareup.okhttp.o oVar, C2375a c2375a) {
        this.f25499b = oVar;
        this.f25498a = c2375a;
    }

    private com.squareup.okhttp.a.a.c b(int i, int i2, int i3, boolean z, boolean z2) throws IOException, RouteException {
        while (true) {
            com.squareup.okhttp.a.a.c a2 = a(i, i2, i3, z);
            synchronized (this.f25499b) {
                if (a2.i == 0) {
                    return a2;
                }
                if (a2.a(z2)) {
                    return a2;
                }
                b();
            }
        }
    }

    private com.squareup.okhttp.a.m e() {
        return com.squareup.okhttp.a.h.f25192b.a(this.f25499b);
    }

    public o a(int i, int i2, int i3, boolean z, boolean z2) throws RouteException, IOException {
        o gVar;
        try {
            com.squareup.okhttp.a.a.c b2 = b(i, i2, i3, z, z2);
            if (b2.f25147h != null) {
                gVar = new h(this, b2.f25147h);
            } else {
                b2.c().setSoTimeout(i2);
                b2.j.e().a(i2, TimeUnit.MILLISECONDS);
                b2.k.e().a(i3, TimeUnit.MILLISECONDS);
                gVar = new g(this, b2.j, b2.k);
            }
            synchronized (this.f25499b) {
                b2.i++;
                this.f25504g = gVar;
            }
            return gVar;
        } catch (IOException e2) {
            throw new RouteException(e2);
        }
    }

    public void c() {
        a(true, false, false);
    }

    public void d() {
        a(false, true, false);
    }

    public String toString() {
        return this.f25498a.toString();
    }

    public void b() {
        a(true, false, true);
    }

    private void b(com.squareup.okhttp.a.a.c cVar) {
        int size = cVar.l.size();
        for (int i = 0; i < size; i++) {
            if (cVar.l.get(i).get() == this) {
                cVar.l.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    private com.squareup.okhttp.a.a.c a(int i, int i2, int i3, boolean z) throws IOException, RouteException {
        synchronized (this.f25499b) {
            if (!this.f25502e) {
                if (this.f25504g == null) {
                    if (!this.f25503f) {
                        com.squareup.okhttp.a.a.c cVar = this.f25501d;
                        if (cVar != null && !cVar.m) {
                            return cVar;
                        }
                        com.squareup.okhttp.a.a.c a2 = com.squareup.okhttp.a.h.f25192b.a(this.f25499b, this.f25498a, this);
                        if (a2 != null) {
                            this.f25501d = a2;
                            return a2;
                        }
                        if (this.f25500c == null) {
                            this.f25500c = new u(this.f25498a, e());
                        }
                        com.squareup.okhttp.a.a.c cVar2 = new com.squareup.okhttp.a.a.c(this.f25500c.b());
                        a(cVar2);
                        synchronized (this.f25499b) {
                            com.squareup.okhttp.a.h.f25192b.b(this.f25499b, cVar2);
                            this.f25501d = cVar2;
                            if (this.f25503f) {
                                throw new IOException("Canceled");
                            }
                        }
                        cVar2.a(i, i2, i3, this.f25498a.c(), z);
                        e().a(cVar2.getRoute());
                        return cVar2;
                    }
                    throw new IOException("Canceled");
                }
                throw new IllegalStateException("stream != null");
            }
            throw new IllegalStateException("released");
        }
    }

    private boolean b(IOException iOException) {
        return ((iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) ? false : true;
    }

    private boolean b(RouteException routeException) {
        IOException lastConnectException = routeException.getLastConnectException();
        if (lastConnectException instanceof ProtocolException) {
            return false;
        }
        if (lastConnectException instanceof InterruptedIOException) {
            return lastConnectException instanceof SocketTimeoutException;
        }
        return (((lastConnectException instanceof SSLHandshakeException) && (lastConnectException.getCause() instanceof CertificateException)) || (lastConnectException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    public void a(o oVar) {
        synchronized (this.f25499b) {
            if (oVar != null) {
                if (oVar == this.f25504g) {
                }
            }
            throw new IllegalStateException("expected " + this.f25504g + " but was " + oVar);
        }
        a(false, false, true);
    }

    public synchronized com.squareup.okhttp.a.a.c a() {
        return this.f25501d;
    }

    private void a(boolean z, boolean z2, boolean z3) {
        com.squareup.okhttp.a.a.c cVar;
        synchronized (this.f25499b) {
            if (z3) {
                try {
                    this.f25504g = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z2) {
                this.f25502e = true;
            }
            if (this.f25501d != null) {
                if (z) {
                    this.f25501d.m = true;
                }
                if (this.f25504g == null && (this.f25502e || this.f25501d.m)) {
                    b(this.f25501d);
                    if (this.f25501d.i > 0) {
                        this.f25500c = null;
                    }
                    if (this.f25501d.l.isEmpty()) {
                        this.f25501d.n = System.nanoTime();
                        if (com.squareup.okhttp.a.h.f25192b.a(this.f25499b, this.f25501d)) {
                            cVar = this.f25501d;
                            this.f25501d = null;
                        }
                    }
                    cVar = null;
                    this.f25501d = null;
                }
            }
            cVar = null;
        }
        if (cVar != null) {
            com.squareup.okhttp.a.o.a(cVar.c());
        }
    }

    private void a(IOException iOException) {
        synchronized (this.f25499b) {
            if (this.f25500c != null) {
                if (this.f25501d.i == 0) {
                    this.f25500c.a(this.f25501d.getRoute(), iOException);
                } else {
                    this.f25500c = null;
                }
            }
        }
        b();
    }

    public void a(com.squareup.okhttp.a.a.c cVar) {
        cVar.l.add(new WeakReference(this));
    }

    public boolean a(RouteException routeException) {
        if (this.f25501d != null) {
            a(routeException.getLastConnectException());
        }
        u uVar = this.f25500c;
        return (uVar == null || uVar.a()) && b(routeException);
    }

    public boolean a(IOException iOException, y yVar) {
        com.squareup.okhttp.a.a.c cVar = this.f25501d;
        if (cVar != null) {
            int i = cVar.i;
            a(iOException);
            if (i == 1) {
                return false;
            }
        }
        boolean z = yVar == null || (yVar instanceof t);
        u uVar = this.f25500c;
        return (uVar == null || uVar.a()) && b(iOException) && z;
    }
}
