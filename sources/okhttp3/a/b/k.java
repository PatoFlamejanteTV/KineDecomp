package okhttp3.a.b;

import android.support.v7.widget.ActivityChooserView;
import com.facebook.stetho.server.http.HttpHeaders;
import com.qq.e.comm.constants.ErrorCode;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.A;
import okhttp3.B;
import okhttp3.C2557a;
import okhttp3.C2564h;
import okhttp3.F;
import okhttp3.I;
import okhttp3.InterfaceC2562f;
import okhttp3.L;
import okhttp3.M;
import okhttp3.O;
import okhttp3.P;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.w;

/* compiled from: RetryAndFollowUpInterceptor.java */
/* loaded from: classes3.dex */
public final class k implements B {

    /* renamed from: a, reason: collision with root package name */
    private final F f28891a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f28892b;

    /* renamed from: c, reason: collision with root package name */
    private volatile okhttp3.internal.connection.f f28893c;

    /* renamed from: d, reason: collision with root package name */
    private Object f28894d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f28895e;

    public k(F f2, boolean z) {
        this.f28891a = f2;
        this.f28892b = z;
    }

    public void a() {
        this.f28895e = true;
        okhttp3.internal.connection.f fVar = this.f28893c;
        if (fVar != null) {
            fVar.a();
        }
    }

    public boolean b() {
        return this.f28895e;
    }

    public void a(Object obj) {
        this.f28894d = obj;
    }

    @Override // okhttp3.B
    public M a(B.a aVar) throws IOException {
        M a2;
        I a3 = aVar.a();
        h hVar = (h) aVar;
        InterfaceC2562f e2 = hVar.e();
        w g2 = hVar.g();
        okhttp3.internal.connection.f fVar = new okhttp3.internal.connection.f(this.f28891a.e(), a(a3.g()), e2, g2, this.f28894d);
        this.f28893c = fVar;
        M m = null;
        int i = 0;
        while (!this.f28895e) {
            try {
                try {
                    a2 = hVar.a(a3, fVar, null, null);
                    if (m != null) {
                        M.a w = a2.w();
                        M.a w2 = m.w();
                        w2.a((O) null);
                        w.c(w2.a());
                        a2 = w.a();
                    }
                } catch (IOException e3) {
                    if (!a(e3, fVar, !(e3 instanceof ConnectionShutdownException), a3)) {
                        throw e3;
                    }
                } catch (RouteException e4) {
                    if (!a(e4.getLastConnectException(), fVar, false, a3)) {
                        throw e4.getFirstConnectException();
                    }
                }
                try {
                    I a4 = a(a2, fVar.g());
                    if (a4 == null) {
                        fVar.f();
                        return a2;
                    }
                    okhttp3.a.e.a(a2.a());
                    int i2 = i + 1;
                    if (i2 <= 20) {
                        a4.a();
                        if (!a(a2, a4.g())) {
                            fVar.f();
                            fVar = new okhttp3.internal.connection.f(this.f28891a.e(), a(a4.g()), e2, g2, this.f28894d);
                            this.f28893c = fVar;
                        } else if (fVar.b() != null) {
                            throw new IllegalStateException("Closing the body of " + a2 + " didn't close its backing stream. Bad interceptor?");
                        }
                        m = a2;
                        a3 = a4;
                        i = i2;
                    } else {
                        fVar.f();
                        throw new ProtocolException("Too many follow-up requests: " + i2);
                    }
                } catch (IOException e5) {
                    fVar.f();
                    throw e5;
                }
            } catch (Throwable th) {
                fVar.a((IOException) null);
                fVar.f();
                throw th;
            }
        }
        fVar.f();
        throw new IOException("Canceled");
    }

    private C2557a a(A a2) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        C2564h c2564h;
        if (a2.h()) {
            SSLSocketFactory y = this.f28891a.y();
            hostnameVerifier = this.f28891a.m();
            sSLSocketFactory = y;
            c2564h = this.f28891a.c();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            c2564h = null;
        }
        return new C2557a(a2.g(), a2.k(), this.f28891a.i(), this.f28891a.x(), sSLSocketFactory, hostnameVerifier, c2564h, this.f28891a.t(), this.f28891a.s(), this.f28891a.r(), this.f28891a.f(), this.f28891a.u());
    }

    private boolean a(IOException iOException, okhttp3.internal.connection.f fVar, boolean z, I i) {
        fVar.a(iOException);
        if (!this.f28891a.w()) {
            return false;
        }
        if (z) {
            i.a();
        }
        return a(iOException, z) && fVar.d();
    }

    private boolean a(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private I a(M m, P p) throws IOException {
        String e2;
        A e3;
        if (m != null) {
            int c2 = m.c();
            String e4 = m.z().e();
            if (c2 == 307 || c2 == 308) {
                if (!e4.equals("GET") && !e4.equals("HEAD")) {
                    return null;
                }
            } else {
                if (c2 == 401) {
                    return this.f28891a.a().a(p, m);
                }
                if (c2 == 503) {
                    if ((m.x() == null || m.x().c() != 503) && a(m, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) == 0) {
                        return m.z();
                    }
                    return null;
                }
                if (c2 == 407) {
                    if (p.b().type() == Proxy.Type.HTTP) {
                        return this.f28891a.t().a(p, m);
                    }
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                if (c2 == 408) {
                    if (!this.f28891a.w()) {
                        return null;
                    }
                    m.z().a();
                    if ((m.x() == null || m.x().c() != 408) && a(m, 0) <= 0) {
                        return m.z();
                    }
                    return null;
                }
                switch (c2) {
                    case 300:
                    case ErrorCode.InitError.INIT_ADMANGER_ERROR /* 301 */:
                    case ErrorCode.InitError.INIT_PLUGIN_ERROR /* 302 */:
                    case ErrorCode.InitError.GET_INTERFACE_ERROR /* 303 */:
                        break;
                    default:
                        return null;
                }
            }
            if (!this.f28891a.k() || (e2 = m.e("Location")) == null || (e3 = m.z().g().e(e2)) == null) {
                return null;
            }
            if (!e3.n().equals(m.z().g().n()) && !this.f28891a.l()) {
                return null;
            }
            I.a f2 = m.z().f();
            if (g.b(e4)) {
                boolean d2 = g.d(e4);
                if (g.c(e4)) {
                    f2.a("GET", (L) null);
                } else {
                    f2.a(e4, d2 ? m.z().a() : null);
                }
                if (!d2) {
                    f2.a("Transfer-Encoding");
                    f2.a(HttpHeaders.CONTENT_LENGTH);
                    f2.a(HttpHeaders.CONTENT_TYPE);
                }
            }
            if (!a(m, e3)) {
                f2.a("Authorization");
            }
            f2.a(e3);
            return f2.a();
        }
        throw new IllegalStateException();
    }

    private int a(M m, int i) {
        String e2 = m.e("Retry-After");
        return e2 == null ? i : e2.matches("\\d+") ? Integer.valueOf(e2).intValue() : ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    }

    private boolean a(M m, A a2) {
        A g2 = m.z().g();
        return g2.g().equals(a2.g()) && g2.k() == a2.k() && g2.n().equals(a2.n());
    }
}
