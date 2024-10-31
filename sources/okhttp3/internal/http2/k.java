package okhttp3.internal.http2;

import android.support.v4.internal.view.SupportMenu;
import android.support.v7.widget.ActivityChooserView;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.http2.p;
import okio.ByteString;

/* compiled from: Http2Connection.java */
/* loaded from: classes3.dex */
public final class k implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    private static final ExecutorService f29084a = new ThreadPoolExecutor(0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 60, TimeUnit.SECONDS, new SynchronousQueue(), okhttp3.a.e.a("OkHttp Http2Connection", true));

    /* renamed from: b, reason: collision with root package name */
    final boolean f29085b;

    /* renamed from: c, reason: collision with root package name */
    final b f29086c;

    /* renamed from: e, reason: collision with root package name */
    final String f29088e;

    /* renamed from: f, reason: collision with root package name */
    int f29089f;

    /* renamed from: g, reason: collision with root package name */
    int f29090g;

    /* renamed from: h, reason: collision with root package name */
    boolean f29091h;
    private final ScheduledExecutorService i;
    private final ExecutorService j;
    final u k;
    private boolean l;
    long n;
    final Socket r;
    final r s;
    final d t;

    /* renamed from: d, reason: collision with root package name */
    final Map<Integer, q> f29087d = new LinkedHashMap();
    long m = 0;
    v o = new v();
    final v p = new v();
    boolean q = false;
    final Set<Integer> u = new LinkedHashSet();

    /* compiled from: Http2Connection.java */
    /* loaded from: classes3.dex */
    public static abstract class b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f29100a = new l();

        public void a(k kVar) {
        }

        public abstract void a(q qVar) throws IOException;
    }

    /* compiled from: Http2Connection.java */
    /* loaded from: classes3.dex */
    final class c extends okhttp3.a.b {

        /* renamed from: b, reason: collision with root package name */
        final boolean f29101b;

        /* renamed from: c, reason: collision with root package name */
        final int f29102c;

        /* renamed from: d, reason: collision with root package name */
        final int f29103d;

        c(boolean z, int i, int i2) {
            super("OkHttp %s ping %08x%08x", k.this.f29088e, Integer.valueOf(i), Integer.valueOf(i2));
            this.f29101b = z;
            this.f29102c = i;
            this.f29103d = i2;
        }

        @Override // okhttp3.a.b
        public void c() {
            k.this.b(this.f29101b, this.f29102c, this.f29103d);
        }
    }

    k(a aVar) {
        this.k = aVar.f29097f;
        boolean z = aVar.f29098g;
        this.f29085b = z;
        this.f29086c = aVar.f29096e;
        this.f29090g = z ? 1 : 2;
        if (aVar.f29098g) {
            this.f29090g += 2;
        }
        if (aVar.f29098g) {
            this.o.a(7, 16777216);
        }
        this.f29088e = aVar.f29093b;
        this.i = new ScheduledThreadPoolExecutor(1, okhttp3.a.e.a(okhttp3.a.e.a("OkHttp %s Writer", this.f29088e), false));
        if (aVar.f29099h != 0) {
            ScheduledExecutorService scheduledExecutorService = this.i;
            c cVar = new c(false, 0, 0);
            int i = aVar.f29099h;
            scheduledExecutorService.scheduleAtFixedRate(cVar, i, i, TimeUnit.MILLISECONDS);
        }
        this.j = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), okhttp3.a.e.a(okhttp3.a.e.a("OkHttp %s Push Observer", this.f29088e), true));
        this.p.a(7, SupportMenu.USER_MASK);
        this.p.a(5, 16384);
        this.n = this.p.c();
        this.r = aVar.f29092a;
        this.s = new r(aVar.f29095d, this.f29085b);
        this.t = new d(new p(aVar.f29094c, this.f29085b));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        try {
            a(ErrorCode.PROTOCOL_ERROR, ErrorCode.PROTOCOL_ERROR);
        } catch (IOException unused) {
        }
    }

    boolean b(int i) {
        return i != 0 && (i & 1) == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized q c(int i) {
        q remove;
        remove = this.f29087d.remove(Integer.valueOf(i));
        notifyAll();
        return remove;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        a(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    public void flush() throws IOException {
        this.s.flush();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void g(long j) {
        this.m += j;
        if (this.m >= this.o.c() / 2) {
            c(0, this.m);
            this.m = 0L;
        }
    }

    public void r() throws IOException {
        a(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0043 A[Catch: all -> 0x0075, TryCatch #0 {, blocks: (B:6:0x0007, B:8:0x000e, B:9:0x0013, B:11:0x0017, B:13:0x002b, B:15:0x0033, B:19:0x003d, B:21:0x0043, B:22:0x004c, B:36:0x006f, B:37:0x0074), top: B:5:0x0007, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private okhttp3.internal.http2.q b(int r11, java.util.List<okhttp3.internal.http2.a> r12, boolean r13) throws java.io.IOException {
        /*
            r10 = this;
            r6 = r13 ^ 1
            r4 = 0
            okhttp3.internal.http2.r r7 = r10.s
            monitor-enter(r7)
            monitor-enter(r10)     // Catch: java.lang.Throwable -> L78
            int r0 = r10.f29090g     // Catch: java.lang.Throwable -> L75
            r1 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 <= r1) goto L13
            okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.REFUSED_STREAM     // Catch: java.lang.Throwable -> L75
            r10.a(r0)     // Catch: java.lang.Throwable -> L75
        L13:
            boolean r0 = r10.f29091h     // Catch: java.lang.Throwable -> L75
            if (r0 != 0) goto L6f
            int r8 = r10.f29090g     // Catch: java.lang.Throwable -> L75
            int r0 = r10.f29090g     // Catch: java.lang.Throwable -> L75
            int r0 = r0 + 2
            r10.f29090g = r0     // Catch: java.lang.Throwable -> L75
            okhttp3.internal.http2.q r9 = new okhttp3.internal.http2.q     // Catch: java.lang.Throwable -> L75
            r5 = 0
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r0.<init>(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L75
            if (r13 == 0) goto L3c
            long r0 = r10.n     // Catch: java.lang.Throwable -> L75
            r2 = 0
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto L3c
            long r0 = r9.f29124b     // Catch: java.lang.Throwable -> L75
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 != 0) goto L3a
            goto L3c
        L3a:
            r13 = 0
            goto L3d
        L3c:
            r13 = 1
        L3d:
            boolean r0 = r9.g()     // Catch: java.lang.Throwable -> L75
            if (r0 == 0) goto L4c
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.q> r0 = r10.f29087d     // Catch: java.lang.Throwable -> L75
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> L75
            r0.put(r1, r9)     // Catch: java.lang.Throwable -> L75
        L4c:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L75
            if (r11 != 0) goto L55
            okhttp3.internal.http2.r r0 = r10.s     // Catch: java.lang.Throwable -> L78
            r0.a(r6, r8, r11, r12)     // Catch: java.lang.Throwable -> L78
            goto L5e
        L55:
            boolean r0 = r10.f29085b     // Catch: java.lang.Throwable -> L78
            if (r0 != 0) goto L67
            okhttp3.internal.http2.r r0 = r10.s     // Catch: java.lang.Throwable -> L78
            r0.a(r11, r8, r12)     // Catch: java.lang.Throwable -> L78
        L5e:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L78
            if (r13 == 0) goto L66
            okhttp3.internal.http2.r r11 = r10.s
            r11.flush()
        L66:
            return r9
        L67:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L78
            java.lang.String r12 = "client streams shouldn't have associated stream IDs"
            r11.<init>(r12)     // Catch: java.lang.Throwable -> L78
            throw r11     // Catch: java.lang.Throwable -> L78
        L6f:
            okhttp3.internal.http2.ConnectionShutdownException r11 = new okhttp3.internal.http2.ConnectionShutdownException     // Catch: java.lang.Throwable -> L75
            r11.<init>()     // Catch: java.lang.Throwable -> L75
            throw r11     // Catch: java.lang.Throwable -> L75
        L75:
            r11 = move-exception
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L75
            throw r11     // Catch: java.lang.Throwable -> L78
        L78:
            r11 = move-exception
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L78
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.k.b(int, java.util.List, boolean):okhttp3.internal.http2.q");
    }

    /* compiled from: Http2Connection.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        Socket f29092a;

        /* renamed from: b, reason: collision with root package name */
        String f29093b;

        /* renamed from: c, reason: collision with root package name */
        okio.i f29094c;

        /* renamed from: d, reason: collision with root package name */
        okio.h f29095d;

        /* renamed from: e, reason: collision with root package name */
        b f29096e = b.f29100a;

        /* renamed from: f, reason: collision with root package name */
        u f29097f = u.f29155a;

        /* renamed from: g, reason: collision with root package name */
        boolean f29098g;

        /* renamed from: h, reason: collision with root package name */
        int f29099h;

        public a(boolean z) {
            this.f29098g = z;
        }

        public a a(Socket socket, String str, okio.i iVar, okio.h hVar) {
            this.f29092a = socket;
            this.f29093b = str;
            this.f29094c = iVar;
            this.f29095d = hVar;
            return this;
        }

        public a a(b bVar) {
            this.f29096e = bVar;
            return this;
        }

        public a a(int i) {
            this.f29099h = i;
            return this;
        }

        public k a() {
            return new k(this);
        }
    }

    synchronized q a(int i) {
        return this.f29087d.get(Integer.valueOf(i));
    }

    public synchronized int c() {
        return this.p.b(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public q a(List<okhttp3.internal.http2.a> list, boolean z) throws IOException {
        return b(0, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i, ErrorCode errorCode) {
        try {
            this.i.execute(new e(this, "OkHttp %s stream %d", new Object[]{this.f29088e, Integer.valueOf(i)}, i, errorCode));
        } catch (RejectedExecutionException unused) {
        }
    }

    public void a(int i, boolean z, okio.g gVar, long j) throws IOException {
        int min;
        long j2;
        if (j == 0) {
            this.s.a(z, i, gVar, 0);
            return;
        }
        while (j > 0) {
            synchronized (this) {
                while (this.n <= 0) {
                    try {
                        if (this.f29087d.containsKey(Integer.valueOf(i))) {
                            wait();
                        } else {
                            throw new IOException("stream closed");
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                }
                min = Math.min((int) Math.min(j, this.n), this.s.t());
                j2 = min;
                this.n -= j2;
            }
            j -= j2;
            this.s.a(z && j == 0, i, gVar, min);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i, long j) {
        try {
            this.i.execute(new f(this, "OkHttp Window Update %s stream %d", new Object[]{this.f29088e, Integer.valueOf(i)}, i, j));
        } catch (RejectedExecutionException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http2Connection.java */
    /* loaded from: classes3.dex */
    public class d extends okhttp3.a.b implements p.b {

        /* renamed from: b, reason: collision with root package name */
        final p f29105b;

        d(p pVar) {
            super("OkHttp %s", k.this.f29088e);
            this.f29105b = pVar;
        }

        @Override // okhttp3.internal.http2.p.b
        public void a(int i, int i2, int i3, boolean z) {
        }

        @Override // okhttp3.internal.http2.p.b
        public void a(boolean z, int i, okio.i iVar, int i2) throws IOException {
            if (k.this.b(i)) {
                k.this.a(i, iVar, i2, z);
                return;
            }
            q a2 = k.this.a(i);
            if (a2 == null) {
                k.this.c(i, ErrorCode.PROTOCOL_ERROR);
                long j = i2;
                k.this.g(j);
                iVar.skip(j);
                return;
            }
            a2.a(iVar, i2);
            if (z) {
                a2.i();
            }
        }

        @Override // okhttp3.internal.http2.p.b
        public void b() {
        }

        @Override // okhttp3.a.b
        protected void c() {
            ErrorCode errorCode;
            k kVar;
            ErrorCode errorCode2 = ErrorCode.INTERNAL_ERROR;
            try {
                try {
                    try {
                        this.f29105b.a(this);
                        do {
                        } while (this.f29105b.a(false, (p.b) this));
                        errorCode = ErrorCode.NO_ERROR;
                    } catch (IOException unused) {
                    } catch (Throwable th) {
                        th = th;
                        errorCode = errorCode2;
                        try {
                            k.this.a(errorCode, errorCode2);
                        } catch (IOException unused2) {
                        }
                        okhttp3.a.e.a(this.f29105b);
                        throw th;
                    }
                    try {
                        errorCode2 = ErrorCode.CANCEL;
                        kVar = k.this;
                    } catch (IOException unused3) {
                        errorCode = ErrorCode.PROTOCOL_ERROR;
                        errorCode2 = ErrorCode.PROTOCOL_ERROR;
                        kVar = k.this;
                        kVar.a(errorCode, errorCode2);
                        okhttp3.a.e.a(this.f29105b);
                    }
                    kVar.a(errorCode, errorCode2);
                } catch (IOException unused4) {
                }
                okhttp3.a.e.a(this.f29105b);
            } catch (Throwable th2) {
                th = th2;
            }
        }

        @Override // okhttp3.internal.http2.p.b
        public void a(boolean z, int i, int i2, List<okhttp3.internal.http2.a> list) {
            if (k.this.b(i)) {
                k.this.a(i, list, z);
                return;
            }
            synchronized (k.this) {
                q a2 = k.this.a(i);
                if (a2 == null) {
                    if (k.this.f29091h) {
                        return;
                    }
                    if (i <= k.this.f29089f) {
                        return;
                    }
                    if (i % 2 == k.this.f29090g % 2) {
                        return;
                    }
                    q qVar = new q(i, k.this, false, z, okhttp3.a.e.b(list));
                    k.this.f29089f = i;
                    k.this.f29087d.put(Integer.valueOf(i), qVar);
                    k.f29084a.execute(new m(this, "OkHttp %s stream %d", new Object[]{k.this.f29088e, Integer.valueOf(i)}, qVar));
                    return;
                }
                a2.a(list);
                if (z) {
                    a2.i();
                }
            }
        }

        @Override // okhttp3.internal.http2.p.b
        public void a(int i, ErrorCode errorCode) {
            if (k.this.b(i)) {
                k.this.a(i, errorCode);
                return;
            }
            q c2 = k.this.c(i);
            if (c2 != null) {
                c2.c(errorCode);
            }
        }

        @Override // okhttp3.internal.http2.p.b
        public void a(boolean z, v vVar) {
            q[] qVarArr;
            long j;
            int i;
            synchronized (k.this) {
                int c2 = k.this.p.c();
                if (z) {
                    k.this.p.a();
                }
                k.this.p.a(vVar);
                a(vVar);
                int c3 = k.this.p.c();
                qVarArr = null;
                if (c3 == -1 || c3 == c2) {
                    j = 0;
                } else {
                    j = c3 - c2;
                    if (!k.this.q) {
                        k.this.q = true;
                    }
                    if (!k.this.f29087d.isEmpty()) {
                        qVarArr = (q[]) k.this.f29087d.values().toArray(new q[k.this.f29087d.size()]);
                    }
                }
                k.f29084a.execute(new n(this, "OkHttp %s settings", k.this.f29088e));
            }
            if (qVarArr == null || j == 0) {
                return;
            }
            for (q qVar : qVarArr) {
                synchronized (qVar) {
                    qVar.a(j);
                }
            }
        }

        private void a(v vVar) {
            try {
                k.this.i.execute(new o(this, "OkHttp %s ACK Settings", new Object[]{k.this.f29088e}, vVar));
            } catch (RejectedExecutionException unused) {
            }
        }

        @Override // okhttp3.internal.http2.p.b
        public void a(boolean z, int i, int i2) {
            if (!z) {
                try {
                    k.this.i.execute(new c(true, i, i2));
                } catch (RejectedExecutionException unused) {
                }
            } else {
                synchronized (k.this) {
                    k.this.l = false;
                    k.this.notifyAll();
                }
            }
        }

        @Override // okhttp3.internal.http2.p.b
        public void a(int i, ErrorCode errorCode, ByteString byteString) {
            q[] qVarArr;
            byteString.size();
            synchronized (k.this) {
                qVarArr = (q[]) k.this.f29087d.values().toArray(new q[k.this.f29087d.size()]);
                k.this.f29091h = true;
            }
            for (q qVar : qVarArr) {
                if (qVar.c() > i && qVar.f()) {
                    qVar.c(ErrorCode.REFUSED_STREAM);
                    k.this.c(qVar.c());
                }
            }
        }

        @Override // okhttp3.internal.http2.p.b
        public void a(int i, long j) {
            if (i == 0) {
                synchronized (k.this) {
                    k.this.n += j;
                    k.this.notifyAll();
                }
                return;
            }
            q a2 = k.this.a(i);
            if (a2 != null) {
                synchronized (a2) {
                    a2.a(j);
                }
            }
        }

        @Override // okhttp3.internal.http2.p.b
        public void a(int i, int i2, List<okhttp3.internal.http2.a> list) {
            k.this.a(i2, list);
        }
    }

    public void a(ErrorCode errorCode) throws IOException {
        synchronized (this.s) {
            synchronized (this) {
                if (this.f29091h) {
                    return;
                }
                this.f29091h = true;
                this.s.a(this.f29089f, errorCode, okhttp3.a.e.f28954a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i, ErrorCode errorCode) throws IOException {
        this.s.a(i, errorCode);
    }

    void b(boolean z, int i, int i2) {
        boolean z2;
        if (!z) {
            synchronized (this) {
                z2 = this.l;
                this.l = true;
            }
            if (z2) {
                s();
                return;
            }
        }
        try {
            this.s.a(z, i, i2);
        } catch (IOException unused) {
            s();
        }
    }

    void a(ErrorCode errorCode, ErrorCode errorCode2) throws IOException {
        q[] qVarArr = null;
        try {
            a(errorCode);
            e = null;
        } catch (IOException e2) {
            e = e2;
        }
        synchronized (this) {
            if (!this.f29087d.isEmpty()) {
                qVarArr = (q[]) this.f29087d.values().toArray(new q[this.f29087d.size()]);
                this.f29087d.clear();
            }
        }
        if (qVarArr != null) {
            for (q qVar : qVarArr) {
                try {
                    qVar.a(errorCode2);
                } catch (IOException e3) {
                    if (e != null) {
                        e = e3;
                    }
                }
            }
        }
        try {
            this.s.close();
        } catch (IOException e4) {
            if (e == null) {
                e = e4;
            }
        }
        try {
            this.r.close();
        } catch (IOException e5) {
            e = e5;
        }
        this.i.shutdown();
        this.j.shutdown();
        if (e != null) {
            throw e;
        }
    }

    public synchronized boolean b() {
        return this.f29091h;
    }

    void a(boolean z) throws IOException {
        if (z) {
            this.s.q();
            this.s.b(this.o);
            if (this.o.c() != 65535) {
                this.s.a(0, r6 - SupportMenu.USER_MASK);
            }
        }
        new Thread(this.t).start();
    }

    void a(int i, List<okhttp3.internal.http2.a> list) {
        synchronized (this) {
            if (this.u.contains(Integer.valueOf(i))) {
                c(i, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.u.add(Integer.valueOf(i));
            try {
                a(new g(this, "OkHttp %s Push Request[%s]", new Object[]{this.f29088e, Integer.valueOf(i)}, i, list));
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    void a(int i, List<okhttp3.internal.http2.a> list, boolean z) {
        try {
            a(new h(this, "OkHttp %s Push Headers[%s]", new Object[]{this.f29088e, Integer.valueOf(i)}, i, list, z));
        } catch (RejectedExecutionException unused) {
        }
    }

    void a(int i, okio.i iVar, int i2, boolean z) throws IOException {
        okio.g gVar = new okio.g();
        long j = i2;
        iVar.c(j);
        iVar.b(gVar, j);
        if (gVar.size() == j) {
            a(new i(this, "OkHttp %s Push Data[%s]", new Object[]{this.f29088e, Integer.valueOf(i)}, i, gVar, i2, z));
            return;
        }
        throw new IOException(gVar.size() + " != " + i2);
    }

    void a(int i, ErrorCode errorCode) {
        a(new j(this, "OkHttp %s Push Reset[%s]", new Object[]{this.f29088e, Integer.valueOf(i)}, i, errorCode));
    }

    private synchronized void a(okhttp3.a.b bVar) {
        if (!b()) {
            this.j.execute(bVar);
        }
    }
}
