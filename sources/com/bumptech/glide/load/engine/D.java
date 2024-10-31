package com.bumptech.glide.load.engine;

import android.support.v4.util.Pools;
import com.bumptech.glide.g.a.d;

/* compiled from: LockedResource.java */
/* loaded from: classes.dex */
public final class D<Z> implements E<Z>, d.c {

    /* renamed from: a */
    private static final Pools.Pool<D<?>> f8742a = com.bumptech.glide.g.a.d.a(20, new C());

    /* renamed from: b */
    private final com.bumptech.glide.g.a.g f8743b = com.bumptech.glide.g.a.g.a();

    /* renamed from: c */
    private E<Z> f8744c;

    /* renamed from: d */
    private boolean f8745d;

    /* renamed from: e */
    private boolean f8746e;

    public static <Z> D<Z> a(E<Z> e2) {
        D acquire = f8742a.acquire();
        com.bumptech.glide.g.l.a(acquire);
        D d2 = acquire;
        d2.b(e2);
        return d2;
    }

    private void b(E<Z> e2) {
        this.f8746e = false;
        this.f8745d = true;
        this.f8744c = e2;
    }

    private void f() {
        this.f8744c = null;
        f8742a.release(this);
    }

    @Override // com.bumptech.glide.load.engine.E
    public Class<Z> c() {
        return this.f8744c.c();
    }

    @Override // com.bumptech.glide.g.a.d.c
    public com.bumptech.glide.g.a.g d() {
        return this.f8743b;
    }

    public synchronized void e() {
        this.f8743b.b();
        if (this.f8745d) {
            this.f8745d = false;
            if (this.f8746e) {
                b();
            }
        } else {
            throw new IllegalStateException("Already unlocked");
        }
    }

    @Override // com.bumptech.glide.load.engine.E
    public Z get() {
        return this.f8744c.get();
    }

    @Override // com.bumptech.glide.load.engine.E
    public int a() {
        return this.f8744c.a();
    }

    @Override // com.bumptech.glide.load.engine.E
    public synchronized void b() {
        this.f8743b.b();
        this.f8746e = true;
        if (!this.f8745d) {
            this.f8744c.b();
            f();
        }
    }
}
