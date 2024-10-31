package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.p;
import io.reactivex.q;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class ObservableScalarXMap {

    /* loaded from: classes3.dex */
    public static final class ScalarDisposable<T> extends AtomicInteger implements io.reactivex.d.b.i<T>, Runnable {
        static final int FUSED = 1;
        static final int ON_COMPLETE = 3;
        static final int ON_NEXT = 2;
        static final int START = 0;
        private static final long serialVersionUID = 3880992722410194083L;
        final q<? super T> observer;
        final T value;

        public ScalarDisposable(q<? super T> qVar, T t) {
            this.observer = qVar;
            this.value = t;
        }

        @Override // io.reactivex.d.b.n
        public void clear() {
            lazySet(3);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            set(3);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() == 3;
        }

        @Override // io.reactivex.d.b.n
        public boolean isEmpty() {
            return get() != 1;
        }

        @Override // io.reactivex.d.b.n
        public boolean offer(T t) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // io.reactivex.d.b.n
        public T poll() throws Exception {
            if (get() != 1) {
                return null;
            }
            lazySet(3);
            return this.value;
        }

        @Override // io.reactivex.d.b.j
        public int requestFusion(int i) {
            if ((i & 1) == 0) {
                return 0;
            }
            lazySet(1);
            return 1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() == 0 && compareAndSet(0, 2)) {
                this.observer.onNext(this.value);
                if (get() == 2) {
                    lazySet(3);
                    this.observer.onComplete();
                }
            }
        }

        public boolean offer(T t, T t2) {
            throw new UnsupportedOperationException("Should not be called!");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class a<T, R> extends io.reactivex.m<R> {

        /* renamed from: a, reason: collision with root package name */
        final T f28310a;

        /* renamed from: b, reason: collision with root package name */
        final io.reactivex.c.f<? super T, ? extends p<? extends R>> f28311b;

        a(T t, io.reactivex.c.f<? super T, ? extends p<? extends R>> fVar) {
            this.f28310a = t;
            this.f28311b = fVar;
        }

        @Override // io.reactivex.m
        public void b(q<? super R> qVar) {
            try {
                p<? extends R> apply = this.f28311b.apply(this.f28310a);
                io.reactivex.d.a.b.a(apply, "The mapper returned a null ObservableSource");
                p<? extends R> pVar = apply;
                if (pVar instanceof Callable) {
                    try {
                        Object call = ((Callable) pVar).call();
                        if (call == null) {
                            EmptyDisposable.complete(qVar);
                            return;
                        }
                        ScalarDisposable scalarDisposable = new ScalarDisposable(qVar, call);
                        qVar.onSubscribe(scalarDisposable);
                        scalarDisposable.run();
                        return;
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        EmptyDisposable.error(th, qVar);
                        return;
                    }
                }
                pVar.a(qVar);
            } catch (Throwable th2) {
                EmptyDisposable.error(th2, qVar);
            }
        }
    }

    public static <T, R> boolean a(p<T> pVar, q<? super R> qVar, io.reactivex.c.f<? super T, ? extends p<? extends R>> fVar) {
        if (!(pVar instanceof Callable)) {
            return false;
        }
        try {
            defpackage.a aVar = (Object) ((Callable) pVar).call();
            if (aVar == null) {
                EmptyDisposable.complete(qVar);
                return true;
            }
            try {
                p<? extends R> apply = fVar.apply(aVar);
                io.reactivex.d.a.b.a(apply, "The mapper returned a null ObservableSource");
                p<? extends R> pVar2 = apply;
                if (pVar2 instanceof Callable) {
                    try {
                        Object call = ((Callable) pVar2).call();
                        if (call == null) {
                            EmptyDisposable.complete(qVar);
                            return true;
                        }
                        ScalarDisposable scalarDisposable = new ScalarDisposable(qVar, call);
                        qVar.onSubscribe(scalarDisposable);
                        scalarDisposable.run();
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        EmptyDisposable.error(th, qVar);
                        return true;
                    }
                } else {
                    pVar2.a(qVar);
                }
                return true;
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                EmptyDisposable.error(th2, qVar);
                return true;
            }
        } catch (Throwable th3) {
            io.reactivex.exceptions.a.b(th3);
            EmptyDisposable.error(th3, qVar);
            return true;
        }
    }

    public static <T, U> io.reactivex.m<U> a(T t, io.reactivex.c.f<? super T, ? extends p<? extends U>> fVar) {
        return io.reactivex.f.a.a(new a(t, fVar));
    }
}
