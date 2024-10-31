package retrofit2;

import java.io.IOException;
import javax.annotation.Nullable;
import okhttp3.InterfaceC2562f;
import okhttp3.M;
import okhttp3.O;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OkHttpCall.java */
/* loaded from: classes3.dex */
public final class v<T> implements InterfaceC2578b<T> {

    /* renamed from: a, reason: collision with root package name */
    private final C f29521a;

    /* renamed from: b, reason: collision with root package name */
    private final Object[] f29522b;

    /* renamed from: c, reason: collision with root package name */
    private final InterfaceC2562f.a f29523c;

    /* renamed from: d, reason: collision with root package name */
    private final j<O, T> f29524d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f29525e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private InterfaceC2562f f29526f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    private Throwable f29527g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f29528h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OkHttpCall.java */
    /* loaded from: classes3.dex */
    public static final class a extends O {

        /* renamed from: b, reason: collision with root package name */
        private final O f29529b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        IOException f29530c;

        a(O o) {
            this.f29529b = o;
        }

        @Override // okhttp3.O
        public long b() {
            return this.f29529b.b();
        }

        @Override // okhttp3.O
        public okhttp3.C c() {
            return this.f29529b.c();
        }

        @Override // okhttp3.O, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f29529b.close();
        }

        @Override // okhttp3.O
        public okio.i r() {
            return okio.s.a(new u(this, this.f29529b.r()));
        }

        void s() throws IOException {
            IOException iOException = this.f29530c;
            if (iOException != null) {
                throw iOException;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OkHttpCall.java */
    /* loaded from: classes3.dex */
    public static final class b extends O {

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        private final okhttp3.C f29531b;

        /* renamed from: c, reason: collision with root package name */
        private final long f29532c;

        b(@Nullable okhttp3.C c2, long j) {
            this.f29531b = c2;
            this.f29532c = j;
        }

        @Override // okhttp3.O
        public long b() {
            return this.f29532c;
        }

        @Override // okhttp3.O
        public okhttp3.C c() {
            return this.f29531b;
        }

        @Override // okhttp3.O
        public okio.i r() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(C c2, Object[] objArr, InterfaceC2562f.a aVar, j<O, T> jVar) {
        this.f29521a = c2;
        this.f29522b = objArr;
        this.f29523c = aVar;
        this.f29524d = jVar;
    }

    @Override // retrofit2.InterfaceC2578b
    public boolean S() {
        boolean z = true;
        if (this.f29525e) {
            return true;
        }
        synchronized (this) {
            if (this.f29526f == null || !this.f29526f.S()) {
                z = false;
            }
        }
        return z;
    }

    @Override // retrofit2.InterfaceC2578b
    public void a(InterfaceC2580d<T> interfaceC2580d) {
        InterfaceC2562f interfaceC2562f;
        Throwable th;
        H.a(interfaceC2580d, "callback == null");
        synchronized (this) {
            if (!this.f29528h) {
                this.f29528h = true;
                interfaceC2562f = this.f29526f;
                th = this.f29527g;
                if (interfaceC2562f == null && th == null) {
                    try {
                        InterfaceC2562f a2 = a();
                        this.f29526f = a2;
                        interfaceC2562f = a2;
                    } catch (Throwable th2) {
                        th = th2;
                        H.a(th);
                        this.f29527g = th;
                    }
                }
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (th != null) {
            interfaceC2580d.a(this, th);
            return;
        }
        if (this.f29525e) {
            interfaceC2562f.cancel();
        }
        interfaceC2562f.a(new t(this, interfaceC2580d));
    }

    @Override // retrofit2.InterfaceC2578b
    public void cancel() {
        InterfaceC2562f interfaceC2562f;
        this.f29525e = true;
        synchronized (this) {
            interfaceC2562f = this.f29526f;
        }
        if (interfaceC2562f != null) {
            interfaceC2562f.cancel();
        }
    }

    @Override // retrofit2.InterfaceC2578b
    public D<T> execute() throws IOException {
        InterfaceC2562f interfaceC2562f;
        synchronized (this) {
            if (!this.f29528h) {
                this.f29528h = true;
                if (this.f29527g != null) {
                    if (!(this.f29527g instanceof IOException)) {
                        if (this.f29527g instanceof RuntimeException) {
                            throw ((RuntimeException) this.f29527g);
                        }
                        throw ((Error) this.f29527g);
                    }
                    throw ((IOException) this.f29527g);
                }
                interfaceC2562f = this.f29526f;
                if (interfaceC2562f == null) {
                    try {
                        interfaceC2562f = a();
                        this.f29526f = interfaceC2562f;
                    } catch (IOException | Error | RuntimeException e2) {
                        H.a(e2);
                        this.f29527g = e2;
                        throw e2;
                    }
                }
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (this.f29525e) {
            interfaceC2562f.cancel();
        }
        return a(interfaceC2562f.execute());
    }

    @Override // retrofit2.InterfaceC2578b
    public v<T> clone() {
        return new v<>(this.f29521a, this.f29522b, this.f29523c, this.f29524d);
    }

    private InterfaceC2562f a() throws IOException {
        InterfaceC2562f a2 = this.f29523c.a(this.f29521a.a(this.f29522b));
        if (a2 != null) {
            return a2;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public D<T> a(M m) throws IOException {
        O a2 = m.a();
        M.a w = m.w();
        w.a(new b(a2.c(), a2.b()));
        M a3 = w.a();
        int c2 = a3.c();
        if (c2 < 200 || c2 >= 300) {
            try {
                return D.a(H.a(a2), a3);
            } finally {
                a2.close();
            }
        }
        if (c2 != 204 && c2 != 205) {
            a aVar = new a(a2);
            try {
                return D.a(this.f29524d.a(aVar), a3);
            } catch (RuntimeException e2) {
                aVar.s();
                throw e2;
            }
        }
        a2.close();
        return D.a((Object) null, a3);
    }
}
