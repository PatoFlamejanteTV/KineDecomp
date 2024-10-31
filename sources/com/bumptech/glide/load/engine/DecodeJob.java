package com.bumptech.glide.load.engine;

import android.os.Build;
import android.support.v4.util.Pools;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.g.a.d;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.engine.InterfaceC0718h;
import com.bumptech.glide.load.engine.k;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
class DecodeJob<R> implements InterfaceC0718h.a, Runnable, Comparable<DecodeJob<?>>, d.c {
    private DataSource A;
    private com.bumptech.glide.load.a.d<?> B;
    private volatile InterfaceC0718h C;
    private volatile boolean D;
    private volatile boolean E;

    /* renamed from: d, reason: collision with root package name */
    private final d f8750d;

    /* renamed from: e, reason: collision with root package name */
    private final Pools.Pool<DecodeJob<?>> f8751e;

    /* renamed from: h, reason: collision with root package name */
    private com.bumptech.glide.e f8754h;
    private com.bumptech.glide.load.c i;
    private Priority j;
    private w k;
    private int l;
    private int m;
    private q n;
    private com.bumptech.glide.load.g o;
    private a<R> p;
    private int q;
    private Stage r;
    private RunReason s;
    private long t;
    private boolean u;
    private Object v;
    private Thread w;
    private com.bumptech.glide.load.c x;
    private com.bumptech.glide.load.c y;
    private Object z;

    /* renamed from: a, reason: collision with root package name */
    private final C0719i<R> f8747a = new C0719i<>();

    /* renamed from: b, reason: collision with root package name */
    private final List<Throwable> f8748b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.g.a.g f8749c = com.bumptech.glide.g.a.g.a();

    /* renamed from: f, reason: collision with root package name */
    private final c<?> f8752f = new c<>();

    /* renamed from: g, reason: collision with root package name */
    private final e f8753g = new e();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum RunReason {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum Stage {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a<R> {
        void a(DecodeJob<?> decodeJob);

        void a(E<R> e2, DataSource dataSource);

        void a(GlideException glideException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class b<Z> implements k.a<Z> {

        /* renamed from: a, reason: collision with root package name */
        private final DataSource f8755a;

        b(DataSource dataSource) {
            this.f8755a = dataSource;
        }

        @Override // com.bumptech.glide.load.engine.k.a
        public E<Z> a(E<Z> e2) {
            return DecodeJob.this.a(this.f8755a, e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        com.bumptech.glide.load.engine.b.a a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DecodeJob(d dVar, Pools.Pool<DecodeJob<?>> pool) {
        this.f8750d = dVar;
        this.f8751e = pool;
    }

    private int getPriority() {
        return this.j.ordinal();
    }

    private void h() {
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Retrieved data", this.t, "data: " + this.z + ", cache key: " + this.x + ", fetcher: " + this.B);
        }
        E<R> e2 = null;
        try {
            e2 = a(this.B, (com.bumptech.glide.load.a.d<?>) this.z, this.A);
        } catch (GlideException e3) {
            e3.setLoggingDetails(this.y, this.A);
            this.f8748b.add(e3);
        }
        if (e2 != null) {
            b(e2, this.A);
        } else {
            n();
        }
    }

    private InterfaceC0718h i() {
        int i = j.f8918b[this.r.ordinal()];
        if (i == 1) {
            return new F(this.f8747a, this);
        }
        if (i == 2) {
            return new C0715e(this.f8747a, this);
        }
        if (i == 3) {
            return new I(this.f8747a, this);
        }
        if (i == 4) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: " + this.r);
    }

    private void j() {
        p();
        this.p.a(new GlideException("Failed to load resource", new ArrayList(this.f8748b)));
        l();
    }

    private void k() {
        if (this.f8753g.a()) {
            m();
        }
    }

    private void l() {
        if (this.f8753g.b()) {
            m();
        }
    }

    private void m() {
        this.f8753g.c();
        this.f8752f.a();
        this.f8747a.a();
        this.D = false;
        this.f8754h = null;
        this.i = null;
        this.o = null;
        this.j = null;
        this.k = null;
        this.p = null;
        this.r = null;
        this.C = null;
        this.w = null;
        this.x = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.t = 0L;
        this.E = false;
        this.v = null;
        this.f8748b.clear();
        this.f8751e.release(this);
    }

    private void n() {
        this.w = Thread.currentThread();
        this.t = com.bumptech.glide.g.h.a();
        boolean z = false;
        while (!this.E && this.C != null && !(z = this.C.a())) {
            this.r = a(this.r);
            this.C = i();
            if (this.r == Stage.SOURCE) {
                e();
                return;
            }
        }
        if ((this.r == Stage.FINISHED || this.E) && !z) {
            j();
        }
    }

    private void o() {
        int i = j.f8917a[this.s.ordinal()];
        if (i == 1) {
            this.r = a(Stage.INITIALIZE);
            this.C = i();
            n();
        } else if (i == 2) {
            n();
        } else {
            if (i == 3) {
                h();
                return;
            }
            throw new IllegalStateException("Unrecognized run reason: " + this.s);
        }
    }

    private void p() {
        Throwable th;
        this.f8749c.b();
        if (this.D) {
            if (this.f8748b.isEmpty()) {
                th = null;
            } else {
                List<Throwable> list = this.f8748b;
                th = list.get(list.size() - 1);
            }
            throw new IllegalStateException("Already notified", th);
        }
        this.D = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DecodeJob<R> a(com.bumptech.glide.e eVar, Object obj, w wVar, com.bumptech.glide.load.c cVar, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, q qVar, Map<Class<?>, com.bumptech.glide.load.j<?>> map, boolean z, boolean z2, boolean z3, com.bumptech.glide.load.g gVar, a<R> aVar, int i3) {
        this.f8747a.a(eVar, obj, cVar, i, i2, qVar, cls, cls2, priority, gVar, map, z, z2, this.f8750d);
        this.f8754h = eVar;
        this.i = cVar;
        this.j = priority;
        this.k = wVar;
        this.l = i;
        this.m = i2;
        this.n = qVar;
        this.u = z3;
        this.o = gVar;
        this.p = aVar;
        this.q = i3;
        this.s = RunReason.INITIALIZE;
        this.v = obj;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(boolean z) {
        if (this.f8753g.a(z)) {
            m();
        }
    }

    @Override // com.bumptech.glide.g.a.d.c
    public com.bumptech.glide.g.a.g d() {
        return this.f8749c;
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC0718h.a
    public void e() {
        this.s = RunReason.SWITCH_TO_SOURCE_SERVICE;
        this.p.a((DecodeJob<?>) this);
    }

    public void f() {
        this.E = true;
        InterfaceC0718h interfaceC0718h = this.C;
        if (interfaceC0718h != null) {
            interfaceC0718h.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        Stage a2 = a(Stage.INITIALIZE);
        return a2 == Stage.RESOURCE_CACHE || a2 == Stage.DATA_CACHE;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.bumptech.glide.g.a.e.a("DecodeJob#run(model=%s)", this.v);
        com.bumptech.glide.load.a.d<?> dVar = this.B;
        try {
            try {
                if (this.E) {
                    j();
                    return;
                }
                o();
                if (dVar != null) {
                    dVar.b();
                }
                com.bumptech.glide.g.a.e.a();
            } catch (CallbackException e2) {
                throw e2;
            } catch (Throwable th) {
                if (Log.isLoggable("DecodeJob", 3)) {
                    Log.d("DecodeJob", "DecodeJob threw unexpectedly, isCancelled: " + this.E + ", stage: " + this.r, th);
                }
                if (this.r != Stage.ENCODE) {
                    this.f8748b.add(th);
                    j();
                }
                if (!this.E) {
                    throw th;
                }
                throw th;
            }
        } finally {
            if (dVar != null) {
                dVar.b();
            }
            com.bumptech.glide.g.a.e.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        private boolean f8760a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f8761b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f8762c;

        e() {
        }

        synchronized boolean a(boolean z) {
            this.f8760a = true;
            return b(z);
        }

        synchronized boolean b() {
            this.f8762c = true;
            return b(false);
        }

        synchronized void c() {
            this.f8761b = false;
            this.f8760a = false;
            this.f8762c = false;
        }

        private boolean b(boolean z) {
            return (this.f8762c || z || this.f8761b) && this.f8760a;
        }

        synchronized boolean a() {
            this.f8761b = true;
            return b(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c<Z> {

        /* renamed from: a, reason: collision with root package name */
        private com.bumptech.glide.load.c f8757a;

        /* renamed from: b, reason: collision with root package name */
        private com.bumptech.glide.load.i<Z> f8758b;

        /* renamed from: c, reason: collision with root package name */
        private D<Z> f8759c;

        c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        <X> void a(com.bumptech.glide.load.c cVar, com.bumptech.glide.load.i<X> iVar, D<X> d2) {
            this.f8757a = cVar;
            this.f8758b = iVar;
            this.f8759c = d2;
        }

        boolean b() {
            return this.f8759c != null;
        }

        void a(d dVar, com.bumptech.glide.load.g gVar) {
            com.bumptech.glide.g.a.e.a("DecodeJob.encode");
            try {
                dVar.a().a(this.f8757a, new C0717g(this.f8758b, this.f8759c, gVar));
            } finally {
                this.f8759c.e();
                com.bumptech.glide.g.a.e.a();
            }
        }

        void a() {
            this.f8757a = null;
            this.f8758b = null;
            this.f8759c = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b(E<R> e2, DataSource dataSource) {
        if (e2 instanceof z) {
            ((z) e2).d();
        }
        D d2 = 0;
        if (this.f8752f.b()) {
            e2 = D.a(e2);
            d2 = e2;
        }
        a((E) e2, dataSource);
        this.r = Stage.ENCODE;
        try {
            if (this.f8752f.b()) {
                this.f8752f.a(this.f8750d, this.o);
            }
            k();
        } finally {
            if (d2 != 0) {
                d2.e();
            }
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(DecodeJob<?> decodeJob) {
        int priority = getPriority() - decodeJob.getPriority();
        return priority == 0 ? this.q - decodeJob.q : priority;
    }

    private void a(E<R> e2, DataSource dataSource) {
        p();
        this.p.a(e2, dataSource);
    }

    private Stage a(Stage stage) {
        int i = j.f8918b[stage.ordinal()];
        if (i == 1) {
            return this.n.a() ? Stage.DATA_CACHE : a(Stage.DATA_CACHE);
        }
        if (i == 2) {
            return this.u ? Stage.FINISHED : Stage.SOURCE;
        }
        if (i == 3 || i == 4) {
            return Stage.FINISHED;
        }
        if (i == 5) {
            return this.n.b() ? Stage.RESOURCE_CACHE : a(Stage.RESOURCE_CACHE);
        }
        throw new IllegalArgumentException("Unrecognized stage: " + stage);
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC0718h.a
    public void a(com.bumptech.glide.load.c cVar, Object obj, com.bumptech.glide.load.a.d<?> dVar, DataSource dataSource, com.bumptech.glide.load.c cVar2) {
        this.x = cVar;
        this.z = obj;
        this.B = dVar;
        this.A = dataSource;
        this.y = cVar2;
        if (Thread.currentThread() != this.w) {
            this.s = RunReason.DECODE_DATA;
            this.p.a((DecodeJob<?>) this);
        } else {
            com.bumptech.glide.g.a.e.a("DecodeJob.decodeFromRetrievedData");
            try {
                h();
            } finally {
                com.bumptech.glide.g.a.e.a();
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC0718h.a
    public void a(com.bumptech.glide.load.c cVar, Exception exc, com.bumptech.glide.load.a.d<?> dVar, DataSource dataSource) {
        dVar.b();
        GlideException glideException = new GlideException("Fetching data failed", exc);
        glideException.setLoggingDetails(cVar, dataSource, dVar.a());
        this.f8748b.add(glideException);
        if (Thread.currentThread() != this.w) {
            this.s = RunReason.SWITCH_TO_SOURCE_SERVICE;
            this.p.a((DecodeJob<?>) this);
        } else {
            n();
        }
    }

    private <Data> E<R> a(com.bumptech.glide.load.a.d<?> dVar, Data data, DataSource dataSource) throws GlideException {
        if (data == null) {
            return null;
        }
        try {
            long a2 = com.bumptech.glide.g.h.a();
            E<R> a3 = a((DecodeJob<R>) data, dataSource);
            if (Log.isLoggable("DecodeJob", 2)) {
                a("Decoded result " + a3, a2);
            }
            return a3;
        } finally {
            dVar.b();
        }
    }

    private <Data> E<R> a(Data data, DataSource dataSource) throws GlideException {
        return a((DecodeJob<R>) data, dataSource, (B<DecodeJob<R>, ResourceType, R>) this.f8747a.a((Class) data.getClass()));
    }

    private com.bumptech.glide.load.g a(DataSource dataSource) {
        com.bumptech.glide.load.g gVar = this.o;
        if (Build.VERSION.SDK_INT < 26) {
            return gVar;
        }
        boolean z = dataSource == DataSource.RESOURCE_DISK_CACHE || this.f8747a.o();
        Boolean bool = (Boolean) gVar.a(com.bumptech.glide.load.resource.bitmap.m.f9031d);
        if (bool != null && (!bool.booleanValue() || z)) {
            return gVar;
        }
        com.bumptech.glide.load.g gVar2 = new com.bumptech.glide.load.g();
        gVar2.a(this.o);
        gVar2.a(com.bumptech.glide.load.resource.bitmap.m.f9031d, Boolean.valueOf(z));
        return gVar2;
    }

    private <Data, ResourceType> E<R> a(Data data, DataSource dataSource, B<Data, ResourceType, R> b2) throws GlideException {
        com.bumptech.glide.load.g a2 = a(dataSource);
        com.bumptech.glide.load.a.e<Data> b3 = this.f8754h.f().b((Registry) data);
        try {
            return b2.a(b3, a2, this.l, this.m, new b(dataSource));
        } finally {
            b3.b();
        }
    }

    private void a(String str, long j) {
        a(str, j, (String) null);
    }

    private void a(String str, long j, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(com.bumptech.glide.g.h.a(j));
        sb.append(", load key: ");
        sb.append(this.k);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sb.toString());
    }

    <Z> E<Z> a(DataSource dataSource, E<Z> e2) {
        E<Z> e3;
        com.bumptech.glide.load.j<Z> jVar;
        EncodeStrategy encodeStrategy;
        com.bumptech.glide.load.c c0716f;
        Class<?> cls = e2.get().getClass();
        com.bumptech.glide.load.i<Z> iVar = null;
        if (dataSource != DataSource.RESOURCE_DISK_CACHE) {
            com.bumptech.glide.load.j<Z> b2 = this.f8747a.b(cls);
            jVar = b2;
            e3 = b2.a(this.f8754h, e2, this.l, this.m);
        } else {
            e3 = e2;
            jVar = null;
        }
        if (!e2.equals(e3)) {
            e2.b();
        }
        if (this.f8747a.b((E<?>) e3)) {
            iVar = this.f8747a.a((E) e3);
            encodeStrategy = iVar.a(this.o);
        } else {
            encodeStrategy = EncodeStrategy.NONE;
        }
        com.bumptech.glide.load.i iVar2 = iVar;
        if (!this.n.a(!this.f8747a.a(this.x), dataSource, encodeStrategy)) {
            return e3;
        }
        if (iVar2 != null) {
            int i = j.f8919c[encodeStrategy.ordinal()];
            if (i == 1) {
                c0716f = new C0716f(this.x, this.i);
            } else if (i == 2) {
                c0716f = new G(this.f8747a.b(), this.x, this.i, this.l, this.m, jVar, cls, this.o);
            } else {
                throw new IllegalArgumentException("Unknown strategy: " + encodeStrategy);
            }
            D a2 = D.a(e3);
            this.f8752f.a(c0716f, iVar2, a2);
            return a2;
        }
        throw new Registry.NoResultEncoderAvailableException(e3.get().getClass());
    }
}
