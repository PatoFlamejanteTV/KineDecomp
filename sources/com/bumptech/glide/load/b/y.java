package com.bumptech.glide.load.b;

import android.support.v4.util.Pools;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.b.u;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: MultiModelLoaderFactory.java */
/* loaded from: classes.dex */
public class y {

    /* renamed from: a */
    private static final c f8662a = new c();

    /* renamed from: b */
    private static final u<Object, Object> f8663b = new a();

    /* renamed from: c */
    private final List<b<?, ?>> f8664c;

    /* renamed from: d */
    private final c f8665d;

    /* renamed from: e */
    private final Set<b<?, ?>> f8666e;

    /* renamed from: f */
    private final Pools.Pool<List<Throwable>> f8667f;

    /* compiled from: MultiModelLoaderFactory.java */
    /* loaded from: classes.dex */
    private static class a implements u<Object, Object> {
        a() {
        }

        @Override // com.bumptech.glide.load.b.u
        public u.a<Object> a(Object obj, int i, int i2, com.bumptech.glide.load.g gVar) {
            return null;
        }

        @Override // com.bumptech.glide.load.b.u
        public boolean a(Object obj) {
            return false;
        }
    }

    /* compiled from: MultiModelLoaderFactory.java */
    /* loaded from: classes.dex */
    public static class b<Model, Data> {

        /* renamed from: a */
        private final Class<Model> f8668a;

        /* renamed from: b */
        final Class<Data> f8669b;

        /* renamed from: c */
        final v<? extends Model, ? extends Data> f8670c;

        public b(Class<Model> cls, Class<Data> cls2, v<? extends Model, ? extends Data> vVar) {
            this.f8668a = cls;
            this.f8669b = cls2;
            this.f8670c = vVar;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return a(cls) && this.f8669b.isAssignableFrom(cls2);
        }

        public boolean a(Class<?> cls) {
            return this.f8668a.isAssignableFrom(cls);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MultiModelLoaderFactory.java */
    /* loaded from: classes.dex */
    public static class c {
        c() {
        }

        public <Model, Data> x<Model, Data> a(List<u<Model, Data>> list, Pools.Pool<List<Throwable>> pool) {
            return new x<>(list, pool);
        }
    }

    public y(Pools.Pool<List<Throwable>> pool) {
        this(pool, f8662a);
    }

    public synchronized <Model, Data> void a(Class<Model> cls, Class<Data> cls2, v<? extends Model, ? extends Data> vVar) {
        a(cls, cls2, vVar, true);
    }

    public synchronized List<Class<?>> b(Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b<?, ?> bVar : this.f8664c) {
            if (!arrayList.contains(bVar.f8669b) && bVar.a(cls)) {
                arrayList.add(bVar.f8669b);
            }
        }
        return arrayList;
    }

    y(Pools.Pool<List<Throwable>> pool, c cVar) {
        this.f8664c = new ArrayList();
        this.f8666e = new HashSet();
        this.f8667f = pool;
        this.f8665d = cVar;
    }

    private <Model, Data> void a(Class<Model> cls, Class<Data> cls2, v<? extends Model, ? extends Data> vVar, boolean z) {
        b<?, ?> bVar = new b<>(cls, cls2, vVar);
        List<b<?, ?>> list = this.f8664c;
        list.add(z ? list.size() : 0, bVar);
    }

    public synchronized <Model> List<u<Model, ?>> a(Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b<?, ?> bVar : this.f8664c) {
                if (!this.f8666e.contains(bVar) && bVar.a(cls)) {
                    this.f8666e.add(bVar);
                    arrayList.add(a(bVar));
                    this.f8666e.remove(bVar);
                }
            }
        } finally {
        }
        return arrayList;
    }

    public synchronized <Model, Data> u<Model, Data> a(Class<Model> cls, Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (b<?, ?> bVar : this.f8664c) {
                if (this.f8666e.contains(bVar)) {
                    z = true;
                } else if (bVar.a(cls, cls2)) {
                    this.f8666e.add(bVar);
                    arrayList.add(a(bVar));
                    this.f8666e.remove(bVar);
                }
            }
            if (arrayList.size() > 1) {
                return this.f8665d.a(arrayList, this.f8667f);
            }
            if (arrayList.size() == 1) {
                return (u) arrayList.get(0);
            }
            if (z) {
                return a();
            }
            throw new Registry.NoModelLoaderAvailableException(cls, cls2);
        } catch (Throwable th) {
            this.f8666e.clear();
            throw th;
        }
    }

    private <Model, Data> u<Model, Data> a(b<?, ?> bVar) {
        Object a2 = bVar.f8670c.a(this);
        com.bumptech.glide.g.l.a(a2);
        return (u) a2;
    }

    private static <Model, Data> u<Model, Data> a() {
        return (u<Model, Data>) f8663b;
    }
}
