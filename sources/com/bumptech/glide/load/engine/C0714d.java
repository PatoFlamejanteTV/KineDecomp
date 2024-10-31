package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.engine.y;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: ActiveResources.java */
/* renamed from: com.bumptech.glide.load.engine.d */
/* loaded from: classes.dex */
public final class C0714d {

    /* renamed from: a */
    private final boolean f8882a;

    /* renamed from: b */
    private final Executor f8883b;

    /* renamed from: c */
    final Map<com.bumptech.glide.load.c, b> f8884c;

    /* renamed from: d */
    private final ReferenceQueue<y<?>> f8885d;

    /* renamed from: e */
    private y.a f8886e;

    /* renamed from: f */
    private volatile boolean f8887f;

    /* renamed from: g */
    private volatile a f8888g;

    /* compiled from: ActiveResources.java */
    /* renamed from: com.bumptech.glide.load.engine.d$a */
    /* loaded from: classes.dex */
    public interface a {
        void a();
    }

    /* compiled from: ActiveResources.java */
    /* renamed from: com.bumptech.glide.load.engine.d$b */
    /* loaded from: classes.dex */
    public static final class b extends WeakReference<y<?>> {

        /* renamed from: a */
        final com.bumptech.glide.load.c f8893a;

        /* renamed from: b */
        final boolean f8894b;

        /* renamed from: c */
        E<?> f8895c;

        b(com.bumptech.glide.load.c cVar, y<?> yVar, ReferenceQueue<? super y<?>> referenceQueue, boolean z) {
            super(yVar, referenceQueue);
            E<?> e2;
            com.bumptech.glide.g.l.a(cVar);
            this.f8893a = cVar;
            if (yVar.f() && z) {
                E<?> e3 = yVar.e();
                com.bumptech.glide.g.l.a(e3);
                e2 = e3;
            } else {
                e2 = null;
            }
            this.f8895c = e2;
            this.f8894b = yVar.f();
        }

        void a() {
            this.f8895c = null;
            clear();
        }
    }

    public C0714d(boolean z) {
        this(z, Executors.newSingleThreadExecutor(new ThreadFactoryC0712b()));
    }

    public void a(y.a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.f8886e = aVar;
            }
        }
    }

    public synchronized y<?> b(com.bumptech.glide.load.c cVar) {
        b bVar = this.f8884c.get(cVar);
        if (bVar == null) {
            return null;
        }
        y<?> yVar = bVar.get();
        if (yVar == null) {
            a(bVar);
        }
        return yVar;
    }

    C0714d(boolean z, Executor executor) {
        this.f8884c = new HashMap();
        this.f8885d = new ReferenceQueue<>();
        this.f8882a = z;
        this.f8883b = executor;
        executor.execute(new RunnableC0713c(this));
    }

    public synchronized void a(com.bumptech.glide.load.c cVar, y<?> yVar) {
        b put = this.f8884c.put(cVar, new b(cVar, yVar, this.f8885d, this.f8882a));
        if (put != null) {
            put.a();
        }
    }

    public synchronized void a(com.bumptech.glide.load.c cVar) {
        b remove = this.f8884c.remove(cVar);
        if (remove != null) {
            remove.a();
        }
    }

    void a(b bVar) {
        synchronized (this.f8886e) {
            synchronized (this) {
                this.f8884c.remove(bVar.f8893a);
                if (bVar.f8894b && bVar.f8895c != null) {
                    y<?> yVar = new y<>(bVar.f8895c, true, false);
                    yVar.a(bVar.f8893a, this.f8886e);
                    this.f8886e.a(bVar.f8893a, yVar);
                }
            }
        }
    }

    public void a() {
        while (!this.f8887f) {
            try {
                a((b) this.f8885d.remove());
                a aVar = this.f8888g;
                if (aVar != null) {
                    aVar.a();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
