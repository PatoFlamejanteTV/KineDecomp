package io.reactivex.internal.operators.flowable;

/* compiled from: FlowableFilter.java */
/* loaded from: classes3.dex */
public final class g<T> extends io.reactivex.internal.operators.flowable.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final io.reactivex.c.h<? super T> f28232c;

    /* compiled from: FlowableFilter.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends io.reactivex.internal.subscribers.a<T, T> {

        /* renamed from: f, reason: collision with root package name */
        final io.reactivex.c.h<? super T> f28233f;

        a(io.reactivex.d.b.a<? super T> aVar, io.reactivex.c.h<? super T> hVar) {
            super(aVar);
            this.f28233f = hVar;
        }

        @Override // io.reactivex.d.b.a
        public boolean a(T t) {
            if (this.f28468d) {
                return false;
            }
            if (this.f28469e != 0) {
                return this.f28465a.a(null);
            }
            try {
                return this.f28233f.test(t) && this.f28465a.a(t);
            } catch (Throwable th) {
                a(th);
                return true;
            }
        }

        @Override // g.b.b
        public void onNext(T t) {
            if (a((a<T>) t)) {
                return;
            }
            this.f28466b.request(1L);
        }

        @Override // io.reactivex.d.b.n
        public T poll() throws Exception {
            io.reactivex.d.b.k<T> kVar = this.f28467c;
            io.reactivex.c.h<? super T> hVar = this.f28233f;
            while (true) {
                T poll = kVar.poll();
                if (poll == null) {
                    return null;
                }
                if (hVar.test(poll)) {
                    return poll;
                }
                if (this.f28469e == 2) {
                    kVar.request(1L);
                }
            }
        }

        @Override // io.reactivex.d.b.j
        public int requestFusion(int i) {
            return a(i);
        }
    }

    /* compiled from: FlowableFilter.java */
    /* loaded from: classes3.dex */
    static final class b<T> extends io.reactivex.internal.subscribers.b<T, T> implements io.reactivex.d.b.a<T> {

        /* renamed from: f, reason: collision with root package name */
        final io.reactivex.c.h<? super T> f28234f;

        b(g.b.b<? super T> bVar, io.reactivex.c.h<? super T> hVar) {
            super(bVar);
            this.f28234f = hVar;
        }

        @Override // io.reactivex.d.b.a
        public boolean a(T t) {
            if (this.f28473d) {
                return false;
            }
            if (this.f28474e != 0) {
                this.f28470a.onNext(null);
                return true;
            }
            try {
                boolean test = this.f28234f.test(t);
                if (test) {
                    this.f28470a.onNext(t);
                }
                return test;
            } catch (Throwable th) {
                a(th);
                return true;
            }
        }

        @Override // g.b.b
        public void onNext(T t) {
            if (a((b<T>) t)) {
                return;
            }
            this.f28471b.request(1L);
        }

        @Override // io.reactivex.d.b.n
        public T poll() throws Exception {
            io.reactivex.d.b.k<T> kVar = this.f28472c;
            io.reactivex.c.h<? super T> hVar = this.f28234f;
            while (true) {
                T poll = kVar.poll();
                if (poll == null) {
                    return null;
                }
                if (hVar.test(poll)) {
                    return poll;
                }
                if (this.f28474e == 2) {
                    kVar.request(1L);
                }
            }
        }

        @Override // io.reactivex.d.b.j
        public int requestFusion(int i) {
            return a(i);
        }
    }

    public g(io.reactivex.e<T> eVar, io.reactivex.c.h<? super T> hVar) {
        super(eVar);
        this.f28232c = hVar;
    }

    @Override // io.reactivex.e
    protected void b(g.b.b<? super T> bVar) {
        if (bVar instanceof io.reactivex.d.b.a) {
            this.f28211b.a((io.reactivex.h) new a((io.reactivex.d.b.a) bVar, this.f28232c));
        } else {
            this.f28211b.a((io.reactivex.h) new b(bVar, this.f28232c));
        }
    }
}
