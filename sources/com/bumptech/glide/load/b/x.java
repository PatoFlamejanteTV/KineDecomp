package com.bumptech.glide.load.b;

import android.support.v4.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.engine.GlideException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MultiModelLoader.java */
/* loaded from: classes.dex */
public class x<Model, Data> implements u<Model, Data> {

    /* renamed from: a, reason: collision with root package name */
    private final List<u<Model, Data>> f8653a;

    /* renamed from: b, reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f8654b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(List<u<Model, Data>> list, Pools.Pool<List<Throwable>> pool) {
        this.f8653a = list;
        this.f8654b = pool;
    }

    @Override // com.bumptech.glide.load.b.u
    public u.a<Data> a(Model model, int i, int i2, com.bumptech.glide.load.g gVar) {
        u.a<Data> a2;
        int size = this.f8653a.size();
        ArrayList arrayList = new ArrayList(size);
        com.bumptech.glide.load.c cVar = null;
        for (int i3 = 0; i3 < size; i3++) {
            u<Model, Data> uVar = this.f8653a.get(i3);
            if (uVar.a(model) && (a2 = uVar.a(model, i, i2, gVar)) != null) {
                cVar = a2.f8646a;
                arrayList.add(a2.f8648c);
            }
        }
        if (arrayList.isEmpty() || cVar == null) {
            return null;
        }
        return new u.a<>(cVar, new a(arrayList, this.f8654b));
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f8653a.toArray()) + '}';
    }

    /* compiled from: MultiModelLoader.java */
    /* loaded from: classes.dex */
    static class a<Data> implements com.bumptech.glide.load.a.d<Data>, d.a<Data> {

        /* renamed from: a, reason: collision with root package name */
        private final List<com.bumptech.glide.load.a.d<Data>> f8655a;

        /* renamed from: b, reason: collision with root package name */
        private final Pools.Pool<List<Throwable>> f8656b;

        /* renamed from: c, reason: collision with root package name */
        private int f8657c;

        /* renamed from: d, reason: collision with root package name */
        private Priority f8658d;

        /* renamed from: e, reason: collision with root package name */
        private d.a<? super Data> f8659e;

        /* renamed from: f, reason: collision with root package name */
        private List<Throwable> f8660f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f8661g;

        a(List<com.bumptech.glide.load.a.d<Data>> list, Pools.Pool<List<Throwable>> pool) {
            this.f8656b = pool;
            com.bumptech.glide.g.l.a(list);
            this.f8655a = list;
            this.f8657c = 0;
        }

        private void d() {
            if (this.f8661g) {
                return;
            }
            if (this.f8657c < this.f8655a.size() - 1) {
                this.f8657c++;
                a(this.f8658d, this.f8659e);
            } else {
                com.bumptech.glide.g.l.a(this.f8660f);
                this.f8659e.a((Exception) new GlideException("Fetch failed", new ArrayList(this.f8660f)));
            }
        }

        @Override // com.bumptech.glide.load.a.d
        public void a(Priority priority, d.a<? super Data> aVar) {
            this.f8658d = priority;
            this.f8659e = aVar;
            this.f8660f = this.f8656b.acquire();
            this.f8655a.get(this.f8657c).a(priority, this);
            if (this.f8661g) {
                cancel();
            }
        }

        @Override // com.bumptech.glide.load.a.d
        public void b() {
            List<Throwable> list = this.f8660f;
            if (list != null) {
                this.f8656b.release(list);
            }
            this.f8660f = null;
            Iterator<com.bumptech.glide.load.a.d<Data>> it = this.f8655a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }

        @Override // com.bumptech.glide.load.a.d
        public DataSource c() {
            return this.f8655a.get(0).c();
        }

        @Override // com.bumptech.glide.load.a.d
        public void cancel() {
            this.f8661g = true;
            Iterator<com.bumptech.glide.load.a.d<Data>> it = this.f8655a.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
        }

        @Override // com.bumptech.glide.load.a.d
        public Class<Data> a() {
            return this.f8655a.get(0).a();
        }

        @Override // com.bumptech.glide.load.a.d.a
        public void a(Data data) {
            if (data != null) {
                this.f8659e.a((d.a<? super Data>) data);
            } else {
                d();
            }
        }

        @Override // com.bumptech.glide.load.a.d.a
        public void a(Exception exc) {
            List<Throwable> list = this.f8660f;
            com.bumptech.glide.g.l.a(list);
            list.add(exc);
            d();
        }
    }

    @Override // com.bumptech.glide.load.b.u
    public boolean a(Model model) {
        Iterator<u<Model, Data>> it = this.f8653a.iterator();
        while (it.hasNext()) {
            if (it.next().a(model)) {
                return true;
            }
        }
        return false;
    }
}
