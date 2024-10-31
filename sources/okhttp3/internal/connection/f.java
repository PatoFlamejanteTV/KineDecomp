package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;
import okhttp3.B;
import okhttp3.C2557a;
import okhttp3.C2569m;
import okhttp3.F;
import okhttp3.InterfaceC2562f;
import okhttp3.P;
import okhttp3.internal.connection.e;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.w;

/* compiled from: StreamAllocation.java */
/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final C2557a f29014a;

    /* renamed from: b, reason: collision with root package name */
    private e.a f29015b;

    /* renamed from: c, reason: collision with root package name */
    private P f29016c;

    /* renamed from: d, reason: collision with root package name */
    private final C2569m f29017d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC2562f f29018e;

    /* renamed from: f, reason: collision with root package name */
    public final w f29019f;

    /* renamed from: g, reason: collision with root package name */
    private final Object f29020g;

    /* renamed from: h, reason: collision with root package name */
    private final e f29021h;
    private int i;
    private c j;
    private boolean k;
    private boolean l;
    private boolean m;
    private okhttp3.a.b.c n;

    /* compiled from: StreamAllocation.java */
    /* loaded from: classes3.dex */
    public static final class a extends WeakReference<f> {

        /* renamed from: a, reason: collision with root package name */
        public final Object f29022a;

        a(f fVar, Object obj) {
            super(fVar);
            this.f29022a = obj;
        }
    }

    public f(C2569m c2569m, C2557a c2557a, InterfaceC2562f interfaceC2562f, w wVar, Object obj) {
        this.f29017d = c2569m;
        this.f29014a = c2557a;
        this.f29018e = interfaceC2562f;
        this.f29019f = wVar;
        this.f29021h = new e(c2557a, i(), interfaceC2562f, wVar);
        this.f29020g = obj;
    }

    private Socket h() {
        c cVar = this.j;
        if (cVar == null || !cVar.k) {
            return null;
        }
        return a(false, false, true);
    }

    private d i() {
        return okhttp3.a.a.f28854a.a(this.f29017d);
    }

    public okhttp3.a.b.c a(F f2, B.a aVar, boolean z) {
        try {
            okhttp3.a.b.c a2 = a(aVar.d(), aVar.b(), aVar.c(), f2.q(), f2.w(), z).a(f2, aVar, this);
            synchronized (this.f29017d) {
                this.n = a2;
            }
            return a2;
        } catch (IOException e2) {
            throw new RouteException(e2);
        }
    }

    public okhttp3.a.b.c b() {
        okhttp3.a.b.c cVar;
        synchronized (this.f29017d) {
            cVar = this.n;
        }
        return cVar;
    }

    public synchronized c c() {
        return this.j;
    }

    public boolean d() {
        e.a aVar;
        return this.f29016c != null || ((aVar = this.f29015b) != null && aVar.b()) || this.f29021h.a();
    }

    public void e() {
        c cVar;
        Socket a2;
        synchronized (this.f29017d) {
            cVar = this.j;
            a2 = a(true, false, false);
            if (this.j != null) {
                cVar = null;
            }
        }
        okhttp3.a.e.a(a2);
        if (cVar != null) {
            this.f29019f.b(this.f29018e, cVar);
        }
    }

    public void f() {
        c cVar;
        Socket a2;
        synchronized (this.f29017d) {
            cVar = this.j;
            a2 = a(false, true, false);
            if (this.j != null) {
                cVar = null;
            }
        }
        okhttp3.a.e.a(a2);
        if (cVar != null) {
            okhttp3.a.a.f28854a.a(this.f29018e, (IOException) null);
            this.f29019f.b(this.f29018e, cVar);
            this.f29019f.a(this.f29018e);
        }
    }

    public P g() {
        return this.f29016c;
    }

    public String toString() {
        c c2 = c();
        return c2 != null ? c2.toString() : this.f29014a.toString();
    }

    private void b(c cVar) {
        int size = cVar.n.size();
        for (int i = 0; i < size; i++) {
            if (cVar.n.get(i).get() == this) {
                cVar.n.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    private c a(int i, int i2, int i3, int i4, boolean z, boolean z2) throws IOException {
        while (true) {
            c a2 = a(i, i2, i3, i4, z);
            synchronized (this.f29017d) {
                if (a2.l == 0) {
                    return a2;
                }
                if (a2.a(z2)) {
                    return a2;
                }
                e();
            }
        }
    }

    private c a(int i, int i2, int i3, int i4, boolean z) throws IOException {
        Socket h2;
        Socket socket;
        c cVar;
        c cVar2;
        c cVar3;
        P p;
        boolean z2;
        boolean z3;
        e.a aVar;
        synchronized (this.f29017d) {
            if (!this.l) {
                if (this.n == null) {
                    if (!this.m) {
                        c cVar4 = this.j;
                        h2 = h();
                        socket = null;
                        if (this.j != null) {
                            cVar2 = this.j;
                            cVar = null;
                        } else {
                            cVar = cVar4;
                            cVar2 = null;
                        }
                        if (!this.k) {
                            cVar = null;
                        }
                        if (cVar2 == null) {
                            okhttp3.a.a.f28854a.a(this.f29017d, this.f29014a, this, null);
                            if (this.j != null) {
                                cVar3 = this.j;
                                p = null;
                                z2 = true;
                            } else {
                                p = this.f29016c;
                                cVar3 = cVar2;
                            }
                        } else {
                            cVar3 = cVar2;
                            p = null;
                        }
                        z2 = false;
                    } else {
                        throw new IOException("Canceled");
                    }
                } else {
                    throw new IllegalStateException("codec != null");
                }
            } else {
                throw new IllegalStateException("released");
            }
        }
        okhttp3.a.e.a(h2);
        if (cVar != null) {
            this.f29019f.b(this.f29018e, cVar);
        }
        if (z2) {
            this.f29019f.a(this.f29018e, cVar3);
        }
        if (cVar3 != null) {
            this.f29016c = this.j.d();
            return cVar3;
        }
        if (p != null || ((aVar = this.f29015b) != null && aVar.b())) {
            z3 = false;
        } else {
            this.f29015b = this.f29021h.b();
            z3 = true;
        }
        synchronized (this.f29017d) {
            if (this.m) {
                throw new IOException("Canceled");
            }
            if (z3) {
                List<P> a2 = this.f29015b.a();
                int size = a2.size();
                int i5 = 0;
                while (true) {
                    if (i5 >= size) {
                        break;
                    }
                    P p2 = a2.get(i5);
                    okhttp3.a.a.f28854a.a(this.f29017d, this.f29014a, this, p2);
                    if (this.j != null) {
                        cVar3 = this.j;
                        this.f29016c = p2;
                        z2 = true;
                        break;
                    }
                    i5++;
                }
            }
            if (!z2) {
                if (p == null) {
                    p = this.f29015b.c();
                }
                this.f29016c = p;
                this.i = 0;
                cVar3 = new c(this.f29017d, p);
                a(cVar3, false);
            }
        }
        if (z2) {
            this.f29019f.a(this.f29018e, cVar3);
            return cVar3;
        }
        cVar3.a(i, i2, i3, i4, z, this.f29018e, this.f29019f);
        i().a(cVar3.d());
        synchronized (this.f29017d) {
            this.k = true;
            okhttp3.a.a.f28854a.b(this.f29017d, cVar3);
            if (cVar3.c()) {
                socket = okhttp3.a.a.f28854a.a(this.f29017d, this.f29014a, this);
                cVar3 = this.j;
            }
        }
        okhttp3.a.e.a(socket);
        this.f29019f.a(this.f29018e, cVar3);
        return cVar3;
    }

    public void a(boolean z, okhttp3.a.b.c cVar, long j, IOException iOException) {
        c cVar2;
        Socket a2;
        boolean z2;
        this.f29019f.b(this.f29018e, j);
        synchronized (this.f29017d) {
            if (cVar != null) {
                if (cVar == this.n) {
                    if (!z) {
                        this.j.l++;
                    }
                    cVar2 = this.j;
                    a2 = a(z, false, true);
                    if (this.j != null) {
                        cVar2 = null;
                    }
                    z2 = this.l;
                }
            }
            throw new IllegalStateException("expected " + this.n + " but was " + cVar);
        }
        okhttp3.a.e.a(a2);
        if (cVar2 != null) {
            this.f29019f.b(this.f29018e, cVar2);
        }
        if (iOException != null) {
            this.f29019f.a(this.f29018e, okhttp3.a.a.f28854a.a(this.f29018e, iOException));
        } else if (z2) {
            okhttp3.a.a.f28854a.a(this.f29018e, (IOException) null);
            this.f29019f.a(this.f29018e);
        }
    }

    private Socket a(boolean z, boolean z2, boolean z3) {
        Socket socket;
        if (z3) {
            this.n = null;
        }
        if (z2) {
            this.l = true;
        }
        c cVar = this.j;
        if (cVar != null) {
            if (z) {
                cVar.k = true;
            }
            if (this.n == null && (this.l || this.j.k)) {
                b(this.j);
                if (this.j.n.isEmpty()) {
                    this.j.o = System.nanoTime();
                    if (okhttp3.a.a.f28854a.a(this.f29017d, this.j)) {
                        socket = this.j.e();
                        this.j = null;
                        return socket;
                    }
                }
                socket = null;
                this.j = null;
                return socket;
            }
        }
        return null;
    }

    public void a() {
        okhttp3.a.b.c cVar;
        c cVar2;
        synchronized (this.f29017d) {
            this.m = true;
            cVar = this.n;
            cVar2 = this.j;
        }
        if (cVar != null) {
            cVar.cancel();
        } else if (cVar2 != null) {
            cVar2.a();
        }
    }

    public void a(IOException iOException) {
        boolean z;
        c cVar;
        Socket a2;
        synchronized (this.f29017d) {
            if (iOException instanceof StreamResetException) {
                ErrorCode errorCode = ((StreamResetException) iOException).errorCode;
                if (errorCode == ErrorCode.REFUSED_STREAM) {
                    this.i++;
                    if (this.i > 1) {
                        this.f29016c = null;
                        z = true;
                    }
                    z = false;
                } else {
                    if (errorCode != ErrorCode.CANCEL) {
                        this.f29016c = null;
                        z = true;
                    }
                    z = false;
                }
            } else {
                if (this.j != null && (!this.j.c() || (iOException instanceof ConnectionShutdownException))) {
                    if (this.j.l == 0) {
                        if (this.f29016c != null && iOException != null) {
                            this.f29021h.a(this.f29016c, iOException);
                        }
                        this.f29016c = null;
                    }
                    z = true;
                }
                z = false;
            }
            cVar = this.j;
            a2 = a(z, false, true);
            if (this.j != null || !this.k) {
                cVar = null;
            }
        }
        okhttp3.a.e.a(a2);
        if (cVar != null) {
            this.f29019f.b(this.f29018e, cVar);
        }
    }

    public void a(c cVar, boolean z) {
        if (this.j == null) {
            this.j = cVar;
            this.k = z;
            cVar.n.add(new a(this, this.f29020g));
            return;
        }
        throw new IllegalStateException();
    }

    public Socket a(c cVar) {
        if (this.n == null && this.j.n.size() == 1) {
            Reference<f> reference = this.j.n.get(0);
            Socket a2 = a(true, false, false);
            this.j = cVar;
            cVar.n.add(reference);
            return a2;
        }
        throw new IllegalStateException();
    }
}
