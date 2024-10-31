package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.p;
import io.reactivex.q;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class ObservableFlatMapCompletableCompletable<T> extends io.reactivex.a implements io.reactivex.d.b.d<T> {

    /* renamed from: a, reason: collision with root package name */
    final p<T> f28304a;

    /* renamed from: b, reason: collision with root package name */
    final io.reactivex.c.f<? super T, ? extends io.reactivex.c> f28305b;

    /* renamed from: c, reason: collision with root package name */
    final boolean f28306c;

    /* loaded from: classes3.dex */
    static final class FlatMapCompletableMainObserver<T> extends AtomicInteger implements io.reactivex.disposables.b, q<T> {
        private static final long serialVersionUID = 8443155186132538303L;
        final boolean delayErrors;
        volatile boolean disposed;
        final io.reactivex.b downstream;
        final io.reactivex.c.f<? super T, ? extends io.reactivex.c> mapper;
        io.reactivex.disposables.b upstream;
        final AtomicThrowable errors = new AtomicThrowable();
        final io.reactivex.disposables.a set = new io.reactivex.disposables.a();

        /* loaded from: classes3.dex */
        final class InnerObserver extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.b, io.reactivex.disposables.b {
            private static final long serialVersionUID = 8606673141535671828L;

            InnerObserver() {
            }

            @Override // io.reactivex.disposables.b
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.disposables.b
            public boolean isDisposed() {
                return DisposableHelper.isDisposed(get());
            }

            @Override // io.reactivex.b
            public void onComplete() {
                FlatMapCompletableMainObserver.this.innerComplete(this);
            }

            @Override // io.reactivex.b
            public void onError(Throwable th) {
                FlatMapCompletableMainObserver.this.innerError(this, th);
            }

            @Override // io.reactivex.b
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }
        }

        FlatMapCompletableMainObserver(io.reactivex.b bVar, io.reactivex.c.f<? super T, ? extends io.reactivex.c> fVar, boolean z) {
            this.downstream = bVar;
            this.mapper = fVar;
            this.delayErrors = z;
            lazySet(1);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.disposed = true;
            this.upstream.dispose();
            this.set.dispose();
        }

        void innerComplete(FlatMapCompletableMainObserver<T>.InnerObserver innerObserver) {
            this.set.c(innerObserver);
            onComplete();
        }

        void innerError(FlatMapCompletableMainObserver<T>.InnerObserver innerObserver, Throwable th) {
            this.set.c(innerObserver);
            onError(th);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.q
        public void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable terminate = this.errors.terminate();
                if (terminate != null) {
                    this.downstream.onError(terminate);
                } else {
                    this.downstream.onComplete();
                }
            }
        }

        @Override // io.reactivex.q
        public void onError(Throwable th) {
            if (this.errors.addThrowable(th)) {
                if (this.delayErrors) {
                    if (decrementAndGet() == 0) {
                        this.downstream.onError(this.errors.terminate());
                        return;
                    }
                    return;
                }
                dispose();
                if (getAndSet(0) > 0) {
                    this.downstream.onError(this.errors.terminate());
                    return;
                }
                return;
            }
            io.reactivex.f.a.b(th);
        }

        @Override // io.reactivex.q
        public void onNext(T t) {
            try {
                io.reactivex.c apply = this.mapper.apply(t);
                io.reactivex.d.a.b.a(apply, "The mapper returned a null CompletableSource");
                io.reactivex.c cVar = apply;
                getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (this.disposed || !this.set.b(innerObserver)) {
                    return;
                }
                cVar.a(innerObserver);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.upstream.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.q
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableFlatMapCompletableCompletable(p<T> pVar, io.reactivex.c.f<? super T, ? extends io.reactivex.c> fVar, boolean z) {
        this.f28304a = pVar;
        this.f28305b = fVar;
        this.f28306c = z;
    }

    @Override // io.reactivex.a
    protected void b(io.reactivex.b bVar) {
        this.f28304a.a(new FlatMapCompletableMainObserver(bVar, this.f28305b, this.f28306c));
    }
}
