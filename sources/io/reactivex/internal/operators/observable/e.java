package io.reactivex.internal.operators.observable;

import io.reactivex.p;
import io.reactivex.q;

/* compiled from: ObservableFilter.java */
/* loaded from: classes3.dex */
public final class e<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final io.reactivex.c.h<? super T> f28324b;

    /* compiled from: ObservableFilter.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends io.reactivex.internal.observers.a<T, T> {

        /* renamed from: f, reason: collision with root package name */
        final io.reactivex.c.h<? super T> f28325f;

        a(q<? super T> qVar, io.reactivex.c.h<? super T> hVar) {
            super(qVar);
            this.f28325f = hVar;
        }

        @Override // io.reactivex.q
        public void onNext(T t) {
            if (this.f28148e == 0) {
                try {
                    if (this.f28325f.test(t)) {
                        this.f28144a.onNext(t);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    a(th);
                    return;
                }
            }
            this.f28144a.onNext(null);
        }

        @Override // io.reactivex.d.b.n
        public T poll() throws Exception {
            T poll;
            do {
                poll = this.f28146c.poll();
                if (poll == null) {
                    break;
                }
            } while (!this.f28325f.test(poll));
            return poll;
        }

        @Override // io.reactivex.d.b.j
        public int requestFusion(int i) {
            return a(i);
        }
    }

    public e(p<T> pVar, io.reactivex.c.h<? super T> hVar) {
        super(pVar);
        this.f28324b = hVar;
    }

    @Override // io.reactivex.m
    public void b(q<? super T> qVar) {
        this.f28315a.a(new a(qVar, this.f28324b));
    }
}
