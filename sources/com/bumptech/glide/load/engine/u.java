package com.bumptech.glide.load.engine;

import android.support.v4.util.Pools;
import com.bumptech.glide.g.a.d;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DecodeJob;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EngineJob.java */
/* loaded from: classes.dex */
public class u<R> implements DecodeJob.a<R>, d.c {

    /* renamed from: a */
    private static final c f8954a = new c();

    /* renamed from: b */
    final e f8955b;

    /* renamed from: c */
    private final com.bumptech.glide.g.a.g f8956c;

    /* renamed from: d */
    private final Pools.Pool<u<?>> f8957d;

    /* renamed from: e */
    private final c f8958e;

    /* renamed from: f */
    private final v f8959f;

    /* renamed from: g */
    private final com.bumptech.glide.load.engine.c.b f8960g;

    /* renamed from: h */
    private final com.bumptech.glide.load.engine.c.b f8961h;
    private final com.bumptech.glide.load.engine.c.b i;
    private final com.bumptech.glide.load.engine.c.b j;
    private final AtomicInteger k;
    private com.bumptech.glide.load.c l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private E<?> q;
    DataSource r;
    private boolean s;
    GlideException t;
    private boolean u;
    y<?> v;
    private DecodeJob<R> w;
    private volatile boolean x;

    /* compiled from: EngineJob.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a */
        private final com.bumptech.glide.request.g f8962a;

        a(com.bumptech.glide.request.g gVar) {
            this.f8962a = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (u.this) {
                if (u.this.f8955b.a(this.f8962a)) {
                    u.this.a(this.f8962a);
                }
                u.this.b();
            }
        }
    }

    /* compiled from: EngineJob.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a */
        private final com.bumptech.glide.request.g f8964a;

        b(com.bumptech.glide.request.g gVar) {
            this.f8964a = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (u.this) {
                if (u.this.f8955b.a(this.f8964a)) {
                    u.this.v.d();
                    u.this.b(this.f8964a);
                    u.this.c(this.f8964a);
                }
                u.this.b();
            }
        }
    }

    /* compiled from: EngineJob.java */
    /* loaded from: classes.dex */
    public static class c {
        c() {
        }

        public <R> y<R> a(E<R> e2, boolean z) {
            return new y<>(e2, z, true);
        }
    }

    /* compiled from: EngineJob.java */
    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a */
        final com.bumptech.glide.request.g f8966a;

        /* renamed from: b */
        final Executor f8967b;

        d(com.bumptech.glide.request.g gVar, Executor executor) {
            this.f8966a = gVar;
            this.f8967b = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.f8966a.equals(((d) obj).f8966a);
            }
            return false;
        }

        public int hashCode() {
            return this.f8966a.hashCode();
        }
    }

    /* compiled from: EngineJob.java */
    /* loaded from: classes.dex */
    public static final class e implements Iterable<d> {

        /* renamed from: a */
        private final List<d> f8968a;

        e() {
            this(new ArrayList(2));
        }

        private static d c(com.bumptech.glide.request.g gVar) {
            return new d(gVar, com.bumptech.glide.g.g.a());
        }

        void a(com.bumptech.glide.request.g gVar, Executor executor) {
            this.f8968a.add(new d(gVar, executor));
        }

        void b(com.bumptech.glide.request.g gVar) {
            this.f8968a.remove(c(gVar));
        }

        void clear() {
            this.f8968a.clear();
        }

        boolean isEmpty() {
            return this.f8968a.isEmpty();
        }

        @Override // java.lang.Iterable
        public Iterator<d> iterator() {
            return this.f8968a.iterator();
        }

        int size() {
            return this.f8968a.size();
        }

        e(List<d> list) {
            this.f8968a = list;
        }

        boolean a(com.bumptech.glide.request.g gVar) {
            return this.f8968a.contains(c(gVar));
        }

        e a() {
            return new e(new ArrayList(this.f8968a));
        }
    }

    public u(com.bumptech.glide.load.engine.c.b bVar, com.bumptech.glide.load.engine.c.b bVar2, com.bumptech.glide.load.engine.c.b bVar3, com.bumptech.glide.load.engine.c.b bVar4, v vVar, Pools.Pool<u<?>> pool) {
        this(bVar, bVar2, bVar3, bVar4, vVar, pool, f8954a);
    }

    private com.bumptech.glide.load.engine.c.b g() {
        if (this.n) {
            return this.i;
        }
        return this.o ? this.j : this.f8961h;
    }

    private boolean h() {
        return this.u || this.s || this.x;
    }

    private synchronized void i() {
        if (this.l != null) {
            this.f8955b.clear();
            this.l = null;
            this.v = null;
            this.q = null;
            this.u = false;
            this.x = false;
            this.s = false;
            this.w.b(false);
            this.w = null;
            this.t = null;
            this.r = null;
            this.f8957d.release(this);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public synchronized u<R> a(com.bumptech.glide.load.c cVar, boolean z, boolean z2, boolean z3, boolean z4) {
        this.l = cVar;
        this.m = z;
        this.n = z2;
        this.o = z3;
        this.p = z4;
        return this;
    }

    public synchronized void b(DecodeJob<R> decodeJob) {
        com.bumptech.glide.load.engine.c.b g2;
        this.w = decodeJob;
        if (decodeJob.g()) {
            g2 = this.f8960g;
        } else {
            g2 = g();
        }
        g2.execute(decodeJob);
    }

    public synchronized void c(com.bumptech.glide.request.g gVar) {
        boolean z;
        this.f8956c.b();
        this.f8955b.b(gVar);
        if (this.f8955b.isEmpty()) {
            a();
            if (!this.s && !this.u) {
                z = false;
                if (z && this.k.get() == 0) {
                    i();
                }
            }
            z = true;
            if (z) {
                i();
            }
        }
    }

    @Override // com.bumptech.glide.g.a.d.c
    public com.bumptech.glide.g.a.g d() {
        return this.f8956c;
    }

    void e() {
        synchronized (this) {
            this.f8956c.b();
            if (this.x) {
                this.q.b();
                i();
                return;
            }
            if (!this.f8955b.isEmpty()) {
                if (!this.s) {
                    this.v = this.f8958e.a(this.q, this.m);
                    this.s = true;
                    e a2 = this.f8955b.a();
                    a(a2.size() + 1);
                    this.f8959f.a(this, this.l, this.v);
                    Iterator<d> it = a2.iterator();
                    while (it.hasNext()) {
                        d next = it.next();
                        next.f8967b.execute(new b(next.f8966a));
                    }
                    b();
                    return;
                }
                throw new IllegalStateException("Already have resource");
            }
            throw new IllegalStateException("Received a resource without any callbacks to notify");
        }
    }

    public boolean f() {
        return this.p;
    }

    u(com.bumptech.glide.load.engine.c.b bVar, com.bumptech.glide.load.engine.c.b bVar2, com.bumptech.glide.load.engine.c.b bVar3, com.bumptech.glide.load.engine.c.b bVar4, v vVar, Pools.Pool<u<?>> pool, c cVar) {
        this.f8955b = new e();
        this.f8956c = com.bumptech.glide.g.a.g.a();
        this.k = new AtomicInteger();
        this.f8960g = bVar;
        this.f8961h = bVar2;
        this.i = bVar3;
        this.j = bVar4;
        this.f8959f = vVar;
        this.f8957d = pool;
        this.f8958e = cVar;
    }

    public synchronized void a(com.bumptech.glide.request.g gVar, Executor executor) {
        this.f8956c.b();
        this.f8955b.a(gVar, executor);
        boolean z = true;
        if (this.s) {
            a(1);
            executor.execute(new b(gVar));
        } else if (this.u) {
            a(1);
            executor.execute(new a(gVar));
        } else {
            if (this.x) {
                z = false;
            }
            com.bumptech.glide.g.l.a(z, "Cannot add callbacks to a cancelled EngineJob");
        }
    }

    synchronized void b(com.bumptech.glide.request.g gVar) {
        CallbackException callbackException;
        try {
            gVar.a(this.v, this.r);
        } finally {
        }
    }

    void c() {
        synchronized (this) {
            this.f8956c.b();
            if (this.x) {
                i();
                return;
            }
            if (!this.f8955b.isEmpty()) {
                if (!this.u) {
                    this.u = true;
                    com.bumptech.glide.load.c cVar = this.l;
                    e a2 = this.f8955b.a();
                    a(a2.size() + 1);
                    this.f8959f.a(this, cVar, null);
                    Iterator<d> it = a2.iterator();
                    while (it.hasNext()) {
                        d next = it.next();
                        next.f8967b.execute(new a(next.f8966a));
                    }
                    b();
                    return;
                }
                throw new IllegalStateException("Already failed once");
            }
            throw new IllegalStateException("Received an exception without any callbacks to notify");
        }
    }

    synchronized void b() {
        this.f8956c.b();
        com.bumptech.glide.g.l.a(h(), "Not yet complete!");
        int decrementAndGet = this.k.decrementAndGet();
        com.bumptech.glide.g.l.a(decrementAndGet >= 0, "Can't decrement below 0");
        if (decrementAndGet == 0) {
            if (this.v != null) {
                this.v.g();
            }
            i();
        }
    }

    synchronized void a(com.bumptech.glide.request.g gVar) {
        CallbackException callbackException;
        try {
            gVar.a(this.t);
        } finally {
        }
    }

    void a() {
        if (h()) {
            return;
        }
        this.x = true;
        this.w.f();
        this.f8959f.a(this, this.l);
    }

    synchronized void a(int i) {
        com.bumptech.glide.g.l.a(h(), "Not yet complete!");
        if (this.k.getAndAdd(i) == 0 && this.v != null) {
            this.v.d();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.engine.DecodeJob.a
    public void a(E<R> e2, DataSource dataSource) {
        synchronized (this) {
            this.q = e2;
            this.r = dataSource;
        }
        e();
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.a
    public void a(GlideException glideException) {
        synchronized (this) {
            this.t = glideException;
        }
        c();
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.a
    public void a(DecodeJob<?> decodeJob) {
        g().execute(decodeJob);
    }
}
