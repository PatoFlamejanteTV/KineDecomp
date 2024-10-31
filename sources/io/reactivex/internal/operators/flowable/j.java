package io.reactivex.internal.operators.flowable;

/* compiled from: FlowableMap.java */
/* loaded from: classes3.dex */
public final class j<T, U> extends io.reactivex.internal.operators.flowable.a<T, U> {

    /* renamed from: c, reason: collision with root package name */
    final io.reactivex.c.f<? super T, ? extends U> f28239c;

    /* compiled from: FlowableMap.java */
    /* loaded from: classes3.dex */
    static final class a<T, U> extends io.reactivex.internal.subscribers.a<T, U> {

        /* renamed from: f, reason: collision with root package name */
        final io.reactivex.c.f<? super T, ? extends U> f28240f;

        a(io.reactivex.d.b.a<? super U> aVar, io.reactivex.c.f<? super T, ? extends U> fVar) {
            super(aVar);
            this.f28240f = fVar;
        }

        @Override // io.reactivex.d.b.a
        public boolean a(T t) {
            if (this.f28468d) {
                return false;
            }
            try {
                U apply = this.f28240f.apply(t);
                io.reactivex.d.a.b.a(apply, "The mapper function returned a null value.");
                return this.f28465a.a(apply);
            } catch (Throwable th) {
                a(th);
                return true;
            }
        }

        @Override // g.b.b
        public void onNext(T t) {
            if (this.f28468d) {
                return;
            }
            if (this.f28469e != 0) {
                this.f28465a.onNext(null);
                return;
            }
            try {
                U apply = this.f28240f.apply(t);
                io.reactivex.d.a.b.a(apply, "The mapper function returned a null value.");
                this.f28465a.onNext(apply);
            } catch (Throwable th) {
                a(th);
            }
        }

        @Override // io.reactivex.d.b.n
        public U poll() throws Exception {
            T poll = this.f28467c.poll();
            if (poll == null) {
                return null;
            }
            U apply = this.f28240f.apply(poll);
            io.reactivex.d.a.b.a(apply, "The mapper function returned a null value.");
            return apply;
        }

        @Override // io.reactivex.d.b.j
        public int requestFusion(int i) {
            return a(i);
        }
    }

    /* compiled from: FlowableMap.java */
    /* loaded from: classes3.dex */
    static final class b<T, U> extends io.reactivex.internal.subscribers.b<T, U> {

        /* renamed from: f, reason: collision with root package name */
        final io.reactivex.c.f<? super T, ? extends U> f28241f;

        b(g.b.b<? super U> bVar, io.reactivex.c.f<? super T, ? extends U> fVar) {
            super(bVar);
            this.f28241f = fVar;
        }

        @Override // g.b.b
        public void onNext(T t) {
            if (this.f28473d) {
                return;
            }
            if (this.f28474e != 0) {
                this.f28470a.onNext(null);
                return;
            }
            try {
                U apply = this.f28241f.apply(t);
                io.reactivex.d.a.b.a(apply, "The mapper function returned a null value.");
                this.f28470a.onNext(apply);
            } catch (Throwable th) {
                a(th);
            }
        }

        @Override // io.reactivex.d.b.n
        public U poll() throws Exception {
            T poll = this.f28472c.poll();
            if (poll == null) {
                return null;
            }
            U apply = this.f28241f.apply(poll);
            io.reactivex.d.a.b.a(apply, "The mapper function returned a null value.");
            return apply;
        }

        @Override // io.reactivex.d.b.j
        public int requestFusion(int i) {
            return a(i);
        }
    }

    public j(io.reactivex.e<T> eVar, io.reactivex.c.f<? super T, ? extends U> fVar) {
        super(eVar);
        this.f28239c = fVar;
    }

    @Override // io.reactivex.e
    protected void b(g.b.b<? super U> bVar) {
        if (bVar instanceof io.reactivex.d.b.a) {
            this.f28211b.a((io.reactivex.h) new a((io.reactivex.d.b.a) bVar, this.f28239c));
        } else {
            this.f28211b.a((io.reactivex.h) new b(bVar, this.f28239c));
        }
    }
}
