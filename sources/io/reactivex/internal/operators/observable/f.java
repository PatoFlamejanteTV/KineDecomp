package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.q;
import java.util.Iterator;

/* compiled from: ObservableFromIterable.java */
/* loaded from: classes3.dex */
public final class f<T> extends io.reactivex.m<T> {

    /* renamed from: a, reason: collision with root package name */
    final Iterable<? extends T> f28326a;

    /* compiled from: ObservableFromIterable.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends io.reactivex.internal.observers.b<T> {

        /* renamed from: a, reason: collision with root package name */
        final q<? super T> f28327a;

        /* renamed from: b, reason: collision with root package name */
        final Iterator<? extends T> f28328b;

        /* renamed from: c, reason: collision with root package name */
        volatile boolean f28329c;

        /* renamed from: d, reason: collision with root package name */
        boolean f28330d;

        /* renamed from: e, reason: collision with root package name */
        boolean f28331e;

        /* renamed from: f, reason: collision with root package name */
        boolean f28332f;

        a(q<? super T> qVar, Iterator<? extends T> it) {
            this.f28327a = qVar;
            this.f28328b = it;
        }

        void a() {
            while (!isDisposed()) {
                try {
                    T next = this.f28328b.next();
                    io.reactivex.d.a.b.a((Object) next, "The iterator returned a null value");
                    this.f28327a.onNext(next);
                    if (isDisposed()) {
                        return;
                    }
                    try {
                        if (!this.f28328b.hasNext()) {
                            if (isDisposed()) {
                                return;
                            }
                            this.f28327a.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        this.f28327a.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.f28327a.onError(th2);
                    return;
                }
            }
        }

        @Override // io.reactivex.d.b.n
        public void clear() {
            this.f28331e = true;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f28329c = true;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f28329c;
        }

        @Override // io.reactivex.d.b.n
        public boolean isEmpty() {
            return this.f28331e;
        }

        @Override // io.reactivex.d.b.n
        public T poll() {
            if (this.f28331e) {
                return null;
            }
            if (this.f28332f) {
                if (!this.f28328b.hasNext()) {
                    this.f28331e = true;
                    return null;
                }
            } else {
                this.f28332f = true;
            }
            T next = this.f28328b.next();
            io.reactivex.d.a.b.a((Object) next, "The iterator returned a null value");
            return next;
        }

        @Override // io.reactivex.d.b.j
        public int requestFusion(int i) {
            if ((i & 1) == 0) {
                return 0;
            }
            this.f28330d = true;
            return 1;
        }
    }

    public f(Iterable<? extends T> iterable) {
        this.f28326a = iterable;
    }

    @Override // io.reactivex.m
    public void b(q<? super T> qVar) {
        try {
            Iterator<? extends T> it = this.f28326a.iterator();
            try {
                if (!it.hasNext()) {
                    EmptyDisposable.complete(qVar);
                    return;
                }
                a aVar = new a(qVar, it);
                qVar.onSubscribe(aVar);
                if (aVar.f28330d) {
                    return;
                }
                aVar.a();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                EmptyDisposable.error(th, qVar);
            }
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            EmptyDisposable.error(th2, qVar);
        }
    }
}
