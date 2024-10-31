package com.squareup.okhttp.a.a;

import android.support.v7.widget.ActivityChooserView;
import com.nextreaming.nexeditorui.NexTimeline;
import com.squareup.okhttp.C2375a;
import com.squareup.okhttp.E;
import com.squareup.okhttp.H;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.J;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.a.b.d;
import com.squareup.okhttp.a.b.f;
import com.squareup.okhttp.a.l;
import com.squareup.okhttp.a.o;
import com.squareup.okhttp.a.p;
import com.squareup.okhttp.internal.framed.j;
import com.squareup.okhttp.internal.http.RouteException;
import com.squareup.okhttp.internal.http.g;
import com.squareup.okhttp.internal.http.w;
import com.squareup.okhttp.k;
import com.squareup.okhttp.m;
import com.squareup.okhttp.q;
import com.squareup.okhttp.v;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import okio.h;
import okio.i;
import okio.s;
import okio.z;

/* compiled from: RealConnection.java */
/* loaded from: classes3.dex */
public final class c implements m {

    /* renamed from: a, reason: collision with root package name */
    private static SSLSocketFactory f25140a;

    /* renamed from: b, reason: collision with root package name */
    private static f f25141b;

    /* renamed from: c, reason: collision with root package name */
    private final J f25142c;

    /* renamed from: d, reason: collision with root package name */
    private Socket f25143d;

    /* renamed from: e, reason: collision with root package name */
    public Socket f25144e;

    /* renamed from: f, reason: collision with root package name */
    private v f25145f;

    /* renamed from: g, reason: collision with root package name */
    private Protocol f25146g;

    /* renamed from: h, reason: collision with root package name */
    public volatile j f25147h;
    public int i;
    public i j;
    public h k;
    public boolean m;
    public final List<Reference<w>> l = new ArrayList();
    public long n = Long.MAX_VALUE;

    public c(J j) {
        this.f25142c = j;
    }

    private E d() throws IOException {
        E.a aVar = new E.a();
        aVar.a(this.f25142c.a().m());
        aVar.b("Host", o.a(this.f25142c.a().m()));
        aVar.b("Proxy-Connection", "Keep-Alive");
        aVar.b(io.fabric.sdk.android.services.common.a.HEADER_USER_AGENT, p.a());
        return aVar.a();
    }

    public void a(int i, int i2, int i3, List<q> list, boolean z) throws RouteException {
        Socket createSocket;
        if (this.f25146g == null) {
            com.squareup.okhttp.a.a aVar = new com.squareup.okhttp.a.a(list);
            Proxy b2 = this.f25142c.b();
            C2375a a2 = this.f25142c.a();
            if (this.f25142c.a().j() == null && !list.contains(q.f25521d)) {
                throw new RouteException(new UnknownServiceException("CLEARTEXT communication not supported: " + list));
            }
            RouteException routeException = null;
            while (this.f25146g == null) {
                try {
                } catch (IOException e2) {
                    o.a(this.f25144e);
                    o.a(this.f25143d);
                    this.f25144e = null;
                    this.f25143d = null;
                    this.j = null;
                    this.k = null;
                    this.f25145f = null;
                    this.f25146g = null;
                    if (routeException == null) {
                        routeException = new RouteException(e2);
                    } else {
                        routeException.addConnectException(e2);
                    }
                    if (z) {
                        if (!aVar.a(e2)) {
                            throw routeException;
                        }
                    } else {
                        throw routeException;
                    }
                }
                if (b2.type() != Proxy.Type.DIRECT && b2.type() != Proxy.Type.HTTP) {
                    createSocket = new Socket(b2);
                    this.f25143d = createSocket;
                    a(i, i2, i3, aVar);
                }
                createSocket = a2.i().createSocket();
                this.f25143d = createSocket;
                a(i, i2, i3, aVar);
            }
            return;
        }
        throw new IllegalStateException("already connected");
    }

    public v b() {
        return this.f25145f;
    }

    public Socket c() {
        return this.f25144e;
    }

    @Override // com.squareup.okhttp.m
    public J getRoute() {
        return this.f25142c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f25142c.a().m().g());
        sb.append(":");
        sb.append(this.f25142c.a().m().j());
        sb.append(", proxy=");
        sb.append(this.f25142c.b());
        sb.append(" hostAddress=");
        sb.append(this.f25142c.c());
        sb.append(" cipherSuite=");
        v vVar = this.f25145f;
        sb.append(vVar != null ? vVar.a() : NexTimeline.DEFAULT_PROJECT_PHOTO_CROP_MODE);
        sb.append(" protocol=");
        sb.append(this.f25146g);
        sb.append('}');
        return sb.toString();
    }

    private void a(int i, int i2, int i3, com.squareup.okhttp.a.a aVar) throws IOException {
        this.f25143d.setSoTimeout(i2);
        try {
            l.a().a(this.f25143d, this.f25142c.c(), i);
            this.j = s.a(s.b(this.f25143d));
            this.k = s.a(s.a(this.f25143d));
            if (this.f25142c.a().j() != null) {
                a(i2, i3, aVar);
            } else {
                this.f25146g = Protocol.HTTP_1_1;
                this.f25144e = this.f25143d;
            }
            Protocol protocol = this.f25146g;
            if (protocol == Protocol.SPDY_3 || protocol == Protocol.HTTP_2) {
                this.f25144e.setSoTimeout(0);
                j.a aVar2 = new j.a(true);
                aVar2.a(this.f25144e, this.f25142c.a().m().g(), this.j, this.k);
                aVar2.a(this.f25146g);
                j a2 = aVar2.a();
                a2.r();
                this.f25147h = a2;
            }
        } catch (ConnectException unused) {
            throw new ConnectException("Failed to connect to " + this.f25142c.c());
        }
    }

    private void a(int i, int i2, com.squareup.okhttp.a.a aVar) throws IOException {
        SSLSocket sSLSocket;
        if (this.f25142c.d()) {
            a(i, i2);
        }
        C2375a a2 = this.f25142c.a();
        try {
            try {
                sSLSocket = (SSLSocket) a2.j().createSocket(this.f25143d, a2.k(), a2.l(), true);
                try {
                    q a3 = aVar.a(sSLSocket);
                    if (a3.b()) {
                        l.a().a(sSLSocket, a2.k(), a2.f());
                    }
                    sSLSocket.startHandshake();
                    v a4 = v.a(sSLSocket.getSession());
                    if (a2.e().verify(a2.k(), sSLSocket.getSession())) {
                        if (a2.b() != k.f25505a) {
                            a2.b().a(a2.k(), new com.squareup.okhttp.a.b.b(a(a2.j())).a(a4.c()));
                        }
                        String b2 = a3.b() ? l.a().b(sSLSocket) : null;
                        this.f25144e = sSLSocket;
                        this.j = s.a(s.b(this.f25144e));
                        this.k = s.a(s.a(this.f25144e));
                        this.f25145f = a4;
                        this.f25146g = b2 != null ? Protocol.get(b2) : Protocol.HTTP_1_1;
                        if (sSLSocket != null) {
                            l.a().a(sSLSocket);
                            return;
                        }
                        return;
                    }
                    X509Certificate x509Certificate = (X509Certificate) a4.c().get(0);
                    throw new SSLPeerUnverifiedException("Hostname " + a2.k() + " not verified:\n    certificate: " + k.a((Certificate) x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + d.a(x509Certificate));
                } catch (AssertionError e2) {
                    e = e2;
                    if (!o.a(e)) {
                        throw e;
                    }
                    throw new IOException(e);
                } catch (Throwable th) {
                    th = th;
                    if (sSLSocket != null) {
                        l.a().a(sSLSocket);
                    }
                    o.a((Socket) sSLSocket);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                sSLSocket = null;
            }
        } catch (AssertionError e3) {
            e = e3;
        }
    }

    private static synchronized f a(SSLSocketFactory sSLSocketFactory) {
        f fVar;
        synchronized (c.class) {
            if (sSLSocketFactory != f25140a) {
                f25141b = l.a().a(l.a().a(sSLSocketFactory));
                f25140a = sSLSocketFactory;
            }
            fVar = f25141b;
        }
        return fVar;
    }

    private void a(int i, int i2) throws IOException {
        E d2 = d();
        HttpUrl d3 = d2.d();
        String str = "CONNECT " + d3.g() + ":" + d3.j() + " HTTP/1.1";
        do {
            g gVar = new g(null, this.j, this.k);
            this.j.e().a(i, TimeUnit.MILLISECONDS);
            this.k.e().a(i2, TimeUnit.MILLISECONDS);
            gVar.a(d2.c(), str);
            gVar.a();
            H.a f2 = gVar.f();
            f2.a(d2);
            H a2 = f2.a();
            long a3 = com.squareup.okhttp.internal.http.q.a(a2);
            if (a3 == -1) {
                a3 = 0;
            }
            z b2 = gVar.b(a3);
            o.b(b2, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, TimeUnit.MILLISECONDS);
            b2.close();
            int e2 = a2.e();
            if (e2 == 200) {
                if (!this.j.d().l() || !this.k.d().l()) {
                    throw new IOException("TLS tunnel buffered too many bytes!");
                }
                return;
            } else if (e2 == 407) {
                d2 = com.squareup.okhttp.internal.http.q.a(this.f25142c.a().a(), a2, this.f25142c.b());
            } else {
                throw new IOException("Unexpected response code for CONNECT: " + a2.e());
            }
        } while (d2 != null);
        throw new IOException("Failed to authenticate with proxy");
    }

    public int a() {
        j jVar = this.f25147h;
        if (jVar != null) {
            return jVar.c();
        }
        return 1;
    }

    public boolean a(boolean z) {
        if (this.f25144e.isClosed() || this.f25144e.isInputShutdown() || this.f25144e.isOutputShutdown()) {
            return false;
        }
        if (this.f25147h == null && z) {
            try {
                int soTimeout = this.f25144e.getSoTimeout();
                try {
                    this.f25144e.setSoTimeout(1);
                    return !this.j.l();
                } finally {
                    this.f25144e.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }
}
