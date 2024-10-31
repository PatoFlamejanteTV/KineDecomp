package com.squareup.okhttp.internal.framed;

import android.support.v4.internal.view.SupportMenu;
import android.support.v7.widget.ActivityChooserView;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.framed.InterfaceC2384a;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okio.ByteString;

/* compiled from: FramedConnection.java */
/* loaded from: classes3.dex */
public final class j implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    private static final ExecutorService f25313a = new ThreadPoolExecutor(0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 60, TimeUnit.SECONDS, new SynchronousQueue(), com.squareup.okhttp.a.o.a("OkHttp FramedConnection", true));

    /* renamed from: b, reason: collision with root package name */
    final Protocol f25314b;

    /* renamed from: c, reason: collision with root package name */
    final boolean f25315c;

    /* renamed from: d, reason: collision with root package name */
    private final b f25316d;

    /* renamed from: e, reason: collision with root package name */
    private final Map<Integer, p> f25317e;

    /* renamed from: f, reason: collision with root package name */
    private final String f25318f;

    /* renamed from: g, reason: collision with root package name */
    private int f25319g;

    /* renamed from: h, reason: collision with root package name */
    private int f25320h;
    private boolean i;
    private long j;
    private final ExecutorService k;
    private Map<Integer, x> l;
    private final z m;
    private int n;
    long o;
    long p;
    A q;
    final A r;
    private boolean s;
    final C t;
    final Socket u;
    final InterfaceC2385b v;
    final c w;
    private final Set<Integer> x;

    /* compiled from: FramedConnection.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private Socket f25321a;

        /* renamed from: b, reason: collision with root package name */
        private String f25322b;

        /* renamed from: c, reason: collision with root package name */
        private okio.i f25323c;

        /* renamed from: d, reason: collision with root package name */
        private okio.h f25324d;

        /* renamed from: e, reason: collision with root package name */
        private b f25325e = b.f25329a;

        /* renamed from: f, reason: collision with root package name */
        private Protocol f25326f = Protocol.SPDY_3;

        /* renamed from: g, reason: collision with root package name */
        private z f25327g = z.f25410a;

        /* renamed from: h, reason: collision with root package name */
        private boolean f25328h;

        public a(boolean z) throws IOException {
            this.f25328h = z;
        }

        public a a(Socket socket, String str, okio.i iVar, okio.h hVar) {
            this.f25321a = socket;
            this.f25322b = str;
            this.f25323c = iVar;
            this.f25324d = hVar;
            return this;
        }

        public a a(Protocol protocol) {
            this.f25326f = protocol;
            return this;
        }

        public j a() throws IOException {
            return new j(this, null);
        }
    }

    /* compiled from: FramedConnection.java */
    /* loaded from: classes3.dex */
    public static abstract class b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f25329a = new k();

        public void a(j jVar) {
        }

        public abstract void a(p pVar) throws IOException;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FramedConnection.java */
    /* loaded from: classes3.dex */
    public class c extends com.squareup.okhttp.a.j implements InterfaceC2384a.InterfaceC0130a {

        /* renamed from: b, reason: collision with root package name */
        final InterfaceC2384a f25330b;

        /* synthetic */ c(j jVar, InterfaceC2384a interfaceC2384a, C2386c c2386c) {
            this(interfaceC2384a);
        }

        @Override // com.squareup.okhttp.internal.framed.InterfaceC2384a.InterfaceC0130a
        public void a(int i, int i2, int i3, boolean z) {
        }

        @Override // com.squareup.okhttp.internal.framed.InterfaceC2384a.InterfaceC0130a
        public void a(boolean z, int i, okio.i iVar, int i2) throws IOException {
            if (!j.this.c(i)) {
                p a2 = j.this.a(i);
                if (a2 == null) {
                    j.this.c(i, ErrorCode.INVALID_STREAM);
                    iVar.skip(i2);
                    return;
                } else {
                    a2.a(iVar, i2);
                    if (z) {
                        a2.h();
                        return;
                    }
                    return;
                }
            }
            j.this.a(i, iVar, i2, z);
        }

        @Override // com.squareup.okhttp.internal.framed.InterfaceC2384a.InterfaceC0130a
        public void b() {
        }

        @Override // com.squareup.okhttp.a.j
        protected void c() {
            ErrorCode errorCode;
            ErrorCode errorCode2;
            j jVar;
            ErrorCode errorCode3 = ErrorCode.INTERNAL_ERROR;
            try {
                try {
                    if (!j.this.f25315c) {
                        this.f25330b.H();
                    }
                    do {
                    } while (this.f25330b.a(this));
                    errorCode2 = ErrorCode.NO_ERROR;
                } catch (IOException unused) {
                } catch (Throwable th) {
                    th = th;
                    errorCode = errorCode3;
                    try {
                        j.this.a(errorCode, errorCode3);
                    } catch (IOException unused2) {
                    }
                    com.squareup.okhttp.a.o.a(this.f25330b);
                    throw th;
                }
                try {
                    errorCode3 = ErrorCode.CANCEL;
                    jVar = j.this;
                } catch (IOException unused3) {
                    errorCode2 = ErrorCode.PROTOCOL_ERROR;
                    errorCode3 = ErrorCode.PROTOCOL_ERROR;
                    jVar = j.this;
                    jVar.a(errorCode2, errorCode3);
                    com.squareup.okhttp.a.o.a(this.f25330b);
                }
                jVar.a(errorCode2, errorCode3);
                com.squareup.okhttp.a.o.a(this.f25330b);
            } catch (Throwable th2) {
                errorCode = errorCode2;
                th = th2;
                j.this.a(errorCode, errorCode3);
                com.squareup.okhttp.a.o.a(this.f25330b);
                throw th;
            }
        }

        private c(InterfaceC2384a interfaceC2384a) {
            super("OkHttp %s", j.this.f25318f);
            this.f25330b = interfaceC2384a;
        }

        @Override // com.squareup.okhttp.internal.framed.InterfaceC2384a.InterfaceC0130a
        public void a(boolean z, boolean z2, int i, int i2, List<q> list, HeadersMode headersMode) {
            if (j.this.c(i)) {
                j.this.a(i, list, z2);
                return;
            }
            synchronized (j.this) {
                if (j.this.i) {
                    return;
                }
                p a2 = j.this.a(i);
                if (a2 == null) {
                    if (!headersMode.failIfStreamAbsent()) {
                        if (i <= j.this.f25319g) {
                            return;
                        }
                        if (i % 2 == j.this.f25320h % 2) {
                            return;
                        }
                        p pVar = new p(i, j.this, z, z2, list);
                        j.this.f25319g = i;
                        j.this.f25317e.put(Integer.valueOf(i), pVar);
                        j.f25313a.execute(new l(this, "OkHttp %s stream %d", new Object[]{j.this.f25318f, Integer.valueOf(i)}, pVar));
                        return;
                    }
                    j.this.c(i, ErrorCode.INVALID_STREAM);
                    return;
                }
                if (headersMode.failIfStreamPresent()) {
                    a2.b(ErrorCode.PROTOCOL_ERROR);
                    j.this.b(i);
                } else {
                    a2.a(list, headersMode);
                    if (z2) {
                        a2.h();
                    }
                }
            }
        }

        @Override // com.squareup.okhttp.internal.framed.InterfaceC2384a.InterfaceC0130a
        public void a(int i, ErrorCode errorCode) {
            if (j.this.c(i)) {
                j.this.d(i, errorCode);
                return;
            }
            p b2 = j.this.b(i);
            if (b2 != null) {
                b2.c(errorCode);
            }
        }

        @Override // com.squareup.okhttp.internal.framed.InterfaceC2384a.InterfaceC0130a
        public void a(boolean z, A a2) {
            p[] pVarArr;
            long j;
            int i;
            synchronized (j.this) {
                int c2 = j.this.r.c(65536);
                if (z) {
                    j.this.r.a();
                }
                j.this.r.a(a2);
                if (j.this.b() == Protocol.HTTP_2) {
                    a(a2);
                }
                int c3 = j.this.r.c(65536);
                pVarArr = null;
                if (c3 == -1 || c3 == c2) {
                    j = 0;
                } else {
                    j = c3 - c2;
                    if (!j.this.s) {
                        j.this.g(j);
                        j.this.s = true;
                    }
                    if (!j.this.f25317e.isEmpty()) {
                        pVarArr = (p[]) j.this.f25317e.values().toArray(new p[j.this.f25317e.size()]);
                    }
                }
                j.f25313a.execute(new m(this, "OkHttp %s settings", j.this.f25318f));
            }
            if (pVarArr == null || j == 0) {
                return;
            }
            for (p pVar : pVarArr) {
                synchronized (pVar) {
                    pVar.a(j);
                }
            }
        }

        private void a(A a2) {
            j.f25313a.execute(new n(this, "OkHttp %s ACK Settings", new Object[]{j.this.f25318f}, a2));
        }

        @Override // com.squareup.okhttp.internal.framed.InterfaceC2384a.InterfaceC0130a
        public void a(boolean z, int i, int i2) {
            if (z) {
                x d2 = j.this.d(i);
                if (d2 != null) {
                    d2.b();
                    return;
                }
                return;
            }
            j.this.b(true, i, i2, null);
        }

        @Override // com.squareup.okhttp.internal.framed.InterfaceC2384a.InterfaceC0130a
        public void a(int i, ErrorCode errorCode, ByteString byteString) {
            p[] pVarArr;
            byteString.size();
            synchronized (j.this) {
                pVarArr = (p[]) j.this.f25317e.values().toArray(new p[j.this.f25317e.size()]);
                j.this.i = true;
            }
            for (p pVar : pVarArr) {
                if (pVar.a() > i && pVar.e()) {
                    pVar.c(ErrorCode.REFUSED_STREAM);
                    j.this.b(pVar.a());
                }
            }
        }

        @Override // com.squareup.okhttp.internal.framed.InterfaceC2384a.InterfaceC0130a
        public void a(int i, long j) {
            if (i == 0) {
                synchronized (j.this) {
                    j.this.p += j;
                    j.this.notifyAll();
                }
                return;
            }
            p a2 = j.this.a(i);
            if (a2 != null) {
                synchronized (a2) {
                    a2.a(j);
                }
            }
        }

        @Override // com.squareup.okhttp.internal.framed.InterfaceC2384a.InterfaceC0130a
        public void a(int i, int i2, List<q> list) {
            j.this.a(i2, list);
        }
    }

    /* synthetic */ j(a aVar, C2386c c2386c) throws IOException {
        this(aVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        a(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    public void flush() throws IOException {
        this.v.flush();
    }

    public void r() throws IOException {
        this.v.q();
        this.v.b(this.q);
        if (this.q.c(65536) != 65536) {
            this.v.a(0, r0 - 65536);
        }
    }

    private j(a aVar) throws IOException {
        this.f25317e = new HashMap();
        this.j = System.nanoTime();
        this.o = 0L;
        this.q = new A();
        this.r = new A();
        this.s = false;
        this.x = new LinkedHashSet();
        this.f25314b = aVar.f25326f;
        this.m = aVar.f25327g;
        this.f25315c = aVar.f25328h;
        this.f25316d = aVar.f25325e;
        this.f25320h = aVar.f25328h ? 1 : 2;
        if (aVar.f25328h && this.f25314b == Protocol.HTTP_2) {
            this.f25320h += 2;
        }
        this.n = aVar.f25328h ? 1 : 2;
        if (aVar.f25328h) {
            this.q.a(7, 0, 16777216);
        }
        this.f25318f = aVar.f25322b;
        Protocol protocol = this.f25314b;
        C2386c c2386c = null;
        if (protocol == Protocol.HTTP_2) {
            this.t = new s();
            this.k = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), com.squareup.okhttp.a.o.a(String.format("OkHttp %s Push Observer", this.f25318f), true));
            this.r.a(7, 0, SupportMenu.USER_MASK);
            this.r.a(5, 0, 16384);
        } else if (protocol == Protocol.SPDY_3) {
            this.t = new B();
            this.k = null;
        } else {
            throw new AssertionError(protocol);
        }
        this.p = this.r.c(65536);
        this.u = aVar.f25321a;
        this.v = this.t.a(aVar.f25324d, this.f25315c);
        this.w = new c(this, this.t.a(aVar.f25323c, this.f25315c), c2386c);
        new Thread(this.w).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized x d(int i) {
        return this.l != null ? this.l.remove(Integer.valueOf(i)) : null;
    }

    void g(long j) {
        this.p += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i, ErrorCode errorCode) {
        this.k.execute(new i(this, "OkHttp %s Push Reset[%s]", new Object[]{this.f25318f, Integer.valueOf(i)}, i, errorCode));
    }

    public synchronized int c() {
        return this.r.d(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i, ErrorCode errorCode) {
        f25313a.submit(new C2386c(this, "OkHttp %s stream %d", new Object[]{this.f25318f, Integer.valueOf(i)}, i, errorCode));
    }

    public Protocol b() {
        return this.f25314b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i, long j) {
        f25313a.execute(new d(this, "OkHttp Window Update %s stream %d", new Object[]{this.f25318f, Integer.valueOf(i)}, i, j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(int i) {
        return this.f25314b == Protocol.HTTP_2 && i != 0 && (i & 1) == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized p b(int i) {
        p remove;
        remove = this.f25317e.remove(Integer.valueOf(i));
        if (remove != null && this.f25317e.isEmpty()) {
            a(true);
        }
        notifyAll();
        return remove;
    }

    synchronized p a(int i) {
        return this.f25317e.get(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i, ErrorCode errorCode) throws IOException {
        this.v.a(i, errorCode);
    }

    private synchronized void a(boolean z) {
        long nanoTime;
        if (z) {
            try {
                nanoTime = System.nanoTime();
            } catch (Throwable th) {
                throw th;
            }
        } else {
            nanoTime = Long.MAX_VALUE;
        }
        this.j = nanoTime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, int i, int i2, x xVar) {
        f25313a.execute(new e(this, "OkHttp %s ping %08x%08x", new Object[]{this.f25318f, Integer.valueOf(i), Integer.valueOf(i2)}, z, i, i2, xVar));
    }

    public p a(List<q> list, boolean z, boolean z2) throws IOException {
        return a(0, list, z, z2);
    }

    private p a(int i, List<q> list, boolean z, boolean z2) throws IOException {
        int i2;
        p pVar;
        boolean z3 = !z;
        boolean z4 = !z2;
        synchronized (this.v) {
            synchronized (this) {
                if (!this.i) {
                    i2 = this.f25320h;
                    this.f25320h += 2;
                    pVar = new p(i2, this, z3, z4, list);
                    if (pVar.f()) {
                        this.f25317e.put(Integer.valueOf(i2), pVar);
                        a(false);
                    }
                } else {
                    throw new IOException("shutdown");
                }
            }
            if (i == 0) {
                this.v.a(z3, z4, i2, i, list);
            } else if (!this.f25315c) {
                this.v.a(i, i2, list);
            } else {
                throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
            }
        }
        if (!z) {
            this.v.flush();
        }
        return pVar;
    }

    public void a(int i, boolean z, okio.g gVar, long j) throws IOException {
        int min;
        long j2;
        if (j == 0) {
            this.v.a(z, i, gVar, 0);
            return;
        }
        while (j > 0) {
            synchronized (this) {
                while (this.p <= 0) {
                    try {
                        if (this.f25317e.containsKey(Integer.valueOf(i))) {
                            wait();
                        } else {
                            throw new IOException("stream closed");
                        }
                    } catch (InterruptedException unused) {
                        throw new InterruptedIOException();
                    }
                }
                min = Math.min((int) Math.min(j, this.p), this.v.t());
                j2 = min;
                this.p -= j2;
            }
            j -= j2;
            this.v.a(z && j == 0, i, gVar, min);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, int i, int i2, x xVar) throws IOException {
        synchronized (this.v) {
            if (xVar != null) {
                xVar.c();
            }
            this.v.a(z, i, i2);
        }
    }

    public void a(ErrorCode errorCode) throws IOException {
        synchronized (this.v) {
            synchronized (this) {
                if (this.i) {
                    return;
                }
                this.i = true;
                this.v.a(this.f25319g, errorCode, com.squareup.okhttp.a.o.f25217a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ErrorCode errorCode, ErrorCode errorCode2) throws IOException {
        int i;
        p[] pVarArr;
        x[] xVarArr = null;
        try {
            a(errorCode);
            e = null;
        } catch (IOException e2) {
            e = e2;
        }
        synchronized (this) {
            if (this.f25317e.isEmpty()) {
                pVarArr = null;
            } else {
                pVarArr = (p[]) this.f25317e.values().toArray(new p[this.f25317e.size()]);
                this.f25317e.clear();
                a(false);
            }
            if (this.l != null) {
                x[] xVarArr2 = (x[]) this.l.values().toArray(new x[this.l.size()]);
                this.l = null;
                xVarArr = xVarArr2;
            }
        }
        if (pVarArr != null) {
            IOException iOException = e;
            for (p pVar : pVarArr) {
                try {
                    pVar.a(errorCode2);
                } catch (IOException e3) {
                    if (iOException != null) {
                        iOException = e3;
                    }
                }
            }
            e = iOException;
        }
        if (xVarArr != null) {
            for (x xVar : xVarArr) {
                xVar.a();
            }
        }
        try {
            this.v.close();
        } catch (IOException e4) {
            if (e == null) {
                e = e4;
            }
        }
        try {
            this.u.close();
        } catch (IOException e5) {
            e = e5;
        }
        if (e != null) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, List<q> list) {
        synchronized (this) {
            if (this.x.contains(Integer.valueOf(i))) {
                c(i, ErrorCode.PROTOCOL_ERROR);
            } else {
                this.x.add(Integer.valueOf(i));
                this.k.execute(new f(this, "OkHttp %s Push Request[%s]", new Object[]{this.f25318f, Integer.valueOf(i)}, i, list));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, List<q> list, boolean z) {
        this.k.execute(new g(this, "OkHttp %s Push Headers[%s]", new Object[]{this.f25318f, Integer.valueOf(i)}, i, list, z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, okio.i iVar, int i2, boolean z) throws IOException {
        okio.g gVar = new okio.g();
        long j = i2;
        iVar.c(j);
        iVar.b(gVar, j);
        if (gVar.size() == j) {
            this.k.execute(new h(this, "OkHttp %s Push Data[%s]", new Object[]{this.f25318f, Integer.valueOf(i)}, i, gVar, i2, z));
            return;
        }
        throw new IOException(gVar.size() + " != " + i2);
    }
}
