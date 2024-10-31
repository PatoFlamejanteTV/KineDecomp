package io.reactivex.internal.operators.observable;

import io.reactivex.p;
import io.reactivex.q;

/* compiled from: ObservableMap.java */
/* loaded from: classes3.dex */
public final class i<T, U> extends io.reactivex.internal.operators.observable.a<T, U> {

    /* renamed from: b, reason: collision with root package name */
    final io.reactivex.c.f<? super T, ? extends U> f28337b;

    /* compiled from: ObservableMap.java */
    /* loaded from: classes3.dex */
    static final class a<T, U> extends io.reactivex.internal.observers.a<T, U> {

        /* renamed from: f, reason: collision with root package name */
        final io.reactivex.c.f<? super T, ? extends U> f28338f;

        a(q<? super U> qVar, io.reactivex.c.f<? super T, ? extends U> fVar) {
            super(qVar);
            this.f28338f = fVar;
        }

        @Override // io.reactivex.q
        public void onNext(T t) {
            if (this.f28147d) {
                return;
            }
            if (this.f28148e != 0) {
                this.f28144a.onNext(null);
                return;
            }
            try {
                U apply = this.f28338f.apply(t);
                io.reactivex.d.a.b.a(apply, "The mapper function returned a null value.");
                this.f28144a.onNext(apply);
            } catch (Throwable th) {
                a(th);
            }
        }

        @Override // io.reactivex.d.b.n
        public U poll() throws Exception {
            T poll = this.f28146c.poll();
            if (poll == null) {
                return null;
            }
            U apply = this.f28338f.apply(poll);
            io.reactivex.d.a.b.a(apply, "The mapper function returned a null value.");
            return apply;
        }

        @Override // io.reactivex.d.b.j
        public int requestFusion(int i) {
            return a(i);
        }
    }

    public i(p<T> pVar, io.reactivex.c.f<? super T, ? extends U> fVar) {
        super(pVar);
        this.f28337b = fVar;
    }

    @Override // io.reactivex.m
    public void b(q<? super U> qVar) {
        this.f28315a.a(new a(qVar, this.f28337b));
    }
}
