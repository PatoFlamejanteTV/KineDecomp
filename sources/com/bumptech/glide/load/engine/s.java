package com.bumptech.glide.load.engine;

import android.support.v4.util.Pools;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.b.a;
import com.bumptech.glide.load.engine.b.i;
import com.bumptech.glide.load.engine.y;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: Engine.java */
/* loaded from: classes.dex */
public class s implements v, i.a, y.a {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f8931a = Log.isLoggable("Engine", 2);

    /* renamed from: b, reason: collision with root package name */
    private final A f8932b;

    /* renamed from: c, reason: collision with root package name */
    private final x f8933c;

    /* renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.b.i f8934d;

    /* renamed from: e, reason: collision with root package name */
    private final b f8935e;

    /* renamed from: f, reason: collision with root package name */
    private final H f8936f;

    /* renamed from: g, reason: collision with root package name */
    private final c f8937g;

    /* renamed from: h, reason: collision with root package name */
    private final a f8938h;
    private final C0714d i;

    /* compiled from: Engine.java */
    /* loaded from: classes.dex */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        final DecodeJob.d f8939a;

        /* renamed from: b, reason: collision with root package name */
        final Pools.Pool<DecodeJob<?>> f8940b = com.bumptech.glide.g.a.d.a(150, new r(this));

        /* renamed from: c, reason: collision with root package name */
        private int f8941c;

        a(DecodeJob.d dVar) {
            this.f8939a = dVar;
        }

        <R> DecodeJob<R> a(com.bumptech.glide.e eVar, Object obj, w wVar, com.bumptech.glide.load.c cVar, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, q qVar, Map<Class<?>, com.bumptech.glide.load.j<?>> map, boolean z, boolean z2, boolean z3, com.bumptech.glide.load.g gVar, DecodeJob.a<R> aVar) {
            DecodeJob acquire = this.f8940b.acquire();
            com.bumptech.glide.g.l.a(acquire);
            DecodeJob decodeJob = acquire;
            int i3 = this.f8941c;
            this.f8941c = i3 + 1;
            decodeJob.a(eVar, obj, wVar, cVar, i, i2, cls, cls2, priority, qVar, map, z, z2, z3, gVar, aVar, i3);
            return decodeJob;
        }
    }

    /* compiled from: Engine.java */
    /* loaded from: classes.dex */
    static class b {

        /* renamed from: a, reason: collision with root package name */
        final com.bumptech.glide.load.engine.c.b f8942a;

        /* renamed from: b, reason: collision with root package name */
        final com.bumptech.glide.load.engine.c.b f8943b;

        /* renamed from: c, reason: collision with root package name */
        final com.bumptech.glide.load.engine.c.b f8944c;

        /* renamed from: d, reason: collision with root package name */
        final com.bumptech.glide.load.engine.c.b f8945d;

        /* renamed from: e, reason: collision with root package name */
        final v f8946e;

        /* renamed from: f, reason: collision with root package name */
        final Pools.Pool<u<?>> f8947f = com.bumptech.glide.g.a.d.a(150, new t(this));

        b(com.bumptech.glide.load.engine.c.b bVar, com.bumptech.glide.load.engine.c.b bVar2, com.bumptech.glide.load.engine.c.b bVar3, com.bumptech.glide.load.engine.c.b bVar4, v vVar) {
            this.f8942a = bVar;
            this.f8943b = bVar2;
            this.f8944c = bVar3;
            this.f8945d = bVar4;
            this.f8946e = vVar;
        }

        <R> u<R> a(com.bumptech.glide.load.c cVar, boolean z, boolean z2, boolean z3, boolean z4) {
            u acquire = this.f8947f.acquire();
            com.bumptech.glide.g.l.a(acquire);
            u uVar = acquire;
            uVar.a(cVar, z, z2, z3, z4);
            return uVar;
        }
    }

    /* compiled from: Engine.java */
    /* loaded from: classes.dex */
    private static class c implements DecodeJob.d {

        /* renamed from: a, reason: collision with root package name */
        private final a.InterfaceC0055a f8948a;

        /* renamed from: b, reason: collision with root package name */
        private volatile com.bumptech.glide.load.engine.b.a f8949b;

        c(a.InterfaceC0055a interfaceC0055a) {
            this.f8948a = interfaceC0055a;
        }

        @Override // com.bumptech.glide.load.engine.DecodeJob.d
        public com.bumptech.glide.load.engine.b.a a() {
            if (this.f8949b == null) {
                synchronized (this) {
                    if (this.f8949b == null) {
                        this.f8949b = this.f8948a.build();
                    }
                    if (this.f8949b == null) {
                        this.f8949b = new com.bumptech.glide.load.engine.b.b();
                    }
                }
            }
            return this.f8949b;
        }
    }

    /* compiled from: Engine.java */
    /* loaded from: classes.dex */
    public class d {

        /* renamed from: a, reason: collision with root package name */
        private final u<?> f8950a;

        /* renamed from: b, reason: collision with root package name */
        private final com.bumptech.glide.request.g f8951b;

        d(com.bumptech.glide.request.g gVar, u<?> uVar) {
            this.f8951b = gVar;
            this.f8950a = uVar;
        }

        public void a() {
            synchronized (s.this) {
                this.f8950a.c(this.f8951b);
            }
        }
    }

    public s(com.bumptech.glide.load.engine.b.i iVar, a.InterfaceC0055a interfaceC0055a, com.bumptech.glide.load.engine.c.b bVar, com.bumptech.glide.load.engine.c.b bVar2, com.bumptech.glide.load.engine.c.b bVar3, com.bumptech.glide.load.engine.c.b bVar4, boolean z) {
        this(iVar, interfaceC0055a, bVar, bVar2, bVar3, bVar4, null, null, null, null, null, null, z);
    }

    private y<?> b(com.bumptech.glide.load.c cVar, boolean z) {
        if (!z) {
            return null;
        }
        y<?> a2 = a(cVar);
        if (a2 != null) {
            a2.d();
            this.i.a(cVar, a2);
        }
        return a2;
    }

    public synchronized <R> d a(com.bumptech.glide.e eVar, Object obj, com.bumptech.glide.load.c cVar, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, q qVar, Map<Class<?>, com.bumptech.glide.load.j<?>> map, boolean z, boolean z2, com.bumptech.glide.load.g gVar, boolean z3, boolean z4, boolean z5, boolean z6, com.bumptech.glide.request.g gVar2, Executor executor) {
        long a2 = f8931a ? com.bumptech.glide.g.h.a() : 0L;
        w a3 = this.f8933c.a(obj, cVar, i, i2, map, cls, cls2, gVar);
        y<?> a4 = a(a3, z3);
        if (a4 != null) {
            gVar2.a(a4, DataSource.MEMORY_CACHE);
            if (f8931a) {
                a("Loaded resource from active resources", a2, a3);
            }
            return null;
        }
        y<?> b2 = b(a3, z3);
        if (b2 != null) {
            gVar2.a(b2, DataSource.MEMORY_CACHE);
            if (f8931a) {
                a("Loaded resource from cache", a2, a3);
            }
            return null;
        }
        u<?> a5 = this.f8932b.a(a3, z6);
        if (a5 != null) {
            a5.a(gVar2, executor);
            if (f8931a) {
                a("Added to existing load", a2, a3);
            }
            return new d(gVar2, a5);
        }
        u<R> a6 = this.f8935e.a(a3, z3, z4, z5, z6);
        DecodeJob<R> a7 = this.f8938h.a(eVar, obj, a3, cVar, i, i2, cls, cls2, priority, qVar, map, z, z2, z6, gVar, a6);
        this.f8932b.a((com.bumptech.glide.load.c) a3, (u<?>) a6);
        a6.a(gVar2, executor);
        a6.b(a7);
        if (f8931a) {
            a("Started new load", a2, a3);
        }
        return new d(gVar2, a6);
    }

    s(com.bumptech.glide.load.engine.b.i iVar, a.InterfaceC0055a interfaceC0055a, com.bumptech.glide.load.engine.c.b bVar, com.bumptech.glide.load.engine.c.b bVar2, com.bumptech.glide.load.engine.c.b bVar3, com.bumptech.glide.load.engine.c.b bVar4, A a2, x xVar, C0714d c0714d, b bVar5, a aVar, H h2, boolean z) {
        this.f8934d = iVar;
        this.f8937g = new c(interfaceC0055a);
        C0714d c0714d2 = c0714d == null ? new C0714d(z) : c0714d;
        this.i = c0714d2;
        c0714d2.a(this);
        this.f8933c = xVar == null ? new x() : xVar;
        this.f8932b = a2 == null ? new A() : a2;
        this.f8935e = bVar5 == null ? new b(bVar, bVar2, bVar3, bVar4, this) : bVar5;
        this.f8938h = aVar == null ? new a(this.f8937g) : aVar;
        this.f8936f = h2 == null ? new H() : h2;
        iVar.a(this);
    }

    public void b(E<?> e2) {
        if (e2 instanceof y) {
            ((y) e2).g();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    private static void a(String str, long j, com.bumptech.glide.load.c cVar) {
        Log.v("Engine", str + " in " + com.bumptech.glide.g.h.a(j) + "ms, key: " + cVar);
    }

    private y<?> a(com.bumptech.glide.load.c cVar, boolean z) {
        if (!z) {
            return null;
        }
        y<?> b2 = this.i.b(cVar);
        if (b2 != null) {
            b2.d();
        }
        return b2;
    }

    private y<?> a(com.bumptech.glide.load.c cVar) {
        E<?> a2 = this.f8934d.a(cVar);
        if (a2 == null) {
            return null;
        }
        if (a2 instanceof y) {
            return (y) a2;
        }
        return new y<>(a2, true, true);
    }

    @Override // com.bumptech.glide.load.engine.v
    public synchronized void a(u<?> uVar, com.bumptech.glide.load.c cVar, y<?> yVar) {
        if (yVar != null) {
            yVar.a(cVar, this);
            if (yVar.f()) {
                this.i.a(cVar, yVar);
            }
        }
        this.f8932b.b(cVar, uVar);
    }

    @Override // com.bumptech.glide.load.engine.v
    public synchronized void a(u<?> uVar, com.bumptech.glide.load.c cVar) {
        this.f8932b.b(cVar, uVar);
    }

    @Override // com.bumptech.glide.load.engine.b.i.a
    public void a(E<?> e2) {
        this.f8936f.a(e2);
    }

    @Override // com.bumptech.glide.load.engine.y.a
    public synchronized void a(com.bumptech.glide.load.c cVar, y<?> yVar) {
        this.i.a(cVar);
        if (yVar.f()) {
            this.f8934d.a(cVar, yVar);
        } else {
            this.f8936f.a(yVar);
        }
    }
}
