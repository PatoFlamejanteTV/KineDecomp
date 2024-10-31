package com.bumptech.glide.load.b;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.b.u;

/* compiled from: UnitModelLoader.java */
/* loaded from: classes.dex */
public class C<Model> implements u<Model, Model> {

    /* renamed from: a, reason: collision with root package name */
    private static final C<?> f8576a = new C<>();

    /* compiled from: UnitModelLoader.java */
    /* loaded from: classes.dex */
    public static class a<Model> implements v<Model, Model> {

        /* renamed from: a, reason: collision with root package name */
        private static final a<?> f8577a = new a<>();

        @Deprecated
        public a() {
        }

        public static <T> a<T> a() {
            return (a<T>) f8577a;
        }

        @Override // com.bumptech.glide.load.b.v
        public u<Model, Model> a(y yVar) {
            return C.a();
        }
    }

    /* compiled from: UnitModelLoader.java */
    /* loaded from: classes.dex */
    private static class b<Model> implements com.bumptech.glide.load.a.d<Model> {

        /* renamed from: a, reason: collision with root package name */
        private final Model f8578a;

        b(Model model) {
            this.f8578a = model;
        }

        @Override // com.bumptech.glide.load.a.d
        public void a(Priority priority, d.a<? super Model> aVar) {
            aVar.a((d.a<? super Model>) this.f8578a);
        }

        @Override // com.bumptech.glide.load.a.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.a.d
        public DataSource c() {
            return DataSource.LOCAL;
        }

        @Override // com.bumptech.glide.load.a.d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.a.d
        public Class<Model> a() {
            return (Class<Model>) this.f8578a.getClass();
        }
    }

    @Deprecated
    public C() {
    }

    public static <T> C<T> a() {
        return (C<T>) f8576a;
    }

    @Override // com.bumptech.glide.load.b.u
    public boolean a(Model model) {
        return true;
    }

    @Override // com.bumptech.glide.load.b.u
    public u.a<Model> a(Model model, int i, int i2, com.bumptech.glide.load.g gVar) {
        return new u.a<>(new com.bumptech.glide.f.c(model), new b(model));
    }
}
