package okhttp3.internal.connection;

import android.support.v7.widget.ActivityChooserView;
import com.nextreaming.nexeditorui.NexTimeline;
import com.qq.e.comm.constants.ErrorCode;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import okhttp3.A;
import okhttp3.B;
import okhttp3.C2557a;
import okhttp3.C2564h;
import okhttp3.C2569m;
import okhttp3.C2570n;
import okhttp3.F;
import okhttp3.I;
import okhttp3.InterfaceC2562f;
import okhttp3.InterfaceC2567k;
import okhttp3.L;
import okhttp3.M;
import okhttp3.P;
import okhttp3.Protocol;
import okhttp3.internal.http2.k;
import okhttp3.internal.http2.q;
import okhttp3.w;
import okhttp3.y;
import okio.h;
import okio.i;
import okio.s;
import okio.z;

/* compiled from: RealConnection.java */
/* loaded from: classes3.dex */
public final class c extends k.b implements InterfaceC2567k {

    /* renamed from: b, reason: collision with root package name */
    private final C2569m f28996b;

    /* renamed from: c, reason: collision with root package name */
    private final P f28997c;

    /* renamed from: d, reason: collision with root package name */
    private Socket f28998d;

    /* renamed from: e, reason: collision with root package name */
    private Socket f28999e;

    /* renamed from: f, reason: collision with root package name */
    private y f29000f;

    /* renamed from: g, reason: collision with root package name */
    private Protocol f29001g;

    /* renamed from: h, reason: collision with root package name */
    private k f29002h;
    private i i;
    private h j;
    public boolean k;
    public int l;
    public int m = 1;
    public final List<Reference<f>> n = new ArrayList();
    public long o = Long.MAX_VALUE;

    public c(C2569m c2569m, P p) {
        this.f28996b = c2569m;
        this.f28997c = p;
    }

    private I f() throws IOException {
        I.a aVar = new I.a();
        aVar.a(this.f28997c.a().k());
        aVar.a("CONNECT", (L) null);
        aVar.b("Host", okhttp3.a.e.a(this.f28997c.a().k(), true));
        aVar.b("Proxy-Connection", "Keep-Alive");
        aVar.b(io.fabric.sdk.android.services.common.a.HEADER_USER_AGENT, okhttp3.a.f.a());
        I a2 = aVar.a();
        M.a aVar2 = new M.a();
        aVar2.a(a2);
        aVar2.a(Protocol.HTTP_1_1);
        aVar2.a(ErrorCode.NetWorkError.RETRY_TIME_JS_ERROR);
        aVar2.a("Preemptive Authenticate");
        aVar2.a(okhttp3.a.e.f28956c);
        aVar2.b(-1L);
        aVar2.a(-1L);
        aVar2.b("Proxy-Authenticate", "OkHttp-Preemptive");
        I a3 = this.f28997c.a().g().a(this.f28997c, aVar2.a());
        return a3 != null ? a3 : a2;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f4 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0143 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0136  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r17, int r18, int r19, int r20, boolean r21, okhttp3.InterfaceC2562f r22, okhttp3.w r23) {
        /*
            Method dump skipped, instructions count: 347
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.c.a(int, int, int, int, boolean, okhttp3.f, okhttp3.w):void");
    }

    public y b() {
        return this.f29000f;
    }

    public boolean c() {
        return this.f29002h != null;
    }

    public P d() {
        return this.f28997c;
    }

    public Socket e() {
        return this.f28999e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f28997c.a().k().g());
        sb.append(":");
        sb.append(this.f28997c.a().k().k());
        sb.append(", proxy=");
        sb.append(this.f28997c.b());
        sb.append(" hostAddress=");
        sb.append(this.f28997c.d());
        sb.append(" cipherSuite=");
        y yVar = this.f29000f;
        sb.append(yVar != null ? yVar.a() : NexTimeline.DEFAULT_PROJECT_PHOTO_CROP_MODE);
        sb.append(" protocol=");
        sb.append(this.f29001g);
        sb.append('}');
        return sb.toString();
    }

    private void a(int i, int i2, int i3, InterfaceC2562f interfaceC2562f, w wVar) throws IOException {
        I f2 = f();
        A g2 = f2.g();
        for (int i4 = 0; i4 < 21; i4++) {
            a(i, i2, interfaceC2562f, wVar);
            f2 = a(i2, i3, f2, g2);
            if (f2 == null) {
                return;
            }
            okhttp3.a.e.a(this.f28998d);
            this.f28998d = null;
            this.j = null;
            this.i = null;
            wVar.a(interfaceC2562f, this.f28997c.d(), this.f28997c.b(), null);
        }
    }

    private void a(int i, int i2, InterfaceC2562f interfaceC2562f, w wVar) throws IOException {
        Socket createSocket;
        Proxy b2 = this.f28997c.b();
        C2557a a2 = this.f28997c.a();
        if (b2.type() != Proxy.Type.DIRECT && b2.type() != Proxy.Type.HTTP) {
            createSocket = new Socket(b2);
        } else {
            createSocket = a2.i().createSocket();
        }
        this.f28998d = createSocket;
        wVar.a(interfaceC2562f, this.f28997c.d(), b2);
        this.f28998d.setSoTimeout(i2);
        try {
            okhttp3.a.d.f.a().a(this.f28998d, this.f28997c.d(), i);
            try {
                this.i = s.a(s.b(this.f28998d));
                this.j = s.a(s.a(this.f28998d));
            } catch (NullPointerException e2) {
                if ("throw with null exception".equals(e2.getMessage())) {
                    throw new IOException(e2);
                }
            }
        } catch (ConnectException e3) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f28997c.d());
            connectException.initCause(e3);
            throw connectException;
        }
    }

    private void a(b bVar, int i, InterfaceC2562f interfaceC2562f, w wVar) throws IOException {
        if (this.f28997c.a().j() == null) {
            if (this.f28997c.a().e().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
                this.f28999e = this.f28998d;
                this.f29001g = Protocol.H2_PRIOR_KNOWLEDGE;
                a(i);
                return;
            } else {
                this.f28999e = this.f28998d;
                this.f29001g = Protocol.HTTP_1_1;
                return;
            }
        }
        wVar.g(interfaceC2562f);
        a(bVar);
        wVar.a(interfaceC2562f, this.f29000f);
        if (this.f29001g == Protocol.HTTP_2) {
            a(i);
        }
    }

    private void a(int i) throws IOException {
        this.f28999e.setSoTimeout(0);
        k.a aVar = new k.a(true);
        aVar.a(this.f28999e, this.f28997c.a().k().g(), this.i, this.j);
        aVar.a(this);
        aVar.a(i);
        this.f29002h = aVar.a();
        this.f29002h.r();
    }

    private void a(b bVar) throws IOException {
        SSLSocket sSLSocket;
        Protocol protocol;
        C2557a a2 = this.f28997c.a();
        try {
            try {
                sSLSocket = (SSLSocket) a2.j().createSocket(this.f28998d, a2.k().g(), a2.k().k(), true);
                try {
                    C2570n a3 = bVar.a(sSLSocket);
                    if (a3.c()) {
                        okhttp3.a.d.f.a().a(sSLSocket, a2.k().g(), a2.e());
                    }
                    sSLSocket.startHandshake();
                    SSLSession session = sSLSocket.getSession();
                    y a4 = y.a(session);
                    if (!a2.d().verify(a2.k().g(), session)) {
                        List<Certificate> b2 = a4.b();
                        if (!b2.isEmpty()) {
                            X509Certificate x509Certificate = (X509Certificate) b2.get(0);
                            throw new SSLPeerUnverifiedException("Hostname " + a2.k().g() + " not verified:\n    certificate: " + C2564h.a((Certificate) x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + okhttp3.a.f.d.a(x509Certificate));
                        }
                        throw new SSLPeerUnverifiedException("Hostname " + a2.k().g() + " not verified (no certificates)");
                    }
                    a2.a().a(a2.k().g(), a4.b());
                    String b3 = a3.c() ? okhttp3.a.d.f.a().b(sSLSocket) : null;
                    this.f28999e = sSLSocket;
                    this.i = s.a(s.b(this.f28999e));
                    this.j = s.a(s.a(this.f28999e));
                    this.f29000f = a4;
                    if (b3 != null) {
                        protocol = Protocol.get(b3);
                    } else {
                        protocol = Protocol.HTTP_1_1;
                    }
                    this.f29001g = protocol;
                    if (sSLSocket != null) {
                        okhttp3.a.d.f.a().a(sSLSocket);
                    }
                } catch (AssertionError e2) {
                    e = e2;
                    if (!okhttp3.a.e.a(e)) {
                        throw e;
                    }
                    throw new IOException(e);
                } catch (Throwable th) {
                    th = th;
                    if (sSLSocket != null) {
                        okhttp3.a.d.f.a().a(sSLSocket);
                    }
                    okhttp3.a.e.a((Socket) sSLSocket);
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

    private I a(int i, int i2, I i3, A a2) throws IOException {
        String str = "CONNECT " + okhttp3.a.e.a(a2, true) + " HTTP/1.1";
        while (true) {
            okhttp3.a.c.b bVar = new okhttp3.a.c.b(null, null, this.i, this.j);
            this.i.e().a(i, TimeUnit.MILLISECONDS);
            this.j.e().a(i2, TimeUnit.MILLISECONDS);
            bVar.a(i3.c(), str);
            bVar.a();
            M.a a3 = bVar.a(false);
            a3.a(i3);
            M a4 = a3.a();
            long a5 = okhttp3.a.b.f.a(a4);
            if (a5 == -1) {
                a5 = 0;
            }
            z b2 = bVar.b(a5);
            okhttp3.a.e.b(b2, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, TimeUnit.MILLISECONDS);
            b2.close();
            int c2 = a4.c();
            if (c2 == 200) {
                if (this.i.d().l() && this.j.d().l()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (c2 == 407) {
                I a6 = this.f28997c.a().g().a(this.f28997c, a4);
                if (a6 != null) {
                    if ("close".equalsIgnoreCase(a4.e("Connection"))) {
                        return a6;
                    }
                    i3 = a6;
                } else {
                    throw new IOException("Failed to authenticate with proxy");
                }
            } else {
                throw new IOException("Unexpected response code for CONNECT: " + a4.c());
            }
        }
    }

    public boolean a(C2557a c2557a, @Nullable P p) {
        if (this.n.size() >= this.m || this.k || !okhttp3.a.a.f28854a.a(this.f28997c.a(), c2557a)) {
            return false;
        }
        if (c2557a.k().g().equals(d().a().k().g())) {
            return true;
        }
        if (this.f29002h == null || p == null || p.b().type() != Proxy.Type.DIRECT || this.f28997c.b().type() != Proxy.Type.DIRECT || !this.f28997c.d().equals(p.d()) || p.a().d() != okhttp3.a.f.d.f28964a || !a(c2557a.k())) {
            return false;
        }
        try {
            c2557a.a().a(c2557a.k().g(), b().b());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public boolean a(A a2) {
        if (a2.k() != this.f28997c.a().k().k()) {
            return false;
        }
        if (a2.g().equals(this.f28997c.a().k().g())) {
            return true;
        }
        return this.f29000f != null && okhttp3.a.f.d.f28964a.verify(a2.g(), (X509Certificate) this.f29000f.b().get(0));
    }

    public okhttp3.a.b.c a(F f2, B.a aVar, f fVar) throws SocketException {
        k kVar = this.f29002h;
        if (kVar != null) {
            return new okhttp3.internal.http2.d(f2, aVar, fVar, kVar);
        }
        this.f28999e.setSoTimeout(aVar.b());
        this.i.e().a(aVar.b(), TimeUnit.MILLISECONDS);
        this.j.e().a(aVar.c(), TimeUnit.MILLISECONDS);
        return new okhttp3.a.c.b(f2, fVar, this.i, this.j);
    }

    public void a() {
        okhttp3.a.e.a(this.f28998d);
    }

    public boolean a(boolean z) {
        if (this.f28999e.isClosed() || this.f28999e.isInputShutdown() || this.f28999e.isOutputShutdown()) {
            return false;
        }
        if (this.f29002h != null) {
            return !r0.b();
        }
        if (z) {
            try {
                int soTimeout = this.f28999e.getSoTimeout();
                try {
                    this.f28999e.setSoTimeout(1);
                    return !this.i.l();
                } finally {
                    this.f28999e.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    @Override // okhttp3.internal.http2.k.b
    public void a(q qVar) throws IOException {
        qVar.a(okhttp3.internal.http2.ErrorCode.REFUSED_STREAM);
    }

    @Override // okhttp3.internal.http2.k.b
    public void a(k kVar) {
        synchronized (this.f28996b) {
            this.m = kVar.c();
        }
    }
}
