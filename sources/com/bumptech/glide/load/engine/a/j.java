package com.bumptech.glide.load.engine.a;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* compiled from: LruArrayPool.java */
/* loaded from: classes.dex */
public final class j implements com.bumptech.glide.load.engine.a.b {

    /* renamed from: a */
    private final h<a, Object> f8806a = new h<>();

    /* renamed from: b */
    private final b f8807b = new b();

    /* renamed from: c */
    private final Map<Class<?>, NavigableMap<Integer, Integer>> f8808c = new HashMap();

    /* renamed from: d */
    private final Map<Class<?>, com.bumptech.glide.load.engine.a.a<?>> f8809d = new HashMap();

    /* renamed from: e */
    private final int f8810e;

    /* renamed from: f */
    private int f8811f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LruArrayPool.java */
    /* loaded from: classes.dex */
    public static final class b extends d<a> {
        b() {
        }

        a a(int i, Class<?> cls) {
            a b2 = b();
            b2.a(i, cls);
            return b2;
        }

        @Override // com.bumptech.glide.load.engine.a.d
        public a a() {
            return new a(this);
        }
    }

    public j(int i) {
        this.f8810e = i;
    }

    private boolean c(int i) {
        return i <= this.f8810e / 2;
    }

    @Override // com.bumptech.glide.load.engine.a.b
    public synchronized <T> T a(int i, Class<T> cls) {
        a a2;
        Integer ceilingKey = b((Class<?>) cls).ceilingKey(Integer.valueOf(i));
        if (a(i, ceilingKey)) {
            a2 = this.f8807b.a(ceilingKey.intValue(), cls);
        } else {
            a2 = this.f8807b.a(i, cls);
        }
        return (T) a(a2, cls);
    }

    @Override // com.bumptech.glide.load.engine.a.b
    public synchronized <T> T b(int i, Class<T> cls) {
        return (T) a(this.f8807b.a(i, cls), cls);
    }

    @Override // com.bumptech.glide.load.engine.a.b
    public synchronized <T> void put(T t) {
        Class<?> cls = t.getClass();
        com.bumptech.glide.load.engine.a.a<T> a2 = a((Class) cls);
        int a3 = a2.a(t);
        int a4 = a2.a() * a3;
        if (c(a4)) {
            a a5 = this.f8807b.a(a3, cls);
            this.f8806a.a(a5, t);
            NavigableMap<Integer, Integer> b2 = b(cls);
            Integer num = (Integer) b2.get(Integer.valueOf(a5.f8813b));
            Integer valueOf = Integer.valueOf(a5.f8813b);
            int i = 1;
            if (num != null) {
                i = 1 + num.intValue();
            }
            b2.put(valueOf, Integer.valueOf(i));
            this.f8811f += a4;
            b();
        }
    }

    /* compiled from: LruArrayPool.java */
    /* loaded from: classes.dex */
    public static final class a implements m {

        /* renamed from: a */
        private final b f8812a;

        /* renamed from: b */
        int f8813b;

        /* renamed from: c */
        private Class<?> f8814c;

        a(b bVar) {
            this.f8812a = bVar;
        }

        void a(int i, Class<?> cls) {
            this.f8813b = i;
            this.f8814c = cls;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f8813b == aVar.f8813b && this.f8814c == aVar.f8814c;
        }

        public int hashCode() {
            int i = this.f8813b * 31;
            Class<?> cls = this.f8814c;
            return i + (cls != null ? cls.hashCode() : 0);
        }

        public String toString() {
            return "Key{size=" + this.f8813b + "array=" + this.f8814c + '}';
        }

        @Override // com.bumptech.glide.load.engine.a.m
        public void a() {
            this.f8812a.a(this);
        }
    }

    private boolean c() {
        int i = this.f8811f;
        return i == 0 || this.f8810e / i >= 2;
    }

    private void b() {
        b(this.f8810e);
    }

    private void c(int i, Class<?> cls) {
        NavigableMap<Integer, Integer> b2 = b(cls);
        Integer num = (Integer) b2.get(Integer.valueOf(i));
        if (num != null) {
            if (num.intValue() == 1) {
                b2.remove(Integer.valueOf(i));
                return;
            } else {
                b2.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i + ", this: " + this);
    }

    private void b(int i) {
        while (this.f8811f > i) {
            Object a2 = this.f8806a.a();
            com.bumptech.glide.g.l.a(a2);
            com.bumptech.glide.load.engine.a.a a3 = a((j) a2);
            this.f8811f -= a3.a(a2) * a3.a();
            c(a3.a(a2), a2.getClass());
            if (Log.isLoggable(a3.getTag(), 2)) {
                Log.v(a3.getTag(), "evicted: " + a3.a(a2));
            }
        }
    }

    private <T> T a(a aVar, Class<T> cls) {
        com.bumptech.glide.load.engine.a.a<T> a2 = a((Class) cls);
        T t = (T) a(aVar);
        if (t != null) {
            this.f8811f -= a2.a(t) * a2.a();
            c(a2.a(t), cls);
        }
        if (t != null) {
            return t;
        }
        if (Log.isLoggable(a2.getTag(), 2)) {
            Log.v(a2.getTag(), "Allocated " + aVar.f8813b + " bytes");
        }
        return a2.newArray(aVar.f8813b);
    }

    private NavigableMap<Integer, Integer> b(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.f8808c.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f8808c.put(cls, treeMap);
        return treeMap;
    }

    private <T> T a(a aVar) {
        return (T) this.f8806a.a((h<a, Object>) aVar);
    }

    private boolean a(int i, Integer num) {
        return num != null && (c() || num.intValue() <= i * 8);
    }

    @Override // com.bumptech.glide.load.engine.a.b
    public synchronized void a() {
        b(0);
    }

    @Override // com.bumptech.glide.load.engine.a.b
    public synchronized void a(int i) {
        try {
            if (i >= 40) {
                a();
            } else if (i >= 20 || i == 15) {
                b(this.f8810e / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private <T> com.bumptech.glide.load.engine.a.a<T> a(T t) {
        return a((Class) t.getClass());
    }

    private <T> com.bumptech.glide.load.engine.a.a<T> a(Class<T> cls) {
        com.bumptech.glide.load.engine.a.a<T> aVar = (com.bumptech.glide.load.engine.a.a) this.f8809d.get(cls);
        if (aVar == null) {
            if (cls.equals(int[].class)) {
                aVar = new i();
            } else if (cls.equals(byte[].class)) {
                aVar = new g();
            } else {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            }
            this.f8809d.put(cls, aVar);
        }
        return aVar;
    }
}
