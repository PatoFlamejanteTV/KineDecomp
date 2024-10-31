package com.bumptech.glide.load.engine;

import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.engine.DecodeJob;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DecodeHelper.java */
/* renamed from: com.bumptech.glide.load.engine.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0719i<Transcode> {

    /* renamed from: a, reason: collision with root package name */
    private final List<u.a<?>> f8909a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final List<com.bumptech.glide.load.c> f8910b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private com.bumptech.glide.e f8911c;

    /* renamed from: d, reason: collision with root package name */
    private Object f8912d;

    /* renamed from: e, reason: collision with root package name */
    private int f8913e;

    /* renamed from: f, reason: collision with root package name */
    private int f8914f;

    /* renamed from: g, reason: collision with root package name */
    private Class<?> f8915g;

    /* renamed from: h, reason: collision with root package name */
    private DecodeJob.d f8916h;
    private com.bumptech.glide.load.g i;
    private Map<Class<?>, com.bumptech.glide.load.j<?>> j;
    private Class<Transcode> k;
    private boolean l;
    private boolean m;
    private com.bumptech.glide.load.c n;
    private Priority o;
    private q p;
    private boolean q;
    private boolean r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public <R> void a(com.bumptech.glide.e eVar, Object obj, com.bumptech.glide.load.c cVar, int i, int i2, q qVar, Class<?> cls, Class<R> cls2, Priority priority, com.bumptech.glide.load.g gVar, Map<Class<?>, com.bumptech.glide.load.j<?>> map, boolean z, boolean z2, DecodeJob.d dVar) {
        this.f8911c = eVar;
        this.f8912d = obj;
        this.n = cVar;
        this.f8913e = i;
        this.f8914f = i2;
        this.p = qVar;
        this.f8915g = cls;
        this.f8916h = dVar;
        this.k = cls2;
        this.o = priority;
        this.i = gVar;
        this.j = map;
        this.q = z;
        this.r = z2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.load.engine.a.b b() {
        return this.f8911c.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean c(Class<?> cls) {
        return a((Class) cls) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.load.engine.b.a d() {
        return this.f8916h.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q e() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f8914f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<u.a<?>> g() {
        if (!this.l) {
            this.l = true;
            this.f8909a.clear();
            List a2 = this.f8911c.f().a((Registry) this.f8912d);
            int size = a2.size();
            for (int i = 0; i < size; i++) {
                u.a<?> a3 = ((com.bumptech.glide.load.b.u) a2.get(i)).a(this.f8912d, this.f8913e, this.f8914f, this.i);
                if (a3 != null) {
                    this.f8909a.add(a3);
                }
            }
        }
        return this.f8909a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class<?> h() {
        return this.f8912d.getClass();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.load.g i() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Priority j() {
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Class<?>> k() {
        return this.f8911c.f().b(this.f8912d.getClass(), this.f8915g, this.k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.load.c l() {
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class<?> m() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int n() {
        return this.f8913e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean o() {
        return this.r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <Z> com.bumptech.glide.load.j<Z> b(Class<Z> cls) {
        com.bumptech.glide.load.j<Z> jVar = (com.bumptech.glide.load.j) this.j.get(cls);
        if (jVar == null) {
            Iterator<Map.Entry<Class<?>, com.bumptech.glide.load.j<?>>> it = this.j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Class<?>, com.bumptech.glide.load.j<?>> next = it.next();
                if (next.getKey().isAssignableFrom(cls)) {
                    jVar = (com.bumptech.glide.load.j) next.getValue();
                    break;
                }
            }
        }
        if (jVar != null) {
            return jVar;
        }
        if (this.j.isEmpty() && this.q) {
            throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
        }
        return com.bumptech.glide.load.c.b.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.bumptech.glide.load.c> c() {
        if (!this.m) {
            this.m = true;
            this.f8910b.clear();
            List<u.a<?>> g2 = g();
            int size = g2.size();
            for (int i = 0; i < size; i++) {
                u.a<?> aVar = g2.get(i);
                if (!this.f8910b.contains(aVar.f8646a)) {
                    this.f8910b.add(aVar.f8646a);
                }
                for (int i2 = 0; i2 < aVar.f8647b.size(); i2++) {
                    if (!this.f8910b.contains(aVar.f8647b.get(i2))) {
                        this.f8910b.add(aVar.f8647b.get(i2));
                    }
                }
            }
        }
        return this.f8910b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(E<?> e2) {
        return this.f8911c.f().b(e2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f8911c = null;
        this.f8912d = null;
        this.n = null;
        this.f8915g = null;
        this.k = null;
        this.i = null;
        this.o = null;
        this.j = null;
        this.p = null;
        this.f8909a.clear();
        this.l = false;
        this.f8910b.clear();
        this.m = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <Data> B<Data, ?, Transcode> a(Class<Data> cls) {
        return this.f8911c.f().a(cls, this.f8915g, this.k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <Z> com.bumptech.glide.load.i<Z> a(E<Z> e2) {
        return this.f8911c.f().a((E) e2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.bumptech.glide.load.b.u<File, ?>> a(File file) throws Registry.NoModelLoaderAvailableException {
        return this.f8911c.f().a((Registry) file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(com.bumptech.glide.load.c cVar) {
        List<u.a<?>> g2 = g();
        int size = g2.size();
        for (int i = 0; i < size; i++) {
            if (g2.get(i).f8646a.equals(cVar)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <X> com.bumptech.glide.load.a<X> a(X x) throws Registry.NoSourceEncoderAvailableException {
        return this.f8911c.f().c(x);
    }
}
