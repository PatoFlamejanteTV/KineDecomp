package com.bumptech.glide.load.engine;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EngineResource.java */
/* loaded from: classes.dex */
public class y<Z> implements E<Z> {

    /* renamed from: a */
    private final boolean f8977a;

    /* renamed from: b */
    private final boolean f8978b;

    /* renamed from: c */
    private final E<Z> f8979c;

    /* renamed from: d */
    private a f8980d;

    /* renamed from: e */
    private com.bumptech.glide.load.c f8981e;

    /* renamed from: f */
    private int f8982f;

    /* renamed from: g */
    private boolean f8983g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EngineResource.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(com.bumptech.glide.load.c cVar, y<?> yVar);
    }

    public y(E<Z> e2, boolean z, boolean z2) {
        com.bumptech.glide.g.l.a(e2);
        this.f8979c = e2;
        this.f8977a = z;
        this.f8978b = z2;
    }

    public synchronized void a(com.bumptech.glide.load.c cVar, a aVar) {
        this.f8981e = cVar;
        this.f8980d = aVar;
    }

    @Override // com.bumptech.glide.load.engine.E
    public synchronized void b() {
        if (this.f8982f <= 0) {
            if (!this.f8983g) {
                this.f8983g = true;
                if (this.f8978b) {
                    this.f8979c.b();
                }
            } else {
                throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
            }
        } else {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
    }

    @Override // com.bumptech.glide.load.engine.E
    public Class<Z> c() {
        return this.f8979c.c();
    }

    public synchronized void d() {
        if (!this.f8983g) {
            this.f8982f++;
        } else {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
    }

    public E<Z> e() {
        return this.f8979c;
    }

    public boolean f() {
        return this.f8977a;
    }

    public void g() {
        synchronized (this.f8980d) {
            synchronized (this) {
                if (this.f8982f > 0) {
                    int i = this.f8982f - 1;
                    this.f8982f = i;
                    if (i == 0) {
                        this.f8980d.a(this.f8981e, this);
                    }
                } else {
                    throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
                }
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.E
    public Z get() {
        return this.f8979c.get();
    }

    public synchronized String toString() {
        return "EngineResource{isCacheable=" + this.f8977a + ", listener=" + this.f8980d + ", key=" + this.f8981e + ", acquired=" + this.f8982f + ", isRecycled=" + this.f8983g + ", resource=" + this.f8979c + '}';
    }

    @Override // com.bumptech.glide.load.engine.E
    public int a() {
        return this.f8979c.a();
    }
}
