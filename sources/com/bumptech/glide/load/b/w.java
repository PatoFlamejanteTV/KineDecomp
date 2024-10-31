package com.bumptech.glide.load.b;

import android.support.v4.util.Pools;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ModelLoaderRegistry.java */
/* loaded from: classes.dex */
public class w {

    /* renamed from: a */
    private final y f8649a;

    /* renamed from: b */
    private final a f8650b;

    /* compiled from: ModelLoaderRegistry.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        private final Map<Class<?>, C0052a<?>> f8651a = new HashMap();

        /* compiled from: ModelLoaderRegistry.java */
        /* renamed from: com.bumptech.glide.load.b.w$a$a */
        /* loaded from: classes.dex */
        public static class C0052a<Model> {

            /* renamed from: a */
            final List<u<Model, ?>> f8652a;

            public C0052a(List<u<Model, ?>> list) {
                this.f8652a = list;
            }
        }

        a() {
        }

        public void a() {
            this.f8651a.clear();
        }

        public <Model> void a(Class<Model> cls, List<u<Model, ?>> list) {
            if (this.f8651a.put(cls, new C0052a<>(list)) == null) {
                return;
            }
            throw new IllegalStateException("Already cached loaders for model: " + cls);
        }

        public <Model> List<u<Model, ?>> a(Class<Model> cls) {
            C0052a<?> c0052a = this.f8651a.get(cls);
            if (c0052a == null) {
                return null;
            }
            return (List<u<Model, ?>>) c0052a.f8652a;
        }
    }

    public w(Pools.Pool<List<Throwable>> pool) {
        this(new y(pool));
    }

    private synchronized <A> List<u<A, ?>> b(Class<A> cls) {
        List<u<A, ?>> a2;
        a2 = this.f8650b.a(cls);
        if (a2 == null) {
            a2 = Collections.unmodifiableList(this.f8649a.a(cls));
            this.f8650b.a(cls, a2);
        }
        return a2;
    }

    public synchronized <Model, Data> void a(Class<Model> cls, Class<Data> cls2, v<? extends Model, ? extends Data> vVar) {
        this.f8649a.a(cls, cls2, vVar);
        this.f8650b.a();
    }

    private w(y yVar) {
        this.f8650b = new a();
        this.f8649a = yVar;
    }

    public <A> List<u<A, ?>> a(A a2) {
        List<u<A, ?>> b2 = b((Class) b(a2));
        int size = b2.size();
        List<u<A, ?>> emptyList = Collections.emptyList();
        boolean z = true;
        for (int i = 0; i < size; i++) {
            u<A, ?> uVar = b2.get(i);
            if (uVar.a(a2)) {
                if (z) {
                    emptyList = new ArrayList<>(size - i);
                    z = false;
                }
                emptyList.add(uVar);
            }
        }
        return emptyList;
    }

    private static <A> Class<A> b(A a2) {
        return (Class<A>) a2.getClass();
    }

    public synchronized List<Class<?>> a(Class<?> cls) {
        return this.f8649a.b(cls);
    }
}
