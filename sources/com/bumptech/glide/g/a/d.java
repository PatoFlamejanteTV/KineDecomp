package com.bumptech.glide.g.a;

import android.support.v4.util.Pools;
import android.util.Log;
import java.util.List;

/* compiled from: FactoryPools.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a */
    private static final InterfaceC0048d<Object> f8496a = new com.bumptech.glide.g.a.a();

    /* compiled from: FactoryPools.java */
    /* loaded from: classes.dex */
    public interface a<T> {
        T create();
    }

    /* compiled from: FactoryPools.java */
    /* loaded from: classes.dex */
    public static final class b<T> implements Pools.Pool<T> {

        /* renamed from: a */
        private final a<T> f8497a;

        /* renamed from: b */
        private final InterfaceC0048d<T> f8498b;

        /* renamed from: c */
        private final Pools.Pool<T> f8499c;

        b(Pools.Pool<T> pool, a<T> aVar, InterfaceC0048d<T> interfaceC0048d) {
            this.f8499c = pool;
            this.f8497a = aVar;
            this.f8498b = interfaceC0048d;
        }

        @Override // android.support.v4.util.Pools.Pool
        public T acquire() {
            T acquire = this.f8499c.acquire();
            if (acquire == null) {
                acquire = this.f8497a.create();
                if (Log.isLoggable("FactoryPools", 2)) {
                    Log.v("FactoryPools", "Created new " + acquire.getClass());
                }
            }
            if (acquire instanceof c) {
                acquire.d().a(false);
            }
            return (T) acquire;
        }

        @Override // android.support.v4.util.Pools.Pool
        public boolean release(T t) {
            if (t instanceof c) {
                ((c) t).d().a(true);
            }
            this.f8498b.a(t);
            return this.f8499c.release(t);
        }
    }

    /* compiled from: FactoryPools.java */
    /* loaded from: classes.dex */
    public interface c {
        g d();
    }

    /* compiled from: FactoryPools.java */
    /* renamed from: com.bumptech.glide.g.a.d$d */
    /* loaded from: classes.dex */
    public interface InterfaceC0048d<T> {
        void a(T t);
    }

    public static <T extends c> Pools.Pool<T> a(int i, a<T> aVar) {
        return a(new Pools.SynchronizedPool(i), aVar);
    }

    private static <T> InterfaceC0048d<T> b() {
        return (InterfaceC0048d<T>) f8496a;
    }

    public static <T> Pools.Pool<List<T>> a() {
        return a(20);
    }

    public static <T> Pools.Pool<List<T>> a(int i) {
        return a(new Pools.SynchronizedPool(i), new com.bumptech.glide.g.a.b(), new com.bumptech.glide.g.a.c());
    }

    private static <T extends c> Pools.Pool<T> a(Pools.Pool<T> pool, a<T> aVar) {
        return a(pool, aVar, b());
    }

    private static <T> Pools.Pool<T> a(Pools.Pool<T> pool, a<T> aVar, InterfaceC0048d<T> interfaceC0048d) {
        return new b(pool, aVar, interfaceC0048d);
    }
}
